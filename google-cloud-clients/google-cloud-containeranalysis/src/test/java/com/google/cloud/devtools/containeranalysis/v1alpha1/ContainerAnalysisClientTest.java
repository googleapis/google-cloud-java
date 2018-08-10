/*
 * Copyright 2018 Google LLC
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
package com.google.cloud.devtools.containeranalysis.v1alpha1;

import static com.google.cloud.devtools.containeranalysis.v1alpha1.ContainerAnalysisClient.ListNoteOccurrencesPagedResponse;
import static com.google.cloud.devtools.containeranalysis.v1alpha1.ContainerAnalysisClient.ListNotesPagedResponse;
import static com.google.cloud.devtools.containeranalysis.v1alpha1.ContainerAnalysisClient.ListOccurrencesPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.common.collect.Lists;
import com.google.containeranalysis.v1alpha1.CreateNoteRequest;
import com.google.containeranalysis.v1alpha1.CreateOccurrenceRequest;
import com.google.containeranalysis.v1alpha1.DeleteNoteRequest;
import com.google.containeranalysis.v1alpha1.DeleteOccurrenceRequest;
import com.google.containeranalysis.v1alpha1.GetNoteRequest;
import com.google.containeranalysis.v1alpha1.GetOccurrenceNoteRequest;
import com.google.containeranalysis.v1alpha1.GetOccurrenceRequest;
import com.google.containeranalysis.v1alpha1.GetVulnzOccurrencesSummaryRequest;
import com.google.containeranalysis.v1alpha1.GetVulnzOccurrencesSummaryResponse;
import com.google.containeranalysis.v1alpha1.ListNoteOccurrencesRequest;
import com.google.containeranalysis.v1alpha1.ListNoteOccurrencesResponse;
import com.google.containeranalysis.v1alpha1.ListNotesRequest;
import com.google.containeranalysis.v1alpha1.ListNotesResponse;
import com.google.containeranalysis.v1alpha1.ListOccurrencesRequest;
import com.google.containeranalysis.v1alpha1.ListOccurrencesResponse;
import com.google.containeranalysis.v1alpha1.Note;
import com.google.containeranalysis.v1alpha1.Occurrence;
import com.google.containeranalysis.v1alpha1.UpdateNoteRequest;
import com.google.containeranalysis.v1alpha1.UpdateOccurrenceRequest;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.protobuf.ByteString;
import com.google.protobuf.Empty;
import com.google.protobuf.GeneratedMessageV3;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@javax.annotation.Generated("by GAPIC")
public class ContainerAnalysisClientTest {
  private static MockContainerAnalysis mockContainerAnalysis;
  private static MockServiceHelper serviceHelper;
  private ContainerAnalysisClient client;
  private LocalChannelProvider channelProvider;

  @BeforeClass
  public static void startStaticServer() {
    mockContainerAnalysis = new MockContainerAnalysis();
    serviceHelper =
        new MockServiceHelper(
            "in-process-1", Arrays.<MockGrpcService>asList(mockContainerAnalysis));
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
    ContainerAnalysisSettings settings =
        ContainerAnalysisSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = ContainerAnalysisClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  @SuppressWarnings("all")
  public void getOccurrenceTest() {
    String name2 = "name2-1052831874";
    String resourceUrl = "resourceUrl-384040514";
    String noteName = "noteName1780787896";
    String remediation = "remediation779381797";
    Occurrence expectedResponse =
        Occurrence.newBuilder()
            .setName(name2)
            .setResourceUrl(resourceUrl)
            .setNoteName(noteName)
            .setRemediation(remediation)
            .build();
    mockContainerAnalysis.addResponse(expectedResponse);

    String formattedName =
        ContainerAnalysisClient.formatOccurrenceName("[PROJECT]", "[OCCURRENCE]");

    Occurrence actualResponse = client.getOccurrence(formattedName);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockContainerAnalysis.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetOccurrenceRequest actualRequest = (GetOccurrenceRequest) actualRequests.get(0);

    Assert.assertEquals(formattedName, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void getOccurrenceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockContainerAnalysis.addException(exception);

    try {
      String formattedName =
          ContainerAnalysisClient.formatOccurrenceName("[PROJECT]", "[OCCURRENCE]");

      client.getOccurrence(formattedName);
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
    mockContainerAnalysis.addResponse(expectedResponse);

    String formattedParent = ContainerAnalysisClient.formatProjectName("[PROJECT]");

    ListOccurrencesPagedResponse pagedListResponse = client.listOccurrences(formattedParent);

    List<Occurrence> resources = Lists.newArrayList(pagedListResponse.iterateAll());
    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getOccurrencesList().get(0), resources.get(0));

    List<GeneratedMessageV3> actualRequests = mockContainerAnalysis.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListOccurrencesRequest actualRequest = (ListOccurrencesRequest) actualRequests.get(0);

    Assert.assertEquals(formattedParent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void listOccurrencesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockContainerAnalysis.addException(exception);

    try {
      String formattedParent = ContainerAnalysisClient.formatProjectName("[PROJECT]");

      client.listOccurrences(formattedParent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void deleteOccurrenceTest() {
    Empty expectedResponse = Empty.newBuilder().build();
    mockContainerAnalysis.addResponse(expectedResponse);

    String formattedName =
        ContainerAnalysisClient.formatOccurrenceName("[PROJECT]", "[OCCURRENCE]");

    client.deleteOccurrence(formattedName);

    List<GeneratedMessageV3> actualRequests = mockContainerAnalysis.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteOccurrenceRequest actualRequest = (DeleteOccurrenceRequest) actualRequests.get(0);

    Assert.assertEquals(formattedName, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void deleteOccurrenceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockContainerAnalysis.addException(exception);

    try {
      String formattedName =
          ContainerAnalysisClient.formatOccurrenceName("[PROJECT]", "[OCCURRENCE]");

      client.deleteOccurrence(formattedName);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void createOccurrenceTest() {
    String name = "name3373707";
    String resourceUrl = "resourceUrl-384040514";
    String noteName = "noteName1780787896";
    String remediation = "remediation779381797";
    Occurrence expectedResponse =
        Occurrence.newBuilder()
            .setName(name)
            .setResourceUrl(resourceUrl)
            .setNoteName(noteName)
            .setRemediation(remediation)
            .build();
    mockContainerAnalysis.addResponse(expectedResponse);

    String formattedParent = ContainerAnalysisClient.formatProjectName("[PROJECT]");
    Occurrence occurrence = Occurrence.newBuilder().build();

    Occurrence actualResponse = client.createOccurrence(formattedParent, occurrence);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockContainerAnalysis.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateOccurrenceRequest actualRequest = (CreateOccurrenceRequest) actualRequests.get(0);

    Assert.assertEquals(formattedParent, actualRequest.getParent());
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
    mockContainerAnalysis.addException(exception);

    try {
      String formattedParent = ContainerAnalysisClient.formatProjectName("[PROJECT]");
      Occurrence occurrence = Occurrence.newBuilder().build();

      client.createOccurrence(formattedParent, occurrence);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void updateOccurrenceTest() {
    String name2 = "name2-1052831874";
    String resourceUrl = "resourceUrl-384040514";
    String noteName = "noteName1780787896";
    String remediation = "remediation779381797";
    Occurrence expectedResponse =
        Occurrence.newBuilder()
            .setName(name2)
            .setResourceUrl(resourceUrl)
            .setNoteName(noteName)
            .setRemediation(remediation)
            .build();
    mockContainerAnalysis.addResponse(expectedResponse);

    String formattedName =
        ContainerAnalysisClient.formatOccurrenceName("[PROJECT]", "[OCCURRENCE]");
    Occurrence occurrence = Occurrence.newBuilder().build();

    Occurrence actualResponse = client.updateOccurrence(formattedName, occurrence);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockContainerAnalysis.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateOccurrenceRequest actualRequest = (UpdateOccurrenceRequest) actualRequests.get(0);

    Assert.assertEquals(formattedName, actualRequest.getName());
    Assert.assertEquals(occurrence, actualRequest.getOccurrence());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void updateOccurrenceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockContainerAnalysis.addException(exception);

    try {
      String formattedName =
          ContainerAnalysisClient.formatOccurrenceName("[PROJECT]", "[OCCURRENCE]");
      Occurrence occurrence = Occurrence.newBuilder().build();

      client.updateOccurrence(formattedName, occurrence);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getOccurrenceNoteTest() {
    String name2 = "name2-1052831874";
    String shortDescription = "shortDescription-235369287";
    String longDescription = "longDescription-1747792199";
    Note expectedResponse =
        Note.newBuilder()
            .setName(name2)
            .setShortDescription(shortDescription)
            .setLongDescription(longDescription)
            .build();
    mockContainerAnalysis.addResponse(expectedResponse);

    String formattedName =
        ContainerAnalysisClient.formatOccurrenceName("[PROJECT]", "[OCCURRENCE]");

    Note actualResponse = client.getOccurrenceNote(formattedName);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockContainerAnalysis.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetOccurrenceNoteRequest actualRequest = (GetOccurrenceNoteRequest) actualRequests.get(0);

    Assert.assertEquals(formattedName, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void getOccurrenceNoteExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockContainerAnalysis.addException(exception);

    try {
      String formattedName =
          ContainerAnalysisClient.formatOccurrenceName("[PROJECT]", "[OCCURRENCE]");

      client.getOccurrenceNote(formattedName);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getNoteTest() {
    String name2 = "name2-1052831874";
    String shortDescription = "shortDescription-235369287";
    String longDescription = "longDescription-1747792199";
    Note expectedResponse =
        Note.newBuilder()
            .setName(name2)
            .setShortDescription(shortDescription)
            .setLongDescription(longDescription)
            .build();
    mockContainerAnalysis.addResponse(expectedResponse);

    String formattedName = ContainerAnalysisClient.formatNoteName("[PROJECT]", "[NOTE]");

    Note actualResponse = client.getNote(formattedName);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockContainerAnalysis.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetNoteRequest actualRequest = (GetNoteRequest) actualRequests.get(0);

    Assert.assertEquals(formattedName, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void getNoteExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockContainerAnalysis.addException(exception);

    try {
      String formattedName = ContainerAnalysisClient.formatNoteName("[PROJECT]", "[NOTE]");

      client.getNote(formattedName);
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
    mockContainerAnalysis.addResponse(expectedResponse);

    String formattedParent = ContainerAnalysisClient.formatProjectName("[PROJECT]");

    ListNotesPagedResponse pagedListResponse = client.listNotes(formattedParent);

    List<Note> resources = Lists.newArrayList(pagedListResponse.iterateAll());
    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getNotesList().get(0), resources.get(0));

    List<GeneratedMessageV3> actualRequests = mockContainerAnalysis.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListNotesRequest actualRequest = (ListNotesRequest) actualRequests.get(0);

    Assert.assertEquals(formattedParent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void listNotesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockContainerAnalysis.addException(exception);

    try {
      String formattedParent = ContainerAnalysisClient.formatProjectName("[PROJECT]");

      client.listNotes(formattedParent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void deleteNoteTest() {
    Empty expectedResponse = Empty.newBuilder().build();
    mockContainerAnalysis.addResponse(expectedResponse);

    String formattedName = ContainerAnalysisClient.formatNoteName("[PROJECT]", "[NOTE]");

    client.deleteNote(formattedName);

    List<GeneratedMessageV3> actualRequests = mockContainerAnalysis.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteNoteRequest actualRequest = (DeleteNoteRequest) actualRequests.get(0);

    Assert.assertEquals(formattedName, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void deleteNoteExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockContainerAnalysis.addException(exception);

    try {
      String formattedName = ContainerAnalysisClient.formatNoteName("[PROJECT]", "[NOTE]");

      client.deleteNote(formattedName);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void createNoteTest() {
    String name = "name3373707";
    String shortDescription = "shortDescription-235369287";
    String longDescription = "longDescription-1747792199";
    Note expectedResponse =
        Note.newBuilder()
            .setName(name)
            .setShortDescription(shortDescription)
            .setLongDescription(longDescription)
            .build();
    mockContainerAnalysis.addResponse(expectedResponse);

    String formattedParent = ContainerAnalysisClient.formatProjectName("[PROJECT]");
    String noteId = "noteId2129224840";
    Note note = Note.newBuilder().build();

    Note actualResponse = client.createNote(formattedParent, noteId, note);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockContainerAnalysis.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateNoteRequest actualRequest = (CreateNoteRequest) actualRequests.get(0);

    Assert.assertEquals(formattedParent, actualRequest.getParent());
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
    mockContainerAnalysis.addException(exception);

    try {
      String formattedParent = ContainerAnalysisClient.formatProjectName("[PROJECT]");
      String noteId = "noteId2129224840";
      Note note = Note.newBuilder().build();

      client.createNote(formattedParent, noteId, note);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void updateNoteTest() {
    String name2 = "name2-1052831874";
    String shortDescription = "shortDescription-235369287";
    String longDescription = "longDescription-1747792199";
    Note expectedResponse =
        Note.newBuilder()
            .setName(name2)
            .setShortDescription(shortDescription)
            .setLongDescription(longDescription)
            .build();
    mockContainerAnalysis.addResponse(expectedResponse);

    String formattedName = ContainerAnalysisClient.formatNoteName("[PROJECT]", "[NOTE]");
    Note note = Note.newBuilder().build();

    Note actualResponse = client.updateNote(formattedName, note);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockContainerAnalysis.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateNoteRequest actualRequest = (UpdateNoteRequest) actualRequests.get(0);

    Assert.assertEquals(formattedName, actualRequest.getName());
    Assert.assertEquals(note, actualRequest.getNote());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void updateNoteExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockContainerAnalysis.addException(exception);

    try {
      String formattedName = ContainerAnalysisClient.formatNoteName("[PROJECT]", "[NOTE]");
      Note note = Note.newBuilder().build();

      client.updateNote(formattedName, note);
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
    mockContainerAnalysis.addResponse(expectedResponse);

    String formattedName = ContainerAnalysisClient.formatNoteName("[PROJECT]", "[NOTE]");

    ListNoteOccurrencesPagedResponse pagedListResponse = client.listNoteOccurrences(formattedName);

    List<Occurrence> resources = Lists.newArrayList(pagedListResponse.iterateAll());
    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getOccurrencesList().get(0), resources.get(0));

    List<GeneratedMessageV3> actualRequests = mockContainerAnalysis.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListNoteOccurrencesRequest actualRequest = (ListNoteOccurrencesRequest) actualRequests.get(0);

    Assert.assertEquals(formattedName, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void listNoteOccurrencesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockContainerAnalysis.addException(exception);

    try {
      String formattedName = ContainerAnalysisClient.formatNoteName("[PROJECT]", "[NOTE]");

      client.listNoteOccurrences(formattedName);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getVulnzOccurrencesSummaryTest() {
    GetVulnzOccurrencesSummaryResponse expectedResponse =
        GetVulnzOccurrencesSummaryResponse.newBuilder().build();
    mockContainerAnalysis.addResponse(expectedResponse);

    String formattedParent = ContainerAnalysisClient.formatProjectName("[PROJECT]");

    GetVulnzOccurrencesSummaryResponse actualResponse =
        client.getVulnzOccurrencesSummary(formattedParent);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockContainerAnalysis.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetVulnzOccurrencesSummaryRequest actualRequest =
        (GetVulnzOccurrencesSummaryRequest) actualRequests.get(0);

    Assert.assertEquals(formattedParent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void getVulnzOccurrencesSummaryExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockContainerAnalysis.addException(exception);

    try {
      String formattedParent = ContainerAnalysisClient.formatProjectName("[PROJECT]");

      client.getVulnzOccurrencesSummary(formattedParent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void setIamPolicyTest() {
    int version = 351608024;
    ByteString etag = ByteString.copyFromUtf8("21");
    Policy expectedResponse = Policy.newBuilder().setVersion(version).setEtag(etag).build();
    mockContainerAnalysis.addResponse(expectedResponse);

    String formattedResource = ContainerAnalysisClient.formatNoteName("[PROJECT]", "[NOTE]");
    Policy policy = Policy.newBuilder().build();

    Policy actualResponse = client.setIamPolicy(formattedResource, policy);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockContainerAnalysis.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SetIamPolicyRequest actualRequest = (SetIamPolicyRequest) actualRequests.get(0);

    Assert.assertEquals(formattedResource, actualRequest.getResource());
    Assert.assertEquals(policy, actualRequest.getPolicy());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void setIamPolicyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockContainerAnalysis.addException(exception);

    try {
      String formattedResource = ContainerAnalysisClient.formatNoteName("[PROJECT]", "[NOTE]");
      Policy policy = Policy.newBuilder().build();

      client.setIamPolicy(formattedResource, policy);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getIamPolicyTest() {
    int version = 351608024;
    ByteString etag = ByteString.copyFromUtf8("21");
    Policy expectedResponse = Policy.newBuilder().setVersion(version).setEtag(etag).build();
    mockContainerAnalysis.addResponse(expectedResponse);

    String formattedResource = ContainerAnalysisClient.formatNoteName("[PROJECT]", "[NOTE]");

    Policy actualResponse = client.getIamPolicy(formattedResource);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockContainerAnalysis.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetIamPolicyRequest actualRequest = (GetIamPolicyRequest) actualRequests.get(0);

    Assert.assertEquals(formattedResource, actualRequest.getResource());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void getIamPolicyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockContainerAnalysis.addException(exception);

    try {
      String formattedResource = ContainerAnalysisClient.formatNoteName("[PROJECT]", "[NOTE]");

      client.getIamPolicy(formattedResource);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void testIamPermissionsTest() {
    TestIamPermissionsResponse expectedResponse = TestIamPermissionsResponse.newBuilder().build();
    mockContainerAnalysis.addResponse(expectedResponse);

    String formattedResource = ContainerAnalysisClient.formatNoteName("[PROJECT]", "[NOTE]");
    List<String> permissions = new ArrayList<>();

    TestIamPermissionsResponse actualResponse =
        client.testIamPermissions(formattedResource, permissions);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockContainerAnalysis.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    TestIamPermissionsRequest actualRequest = (TestIamPermissionsRequest) actualRequests.get(0);

    Assert.assertEquals(formattedResource, actualRequest.getResource());
    Assert.assertEquals(permissions, actualRequest.getPermissionsList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void testIamPermissionsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockContainerAnalysis.addException(exception);

    try {
      String formattedResource = ContainerAnalysisClient.formatNoteName("[PROJECT]", "[NOTE]");
      List<String> permissions = new ArrayList<>();

      client.testIamPermissions(formattedResource, permissions);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }
}
