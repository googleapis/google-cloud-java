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

import com.google.api.core.InternalApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.httpjson.ApiMethodDescriptor;
import com.google.api.gax.httpjson.HttpJsonCallSettings;
import com.google.api.gax.httpjson.HttpJsonStubCallableFactory;
import com.google.api.gax.httpjson.ProtoMessageRequestFormatter;
import com.google.api.gax.httpjson.ProtoMessageResponseParser;
import com.google.api.gax.httpjson.ProtoRestSerializer;
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
import com.google.protobuf.Empty;
import com.google.protobuf.TypeRegistry;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * REST stub implementation for the LibraryService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class HttpJsonLibraryServiceStub extends LibraryServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<CreateShelfRequest, Shelf> createShelfMethodDescriptor =
      ApiMethodDescriptor.<CreateShelfRequest, Shelf>newBuilder()
          .setFullMethodName("google.example.library.v1.LibraryService/CreateShelf")
          .setHttpMethod("POST")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<CreateShelfRequest>newBuilder()
                  .setPath(
                      "/v1/shelves",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<CreateShelfRequest> serializer =
                            ProtoRestSerializer.create();
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<CreateShelfRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(
                      request ->
                          ProtoRestSerializer.create().toBody("shelf", request.getShelf(), true))
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Shelf>newBuilder()
                  .setDefaultInstance(Shelf.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<GetShelfRequest, Shelf> getShelfMethodDescriptor =
      ApiMethodDescriptor.<GetShelfRequest, Shelf>newBuilder()
          .setFullMethodName("google.example.library.v1.LibraryService/GetShelf")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetShelfRequest>newBuilder()
                  .setPath(
                      "/v1/{name=shelves/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetShelfRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetShelfRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Shelf>newBuilder()
                  .setDefaultInstance(Shelf.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<ListShelvesRequest, ListShelvesResponse>
      listShelvesMethodDescriptor =
          ApiMethodDescriptor.<ListShelvesRequest, ListShelvesResponse>newBuilder()
              .setFullMethodName("google.example.library.v1.LibraryService/ListShelves")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListShelvesRequest>newBuilder()
                      .setPath(
                          "/v1/shelves",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListShelvesRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListShelvesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListShelvesResponse>newBuilder()
                      .setDefaultInstance(ListShelvesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteShelfRequest, Empty> deleteShelfMethodDescriptor =
      ApiMethodDescriptor.<DeleteShelfRequest, Empty>newBuilder()
          .setFullMethodName("google.example.library.v1.LibraryService/DeleteShelf")
          .setHttpMethod("DELETE")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<DeleteShelfRequest>newBuilder()
                  .setPath(
                      "/v1/{name=shelves/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<DeleteShelfRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<DeleteShelfRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Empty>newBuilder()
                  .setDefaultInstance(Empty.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<MergeShelvesRequest, Shelf>
      mergeShelvesMethodDescriptor =
          ApiMethodDescriptor.<MergeShelvesRequest, Shelf>newBuilder()
              .setFullMethodName("google.example.library.v1.LibraryService/MergeShelves")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<MergeShelvesRequest>newBuilder()
                      .setPath(
                          "/v1/{name=shelves/*}:merge",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<MergeShelvesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<MergeShelvesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearName().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Shelf>newBuilder()
                      .setDefaultInstance(Shelf.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateBookRequest, Book> createBookMethodDescriptor =
      ApiMethodDescriptor.<CreateBookRequest, Book>newBuilder()
          .setFullMethodName("google.example.library.v1.LibraryService/CreateBook")
          .setHttpMethod("POST")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<CreateBookRequest>newBuilder()
                  .setPath(
                      "/v1/{parent=shelves/*}/books",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<CreateBookRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "parent", request.getParent());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<CreateBookRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(
                      request ->
                          ProtoRestSerializer.create().toBody("book", request.getBook(), true))
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Book>newBuilder()
                  .setDefaultInstance(Book.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<GetBookRequest, Book> getBookMethodDescriptor =
      ApiMethodDescriptor.<GetBookRequest, Book>newBuilder()
          .setFullMethodName("google.example.library.v1.LibraryService/GetBook")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetBookRequest>newBuilder()
                  .setPath(
                      "/v1/{name=shelves/*/books/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetBookRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetBookRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Book>newBuilder()
                  .setDefaultInstance(Book.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<ListBooksRequest, ListBooksResponse>
      listBooksMethodDescriptor =
          ApiMethodDescriptor.<ListBooksRequest, ListBooksResponse>newBuilder()
              .setFullMethodName("google.example.library.v1.LibraryService/ListBooks")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListBooksRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=shelves/*}/books",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListBooksRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListBooksRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListBooksResponse>newBuilder()
                      .setDefaultInstance(ListBooksResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteBookRequest, Empty> deleteBookMethodDescriptor =
      ApiMethodDescriptor.<DeleteBookRequest, Empty>newBuilder()
          .setFullMethodName("google.example.library.v1.LibraryService/DeleteBook")
          .setHttpMethod("DELETE")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<DeleteBookRequest>newBuilder()
                  .setPath(
                      "/v1/{name=shelves/*/books/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<DeleteBookRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<DeleteBookRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Empty>newBuilder()
                  .setDefaultInstance(Empty.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<UpdateBookRequest, Book> updateBookMethodDescriptor =
      ApiMethodDescriptor.<UpdateBookRequest, Book>newBuilder()
          .setFullMethodName("google.example.library.v1.LibraryService/UpdateBook")
          .setHttpMethod("PATCH")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<UpdateBookRequest>newBuilder()
                  .setPath(
                      "/v1/{book.name=shelves/*/books/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<UpdateBookRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "book.name", request.getBook().getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<UpdateBookRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(
                      request ->
                          ProtoRestSerializer.create().toBody("book", request.getBook(), true))
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Book>newBuilder()
                  .setDefaultInstance(Book.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<MoveBookRequest, Book> moveBookMethodDescriptor =
      ApiMethodDescriptor.<MoveBookRequest, Book>newBuilder()
          .setFullMethodName("google.example.library.v1.LibraryService/MoveBook")
          .setHttpMethod("POST")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<MoveBookRequest>newBuilder()
                  .setPath(
                      "/v1/{name=shelves/*/books/*}:move",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<MoveBookRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<MoveBookRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(
                      request ->
                          ProtoRestSerializer.create()
                              .toBody("*", request.toBuilder().clearName().build(), true))
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Book>newBuilder()
                  .setDefaultInstance(Book.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
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
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonLibraryServiceStub create(LibraryServiceStubSettings settings)
      throws IOException {
    return new HttpJsonLibraryServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonLibraryServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonLibraryServiceStub(
        LibraryServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonLibraryServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonLibraryServiceStub(
        LibraryServiceStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonLibraryServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonLibraryServiceStub(
      LibraryServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonLibraryServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonLibraryServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonLibraryServiceStub(
      LibraryServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<CreateShelfRequest, Shelf> createShelfTransportSettings =
        HttpJsonCallSettings.<CreateShelfRequest, Shelf>newBuilder()
            .setMethodDescriptor(createShelfMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<GetShelfRequest, Shelf> getShelfTransportSettings =
        HttpJsonCallSettings.<GetShelfRequest, Shelf>newBuilder()
            .setMethodDescriptor(getShelfMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListShelvesRequest, ListShelvesResponse> listShelvesTransportSettings =
        HttpJsonCallSettings.<ListShelvesRequest, ListShelvesResponse>newBuilder()
            .setMethodDescriptor(listShelvesMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<DeleteShelfRequest, Empty> deleteShelfTransportSettings =
        HttpJsonCallSettings.<DeleteShelfRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteShelfMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<MergeShelvesRequest, Shelf> mergeShelvesTransportSettings =
        HttpJsonCallSettings.<MergeShelvesRequest, Shelf>newBuilder()
            .setMethodDescriptor(mergeShelvesMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<CreateBookRequest, Book> createBookTransportSettings =
        HttpJsonCallSettings.<CreateBookRequest, Book>newBuilder()
            .setMethodDescriptor(createBookMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<GetBookRequest, Book> getBookTransportSettings =
        HttpJsonCallSettings.<GetBookRequest, Book>newBuilder()
            .setMethodDescriptor(getBookMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListBooksRequest, ListBooksResponse> listBooksTransportSettings =
        HttpJsonCallSettings.<ListBooksRequest, ListBooksResponse>newBuilder()
            .setMethodDescriptor(listBooksMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeleteBookRequest, Empty> deleteBookTransportSettings =
        HttpJsonCallSettings.<DeleteBookRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteBookMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<UpdateBookRequest, Book> updateBookTransportSettings =
        HttpJsonCallSettings.<UpdateBookRequest, Book>newBuilder()
            .setMethodDescriptor(updateBookMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("book.name", String.valueOf(request.getBook().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<MoveBookRequest, Book> moveBookTransportSettings =
        HttpJsonCallSettings.<MoveBookRequest, Book>newBuilder()
            .setMethodDescriptor(moveBookMethodDescriptor)
            .setTypeRegistry(typeRegistry)
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

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(createShelfMethodDescriptor);
    methodDescriptors.add(getShelfMethodDescriptor);
    methodDescriptors.add(listShelvesMethodDescriptor);
    methodDescriptors.add(deleteShelfMethodDescriptor);
    methodDescriptors.add(mergeShelvesMethodDescriptor);
    methodDescriptors.add(createBookMethodDescriptor);
    methodDescriptors.add(getBookMethodDescriptor);
    methodDescriptors.add(listBooksMethodDescriptor);
    methodDescriptors.add(deleteBookMethodDescriptor);
    methodDescriptors.add(updateBookMethodDescriptor);
    methodDescriptors.add(moveBookMethodDescriptor);
    return methodDescriptors;
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
