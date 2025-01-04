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

package com.google.cloud.discoveryengine.v1beta.stub;

import static com.google.cloud.discoveryengine.v1beta.SampleQuerySetServiceClient.ListSampleQuerySetsPagedResponse;

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
import com.google.cloud.discoveryengine.v1beta.CreateSampleQuerySetRequest;
import com.google.cloud.discoveryengine.v1beta.DeleteSampleQuerySetRequest;
import com.google.cloud.discoveryengine.v1beta.GetSampleQuerySetRequest;
import com.google.cloud.discoveryengine.v1beta.ListSampleQuerySetsRequest;
import com.google.cloud.discoveryengine.v1beta.ListSampleQuerySetsResponse;
import com.google.cloud.discoveryengine.v1beta.SampleQuerySet;
import com.google.cloud.discoveryengine.v1beta.UpdateSampleQuerySetRequest;
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
 * REST stub implementation for the SampleQuerySetService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class HttpJsonSampleQuerySetServiceStub extends SampleQuerySetServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<GetSampleQuerySetRequest, SampleQuerySet>
      getSampleQuerySetMethodDescriptor =
          ApiMethodDescriptor.<GetSampleQuerySetRequest, SampleQuerySet>newBuilder()
              .setFullMethodName(
                  "google.cloud.discoveryengine.v1beta.SampleQuerySetService/GetSampleQuerySet")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetSampleQuerySetRequest>newBuilder()
                      .setPath(
                          "/v1beta/{name=projects/*/locations/*/sampleQuerySets/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetSampleQuerySetRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetSampleQuerySetRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<SampleQuerySet>newBuilder()
                      .setDefaultInstance(SampleQuerySet.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListSampleQuerySetsRequest, ListSampleQuerySetsResponse>
      listSampleQuerySetsMethodDescriptor =
          ApiMethodDescriptor.<ListSampleQuerySetsRequest, ListSampleQuerySetsResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.discoveryengine.v1beta.SampleQuerySetService/ListSampleQuerySets")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListSampleQuerySetsRequest>newBuilder()
                      .setPath(
                          "/v1beta/{parent=projects/*/locations/*}/sampleQuerySets",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListSampleQuerySetsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListSampleQuerySetsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListSampleQuerySetsResponse>newBuilder()
                      .setDefaultInstance(ListSampleQuerySetsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateSampleQuerySetRequest, SampleQuerySet>
      createSampleQuerySetMethodDescriptor =
          ApiMethodDescriptor.<CreateSampleQuerySetRequest, SampleQuerySet>newBuilder()
              .setFullMethodName(
                  "google.cloud.discoveryengine.v1beta.SampleQuerySetService/CreateSampleQuerySet")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateSampleQuerySetRequest>newBuilder()
                      .setPath(
                          "/v1beta/{parent=projects/*/locations/*}/sampleQuerySets",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateSampleQuerySetRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateSampleQuerySetRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "sampleQuerySetId", request.getSampleQuerySetId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("sampleQuerySet", request.getSampleQuerySet(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<SampleQuerySet>newBuilder()
                      .setDefaultInstance(SampleQuerySet.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateSampleQuerySetRequest, SampleQuerySet>
      updateSampleQuerySetMethodDescriptor =
          ApiMethodDescriptor.<UpdateSampleQuerySetRequest, SampleQuerySet>newBuilder()
              .setFullMethodName(
                  "google.cloud.discoveryengine.v1beta.SampleQuerySetService/UpdateSampleQuerySet")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateSampleQuerySetRequest>newBuilder()
                      .setPath(
                          "/v1beta/{sampleQuerySet.name=projects/*/locations/*/sampleQuerySets/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateSampleQuerySetRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields,
                                "sampleQuerySet.name",
                                request.getSampleQuerySet().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateSampleQuerySetRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("sampleQuerySet", request.getSampleQuerySet(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<SampleQuerySet>newBuilder()
                      .setDefaultInstance(SampleQuerySet.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteSampleQuerySetRequest, Empty>
      deleteSampleQuerySetMethodDescriptor =
          ApiMethodDescriptor.<DeleteSampleQuerySetRequest, Empty>newBuilder()
              .setFullMethodName(
                  "google.cloud.discoveryengine.v1beta.SampleQuerySetService/DeleteSampleQuerySet")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteSampleQuerySetRequest>newBuilder()
                      .setPath(
                          "/v1beta/{name=projects/*/locations/*/sampleQuerySets/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteSampleQuerySetRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteSampleQuerySetRequest> serializer =
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

  private final UnaryCallable<GetSampleQuerySetRequest, SampleQuerySet> getSampleQuerySetCallable;
  private final UnaryCallable<ListSampleQuerySetsRequest, ListSampleQuerySetsResponse>
      listSampleQuerySetsCallable;
  private final UnaryCallable<ListSampleQuerySetsRequest, ListSampleQuerySetsPagedResponse>
      listSampleQuerySetsPagedCallable;
  private final UnaryCallable<CreateSampleQuerySetRequest, SampleQuerySet>
      createSampleQuerySetCallable;
  private final UnaryCallable<UpdateSampleQuerySetRequest, SampleQuerySet>
      updateSampleQuerySetCallable;
  private final UnaryCallable<DeleteSampleQuerySetRequest, Empty> deleteSampleQuerySetCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonSampleQuerySetServiceStub create(
      SampleQuerySetServiceStubSettings settings) throws IOException {
    return new HttpJsonSampleQuerySetServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonSampleQuerySetServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonSampleQuerySetServiceStub(
        SampleQuerySetServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonSampleQuerySetServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonSampleQuerySetServiceStub(
        SampleQuerySetServiceStubSettings.newHttpJsonBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonSampleQuerySetServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonSampleQuerySetServiceStub(
      SampleQuerySetServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonSampleQuerySetServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonSampleQuerySetServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonSampleQuerySetServiceStub(
      SampleQuerySetServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<GetSampleQuerySetRequest, SampleQuerySet>
        getSampleQuerySetTransportSettings =
            HttpJsonCallSettings.<GetSampleQuerySetRequest, SampleQuerySet>newBuilder()
                .setMethodDescriptor(getSampleQuerySetMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListSampleQuerySetsRequest, ListSampleQuerySetsResponse>
        listSampleQuerySetsTransportSettings =
            HttpJsonCallSettings
                .<ListSampleQuerySetsRequest, ListSampleQuerySetsResponse>newBuilder()
                .setMethodDescriptor(listSampleQuerySetsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<CreateSampleQuerySetRequest, SampleQuerySet>
        createSampleQuerySetTransportSettings =
            HttpJsonCallSettings.<CreateSampleQuerySetRequest, SampleQuerySet>newBuilder()
                .setMethodDescriptor(createSampleQuerySetMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<UpdateSampleQuerySetRequest, SampleQuerySet>
        updateSampleQuerySetTransportSettings =
            HttpJsonCallSettings.<UpdateSampleQuerySetRequest, SampleQuerySet>newBuilder()
                .setMethodDescriptor(updateSampleQuerySetMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "sample_query_set.name",
                          String.valueOf(request.getSampleQuerySet().getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<DeleteSampleQuerySetRequest, Empty> deleteSampleQuerySetTransportSettings =
        HttpJsonCallSettings.<DeleteSampleQuerySetRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteSampleQuerySetMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();

    this.getSampleQuerySetCallable =
        callableFactory.createUnaryCallable(
            getSampleQuerySetTransportSettings,
            settings.getSampleQuerySetSettings(),
            clientContext);
    this.listSampleQuerySetsCallable =
        callableFactory.createUnaryCallable(
            listSampleQuerySetsTransportSettings,
            settings.listSampleQuerySetsSettings(),
            clientContext);
    this.listSampleQuerySetsPagedCallable =
        callableFactory.createPagedCallable(
            listSampleQuerySetsTransportSettings,
            settings.listSampleQuerySetsSettings(),
            clientContext);
    this.createSampleQuerySetCallable =
        callableFactory.createUnaryCallable(
            createSampleQuerySetTransportSettings,
            settings.createSampleQuerySetSettings(),
            clientContext);
    this.updateSampleQuerySetCallable =
        callableFactory.createUnaryCallable(
            updateSampleQuerySetTransportSettings,
            settings.updateSampleQuerySetSettings(),
            clientContext);
    this.deleteSampleQuerySetCallable =
        callableFactory.createUnaryCallable(
            deleteSampleQuerySetTransportSettings,
            settings.deleteSampleQuerySetSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(getSampleQuerySetMethodDescriptor);
    methodDescriptors.add(listSampleQuerySetsMethodDescriptor);
    methodDescriptors.add(createSampleQuerySetMethodDescriptor);
    methodDescriptors.add(updateSampleQuerySetMethodDescriptor);
    methodDescriptors.add(deleteSampleQuerySetMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<GetSampleQuerySetRequest, SampleQuerySet> getSampleQuerySetCallable() {
    return getSampleQuerySetCallable;
  }

  @Override
  public UnaryCallable<ListSampleQuerySetsRequest, ListSampleQuerySetsResponse>
      listSampleQuerySetsCallable() {
    return listSampleQuerySetsCallable;
  }

  @Override
  public UnaryCallable<ListSampleQuerySetsRequest, ListSampleQuerySetsPagedResponse>
      listSampleQuerySetsPagedCallable() {
    return listSampleQuerySetsPagedCallable;
  }

  @Override
  public UnaryCallable<CreateSampleQuerySetRequest, SampleQuerySet> createSampleQuerySetCallable() {
    return createSampleQuerySetCallable;
  }

  @Override
  public UnaryCallable<UpdateSampleQuerySetRequest, SampleQuerySet> updateSampleQuerySetCallable() {
    return updateSampleQuerySetCallable;
  }

  @Override
  public UnaryCallable<DeleteSampleQuerySetRequest, Empty> deleteSampleQuerySetCallable() {
    return deleteSampleQuerySetCallable;
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
