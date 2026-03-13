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
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsBuilder;
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
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.protobuf.Empty;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the LibraryService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcLibraryServiceStub extends LibraryServiceStub {
  private static final MethodDescriptor<CreateShelfRequest, Shelf> createShelfMethodDescriptor =
      MethodDescriptor.<CreateShelfRequest, Shelf>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.example.library.v1.LibraryService/CreateShelf")
          .setRequestMarshaller(ProtoUtils.marshaller(CreateShelfRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Shelf.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<GetShelfRequest, Shelf> getShelfMethodDescriptor =
      MethodDescriptor.<GetShelfRequest, Shelf>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.example.library.v1.LibraryService/GetShelf")
          .setRequestMarshaller(ProtoUtils.marshaller(GetShelfRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Shelf.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<ListShelvesRequest, ListShelvesResponse>
      listShelvesMethodDescriptor =
          MethodDescriptor.<ListShelvesRequest, ListShelvesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.example.library.v1.LibraryService/ListShelves")
              .setRequestMarshaller(ProtoUtils.marshaller(ListShelvesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListShelvesResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteShelfRequest, Empty> deleteShelfMethodDescriptor =
      MethodDescriptor.<DeleteShelfRequest, Empty>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.example.library.v1.LibraryService/DeleteShelf")
          .setRequestMarshaller(ProtoUtils.marshaller(DeleteShelfRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<MergeShelvesRequest, Shelf> mergeShelvesMethodDescriptor =
      MethodDescriptor.<MergeShelvesRequest, Shelf>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.example.library.v1.LibraryService/MergeShelves")
          .setRequestMarshaller(ProtoUtils.marshaller(MergeShelvesRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Shelf.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<CreateBookRequest, Book> createBookMethodDescriptor =
      MethodDescriptor.<CreateBookRequest, Book>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.example.library.v1.LibraryService/CreateBook")
          .setRequestMarshaller(ProtoUtils.marshaller(CreateBookRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Book.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<GetBookRequest, Book> getBookMethodDescriptor =
      MethodDescriptor.<GetBookRequest, Book>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.example.library.v1.LibraryService/GetBook")
          .setRequestMarshaller(ProtoUtils.marshaller(GetBookRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Book.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<ListBooksRequest, ListBooksResponse>
      listBooksMethodDescriptor =
          MethodDescriptor.<ListBooksRequest, ListBooksResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.example.library.v1.LibraryService/ListBooks")
              .setRequestMarshaller(ProtoUtils.marshaller(ListBooksRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ListBooksResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteBookRequest, Empty> deleteBookMethodDescriptor =
      MethodDescriptor.<DeleteBookRequest, Empty>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.example.library.v1.LibraryService/DeleteBook")
          .setRequestMarshaller(ProtoUtils.marshaller(DeleteBookRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<UpdateBookRequest, Book> updateBookMethodDescriptor =
      MethodDescriptor.<UpdateBookRequest, Book>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.example.library.v1.LibraryService/UpdateBook")
          .setRequestMarshaller(ProtoUtils.marshaller(UpdateBookRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Book.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<MoveBookRequest, Book> moveBookMethodDescriptor =
      MethodDescriptor.<MoveBookRequest, Book>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.example.library.v1.LibraryService/MoveBook")
          .setRequestMarshaller(ProtoUtils.marshaller(MoveBookRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Book.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private final UnaryCallable<CreateShelfRequest, Shelf> createShelfCallable;
  private final UnaryCallable<GetShelfRequest, Shelf> getShelfCallable;
  private final UnaryCallable<ListShelvesRequest, ListShelvesResponse> listShelvesCallable;
  private final UnaryCallable<ListShelvesRequest, ListShelvesPagedResponse>
      listShelvesPagedCallable;
  private final UnaryCallable<DeleteShelfRequest, Empty> deleteShelfCallable;
  private final UnaryCallable<MergeShelvesRequest, Shelf> mergeShelvesCallable;
  private final UnaryCallable<CreateBookRequest, Book> createBookCallable;
  private final UnaryCallable<GetBookRequest, Book> getBookCallable;
  private final UnaryCallable<ListBooksRequest, ListBooksResponse> listBooksCallable;
  private final UnaryCallable<ListBooksRequest, ListBooksPagedResponse> listBooksPagedCallable;
  private final UnaryCallable<DeleteBookRequest, Empty> deleteBookCallable;
  private final UnaryCallable<UpdateBookRequest, Book> updateBookCallable;
  private final UnaryCallable<MoveBookRequest, Book> moveBookCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcLibraryServiceStub create(LibraryServiceStubSettings settings)
      throws IOException {
    return new GrpcLibraryServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcLibraryServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcLibraryServiceStub(
        LibraryServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcLibraryServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcLibraryServiceStub(
        LibraryServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcLibraryServiceStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcLibraryServiceStub(LibraryServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcLibraryServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcLibraryServiceStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcLibraryServiceStub(
      LibraryServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<CreateShelfRequest, Shelf> createShelfTransportSettings =
        GrpcCallSettings.<CreateShelfRequest, Shelf>newBuilder()
            .setMethodDescriptor(createShelfMethodDescriptor)
            .build();
    GrpcCallSettings<GetShelfRequest, Shelf> getShelfTransportSettings =
        GrpcCallSettings.<GetShelfRequest, Shelf>newBuilder()
            .setMethodDescriptor(getShelfMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListShelvesRequest, ListShelvesResponse> listShelvesTransportSettings =
        GrpcCallSettings.<ListShelvesRequest, ListShelvesResponse>newBuilder()
            .setMethodDescriptor(listShelvesMethodDescriptor)
            .build();
    GrpcCallSettings<DeleteShelfRequest, Empty> deleteShelfTransportSettings =
        GrpcCallSettings.<DeleteShelfRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteShelfMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<MergeShelvesRequest, Shelf> mergeShelvesTransportSettings =
        GrpcCallSettings.<MergeShelvesRequest, Shelf>newBuilder()
            .setMethodDescriptor(mergeShelvesMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateBookRequest, Book> createBookTransportSettings =
        GrpcCallSettings.<CreateBookRequest, Book>newBuilder()
            .setMethodDescriptor(createBookMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetBookRequest, Book> getBookTransportSettings =
        GrpcCallSettings.<GetBookRequest, Book>newBuilder()
            .setMethodDescriptor(getBookMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListBooksRequest, ListBooksResponse> listBooksTransportSettings =
        GrpcCallSettings.<ListBooksRequest, ListBooksResponse>newBuilder()
            .setMethodDescriptor(listBooksMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteBookRequest, Empty> deleteBookTransportSettings =
        GrpcCallSettings.<DeleteBookRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteBookMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateBookRequest, Book> updateBookTransportSettings =
        GrpcCallSettings.<UpdateBookRequest, Book>newBuilder()
            .setMethodDescriptor(updateBookMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("book.name", String.valueOf(request.getBook().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<MoveBookRequest, Book> moveBookTransportSettings =
        GrpcCallSettings.<MoveBookRequest, Book>newBuilder()
            .setMethodDescriptor(moveBookMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();

    this.createShelfCallable =
        callableFactory.createUnaryCallable(
            createShelfTransportSettings, settings.createShelfSettings(), clientContext);
    this.getShelfCallable =
        callableFactory.createUnaryCallable(
            getShelfTransportSettings, settings.getShelfSettings(), clientContext);
    this.listShelvesCallable =
        callableFactory.createUnaryCallable(
            listShelvesTransportSettings, settings.listShelvesSettings(), clientContext);
    this.listShelvesPagedCallable =
        callableFactory.createPagedCallable(
            listShelvesTransportSettings, settings.listShelvesSettings(), clientContext);
    this.deleteShelfCallable =
        callableFactory.createUnaryCallable(
            deleteShelfTransportSettings, settings.deleteShelfSettings(), clientContext);
    this.mergeShelvesCallable =
        callableFactory.createUnaryCallable(
            mergeShelvesTransportSettings, settings.mergeShelvesSettings(), clientContext);
    this.createBookCallable =
        callableFactory.createUnaryCallable(
            createBookTransportSettings, settings.createBookSettings(), clientContext);
    this.getBookCallable =
        callableFactory.createUnaryCallable(
            getBookTransportSettings, settings.getBookSettings(), clientContext);
    this.listBooksCallable =
        callableFactory.createUnaryCallable(
            listBooksTransportSettings, settings.listBooksSettings(), clientContext);
    this.listBooksPagedCallable =
        callableFactory.createPagedCallable(
            listBooksTransportSettings, settings.listBooksSettings(), clientContext);
    this.deleteBookCallable =
        callableFactory.createUnaryCallable(
            deleteBookTransportSettings, settings.deleteBookSettings(), clientContext);
    this.updateBookCallable =
        callableFactory.createUnaryCallable(
            updateBookTransportSettings, settings.updateBookSettings(), clientContext);
    this.moveBookCallable =
        callableFactory.createUnaryCallable(
            moveBookTransportSettings, settings.moveBookSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<CreateShelfRequest, Shelf> createShelfCallable() {
    return createShelfCallable;
  }

  @Override
  public UnaryCallable<GetShelfRequest, Shelf> getShelfCallable() {
    return getShelfCallable;
  }

  @Override
  public UnaryCallable<ListShelvesRequest, ListShelvesResponse> listShelvesCallable() {
    return listShelvesCallable;
  }

  @Override
  public UnaryCallable<ListShelvesRequest, ListShelvesPagedResponse> listShelvesPagedCallable() {
    return listShelvesPagedCallable;
  }

  @Override
  public UnaryCallable<DeleteShelfRequest, Empty> deleteShelfCallable() {
    return deleteShelfCallable;
  }

  @Override
  public UnaryCallable<MergeShelvesRequest, Shelf> mergeShelvesCallable() {
    return mergeShelvesCallable;
  }

  @Override
  public UnaryCallable<CreateBookRequest, Book> createBookCallable() {
    return createBookCallable;
  }

  @Override
  public UnaryCallable<GetBookRequest, Book> getBookCallable() {
    return getBookCallable;
  }

  @Override
  public UnaryCallable<ListBooksRequest, ListBooksResponse> listBooksCallable() {
    return listBooksCallable;
  }

  @Override
  public UnaryCallable<ListBooksRequest, ListBooksPagedResponse> listBooksPagedCallable() {
    return listBooksPagedCallable;
  }

  @Override
  public UnaryCallable<DeleteBookRequest, Empty> deleteBookCallable() {
    return deleteBookCallable;
  }

  @Override
  public UnaryCallable<UpdateBookRequest, Book> updateBookCallable() {
    return updateBookCallable;
  }

  @Override
  public UnaryCallable<MoveBookRequest, Book> moveBookCallable() {
    return moveBookCallable;
  }

  @Override
  public final void close() {
    try {
      backgroundResources.close();
    } catch (RuntimeException e) {
      throw e;
    } catch (Exception e) {
      throw new IllegalStateException("Failed to close resource", e);
    }
  }

  @Override
  public void shutdown() {
    backgroundResources.shutdown();
  }

  @Override
  public boolean isShutdown() {
    return backgroundResources.isShutdown();
  }

  @Override
  public boolean isTerminated() {
    return backgroundResources.isTerminated();
  }

  @Override
  public void shutdownNow() {
    backgroundResources.shutdownNow();
  }

  @Override
  public boolean awaitTermination(long duration, TimeUnit unit) throws InterruptedException {
    return backgroundResources.awaitTermination(duration, unit);
  }
}
