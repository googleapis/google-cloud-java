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

package com.google.cloud.recommender.v1;

import com.google.api.core.BetaApi;
import com.google.cloud.recommender.v1.RecommenderGrpc.RecommenderImplBase;
import com.google.protobuf.AbstractMessage;
import io.grpc.stub.StreamObserver;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import javax.annotation.Generated;

@BetaApi
@Generated("by gapic-generator-java")
public class MockRecommenderImpl extends RecommenderImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockRecommenderImpl() {
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
  public void listInsights(
      ListInsightsRequest request, StreamObserver<ListInsightsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListInsightsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListInsightsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListInsights, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListInsightsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getInsight(GetInsightRequest request, StreamObserver<Insight> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Insight) {
      requests.add(request);
      responseObserver.onNext(((Insight) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetInsight, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Insight.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void markInsightAccepted(
      MarkInsightAcceptedRequest request, StreamObserver<Insight> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Insight) {
      requests.add(request);
      responseObserver.onNext(((Insight) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method MarkInsightAccepted, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Insight.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listRecommendations(
      ListRecommendationsRequest request,
      StreamObserver<ListRecommendationsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListRecommendationsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListRecommendationsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListRecommendations, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListRecommendationsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getRecommendation(
      GetRecommendationRequest request, StreamObserver<Recommendation> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Recommendation) {
      requests.add(request);
      responseObserver.onNext(((Recommendation) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetRecommendation, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Recommendation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void markRecommendationClaimed(
      MarkRecommendationClaimedRequest request, StreamObserver<Recommendation> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Recommendation) {
      requests.add(request);
      responseObserver.onNext(((Recommendation) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method MarkRecommendationClaimed, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Recommendation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void markRecommendationSucceeded(
      MarkRecommendationSucceededRequest request, StreamObserver<Recommendation> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Recommendation) {
      requests.add(request);
      responseObserver.onNext(((Recommendation) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method MarkRecommendationSucceeded, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Recommendation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void markRecommendationFailed(
      MarkRecommendationFailedRequest request, StreamObserver<Recommendation> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Recommendation) {
      requests.add(request);
      responseObserver.onNext(((Recommendation) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method MarkRecommendationFailed, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Recommendation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getRecommenderConfig(
      GetRecommenderConfigRequest request, StreamObserver<RecommenderConfig> responseObserver) {
    Object response = responses.poll();
    if (response instanceof RecommenderConfig) {
      requests.add(request);
      responseObserver.onNext(((RecommenderConfig) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetRecommenderConfig, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  RecommenderConfig.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateRecommenderConfig(
      UpdateRecommenderConfigRequest request, StreamObserver<RecommenderConfig> responseObserver) {
    Object response = responses.poll();
    if (response instanceof RecommenderConfig) {
      requests.add(request);
      responseObserver.onNext(((RecommenderConfig) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateRecommenderConfig, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  RecommenderConfig.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getInsightTypeConfig(
      GetInsightTypeConfigRequest request, StreamObserver<InsightTypeConfig> responseObserver) {
    Object response = responses.poll();
    if (response instanceof InsightTypeConfig) {
      requests.add(request);
      responseObserver.onNext(((InsightTypeConfig) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetInsightTypeConfig, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  InsightTypeConfig.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateInsightTypeConfig(
      UpdateInsightTypeConfigRequest request, StreamObserver<InsightTypeConfig> responseObserver) {
    Object response = responses.poll();
    if (response instanceof InsightTypeConfig) {
      requests.add(request);
      responseObserver.onNext(((InsightTypeConfig) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateInsightTypeConfig, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  InsightTypeConfig.class.getName(),
                  Exception.class.getName())));
    }
  }
}
