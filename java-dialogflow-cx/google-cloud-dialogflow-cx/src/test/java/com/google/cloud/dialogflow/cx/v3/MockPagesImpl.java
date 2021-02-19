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

package com.google.cloud.dialogflow.cx.v3;

import com.google.api.core.BetaApi;
import com.google.cloud.dialogflow.cx.v3.PagesGrpc.PagesImplBase;
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
public class MockPagesImpl extends PagesImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockPagesImpl() {
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
  public void listPages(
      ListPagesRequest request, StreamObserver<ListPagesResponse> responseObserver) {
    Object response = responses.remove();
    if (response instanceof ListPagesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListPagesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListPages, expected %s or %s",
                  response.getClass().getName(),
                  ListPagesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getPage(GetPageRequest request, StreamObserver<Page> responseObserver) {
    Object response = responses.remove();
    if (response instanceof Page) {
      requests.add(request);
      responseObserver.onNext(((Page) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetPage, expected %s or %s",
                  response.getClass().getName(), Page.class.getName(), Exception.class.getName())));
    }
  }

  @Override
  public void createPage(CreatePageRequest request, StreamObserver<Page> responseObserver) {
    Object response = responses.remove();
    if (response instanceof Page) {
      requests.add(request);
      responseObserver.onNext(((Page) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreatePage, expected %s or %s",
                  response.getClass().getName(), Page.class.getName(), Exception.class.getName())));
    }
  }

  @Override
  public void updatePage(UpdatePageRequest request, StreamObserver<Page> responseObserver) {
    Object response = responses.remove();
    if (response instanceof Page) {
      requests.add(request);
      responseObserver.onNext(((Page) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdatePage, expected %s or %s",
                  response.getClass().getName(), Page.class.getName(), Exception.class.getName())));
    }
  }

  @Override
  public void deletePage(DeletePageRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method DeletePage, expected %s or %s",
                  response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }
}
