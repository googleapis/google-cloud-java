/*
 * Copyright 2024 Google LLC
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

package com.google.shopping.merchant.conversions.v1beta.stub;

import static com.google.shopping.merchant.conversions.v1beta.ConversionSourcesServiceClient.ListConversionSourcesPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.protobuf.Empty;
import com.google.shopping.merchant.conversions.v1beta.ConversionSource;
import com.google.shopping.merchant.conversions.v1beta.CreateConversionSourceRequest;
import com.google.shopping.merchant.conversions.v1beta.DeleteConversionSourceRequest;
import com.google.shopping.merchant.conversions.v1beta.GetConversionSourceRequest;
import com.google.shopping.merchant.conversions.v1beta.ListConversionSourcesRequest;
import com.google.shopping.merchant.conversions.v1beta.ListConversionSourcesResponse;
import com.google.shopping.merchant.conversions.v1beta.UndeleteConversionSourceRequest;
import com.google.shopping.merchant.conversions.v1beta.UpdateConversionSourceRequest;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the ConversionSourcesService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GrpcConversionSourcesServiceStub extends ConversionSourcesServiceStub {
  private static final MethodDescriptor<CreateConversionSourceRequest, ConversionSource>
      createConversionSourceMethodDescriptor =
          MethodDescriptor.<CreateConversionSourceRequest, ConversionSource>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.shopping.merchant.conversions.v1beta.ConversionSourcesService/CreateConversionSource")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateConversionSourceRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ConversionSource.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateConversionSourceRequest, ConversionSource>
      updateConversionSourceMethodDescriptor =
          MethodDescriptor.<UpdateConversionSourceRequest, ConversionSource>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.shopping.merchant.conversions.v1beta.ConversionSourcesService/UpdateConversionSource")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateConversionSourceRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ConversionSource.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteConversionSourceRequest, Empty>
      deleteConversionSourceMethodDescriptor =
          MethodDescriptor.<DeleteConversionSourceRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.shopping.merchant.conversions.v1beta.ConversionSourcesService/DeleteConversionSource")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteConversionSourceRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UndeleteConversionSourceRequest, ConversionSource>
      undeleteConversionSourceMethodDescriptor =
          MethodDescriptor.<UndeleteConversionSourceRequest, ConversionSource>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.shopping.merchant.conversions.v1beta.ConversionSourcesService/UndeleteConversionSource")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UndeleteConversionSourceRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ConversionSource.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetConversionSourceRequest, ConversionSource>
      getConversionSourceMethodDescriptor =
          MethodDescriptor.<GetConversionSourceRequest, ConversionSource>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.shopping.merchant.conversions.v1beta.ConversionSourcesService/GetConversionSource")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetConversionSourceRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ConversionSource.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListConversionSourcesRequest, ListConversionSourcesResponse>
      listConversionSourcesMethodDescriptor =
          MethodDescriptor.<ListConversionSourcesRequest, ListConversionSourcesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.shopping.merchant.conversions.v1beta.ConversionSourcesService/ListConversionSources")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListConversionSourcesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListConversionSourcesResponse.getDefaultInstance()))
              .build();

  private final UnaryCallable<CreateConversionSourceRequest, ConversionSource>
      createConversionSourceCallable;
  private final UnaryCallable<UpdateConversionSourceRequest, ConversionSource>
      updateConversionSourceCallable;
  private final UnaryCallable<DeleteConversionSourceRequest, Empty> deleteConversionSourceCallable;
  private final UnaryCallable<UndeleteConversionSourceRequest, ConversionSource>
      undeleteConversionSourceCallable;
  private final UnaryCallable<GetConversionSourceRequest, ConversionSource>
      getConversionSourceCallable;
  private final UnaryCallable<ListConversionSourcesRequest, ListConversionSourcesResponse>
      listConversionSourcesCallable;
  private final UnaryCallable<ListConversionSourcesRequest, ListConversionSourcesPagedResponse>
      listConversionSourcesPagedCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcConversionSourcesServiceStub create(
      ConversionSourcesServiceStubSettings settings) throws IOException {
    return new GrpcConversionSourcesServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcConversionSourcesServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcConversionSourcesServiceStub(
        ConversionSourcesServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcConversionSourcesServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcConversionSourcesServiceStub(
        ConversionSourcesServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcConversionSourcesServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcConversionSourcesServiceStub(
      ConversionSourcesServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcConversionSourcesServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcConversionSourcesServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcConversionSourcesServiceStub(
      ConversionSourcesServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<CreateConversionSourceRequest, ConversionSource>
        createConversionSourceTransportSettings =
            GrpcCallSettings.<CreateConversionSourceRequest, ConversionSource>newBuilder()
                .setMethodDescriptor(createConversionSourceMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<UpdateConversionSourceRequest, ConversionSource>
        updateConversionSourceTransportSettings =
            GrpcCallSettings.<UpdateConversionSourceRequest, ConversionSource>newBuilder()
                .setMethodDescriptor(updateConversionSourceMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "conversion_source.name",
                          String.valueOf(request.getConversionSource().getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<DeleteConversionSourceRequest, Empty> deleteConversionSourceTransportSettings =
        GrpcCallSettings.<DeleteConversionSourceRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteConversionSourceMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UndeleteConversionSourceRequest, ConversionSource>
        undeleteConversionSourceTransportSettings =
            GrpcCallSettings.<UndeleteConversionSourceRequest, ConversionSource>newBuilder()
                .setMethodDescriptor(undeleteConversionSourceMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetConversionSourceRequest, ConversionSource>
        getConversionSourceTransportSettings =
            GrpcCallSettings.<GetConversionSourceRequest, ConversionSource>newBuilder()
                .setMethodDescriptor(getConversionSourceMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ListConversionSourcesRequest, ListConversionSourcesResponse>
        listConversionSourcesTransportSettings =
            GrpcCallSettings
                .<ListConversionSourcesRequest, ListConversionSourcesResponse>newBuilder()
                .setMethodDescriptor(listConversionSourcesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();

    this.createConversionSourceCallable =
        callableFactory.createUnaryCallable(
            createConversionSourceTransportSettings,
            settings.createConversionSourceSettings(),
            clientContext);
    this.updateConversionSourceCallable =
        callableFactory.createUnaryCallable(
            updateConversionSourceTransportSettings,
            settings.updateConversionSourceSettings(),
            clientContext);
    this.deleteConversionSourceCallable =
        callableFactory.createUnaryCallable(
            deleteConversionSourceTransportSettings,
            settings.deleteConversionSourceSettings(),
            clientContext);
    this.undeleteConversionSourceCallable =
        callableFactory.createUnaryCallable(
            undeleteConversionSourceTransportSettings,
            settings.undeleteConversionSourceSettings(),
            clientContext);
    this.getConversionSourceCallable =
        callableFactory.createUnaryCallable(
            getConversionSourceTransportSettings,
            settings.getConversionSourceSettings(),
            clientContext);
    this.listConversionSourcesCallable =
        callableFactory.createUnaryCallable(
            listConversionSourcesTransportSettings,
            settings.listConversionSourcesSettings(),
            clientContext);
    this.listConversionSourcesPagedCallable =
        callableFactory.createPagedCallable(
            listConversionSourcesTransportSettings,
            settings.listConversionSourcesSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<CreateConversionSourceRequest, ConversionSource>
      createConversionSourceCallable() {
    return createConversionSourceCallable;
  }

  @Override
  public UnaryCallable<UpdateConversionSourceRequest, ConversionSource>
      updateConversionSourceCallable() {
    return updateConversionSourceCallable;
  }

  @Override
  public UnaryCallable<DeleteConversionSourceRequest, Empty> deleteConversionSourceCallable() {
    return deleteConversionSourceCallable;
  }

  @Override
  public UnaryCallable<UndeleteConversionSourceRequest, ConversionSource>
      undeleteConversionSourceCallable() {
    return undeleteConversionSourceCallable;
  }

  @Override
  public UnaryCallable<GetConversionSourceRequest, ConversionSource> getConversionSourceCallable() {
    return getConversionSourceCallable;
  }

  @Override
  public UnaryCallable<ListConversionSourcesRequest, ListConversionSourcesResponse>
      listConversionSourcesCallable() {
    return listConversionSourcesCallable;
  }

  @Override
  public UnaryCallable<ListConversionSourcesRequest, ListConversionSourcesPagedResponse>
      listConversionSourcesPagedCallable() {
    return listConversionSourcesPagedCallable;
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
