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

package com.google.cloud.retail.v2;

import com.google.api.core.BetaApi;
import com.google.cloud.retail.v2.ProductServiceGrpc.ProductServiceImplBase;
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
public class MockProductServiceImpl extends ProductServiceImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockProductServiceImpl() {
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
  public void createProduct(
      CreateProductRequest request, StreamObserver<Product> responseObserver) {
    Object response = responses.remove();
    if (response instanceof Product) {
      requests.add(request);
      responseObserver.onNext(((Product) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateProduct, expected %s or %s",
                  response.getClass().getName(),
                  Product.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getProduct(GetProductRequest request, StreamObserver<Product> responseObserver) {
    Object response = responses.remove();
    if (response instanceof Product) {
      requests.add(request);
      responseObserver.onNext(((Product) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetProduct, expected %s or %s",
                  response.getClass().getName(),
                  Product.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateProduct(
      UpdateProductRequest request, StreamObserver<Product> responseObserver) {
    Object response = responses.remove();
    if (response instanceof Product) {
      requests.add(request);
      responseObserver.onNext(((Product) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateProduct, expected %s or %s",
                  response.getClass().getName(),
                  Product.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteProduct(DeleteProductRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteProduct, expected %s or %s",
                  response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void importProducts(
      ImportProductsRequest request, StreamObserver<Operation> responseObserver) {
    Object response = responses.remove();
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
                  "Unrecognized response type %s for method ImportProducts, expected %s or %s",
                  response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }
}
