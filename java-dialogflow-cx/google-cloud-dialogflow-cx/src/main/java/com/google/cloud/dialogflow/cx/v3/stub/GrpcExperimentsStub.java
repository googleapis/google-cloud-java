/*
 * Copyright 2020 Google LLC
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

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsExtractor;
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
import com.google.common.collect.ImmutableMap;
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
 * gRPC stub implementation for the Experiments service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcExperimentsStub extends ExperimentsStub {
  private static final MethodDescriptor<ListExperimentsRequest, ListExperimentsResponse>
      listExperimentsMethodDescriptor =
          MethodDescriptor.<ListExperimentsRequest, ListExperimentsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dialogflow.cx.v3.Experiments/ListExperiments")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListExperimentsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListExperimentsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetExperimentRequest, Experiment>
      getExperimentMethodDescriptor =
          MethodDescriptor.<GetExperimentRequest, Experiment>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dialogflow.cx.v3.Experiments/GetExperiment")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetExperimentRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Experiment.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateExperimentRequest, Experiment>
      createExperimentMethodDescriptor =
          MethodDescriptor.<CreateExperimentRequest, Experiment>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dialogflow.cx.v3.Experiments/CreateExperiment")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateExperimentRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Experiment.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateExperimentRequest, Experiment>
      updateExperimentMethodDescriptor =
          MethodDescriptor.<UpdateExperimentRequest, Experiment>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dialogflow.cx.v3.Experiments/UpdateExperiment")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateExperimentRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Experiment.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteExperimentRequest, Empty>
      deleteExperimentMethodDescriptor =
          MethodDescriptor.<DeleteExperimentRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dialogflow.cx.v3.Experiments/DeleteExperiment")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteExperimentRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<StartExperimentRequest, Experiment>
      startExperimentMethodDescriptor =
          MethodDescriptor.<StartExperimentRequest, Experiment>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dialogflow.cx.v3.Experiments/StartExperiment")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(StartExperimentRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Experiment.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<StopExperimentRequest, Experiment>
      stopExperimentMethodDescriptor =
          MethodDescriptor.<StopExperimentRequest, Experiment>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dialogflow.cx.v3.Experiments/StopExperiment")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(StopExperimentRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Experiment.getDefaultInstance()))
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

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcExperimentsStub create(ExperimentsStubSettings settings)
      throws IOException {
    return new GrpcExperimentsStub(settings, ClientContext.create(settings));
  }

  public static final GrpcExperimentsStub create(ClientContext clientContext) throws IOException {
    return new GrpcExperimentsStub(ExperimentsStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcExperimentsStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcExperimentsStub(
        ExperimentsStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcExperimentsStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcExperimentsStub(ExperimentsStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcExperimentsCallableFactory());
  }

  /**
   * Constructs an instance of GrpcExperimentsStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcExperimentsStub(
      ExperimentsStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<ListExperimentsRequest, ListExperimentsResponse>
        listExperimentsTransportSettings =
            GrpcCallSettings.<ListExperimentsRequest, ListExperimentsResponse>newBuilder()
                .setMethodDescriptor(listExperimentsMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<ListExperimentsRequest>() {
                      @Override
                      public Map<String, String> extract(ListExperimentsRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("parent", String.valueOf(request.getParent()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<GetExperimentRequest, Experiment> getExperimentTransportSettings =
        GrpcCallSettings.<GetExperimentRequest, Experiment>newBuilder()
            .setMethodDescriptor(getExperimentMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<GetExperimentRequest>() {
                  @Override
                  public Map<String, String> extract(GetExperimentRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<CreateExperimentRequest, Experiment> createExperimentTransportSettings =
        GrpcCallSettings.<CreateExperimentRequest, Experiment>newBuilder()
            .setMethodDescriptor(createExperimentMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<CreateExperimentRequest>() {
                  @Override
                  public Map<String, String> extract(CreateExperimentRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("parent", String.valueOf(request.getParent()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<UpdateExperimentRequest, Experiment> updateExperimentTransportSettings =
        GrpcCallSettings.<UpdateExperimentRequest, Experiment>newBuilder()
            .setMethodDescriptor(updateExperimentMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<UpdateExperimentRequest>() {
                  @Override
                  public Map<String, String> extract(UpdateExperimentRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put(
                        "experiment.name", String.valueOf(request.getExperiment().getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<DeleteExperimentRequest, Empty> deleteExperimentTransportSettings =
        GrpcCallSettings.<DeleteExperimentRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteExperimentMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<DeleteExperimentRequest>() {
                  @Override
                  public Map<String, String> extract(DeleteExperimentRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<StartExperimentRequest, Experiment> startExperimentTransportSettings =
        GrpcCallSettings.<StartExperimentRequest, Experiment>newBuilder()
            .setMethodDescriptor(startExperimentMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<StartExperimentRequest>() {
                  @Override
                  public Map<String, String> extract(StartExperimentRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<StopExperimentRequest, Experiment> stopExperimentTransportSettings =
        GrpcCallSettings.<StopExperimentRequest, Experiment>newBuilder()
            .setMethodDescriptor(stopExperimentMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<StopExperimentRequest>() {
                  @Override
                  public Map<String, String> extract(StopExperimentRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
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

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  public UnaryCallable<ListExperimentsRequest, ListExperimentsResponse> listExperimentsCallable() {
    return listExperimentsCallable;
  }

  public UnaryCallable<ListExperimentsRequest, ListExperimentsPagedResponse>
      listExperimentsPagedCallable() {
    return listExperimentsPagedCallable;
  }

  public UnaryCallable<GetExperimentRequest, Experiment> getExperimentCallable() {
    return getExperimentCallable;
  }

  public UnaryCallable<CreateExperimentRequest, Experiment> createExperimentCallable() {
    return createExperimentCallable;
  }

  public UnaryCallable<UpdateExperimentRequest, Experiment> updateExperimentCallable() {
    return updateExperimentCallable;
  }

  public UnaryCallable<DeleteExperimentRequest, Empty> deleteExperimentCallable() {
    return deleteExperimentCallable;
  }

  public UnaryCallable<StartExperimentRequest, Experiment> startExperimentCallable() {
    return startExperimentCallable;
  }

  public UnaryCallable<StopExperimentRequest, Experiment> stopExperimentCallable() {
    return stopExperimentCallable;
  }

  @Override
  public final void close() {
    shutdown();
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
