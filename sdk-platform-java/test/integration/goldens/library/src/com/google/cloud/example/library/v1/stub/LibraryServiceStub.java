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

package com.google.cloud.example.library.v1.stub;

import static com.google.cloud.example.library.v1.LibraryServiceClient.ListBooksPagedResponse;
import static com.google.cloud.example.library.v1.LibraryServiceClient.ListShelvesPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.example.library.v1.Book;
import com.google.example.library.v1.CreateBookRequest;
import com.google.example.library.v1.CreateShelfRequest;
import com.google.example.library.v1.DeleteBookRequest;
import com.google.example.library.v1.DeleteShelfRequest;
import com.google.example.library.v1.GetBookRequest;
import com.google.example.library.v1.GetShelfRequest;
import com.google.example.library.v1.ListBooksRequest;
import com.google.example.library.v1.ListBooksResponse;
import com.google.example.library.v1.ListShelvesRequest;
import com.google.example.library.v1.ListShelvesResponse;
import com.google.example.library.v1.MergeShelvesRequest;
import com.google.example.library.v1.MoveBookRequest;
import com.google.example.library.v1.Shelf;
import com.google.example.library.v1.UpdateBookRequest;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the LibraryService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class LibraryServiceStub implements BackgroundResource {

  public UnaryCallable<CreateShelfRequest, Shelf> createShelfCallable() {
    throw new UnsupportedOperationException("Not implemented: createShelfCallable()");
  }

  public UnaryCallable<GetShelfRequest, Shelf> getShelfCallable() {
    throw new UnsupportedOperationException("Not implemented: getShelfCallable()");
  }

  public UnaryCallable<ListShelvesRequest, ListShelvesPagedResponse> listShelvesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listShelvesPagedCallable()");
  }

  public UnaryCallable<ListShelvesRequest, ListShelvesResponse> listShelvesCallable() {
    throw new UnsupportedOperationException("Not implemented: listShelvesCallable()");
  }

  public UnaryCallable<DeleteShelfRequest, Empty> deleteShelfCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteShelfCallable()");
  }

  public UnaryCallable<MergeShelvesRequest, Shelf> mergeShelvesCallable() {
    throw new UnsupportedOperationException("Not implemented: mergeShelvesCallable()");
  }

  public UnaryCallable<CreateBookRequest, Book> createBookCallable() {
    throw new UnsupportedOperationException("Not implemented: createBookCallable()");
  }

  public UnaryCallable<GetBookRequest, Book> getBookCallable() {
    throw new UnsupportedOperationException("Not implemented: getBookCallable()");
  }

  public UnaryCallable<ListBooksRequest, ListBooksPagedResponse> listBooksPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listBooksPagedCallable()");
  }

  public UnaryCallable<ListBooksRequest, ListBooksResponse> listBooksCallable() {
    throw new UnsupportedOperationException("Not implemented: listBooksCallable()");
  }

  public UnaryCallable<DeleteBookRequest, Empty> deleteBookCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteBookCallable()");
  }

  public UnaryCallable<UpdateBookRequest, Book> updateBookCallable() {
    throw new UnsupportedOperationException("Not implemented: updateBookCallable()");
  }

  public UnaryCallable<MoveBookRequest, Book> moveBookCallable() {
    throw new UnsupportedOperationException("Not implemented: moveBookCallable()");
  }

  @Override
  public abstract void close();
}
