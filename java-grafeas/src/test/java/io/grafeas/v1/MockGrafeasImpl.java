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

package io.grafeas.v1;

import com.google.api.core.BetaApi;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Empty;
import io.grafeas.v1.GrafeasGrpc.GrafeasImplBase;
import io.grpc.stub.StreamObserver;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import javax.annotation.Generated;

@BetaApi
@Generated("by gapic-generator-java")
public class MockGrafeasImpl extends GrafeasImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockGrafeasImpl() {
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
    Object response = responses.poll();
    if (response instanceof Occurrence) {
      requests.add(request);
      responseObserver.onNext(((Occurrence) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetOccurrence, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Occurrence.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listOccurrences(
      ListOccurrencesRequest request, StreamObserver<ListOccurrencesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListOccurrencesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListOccurrencesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListOccurrences, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListOccurrencesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteOccurrence(
      DeleteOccurrenceRequest request, StreamObserver<Empty> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Empty) {
      requests.add(request);
      responseObserver.onNext(((Empty) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method DeleteOccurrence, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createOccurrence(
      CreateOccurrenceRequest request, StreamObserver<Occurrence> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Occurrence) {
      requests.add(request);
      responseObserver.onNext(((Occurrence) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateOccurrence, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Occurrence.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void batchCreateOccurrences(
      BatchCreateOccurrencesRequest request,
      StreamObserver<BatchCreateOccurrencesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof BatchCreateOccurrencesResponse) {
      requests.add(request);
      responseObserver.onNext(((BatchCreateOccurrencesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method BatchCreateOccurrences, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  BatchCreateOccurrencesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateOccurrence(
      UpdateOccurrenceRequest request, StreamObserver<Occurrence> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Occurrence) {
      requests.add(request);
      responseObserver.onNext(((Occurrence) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateOccurrence, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Occurrence.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getOccurrenceNote(
      GetOccurrenceNoteRequest request, StreamObserver<Note> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Note) {
      requests.add(request);
      responseObserver.onNext(((Note) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetOccurrenceNote, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Note.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getNote(GetNoteRequest request, StreamObserver<Note> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Note) {
      requests.add(request);
      responseObserver.onNext(((Note) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetNote, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Note.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listNotes(
      ListNotesRequest request, StreamObserver<ListNotesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListNotesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListNotesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListNotes, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListNotesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteNote(DeleteNoteRequest request, StreamObserver<Empty> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Empty) {
      requests.add(request);
      responseObserver.onNext(((Empty) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method DeleteNote, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createNote(CreateNoteRequest request, StreamObserver<Note> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Note) {
      requests.add(request);
      responseObserver.onNext(((Note) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateNote, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Note.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void batchCreateNotes(
      BatchCreateNotesRequest request, StreamObserver<BatchCreateNotesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof BatchCreateNotesResponse) {
      requests.add(request);
      responseObserver.onNext(((BatchCreateNotesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method BatchCreateNotes, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  BatchCreateNotesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateNote(UpdateNoteRequest request, StreamObserver<Note> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Note) {
      requests.add(request);
      responseObserver.onNext(((Note) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateNote, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Note.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listNoteOccurrences(
      ListNoteOccurrencesRequest request,
      StreamObserver<ListNoteOccurrencesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListNoteOccurrencesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListNoteOccurrencesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListNoteOccurrences, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListNoteOccurrencesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }
}
