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

package com.google.cloud.asset.v1;

import com.google.api.core.BetaApi;
import com.google.cloud.asset.v1.AssetServiceGrpc.AssetServiceImplBase;
import com.google.longrunning.Operation;
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
public class MockAssetServiceImpl extends AssetServiceImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockAssetServiceImpl() {
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
  public void exportAssets(
      ExportAssetsRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method ExportAssets, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listAssets(
      ListAssetsRequest request, StreamObserver<ListAssetsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListAssetsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListAssetsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListAssets, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListAssetsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void batchGetAssetsHistory(
      BatchGetAssetsHistoryRequest request,
      StreamObserver<BatchGetAssetsHistoryResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof BatchGetAssetsHistoryResponse) {
      requests.add(request);
      responseObserver.onNext(((BatchGetAssetsHistoryResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method BatchGetAssetsHistory, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  BatchGetAssetsHistoryResponse.class.getName(),
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
  public void searchAllResources(
      SearchAllResourcesRequest request,
      StreamObserver<SearchAllResourcesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof SearchAllResourcesResponse) {
      requests.add(request);
      responseObserver.onNext(((SearchAllResourcesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method SearchAllResources, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  SearchAllResourcesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void searchAllIamPolicies(
      SearchAllIamPoliciesRequest request,
      StreamObserver<SearchAllIamPoliciesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof SearchAllIamPoliciesResponse) {
      requests.add(request);
      responseObserver.onNext(((SearchAllIamPoliciesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method SearchAllIamPolicies, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  SearchAllIamPoliciesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void analyzeIamPolicy(
      AnalyzeIamPolicyRequest request, StreamObserver<AnalyzeIamPolicyResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof AnalyzeIamPolicyResponse) {
      requests.add(request);
      responseObserver.onNext(((AnalyzeIamPolicyResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method AnalyzeIamPolicy, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  AnalyzeIamPolicyResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void analyzeIamPolicyLongrunning(
      AnalyzeIamPolicyLongrunningRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method AnalyzeIamPolicyLongrunning, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void analyzeMove(
      AnalyzeMoveRequest request, StreamObserver<AnalyzeMoveResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof AnalyzeMoveResponse) {
      requests.add(request);
      responseObserver.onNext(((AnalyzeMoveResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method AnalyzeMove, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  AnalyzeMoveResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void queryAssets(
      QueryAssetsRequest request, StreamObserver<QueryAssetsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof QueryAssetsResponse) {
      requests.add(request);
      responseObserver.onNext(((QueryAssetsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method QueryAssets, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  QueryAssetsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createSavedQuery(
      CreateSavedQueryRequest request, StreamObserver<SavedQuery> responseObserver) {
    Object response = responses.poll();
    if (response instanceof SavedQuery) {
      requests.add(request);
      responseObserver.onNext(((SavedQuery) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateSavedQuery, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  SavedQuery.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getSavedQuery(
      GetSavedQueryRequest request, StreamObserver<SavedQuery> responseObserver) {
    Object response = responses.poll();
    if (response instanceof SavedQuery) {
      requests.add(request);
      responseObserver.onNext(((SavedQuery) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetSavedQuery, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  SavedQuery.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listSavedQueries(
      ListSavedQueriesRequest request, StreamObserver<ListSavedQueriesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListSavedQueriesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListSavedQueriesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListSavedQueries, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListSavedQueriesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateSavedQuery(
      UpdateSavedQueryRequest request, StreamObserver<SavedQuery> responseObserver) {
    Object response = responses.poll();
    if (response instanceof SavedQuery) {
      requests.add(request);
      responseObserver.onNext(((SavedQuery) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateSavedQuery, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  SavedQuery.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteSavedQuery(
      DeleteSavedQueryRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteSavedQuery, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void batchGetEffectiveIamPolicies(
      BatchGetEffectiveIamPoliciesRequest request,
      StreamObserver<BatchGetEffectiveIamPoliciesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof BatchGetEffectiveIamPoliciesResponse) {
      requests.add(request);
      responseObserver.onNext(((BatchGetEffectiveIamPoliciesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method BatchGetEffectiveIamPolicies, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  BatchGetEffectiveIamPoliciesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }
}
