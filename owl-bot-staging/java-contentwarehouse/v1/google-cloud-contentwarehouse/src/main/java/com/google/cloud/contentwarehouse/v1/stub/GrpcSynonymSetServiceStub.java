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

package com.google.cloud.contentwarehouse.v1.stub;

import static com.google.cloud.contentwarehouse.v1.SynonymSetServiceClient.ListSynonymSetsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.contentwarehouse.v1.CreateSynonymSetRequest;
import com.google.cloud.contentwarehouse.v1.DeleteSynonymSetRequest;
import com.google.cloud.contentwarehouse.v1.GetSynonymSetRequest;
import com.google.cloud.contentwarehouse.v1.ListSynonymSetsRequest;
import com.google.cloud.contentwarehouse.v1.ListSynonymSetsResponse;
import com.google.cloud.contentwarehouse.v1.SynonymSet;
import com.google.cloud.contentwarehouse.v1.UpdateSynonymSetRequest;
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
 * gRPC stub implementation for the SynonymSetService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcSynonymSetServiceStub extends SynonymSetServiceStub {
  private static final MethodDescriptor<CreateSynonymSetRequest, SynonymSet>
      createSynonymSetMethodDescriptor =
          MethodDescriptor.<CreateSynonymSetRequest, SynonymSet>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.contentwarehouse.v1.SynonymSetService/CreateSynonymSet")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateSynonymSetRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(SynonymSet.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetSynonymSetRequest, SynonymSet>
      getSynonymSetMethodDescriptor =
          MethodDescriptor.<GetSynonymSetRequest, SynonymSet>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.contentwarehouse.v1.SynonymSetService/GetSynonymSet")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetSynonymSetRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(SynonymSet.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateSynonymSetRequest, SynonymSet>
      updateSynonymSetMethodDescriptor =
          MethodDescriptor.<UpdateSynonymSetRequest, SynonymSet>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.contentwarehouse.v1.SynonymSetService/UpdateSynonymSet")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateSynonymSetRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(SynonymSet.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteSynonymSetRequest, Empty>
      deleteSynonymSetMethodDescriptor =
          MethodDescriptor.<DeleteSynonymSetRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.contentwarehouse.v1.SynonymSetService/DeleteSynonymSet")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteSynonymSetRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListSynonymSetsRequest, ListSynonymSetsResponse>
      listSynonymSetsMethodDescriptor =
          MethodDescriptor.<ListSynonymSetsRequest, ListSynonymSetsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.contentwarehouse.v1.SynonymSetService/ListSynonymSets")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListSynonymSetsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListSynonymSetsResponse.getDefaultInstance()))
              .build();

  private final UnaryCallable<CreateSynonymSetRequest, SynonymSet> createSynonymSetCallable;
  private final UnaryCallable<GetSynonymSetRequest, SynonymSet> getSynonymSetCallable;
  private final UnaryCallable<UpdateSynonymSetRequest, SynonymSet> updateSynonymSetCallable;
  private final UnaryCallable<DeleteSynonymSetRequest, Empty> deleteSynonymSetCallable;
  private final UnaryCallable<ListSynonymSetsRequest, ListSynonymSetsResponse>
      listSynonymSetsCallable;
  private final UnaryCallable<ListSynonymSetsRequest, ListSynonymSetsPagedResponse>
      listSynonymSetsPagedCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcSynonymSetServiceStub create(SynonymSetServiceStubSettings settings)
      throws IOException {
    return new GrpcSynonymSetServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcSynonymSetServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcSynonymSetServiceStub(
        SynonymSetServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcSynonymSetServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcSynonymSetServiceStub(
        SynonymSetServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcSynonymSetServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcSynonymSetServiceStub(
      SynonymSetServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcSynonymSetServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcSynonymSetServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcSynonymSetServiceStub(
      SynonymSetServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<CreateSynonymSetRequest, SynonymSet> createSynonymSetTransportSettings =
        GrpcCallSettings.<CreateSynonymSetRequest, SynonymSet>newBuilder()
            .setMethodDescriptor(createSynonymSetMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<GetSynonymSetRequest, SynonymSet> getSynonymSetTransportSettings =
        GrpcCallSettings.<GetSynonymSetRequest, SynonymSet>newBuilder()
            .setMethodDescriptor(getSynonymSetMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<UpdateSynonymSetRequest, SynonymSet> updateSynonymSetTransportSettings =
        GrpcCallSettings.<UpdateSynonymSetRequest, SynonymSet>newBuilder()
            .setMethodDescriptor(updateSynonymSetMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<DeleteSynonymSetRequest, Empty> deleteSynonymSetTransportSettings =
        GrpcCallSettings.<DeleteSynonymSetRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteSynonymSetMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<ListSynonymSetsRequest, ListSynonymSetsResponse>
        listSynonymSetsTransportSettings =
            GrpcCallSettings.<ListSynonymSetsRequest, ListSynonymSetsResponse>newBuilder()
                .setMethodDescriptor(listSynonymSetsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();

    this.createSynonymSetCallable =
        callableFactory.createUnaryCallable(
            createSynonymSetTransportSettings, settings.createSynonymSetSettings(), clientContext);
    this.getSynonymSetCallable =
        callableFactory.createUnaryCallable(
            getSynonymSetTransportSettings, settings.getSynonymSetSettings(), clientContext);
    this.updateSynonymSetCallable =
        callableFactory.createUnaryCallable(
            updateSynonymSetTransportSettings, settings.updateSynonymSetSettings(), clientContext);
    this.deleteSynonymSetCallable =
        callableFactory.createUnaryCallable(
            deleteSynonymSetTransportSettings, settings.deleteSynonymSetSettings(), clientContext);
    this.listSynonymSetsCallable =
        callableFactory.createUnaryCallable(
            listSynonymSetsTransportSettings, settings.listSynonymSetsSettings(), clientContext);
    this.listSynonymSetsPagedCallable =
        callableFactory.createPagedCallable(
            listSynonymSetsTransportSettings, settings.listSynonymSetsSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<CreateSynonymSetRequest, SynonymSet> createSynonymSetCallable() {
    return createSynonymSetCallable;
  }

  @Override
  public UnaryCallable<GetSynonymSetRequest, SynonymSet> getSynonymSetCallable() {
    return getSynonymSetCallable;
  }

  @Override
  public UnaryCallable<UpdateSynonymSetRequest, SynonymSet> updateSynonymSetCallable() {
    return updateSynonymSetCallable;
  }

  @Override
  public UnaryCallable<DeleteSynonymSetRequest, Empty> deleteSynonymSetCallable() {
    return deleteSynonymSetCallable;
  }

  @Override
  public UnaryCallable<ListSynonymSetsRequest, ListSynonymSetsResponse> listSynonymSetsCallable() {
    return listSynonymSetsCallable;
  }

  @Override
  public UnaryCallable<ListSynonymSetsRequest, ListSynonymSetsPagedResponse>
      listSynonymSetsPagedCallable() {
    return listSynonymSetsPagedCallable;
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
