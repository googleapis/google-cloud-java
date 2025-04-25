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

package com.google.cloud.servicehealth.v1;

import com.google.api.core.BetaApi;
import com.google.cloud.servicehealth.v1.ServiceHealthGrpc.ServiceHealthImplBase;
import com.google.protobuf.AbstractMessage;
import io.grpc.stub.StreamObserver;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import javax.annotation.Generated;

@BetaApi
@Generated("by gapic-generator-java")
public class MockServiceHealthImpl extends ServiceHealthImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockServiceHealthImpl() {
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
  public void listEvents(
      ListEventsRequest request, StreamObserver<ListEventsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListEventsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListEventsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListEvents, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListEventsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getEvent(GetEventRequest request, StreamObserver<Event> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Event) {
      requests.add(request);
      responseObserver.onNext(((Event) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetEvent, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Event.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listOrganizationEvents(
      ListOrganizationEventsRequest request,
      StreamObserver<ListOrganizationEventsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListOrganizationEventsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListOrganizationEventsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListOrganizationEvents, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListOrganizationEventsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getOrganizationEvent(
      GetOrganizationEventRequest request, StreamObserver<OrganizationEvent> responseObserver) {
    Object response = responses.poll();
    if (response instanceof OrganizationEvent) {
      requests.add(request);
      responseObserver.onNext(((OrganizationEvent) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetOrganizationEvent, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  OrganizationEvent.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listOrganizationImpacts(
      ListOrganizationImpactsRequest request,
      StreamObserver<ListOrganizationImpactsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListOrganizationImpactsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListOrganizationImpactsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListOrganizationImpacts, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListOrganizationImpactsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getOrganizationImpact(
      GetOrganizationImpactRequest request, StreamObserver<OrganizationImpact> responseObserver) {
    Object response = responses.poll();
    if (response instanceof OrganizationImpact) {
      requests.add(request);
      responseObserver.onNext(((OrganizationImpact) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetOrganizationImpact, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  OrganizationImpact.class.getName(),
                  Exception.class.getName())));
    }
  }
}
