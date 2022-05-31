/*
 * Copyright 2020 Google LLC
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
package com.google.cloud.devtools.containeranalysis.v1beta1;

import com.google.api.core.BetaApi;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Empty;
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
import io.grafeas.v1beta1.GrafeasV1Beta1Grpc.GrafeasV1Beta1ImplBase;
import io.grafeas.v1beta1.ListNoteOccurrencesRequest;
import io.grafeas.v1beta1.ListNoteOccurrencesResponse;
import io.grafeas.v1beta1.ListNotesRequest;
import io.grafeas.v1beta1.ListNotesResponse;
import io.grafeas.v1beta1.ListOccurrencesRequest;
import io.grafeas.v1beta1.ListOccurrencesResponse;
import io.grafeas.v1beta1.Note;
import io.grafeas.v1beta1.Occurrence;
import io.grafeas.v1beta1.UpdateNoteRequest;
import io.grafeas.v1beta1.UpdateOccurrenceRequest;
import io.grafeas.v1beta1.VulnerabilityOccurrencesSummary;
import io.grpc.stub.StreamObserver;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

@javax.annotation.Generated("by GAPIC")
@BetaApi
public class MockGrafeasV1Beta1Impl extends GrafeasV1Beta1ImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockGrafeasV1Beta1Impl() {
    requests = new ArrayList<>();
    responses = new LinkedList<>();
  }

  public List<AbstractMessage> getRequests() {
    return requests;
  }

  public void addResponse(AbstractMessage response) {
    responses.add(response);
  }

  public void setResponses(List<AbstractMessage> responses) {
    this.responses = new LinkedList<Object>(responses);
  }

  public void addException(Exception exception) {
    responses.add(exception);
  }

  public void reset() {
    requests = new ArrayList<>();
    responses = new LinkedList<>();
  }

  @Override
  public void getOccurrence(
      GetOccurrenceRequest request, StreamObserver<Occurrence> responseObserver) {
    Object response = responses.remove();
    if (response instanceof Occurrence) {
      requests.add(request);
      responseObserver.onNext((Occurrence) response);
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError((Exception) response);
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void listOccurrences(
      ListOccurrencesRequest request, StreamObserver<ListOccurrencesResponse> responseObserver) {
    Object response = responses.remove();
    if (response instanceof ListOccurrencesResponse) {
      requests.add(request);
      responseObserver.onNext((ListOccurrencesResponse) response);
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError((Exception) response);
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void deleteOccurrence(
      DeleteOccurrenceRequest request, StreamObserver<Empty> responseObserver) {
    Object response = responses.remove();
    if (response instanceof Empty) {
      requests.add(request);
      responseObserver.onNext((Empty) response);
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError((Exception) response);
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void createOccurrence(
      CreateOccurrenceRequest request, StreamObserver<Occurrence> responseObserver) {
    Object response = responses.remove();
    if (response instanceof Occurrence) {
      requests.add(request);
      responseObserver.onNext((Occurrence) response);
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError((Exception) response);
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void batchCreateOccurrences(
      BatchCreateOccurrencesRequest request,
      StreamObserver<BatchCreateOccurrencesResponse> responseObserver) {
    Object response = responses.remove();
    if (response instanceof BatchCreateOccurrencesResponse) {
      requests.add(request);
      responseObserver.onNext((BatchCreateOccurrencesResponse) response);
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError((Exception) response);
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void updateOccurrence(
      UpdateOccurrenceRequest request, StreamObserver<Occurrence> responseObserver) {
    Object response = responses.remove();
    if (response instanceof Occurrence) {
      requests.add(request);
      responseObserver.onNext((Occurrence) response);
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError((Exception) response);
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void getOccurrenceNote(
      GetOccurrenceNoteRequest request, StreamObserver<Note> responseObserver) {
    Object response = responses.remove();
    if (response instanceof Note) {
      requests.add(request);
      responseObserver.onNext((Note) response);
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError((Exception) response);
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void getNote(GetNoteRequest request, StreamObserver<Note> responseObserver) {
    Object response = responses.remove();
    if (response instanceof Note) {
      requests.add(request);
      responseObserver.onNext((Note) response);
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError((Exception) response);
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void listNotes(
      ListNotesRequest request, StreamObserver<ListNotesResponse> responseObserver) {
    Object response = responses.remove();
    if (response instanceof ListNotesResponse) {
      requests.add(request);
      responseObserver.onNext((ListNotesResponse) response);
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError((Exception) response);
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void deleteNote(DeleteNoteRequest request, StreamObserver<Empty> responseObserver) {
    Object response = responses.remove();
    if (response instanceof Empty) {
      requests.add(request);
      responseObserver.onNext((Empty) response);
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError((Exception) response);
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void createNote(CreateNoteRequest request, StreamObserver<Note> responseObserver) {
    Object response = responses.remove();
    if (response instanceof Note) {
      requests.add(request);
      responseObserver.onNext((Note) response);
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError((Exception) response);
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void batchCreateNotes(
      BatchCreateNotesRequest request, StreamObserver<BatchCreateNotesResponse> responseObserver) {
    Object response = responses.remove();
    if (response instanceof BatchCreateNotesResponse) {
      requests.add(request);
      responseObserver.onNext((BatchCreateNotesResponse) response);
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError((Exception) response);
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void updateNote(UpdateNoteRequest request, StreamObserver<Note> responseObserver) {
    Object response = responses.remove();
    if (response instanceof Note) {
      requests.add(request);
      responseObserver.onNext((Note) response);
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError((Exception) response);
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void listNoteOccurrences(
      ListNoteOccurrencesRequest request,
      StreamObserver<ListNoteOccurrencesResponse> responseObserver) {
    Object response = responses.remove();
    if (response instanceof ListNoteOccurrencesResponse) {
      requests.add(request);
      responseObserver.onNext((ListNoteOccurrencesResponse) response);
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError((Exception) response);
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void getVulnerabilityOccurrencesSummary(
      GetVulnerabilityOccurrencesSummaryRequest request,
      StreamObserver<VulnerabilityOccurrencesSummary> responseObserver) {
    Object response = responses.remove();
    if (response instanceof VulnerabilityOccurrencesSummary) {
      requests.add(request);
      responseObserver.onNext((VulnerabilityOccurrencesSummary) response);
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError((Exception) response);
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }
}
