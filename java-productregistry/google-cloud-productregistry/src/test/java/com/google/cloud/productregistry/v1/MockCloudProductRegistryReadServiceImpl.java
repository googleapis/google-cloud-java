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

package com.google.cloud.productregistry.v1;

import com.google.api.core.BetaApi;
import com.google.cloud.productregistry.v1.CloudProductRegistryReadServiceGrpc.CloudProductRegistryReadServiceImplBase;
import com.google.protobuf.AbstractMessage;
import io.grpc.stub.StreamObserver;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import javax.annotation.Generated;

@BetaApi
@Generated("by gapic-generator-java")
public class MockCloudProductRegistryReadServiceImpl
    extends CloudProductRegistryReadServiceImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockCloudProductRegistryReadServiceImpl() {
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
  public void getProductSuite(
      GetProductSuiteRequest request, StreamObserver<ProductSuite> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ProductSuite) {
      requests.add(request);
      responseObserver.onNext(((ProductSuite) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetProductSuite, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ProductSuite.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listProductSuites(
      ListProductSuitesRequest request,
      StreamObserver<ListProductSuitesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListProductSuitesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListProductSuitesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListProductSuites, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListProductSuitesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getLogicalProduct(
      GetLogicalProductRequest request, StreamObserver<LogicalProduct> responseObserver) {
    Object response = responses.poll();
    if (response instanceof LogicalProduct) {
      requests.add(request);
      responseObserver.onNext(((LogicalProduct) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetLogicalProduct, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  LogicalProduct.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listLogicalProducts(
      ListLogicalProductsRequest request,
      StreamObserver<ListLogicalProductsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListLogicalProductsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListLogicalProductsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListLogicalProducts, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListLogicalProductsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getLogicalProductVariant(
      GetLogicalProductVariantRequest request,
      StreamObserver<LogicalProductVariant> responseObserver) {
    Object response = responses.poll();
    if (response instanceof LogicalProductVariant) {
      requests.add(request);
      responseObserver.onNext(((LogicalProductVariant) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetLogicalProductVariant, expected %s"
                      + " or %s",
                  response == null ? "null" : response.getClass().getName(),
                  LogicalProductVariant.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listLogicalProductVariants(
      ListLogicalProductVariantsRequest request,
      StreamObserver<ListLogicalProductVariantsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListLogicalProductVariantsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListLogicalProductVariantsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListLogicalProductVariants, expected %s"
                      + " or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListLogicalProductVariantsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void lookupEntity(
      LookupEntityRequest request, StreamObserver<LookupEntityResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof LookupEntityResponse) {
      requests.add(request);
      responseObserver.onNext(((LookupEntityResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method LookupEntity, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  LookupEntityResponse.class.getName(),
                  Exception.class.getName())));
    }
  }
}
