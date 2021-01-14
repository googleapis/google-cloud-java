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

package com.google.cloud.talent.v4beta1.stub;

import static com.google.cloud.talent.v4beta1.ApplicationServiceClient.ListApplicationsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsExtractor;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.talent.v4beta1.Application;
import com.google.cloud.talent.v4beta1.CreateApplicationRequest;
import com.google.cloud.talent.v4beta1.DeleteApplicationRequest;
import com.google.cloud.talent.v4beta1.GetApplicationRequest;
import com.google.cloud.talent.v4beta1.ListApplicationsRequest;
import com.google.cloud.talent.v4beta1.ListApplicationsResponse;
import com.google.cloud.talent.v4beta1.UpdateApplicationRequest;
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
 * gRPC stub implementation for the ApplicationService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GrpcApplicationServiceStub extends ApplicationServiceStub {
  private static final MethodDescriptor<CreateApplicationRequest, Application>
      createApplicationMethodDescriptor =
          MethodDescriptor.<CreateApplicationRequest, Application>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.talent.v4beta1.ApplicationService/CreateApplication")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateApplicationRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Application.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetApplicationRequest, Application>
      getApplicationMethodDescriptor =
          MethodDescriptor.<GetApplicationRequest, Application>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.talent.v4beta1.ApplicationService/GetApplication")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetApplicationRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Application.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateApplicationRequest, Application>
      updateApplicationMethodDescriptor =
          MethodDescriptor.<UpdateApplicationRequest, Application>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.talent.v4beta1.ApplicationService/UpdateApplication")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateApplicationRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Application.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteApplicationRequest, Empty>
      deleteApplicationMethodDescriptor =
          MethodDescriptor.<DeleteApplicationRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.talent.v4beta1.ApplicationService/DeleteApplication")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteApplicationRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListApplicationsRequest, ListApplicationsResponse>
      listApplicationsMethodDescriptor =
          MethodDescriptor.<ListApplicationsRequest, ListApplicationsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.talent.v4beta1.ApplicationService/ListApplications")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListApplicationsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListApplicationsResponse.getDefaultInstance()))
              .build();

  private final UnaryCallable<CreateApplicationRequest, Application> createApplicationCallable;
  private final UnaryCallable<GetApplicationRequest, Application> getApplicationCallable;
  private final UnaryCallable<UpdateApplicationRequest, Application> updateApplicationCallable;
  private final UnaryCallable<DeleteApplicationRequest, Empty> deleteApplicationCallable;
  private final UnaryCallable<ListApplicationsRequest, ListApplicationsResponse>
      listApplicationsCallable;
  private final UnaryCallable<ListApplicationsRequest, ListApplicationsPagedResponse>
      listApplicationsPagedCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcApplicationServiceStub create(ApplicationServiceStubSettings settings)
      throws IOException {
    return new GrpcApplicationServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcApplicationServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcApplicationServiceStub(
        ApplicationServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcApplicationServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcApplicationServiceStub(
        ApplicationServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcApplicationServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcApplicationServiceStub(
      ApplicationServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcApplicationServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcApplicationServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcApplicationServiceStub(
      ApplicationServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<CreateApplicationRequest, Application> createApplicationTransportSettings =
        GrpcCallSettings.<CreateApplicationRequest, Application>newBuilder()
            .setMethodDescriptor(createApplicationMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<CreateApplicationRequest>() {
                  @Override
                  public Map<String, String> extract(CreateApplicationRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("parent", String.valueOf(request.getParent()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<GetApplicationRequest, Application> getApplicationTransportSettings =
        GrpcCallSettings.<GetApplicationRequest, Application>newBuilder()
            .setMethodDescriptor(getApplicationMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<GetApplicationRequest>() {
                  @Override
                  public Map<String, String> extract(GetApplicationRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<UpdateApplicationRequest, Application> updateApplicationTransportSettings =
        GrpcCallSettings.<UpdateApplicationRequest, Application>newBuilder()
            .setMethodDescriptor(updateApplicationMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<UpdateApplicationRequest>() {
                  @Override
                  public Map<String, String> extract(UpdateApplicationRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put(
                        "application.name", String.valueOf(request.getApplication().getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<DeleteApplicationRequest, Empty> deleteApplicationTransportSettings =
        GrpcCallSettings.<DeleteApplicationRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteApplicationMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<DeleteApplicationRequest>() {
                  @Override
                  public Map<String, String> extract(DeleteApplicationRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<ListApplicationsRequest, ListApplicationsResponse>
        listApplicationsTransportSettings =
            GrpcCallSettings.<ListApplicationsRequest, ListApplicationsResponse>newBuilder()
                .setMethodDescriptor(listApplicationsMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<ListApplicationsRequest>() {
                      @Override
                      public Map<String, String> extract(ListApplicationsRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("parent", String.valueOf(request.getParent()));
                        return params.build();
                      }
                    })
                .build();

    this.createApplicationCallable =
        callableFactory.createUnaryCallable(
            createApplicationTransportSettings,
            settings.createApplicationSettings(),
            clientContext);
    this.getApplicationCallable =
        callableFactory.createUnaryCallable(
            getApplicationTransportSettings, settings.getApplicationSettings(), clientContext);
    this.updateApplicationCallable =
        callableFactory.createUnaryCallable(
            updateApplicationTransportSettings,
            settings.updateApplicationSettings(),
            clientContext);
    this.deleteApplicationCallable =
        callableFactory.createUnaryCallable(
            deleteApplicationTransportSettings,
            settings.deleteApplicationSettings(),
            clientContext);
    this.listApplicationsCallable =
        callableFactory.createUnaryCallable(
            listApplicationsTransportSettings, settings.listApplicationsSettings(), clientContext);
    this.listApplicationsPagedCallable =
        callableFactory.createPagedCallable(
            listApplicationsTransportSettings, settings.listApplicationsSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  public UnaryCallable<CreateApplicationRequest, Application> createApplicationCallable() {
    return createApplicationCallable;
  }

  public UnaryCallable<GetApplicationRequest, Application> getApplicationCallable() {
    return getApplicationCallable;
  }

  public UnaryCallable<UpdateApplicationRequest, Application> updateApplicationCallable() {
    return updateApplicationCallable;
  }

  public UnaryCallable<DeleteApplicationRequest, Empty> deleteApplicationCallable() {
    return deleteApplicationCallable;
  }

  public UnaryCallable<ListApplicationsRequest, ListApplicationsResponse>
      listApplicationsCallable() {
    return listApplicationsCallable;
  }

  public UnaryCallable<ListApplicationsRequest, ListApplicationsPagedResponse>
      listApplicationsPagedCallable() {
    return listApplicationsPagedCallable;
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
