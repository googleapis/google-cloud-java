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

package com.google.cloud.geminidataanalytics.v1beta;

import com.google.api.core.BetaApi;
import com.google.cloud.geminidataanalytics.v1beta.ContextRetrievalServiceGrpc.ContextRetrievalServiceImplBase;
import com.google.protobuf.AbstractMessage;
import io.grpc.stub.StreamObserver;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import javax.annotation.Generated;

@BetaApi
@Generated("by gapic-generator-java")
public class MockContextRetrievalServiceImpl extends ContextRetrievalServiceImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockContextRetrievalServiceImpl() {
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
  public void retrieveBigQueryTableContext(
      RetrieveBigQueryTableContextRequest request,
      StreamObserver<RetrieveBigQueryTableContextResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof RetrieveBigQueryTableContextResponse) {
      requests.add(request);
      responseObserver.onNext(((RetrieveBigQueryTableContextResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method RetrieveBigQueryTableContext, expected"
                      + " %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  RetrieveBigQueryTableContextResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void retrieveBigQueryTableContexts(
      RetrieveBigQueryTableContextsRequest request,
      StreamObserver<RetrieveBigQueryTableContextsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof RetrieveBigQueryTableContextsResponse) {
      requests.add(request);
      responseObserver.onNext(((RetrieveBigQueryTableContextsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method RetrieveBigQueryTableContexts, expected"
                      + " %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  RetrieveBigQueryTableContextsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void retrieveBigQueryTableContextsFromRecentTables(
      RetrieveBigQueryTableContextsFromRecentTablesRequest request,
      StreamObserver<RetrieveBigQueryTableContextsFromRecentTablesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof RetrieveBigQueryTableContextsFromRecentTablesResponse) {
      requests.add(request);
      responseObserver.onNext(((RetrieveBigQueryTableContextsFromRecentTablesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method"
                      + " RetrieveBigQueryTableContextsFromRecentTables, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  RetrieveBigQueryTableContextsFromRecentTablesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void retrieveBigQueryTableSuggestedDescriptions(
      RetrieveBigQueryTableSuggestedDescriptionsRequest request,
      StreamObserver<RetrieveBigQueryTableSuggestedDescriptionsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof RetrieveBigQueryTableSuggestedDescriptionsResponse) {
      requests.add(request);
      responseObserver.onNext(((RetrieveBigQueryTableSuggestedDescriptionsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method"
                      + " RetrieveBigQueryTableSuggestedDescriptions, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  RetrieveBigQueryTableSuggestedDescriptionsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void retrieveBigQueryTableSuggestedExamples(
      RetrieveBigQueryTableSuggestedExamplesRequest request,
      StreamObserver<RetrieveBigQueryTableSuggestedExamplesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof RetrieveBigQueryTableSuggestedExamplesResponse) {
      requests.add(request);
      responseObserver.onNext(((RetrieveBigQueryTableSuggestedExamplesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method RetrieveBigQueryTableSuggestedExamples,"
                      + " expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  RetrieveBigQueryTableSuggestedExamplesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void retrieveBigQueryRecentRelevantTables(
      RetrieveBigQueryRecentRelevantTablesRequest request,
      StreamObserver<RetrieveBigQueryRecentRelevantTablesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof RetrieveBigQueryRecentRelevantTablesResponse) {
      requests.add(request);
      responseObserver.onNext(((RetrieveBigQueryRecentRelevantTablesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method RetrieveBigQueryRecentRelevantTables,"
                      + " expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  RetrieveBigQueryRecentRelevantTablesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }
}
