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

package com.google.cloud.aiplatform.v1beta1.stub;

import static com.google.cloud.aiplatform.v1beta1.PersistentResourceServiceClient.ListLocationsPagedResponse;
import static com.google.cloud.aiplatform.v1beta1.PersistentResourceServiceClient.ListPersistentResourcesPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.aiplatform.v1beta1.CreatePersistentResourceOperationMetadata;
import com.google.cloud.aiplatform.v1beta1.CreatePersistentResourceRequest;
import com.google.cloud.aiplatform.v1beta1.DeleteOperationMetadata;
import com.google.cloud.aiplatform.v1beta1.DeletePersistentResourceRequest;
import com.google.cloud.aiplatform.v1beta1.GetPersistentResourceRequest;
import com.google.cloud.aiplatform.v1beta1.ListPersistentResourcesRequest;
import com.google.cloud.aiplatform.v1beta1.ListPersistentResourcesResponse;
import com.google.cloud.aiplatform.v1beta1.PersistentResource;
import com.google.cloud.aiplatform.v1beta1.RebootPersistentResourceOperationMetadata;
import com.google.cloud.aiplatform.v1beta1.RebootPersistentResourceRequest;
import com.google.cloud.aiplatform.v1beta1.UpdatePersistentResourceOperationMetadata;
import com.google.cloud.aiplatform.v1beta1.UpdatePersistentResourceRequest;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.protobuf.Empty;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the PersistentResourceService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GrpcPersistentResourceServiceStub extends PersistentResourceServiceStub {
  private static final MethodDescriptor<CreatePersistentResourceRequest, Operation>
      createPersistentResourceMethodDescriptor =
          MethodDescriptor.<CreatePersistentResourceRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.aiplatform.v1beta1.PersistentResourceService/CreatePersistentResource")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreatePersistentResourceRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetPersistentResourceRequest, PersistentResource>
      getPersistentResourceMethodDescriptor =
          MethodDescriptor.<GetPersistentResourceRequest, PersistentResource>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.aiplatform.v1beta1.PersistentResourceService/GetPersistentResource")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetPersistentResourceRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(PersistentResource.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          ListPersistentResourcesRequest, ListPersistentResourcesResponse>
      listPersistentResourcesMethodDescriptor =
          MethodDescriptor
              .<ListPersistentResourcesRequest, ListPersistentResourcesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.aiplatform.v1beta1.PersistentResourceService/ListPersistentResources")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListPersistentResourcesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListPersistentResourcesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeletePersistentResourceRequest, Operation>
      deletePersistentResourceMethodDescriptor =
          MethodDescriptor.<DeletePersistentResourceRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.aiplatform.v1beta1.PersistentResourceService/DeletePersistentResource")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeletePersistentResourceRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdatePersistentResourceRequest, Operation>
      updatePersistentResourceMethodDescriptor =
          MethodDescriptor.<UpdatePersistentResourceRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.aiplatform.v1beta1.PersistentResourceService/UpdatePersistentResource")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdatePersistentResourceRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<RebootPersistentResourceRequest, Operation>
      rebootPersistentResourceMethodDescriptor =
          MethodDescriptor.<RebootPersistentResourceRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.aiplatform.v1beta1.PersistentResourceService/RebootPersistentResource")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(RebootPersistentResourceRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListLocationsRequest, ListLocationsResponse>
      listLocationsMethodDescriptor =
          MethodDescriptor.<ListLocationsRequest, ListLocationsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.location.Locations/ListLocations")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListLocationsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListLocationsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetLocationRequest, Location> getLocationMethodDescriptor =
      MethodDescriptor.<GetLocationRequest, Location>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.location.Locations/GetLocation")
          .setRequestMarshaller(ProtoUtils.marshaller(GetLocationRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Location.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<SetIamPolicyRequest, Policy> setIamPolicyMethodDescriptor =
      MethodDescriptor.<SetIamPolicyRequest, Policy>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.iam.v1.IAMPolicy/SetIamPolicy")
          .setRequestMarshaller(ProtoUtils.marshaller(SetIamPolicyRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Policy.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<GetIamPolicyRequest, Policy> getIamPolicyMethodDescriptor =
      MethodDescriptor.<GetIamPolicyRequest, Policy>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.iam.v1.IAMPolicy/GetIamPolicy")
          .setRequestMarshaller(ProtoUtils.marshaller(GetIamPolicyRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Policy.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsMethodDescriptor =
          MethodDescriptor.<TestIamPermissionsRequest, TestIamPermissionsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.iam.v1.IAMPolicy/TestIamPermissions")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(TestIamPermissionsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(TestIamPermissionsResponse.getDefaultInstance()))
              .build();

  private final UnaryCallable<CreatePersistentResourceRequest, Operation>
      createPersistentResourceCallable;
  private final OperationCallable<
          CreatePersistentResourceRequest,
          PersistentResource,
          CreatePersistentResourceOperationMetadata>
      createPersistentResourceOperationCallable;
  private final UnaryCallable<GetPersistentResourceRequest, PersistentResource>
      getPersistentResourceCallable;
  private final UnaryCallable<ListPersistentResourcesRequest, ListPersistentResourcesResponse>
      listPersistentResourcesCallable;
  private final UnaryCallable<ListPersistentResourcesRequest, ListPersistentResourcesPagedResponse>
      listPersistentResourcesPagedCallable;
  private final UnaryCallable<DeletePersistentResourceRequest, Operation>
      deletePersistentResourceCallable;
  private final OperationCallable<DeletePersistentResourceRequest, Empty, DeleteOperationMetadata>
      deletePersistentResourceOperationCallable;
  private final UnaryCallable<UpdatePersistentResourceRequest, Operation>
      updatePersistentResourceCallable;
  private final OperationCallable<
          UpdatePersistentResourceRequest,
          PersistentResource,
          UpdatePersistentResourceOperationMetadata>
      updatePersistentResourceOperationCallable;
  private final UnaryCallable<RebootPersistentResourceRequest, Operation>
      rebootPersistentResourceCallable;
  private final OperationCallable<
          RebootPersistentResourceRequest,
          PersistentResource,
          RebootPersistentResourceOperationMetadata>
      rebootPersistentResourceOperationCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;
  private final UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable;
  private final UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable;
  private final UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcPersistentResourceServiceStub create(
      PersistentResourceServiceStubSettings settings) throws IOException {
    return new GrpcPersistentResourceServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcPersistentResourceServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcPersistentResourceServiceStub(
        PersistentResourceServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcPersistentResourceServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcPersistentResourceServiceStub(
        PersistentResourceServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcPersistentResourceServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcPersistentResourceServiceStub(
      PersistentResourceServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcPersistentResourceServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcPersistentResourceServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcPersistentResourceServiceStub(
      PersistentResourceServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<CreatePersistentResourceRequest, Operation>
        createPersistentResourceTransportSettings =
            GrpcCallSettings.<CreatePersistentResourceRequest, Operation>newBuilder()
                .setMethodDescriptor(createPersistentResourceMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetPersistentResourceRequest, PersistentResource>
        getPersistentResourceTransportSettings =
            GrpcCallSettings.<GetPersistentResourceRequest, PersistentResource>newBuilder()
                .setMethodDescriptor(getPersistentResourceMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ListPersistentResourcesRequest, ListPersistentResourcesResponse>
        listPersistentResourcesTransportSettings =
            GrpcCallSettings
                .<ListPersistentResourcesRequest, ListPersistentResourcesResponse>newBuilder()
                .setMethodDescriptor(listPersistentResourcesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<DeletePersistentResourceRequest, Operation>
        deletePersistentResourceTransportSettings =
            GrpcCallSettings.<DeletePersistentResourceRequest, Operation>newBuilder()
                .setMethodDescriptor(deletePersistentResourceMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<UpdatePersistentResourceRequest, Operation>
        updatePersistentResourceTransportSettings =
            GrpcCallSettings.<UpdatePersistentResourceRequest, Operation>newBuilder()
                .setMethodDescriptor(updatePersistentResourceMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "persistent_resource.name",
                          String.valueOf(request.getPersistentResource().getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<RebootPersistentResourceRequest, Operation>
        rebootPersistentResourceTransportSettings =
            GrpcCallSettings.<RebootPersistentResourceRequest, Operation>newBuilder()
                .setMethodDescriptor(rebootPersistentResourceMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ListLocationsRequest, ListLocationsResponse> listLocationsTransportSettings =
        GrpcCallSettings.<ListLocationsRequest, ListLocationsResponse>newBuilder()
            .setMethodDescriptor(listLocationsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetLocationRequest, Location> getLocationTransportSettings =
        GrpcCallSettings.<GetLocationRequest, Location>newBuilder()
            .setMethodDescriptor(getLocationMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<SetIamPolicyRequest, Policy> setIamPolicyTransportSettings =
        GrpcCallSettings.<SetIamPolicyRequest, Policy>newBuilder()
            .setMethodDescriptor(setIamPolicyMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("resource", String.valueOf(request.getResource()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetIamPolicyRequest, Policy> getIamPolicyTransportSettings =
        GrpcCallSettings.<GetIamPolicyRequest, Policy>newBuilder()
            .setMethodDescriptor(getIamPolicyMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("resource", String.valueOf(request.getResource()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsTransportSettings =
            GrpcCallSettings.<TestIamPermissionsRequest, TestIamPermissionsResponse>newBuilder()
                .setMethodDescriptor(testIamPermissionsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("resource", String.valueOf(request.getResource()));
                      return builder.build();
                    })
                .build();

    this.createPersistentResourceCallable =
        callableFactory.createUnaryCallable(
            createPersistentResourceTransportSettings,
            settings.createPersistentResourceSettings(),
            clientContext);
    this.createPersistentResourceOperationCallable =
        callableFactory.createOperationCallable(
            createPersistentResourceTransportSettings,
            settings.createPersistentResourceOperationSettings(),
            clientContext,
            operationsStub);
    this.getPersistentResourceCallable =
        callableFactory.createUnaryCallable(
            getPersistentResourceTransportSettings,
            settings.getPersistentResourceSettings(),
            clientContext);
    this.listPersistentResourcesCallable =
        callableFactory.createUnaryCallable(
            listPersistentResourcesTransportSettings,
            settings.listPersistentResourcesSettings(),
            clientContext);
    this.listPersistentResourcesPagedCallable =
        callableFactory.createPagedCallable(
            listPersistentResourcesTransportSettings,
            settings.listPersistentResourcesSettings(),
            clientContext);
    this.deletePersistentResourceCallable =
        callableFactory.createUnaryCallable(
            deletePersistentResourceTransportSettings,
            settings.deletePersistentResourceSettings(),
            clientContext);
    this.deletePersistentResourceOperationCallable =
        callableFactory.createOperationCallable(
            deletePersistentResourceTransportSettings,
            settings.deletePersistentResourceOperationSettings(),
            clientContext,
            operationsStub);
    this.updatePersistentResourceCallable =
        callableFactory.createUnaryCallable(
            updatePersistentResourceTransportSettings,
            settings.updatePersistentResourceSettings(),
            clientContext);
    this.updatePersistentResourceOperationCallable =
        callableFactory.createOperationCallable(
            updatePersistentResourceTransportSettings,
            settings.updatePersistentResourceOperationSettings(),
            clientContext,
            operationsStub);
    this.rebootPersistentResourceCallable =
        callableFactory.createUnaryCallable(
            rebootPersistentResourceTransportSettings,
            settings.rebootPersistentResourceSettings(),
            clientContext);
    this.rebootPersistentResourceOperationCallable =
        callableFactory.createOperationCallable(
            rebootPersistentResourceTransportSettings,
            settings.rebootPersistentResourceOperationSettings(),
            clientContext,
            operationsStub);
    this.listLocationsCallable =
        callableFactory.createUnaryCallable(
            listLocationsTransportSettings, settings.listLocationsSettings(), clientContext);
    this.listLocationsPagedCallable =
        callableFactory.createPagedCallable(
            listLocationsTransportSettings, settings.listLocationsSettings(), clientContext);
    this.getLocationCallable =
        callableFactory.createUnaryCallable(
            getLocationTransportSettings, settings.getLocationSettings(), clientContext);
    this.setIamPolicyCallable =
        callableFactory.createUnaryCallable(
            setIamPolicyTransportSettings, settings.setIamPolicySettings(), clientContext);
    this.getIamPolicyCallable =
        callableFactory.createUnaryCallable(
            getIamPolicyTransportSettings, settings.getIamPolicySettings(), clientContext);
    this.testIamPermissionsCallable =
        callableFactory.createUnaryCallable(
            testIamPermissionsTransportSettings,
            settings.testIamPermissionsSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<CreatePersistentResourceRequest, Operation>
      createPersistentResourceCallable() {
    return createPersistentResourceCallable;
  }

  @Override
  public OperationCallable<
          CreatePersistentResourceRequest,
          PersistentResource,
          CreatePersistentResourceOperationMetadata>
      createPersistentResourceOperationCallable() {
    return createPersistentResourceOperationCallable;
  }

  @Override
  public UnaryCallable<GetPersistentResourceRequest, PersistentResource>
      getPersistentResourceCallable() {
    return getPersistentResourceCallable;
  }

  @Override
  public UnaryCallable<ListPersistentResourcesRequest, ListPersistentResourcesResponse>
      listPersistentResourcesCallable() {
    return listPersistentResourcesCallable;
  }

  @Override
  public UnaryCallable<ListPersistentResourcesRequest, ListPersistentResourcesPagedResponse>
      listPersistentResourcesPagedCallable() {
    return listPersistentResourcesPagedCallable;
  }

  @Override
  public UnaryCallable<DeletePersistentResourceRequest, Operation>
      deletePersistentResourceCallable() {
    return deletePersistentResourceCallable;
  }

  @Override
  public OperationCallable<DeletePersistentResourceRequest, Empty, DeleteOperationMetadata>
      deletePersistentResourceOperationCallable() {
    return deletePersistentResourceOperationCallable;
  }

  @Override
  public UnaryCallable<UpdatePersistentResourceRequest, Operation>
      updatePersistentResourceCallable() {
    return updatePersistentResourceCallable;
  }

  @Override
  public OperationCallable<
          UpdatePersistentResourceRequest,
          PersistentResource,
          UpdatePersistentResourceOperationMetadata>
      updatePersistentResourceOperationCallable() {
    return updatePersistentResourceOperationCallable;
  }

  @Override
  public UnaryCallable<RebootPersistentResourceRequest, Operation>
      rebootPersistentResourceCallable() {
    return rebootPersistentResourceCallable;
  }

  @Override
  public OperationCallable<
          RebootPersistentResourceRequest,
          PersistentResource,
          RebootPersistentResourceOperationMetadata>
      rebootPersistentResourceOperationCallable() {
    return rebootPersistentResourceOperationCallable;
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
  public UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable() {
    return setIamPolicyCallable;
  }

  @Override
  public UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable() {
    return getIamPolicyCallable;
  }

  @Override
  public UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable() {
    return testIamPermissionsCallable;
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
