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

package com.google.cloud.speech.v1p1beta1.stub;

import static com.google.cloud.speech.v1p1beta1.AdaptationClient.ListCustomClassesPagedResponse;
import static com.google.cloud.speech.v1p1beta1.AdaptationClient.ListPhraseSetPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsExtractor;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.speech.v1p1beta1.CreateCustomClassRequest;
import com.google.cloud.speech.v1p1beta1.CreatePhraseSetRequest;
import com.google.cloud.speech.v1p1beta1.CustomClass;
import com.google.cloud.speech.v1p1beta1.DeleteCustomClassRequest;
import com.google.cloud.speech.v1p1beta1.DeletePhraseSetRequest;
import com.google.cloud.speech.v1p1beta1.GetCustomClassRequest;
import com.google.cloud.speech.v1p1beta1.GetPhraseSetRequest;
import com.google.cloud.speech.v1p1beta1.ListCustomClassesRequest;
import com.google.cloud.speech.v1p1beta1.ListCustomClassesResponse;
import com.google.cloud.speech.v1p1beta1.ListPhraseSetRequest;
import com.google.cloud.speech.v1p1beta1.ListPhraseSetResponse;
import com.google.cloud.speech.v1p1beta1.PhraseSet;
import com.google.cloud.speech.v1p1beta1.UpdateCustomClassRequest;
import com.google.cloud.speech.v1p1beta1.UpdatePhraseSetRequest;
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
 * gRPC stub implementation for the Adaptation service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GrpcAdaptationStub extends AdaptationStub {
  private static final MethodDescriptor<CreatePhraseSetRequest, PhraseSet>
      createPhraseSetMethodDescriptor =
          MethodDescriptor.<CreatePhraseSetRequest, PhraseSet>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.speech.v1p1beta1.Adaptation/CreatePhraseSet")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreatePhraseSetRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(PhraseSet.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetPhraseSetRequest, PhraseSet>
      getPhraseSetMethodDescriptor =
          MethodDescriptor.<GetPhraseSetRequest, PhraseSet>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.speech.v1p1beta1.Adaptation/GetPhraseSet")
              .setRequestMarshaller(ProtoUtils.marshaller(GetPhraseSetRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(PhraseSet.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListPhraseSetRequest, ListPhraseSetResponse>
      listPhraseSetMethodDescriptor =
          MethodDescriptor.<ListPhraseSetRequest, ListPhraseSetResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.speech.v1p1beta1.Adaptation/ListPhraseSet")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListPhraseSetRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListPhraseSetResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdatePhraseSetRequest, PhraseSet>
      updatePhraseSetMethodDescriptor =
          MethodDescriptor.<UpdatePhraseSetRequest, PhraseSet>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.speech.v1p1beta1.Adaptation/UpdatePhraseSet")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdatePhraseSetRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(PhraseSet.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeletePhraseSetRequest, Empty>
      deletePhraseSetMethodDescriptor =
          MethodDescriptor.<DeletePhraseSetRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.speech.v1p1beta1.Adaptation/DeletePhraseSet")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeletePhraseSetRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateCustomClassRequest, CustomClass>
      createCustomClassMethodDescriptor =
          MethodDescriptor.<CreateCustomClassRequest, CustomClass>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.speech.v1p1beta1.Adaptation/CreateCustomClass")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateCustomClassRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(CustomClass.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetCustomClassRequest, CustomClass>
      getCustomClassMethodDescriptor =
          MethodDescriptor.<GetCustomClassRequest, CustomClass>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.speech.v1p1beta1.Adaptation/GetCustomClass")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetCustomClassRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(CustomClass.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListCustomClassesRequest, ListCustomClassesResponse>
      listCustomClassesMethodDescriptor =
          MethodDescriptor.<ListCustomClassesRequest, ListCustomClassesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.speech.v1p1beta1.Adaptation/ListCustomClasses")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListCustomClassesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListCustomClassesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateCustomClassRequest, CustomClass>
      updateCustomClassMethodDescriptor =
          MethodDescriptor.<UpdateCustomClassRequest, CustomClass>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.speech.v1p1beta1.Adaptation/UpdateCustomClass")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateCustomClassRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(CustomClass.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteCustomClassRequest, Empty>
      deleteCustomClassMethodDescriptor =
          MethodDescriptor.<DeleteCustomClassRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.speech.v1p1beta1.Adaptation/DeleteCustomClass")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteCustomClassRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private final UnaryCallable<CreatePhraseSetRequest, PhraseSet> createPhraseSetCallable;
  private final UnaryCallable<GetPhraseSetRequest, PhraseSet> getPhraseSetCallable;
  private final UnaryCallable<ListPhraseSetRequest, ListPhraseSetResponse> listPhraseSetCallable;
  private final UnaryCallable<ListPhraseSetRequest, ListPhraseSetPagedResponse>
      listPhraseSetPagedCallable;
  private final UnaryCallable<UpdatePhraseSetRequest, PhraseSet> updatePhraseSetCallable;
  private final UnaryCallable<DeletePhraseSetRequest, Empty> deletePhraseSetCallable;
  private final UnaryCallable<CreateCustomClassRequest, CustomClass> createCustomClassCallable;
  private final UnaryCallable<GetCustomClassRequest, CustomClass> getCustomClassCallable;
  private final UnaryCallable<ListCustomClassesRequest, ListCustomClassesResponse>
      listCustomClassesCallable;
  private final UnaryCallable<ListCustomClassesRequest, ListCustomClassesPagedResponse>
      listCustomClassesPagedCallable;
  private final UnaryCallable<UpdateCustomClassRequest, CustomClass> updateCustomClassCallable;
  private final UnaryCallable<DeleteCustomClassRequest, Empty> deleteCustomClassCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcAdaptationStub create(AdaptationStubSettings settings)
      throws IOException {
    return new GrpcAdaptationStub(settings, ClientContext.create(settings));
  }

  public static final GrpcAdaptationStub create(ClientContext clientContext) throws IOException {
    return new GrpcAdaptationStub(AdaptationStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcAdaptationStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcAdaptationStub(
        AdaptationStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcAdaptationStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcAdaptationStub(AdaptationStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcAdaptationCallableFactory());
  }

  /**
   * Constructs an instance of GrpcAdaptationStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcAdaptationStub(
      AdaptationStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<CreatePhraseSetRequest, PhraseSet> createPhraseSetTransportSettings =
        GrpcCallSettings.<CreatePhraseSetRequest, PhraseSet>newBuilder()
            .setMethodDescriptor(createPhraseSetMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<CreatePhraseSetRequest>() {
                  @Override
                  public Map<String, String> extract(CreatePhraseSetRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("parent", String.valueOf(request.getParent()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<GetPhraseSetRequest, PhraseSet> getPhraseSetTransportSettings =
        GrpcCallSettings.<GetPhraseSetRequest, PhraseSet>newBuilder()
            .setMethodDescriptor(getPhraseSetMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<GetPhraseSetRequest>() {
                  @Override
                  public Map<String, String> extract(GetPhraseSetRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<ListPhraseSetRequest, ListPhraseSetResponse> listPhraseSetTransportSettings =
        GrpcCallSettings.<ListPhraseSetRequest, ListPhraseSetResponse>newBuilder()
            .setMethodDescriptor(listPhraseSetMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<ListPhraseSetRequest>() {
                  @Override
                  public Map<String, String> extract(ListPhraseSetRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("parent", String.valueOf(request.getParent()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<UpdatePhraseSetRequest, PhraseSet> updatePhraseSetTransportSettings =
        GrpcCallSettings.<UpdatePhraseSetRequest, PhraseSet>newBuilder()
            .setMethodDescriptor(updatePhraseSetMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<UpdatePhraseSetRequest>() {
                  @Override
                  public Map<String, String> extract(UpdatePhraseSetRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("phrase_set.name", String.valueOf(request.getPhraseSet().getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<DeletePhraseSetRequest, Empty> deletePhraseSetTransportSettings =
        GrpcCallSettings.<DeletePhraseSetRequest, Empty>newBuilder()
            .setMethodDescriptor(deletePhraseSetMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<DeletePhraseSetRequest>() {
                  @Override
                  public Map<String, String> extract(DeletePhraseSetRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<CreateCustomClassRequest, CustomClass> createCustomClassTransportSettings =
        GrpcCallSettings.<CreateCustomClassRequest, CustomClass>newBuilder()
            .setMethodDescriptor(createCustomClassMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<CreateCustomClassRequest>() {
                  @Override
                  public Map<String, String> extract(CreateCustomClassRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("parent", String.valueOf(request.getParent()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<GetCustomClassRequest, CustomClass> getCustomClassTransportSettings =
        GrpcCallSettings.<GetCustomClassRequest, CustomClass>newBuilder()
            .setMethodDescriptor(getCustomClassMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<GetCustomClassRequest>() {
                  @Override
                  public Map<String, String> extract(GetCustomClassRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<ListCustomClassesRequest, ListCustomClassesResponse>
        listCustomClassesTransportSettings =
            GrpcCallSettings.<ListCustomClassesRequest, ListCustomClassesResponse>newBuilder()
                .setMethodDescriptor(listCustomClassesMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<ListCustomClassesRequest>() {
                      @Override
                      public Map<String, String> extract(ListCustomClassesRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("parent", String.valueOf(request.getParent()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<UpdateCustomClassRequest, CustomClass> updateCustomClassTransportSettings =
        GrpcCallSettings.<UpdateCustomClassRequest, CustomClass>newBuilder()
            .setMethodDescriptor(updateCustomClassMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<UpdateCustomClassRequest>() {
                  @Override
                  public Map<String, String> extract(UpdateCustomClassRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put(
                        "custom_class.name", String.valueOf(request.getCustomClass().getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<DeleteCustomClassRequest, Empty> deleteCustomClassTransportSettings =
        GrpcCallSettings.<DeleteCustomClassRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteCustomClassMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<DeleteCustomClassRequest>() {
                  @Override
                  public Map<String, String> extract(DeleteCustomClassRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();

    this.createPhraseSetCallable =
        callableFactory.createUnaryCallable(
            createPhraseSetTransportSettings, settings.createPhraseSetSettings(), clientContext);
    this.getPhraseSetCallable =
        callableFactory.createUnaryCallable(
            getPhraseSetTransportSettings, settings.getPhraseSetSettings(), clientContext);
    this.listPhraseSetCallable =
        callableFactory.createUnaryCallable(
            listPhraseSetTransportSettings, settings.listPhraseSetSettings(), clientContext);
    this.listPhraseSetPagedCallable =
        callableFactory.createPagedCallable(
            listPhraseSetTransportSettings, settings.listPhraseSetSettings(), clientContext);
    this.updatePhraseSetCallable =
        callableFactory.createUnaryCallable(
            updatePhraseSetTransportSettings, settings.updatePhraseSetSettings(), clientContext);
    this.deletePhraseSetCallable =
        callableFactory.createUnaryCallable(
            deletePhraseSetTransportSettings, settings.deletePhraseSetSettings(), clientContext);
    this.createCustomClassCallable =
        callableFactory.createUnaryCallable(
            createCustomClassTransportSettings,
            settings.createCustomClassSettings(),
            clientContext);
    this.getCustomClassCallable =
        callableFactory.createUnaryCallable(
            getCustomClassTransportSettings, settings.getCustomClassSettings(), clientContext);
    this.listCustomClassesCallable =
        callableFactory.createUnaryCallable(
            listCustomClassesTransportSettings,
            settings.listCustomClassesSettings(),
            clientContext);
    this.listCustomClassesPagedCallable =
        callableFactory.createPagedCallable(
            listCustomClassesTransportSettings,
            settings.listCustomClassesSettings(),
            clientContext);
    this.updateCustomClassCallable =
        callableFactory.createUnaryCallable(
            updateCustomClassTransportSettings,
            settings.updateCustomClassSettings(),
            clientContext);
    this.deleteCustomClassCallable =
        callableFactory.createUnaryCallable(
            deleteCustomClassTransportSettings,
            settings.deleteCustomClassSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<CreatePhraseSetRequest, PhraseSet> createPhraseSetCallable() {
    return createPhraseSetCallable;
  }

  @Override
  public UnaryCallable<GetPhraseSetRequest, PhraseSet> getPhraseSetCallable() {
    return getPhraseSetCallable;
  }

  @Override
  public UnaryCallable<ListPhraseSetRequest, ListPhraseSetResponse> listPhraseSetCallable() {
    return listPhraseSetCallable;
  }

  @Override
  public UnaryCallable<ListPhraseSetRequest, ListPhraseSetPagedResponse>
      listPhraseSetPagedCallable() {
    return listPhraseSetPagedCallable;
  }

  @Override
  public UnaryCallable<UpdatePhraseSetRequest, PhraseSet> updatePhraseSetCallable() {
    return updatePhraseSetCallable;
  }

  @Override
  public UnaryCallable<DeletePhraseSetRequest, Empty> deletePhraseSetCallable() {
    return deletePhraseSetCallable;
  }

  @Override
  public UnaryCallable<CreateCustomClassRequest, CustomClass> createCustomClassCallable() {
    return createCustomClassCallable;
  }

  @Override
  public UnaryCallable<GetCustomClassRequest, CustomClass> getCustomClassCallable() {
    return getCustomClassCallable;
  }

  @Override
  public UnaryCallable<ListCustomClassesRequest, ListCustomClassesResponse>
      listCustomClassesCallable() {
    return listCustomClassesCallable;
  }

  @Override
  public UnaryCallable<ListCustomClassesRequest, ListCustomClassesPagedResponse>
      listCustomClassesPagedCallable() {
    return listCustomClassesPagedCallable;
  }

  @Override
  public UnaryCallable<UpdateCustomClassRequest, CustomClass> updateCustomClassCallable() {
    return updateCustomClassCallable;
  }

  @Override
  public UnaryCallable<DeleteCustomClassRequest, Empty> deleteCustomClassCallable() {
    return deleteCustomClassCallable;
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
