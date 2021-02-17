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

package com.google.cloud.bigquery.reservation.v1;

import com.google.api.core.BetaApi;
import com.google.cloud.bigquery.reservation.v1.ReservationServiceGrpc.ReservationServiceImplBase;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Empty;
import io.grpc.stub.StreamObserver;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import javax.annotation.Generated;

@BetaApi
@Generated("by gapic-generator-java")
public class MockReservationServiceImpl extends ReservationServiceImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockReservationServiceImpl() {
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
  public void createReservation(
      CreateReservationRequest request, StreamObserver<Reservation> responseObserver) {
    Object response = responses.remove();
    if (response instanceof Reservation) {
      requests.add(request);
      responseObserver.onNext(((Reservation) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateReservation, expected %s or %s",
                  response.getClass().getName(),
                  Reservation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listReservations(
      ListReservationsRequest request, StreamObserver<ListReservationsResponse> responseObserver) {
    Object response = responses.remove();
    if (response instanceof ListReservationsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListReservationsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListReservations, expected %s or %s",
                  response.getClass().getName(),
                  ListReservationsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getReservation(
      GetReservationRequest request, StreamObserver<Reservation> responseObserver) {
    Object response = responses.remove();
    if (response instanceof Reservation) {
      requests.add(request);
      responseObserver.onNext(((Reservation) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetReservation, expected %s or %s",
                  response.getClass().getName(),
                  Reservation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteReservation(
      DeleteReservationRequest request, StreamObserver<Empty> responseObserver) {
    Object response = responses.remove();
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
                  "Unrecognized response type %s for method DeleteReservation, expected %s or %s",
                  response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateReservation(
      UpdateReservationRequest request, StreamObserver<Reservation> responseObserver) {
    Object response = responses.remove();
    if (response instanceof Reservation) {
      requests.add(request);
      responseObserver.onNext(((Reservation) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateReservation, expected %s or %s",
                  response.getClass().getName(),
                  Reservation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createCapacityCommitment(
      CreateCapacityCommitmentRequest request,
      StreamObserver<CapacityCommitment> responseObserver) {
    Object response = responses.remove();
    if (response instanceof CapacityCommitment) {
      requests.add(request);
      responseObserver.onNext(((CapacityCommitment) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateCapacityCommitment, expected %s or %s",
                  response.getClass().getName(),
                  CapacityCommitment.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listCapacityCommitments(
      ListCapacityCommitmentsRequest request,
      StreamObserver<ListCapacityCommitmentsResponse> responseObserver) {
    Object response = responses.remove();
    if (response instanceof ListCapacityCommitmentsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListCapacityCommitmentsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListCapacityCommitments, expected %s or %s",
                  response.getClass().getName(),
                  ListCapacityCommitmentsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getCapacityCommitment(
      GetCapacityCommitmentRequest request, StreamObserver<CapacityCommitment> responseObserver) {
    Object response = responses.remove();
    if (response instanceof CapacityCommitment) {
      requests.add(request);
      responseObserver.onNext(((CapacityCommitment) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetCapacityCommitment, expected %s or %s",
                  response.getClass().getName(),
                  CapacityCommitment.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteCapacityCommitment(
      DeleteCapacityCommitmentRequest request, StreamObserver<Empty> responseObserver) {
    Object response = responses.remove();
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
                  "Unrecognized response type %s for method DeleteCapacityCommitment, expected %s or %s",
                  response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateCapacityCommitment(
      UpdateCapacityCommitmentRequest request,
      StreamObserver<CapacityCommitment> responseObserver) {
    Object response = responses.remove();
    if (response instanceof CapacityCommitment) {
      requests.add(request);
      responseObserver.onNext(((CapacityCommitment) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateCapacityCommitment, expected %s or %s",
                  response.getClass().getName(),
                  CapacityCommitment.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void splitCapacityCommitment(
      SplitCapacityCommitmentRequest request,
      StreamObserver<SplitCapacityCommitmentResponse> responseObserver) {
    Object response = responses.remove();
    if (response instanceof SplitCapacityCommitmentResponse) {
      requests.add(request);
      responseObserver.onNext(((SplitCapacityCommitmentResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method SplitCapacityCommitment, expected %s or %s",
                  response.getClass().getName(),
                  SplitCapacityCommitmentResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void mergeCapacityCommitments(
      MergeCapacityCommitmentsRequest request,
      StreamObserver<CapacityCommitment> responseObserver) {
    Object response = responses.remove();
    if (response instanceof CapacityCommitment) {
      requests.add(request);
      responseObserver.onNext(((CapacityCommitment) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method MergeCapacityCommitments, expected %s or %s",
                  response.getClass().getName(),
                  CapacityCommitment.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createAssignment(
      CreateAssignmentRequest request, StreamObserver<Assignment> responseObserver) {
    Object response = responses.remove();
    if (response instanceof Assignment) {
      requests.add(request);
      responseObserver.onNext(((Assignment) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateAssignment, expected %s or %s",
                  response.getClass().getName(),
                  Assignment.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listAssignments(
      ListAssignmentsRequest request, StreamObserver<ListAssignmentsResponse> responseObserver) {
    Object response = responses.remove();
    if (response instanceof ListAssignmentsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListAssignmentsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListAssignments, expected %s or %s",
                  response.getClass().getName(),
                  ListAssignmentsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteAssignment(
      DeleteAssignmentRequest request, StreamObserver<Empty> responseObserver) {
    Object response = responses.remove();
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
                  "Unrecognized response type %s for method DeleteAssignment, expected %s or %s",
                  response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void searchAssignments(
      SearchAssignmentsRequest request,
      StreamObserver<SearchAssignmentsResponse> responseObserver) {
    Object response = responses.remove();
    if (response instanceof SearchAssignmentsResponse) {
      requests.add(request);
      responseObserver.onNext(((SearchAssignmentsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method SearchAssignments, expected %s or %s",
                  response.getClass().getName(),
                  SearchAssignmentsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void moveAssignment(
      MoveAssignmentRequest request, StreamObserver<Assignment> responseObserver) {
    Object response = responses.remove();
    if (response instanceof Assignment) {
      requests.add(request);
      responseObserver.onNext(((Assignment) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method MoveAssignment, expected %s or %s",
                  response.getClass().getName(),
                  Assignment.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getBiReservation(
      GetBiReservationRequest request, StreamObserver<BiReservation> responseObserver) {
    Object response = responses.remove();
    if (response instanceof BiReservation) {
      requests.add(request);
      responseObserver.onNext(((BiReservation) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetBiReservation, expected %s or %s",
                  response.getClass().getName(),
                  BiReservation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateBiReservation(
      UpdateBiReservationRequest request, StreamObserver<BiReservation> responseObserver) {
    Object response = responses.remove();
    if (response instanceof BiReservation) {
      requests.add(request);
      responseObserver.onNext(((BiReservation) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateBiReservation, expected %s or %s",
                  response.getClass().getName(),
                  BiReservation.class.getName(),
                  Exception.class.getName())));
    }
  }
}
