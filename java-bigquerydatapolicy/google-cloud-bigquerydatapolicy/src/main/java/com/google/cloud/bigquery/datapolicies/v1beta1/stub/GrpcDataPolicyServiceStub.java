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

package com.google.cloud.bigquery.datapolicies.v1beta1.stub;

import static com.google.cloud.bigquery.datapolicies.v1beta1.DataPolicyServiceClient.ListDataPoliciesPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.bigquery.datapolicies.v1beta1.CreateDataPolicyRequest;
import com.google.cloud.bigquery.datapolicies.v1beta1.DataPolicy;
import com.google.cloud.bigquery.datapolicies.v1beta1.DeleteDataPolicyRequest;
import com.google.cloud.bigquery.datapolicies.v1beta1.GetDataPolicyRequest;
import com.google.cloud.bigquery.datapolicies.v1beta1.ListDataPoliciesRequest;
import com.google.cloud.bigquery.datapolicies.v1beta1.ListDataPoliciesResponse;
import com.google.cloud.bigquery.datapolicies.v1beta1.UpdateDataPolicyRequest;
import com.google.common.collect.ImmutableMap;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.protobuf.Empty;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the DataPolicyService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GrpcDataPolicyServiceStub extends DataPolicyServiceStub {
  private static final MethodDescriptor<CreateDataPolicyRequest, DataPolicy>
      createDataPolicyMethodDescriptor =
          MethodDescriptor.<CreateDataPolicyRequest, DataPolicy>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.bigquery.datapolicies.v1beta1.DataPolicyService/CreateDataPolicy")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateDataPolicyRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(DataPolicy.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateDataPolicyRequest, DataPolicy>
      updateDataPolicyMethodDescriptor =
          MethodDescriptor.<UpdateDataPolicyRequest, DataPolicy>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.bigquery.datapolicies.v1beta1.DataPolicyService/UpdateDataPolicy")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateDataPolicyRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(DataPolicy.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteDataPolicyRequest, Empty>
      deleteDataPolicyMethodDescriptor =
          MethodDescriptor.<DeleteDataPolicyRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.bigquery.datapolicies.v1beta1.DataPolicyService/DeleteDataPolicy")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteDataPolicyRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetDataPolicyRequest, DataPolicy>
      getDataPolicyMethodDescriptor =
          MethodDescriptor.<GetDataPolicyRequest, DataPolicy>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.bigquery.datapolicies.v1beta1.DataPolicyService/GetDataPolicy")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetDataPolicyRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(DataPolicy.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListDataPoliciesRequest, ListDataPoliciesResponse>
      listDataPoliciesMethodDescriptor =
          MethodDescriptor.<ListDataPoliciesRequest, ListDataPoliciesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.bigquery.datapolicies.v1beta1.DataPolicyService/ListDataPolicies")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListDataPoliciesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListDataPoliciesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetIamPolicyRequest, Policy> getIamPolicyMethodDescriptor =
      MethodDescriptor.<GetIamPolicyRequest, Policy>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(
              "google.cloud.bigquery.datapolicies.v1beta1.DataPolicyService/GetIamPolicy")
          .setRequestMarshaller(ProtoUtils.marshaller(GetIamPolicyRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Policy.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<SetIamPolicyRequest, Policy> setIamPolicyMethodDescriptor =
      MethodDescriptor.<SetIamPolicyRequest, Policy>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(
              "google.cloud.bigquery.datapolicies.v1beta1.DataPolicyService/SetIamPolicy")
          .setRequestMarshaller(ProtoUtils.marshaller(SetIamPolicyRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Policy.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsMethodDescriptor =
          MethodDescriptor.<TestIamPermissionsRequest, TestIamPermissionsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.bigquery.datapolicies.v1beta1.DataPolicyService/TestIamPermissions")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(TestIamPermissionsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(TestIamPermissionsResponse.getDefaultInstance()))
              .build();

  private final UnaryCallable<CreateDataPolicyRequest, DataPolicy> createDataPolicyCallable;
  private final UnaryCallable<UpdateDataPolicyRequest, DataPolicy> updateDataPolicyCallable;
  private final UnaryCallable<DeleteDataPolicyRequest, Empty> deleteDataPolicyCallable;
  private final UnaryCallable<GetDataPolicyRequest, DataPolicy> getDataPolicyCallable;
  private final UnaryCallable<ListDataPoliciesRequest, ListDataPoliciesResponse>
      listDataPoliciesCallable;
  private final UnaryCallable<ListDataPoliciesRequest, ListDataPoliciesPagedResponse>
      listDataPoliciesPagedCallable;
  private final UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable;
  private final UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable;
  private final UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcDataPolicyServiceStub create(DataPolicyServiceStubSettings settings)
      throws IOException {
    return new GrpcDataPolicyServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcDataPolicyServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcDataPolicyServiceStub(
        DataPolicyServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcDataPolicyServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcDataPolicyServiceStub(
        DataPolicyServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcDataPolicyServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcDataPolicyServiceStub(
      DataPolicyServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcDataPolicyServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcDataPolicyServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcDataPolicyServiceStub(
      DataPolicyServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<CreateDataPolicyRequest, DataPolicy> createDataPolicyTransportSettings =
        GrpcCallSettings.<CreateDataPolicyRequest, DataPolicy>newBuilder()
            .setMethodDescriptor(createDataPolicyMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<UpdateDataPolicyRequest, DataPolicy> updateDataPolicyTransportSettings =
        GrpcCallSettings.<UpdateDataPolicyRequest, DataPolicy>newBuilder()
            .setMethodDescriptor(updateDataPolicyMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("data_policy.name", String.valueOf(request.getDataPolicy().getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<DeleteDataPolicyRequest, Empty> deleteDataPolicyTransportSettings =
        GrpcCallSettings.<DeleteDataPolicyRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteDataPolicyMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<GetDataPolicyRequest, DataPolicy> getDataPolicyTransportSettings =
        GrpcCallSettings.<GetDataPolicyRequest, DataPolicy>newBuilder()
            .setMethodDescriptor(getDataPolicyMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<ListDataPoliciesRequest, ListDataPoliciesResponse>
        listDataPoliciesTransportSettings =
            GrpcCallSettings.<ListDataPoliciesRequest, ListDataPoliciesResponse>newBuilder()
                .setMethodDescriptor(listDataPoliciesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
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

    this.createDataPolicyCallable =
        callableFactory.createUnaryCallable(
            createDataPolicyTransportSettings, settings.createDataPolicySettings(), clientContext);
    this.updateDataPolicyCallable =
        callableFactory.createUnaryCallable(
            updateDataPolicyTransportSettings, settings.updateDataPolicySettings(), clientContext);
    this.deleteDataPolicyCallable =
        callableFactory.createUnaryCallable(
            deleteDataPolicyTransportSettings, settings.deleteDataPolicySettings(), clientContext);
    this.getDataPolicyCallable =
        callableFactory.createUnaryCallable(
            getDataPolicyTransportSettings, settings.getDataPolicySettings(), clientContext);
    this.listDataPoliciesCallable =
        callableFactory.createUnaryCallable(
            listDataPoliciesTransportSettings, settings.listDataPoliciesSettings(), clientContext);
    this.listDataPoliciesPagedCallable =
        callableFactory.createPagedCallable(
            listDataPoliciesTransportSettings, settings.listDataPoliciesSettings(), clientContext);
    this.getIamPolicyCallable =
        callableFactory.createUnaryCallable(
            getIamPolicyTransportSettings, settings.getIamPolicySettings(), clientContext);
    this.setIamPolicyCallable =
        callableFactory.createUnaryCallable(
            setIamPolicyTransportSettings, settings.setIamPolicySettings(), clientContext);
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
  public UnaryCallable<CreateDataPolicyRequest, DataPolicy> createDataPolicyCallable() {
    return createDataPolicyCallable;
  }

  @Override
  public UnaryCallable<UpdateDataPolicyRequest, DataPolicy> updateDataPolicyCallable() {
    return updateDataPolicyCallable;
  }

  @Override
  public UnaryCallable<DeleteDataPolicyRequest, Empty> deleteDataPolicyCallable() {
    return deleteDataPolicyCallable;
  }

  @Override
  public UnaryCallable<GetDataPolicyRequest, DataPolicy> getDataPolicyCallable() {
    return getDataPolicyCallable;
  }

  @Override
  public UnaryCallable<ListDataPoliciesRequest, ListDataPoliciesResponse>
      listDataPoliciesCallable() {
    return listDataPoliciesCallable;
  }

  @Override
  public UnaryCallable<ListDataPoliciesRequest, ListDataPoliciesPagedResponse>
      listDataPoliciesPagedCallable() {
    return listDataPoliciesPagedCallable;
  }

  @Override
  public UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable() {
    return getIamPolicyCallable;
  }

  @Override
  public UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable() {
    return setIamPolicyCallable;
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
