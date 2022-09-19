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

package com.google.cloud.dialogflow.cx.v3.stub;

import static com.google.cloud.dialogflow.cx.v3.ExperimentsClient.ListExperimentsPagedResponse;
import static com.google.cloud.dialogflow.cx.v3.ExperimentsClient.ListLocationsPagedResponse;

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
import com.google.cloud.dialogflow.cx.v3.CreateExperimentRequest;
import com.google.cloud.dialogflow.cx.v3.DeleteExperimentRequest;
import com.google.cloud.dialogflow.cx.v3.Experiment;
import com.google.cloud.dialogflow.cx.v3.GetExperimentRequest;
import com.google.cloud.dialogflow.cx.v3.ListExperimentsRequest;
import com.google.cloud.dialogflow.cx.v3.ListExperimentsResponse;
import com.google.cloud.dialogflow.cx.v3.StartExperimentRequest;
import com.google.cloud.dialogflow.cx.v3.StopExperimentRequest;
import com.google.cloud.dialogflow.cx.v3.UpdateExperimentRequest;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
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
 * REST stub implementation for the Experiments service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
@BetaApi
public class HttpJsonExperimentsStub extends ExperimentsStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<ListExperimentsRequest, ListExperimentsResponse>
      listExperimentsMethodDescriptor =
          ApiMethodDescriptor.<ListExperimentsRequest, ListExperimentsResponse>newBuilder()
              .setFullMethodName("google.cloud.dialogflow.cx.v3.Experiments/ListExperiments")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListExperimentsRequest>newBuilder()
                      .setPath(
                          "/v3/{parent=projects/*/locations/*/agents/*/environments/*}/experiments",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListExperimentsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListExperimentsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListExperimentsResponse>newBuilder()
                      .setDefaultInstance(ListExperimentsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetExperimentRequest, Experiment>
      getExperimentMethodDescriptor =
          ApiMethodDescriptor.<GetExperimentRequest, Experiment>newBuilder()
              .setFullMethodName("google.cloud.dialogflow.cx.v3.Experiments/GetExperiment")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetExperimentRequest>newBuilder()
                      .setPath(
                          "/v3/{name=projects/*/locations/*/agents/*/environments/*/experiments/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetExperimentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetExperimentRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Experiment>newBuilder()
                      .setDefaultInstance(Experiment.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateExperimentRequest, Experiment>
      createExperimentMethodDescriptor =
          ApiMethodDescriptor.<CreateExperimentRequest, Experiment>newBuilder()
              .setFullMethodName("google.cloud.dialogflow.cx.v3.Experiments/CreateExperiment")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateExperimentRequest>newBuilder()
                      .setPath(
                          "/v3/{parent=projects/*/locations/*/agents/*/environments/*}/experiments",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateExperimentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateExperimentRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("experiment", request.getExperiment(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Experiment>newBuilder()
                      .setDefaultInstance(Experiment.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateExperimentRequest, Experiment>
      updateExperimentMethodDescriptor =
          ApiMethodDescriptor.<UpdateExperimentRequest, Experiment>newBuilder()
              .setFullMethodName("google.cloud.dialogflow.cx.v3.Experiments/UpdateExperiment")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateExperimentRequest>newBuilder()
                      .setPath(
                          "/v3/{experiment.name=projects/*/locations/*/agents/*/environments/*/experiments/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateExperimentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "experiment.name", request.getExperiment().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateExperimentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("experiment", request.getExperiment(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Experiment>newBuilder()
                      .setDefaultInstance(Experiment.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteExperimentRequest, Empty>
      deleteExperimentMethodDescriptor =
          ApiMethodDescriptor.<DeleteExperimentRequest, Empty>newBuilder()
              .setFullMethodName("google.cloud.dialogflow.cx.v3.Experiments/DeleteExperiment")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteExperimentRequest>newBuilder()
                      .setPath(
                          "/v3/{name=projects/*/locations/*/agents/*/environments/*/experiments/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteExperimentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteExperimentRequest> serializer =
                                ProtoRestSerializer.create();
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

  private static final ApiMethodDescriptor<StartExperimentRequest, Experiment>
      startExperimentMethodDescriptor =
          ApiMethodDescriptor.<StartExperimentRequest, Experiment>newBuilder()
              .setFullMethodName("google.cloud.dialogflow.cx.v3.Experiments/StartExperiment")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<StartExperimentRequest>newBuilder()
                      .setPath(
                          "/v3/{name=projects/*/locations/*/agents/*/environments/*/experiments/*}:start",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<StartExperimentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<StartExperimentRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearName().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Experiment>newBuilder()
                      .setDefaultInstance(Experiment.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<StopExperimentRequest, Experiment>
      stopExperimentMethodDescriptor =
          ApiMethodDescriptor.<StopExperimentRequest, Experiment>newBuilder()
              .setFullMethodName("google.cloud.dialogflow.cx.v3.Experiments/StopExperiment")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<StopExperimentRequest>newBuilder()
                      .setPath(
                          "/v3/{name=projects/*/locations/*/agents/*/environments/*/experiments/*}:stop",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<StopExperimentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<StopExperimentRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearName().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Experiment>newBuilder()
                      .setDefaultInstance(Experiment.getDefaultInstance())
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
                          "/v3/{name=projects/*}/locations",
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
                          "/v3/{name=projects/*/locations/*}",
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

  private final UnaryCallable<ListExperimentsRequest, ListExperimentsResponse>
      listExperimentsCallable;
  private final UnaryCallable<ListExperimentsRequest, ListExperimentsPagedResponse>
      listExperimentsPagedCallable;
  private final UnaryCallable<GetExperimentRequest, Experiment> getExperimentCallable;
  private final UnaryCallable<CreateExperimentRequest, Experiment> createExperimentCallable;
  private final UnaryCallable<UpdateExperimentRequest, Experiment> updateExperimentCallable;
  private final UnaryCallable<DeleteExperimentRequest, Empty> deleteExperimentCallable;
  private final UnaryCallable<StartExperimentRequest, Experiment> startExperimentCallable;
  private final UnaryCallable<StopExperimentRequest, Experiment> stopExperimentCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonExperimentsStub create(ExperimentsStubSettings settings)
      throws IOException {
    return new HttpJsonExperimentsStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonExperimentsStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonExperimentsStub(
        ExperimentsStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonExperimentsStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonExperimentsStub(
        ExperimentsStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonExperimentsStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonExperimentsStub(ExperimentsStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonExperimentsCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonExperimentsStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonExperimentsStub(
      ExperimentsStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<ListExperimentsRequest, ListExperimentsResponse>
        listExperimentsTransportSettings =
            HttpJsonCallSettings.<ListExperimentsRequest, ListExperimentsResponse>newBuilder()
                .setMethodDescriptor(listExperimentsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GetExperimentRequest, Experiment> getExperimentTransportSettings =
        HttpJsonCallSettings.<GetExperimentRequest, Experiment>newBuilder()
            .setMethodDescriptor(getExperimentMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<CreateExperimentRequest, Experiment> createExperimentTransportSettings =
        HttpJsonCallSettings.<CreateExperimentRequest, Experiment>newBuilder()
            .setMethodDescriptor(createExperimentMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<UpdateExperimentRequest, Experiment> updateExperimentTransportSettings =
        HttpJsonCallSettings.<UpdateExperimentRequest, Experiment>newBuilder()
            .setMethodDescriptor(updateExperimentMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<DeleteExperimentRequest, Empty> deleteExperimentTransportSettings =
        HttpJsonCallSettings.<DeleteExperimentRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteExperimentMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<StartExperimentRequest, Experiment> startExperimentTransportSettings =
        HttpJsonCallSettings.<StartExperimentRequest, Experiment>newBuilder()
            .setMethodDescriptor(startExperimentMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<StopExperimentRequest, Experiment> stopExperimentTransportSettings =
        HttpJsonCallSettings.<StopExperimentRequest, Experiment>newBuilder()
            .setMethodDescriptor(stopExperimentMethodDescriptor)
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

    this.listExperimentsCallable =
        callableFactory.createUnaryCallable(
            listExperimentsTransportSettings, settings.listExperimentsSettings(), clientContext);
    this.listExperimentsPagedCallable =
        callableFactory.createPagedCallable(
            listExperimentsTransportSettings, settings.listExperimentsSettings(), clientContext);
    this.getExperimentCallable =
        callableFactory.createUnaryCallable(
            getExperimentTransportSettings, settings.getExperimentSettings(), clientContext);
    this.createExperimentCallable =
        callableFactory.createUnaryCallable(
            createExperimentTransportSettings, settings.createExperimentSettings(), clientContext);
    this.updateExperimentCallable =
        callableFactory.createUnaryCallable(
            updateExperimentTransportSettings, settings.updateExperimentSettings(), clientContext);
    this.deleteExperimentCallable =
        callableFactory.createUnaryCallable(
            deleteExperimentTransportSettings, settings.deleteExperimentSettings(), clientContext);
    this.startExperimentCallable =
        callableFactory.createUnaryCallable(
            startExperimentTransportSettings, settings.startExperimentSettings(), clientContext);
    this.stopExperimentCallable =
        callableFactory.createUnaryCallable(
            stopExperimentTransportSettings, settings.stopExperimentSettings(), clientContext);
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
    methodDescriptors.add(listExperimentsMethodDescriptor);
    methodDescriptors.add(getExperimentMethodDescriptor);
    methodDescriptors.add(createExperimentMethodDescriptor);
    methodDescriptors.add(updateExperimentMethodDescriptor);
    methodDescriptors.add(deleteExperimentMethodDescriptor);
    methodDescriptors.add(startExperimentMethodDescriptor);
    methodDescriptors.add(stopExperimentMethodDescriptor);
    methodDescriptors.add(listLocationsMethodDescriptor);
    methodDescriptors.add(getLocationMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<ListExperimentsRequest, ListExperimentsResponse> listExperimentsCallable() {
    return listExperimentsCallable;
  }

  @Override
  public UnaryCallable<ListExperimentsRequest, ListExperimentsPagedResponse>
      listExperimentsPagedCallable() {
    return listExperimentsPagedCallable;
  }

  @Override
  public UnaryCallable<GetExperimentRequest, Experiment> getExperimentCallable() {
    return getExperimentCallable;
  }

  @Override
  public UnaryCallable<CreateExperimentRequest, Experiment> createExperimentCallable() {
    return createExperimentCallable;
  }

  @Override
  public UnaryCallable<UpdateExperimentRequest, Experiment> updateExperimentCallable() {
    return updateExperimentCallable;
  }

  @Override
  public UnaryCallable<DeleteExperimentRequest, Empty> deleteExperimentCallable() {
    return deleteExperimentCallable;
  }

  @Override
  public UnaryCallable<StartExperimentRequest, Experiment> startExperimentCallable() {
    return startExperimentCallable;
  }

  @Override
  public UnaryCallable<StopExperimentRequest, Experiment> stopExperimentCallable() {
    return stopExperimentCallable;
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
