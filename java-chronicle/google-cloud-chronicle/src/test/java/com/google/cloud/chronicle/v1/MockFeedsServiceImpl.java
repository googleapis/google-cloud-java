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

package com.google.cloud.chronicle.v1;

import com.google.api.HttpBody;
import com.google.api.core.BetaApi;
import com.google.cloud.chronicle.v1.FeedsServiceGrpc.FeedsServiceImplBase;
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
public class MockFeedsServiceImpl extends FeedsServiceImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockFeedsServiceImpl() {
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
  public void fetchServiceAccountForCustomer(
      FetchServiceAccountForCustomerRequest request,
      StreamObserver<FeedServiceAccount> responseObserver) {
    Object response = responses.poll();
    if (response instanceof FeedServiceAccount) {
      requests.add(request);
      responseObserver.onNext(((FeedServiceAccount) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method FetchServiceAccountForCustomer,"
                      + " expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  FeedServiceAccount.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createFeed(CreateFeedRequest request, StreamObserver<Feed> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Feed) {
      requests.add(request);
      responseObserver.onNext(((Feed) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateFeed, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Feed.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getFeed(GetFeedRequest request, StreamObserver<Feed> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Feed) {
      requests.add(request);
      responseObserver.onNext(((Feed) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetFeed, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Feed.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteFeed(DeleteFeedRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteFeed, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void enableFeed(EnableFeedRequest request, StreamObserver<Feed> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Feed) {
      requests.add(request);
      responseObserver.onNext(((Feed) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method EnableFeed, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Feed.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void disableFeed(DisableFeedRequest request, StreamObserver<Feed> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Feed) {
      requests.add(request);
      responseObserver.onNext(((Feed) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method DisableFeed, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Feed.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listFeeds(
      ListFeedsRequest request, StreamObserver<ListFeedsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListFeedsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListFeedsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListFeeds, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListFeedsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listFeedPacks(
      ListFeedPacksRequest request, StreamObserver<ListFeedPacksResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListFeedPacksResponse) {
      requests.add(request);
      responseObserver.onNext(((ListFeedPacksResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListFeedPacks, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListFeedPacksResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getFeedPack(GetFeedPackRequest request, StreamObserver<FeedPack> responseObserver) {
    Object response = responses.poll();
    if (response instanceof FeedPack) {
      requests.add(request);
      responseObserver.onNext(((FeedPack) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetFeedPack, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  FeedPack.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateFeed(UpdateFeedRequest request, StreamObserver<Feed> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Feed) {
      requests.add(request);
      responseObserver.onNext(((Feed) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateFeed, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Feed.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listFeedSourceTypeSchemas(
      ListFeedSourceTypeSchemasRequest request,
      StreamObserver<ListFeedSourceTypeSchemasResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListFeedSourceTypeSchemasResponse) {
      requests.add(request);
      responseObserver.onNext(((ListFeedSourceTypeSchemasResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListFeedSourceTypeSchemas, expected %s"
                      + " or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListFeedSourceTypeSchemasResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listLogTypeSchemas(
      ListLogTypeSchemasRequest request,
      StreamObserver<ListLogTypeSchemasResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListLogTypeSchemasResponse) {
      requests.add(request);
      responseObserver.onNext(((ListLogTypeSchemasResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListLogTypeSchemas, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListLogTypeSchemasResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void importPushLogs(
      ImportPushLogsRequest request, StreamObserver<HttpBody> responseObserver) {
    Object response = responses.poll();
    if (response instanceof HttpBody) {
      requests.add(request);
      responseObserver.onNext(((HttpBody) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ImportPushLogs, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  HttpBody.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void generateSecret(
      GenerateSecretRequest request, StreamObserver<GenerateSecretResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof GenerateSecretResponse) {
      requests.add(request);
      responseObserver.onNext(((GenerateSecretResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GenerateSecret, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  GenerateSecretResponse.class.getName(),
                  Exception.class.getName())));
    }
  }
}
