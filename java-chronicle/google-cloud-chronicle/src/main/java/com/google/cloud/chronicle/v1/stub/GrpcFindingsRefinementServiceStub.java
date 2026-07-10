/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.chronicle.v1.stub;

import static com.google.cloud.chronicle.v1.FindingsRefinementServiceClient.ListAllFindingsRefinementDeploymentsPagedResponse;
import static com.google.cloud.chronicle.v1.FindingsRefinementServiceClient.ListFindingsRefinementsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.chronicle.v1.ComputeAllFindingsRefinementActivitiesRequest;
import com.google.cloud.chronicle.v1.ComputeAllFindingsRefinementActivitiesResponse;
import com.google.cloud.chronicle.v1.ComputeFindingsRefinementActivityRequest;
import com.google.cloud.chronicle.v1.ComputeFindingsRefinementActivityResponse;
import com.google.cloud.chronicle.v1.CreateFindingsRefinementRequest;
import com.google.cloud.chronicle.v1.FindingsRefinement;
import com.google.cloud.chronicle.v1.FindingsRefinementDeployment;
import com.google.cloud.chronicle.v1.GetFindingsRefinementDeploymentRequest;
import com.google.cloud.chronicle.v1.GetFindingsRefinementRequest;
import com.google.cloud.chronicle.v1.ListAllFindingsRefinementDeploymentsRequest;
import com.google.cloud.chronicle.v1.ListAllFindingsRefinementDeploymentsResponse;
import com.google.cloud.chronicle.v1.ListFindingsRefinementsRequest;
import com.google.cloud.chronicle.v1.ListFindingsRefinementsResponse;
import com.google.cloud.chronicle.v1.UpdateFindingsRefinementDeploymentRequest;
import com.google.cloud.chronicle.v1.UpdateFindingsRefinementRequest;
import com.google.longrunning.stub.GrpcOperationsStub;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the FindingsRefinementService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@NullMarked
@Generated("by gapic-generator-java")
public class GrpcFindingsRefinementServiceStub extends FindingsRefinementServiceStub {
  private static final MethodDescriptor<GetFindingsRefinementRequest, FindingsRefinement>
      getFindingsRefinementMethodDescriptor =
          MethodDescriptor.<GetFindingsRefinementRequest, FindingsRefinement>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.chronicle.v1.FindingsRefinementService/GetFindingsRefinement")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetFindingsRefinementRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(FindingsRefinement.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<
          ListFindingsRefinementsRequest, ListFindingsRefinementsResponse>
      listFindingsRefinementsMethodDescriptor =
          MethodDescriptor
              .<ListFindingsRefinementsRequest, ListFindingsRefinementsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.chronicle.v1.FindingsRefinementService/ListFindingsRefinements")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListFindingsRefinementsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListFindingsRefinementsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<CreateFindingsRefinementRequest, FindingsRefinement>
      createFindingsRefinementMethodDescriptor =
          MethodDescriptor.<CreateFindingsRefinementRequest, FindingsRefinement>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.chronicle.v1.FindingsRefinementService/CreateFindingsRefinement")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateFindingsRefinementRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(FindingsRefinement.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UpdateFindingsRefinementRequest, FindingsRefinement>
      updateFindingsRefinementMethodDescriptor =
          MethodDescriptor.<UpdateFindingsRefinementRequest, FindingsRefinement>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.chronicle.v1.FindingsRefinementService/UpdateFindingsRefinement")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateFindingsRefinementRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(FindingsRefinement.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<
          GetFindingsRefinementDeploymentRequest, FindingsRefinementDeployment>
      getFindingsRefinementDeploymentMethodDescriptor =
          MethodDescriptor
              .<GetFindingsRefinementDeploymentRequest, FindingsRefinementDeployment>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.chronicle.v1.FindingsRefinementService/GetFindingsRefinementDeployment")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      GetFindingsRefinementDeploymentRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(FindingsRefinementDeployment.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<
          UpdateFindingsRefinementDeploymentRequest, FindingsRefinementDeployment>
      updateFindingsRefinementDeploymentMethodDescriptor =
          MethodDescriptor
              .<UpdateFindingsRefinementDeploymentRequest, FindingsRefinementDeployment>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.chronicle.v1.FindingsRefinementService/UpdateFindingsRefinementDeployment")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      UpdateFindingsRefinementDeploymentRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(FindingsRefinementDeployment.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<
          ListAllFindingsRefinementDeploymentsRequest, ListAllFindingsRefinementDeploymentsResponse>
      listAllFindingsRefinementDeploymentsMethodDescriptor =
          MethodDescriptor
              .<ListAllFindingsRefinementDeploymentsRequest,
                  ListAllFindingsRefinementDeploymentsResponse>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.chronicle.v1.FindingsRefinementService/ListAllFindingsRefinementDeployments")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      ListAllFindingsRefinementDeploymentsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(
                      ListAllFindingsRefinementDeploymentsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<
          ComputeFindingsRefinementActivityRequest, ComputeFindingsRefinementActivityResponse>
      computeFindingsRefinementActivityMethodDescriptor =
          MethodDescriptor
              .<ComputeFindingsRefinementActivityRequest, ComputeFindingsRefinementActivityResponse>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.chronicle.v1.FindingsRefinementService/ComputeFindingsRefinementActivity")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      ComputeFindingsRefinementActivityRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(
                      ComputeFindingsRefinementActivityResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<
          ComputeAllFindingsRefinementActivitiesRequest,
          ComputeAllFindingsRefinementActivitiesResponse>
      computeAllFindingsRefinementActivitiesMethodDescriptor =
          MethodDescriptor
              .<ComputeAllFindingsRefinementActivitiesRequest,
                  ComputeAllFindingsRefinementActivitiesResponse>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.chronicle.v1.FindingsRefinementService/ComputeAllFindingsRefinementActivities")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      ComputeAllFindingsRefinementActivitiesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(
                      ComputeAllFindingsRefinementActivitiesResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private final UnaryCallable<GetFindingsRefinementRequest, FindingsRefinement>
      getFindingsRefinementCallable;
  private final UnaryCallable<ListFindingsRefinementsRequest, ListFindingsRefinementsResponse>
      listFindingsRefinementsCallable;
  private final UnaryCallable<ListFindingsRefinementsRequest, ListFindingsRefinementsPagedResponse>
      listFindingsRefinementsPagedCallable;
  private final UnaryCallable<CreateFindingsRefinementRequest, FindingsRefinement>
      createFindingsRefinementCallable;
  private final UnaryCallable<UpdateFindingsRefinementRequest, FindingsRefinement>
      updateFindingsRefinementCallable;
  private final UnaryCallable<GetFindingsRefinementDeploymentRequest, FindingsRefinementDeployment>
      getFindingsRefinementDeploymentCallable;
  private final UnaryCallable<
          UpdateFindingsRefinementDeploymentRequest, FindingsRefinementDeployment>
      updateFindingsRefinementDeploymentCallable;
  private final UnaryCallable<
          ListAllFindingsRefinementDeploymentsRequest, ListAllFindingsRefinementDeploymentsResponse>
      listAllFindingsRefinementDeploymentsCallable;
  private final UnaryCallable<
          ListAllFindingsRefinementDeploymentsRequest,
          ListAllFindingsRefinementDeploymentsPagedResponse>
      listAllFindingsRefinementDeploymentsPagedCallable;
  private final UnaryCallable<
          ComputeFindingsRefinementActivityRequest, ComputeFindingsRefinementActivityResponse>
      computeFindingsRefinementActivityCallable;
  private final UnaryCallable<
          ComputeAllFindingsRefinementActivitiesRequest,
          ComputeAllFindingsRefinementActivitiesResponse>
      computeAllFindingsRefinementActivitiesCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcFindingsRefinementServiceStub create(
      FindingsRefinementServiceStubSettings settings) throws IOException {
    return new GrpcFindingsRefinementServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcFindingsRefinementServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcFindingsRefinementServiceStub(
        FindingsRefinementServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcFindingsRefinementServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcFindingsRefinementServiceStub(
        FindingsRefinementServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcFindingsRefinementServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcFindingsRefinementServiceStub(
      FindingsRefinementServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcFindingsRefinementServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcFindingsRefinementServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcFindingsRefinementServiceStub(
      FindingsRefinementServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<GetFindingsRefinementRequest, FindingsRefinement>
        getFindingsRefinementTransportSettings =
            GrpcCallSettings.<GetFindingsRefinementRequest, FindingsRefinement>newBuilder()
                .setMethodDescriptor(getFindingsRefinementMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    GrpcCallSettings<ListFindingsRefinementsRequest, ListFindingsRefinementsResponse>
        listFindingsRefinementsTransportSettings =
            GrpcCallSettings
                .<ListFindingsRefinementsRequest, ListFindingsRefinementsResponse>newBuilder()
                .setMethodDescriptor(listFindingsRefinementsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    GrpcCallSettings<CreateFindingsRefinementRequest, FindingsRefinement>
        createFindingsRefinementTransportSettings =
            GrpcCallSettings.<CreateFindingsRefinementRequest, FindingsRefinement>newBuilder()
                .setMethodDescriptor(createFindingsRefinementMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    GrpcCallSettings<UpdateFindingsRefinementRequest, FindingsRefinement>
        updateFindingsRefinementTransportSettings =
            GrpcCallSettings.<UpdateFindingsRefinementRequest, FindingsRefinement>newBuilder()
                .setMethodDescriptor(updateFindingsRefinementMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "findings_refinement.name",
                          String.valueOf(request.getFindingsRefinement().getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetFindingsRefinementDeploymentRequest, FindingsRefinementDeployment>
        getFindingsRefinementDeploymentTransportSettings =
            GrpcCallSettings
                .<GetFindingsRefinementDeploymentRequest, FindingsRefinementDeployment>newBuilder()
                .setMethodDescriptor(getFindingsRefinementDeploymentMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    GrpcCallSettings<UpdateFindingsRefinementDeploymentRequest, FindingsRefinementDeployment>
        updateFindingsRefinementDeploymentTransportSettings =
            GrpcCallSettings
                .<UpdateFindingsRefinementDeploymentRequest, FindingsRefinementDeployment>
                    newBuilder()
                .setMethodDescriptor(updateFindingsRefinementDeploymentMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "findings_refinement_deployment.name",
                          String.valueOf(request.getFindingsRefinementDeployment().getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<
            ListAllFindingsRefinementDeploymentsRequest,
            ListAllFindingsRefinementDeploymentsResponse>
        listAllFindingsRefinementDeploymentsTransportSettings =
            GrpcCallSettings
                .<ListAllFindingsRefinementDeploymentsRequest,
                    ListAllFindingsRefinementDeploymentsResponse>
                    newBuilder()
                .setMethodDescriptor(listAllFindingsRefinementDeploymentsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("instance", String.valueOf(request.getInstance()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getInstance())
                .build();
    GrpcCallSettings<
            ComputeFindingsRefinementActivityRequest, ComputeFindingsRefinementActivityResponse>
        computeFindingsRefinementActivityTransportSettings =
            GrpcCallSettings
                .<ComputeFindingsRefinementActivityRequest,
                    ComputeFindingsRefinementActivityResponse>
                    newBuilder()
                .setMethodDescriptor(computeFindingsRefinementActivityMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    GrpcCallSettings<
            ComputeAllFindingsRefinementActivitiesRequest,
            ComputeAllFindingsRefinementActivitiesResponse>
        computeAllFindingsRefinementActivitiesTransportSettings =
            GrpcCallSettings
                .<ComputeAllFindingsRefinementActivitiesRequest,
                    ComputeAllFindingsRefinementActivitiesResponse>
                    newBuilder()
                .setMethodDescriptor(computeAllFindingsRefinementActivitiesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("instance", String.valueOf(request.getInstance()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getInstance())
                .build();

    this.getFindingsRefinementCallable =
        callableFactory.createUnaryCallable(
            getFindingsRefinementTransportSettings,
            settings.getFindingsRefinementSettings(),
            clientContext);
    this.listFindingsRefinementsCallable =
        callableFactory.createUnaryCallable(
            listFindingsRefinementsTransportSettings,
            settings.listFindingsRefinementsSettings(),
            clientContext);
    this.listFindingsRefinementsPagedCallable =
        callableFactory.createPagedCallable(
            listFindingsRefinementsTransportSettings,
            settings.listFindingsRefinementsSettings(),
            clientContext);
    this.createFindingsRefinementCallable =
        callableFactory.createUnaryCallable(
            createFindingsRefinementTransportSettings,
            settings.createFindingsRefinementSettings(),
            clientContext);
    this.updateFindingsRefinementCallable =
        callableFactory.createUnaryCallable(
            updateFindingsRefinementTransportSettings,
            settings.updateFindingsRefinementSettings(),
            clientContext);
    this.getFindingsRefinementDeploymentCallable =
        callableFactory.createUnaryCallable(
            getFindingsRefinementDeploymentTransportSettings,
            settings.getFindingsRefinementDeploymentSettings(),
            clientContext);
    this.updateFindingsRefinementDeploymentCallable =
        callableFactory.createUnaryCallable(
            updateFindingsRefinementDeploymentTransportSettings,
            settings.updateFindingsRefinementDeploymentSettings(),
            clientContext);
    this.listAllFindingsRefinementDeploymentsCallable =
        callableFactory.createUnaryCallable(
            listAllFindingsRefinementDeploymentsTransportSettings,
            settings.listAllFindingsRefinementDeploymentsSettings(),
            clientContext);
    this.listAllFindingsRefinementDeploymentsPagedCallable =
        callableFactory.createPagedCallable(
            listAllFindingsRefinementDeploymentsTransportSettings,
            settings.listAllFindingsRefinementDeploymentsSettings(),
            clientContext);
    this.computeFindingsRefinementActivityCallable =
        callableFactory.createUnaryCallable(
            computeFindingsRefinementActivityTransportSettings,
            settings.computeFindingsRefinementActivitySettings(),
            clientContext);
    this.computeAllFindingsRefinementActivitiesCallable =
        callableFactory.createUnaryCallable(
            computeAllFindingsRefinementActivitiesTransportSettings,
            settings.computeAllFindingsRefinementActivitiesSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<GetFindingsRefinementRequest, FindingsRefinement>
      getFindingsRefinementCallable() {
    return getFindingsRefinementCallable;
  }

  @Override
  public UnaryCallable<ListFindingsRefinementsRequest, ListFindingsRefinementsResponse>
      listFindingsRefinementsCallable() {
    return listFindingsRefinementsCallable;
  }

  @Override
  public UnaryCallable<ListFindingsRefinementsRequest, ListFindingsRefinementsPagedResponse>
      listFindingsRefinementsPagedCallable() {
    return listFindingsRefinementsPagedCallable;
  }

  @Override
  public UnaryCallable<CreateFindingsRefinementRequest, FindingsRefinement>
      createFindingsRefinementCallable() {
    return createFindingsRefinementCallable;
  }

  @Override
  public UnaryCallable<UpdateFindingsRefinementRequest, FindingsRefinement>
      updateFindingsRefinementCallable() {
    return updateFindingsRefinementCallable;
  }

  @Override
  public UnaryCallable<GetFindingsRefinementDeploymentRequest, FindingsRefinementDeployment>
      getFindingsRefinementDeploymentCallable() {
    return getFindingsRefinementDeploymentCallable;
  }

  @Override
  public UnaryCallable<UpdateFindingsRefinementDeploymentRequest, FindingsRefinementDeployment>
      updateFindingsRefinementDeploymentCallable() {
    return updateFindingsRefinementDeploymentCallable;
  }

  @Override
  public UnaryCallable<
          ListAllFindingsRefinementDeploymentsRequest, ListAllFindingsRefinementDeploymentsResponse>
      listAllFindingsRefinementDeploymentsCallable() {
    return listAllFindingsRefinementDeploymentsCallable;
  }

  @Override
  public UnaryCallable<
          ListAllFindingsRefinementDeploymentsRequest,
          ListAllFindingsRefinementDeploymentsPagedResponse>
      listAllFindingsRefinementDeploymentsPagedCallable() {
    return listAllFindingsRefinementDeploymentsPagedCallable;
  }

  @Override
  public UnaryCallable<
          ComputeFindingsRefinementActivityRequest, ComputeFindingsRefinementActivityResponse>
      computeFindingsRefinementActivityCallable() {
    return computeFindingsRefinementActivityCallable;
  }

  @Override
  public UnaryCallable<
          ComputeAllFindingsRefinementActivitiesRequest,
          ComputeAllFindingsRefinementActivitiesResponse>
      computeAllFindingsRefinementActivitiesCallable() {
    return computeAllFindingsRefinementActivitiesCallable;
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
