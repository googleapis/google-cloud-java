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

package com.google.cloud.dialogflow.cx.v3beta1;

import com.google.api.core.BetaApi;
import com.google.cloud.dialogflow.cx.v3beta1.ChangelogsGrpc.ChangelogsImplBase;
import com.google.protobuf.AbstractMessage;
import io.grpc.stub.StreamObserver;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import javax.annotation.Generated;

@BetaApi
@Generated("by gapic-generator-java")
public class MockChangelogsImpl extends ChangelogsImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockChangelogsImpl() {
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
  public void listChangelogs(
      ListChangelogsRequest request, StreamObserver<ListChangelogsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListChangelogsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListChangelogsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListChangelogs, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListChangelogsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getChangelog(
      GetChangelogRequest request, StreamObserver<Changelog> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Changelog) {
      requests.add(request);
      responseObserver.onNext(((Changelog) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetChangelog, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Changelog.class.getName(),
                  Exception.class.getName())));
    }
  }
}
