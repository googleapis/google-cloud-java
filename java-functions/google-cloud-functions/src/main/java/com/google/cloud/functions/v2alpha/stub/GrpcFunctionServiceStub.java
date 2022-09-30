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

package com.google.cloud.functions.v2alpha.stub;

import static com.google.cloud.functions.v2alpha.FunctionServiceClient.ListFunctionsPagedResponse;
import static com.google.cloud.functions.v2alpha.FunctionServiceClient.ListLocationsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.functions.v2alpha.CreateFunctionRequest;
import com.google.cloud.functions.v2alpha.DeleteFunctionRequest;
import com.google.cloud.functions.v2alpha.Function;
import com.google.cloud.functions.v2alpha.GenerateDownloadUrlRequest;
import com.google.cloud.functions.v2alpha.GenerateDownloadUrlResponse;
import com.google.cloud.functions.v2alpha.GenerateUploadUrlRequest;
import com.google.cloud.functions.v2alpha.GenerateUploadUrlResponse;
import com.google.cloud.functions.v2alpha.GetFunctionRequest;
import com.google.cloud.functions.v2alpha.ListFunctionsRequest;
import com.google.cloud.functions.v2alpha.ListFunctionsResponse;
import com.google.cloud.functions.v2alpha.ListRuntimesRequest;
import com.google.cloud.functions.v2alpha.ListRuntimesResponse;
import com.google.cloud.functions.v2alpha.OperationMetadata;
import com.google.cloud.functions.v2alpha.UpdateFunctionRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.common.collect.ImmutableMap;
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
 * gRPC stub implementation for the FunctionService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GrpcFunctionServiceStub extends FunctionServiceStub {
  private static final MethodDescriptor<GetFunctionRequest, Function> getFunctionMethodDescriptor =
      MethodDescriptor.<GetFunctionRequest, Function>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.functions.v2alpha.FunctionService/GetFunction")
          .setRequestMarshaller(ProtoUtils.marshaller(GetFunctionRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Function.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<ListFunctionsRequest, ListFunctionsResponse>
      listFunctionsMethodDescriptor =
          MethodDescriptor.<ListFunctionsRequest, ListFunctionsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.functions.v2alpha.FunctionService/ListFunctions")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListFunctionsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListFunctionsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateFunctionRequest, Operation>
      createFunctionMethodDescriptor =
          MethodDescriptor.<CreateFunctionRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.functions.v2alpha.FunctionService/CreateFunction")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateFunctionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateFunctionRequest, Operation>
      updateFunctionMethodDescriptor =
          MethodDescriptor.<UpdateFunctionRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.functions.v2alpha.FunctionService/UpdateFunction")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateFunctionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteFunctionRequest, Operation>
      deleteFunctionMethodDescriptor =
          MethodDescriptor.<DeleteFunctionRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.functions.v2alpha.FunctionService/DeleteFunction")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteFunctionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GenerateUploadUrlRequest, GenerateUploadUrlResponse>
      generateUploadUrlMethodDescriptor =
          MethodDescriptor.<GenerateUploadUrlRequest, GenerateUploadUrlResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.functions.v2alpha.FunctionService/GenerateUploadUrl")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GenerateUploadUrlRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(GenerateUploadUrlResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GenerateDownloadUrlRequest, GenerateDownloadUrlResponse>
      generateDownloadUrlMethodDescriptor =
          MethodDescriptor.<GenerateDownloadUrlRequest, GenerateDownloadUrlResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.functions.v2alpha.FunctionService/GenerateDownloadUrl")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GenerateDownloadUrlRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(GenerateDownloadUrlResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListRuntimesRequest, ListRuntimesResponse>
      listRuntimesMethodDescriptor =
          MethodDescriptor.<ListRuntimesRequest, ListRuntimesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.functions.v2alpha.FunctionService/ListRuntimes")
              .setRequestMarshaller(ProtoUtils.marshaller(ListRuntimesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListRuntimesResponse.getDefaultInstance()))
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

  private final UnaryCallable<GetFunctionRequest, Function> getFunctionCallable;
  private final UnaryCallable<ListFunctionsRequest, ListFunctionsResponse> listFunctionsCallable;
  private final UnaryCallable<ListFunctionsRequest, ListFunctionsPagedResponse>
      listFunctionsPagedCallable;
  private final UnaryCallable<CreateFunctionRequest, Operation> createFunctionCallable;
  private final OperationCallable<CreateFunctionRequest, Function, OperationMetadata>
      createFunctionOperationCallable;
  private final UnaryCallable<UpdateFunctionRequest, Operation> updateFunctionCallable;
  private final OperationCallable<UpdateFunctionRequest, Function, OperationMetadata>
      updateFunctionOperationCallable;
  private final UnaryCallable<DeleteFunctionRequest, Operation> deleteFunctionCallable;
  private final OperationCallable<DeleteFunctionRequest, Empty, OperationMetadata>
      deleteFunctionOperationCallable;
  private final UnaryCallable<GenerateUploadUrlRequest, GenerateUploadUrlResponse>
      generateUploadUrlCallable;
  private final UnaryCallable<GenerateDownloadUrlRequest, GenerateDownloadUrlResponse>
      generateDownloadUrlCallable;
  private final UnaryCallable<ListRuntimesRequest, ListRuntimesResponse> listRuntimesCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable;
  private final UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable;
  private final UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcFunctionServiceStub create(FunctionServiceStubSettings settings)
      throws IOException {
    return new GrpcFunctionServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcFunctionServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcFunctionServiceStub(
        FunctionServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcFunctionServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcFunctionServiceStub(
        FunctionServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcFunctionServiceStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcFunctionServiceStub(
      FunctionServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcFunctionServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcFunctionServiceStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcFunctionServiceStub(
      FunctionServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<GetFunctionRequest, Function> getFunctionTransportSettings =
        GrpcCallSettings.<GetFunctionRequest, Function>newBuilder()
            .setMethodDescriptor(getFunctionMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<ListFunctionsRequest, ListFunctionsResponse> listFunctionsTransportSettings =
        GrpcCallSettings.<ListFunctionsRequest, ListFunctionsResponse>newBuilder()
            .setMethodDescriptor(listFunctionsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<CreateFunctionRequest, Operation> createFunctionTransportSettings =
        GrpcCallSettings.<CreateFunctionRequest, Operation>newBuilder()
            .setMethodDescriptor(createFunctionMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<UpdateFunctionRequest, Operation> updateFunctionTransportSettings =
        GrpcCallSettings.<UpdateFunctionRequest, Operation>newBuilder()
            .setMethodDescriptor(updateFunctionMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("function.name", String.valueOf(request.getFunction().getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<DeleteFunctionRequest, Operation> deleteFunctionTransportSettings =
        GrpcCallSettings.<DeleteFunctionRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteFunctionMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<GenerateUploadUrlRequest, GenerateUploadUrlResponse>
        generateUploadUrlTransportSettings =
            GrpcCallSettings.<GenerateUploadUrlRequest, GenerateUploadUrlResponse>newBuilder()
                .setMethodDescriptor(generateUploadUrlMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<GenerateDownloadUrlRequest, GenerateDownloadUrlResponse>
        generateDownloadUrlTransportSettings =
            GrpcCallSettings.<GenerateDownloadUrlRequest, GenerateDownloadUrlResponse>newBuilder()
                .setMethodDescriptor(generateDownloadUrlMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<ListRuntimesRequest, ListRuntimesResponse> listRuntimesTransportSettings =
        GrpcCallSettings.<ListRuntimesRequest, ListRuntimesResponse>newBuilder()
            .setMethodDescriptor(listRuntimesMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<ListLocationsRequest, ListLocationsResponse> listLocationsTransportSettings =
        GrpcCallSettings.<ListLocationsRequest, ListLocationsResponse>newBuilder()
            .setMethodDescriptor(listLocationsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<SetIamPolicyRequest, Policy> setIamPolicyTransportSettings =
        GrpcCallSettings.<SetIamPolicyRequest, Policy>newBuilder()
            .setMethodDescriptor(setIamPolicyMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("resource", String.valueOf(request.getResource()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<GetIamPolicyRequest, Policy> getIamPolicyTransportSettings =
        GrpcCallSettings.<GetIamPolicyRequest, Policy>newBuilder()
            .setMethodDescriptor(getIamPolicyMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("resource", String.valueOf(request.getResource()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsTransportSettings =
            GrpcCallSettings.<TestIamPermissionsRequest, TestIamPermissionsResponse>newBuilder()
                .setMethodDescriptor(testIamPermissionsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("resource", String.valueOf(request.getResource()));
                      return params.build();
                    })
                .build();

    this.getFunctionCallable =
        callableFactory.createUnaryCallable(
            getFunctionTransportSettings, settings.getFunctionSettings(), clientContext);
    this.listFunctionsCallable =
        callableFactory.createUnaryCallable(
            listFunctionsTransportSettings, settings.listFunctionsSettings(), clientContext);
    this.listFunctionsPagedCallable =
        callableFactory.createPagedCallable(
            listFunctionsTransportSettings, settings.listFunctionsSettings(), clientContext);
    this.createFunctionCallable =
        callableFactory.createUnaryCallable(
            createFunctionTransportSettings, settings.createFunctionSettings(), clientContext);
    this.createFunctionOperationCallable =
        callableFactory.createOperationCallable(
            createFunctionTransportSettings,
            settings.createFunctionOperationSettings(),
            clientContext,
            operationsStub);
    this.updateFunctionCallable =
        callableFactory.createUnaryCallable(
            updateFunctionTransportSettings, settings.updateFunctionSettings(), clientContext);
    this.updateFunctionOperationCallable =
        callableFactory.createOperationCallable(
            updateFunctionTransportSettings,
            settings.updateFunctionOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteFunctionCallable =
        callableFactory.createUnaryCallable(
            deleteFunctionTransportSettings, settings.deleteFunctionSettings(), clientContext);
    this.deleteFunctionOperationCallable =
        callableFactory.createOperationCallable(
            deleteFunctionTransportSettings,
            settings.deleteFunctionOperationSettings(),
            clientContext,
            operationsStub);
    this.generateUploadUrlCallable =
        callableFactory.createUnaryCallable(
            generateUploadUrlTransportSettings,
            settings.generateUploadUrlSettings(),
            clientContext);
    this.generateDownloadUrlCallable =
        callableFactory.createUnaryCallable(
            generateDownloadUrlTransportSettings,
            settings.generateDownloadUrlSettings(),
            clientContext);
    this.listRuntimesCallable =
        callableFactory.createUnaryCallable(
            listRuntimesTransportSettings, settings.listRuntimesSettings(), clientContext);
    this.listLocationsCallable =
        callableFactory.createUnaryCallable(
            listLocationsTransportSettings, settings.listLocationsSettings(), clientContext);
    this.listLocationsPagedCallable =
        callableFactory.createPagedCallable(
            listLocationsTransportSettings, settings.listLocationsSettings(), clientContext);
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
  public UnaryCallable<GetFunctionRequest, Function> getFunctionCallable() {
    return getFunctionCallable;
  }

  @Override
  public UnaryCallable<ListFunctionsRequest, ListFunctionsResponse> listFunctionsCallable() {
    return listFunctionsCallable;
  }

  @Override
  public UnaryCallable<ListFunctionsRequest, ListFunctionsPagedResponse>
      listFunctionsPagedCallable() {
    return listFunctionsPagedCallable;
  }

  @Override
  public UnaryCallable<CreateFunctionRequest, Operation> createFunctionCallable() {
    return createFunctionCallable;
  }

  @Override
  public OperationCallable<CreateFunctionRequest, Function, OperationMetadata>
      createFunctionOperationCallable() {
    return createFunctionOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateFunctionRequest, Operation> updateFunctionCallable() {
    return updateFunctionCallable;
  }

  @Override
  public OperationCallable<UpdateFunctionRequest, Function, OperationMetadata>
      updateFunctionOperationCallable() {
    return updateFunctionOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteFunctionRequest, Operation> deleteFunctionCallable() {
    return deleteFunctionCallable;
  }

  @Override
  public OperationCallable<DeleteFunctionRequest, Empty, OperationMetadata>
      deleteFunctionOperationCallable() {
    return deleteFunctionOperationCallable;
  }

  @Override
  public UnaryCallable<GenerateUploadUrlRequest, GenerateUploadUrlResponse>
      generateUploadUrlCallable() {
    return generateUploadUrlCallable;
  }

  @Override
  public UnaryCallable<GenerateDownloadUrlRequest, GenerateDownloadUrlResponse>
      generateDownloadUrlCallable() {
    return generateDownloadUrlCallable;
  }

  @Override
  public UnaryCallable<ListRuntimesRequest, ListRuntimesResponse> listRuntimesCallable() {
    return listRuntimesCallable;
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
