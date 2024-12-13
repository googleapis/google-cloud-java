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

package com.google.shopping.merchant.reviews.v1beta;

import com.google.api.core.BetaApi;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Empty;
import com.google.shopping.merchant.reviews.v1beta.MerchantReviewsServiceGrpc.MerchantReviewsServiceImplBase;
import io.grpc.stub.StreamObserver;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import javax.annotation.Generated;

@BetaApi
@Generated("by gapic-generator-java")
public class MockMerchantReviewsServiceImpl extends MerchantReviewsServiceImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockMerchantReviewsServiceImpl() {
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
  public void getMerchantReview(
      GetMerchantReviewRequest request, StreamObserver<MerchantReview> responseObserver) {
    Object response = responses.poll();
    if (response instanceof MerchantReview) {
      requests.add(request);
      responseObserver.onNext(((MerchantReview) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetMerchantReview, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  MerchantReview.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listMerchantReviews(
      ListMerchantReviewsRequest request,
      StreamObserver<ListMerchantReviewsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListMerchantReviewsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListMerchantReviewsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListMerchantReviews, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListMerchantReviewsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void insertMerchantReview(
      InsertMerchantReviewRequest request, StreamObserver<MerchantReview> responseObserver) {
    Object response = responses.poll();
    if (response instanceof MerchantReview) {
      requests.add(request);
      responseObserver.onNext(((MerchantReview) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method InsertMerchantReview, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  MerchantReview.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteMerchantReview(
      DeleteMerchantReviewRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteMerchantReview, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }
}
