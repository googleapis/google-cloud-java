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

package com.google.cloud.vectorsearch.v1beta.stub;

import static com.google.cloud.vectorsearch.v1beta.DataObjectServiceClient.ListLocationsPagedResponse;

import com.google.api.core.BetaApi;
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
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.cloud.vectorsearch.v1beta.BatchCreateDataObjectsRequest;
import com.google.cloud.vectorsearch.v1beta.BatchCreateDataObjectsResponse;
import com.google.cloud.vectorsearch.v1beta.BatchDeleteDataObjectsRequest;
import com.google.cloud.vectorsearch.v1beta.BatchUpdateDataObjectsRequest;
import com.google.cloud.vectorsearch.v1beta.BatchUpdateDataObjectsResponse;
import com.google.cloud.vectorsearch.v1beta.CreateDataObjectRequest;
import com.google.cloud.vectorsearch.v1beta.DataObject;
import com.google.cloud.vectorsearch.v1beta.DeleteDataObjectRequest;
import com.google.cloud.vectorsearch.v1beta.GetDataObjectRequest;
import com.google.cloud.vectorsearch.v1beta.UpdateDataObjectRequest;
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
 * REST stub implementation for the DataObjectService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class HttpJsonDataObjectServiceStub extends DataObjectServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<CreateDataObjectRequest, DataObject>
      createDataObjectMethodDescriptor =
          ApiMethodDescriptor.<CreateDataObjectRequest, DataObject>newBuilder()
              .setFullMethodName(
                  "google.cloud.vectorsearch.v1beta.DataObjectService/CreateDataObject")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateDataObjectRequest>newBuilder()
                      .setPath(
                          "/v1beta/{parent=projects/*/locations/*/collections/*}/dataObjects",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateDataObjectRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateDataObjectRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "dataObjectId", request.getDataObjectId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("dataObject", request.getDataObject(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<DataObject>newBuilder()
                      .setDefaultInstance(DataObject.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          BatchCreateDataObjectsRequest, BatchCreateDataObjectsResponse>
      batchCreateDataObjectsMethodDescriptor =
          ApiMethodDescriptor
              .<BatchCreateDataObjectsRequest, BatchCreateDataObjectsResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.vectorsearch.v1beta.DataObjectService/BatchCreateDataObjects")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BatchCreateDataObjectsRequest>newBuilder()
                      .setPath(
                          "/v1beta/{parent=projects/*/locations/*/collections/*}/dataObjects:batchCreate",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchCreateDataObjectsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchCreateDataObjectsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearParent().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<BatchCreateDataObjectsResponse>newBuilder()
                      .setDefaultInstance(BatchCreateDataObjectsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetDataObjectRequest, DataObject>
      getDataObjectMethodDescriptor =
          ApiMethodDescriptor.<GetDataObjectRequest, DataObject>newBuilder()
              .setFullMethodName("google.cloud.vectorsearch.v1beta.DataObjectService/GetDataObject")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetDataObjectRequest>newBuilder()
                      .setPath(
                          "/v1beta/{name=projects/*/locations/*/collections/*/dataObjects/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetDataObjectRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetDataObjectRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<DataObject>newBuilder()
                      .setDefaultInstance(DataObject.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateDataObjectRequest, DataObject>
      updateDataObjectMethodDescriptor =
          ApiMethodDescriptor.<UpdateDataObjectRequest, DataObject>newBuilder()
              .setFullMethodName(
                  "google.cloud.vectorsearch.v1beta.DataObjectService/UpdateDataObject")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateDataObjectRequest>newBuilder()
                      .setPath(
                          "/v1beta/{dataObject.name=projects/*/locations/*/collections/*/dataObjects/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateDataObjectRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "dataObject.name", request.getDataObject().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateDataObjectRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("dataObject", request.getDataObject(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<DataObject>newBuilder()
                      .setDefaultInstance(DataObject.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          BatchUpdateDataObjectsRequest, BatchUpdateDataObjectsResponse>
      batchUpdateDataObjectsMethodDescriptor =
          ApiMethodDescriptor
              .<BatchUpdateDataObjectsRequest, BatchUpdateDataObjectsResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.vectorsearch.v1beta.DataObjectService/BatchUpdateDataObjects")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BatchUpdateDataObjectsRequest>newBuilder()
                      .setPath(
                          "/v1beta/{parent=projects/*/locations/*/collections/*}/dataObjects:batchUpdate",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchUpdateDataObjectsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchUpdateDataObjectsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearParent().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<BatchUpdateDataObjectsResponse>newBuilder()
                      .setDefaultInstance(BatchUpdateDataObjectsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteDataObjectRequest, Empty>
      deleteDataObjectMethodDescriptor =
          ApiMethodDescriptor.<DeleteDataObjectRequest, Empty>newBuilder()
              .setFullMethodName(
                  "google.cloud.vectorsearch.v1beta.DataObjectService/DeleteDataObject")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteDataObjectRequest>newBuilder()
                      .setPath(
                          "/v1beta/{name=projects/*/locations/*/collections/*/dataObjects/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteDataObjectRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteDataObjectRequest> serializer =
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

  private static final ApiMethodDescriptor<BatchDeleteDataObjectsRequest, Empty>
      batchDeleteDataObjectsMethodDescriptor =
          ApiMethodDescriptor.<BatchDeleteDataObjectsRequest, Empty>newBuilder()
              .setFullMethodName(
                  "google.cloud.vectorsearch.v1beta.DataObjectService/BatchDeleteDataObjects")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BatchDeleteDataObjectsRequest>newBuilder()
                      .setPath(
                          "/v1beta/{parent=projects/*/locations/*/collections/*}/dataObjects:batchDelete",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchDeleteDataObjectsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchDeleteDataObjectsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearParent().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Empty>newBuilder()
                      .setDefaultInstance(Empty.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListLocationsRequest, ListLocationsResponse>
      listLocationsMethodDescriptor =
          ApiMethodDescriptor.<ListLocationsRequest, ListLocationsResponse>newBuilder()
              .setFullMethodName("google.cloud.location.Locations/ListLocations")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListLocationsRequest>newBuilder()
                      .setPath(
                          "/v1beta/{name=projects/*}/locations",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListLocationsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListLocationsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListLocationsResponse>newBuilder()
                      .setDefaultInstance(ListLocationsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetLocationRequest, Location>
      getLocationMethodDescriptor =
          ApiMethodDescriptor.<GetLocationRequest, Location>newBuilder()
              .setFullMethodName("google.cloud.location.Locations/GetLocation")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetLocationRequest>newBuilder()
                      .setPath(
                          "/v1beta/{name=projects/*/locations/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetLocationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetLocationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Location>newBuilder()
                      .setDefaultInstance(Location.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<CreateDataObjectRequest, DataObject> createDataObjectCallable;
  private final UnaryCallable<BatchCreateDataObjectsRequest, BatchCreateDataObjectsResponse>
      batchCreateDataObjectsCallable;
  private final UnaryCallable<GetDataObjectRequest, DataObject> getDataObjectCallable;
  private final UnaryCallable<UpdateDataObjectRequest, DataObject> updateDataObjectCallable;
  private final UnaryCallable<BatchUpdateDataObjectsRequest, BatchUpdateDataObjectsResponse>
      batchUpdateDataObjectsCallable;
  private final UnaryCallable<DeleteDataObjectRequest, Empty> deleteDataObjectCallable;
  private final UnaryCallable<BatchDeleteDataObjectsRequest, Empty> batchDeleteDataObjectsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonDataObjectServiceStub create(DataObjectServiceStubSettings settings)
      throws IOException {
    return new HttpJsonDataObjectServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonDataObjectServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonDataObjectServiceStub(
        DataObjectServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonDataObjectServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonDataObjectServiceStub(
        DataObjectServiceStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonDataObjectServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonDataObjectServiceStub(
      DataObjectServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonDataObjectServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonDataObjectServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonDataObjectServiceStub(
      DataObjectServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<CreateDataObjectRequest, DataObject> createDataObjectTransportSettings =
        HttpJsonCallSettings.<CreateDataObjectRequest, DataObject>newBuilder()
            .setMethodDescriptor(createDataObjectMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<BatchCreateDataObjectsRequest, BatchCreateDataObjectsResponse>
        batchCreateDataObjectsTransportSettings =
            HttpJsonCallSettings
                .<BatchCreateDataObjectsRequest, BatchCreateDataObjectsResponse>newBuilder()
                .setMethodDescriptor(batchCreateDataObjectsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetDataObjectRequest, DataObject> getDataObjectTransportSettings =
        HttpJsonCallSettings.<GetDataObjectRequest, DataObject>newBuilder()
            .setMethodDescriptor(getDataObjectMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<UpdateDataObjectRequest, DataObject> updateDataObjectTransportSettings =
        HttpJsonCallSettings.<UpdateDataObjectRequest, DataObject>newBuilder()
            .setMethodDescriptor(updateDataObjectMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(
                      "data_object.name", String.valueOf(request.getDataObject().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<BatchUpdateDataObjectsRequest, BatchUpdateDataObjectsResponse>
        batchUpdateDataObjectsTransportSettings =
            HttpJsonCallSettings
                .<BatchUpdateDataObjectsRequest, BatchUpdateDataObjectsResponse>newBuilder()
                .setMethodDescriptor(batchUpdateDataObjectsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<DeleteDataObjectRequest, Empty> deleteDataObjectTransportSettings =
        HttpJsonCallSettings.<DeleteDataObjectRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteDataObjectMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<BatchDeleteDataObjectsRequest, Empty>
        batchDeleteDataObjectsTransportSettings =
            HttpJsonCallSettings.<BatchDeleteDataObjectsRequest, Empty>newBuilder()
                .setMethodDescriptor(batchDeleteDataObjectsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListLocationsRequest, ListLocationsResponse>
        listLocationsTransportSettings =
            HttpJsonCallSettings.<ListLocationsRequest, ListLocationsResponse>newBuilder()
                .setMethodDescriptor(listLocationsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetLocationRequest, Location> getLocationTransportSettings =
        HttpJsonCallSettings.<GetLocationRequest, Location>newBuilder()
            .setMethodDescriptor(getLocationMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();

    this.createDataObjectCallable =
        callableFactory.createUnaryCallable(
            createDataObjectTransportSettings, settings.createDataObjectSettings(), clientContext);
    this.batchCreateDataObjectsCallable =
        callableFactory.createUnaryCallable(
            batchCreateDataObjectsTransportSettings,
            settings.batchCreateDataObjectsSettings(),
            clientContext);
    this.getDataObjectCallable =
        callableFactory.createUnaryCallable(
            getDataObjectTransportSettings, settings.getDataObjectSettings(), clientContext);
    this.updateDataObjectCallable =
        callableFactory.createUnaryCallable(
            updateDataObjectTransportSettings, settings.updateDataObjectSettings(), clientContext);
    this.batchUpdateDataObjectsCallable =
        callableFactory.createUnaryCallable(
            batchUpdateDataObjectsTransportSettings,
            settings.batchUpdateDataObjectsSettings(),
            clientContext);
    this.deleteDataObjectCallable =
        callableFactory.createUnaryCallable(
            deleteDataObjectTransportSettings, settings.deleteDataObjectSettings(), clientContext);
    this.batchDeleteDataObjectsCallable =
        callableFactory.createUnaryCallable(
            batchDeleteDataObjectsTransportSettings,
            settings.batchDeleteDataObjectsSettings(),
            clientContext);
    this.listLocationsCallable =
        callableFactory.createUnaryCallable(
            listLocationsTransportSettings, settings.listLocationsSettings(), clientContext);
    this.listLocationsPagedCallable =
        callableFactory.createPagedCallable(
            listLocationsTransportSettings, settings.listLocationsSettings(), clientContext);
    this.getLocationCallable =
        callableFactory.createUnaryCallable(
            getLocationTransportSettings, settings.getLocationSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(createDataObjectMethodDescriptor);
    methodDescriptors.add(batchCreateDataObjectsMethodDescriptor);
    methodDescriptors.add(getDataObjectMethodDescriptor);
    methodDescriptors.add(updateDataObjectMethodDescriptor);
    methodDescriptors.add(batchUpdateDataObjectsMethodDescriptor);
    methodDescriptors.add(deleteDataObjectMethodDescriptor);
    methodDescriptors.add(batchDeleteDataObjectsMethodDescriptor);
    methodDescriptors.add(listLocationsMethodDescriptor);
    methodDescriptors.add(getLocationMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<CreateDataObjectRequest, DataObject> createDataObjectCallable() {
    return createDataObjectCallable;
  }

  @Override
  public UnaryCallable<BatchCreateDataObjectsRequest, BatchCreateDataObjectsResponse>
      batchCreateDataObjectsCallable() {
    return batchCreateDataObjectsCallable;
  }

  @Override
  public UnaryCallable<GetDataObjectRequest, DataObject> getDataObjectCallable() {
    return getDataObjectCallable;
  }

  @Override
  public UnaryCallable<UpdateDataObjectRequest, DataObject> updateDataObjectCallable() {
    return updateDataObjectCallable;
  }

  @Override
  public UnaryCallable<BatchUpdateDataObjectsRequest, BatchUpdateDataObjectsResponse>
      batchUpdateDataObjectsCallable() {
    return batchUpdateDataObjectsCallable;
  }

  @Override
  public UnaryCallable<DeleteDataObjectRequest, Empty> deleteDataObjectCallable() {
    return deleteDataObjectCallable;
  }

  @Override
  public UnaryCallable<BatchDeleteDataObjectsRequest, Empty> batchDeleteDataObjectsCallable() {
    return batchDeleteDataObjectsCallable;
  }

  @Override
  public UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable() {
    return listLocationsCallable;
  }

  @Override
  public UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable() {
    return listLocationsPagedCallable;
  }

  @Override
  public UnaryCallable<GetLocationRequest, Location> getLocationCallable() {
    return getLocationCallable;
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
