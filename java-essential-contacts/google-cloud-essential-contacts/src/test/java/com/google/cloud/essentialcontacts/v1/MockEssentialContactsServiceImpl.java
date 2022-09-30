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

package com.google.cloud.essentialcontacts.v1;

import com.google.api.core.BetaApi;
import com.google.cloud.essentialcontacts.v1.EssentialContactsServiceGrpc.EssentialContactsServiceImplBase;
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
public class MockEssentialContactsServiceImpl extends EssentialContactsServiceImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockEssentialContactsServiceImpl() {
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
  public void createContact(
      CreateContactRequest request, StreamObserver<Contact> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Contact) {
      requests.add(request);
      responseObserver.onNext(((Contact) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateContact, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Contact.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateContact(
      UpdateContactRequest request, StreamObserver<Contact> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Contact) {
      requests.add(request);
      responseObserver.onNext(((Contact) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateContact, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Contact.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listContacts(
      ListContactsRequest request, StreamObserver<ListContactsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListContactsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListContactsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListContacts, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListContactsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getContact(GetContactRequest request, StreamObserver<Contact> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Contact) {
      requests.add(request);
      responseObserver.onNext(((Contact) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetContact, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Contact.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteContact(DeleteContactRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteContact, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void computeContacts(
      ComputeContactsRequest request, StreamObserver<ComputeContactsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ComputeContactsResponse) {
      requests.add(request);
      responseObserver.onNext(((ComputeContactsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ComputeContacts, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ComputeContactsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void sendTestMessage(
      SendTestMessageRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method SendTestMessage, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }
}
