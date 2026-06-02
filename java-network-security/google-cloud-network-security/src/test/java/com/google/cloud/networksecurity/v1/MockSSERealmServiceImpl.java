/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.networksecurity.v1;

import com.google.api.core.BetaApi;
import com.google.cloud.networksecurity.v1.SSERealmServiceGrpc.SSERealmServiceImplBase;
import com.google.longrunning.Operation;
import com.google.protobuf.AbstractMessage;
import io.grpc.stub.StreamObserver;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import javax.annotation.Generated;

@BetaApi
@Generated("by gapic-generator-java")
public class MockSSERealmServiceImpl extends SSERealmServiceImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockSSERealmServiceImpl() {
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
  public void listSACRealms(
      ListSACRealmsRequest request, StreamObserver<ListSACRealmsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListSACRealmsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListSACRealmsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListSACRealms, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListSACRealmsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getSACRealm(GetSACRealmRequest request, StreamObserver<SACRealm> responseObserver) {
    Object response = responses.poll();
    if (response instanceof SACRealm) {
      requests.add(request);
      responseObserver.onNext(((SACRealm) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetSACRealm, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  SACRealm.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createSACRealm(
      CreateSACRealmRequest request, StreamObserver<Operation> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Operation) {
      requests.add(request);
      responseObserver.onNext(((Operation) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateSACRealm, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteSACRealm(
      DeleteSACRealmRequest request, StreamObserver<Operation> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Operation) {
      requests.add(request);
      responseObserver.onNext(((Operation) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method DeleteSACRealm, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listSACAttachments(
      ListSACAttachmentsRequest request,
      StreamObserver<ListSACAttachmentsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListSACAttachmentsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListSACAttachmentsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListSACAttachments, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListSACAttachmentsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getSACAttachment(
      GetSACAttachmentRequest request, StreamObserver<SACAttachment> responseObserver) {
    Object response = responses.poll();
    if (response instanceof SACAttachment) {
      requests.add(request);
      responseObserver.onNext(((SACAttachment) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetSACAttachment, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  SACAttachment.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createSACAttachment(
      CreateSACAttachmentRequest request, StreamObserver<Operation> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Operation) {
      requests.add(request);
      responseObserver.onNext(((Operation) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateSACAttachment, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteSACAttachment(
      DeleteSACAttachmentRequest request, StreamObserver<Operation> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Operation) {
      requests.add(request);
      responseObserver.onNext(((Operation) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method DeleteSACAttachment, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }
}
