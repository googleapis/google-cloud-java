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

package com.google.cloud.functions.v1.stub;

import static com.google.cloud.functions.v1.CloudFunctionsServiceClient.ListFunctionsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.functions.v1.CallFunctionRequest;
import com.google.cloud.functions.v1.CallFunctionResponse;
import com.google.cloud.functions.v1.CloudFunction;
import com.google.cloud.functions.v1.CreateFunctionRequest;
import com.google.cloud.functions.v1.DeleteFunctionRequest;
import com.google.cloud.functions.v1.GenerateDownloadUrlRequest;
import com.google.cloud.functions.v1.GenerateDownloadUrlResponse;
import com.google.cloud.functions.v1.GenerateUploadUrlRequest;
import com.google.cloud.functions.v1.GenerateUploadUrlResponse;
import com.google.cloud.functions.v1.GetFunctionRequest;
import com.google.cloud.functions.v1.ListFunctionsRequest;
import com.google.cloud.functions.v1.ListFunctionsResponse;
import com.google.cloud.functions.v1.OperationMetadataV1;
import com.google.cloud.functions.v1.UpdateFunctionRequest;
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
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the CloudFunctionsService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcCloudFunctionsServiceStub extends CloudFunctionsServiceStub {
  private static final MethodDescriptor<ListFunctionsRequest, ListFunctionsResponse>
      listFunctionsMethodDescriptor =
          MethodDescriptor.<ListFunctionsRequest, ListFunctionsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.functions.v1.CloudFunctionsService/ListFunctions")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListFunctionsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListFunctionsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetFunctionRequest, CloudFunction>
      getFunctionMethodDescriptor =
          MethodDescriptor.<GetFunctionRequest, CloudFunction>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.functions.v1.CloudFunctionsService/GetFunction")
              .setRequestMarshaller(ProtoUtils.marshaller(GetFunctionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(CloudFunction.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateFunctionRequest, Operation>
      createFunctionMethodDescriptor =
          MethodDescriptor.<CreateFunctionRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.functions.v1.CloudFunctionsService/CreateFunction")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateFunctionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateFunctionRequest, Operation>
      updateFunctionMethodDescriptor =
          MethodDescriptor.<UpdateFunctionRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.functions.v1.CloudFunctionsService/UpdateFunction")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateFunctionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteFunctionRequest, Operation>
      deleteFunctionMethodDescriptor =
          MethodDescriptor.<DeleteFunctionRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.functions.v1.CloudFunctionsService/DeleteFunction")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteFunctionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CallFunctionRequest, CallFunctionResponse>
      callFunctionMethodDescriptor =
          MethodDescriptor.<CallFunctionRequest, CallFunctionResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.functions.v1.CloudFunctionsService/CallFunction")
              .setRequestMarshaller(ProtoUtils.marshaller(CallFunctionRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(CallFunctionResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GenerateUploadUrlRequest, GenerateUploadUrlResponse>
      generateUploadUrlMethodDescriptor =
          MethodDescriptor.<GenerateUploadUrlRequest, GenerateUploadUrlResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.functions.v1.CloudFunctionsService/GenerateUploadUrl")
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
                  "google.cloud.functions.v1.CloudFunctionsService/GenerateDownloadUrl")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GenerateDownloadUrlRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(GenerateDownloadUrlResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<SetIamPolicyRequest, Policy> setIamPolicyMethodDescriptor =
      MethodDescriptor.<SetIamPolicyRequest, Policy>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.functions.v1.CloudFunctionsService/SetIamPolicy")
          .setRequestMarshaller(ProtoUtils.marshaller(SetIamPolicyRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Policy.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<GetIamPolicyRequest, Policy> getIamPolicyMethodDescriptor =
      MethodDescriptor.<GetIamPolicyRequest, Policy>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.functions.v1.CloudFunctionsService/GetIamPolicy")
          .setRequestMarshaller(ProtoUtils.marshaller(GetIamPolicyRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Policy.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsMethodDescriptor =
          MethodDescriptor.<TestIamPermissionsRequest, TestIamPermissionsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.functions.v1.CloudFunctionsService/TestIamPermissions")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(TestIamPermissionsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(TestIamPermissionsResponse.getDefaultInstance()))
              .build();

  private final UnaryCallable<ListFunctionsRequest, ListFunctionsResponse> listFunctionsCallable;
  private final UnaryCallable<ListFunctionsRequest, ListFunctionsPagedResponse>
      listFunctionsPagedCallable;
  private final UnaryCallable<GetFunctionRequest, CloudFunction> getFunctionCallable;
  private final UnaryCallable<CreateFunctionRequest, Operation> createFunctionCallable;
  private final OperationCallable<CreateFunctionRequest, CloudFunction, OperationMetadataV1>
      createFunctionOperationCallable;
  private final UnaryCallable<UpdateFunctionRequest, Operation> updateFunctionCallable;
  private final OperationCallable<UpdateFunctionRequest, CloudFunction, OperationMetadataV1>
      updateFunctionOperationCallable;
  private final UnaryCallable<DeleteFunctionRequest, Operation> deleteFunctionCallable;
  private final OperationCallable<DeleteFunctionRequest, Empty, OperationMetadataV1>
      deleteFunctionOperationCallable;
  private final UnaryCallable<CallFunctionRequest, CallFunctionResponse> callFunctionCallable;
  private final UnaryCallable<GenerateUploadUrlRequest, GenerateUploadUrlResponse>
      generateUploadUrlCallable;
  private final UnaryCallable<GenerateDownloadUrlRequest, GenerateDownloadUrlResponse>
      generateDownloadUrlCallable;
  private final UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable;
  private final UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable;
  private final UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcCloudFunctionsServiceStub create(
      CloudFunctionsServiceStubSettings settings) throws IOException {
    return new GrpcCloudFunctionsServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcCloudFunctionsServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcCloudFunctionsServiceStub(
        CloudFunctionsServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcCloudFunctionsServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcCloudFunctionsServiceStub(
        CloudFunctionsServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcCloudFunctionsServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcCloudFunctionsServiceStub(
      CloudFunctionsServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcCloudFunctionsServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcCloudFunctionsServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcCloudFunctionsServiceStub(
      CloudFunctionsServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

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
    GrpcCallSettings<GetFunctionRequest, CloudFunction> getFunctionTransportSettings =
        GrpcCallSettings.<GetFunctionRequest, CloudFunction>newBuilder()
            .setMethodDescriptor(getFunctionMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<CreateFunctionRequest, Operation> createFunctionTransportSettings =
        GrpcCallSettings.<CreateFunctionRequest, Operation>newBuilder()
            .setMethodDescriptor(createFunctionMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("location", String.valueOf(request.getLocation()));
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
    GrpcCallSettings<CallFunctionRequest, CallFunctionResponse> callFunctionTransportSettings =
        GrpcCallSettings.<CallFunctionRequest, CallFunctionResponse>newBuilder()
            .setMethodDescriptor(callFunctionMethodDescriptor)
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

    this.listFunctionsCallable =
        callableFactory.createUnaryCallable(
            listFunctionsTransportSettings, settings.listFunctionsSettings(), clientContext);
    this.listFunctionsPagedCallable =
        callableFactory.createPagedCallable(
            listFunctionsTransportSettings, settings.listFunctionsSettings(), clientContext);
    this.getFunctionCallable =
        callableFactory.createUnaryCallable(
            getFunctionTransportSettings, settings.getFunctionSettings(), clientContext);
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
    this.callFunctionCallable =
        callableFactory.createUnaryCallable(
            callFunctionTransportSettings, settings.callFunctionSettings(), clientContext);
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
  public UnaryCallable<ListFunctionsRequest, ListFunctionsResponse> listFunctionsCallable() {
    return listFunctionsCallable;
  }

  @Override
  public UnaryCallable<ListFunctionsRequest, ListFunctionsPagedResponse>
      listFunctionsPagedCallable() {
    return listFunctionsPagedCallable;
  }

  @Override
  public UnaryCallable<GetFunctionRequest, CloudFunction> getFunctionCallable() {
    return getFunctionCallable;
  }

  @Override
  public UnaryCallable<CreateFunctionRequest, Operation> createFunctionCallable() {
    return createFunctionCallable;
  }

  @Override
  public OperationCallable<CreateFunctionRequest, CloudFunction, OperationMetadataV1>
      createFunctionOperationCallable() {
    return createFunctionOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateFunctionRequest, Operation> updateFunctionCallable() {
    return updateFunctionCallable;
  }

  @Override
  public OperationCallable<UpdateFunctionRequest, CloudFunction, OperationMetadataV1>
      updateFunctionOperationCallable() {
    return updateFunctionOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteFunctionRequest, Operation> deleteFunctionCallable() {
    return deleteFunctionCallable;
  }

  @Override
  public OperationCallable<DeleteFunctionRequest, Empty, OperationMetadataV1>
      deleteFunctionOperationCallable() {
    return deleteFunctionOperationCallable;
  }

  @Override
  public UnaryCallable<CallFunctionRequest, CallFunctionResponse> callFunctionCallable() {
    return callFunctionCallable;
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
