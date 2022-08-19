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

package com.google.appengine.v1.stub;

import static com.google.appengine.v1.FirewallClient.ListIngressRulesPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.appengine.v1.BatchUpdateIngressRulesRequest;
import com.google.appengine.v1.BatchUpdateIngressRulesResponse;
import com.google.appengine.v1.CreateIngressRuleRequest;
import com.google.appengine.v1.DeleteIngressRuleRequest;
import com.google.appengine.v1.GetIngressRuleRequest;
import com.google.appengine.v1.ListIngressRulesRequest;
import com.google.appengine.v1.ListIngressRulesResponse;
import com.google.appengine.v1.UpdateIngressRuleRequest;
import com.google.appengine.v1.firewall.FirewallRule;
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
 * gRPC stub implementation for the Firewall service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcFirewallStub extends FirewallStub {
  private static final MethodDescriptor<ListIngressRulesRequest, ListIngressRulesResponse>
      listIngressRulesMethodDescriptor =
          MethodDescriptor.<ListIngressRulesRequest, ListIngressRulesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.appengine.v1.Firewall/ListIngressRules")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListIngressRulesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListIngressRulesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          BatchUpdateIngressRulesRequest, BatchUpdateIngressRulesResponse>
      batchUpdateIngressRulesMethodDescriptor =
          MethodDescriptor
              .<BatchUpdateIngressRulesRequest, BatchUpdateIngressRulesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.appengine.v1.Firewall/BatchUpdateIngressRules")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(BatchUpdateIngressRulesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(BatchUpdateIngressRulesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateIngressRuleRequest, FirewallRule>
      createIngressRuleMethodDescriptor =
          MethodDescriptor.<CreateIngressRuleRequest, FirewallRule>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.appengine.v1.Firewall/CreateIngressRule")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateIngressRuleRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(FirewallRule.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetIngressRuleRequest, FirewallRule>
      getIngressRuleMethodDescriptor =
          MethodDescriptor.<GetIngressRuleRequest, FirewallRule>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.appengine.v1.Firewall/GetIngressRule")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetIngressRuleRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(FirewallRule.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateIngressRuleRequest, FirewallRule>
      updateIngressRuleMethodDescriptor =
          MethodDescriptor.<UpdateIngressRuleRequest, FirewallRule>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.appengine.v1.Firewall/UpdateIngressRule")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateIngressRuleRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(FirewallRule.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteIngressRuleRequest, Empty>
      deleteIngressRuleMethodDescriptor =
          MethodDescriptor.<DeleteIngressRuleRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.appengine.v1.Firewall/DeleteIngressRule")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteIngressRuleRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private final UnaryCallable<ListIngressRulesRequest, ListIngressRulesResponse>
      listIngressRulesCallable;
  private final UnaryCallable<ListIngressRulesRequest, ListIngressRulesPagedResponse>
      listIngressRulesPagedCallable;
  private final UnaryCallable<BatchUpdateIngressRulesRequest, BatchUpdateIngressRulesResponse>
      batchUpdateIngressRulesCallable;
  private final UnaryCallable<CreateIngressRuleRequest, FirewallRule> createIngressRuleCallable;
  private final UnaryCallable<GetIngressRuleRequest, FirewallRule> getIngressRuleCallable;
  private final UnaryCallable<UpdateIngressRuleRequest, FirewallRule> updateIngressRuleCallable;
  private final UnaryCallable<DeleteIngressRuleRequest, Empty> deleteIngressRuleCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcFirewallStub create(FirewallStubSettings settings) throws IOException {
    return new GrpcFirewallStub(settings, ClientContext.create(settings));
  }

  public static final GrpcFirewallStub create(ClientContext clientContext) throws IOException {
    return new GrpcFirewallStub(FirewallStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcFirewallStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcFirewallStub(
        FirewallStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcFirewallStub, using the given settings. This is protected so that
   * it is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected GrpcFirewallStub(FirewallStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcFirewallCallableFactory());
  }

  /**
   * Constructs an instance of GrpcFirewallStub, using the given settings. This is protected so that
   * it is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected GrpcFirewallStub(
      FirewallStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<ListIngressRulesRequest, ListIngressRulesResponse>
        listIngressRulesTransportSettings =
            GrpcCallSettings.<ListIngressRulesRequest, ListIngressRulesResponse>newBuilder()
                .setMethodDescriptor(listIngressRulesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<BatchUpdateIngressRulesRequest, BatchUpdateIngressRulesResponse>
        batchUpdateIngressRulesTransportSettings =
            GrpcCallSettings
                .<BatchUpdateIngressRulesRequest, BatchUpdateIngressRulesResponse>newBuilder()
                .setMethodDescriptor(batchUpdateIngressRulesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<CreateIngressRuleRequest, FirewallRule> createIngressRuleTransportSettings =
        GrpcCallSettings.<CreateIngressRuleRequest, FirewallRule>newBuilder()
            .setMethodDescriptor(createIngressRuleMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<GetIngressRuleRequest, FirewallRule> getIngressRuleTransportSettings =
        GrpcCallSettings.<GetIngressRuleRequest, FirewallRule>newBuilder()
            .setMethodDescriptor(getIngressRuleMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<UpdateIngressRuleRequest, FirewallRule> updateIngressRuleTransportSettings =
        GrpcCallSettings.<UpdateIngressRuleRequest, FirewallRule>newBuilder()
            .setMethodDescriptor(updateIngressRuleMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<DeleteIngressRuleRequest, Empty> deleteIngressRuleTransportSettings =
        GrpcCallSettings.<DeleteIngressRuleRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteIngressRuleMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();

    this.listIngressRulesCallable =
        callableFactory.createUnaryCallable(
            listIngressRulesTransportSettings, settings.listIngressRulesSettings(), clientContext);
    this.listIngressRulesPagedCallable =
        callableFactory.createPagedCallable(
            listIngressRulesTransportSettings, settings.listIngressRulesSettings(), clientContext);
    this.batchUpdateIngressRulesCallable =
        callableFactory.createUnaryCallable(
            batchUpdateIngressRulesTransportSettings,
            settings.batchUpdateIngressRulesSettings(),
            clientContext);
    this.createIngressRuleCallable =
        callableFactory.createUnaryCallable(
            createIngressRuleTransportSettings,
            settings.createIngressRuleSettings(),
            clientContext);
    this.getIngressRuleCallable =
        callableFactory.createUnaryCallable(
            getIngressRuleTransportSettings, settings.getIngressRuleSettings(), clientContext);
    this.updateIngressRuleCallable =
        callableFactory.createUnaryCallable(
            updateIngressRuleTransportSettings,
            settings.updateIngressRuleSettings(),
            clientContext);
    this.deleteIngressRuleCallable =
        callableFactory.createUnaryCallable(
            deleteIngressRuleTransportSettings,
            settings.deleteIngressRuleSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<ListIngressRulesRequest, ListIngressRulesResponse>
      listIngressRulesCallable() {
    return listIngressRulesCallable;
  }

  @Override
  public UnaryCallable<ListIngressRulesRequest, ListIngressRulesPagedResponse>
      listIngressRulesPagedCallable() {
    return listIngressRulesPagedCallable;
  }

  @Override
  public UnaryCallable<BatchUpdateIngressRulesRequest, BatchUpdateIngressRulesResponse>
      batchUpdateIngressRulesCallable() {
    return batchUpdateIngressRulesCallable;
  }

  @Override
  public UnaryCallable<CreateIngressRuleRequest, FirewallRule> createIngressRuleCallable() {
    return createIngressRuleCallable;
  }

  @Override
  public UnaryCallable<GetIngressRuleRequest, FirewallRule> getIngressRuleCallable() {
    return getIngressRuleCallable;
  }

  @Override
  public UnaryCallable<UpdateIngressRuleRequest, FirewallRule> updateIngressRuleCallable() {
    return updateIngressRuleCallable;
  }

  @Override
  public UnaryCallable<DeleteIngressRuleRequest, Empty> deleteIngressRuleCallable() {
    return deleteIngressRuleCallable;
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
