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

package com.google.cloud.vectorsearch.v1beta;

import com.google.api.core.BetaApi;
import com.google.cloud.vectorsearch.v1beta.DataObjectServiceGrpc.DataObjectServiceImplBase;
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
public class MockDataObjectServiceImpl extends DataObjectServiceImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockDataObjectServiceImpl() {
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
  public void createDataObject(
      CreateDataObjectRequest request, StreamObserver<DataObject> responseObserver) {
    Object response = responses.poll();
    if (response instanceof DataObject) {
      requests.add(request);
      responseObserver.onNext(((DataObject) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateDataObject, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  DataObject.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void batchCreateDataObjects(
      BatchCreateDataObjectsRequest request,
      StreamObserver<BatchCreateDataObjectsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof BatchCreateDataObjectsResponse) {
      requests.add(request);
      responseObserver.onNext(((BatchCreateDataObjectsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method BatchCreateDataObjects, expected %s or"
                      + " %s",
                  response == null ? "null" : response.getClass().getName(),
                  BatchCreateDataObjectsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getDataObject(
      GetDataObjectRequest request, StreamObserver<DataObject> responseObserver) {
    Object response = responses.poll();
    if (response instanceof DataObject) {
      requests.add(request);
      responseObserver.onNext(((DataObject) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetDataObject, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  DataObject.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateDataObject(
      UpdateDataObjectRequest request, StreamObserver<DataObject> responseObserver) {
    Object response = responses.poll();
    if (response instanceof DataObject) {
      requests.add(request);
      responseObserver.onNext(((DataObject) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateDataObject, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  DataObject.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void batchUpdateDataObjects(
      BatchUpdateDataObjectsRequest request,
      StreamObserver<BatchUpdateDataObjectsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof BatchUpdateDataObjectsResponse) {
      requests.add(request);
      responseObserver.onNext(((BatchUpdateDataObjectsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method BatchUpdateDataObjects, expected %s or"
                      + " %s",
                  response == null ? "null" : response.getClass().getName(),
                  BatchUpdateDataObjectsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteDataObject(
      DeleteDataObjectRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteDataObject, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void batchDeleteDataObjects(
      BatchDeleteDataObjectsRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method BatchDeleteDataObjects, expected %s or"
                      + " %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }
}
