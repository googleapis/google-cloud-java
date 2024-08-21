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

package com.google.cloud.apihub.v1;

import com.google.api.core.BetaApi;
import com.google.cloud.apihub.v1.RuntimeProjectAttachmentServiceGrpc.RuntimeProjectAttachmentServiceImplBase;
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
public class MockRuntimeProjectAttachmentServiceImpl
    extends RuntimeProjectAttachmentServiceImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockRuntimeProjectAttachmentServiceImpl() {
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
  public void createRuntimeProjectAttachment(
      CreateRuntimeProjectAttachmentRequest request,
      StreamObserver<RuntimeProjectAttachment> responseObserver) {
    Object response = responses.poll();
    if (response instanceof RuntimeProjectAttachment) {
      requests.add(request);
      responseObserver.onNext(((RuntimeProjectAttachment) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateRuntimeProjectAttachment, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  RuntimeProjectAttachment.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getRuntimeProjectAttachment(
      GetRuntimeProjectAttachmentRequest request,
      StreamObserver<RuntimeProjectAttachment> responseObserver) {
    Object response = responses.poll();
    if (response instanceof RuntimeProjectAttachment) {
      requests.add(request);
      responseObserver.onNext(((RuntimeProjectAttachment) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetRuntimeProjectAttachment, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  RuntimeProjectAttachment.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listRuntimeProjectAttachments(
      ListRuntimeProjectAttachmentsRequest request,
      StreamObserver<ListRuntimeProjectAttachmentsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListRuntimeProjectAttachmentsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListRuntimeProjectAttachmentsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListRuntimeProjectAttachments, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListRuntimeProjectAttachmentsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteRuntimeProjectAttachment(
      DeleteRuntimeProjectAttachmentRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteRuntimeProjectAttachment, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void lookupRuntimeProjectAttachment(
      LookupRuntimeProjectAttachmentRequest request,
      StreamObserver<LookupRuntimeProjectAttachmentResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof LookupRuntimeProjectAttachmentResponse) {
      requests.add(request);
      responseObserver.onNext(((LookupRuntimeProjectAttachmentResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method LookupRuntimeProjectAttachment, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  LookupRuntimeProjectAttachmentResponse.class.getName(),
                  Exception.class.getName())));
    }
  }
}
