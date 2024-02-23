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

package com.google.cloud.aiplatform.v1;

import com.google.api.core.BetaApi;
import com.google.cloud.aiplatform.v1.FeatureOnlineStoreAdminServiceGrpc.FeatureOnlineStoreAdminServiceImplBase;
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
public class MockFeatureOnlineStoreAdminServiceImpl extends FeatureOnlineStoreAdminServiceImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockFeatureOnlineStoreAdminServiceImpl() {
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
  public void createFeatureOnlineStore(
      CreateFeatureOnlineStoreRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method CreateFeatureOnlineStore, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getFeatureOnlineStore(
      GetFeatureOnlineStoreRequest request, StreamObserver<FeatureOnlineStore> responseObserver) {
    Object response = responses.poll();
    if (response instanceof FeatureOnlineStore) {
      requests.add(request);
      responseObserver.onNext(((FeatureOnlineStore) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetFeatureOnlineStore, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  FeatureOnlineStore.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listFeatureOnlineStores(
      ListFeatureOnlineStoresRequest request,
      StreamObserver<ListFeatureOnlineStoresResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListFeatureOnlineStoresResponse) {
      requests.add(request);
      responseObserver.onNext(((ListFeatureOnlineStoresResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListFeatureOnlineStores, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListFeatureOnlineStoresResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateFeatureOnlineStore(
      UpdateFeatureOnlineStoreRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method UpdateFeatureOnlineStore, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteFeatureOnlineStore(
      DeleteFeatureOnlineStoreRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteFeatureOnlineStore, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createFeatureView(
      CreateFeatureViewRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method CreateFeatureView, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getFeatureView(
      GetFeatureViewRequest request, StreamObserver<FeatureView> responseObserver) {
    Object response = responses.poll();
    if (response instanceof FeatureView) {
      requests.add(request);
      responseObserver.onNext(((FeatureView) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetFeatureView, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  FeatureView.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listFeatureViews(
      ListFeatureViewsRequest request, StreamObserver<ListFeatureViewsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListFeatureViewsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListFeatureViewsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListFeatureViews, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListFeatureViewsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateFeatureView(
      UpdateFeatureViewRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method UpdateFeatureView, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteFeatureView(
      DeleteFeatureViewRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteFeatureView, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void syncFeatureView(
      SyncFeatureViewRequest request, StreamObserver<SyncFeatureViewResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof SyncFeatureViewResponse) {
      requests.add(request);
      responseObserver.onNext(((SyncFeatureViewResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method SyncFeatureView, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  SyncFeatureViewResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getFeatureViewSync(
      GetFeatureViewSyncRequest request, StreamObserver<FeatureViewSync> responseObserver) {
    Object response = responses.poll();
    if (response instanceof FeatureViewSync) {
      requests.add(request);
      responseObserver.onNext(((FeatureViewSync) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetFeatureViewSync, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  FeatureViewSync.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listFeatureViewSyncs(
      ListFeatureViewSyncsRequest request,
      StreamObserver<ListFeatureViewSyncsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListFeatureViewSyncsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListFeatureViewSyncsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListFeatureViewSyncs, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListFeatureViewSyncsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }
}
