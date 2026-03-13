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

package com.google.cloud.example.library.v1;

import com.google.api.core.BetaApi;
import com.google.example.library.v1.Book;
import com.google.example.library.v1.CreateBookRequest;
import com.google.example.library.v1.CreateShelfRequest;
import com.google.example.library.v1.DeleteBookRequest;
import com.google.example.library.v1.DeleteShelfRequest;
import com.google.example.library.v1.GetBookRequest;
import com.google.example.library.v1.GetShelfRequest;
import com.google.example.library.v1.LibraryServiceGrpc.LibraryServiceImplBase;
import com.google.example.library.v1.ListBooksRequest;
import com.google.example.library.v1.ListBooksResponse;
import com.google.example.library.v1.ListShelvesRequest;
import com.google.example.library.v1.ListShelvesResponse;
import com.google.example.library.v1.MergeShelvesRequest;
import com.google.example.library.v1.MoveBookRequest;
import com.google.example.library.v1.Shelf;
import com.google.example.library.v1.UpdateBookRequest;
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
public class MockLibraryServiceImpl extends LibraryServiceImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockLibraryServiceImpl() {
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
  public void createShelf(CreateShelfRequest request, StreamObserver<Shelf> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Shelf) {
      requests.add(request);
      responseObserver.onNext(((Shelf) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateShelf, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Shelf.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getShelf(GetShelfRequest request, StreamObserver<Shelf> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Shelf) {
      requests.add(request);
      responseObserver.onNext(((Shelf) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetShelf, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Shelf.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listShelves(
      ListShelvesRequest request, StreamObserver<ListShelvesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListShelvesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListShelvesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListShelves, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListShelvesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteShelf(DeleteShelfRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteShelf, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void mergeShelves(MergeShelvesRequest request, StreamObserver<Shelf> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Shelf) {
      requests.add(request);
      responseObserver.onNext(((Shelf) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method MergeShelves, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Shelf.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createBook(CreateBookRequest request, StreamObserver<Book> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Book) {
      requests.add(request);
      responseObserver.onNext(((Book) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateBook, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Book.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getBook(GetBookRequest request, StreamObserver<Book> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Book) {
      requests.add(request);
      responseObserver.onNext(((Book) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetBook, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Book.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listBooks(
      ListBooksRequest request, StreamObserver<ListBooksResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListBooksResponse) {
      requests.add(request);
      responseObserver.onNext(((ListBooksResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListBooks, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListBooksResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteBook(DeleteBookRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteBook, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateBook(UpdateBookRequest request, StreamObserver<Book> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Book) {
      requests.add(request);
      responseObserver.onNext(((Book) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateBook, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Book.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void moveBook(MoveBookRequest request, StreamObserver<Book> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Book) {
      requests.add(request);
      responseObserver.onNext(((Book) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method MoveBook, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Book.class.getName(),
                  Exception.class.getName())));
    }
  }
}
