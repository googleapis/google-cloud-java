/*
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
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
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@javax.annotation.Generated("by GAPIC")
public class GrafeasClientTest {
  private static MockGrafeas mockGrafeas;
  private static MockServiceHelper serviceHelper;
  private GrafeasClient client;
  private LocalChannelProvider channelProvider;

  @BeforeClass
  public static void startStaticServer() {
    mockGrafeas = new MockGrafeas();
    serviceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockGrafeas));
    serviceHelper.start();
  }

  @AfterClass
  public static void stopServer() {
    serviceHelper.stop();
  }

  @Before
  public void setUp() throws IOException {
    serviceHelper.reset();
    channelProvider = serviceHelper.createChannelProvider();
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
  @SuppressWarnings("all")
  public void getOccurrenceTest() {
    OccurrenceName name2 = OccurrenceName.of("[PROJECT]", "[OCCURRENCE]");
    String resourceUri = "resourceUri-384040517";
    String noteName = "noteName1780787896";
    String remediation = "remediation779381797";
    Occurrence expectedResponse =
        Occurrence.newBuilder()
            .setName(name2.toString())
            .setResourceUri(resourceUri)
            .setNoteName(noteName)
            .setRemediation(remediation)
            .build();
    mockGrafeas.addResponse(expectedResponse);

    OccurrenceName name = OccurrenceName.of("[PROJECT]", "[OCCURRENCE]");

    Occurrence actualResponse = client.getOccurrence(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockGrafeas.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetOccurrenceRequest actualRequest = (GetOccurrenceRequest) actualRequests.get(0);

    Assert.assertEquals(name, OccurrenceName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void getOccurrenceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockGrafeas.addException(exception);

    try {
      OccurrenceName name = OccurrenceName.of("[PROJECT]", "[OCCURRENCE]");

      client.getOccurrence(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void listOccurrencesTest() {
    String nextPageToken = "";
    Occurrence occurrencesElement = Occurrence.newBuilder().build();
    List<Occurrence> occurrences = Arrays.asList(occurrencesElement);
    ListOccurrencesResponse expectedResponse =
        ListOccurrencesResponse.newBuilder()
            .setNextPageToken(nextPageToken)
            .addAllOccurrences(occurrences)
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
    ListOccurrencesRequest actualRequest = (ListOccurrencesRequest) actualRequests.get(0);

    Assert.assertEquals(parent, ProjectName.parse(actualRequest.getParent()));
    Assert.assertEquals(filter, actualRequest.getFilter());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void listOccurrencesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockGrafeas.addException(exception);

    try {
      ProjectName parent = ProjectName.of("[PROJECT]");
      String filter = "filter-1274492040";

      client.listOccurrences(parent, filter);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void deleteOccurrenceTest() {
    Empty expectedResponse = Empty.newBuilder().build();
    mockGrafeas.addResponse(expectedResponse);

    OccurrenceName name = OccurrenceName.of("[PROJECT]", "[OCCURRENCE]");

    client.deleteOccurrence(name);

    List<AbstractMessage> actualRequests = mockGrafeas.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteOccurrenceRequest actualRequest = (DeleteOccurrenceRequest) actualRequests.get(0);

    Assert.assertEquals(name, OccurrenceName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void deleteOccurrenceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockGrafeas.addException(exception);

    try {
      OccurrenceName name = OccurrenceName.of("[PROJECT]", "[OCCURRENCE]");

      client.deleteOccurrence(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void createOccurrenceTest() {
    OccurrenceName name = OccurrenceName.of("[PROJECT]", "[OCCURRENCE]");
    String resourceUri = "resourceUri-384040517";
    String noteName = "noteName1780787896";
    String remediation = "remediation779381797";
    Occurrence expectedResponse =
        Occurrence.newBuilder()
            .setName(name.toString())
            .setResourceUri(resourceUri)
            .setNoteName(noteName)
            .setRemediation(remediation)
            .build();
    mockGrafeas.addResponse(expectedResponse);

    ProjectName parent = ProjectName.of("[PROJECT]");
    Occurrence occurrence = Occurrence.newBuilder().build();

    Occurrence actualResponse = client.createOccurrence(parent, occurrence);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockGrafeas.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateOccurrenceRequest actualRequest = (CreateOccurrenceRequest) actualRequests.get(0);

    Assert.assertEquals(parent, ProjectName.parse(actualRequest.getParent()));
    Assert.assertEquals(occurrence, actualRequest.getOccurrence());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void createOccurrenceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockGrafeas.addException(exception);

    try {
      ProjectName parent = ProjectName.of("[PROJECT]");
      Occurrence occurrence = Occurrence.newBuilder().build();

      client.createOccurrence(parent, occurrence);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void batchCreateOccurrencesTest() {
    BatchCreateOccurrencesResponse expectedResponse =
        BatchCreateOccurrencesResponse.newBuilder().build();
    mockGrafeas.addResponse(expectedResponse);

    ProjectName parent = ProjectName.of("[PROJECT]");
    List<Occurrence> occurrences = new ArrayList<>();

    BatchCreateOccurrencesResponse actualResponse =
        client.batchCreateOccurrences(parent, occurrences);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockGrafeas.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    BatchCreateOccurrencesRequest actualRequest =
        (BatchCreateOccurrencesRequest) actualRequests.get(0);

    Assert.assertEquals(parent, ProjectName.parse(actualRequest.getParent()));
    Assert.assertEquals(occurrences, actualRequest.getOccurrencesList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void batchCreateOccurrencesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockGrafeas.addException(exception);

    try {
      ProjectName parent = ProjectName.of("[PROJECT]");
      List<Occurrence> occurrences = new ArrayList<>();

      client.batchCreateOccurrences(parent, occurrences);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void updateOccurrenceTest() {
    OccurrenceName name2 = OccurrenceName.of("[PROJECT]", "[OCCURRENCE]");
    String resourceUri = "resourceUri-384040517";
    String noteName = "noteName1780787896";
    String remediation = "remediation779381797";
    Occurrence expectedResponse =
        Occurrence.newBuilder()
            .setName(name2.toString())
            .setResourceUri(resourceUri)
            .setNoteName(noteName)
            .setRemediation(remediation)
            .build();
    mockGrafeas.addResponse(expectedResponse);

    OccurrenceName name = OccurrenceName.of("[PROJECT]", "[OCCURRENCE]");
    Occurrence occurrence = Occurrence.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Occurrence actualResponse = client.updateOccurrence(name, occurrence, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockGrafeas.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateOccurrenceRequest actualRequest = (UpdateOccurrenceRequest) actualRequests.get(0);

    Assert.assertEquals(name, OccurrenceName.parse(actualRequest.getName()));
    Assert.assertEquals(occurrence, actualRequest.getOccurrence());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void updateOccurrenceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockGrafeas.addException(exception);

    try {
      OccurrenceName name = OccurrenceName.of("[PROJECT]", "[OCCURRENCE]");
      Occurrence occurrence = Occurrence.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();

      client.updateOccurrence(name, occurrence, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getOccurrenceNoteTest() {
    NoteName name2 = NoteName.of("[PROJECT]", "[NOTE]");
    String shortDescription = "shortDescription-235369287";
    String longDescription = "longDescription-1747792199";
    Note expectedResponse =
        Note.newBuilder()
            .setName(name2.toString())
            .setShortDescription(shortDescription)
            .setLongDescription(longDescription)
            .build();
    mockGrafeas.addResponse(expectedResponse);

    OccurrenceName name = OccurrenceName.of("[PROJECT]", "[OCCURRENCE]");

    Note actualResponse = client.getOccurrenceNote(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockGrafeas.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetOccurrenceNoteRequest actualRequest = (GetOccurrenceNoteRequest) actualRequests.get(0);

    Assert.assertEquals(name, OccurrenceName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void getOccurrenceNoteExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockGrafeas.addException(exception);

    try {
      OccurrenceName name = OccurrenceName.of("[PROJECT]", "[OCCURRENCE]");

      client.getOccurrenceNote(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getNoteTest() {
    NoteName name2 = NoteName.of("[PROJECT]", "[NOTE]");
    String shortDescription = "shortDescription-235369287";
    String longDescription = "longDescription-1747792199";
    Note expectedResponse =
        Note.newBuilder()
            .setName(name2.toString())
            .setShortDescription(shortDescription)
            .setLongDescription(longDescription)
            .build();
    mockGrafeas.addResponse(expectedResponse);

    NoteName name = NoteName.of("[PROJECT]", "[NOTE]");

    Note actualResponse = client.getNote(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockGrafeas.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetNoteRequest actualRequest = (GetNoteRequest) actualRequests.get(0);

    Assert.assertEquals(name, NoteName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void getNoteExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockGrafeas.addException(exception);

    try {
      NoteName name = NoteName.of("[PROJECT]", "[NOTE]");

      client.getNote(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void listNotesTest() {
    String nextPageToken = "";
    Note notesElement = Note.newBuilder().build();
    List<Note> notes = Arrays.asList(notesElement);
    ListNotesResponse expectedResponse =
        ListNotesResponse.newBuilder().setNextPageToken(nextPageToken).addAllNotes(notes).build();
    mockGrafeas.addResponse(expectedResponse);

    ProjectName parent = ProjectName.of("[PROJECT]");
    String filter = "filter-1274492040";

    ListNotesPagedResponse pagedListResponse = client.listNotes(parent, filter);

    List<Note> resources = Lists.newArrayList(pagedListResponse.iterateAll());
    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getNotesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockGrafeas.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListNotesRequest actualRequest = (ListNotesRequest) actualRequests.get(0);

    Assert.assertEquals(parent, ProjectName.parse(actualRequest.getParent()));
    Assert.assertEquals(filter, actualRequest.getFilter());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void listNotesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockGrafeas.addException(exception);

    try {
      ProjectName parent = ProjectName.of("[PROJECT]");
      String filter = "filter-1274492040";

      client.listNotes(parent, filter);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void deleteNoteTest() {
    Empty expectedResponse = Empty.newBuilder().build();
    mockGrafeas.addResponse(expectedResponse);

    NoteName name = NoteName.of("[PROJECT]", "[NOTE]");

    client.deleteNote(name);

    List<AbstractMessage> actualRequests = mockGrafeas.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteNoteRequest actualRequest = (DeleteNoteRequest) actualRequests.get(0);

    Assert.assertEquals(name, NoteName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void deleteNoteExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockGrafeas.addException(exception);

    try {
      NoteName name = NoteName.of("[PROJECT]", "[NOTE]");

      client.deleteNote(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void createNoteTest() {
    NoteName name = NoteName.of("[PROJECT]", "[NOTE]");
    String shortDescription = "shortDescription-235369287";
    String longDescription = "longDescription-1747792199";
    Note expectedResponse =
        Note.newBuilder()
            .setName(name.toString())
            .setShortDescription(shortDescription)
            .setLongDescription(longDescription)
            .build();
    mockGrafeas.addResponse(expectedResponse);

    ProjectName parent = ProjectName.of("[PROJECT]");
    String noteId = "noteId2129224840";
    Note note = Note.newBuilder().build();

    Note actualResponse = client.createNote(parent, noteId, note);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockGrafeas.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateNoteRequest actualRequest = (CreateNoteRequest) actualRequests.get(0);

    Assert.assertEquals(parent, ProjectName.parse(actualRequest.getParent()));
    Assert.assertEquals(noteId, actualRequest.getNoteId());
    Assert.assertEquals(note, actualRequest.getNote());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void createNoteExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockGrafeas.addException(exception);

    try {
      ProjectName parent = ProjectName.of("[PROJECT]");
      String noteId = "noteId2129224840";
      Note note = Note.newBuilder().build();

      client.createNote(parent, noteId, note);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void batchCreateNotesTest() {
    BatchCreateNotesResponse expectedResponse = BatchCreateNotesResponse.newBuilder().build();
    mockGrafeas.addResponse(expectedResponse);

    ProjectName parent = ProjectName.of("[PROJECT]");
    Map<String, Note> notes = new HashMap<>();

    BatchCreateNotesResponse actualResponse = client.batchCreateNotes(parent, notes);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockGrafeas.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    BatchCreateNotesRequest actualRequest = (BatchCreateNotesRequest) actualRequests.get(0);

    Assert.assertEquals(parent, ProjectName.parse(actualRequest.getParent()));
    Assert.assertEquals(notes, actualRequest.getNotesMap());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void batchCreateNotesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockGrafeas.addException(exception);

    try {
      ProjectName parent = ProjectName.of("[PROJECT]");
      Map<String, Note> notes = new HashMap<>();

      client.batchCreateNotes(parent, notes);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void updateNoteTest() {
    NoteName name2 = NoteName.of("[PROJECT]", "[NOTE]");
    String shortDescription = "shortDescription-235369287";
    String longDescription = "longDescription-1747792199";
    Note expectedResponse =
        Note.newBuilder()
            .setName(name2.toString())
            .setShortDescription(shortDescription)
            .setLongDescription(longDescription)
            .build();
    mockGrafeas.addResponse(expectedResponse);

    NoteName name = NoteName.of("[PROJECT]", "[NOTE]");
    Note note = Note.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Note actualResponse = client.updateNote(name, note, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockGrafeas.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateNoteRequest actualRequest = (UpdateNoteRequest) actualRequests.get(0);

    Assert.assertEquals(name, NoteName.parse(actualRequest.getName()));
    Assert.assertEquals(note, actualRequest.getNote());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void updateNoteExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockGrafeas.addException(exception);

    try {
      NoteName name = NoteName.of("[PROJECT]", "[NOTE]");
      Note note = Note.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();

      client.updateNote(name, note, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void listNoteOccurrencesTest() {
    String nextPageToken = "";
    Occurrence occurrencesElement = Occurrence.newBuilder().build();
    List<Occurrence> occurrences = Arrays.asList(occurrencesElement);
    ListNoteOccurrencesResponse expectedResponse =
        ListNoteOccurrencesResponse.newBuilder()
            .setNextPageToken(nextPageToken)
            .addAllOccurrences(occurrences)
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
    ListNoteOccurrencesRequest actualRequest = (ListNoteOccurrencesRequest) actualRequests.get(0);

    Assert.assertEquals(name, NoteName.parse(actualRequest.getName()));
    Assert.assertEquals(filter, actualRequest.getFilter());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void listNoteOccurrencesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockGrafeas.addException(exception);

    try {
      NoteName name = NoteName.of("[PROJECT]", "[NOTE]");
      String filter = "filter-1274492040";

      client.listNoteOccurrences(name, filter);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }
}
