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

package com.google.cloud.observability.v1;

import com.google.api.core.BetaApi;
import com.google.cloud.observability.v1.ObservabilityGrpc.ObservabilityImplBase;
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
public class MockObservabilityImpl extends ObservabilityImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockObservabilityImpl() {
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
  public void getScope(GetScopeRequest request, StreamObserver<Scope> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Scope) {
      requests.add(request);
      responseObserver.onNext(((Scope) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetScope, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Scope.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateScope(UpdateScopeRequest request, StreamObserver<Scope> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Scope) {
      requests.add(request);
      responseObserver.onNext(((Scope) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateScope, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Scope.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getBucket(GetBucketRequest request, StreamObserver<Bucket> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Bucket) {
      requests.add(request);
      responseObserver.onNext(((Bucket) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetBucket, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Bucket.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listBuckets(
      ListBucketsRequest request, StreamObserver<ListBucketsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListBucketsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListBucketsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListBuckets, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListBucketsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createBucket(
      CreateBucketRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method CreateBucket, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateBucket(
      UpdateBucketRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method UpdateBucket, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getDataset(GetDatasetRequest request, StreamObserver<Dataset> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Dataset) {
      requests.add(request);
      responseObserver.onNext(((Dataset) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetDataset, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Dataset.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listDatasets(
      ListDatasetsRequest request, StreamObserver<ListDatasetsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListDatasetsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListDatasetsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListDatasets, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListDatasetsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getView(GetViewRequest request, StreamObserver<View> responseObserver) {
    Object response = responses.poll();
    if (response instanceof View) {
      requests.add(request);
      responseObserver.onNext(((View) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetView, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  View.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listViews(
      ListViewsRequest request, StreamObserver<ListViewsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListViewsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListViewsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListViews, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListViewsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getLink(GetLinkRequest request, StreamObserver<Link> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Link) {
      requests.add(request);
      responseObserver.onNext(((Link) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetLink, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Link.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listLinks(
      ListLinksRequest request, StreamObserver<ListLinksResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListLinksResponse) {
      requests.add(request);
      responseObserver.onNext(((ListLinksResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListLinks, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListLinksResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createLink(CreateLinkRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method CreateLink, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateLink(UpdateLinkRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method UpdateLink, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteLink(DeleteLinkRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteLink, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getTraceScope(
      GetTraceScopeRequest request, StreamObserver<TraceScope> responseObserver) {
    Object response = responses.poll();
    if (response instanceof TraceScope) {
      requests.add(request);
      responseObserver.onNext(((TraceScope) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetTraceScope, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  TraceScope.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listTraceScopes(
      ListTraceScopesRequest request, StreamObserver<ListTraceScopesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListTraceScopesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListTraceScopesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListTraceScopes, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListTraceScopesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createTraceScope(
      CreateTraceScopeRequest request, StreamObserver<TraceScope> responseObserver) {
    Object response = responses.poll();
    if (response instanceof TraceScope) {
      requests.add(request);
      responseObserver.onNext(((TraceScope) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateTraceScope, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  TraceScope.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateTraceScope(
      UpdateTraceScopeRequest request, StreamObserver<TraceScope> responseObserver) {
    Object response = responses.poll();
    if (response instanceof TraceScope) {
      requests.add(request);
      responseObserver.onNext(((TraceScope) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateTraceScope, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  TraceScope.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteTraceScope(
      DeleteTraceScopeRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteTraceScope, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getSettings(GetSettingsRequest request, StreamObserver<Settings> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Settings) {
      requests.add(request);
      responseObserver.onNext(((Settings) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetSettings, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Settings.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateSettings(
      UpdateSettingsRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method UpdateSettings, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }
}
