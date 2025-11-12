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

package com.google.ads.datamanager.v1;

import com.google.ads.datamanager.v1.IngestionServiceGrpc.IngestionServiceImplBase;
import com.google.api.core.BetaApi;
import com.google.protobuf.AbstractMessage;
import io.grpc.stub.StreamObserver;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import javax.annotation.Generated;

@BetaApi
@Generated("by gapic-generator-java")
public class MockIngestionServiceImpl extends IngestionServiceImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockIngestionServiceImpl() {
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
  public void ingestAudienceMembers(
      IngestAudienceMembersRequest request,
      StreamObserver<IngestAudienceMembersResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof IngestAudienceMembersResponse) {
      requests.add(request);
      responseObserver.onNext(((IngestAudienceMembersResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method IngestAudienceMembers, expected %s or"
                      + " %s",
                  response == null ? "null" : response.getClass().getName(),
                  IngestAudienceMembersResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void removeAudienceMembers(
      RemoveAudienceMembersRequest request,
      StreamObserver<RemoveAudienceMembersResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof RemoveAudienceMembersResponse) {
      requests.add(request);
      responseObserver.onNext(((RemoveAudienceMembersResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method RemoveAudienceMembers, expected %s or"
                      + " %s",
                  response == null ? "null" : response.getClass().getName(),
                  RemoveAudienceMembersResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void ingestEvents(
      IngestEventsRequest request, StreamObserver<IngestEventsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof IngestEventsResponse) {
      requests.add(request);
      responseObserver.onNext(((IngestEventsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method IngestEvents, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  IngestEventsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void retrieveRequestStatus(
      RetrieveRequestStatusRequest request,
      StreamObserver<RetrieveRequestStatusResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof RetrieveRequestStatusResponse) {
      requests.add(request);
      responseObserver.onNext(((RetrieveRequestStatusResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method RetrieveRequestStatus, expected %s or"
                      + " %s",
                  response == null ? "null" : response.getClass().getName(),
                  RetrieveRequestStatusResponse.class.getName(),
                  Exception.class.getName())));
    }
  }
}
