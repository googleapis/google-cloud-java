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

import static com.google.cloud.contentwarehouse.v1.RuleSetServiceClient.ListRuleSetsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.contentwarehouse.v1.CreateRuleSetRequest;
import com.google.cloud.contentwarehouse.v1.DeleteRuleSetRequest;
import com.google.cloud.contentwarehouse.v1.GetRuleSetRequest;
import com.google.cloud.contentwarehouse.v1.ListRuleSetsRequest;
import com.google.cloud.contentwarehouse.v1.ListRuleSetsResponse;
import com.google.cloud.contentwarehouse.v1.RuleSet;
import com.google.cloud.contentwarehouse.v1.UpdateRuleSetRequest;
import com.google.common.collect.ImmutableMap;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.protobuf.Empty;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the RuleSetService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcRuleSetServiceStub extends RuleSetServiceStub {
  private static final MethodDescriptor<CreateRuleSetRequest, RuleSet>
      createRuleSetMethodDescriptor =
          MethodDescriptor.<CreateRuleSetRequest, RuleSet>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.contentwarehouse.v1.RuleSetService/CreateRuleSet")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateRuleSetRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(RuleSet.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetRuleSetRequest, RuleSet> getRuleSetMethodDescriptor =
      MethodDescriptor.<GetRuleSetRequest, RuleSet>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.contentwarehouse.v1.RuleSetService/GetRuleSet")
          .setRequestMarshaller(ProtoUtils.marshaller(GetRuleSetRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(RuleSet.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<UpdateRuleSetRequest, RuleSet>
      updateRuleSetMethodDescriptor =
          MethodDescriptor.<UpdateRuleSetRequest, RuleSet>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.contentwarehouse.v1.RuleSetService/UpdateRuleSet")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateRuleSetRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(RuleSet.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteRuleSetRequest, Empty> deleteRuleSetMethodDescriptor =
      MethodDescriptor.<DeleteRuleSetRequest, Empty>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.contentwarehouse.v1.RuleSetService/DeleteRuleSet")
          .setRequestMarshaller(ProtoUtils.marshaller(DeleteRuleSetRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<ListRuleSetsRequest, ListRuleSetsResponse>
      listRuleSetsMethodDescriptor =
          MethodDescriptor.<ListRuleSetsRequest, ListRuleSetsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.contentwarehouse.v1.RuleSetService/ListRuleSets")
              .setRequestMarshaller(ProtoUtils.marshaller(ListRuleSetsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListRuleSetsResponse.getDefaultInstance()))
              .build();

  private final UnaryCallable<CreateRuleSetRequest, RuleSet> createRuleSetCallable;
  private final UnaryCallable<GetRuleSetRequest, RuleSet> getRuleSetCallable;
  private final UnaryCallable<UpdateRuleSetRequest, RuleSet> updateRuleSetCallable;
  private final UnaryCallable<DeleteRuleSetRequest, Empty> deleteRuleSetCallable;
  private final UnaryCallable<ListRuleSetsRequest, ListRuleSetsResponse> listRuleSetsCallable;
  private final UnaryCallable<ListRuleSetsRequest, ListRuleSetsPagedResponse>
      listRuleSetsPagedCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcRuleSetServiceStub create(RuleSetServiceStubSettings settings)
      throws IOException {
    return new GrpcRuleSetServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcRuleSetServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcRuleSetServiceStub(
        RuleSetServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcRuleSetServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcRuleSetServiceStub(
        RuleSetServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcRuleSetServiceStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcRuleSetServiceStub(RuleSetServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcRuleSetServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcRuleSetServiceStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcRuleSetServiceStub(
      RuleSetServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<CreateRuleSetRequest, RuleSet> createRuleSetTransportSettings =
        GrpcCallSettings.<CreateRuleSetRequest, RuleSet>newBuilder()
            .setMethodDescriptor(createRuleSetMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<GetRuleSetRequest, RuleSet> getRuleSetTransportSettings =
        GrpcCallSettings.<GetRuleSetRequest, RuleSet>newBuilder()
            .setMethodDescriptor(getRuleSetMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<UpdateRuleSetRequest, RuleSet> updateRuleSetTransportSettings =
        GrpcCallSettings.<UpdateRuleSetRequest, RuleSet>newBuilder()
            .setMethodDescriptor(updateRuleSetMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<DeleteRuleSetRequest, Empty> deleteRuleSetTransportSettings =
        GrpcCallSettings.<DeleteRuleSetRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteRuleSetMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<ListRuleSetsRequest, ListRuleSetsResponse> listRuleSetsTransportSettings =
        GrpcCallSettings.<ListRuleSetsRequest, ListRuleSetsResponse>newBuilder()
            .setMethodDescriptor(listRuleSetsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();

    this.createRuleSetCallable =
        callableFactory.createUnaryCallable(
            createRuleSetTransportSettings, settings.createRuleSetSettings(), clientContext);
    this.getRuleSetCallable =
        callableFactory.createUnaryCallable(
            getRuleSetTransportSettings, settings.getRuleSetSettings(), clientContext);
    this.updateRuleSetCallable =
        callableFactory.createUnaryCallable(
            updateRuleSetTransportSettings, settings.updateRuleSetSettings(), clientContext);
    this.deleteRuleSetCallable =
        callableFactory.createUnaryCallable(
            deleteRuleSetTransportSettings, settings.deleteRuleSetSettings(), clientContext);
    this.listRuleSetsCallable =
        callableFactory.createUnaryCallable(
            listRuleSetsTransportSettings, settings.listRuleSetsSettings(), clientContext);
    this.listRuleSetsPagedCallable =
        callableFactory.createPagedCallable(
            listRuleSetsTransportSettings, settings.listRuleSetsSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<CreateRuleSetRequest, RuleSet> createRuleSetCallable() {
    return createRuleSetCallable;
  }

  @Override
  public UnaryCallable<GetRuleSetRequest, RuleSet> getRuleSetCallable() {
    return getRuleSetCallable;
  }

  @Override
  public UnaryCallable<UpdateRuleSetRequest, RuleSet> updateRuleSetCallable() {
    return updateRuleSetCallable;
  }

  @Override
  public UnaryCallable<DeleteRuleSetRequest, Empty> deleteRuleSetCallable() {
    return deleteRuleSetCallable;
  }

  @Override
  public UnaryCallable<ListRuleSetsRequest, ListRuleSetsResponse> listRuleSetsCallable() {
    return listRuleSetsCallable;
  }

  @Override
  public UnaryCallable<ListRuleSetsRequest, ListRuleSetsPagedResponse> listRuleSetsPagedCallable() {
    return listRuleSetsPagedCallable;
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
