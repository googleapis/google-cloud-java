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

package com.google.cloud.dialogflow.v2beta1.stub;

import static com.google.cloud.dialogflow.v2beta1.AnswerRecordsClient.ListAnswerRecordsPagedResponse;
import static com.google.cloud.dialogflow.v2beta1.AnswerRecordsClient.ListLocationsPagedResponse;

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
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.dialogflow.v2beta1.AnswerRecord;
import com.google.cloud.dialogflow.v2beta1.GetAnswerRecordRequest;
import com.google.cloud.dialogflow.v2beta1.ListAnswerRecordsRequest;
import com.google.cloud.dialogflow.v2beta1.ListAnswerRecordsResponse;
import com.google.cloud.dialogflow.v2beta1.UpdateAnswerRecordRequest;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
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
 * REST stub implementation for the AnswerRecords service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class HttpJsonAnswerRecordsStub extends AnswerRecordsStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<GetAnswerRecordRequest, AnswerRecord>
      getAnswerRecordMethodDescriptor =
          ApiMethodDescriptor.<GetAnswerRecordRequest, AnswerRecord>newBuilder()
              .setFullMethodName("google.cloud.dialogflow.v2beta1.AnswerRecords/GetAnswerRecord")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetAnswerRecordRequest>newBuilder()
                      .setPath(
                          "/v2beta1/{name=projects/*/answerRecords/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetAnswerRecordRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setAdditionalPaths("/v2beta1/{name=projects/*/locations/*/answerRecords/*}")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetAnswerRecordRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<AnswerRecord>newBuilder()
                      .setDefaultInstance(AnswerRecord.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListAnswerRecordsRequest, ListAnswerRecordsResponse>
      listAnswerRecordsMethodDescriptor =
          ApiMethodDescriptor.<ListAnswerRecordsRequest, ListAnswerRecordsResponse>newBuilder()
              .setFullMethodName("google.cloud.dialogflow.v2beta1.AnswerRecords/ListAnswerRecords")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListAnswerRecordsRequest>newBuilder()
                      .setPath(
                          "/v2beta1/{parent=projects/*}/answerRecords",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListAnswerRecordsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setAdditionalPaths("/v2beta1/{parent=projects/*/locations/*}/answerRecords")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListAnswerRecordsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListAnswerRecordsResponse>newBuilder()
                      .setDefaultInstance(ListAnswerRecordsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateAnswerRecordRequest, AnswerRecord>
      updateAnswerRecordMethodDescriptor =
          ApiMethodDescriptor.<UpdateAnswerRecordRequest, AnswerRecord>newBuilder()
              .setFullMethodName("google.cloud.dialogflow.v2beta1.AnswerRecords/UpdateAnswerRecord")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateAnswerRecordRequest>newBuilder()
                      .setPath(
                          "/v2beta1/{answerRecord.name=projects/*/answerRecords/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateAnswerRecordRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "answerRecord.name", request.getAnswerRecord().getName());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v2beta1/{answerRecord.name=projects/*/locations/*/answerRecords/*}")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateAnswerRecordRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("answerRecord", request.getAnswerRecord(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<AnswerRecord>newBuilder()
                      .setDefaultInstance(AnswerRecord.getDefaultInstance())
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
                          "/v2beta1/{name=projects/*}/locations",
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
                          "/v2beta1/{name=projects/*/locations/*}",
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

  private final UnaryCallable<GetAnswerRecordRequest, AnswerRecord> getAnswerRecordCallable;
  private final UnaryCallable<ListAnswerRecordsRequest, ListAnswerRecordsResponse>
      listAnswerRecordsCallable;
  private final UnaryCallable<ListAnswerRecordsRequest, ListAnswerRecordsPagedResponse>
      listAnswerRecordsPagedCallable;
  private final UnaryCallable<UpdateAnswerRecordRequest, AnswerRecord> updateAnswerRecordCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonAnswerRecordsStub create(AnswerRecordsStubSettings settings)
      throws IOException {
    return new HttpJsonAnswerRecordsStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonAnswerRecordsStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonAnswerRecordsStub(
        AnswerRecordsStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonAnswerRecordsStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonAnswerRecordsStub(
        AnswerRecordsStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonAnswerRecordsStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonAnswerRecordsStub(
      AnswerRecordsStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonAnswerRecordsCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonAnswerRecordsStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonAnswerRecordsStub(
      AnswerRecordsStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<GetAnswerRecordRequest, AnswerRecord> getAnswerRecordTransportSettings =
        HttpJsonCallSettings.<GetAnswerRecordRequest, AnswerRecord>newBuilder()
            .setMethodDescriptor(getAnswerRecordMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ListAnswerRecordsRequest, ListAnswerRecordsResponse>
        listAnswerRecordsTransportSettings =
            HttpJsonCallSettings.<ListAnswerRecordsRequest, ListAnswerRecordsResponse>newBuilder()
                .setMethodDescriptor(listAnswerRecordsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<UpdateAnswerRecordRequest, AnswerRecord>
        updateAnswerRecordTransportSettings =
            HttpJsonCallSettings.<UpdateAnswerRecordRequest, AnswerRecord>newBuilder()
                .setMethodDescriptor(updateAnswerRecordMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<ListLocationsRequest, ListLocationsResponse>
        listLocationsTransportSettings =
            HttpJsonCallSettings.<ListLocationsRequest, ListLocationsResponse>newBuilder()
                .setMethodDescriptor(listLocationsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GetLocationRequest, Location> getLocationTransportSettings =
        HttpJsonCallSettings.<GetLocationRequest, Location>newBuilder()
            .setMethodDescriptor(getLocationMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();

    this.getAnswerRecordCallable =
        callableFactory.createUnaryCallable(
            getAnswerRecordTransportSettings, settings.getAnswerRecordSettings(), clientContext);
    this.listAnswerRecordsCallable =
        callableFactory.createUnaryCallable(
            listAnswerRecordsTransportSettings,
            settings.listAnswerRecordsSettings(),
            clientContext);
    this.listAnswerRecordsPagedCallable =
        callableFactory.createPagedCallable(
            listAnswerRecordsTransportSettings,
            settings.listAnswerRecordsSettings(),
            clientContext);
    this.updateAnswerRecordCallable =
        callableFactory.createUnaryCallable(
            updateAnswerRecordTransportSettings,
            settings.updateAnswerRecordSettings(),
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
    methodDescriptors.add(getAnswerRecordMethodDescriptor);
    methodDescriptors.add(listAnswerRecordsMethodDescriptor);
    methodDescriptors.add(updateAnswerRecordMethodDescriptor);
    methodDescriptors.add(listLocationsMethodDescriptor);
    methodDescriptors.add(getLocationMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<GetAnswerRecordRequest, AnswerRecord> getAnswerRecordCallable() {
    return getAnswerRecordCallable;
  }

  @Override
  public UnaryCallable<ListAnswerRecordsRequest, ListAnswerRecordsResponse>
      listAnswerRecordsCallable() {
    return listAnswerRecordsCallable;
  }

  @Override
  public UnaryCallable<ListAnswerRecordsRequest, ListAnswerRecordsPagedResponse>
      listAnswerRecordsPagedCallable() {
    return listAnswerRecordsPagedCallable;
  }

  @Override
  public UnaryCallable<UpdateAnswerRecordRequest, AnswerRecord> updateAnswerRecordCallable() {
    return updateAnswerRecordCallable;
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
