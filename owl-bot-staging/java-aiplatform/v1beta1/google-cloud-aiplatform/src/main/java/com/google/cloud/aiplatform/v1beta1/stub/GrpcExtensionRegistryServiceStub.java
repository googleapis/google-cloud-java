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

import static com.google.cloud.aiplatform.v1beta1.ExtensionRegistryServiceClient.ListExtensionsPagedResponse;
import static com.google.cloud.aiplatform.v1beta1.ExtensionRegistryServiceClient.ListLocationsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.aiplatform.v1beta1.DeleteExtensionRequest;
import com.google.cloud.aiplatform.v1beta1.DeleteOperationMetadata;
import com.google.cloud.aiplatform.v1beta1.Extension;
import com.google.cloud.aiplatform.v1beta1.GetExtensionRequest;
import com.google.cloud.aiplatform.v1beta1.ImportExtensionOperationMetadata;
import com.google.cloud.aiplatform.v1beta1.ImportExtensionRequest;
import com.google.cloud.aiplatform.v1beta1.ListExtensionsRequest;
import com.google.cloud.aiplatform.v1beta1.ListExtensionsResponse;
import com.google.cloud.aiplatform.v1beta1.UpdateExtensionRequest;
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
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the ExtensionRegistryService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GrpcExtensionRegistryServiceStub extends ExtensionRegistryServiceStub {
  private static final MethodDescriptor<ImportExtensionRequest, Operation>
      importExtensionMethodDescriptor =
          MethodDescriptor.<ImportExtensionRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.aiplatform.v1beta1.ExtensionRegistryService/ImportExtension")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ImportExtensionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetExtensionRequest, Extension>
      getExtensionMethodDescriptor =
          MethodDescriptor.<GetExtensionRequest, Extension>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.aiplatform.v1beta1.ExtensionRegistryService/GetExtension")
              .setRequestMarshaller(ProtoUtils.marshaller(GetExtensionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Extension.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListExtensionsRequest, ListExtensionsResponse>
      listExtensionsMethodDescriptor =
          MethodDescriptor.<ListExtensionsRequest, ListExtensionsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.aiplatform.v1beta1.ExtensionRegistryService/ListExtensions")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListExtensionsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListExtensionsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateExtensionRequest, Extension>
      updateExtensionMethodDescriptor =
          MethodDescriptor.<UpdateExtensionRequest, Extension>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.aiplatform.v1beta1.ExtensionRegistryService/UpdateExtension")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateExtensionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Extension.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteExtensionRequest, Operation>
      deleteExtensionMethodDescriptor =
          MethodDescriptor.<DeleteExtensionRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.aiplatform.v1beta1.ExtensionRegistryService/DeleteExtension")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteExtensionRequest.getDefaultInstance()))
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

  private final UnaryCallable<ImportExtensionRequest, Operation> importExtensionCallable;
  private final OperationCallable<
          ImportExtensionRequest, Extension, ImportExtensionOperationMetadata>
      importExtensionOperationCallable;
  private final UnaryCallable<GetExtensionRequest, Extension> getExtensionCallable;
  private final UnaryCallable<ListExtensionsRequest, ListExtensionsResponse> listExtensionsCallable;
  private final UnaryCallable<ListExtensionsRequest, ListExtensionsPagedResponse>
      listExtensionsPagedCallable;
  private final UnaryCallable<UpdateExtensionRequest, Extension> updateExtensionCallable;
  private final UnaryCallable<DeleteExtensionRequest, Operation> deleteExtensionCallable;
  private final OperationCallable<DeleteExtensionRequest, Empty, DeleteOperationMetadata>
      deleteExtensionOperationCallable;
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

  public static final GrpcExtensionRegistryServiceStub create(
      ExtensionRegistryServiceStubSettings settings) throws IOException {
    return new GrpcExtensionRegistryServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcExtensionRegistryServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcExtensionRegistryServiceStub(
        ExtensionRegistryServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcExtensionRegistryServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcExtensionRegistryServiceStub(
        ExtensionRegistryServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcExtensionRegistryServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcExtensionRegistryServiceStub(
      ExtensionRegistryServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcExtensionRegistryServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcExtensionRegistryServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcExtensionRegistryServiceStub(
      ExtensionRegistryServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<ImportExtensionRequest, Operation> importExtensionTransportSettings =
        GrpcCallSettings.<ImportExtensionRequest, Operation>newBuilder()
            .setMethodDescriptor(importExtensionMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetExtensionRequest, Extension> getExtensionTransportSettings =
        GrpcCallSettings.<GetExtensionRequest, Extension>newBuilder()
            .setMethodDescriptor(getExtensionMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListExtensionsRequest, ListExtensionsResponse>
        listExtensionsTransportSettings =
            GrpcCallSettings.<ListExtensionsRequest, ListExtensionsResponse>newBuilder()
                .setMethodDescriptor(listExtensionsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<UpdateExtensionRequest, Extension> updateExtensionTransportSettings =
        GrpcCallSettings.<UpdateExtensionRequest, Extension>newBuilder()
            .setMethodDescriptor(updateExtensionMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("extension.name", String.valueOf(request.getExtension().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteExtensionRequest, Operation> deleteExtensionTransportSettings =
        GrpcCallSettings.<DeleteExtensionRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteExtensionMethodDescriptor)
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

    this.importExtensionCallable =
        callableFactory.createUnaryCallable(
            importExtensionTransportSettings, settings.importExtensionSettings(), clientContext);
    this.importExtensionOperationCallable =
        callableFactory.createOperationCallable(
            importExtensionTransportSettings,
            settings.importExtensionOperationSettings(),
            clientContext,
            operationsStub);
    this.getExtensionCallable =
        callableFactory.createUnaryCallable(
            getExtensionTransportSettings, settings.getExtensionSettings(), clientContext);
    this.listExtensionsCallable =
        callableFactory.createUnaryCallable(
            listExtensionsTransportSettings, settings.listExtensionsSettings(), clientContext);
    this.listExtensionsPagedCallable =
        callableFactory.createPagedCallable(
            listExtensionsTransportSettings, settings.listExtensionsSettings(), clientContext);
    this.updateExtensionCallable =
        callableFactory.createUnaryCallable(
            updateExtensionTransportSettings, settings.updateExtensionSettings(), clientContext);
    this.deleteExtensionCallable =
        callableFactory.createUnaryCallable(
            deleteExtensionTransportSettings, settings.deleteExtensionSettings(), clientContext);
    this.deleteExtensionOperationCallable =
        callableFactory.createOperationCallable(
            deleteExtensionTransportSettings,
            settings.deleteExtensionOperationSettings(),
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
  public UnaryCallable<ImportExtensionRequest, Operation> importExtensionCallable() {
    return importExtensionCallable;
  }

  @Override
  public OperationCallable<ImportExtensionRequest, Extension, ImportExtensionOperationMetadata>
      importExtensionOperationCallable() {
    return importExtensionOperationCallable;
  }

  @Override
  public UnaryCallable<GetExtensionRequest, Extension> getExtensionCallable() {
    return getExtensionCallable;
  }

  @Override
  public UnaryCallable<ListExtensionsRequest, ListExtensionsResponse> listExtensionsCallable() {
    return listExtensionsCallable;
  }

  @Override
  public UnaryCallable<ListExtensionsRequest, ListExtensionsPagedResponse>
      listExtensionsPagedCallable() {
    return listExtensionsPagedCallable;
  }

  @Override
  public UnaryCallable<UpdateExtensionRequest, Extension> updateExtensionCallable() {
    return updateExtensionCallable;
  }

  @Override
  public UnaryCallable<DeleteExtensionRequest, Operation> deleteExtensionCallable() {
    return deleteExtensionCallable;
  }

  @Override
  public OperationCallable<DeleteExtensionRequest, Empty, DeleteOperationMetadata>
      deleteExtensionOperationCallable() {
    return deleteExtensionOperationCallable;
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
