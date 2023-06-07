/*
 * Copyright 2023 Google LLC
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

package com.google.maps.mapsplatformdatasets.v1.stub;

import static com.google.maps.mapsplatformdatasets.v1.MapsPlatformDatasetsClient.ListDatasetsPagedResponse;

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
import com.google.maps.mapsplatformdatasets.v1.CreateDatasetRequest;
import com.google.maps.mapsplatformdatasets.v1.Dataset;
import com.google.maps.mapsplatformdatasets.v1.DeleteDatasetRequest;
import com.google.maps.mapsplatformdatasets.v1.GetDatasetRequest;
import com.google.maps.mapsplatformdatasets.v1.ListDatasetsRequest;
import com.google.maps.mapsplatformdatasets.v1.ListDatasetsResponse;
import com.google.maps.mapsplatformdatasets.v1.UpdateDatasetMetadataRequest;
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
 * REST stub implementation for the MapsPlatformDatasets service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
@BetaApi
public class HttpJsonMapsPlatformDatasetsStub extends MapsPlatformDatasetsStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<CreateDatasetRequest, Dataset>
      createDatasetMethodDescriptor =
          ApiMethodDescriptor.<CreateDatasetRequest, Dataset>newBuilder()
              .setFullMethodName(
                  "google.maps.mapsplatformdatasets.v1.MapsPlatformDatasets/CreateDataset")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateDatasetRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*}/datasets",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateDatasetRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateDatasetRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("dataset", request.getDataset(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Dataset>newBuilder()
                      .setDefaultInstance(Dataset.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateDatasetMetadataRequest, Dataset>
      updateDatasetMetadataMethodDescriptor =
          ApiMethodDescriptor.<UpdateDatasetMetadataRequest, Dataset>newBuilder()
              .setFullMethodName(
                  "google.maps.mapsplatformdatasets.v1.MapsPlatformDatasets/UpdateDatasetMetadata")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateDatasetMetadataRequest>newBuilder()
                      .setPath(
                          "/v1/{dataset.name=projects/*/datasets/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateDatasetMetadataRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "dataset.name", request.getDataset().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateDatasetMetadataRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("dataset", request.getDataset(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Dataset>newBuilder()
                      .setDefaultInstance(Dataset.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetDatasetRequest, Dataset> getDatasetMethodDescriptor =
      ApiMethodDescriptor.<GetDatasetRequest, Dataset>newBuilder()
          .setFullMethodName("google.maps.mapsplatformdatasets.v1.MapsPlatformDatasets/GetDataset")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetDatasetRequest>newBuilder()
                  .setPath(
                      "/v1/{name=projects/*/datasets/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetDatasetRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetDatasetRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Dataset>newBuilder()
                  .setDefaultInstance(Dataset.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<ListDatasetsRequest, ListDatasetsResponse>
      listDatasetsMethodDescriptor =
          ApiMethodDescriptor.<ListDatasetsRequest, ListDatasetsResponse>newBuilder()
              .setFullMethodName(
                  "google.maps.mapsplatformdatasets.v1.MapsPlatformDatasets/ListDatasets")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListDatasetsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*}/datasets",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListDatasetsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListDatasetsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListDatasetsResponse>newBuilder()
                      .setDefaultInstance(ListDatasetsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteDatasetRequest, Empty>
      deleteDatasetMethodDescriptor =
          ApiMethodDescriptor.<DeleteDatasetRequest, Empty>newBuilder()
              .setFullMethodName(
                  "google.maps.mapsplatformdatasets.v1.MapsPlatformDatasets/DeleteDataset")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteDatasetRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/datasets/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteDatasetRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteDatasetRequest> serializer =
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

  private final UnaryCallable<CreateDatasetRequest, Dataset> createDatasetCallable;
  private final UnaryCallable<UpdateDatasetMetadataRequest, Dataset> updateDatasetMetadataCallable;
  private final UnaryCallable<GetDatasetRequest, Dataset> getDatasetCallable;
  private final UnaryCallable<ListDatasetsRequest, ListDatasetsResponse> listDatasetsCallable;
  private final UnaryCallable<ListDatasetsRequest, ListDatasetsPagedResponse>
      listDatasetsPagedCallable;
  private final UnaryCallable<DeleteDatasetRequest, Empty> deleteDatasetCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonMapsPlatformDatasetsStub create(
      MapsPlatformDatasetsStubSettings settings) throws IOException {
    return new HttpJsonMapsPlatformDatasetsStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonMapsPlatformDatasetsStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonMapsPlatformDatasetsStub(
        MapsPlatformDatasetsStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonMapsPlatformDatasetsStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonMapsPlatformDatasetsStub(
        MapsPlatformDatasetsStubSettings.newHttpJsonBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonMapsPlatformDatasetsStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonMapsPlatformDatasetsStub(
      MapsPlatformDatasetsStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonMapsPlatformDatasetsCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonMapsPlatformDatasetsStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonMapsPlatformDatasetsStub(
      MapsPlatformDatasetsStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<CreateDatasetRequest, Dataset> createDatasetTransportSettings =
        HttpJsonCallSettings.<CreateDatasetRequest, Dataset>newBuilder()
            .setMethodDescriptor(createDatasetMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<UpdateDatasetMetadataRequest, Dataset>
        updateDatasetMetadataTransportSettings =
            HttpJsonCallSettings.<UpdateDatasetMetadataRequest, Dataset>newBuilder()
                .setMethodDescriptor(updateDatasetMetadataMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("dataset.name", String.valueOf(request.getDataset().getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetDatasetRequest, Dataset> getDatasetTransportSettings =
        HttpJsonCallSettings.<GetDatasetRequest, Dataset>newBuilder()
            .setMethodDescriptor(getDatasetMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListDatasetsRequest, ListDatasetsResponse> listDatasetsTransportSettings =
        HttpJsonCallSettings.<ListDatasetsRequest, ListDatasetsResponse>newBuilder()
            .setMethodDescriptor(listDatasetsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeleteDatasetRequest, Empty> deleteDatasetTransportSettings =
        HttpJsonCallSettings.<DeleteDatasetRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteDatasetMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();

    this.createDatasetCallable =
        callableFactory.createUnaryCallable(
            createDatasetTransportSettings, settings.createDatasetSettings(), clientContext);
    this.updateDatasetMetadataCallable =
        callableFactory.createUnaryCallable(
            updateDatasetMetadataTransportSettings,
            settings.updateDatasetMetadataSettings(),
            clientContext);
    this.getDatasetCallable =
        callableFactory.createUnaryCallable(
            getDatasetTransportSettings, settings.getDatasetSettings(), clientContext);
    this.listDatasetsCallable =
        callableFactory.createUnaryCallable(
            listDatasetsTransportSettings, settings.listDatasetsSettings(), clientContext);
    this.listDatasetsPagedCallable =
        callableFactory.createPagedCallable(
            listDatasetsTransportSettings, settings.listDatasetsSettings(), clientContext);
    this.deleteDatasetCallable =
        callableFactory.createUnaryCallable(
            deleteDatasetTransportSettings, settings.deleteDatasetSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(createDatasetMethodDescriptor);
    methodDescriptors.add(updateDatasetMetadataMethodDescriptor);
    methodDescriptors.add(getDatasetMethodDescriptor);
    methodDescriptors.add(listDatasetsMethodDescriptor);
    methodDescriptors.add(deleteDatasetMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<CreateDatasetRequest, Dataset> createDatasetCallable() {
    return createDatasetCallable;
  }

  @Override
  public UnaryCallable<UpdateDatasetMetadataRequest, Dataset> updateDatasetMetadataCallable() {
    return updateDatasetMetadataCallable;
  }

  @Override
  public UnaryCallable<GetDatasetRequest, Dataset> getDatasetCallable() {
    return getDatasetCallable;
  }

  @Override
  public UnaryCallable<ListDatasetsRequest, ListDatasetsResponse> listDatasetsCallable() {
    return listDatasetsCallable;
  }

  @Override
  public UnaryCallable<ListDatasetsRequest, ListDatasetsPagedResponse> listDatasetsPagedCallable() {
    return listDatasetsPagedCallable;
  }

  @Override
  public UnaryCallable<DeleteDatasetRequest, Empty> deleteDatasetCallable() {
    return deleteDatasetCallable;
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
