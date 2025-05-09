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

package com.google.cloud.discoveryengine.v1alpha.stub;

import static com.google.cloud.discoveryengine.v1alpha.SampleQuerySetServiceClient.ListSampleQuerySetsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.discoveryengine.v1alpha.CreateSampleQuerySetRequest;
import com.google.cloud.discoveryengine.v1alpha.DeleteSampleQuerySetRequest;
import com.google.cloud.discoveryengine.v1alpha.GetSampleQuerySetRequest;
import com.google.cloud.discoveryengine.v1alpha.ListSampleQuerySetsRequest;
import com.google.cloud.discoveryengine.v1alpha.ListSampleQuerySetsResponse;
import com.google.cloud.discoveryengine.v1alpha.SampleQuerySet;
import com.google.cloud.discoveryengine.v1alpha.UpdateSampleQuerySetRequest;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.protobuf.Empty;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the SampleQuerySetService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GrpcSampleQuerySetServiceStub extends SampleQuerySetServiceStub {
  private static final MethodDescriptor<GetSampleQuerySetRequest, SampleQuerySet>
      getSampleQuerySetMethodDescriptor =
          MethodDescriptor.<GetSampleQuerySetRequest, SampleQuerySet>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.discoveryengine.v1alpha.SampleQuerySetService/GetSampleQuerySet")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetSampleQuerySetRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(SampleQuerySet.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListSampleQuerySetsRequest, ListSampleQuerySetsResponse>
      listSampleQuerySetsMethodDescriptor =
          MethodDescriptor.<ListSampleQuerySetsRequest, ListSampleQuerySetsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.discoveryengine.v1alpha.SampleQuerySetService/ListSampleQuerySets")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListSampleQuerySetsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListSampleQuerySetsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateSampleQuerySetRequest, SampleQuerySet>
      createSampleQuerySetMethodDescriptor =
          MethodDescriptor.<CreateSampleQuerySetRequest, SampleQuerySet>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.discoveryengine.v1alpha.SampleQuerySetService/CreateSampleQuerySet")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateSampleQuerySetRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(SampleQuerySet.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateSampleQuerySetRequest, SampleQuerySet>
      updateSampleQuerySetMethodDescriptor =
          MethodDescriptor.<UpdateSampleQuerySetRequest, SampleQuerySet>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.discoveryengine.v1alpha.SampleQuerySetService/UpdateSampleQuerySet")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateSampleQuerySetRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(SampleQuerySet.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteSampleQuerySetRequest, Empty>
      deleteSampleQuerySetMethodDescriptor =
          MethodDescriptor.<DeleteSampleQuerySetRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.discoveryengine.v1alpha.SampleQuerySetService/DeleteSampleQuerySet")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteSampleQuerySetRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
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
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcSampleQuerySetServiceStub create(
      SampleQuerySetServiceStubSettings settings) throws IOException {
    return new GrpcSampleQuerySetServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcSampleQuerySetServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcSampleQuerySetServiceStub(
        SampleQuerySetServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcSampleQuerySetServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcSampleQuerySetServiceStub(
        SampleQuerySetServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcSampleQuerySetServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcSampleQuerySetServiceStub(
      SampleQuerySetServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcSampleQuerySetServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcSampleQuerySetServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcSampleQuerySetServiceStub(
      SampleQuerySetServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<GetSampleQuerySetRequest, SampleQuerySet> getSampleQuerySetTransportSettings =
        GrpcCallSettings.<GetSampleQuerySetRequest, SampleQuerySet>newBuilder()
            .setMethodDescriptor(getSampleQuerySetMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListSampleQuerySetsRequest, ListSampleQuerySetsResponse>
        listSampleQuerySetsTransportSettings =
            GrpcCallSettings.<ListSampleQuerySetsRequest, ListSampleQuerySetsResponse>newBuilder()
                .setMethodDescriptor(listSampleQuerySetsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<CreateSampleQuerySetRequest, SampleQuerySet>
        createSampleQuerySetTransportSettings =
            GrpcCallSettings.<CreateSampleQuerySetRequest, SampleQuerySet>newBuilder()
                .setMethodDescriptor(createSampleQuerySetMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<UpdateSampleQuerySetRequest, SampleQuerySet>
        updateSampleQuerySetTransportSettings =
            GrpcCallSettings.<UpdateSampleQuerySetRequest, SampleQuerySet>newBuilder()
                .setMethodDescriptor(updateSampleQuerySetMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "sample_query_set.name",
                          String.valueOf(request.getSampleQuerySet().getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<DeleteSampleQuerySetRequest, Empty> deleteSampleQuerySetTransportSettings =
        GrpcCallSettings.<DeleteSampleQuerySetRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteSampleQuerySetMethodDescriptor)
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

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
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
