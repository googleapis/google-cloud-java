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

package com.google.cloud.vision.v1p3beta1;

import com.google.api.core.BetaApi;
import com.google.cloud.vision.v1p3beta1.ProductSearchGrpc.ProductSearchImplBase;
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
public class MockProductSearchImpl extends ProductSearchImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockProductSearchImpl() {
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
  public void createProductSet(
      CreateProductSetRequest request, StreamObserver<ProductSet> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ProductSet) {
      requests.add(request);
      responseObserver.onNext(((ProductSet) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateProductSet, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ProductSet.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listProductSets(
      ListProductSetsRequest request, StreamObserver<ListProductSetsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListProductSetsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListProductSetsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListProductSets, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListProductSetsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getProductSet(
      GetProductSetRequest request, StreamObserver<ProductSet> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ProductSet) {
      requests.add(request);
      responseObserver.onNext(((ProductSet) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetProductSet, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ProductSet.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateProductSet(
      UpdateProductSetRequest request, StreamObserver<ProductSet> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ProductSet) {
      requests.add(request);
      responseObserver.onNext(((ProductSet) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateProductSet, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ProductSet.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteProductSet(
      DeleteProductSetRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteProductSet, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createProduct(
      CreateProductRequest request, StreamObserver<Product> responseObserver) {
    Object response = responses.poll();
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
                  response == null ? "null" : response.getClass().getName(),
                  Product.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listProducts(
      ListProductsRequest request, StreamObserver<ListProductsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListProductsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListProductsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListProducts, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListProductsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getProduct(GetProductRequest request, StreamObserver<Product> responseObserver) {
    Object response = responses.poll();
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
                  response == null ? "null" : response.getClass().getName(),
                  Product.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateProduct(
      UpdateProductRequest request, StreamObserver<Product> responseObserver) {
    Object response = responses.poll();
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
                  response == null ? "null" : response.getClass().getName(),
                  Product.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteProduct(DeleteProductRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteProduct, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createReferenceImage(
      CreateReferenceImageRequest request, StreamObserver<ReferenceImage> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ReferenceImage) {
      requests.add(request);
      responseObserver.onNext(((ReferenceImage) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateReferenceImage, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ReferenceImage.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteReferenceImage(
      DeleteReferenceImageRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteReferenceImage, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listReferenceImages(
      ListReferenceImagesRequest request,
      StreamObserver<ListReferenceImagesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListReferenceImagesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListReferenceImagesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListReferenceImages, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListReferenceImagesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getReferenceImage(
      GetReferenceImageRequest request, StreamObserver<ReferenceImage> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ReferenceImage) {
      requests.add(request);
      responseObserver.onNext(((ReferenceImage) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetReferenceImage, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ReferenceImage.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void addProductToProductSet(
      AddProductToProductSetRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method AddProductToProductSet, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void removeProductFromProductSet(
      RemoveProductFromProductSetRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method RemoveProductFromProductSet, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listProductsInProductSet(
      ListProductsInProductSetRequest request,
      StreamObserver<ListProductsInProductSetResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListProductsInProductSetResponse) {
      requests.add(request);
      responseObserver.onNext(((ListProductsInProductSetResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListProductsInProductSet, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListProductsInProductSetResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void importProductSets(
      ImportProductSetsRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method ImportProductSets, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }
}
