/*
 * Copyright 2025 Google LLC
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

package google.cloud.chronicle.v1.stub;

import static google.cloud.chronicle.v1.RuleServiceClient.ListRetrohuntsPagedResponse;
import static google.cloud.chronicle.v1.RuleServiceClient.ListRuleDeploymentsPagedResponse;
import static google.cloud.chronicle.v1.RuleServiceClient.ListRuleRevisionsPagedResponse;
import static google.cloud.chronicle.v1.RuleServiceClient.ListRulesPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.protobuf.Empty;
import google.cloud.chronicle.v1.CreateRetrohuntRequest;
import google.cloud.chronicle.v1.CreateRuleRequest;
import google.cloud.chronicle.v1.DeleteRuleRequest;
import google.cloud.chronicle.v1.GetRetrohuntRequest;
import google.cloud.chronicle.v1.GetRuleDeploymentRequest;
import google.cloud.chronicle.v1.GetRuleRequest;
import google.cloud.chronicle.v1.ListRetrohuntsRequest;
import google.cloud.chronicle.v1.ListRetrohuntsResponse;
import google.cloud.chronicle.v1.ListRuleDeploymentsRequest;
import google.cloud.chronicle.v1.ListRuleDeploymentsResponse;
import google.cloud.chronicle.v1.ListRuleRevisionsRequest;
import google.cloud.chronicle.v1.ListRuleRevisionsResponse;
import google.cloud.chronicle.v1.ListRulesRequest;
import google.cloud.chronicle.v1.ListRulesResponse;
import google.cloud.chronicle.v1.Retrohunt;
import google.cloud.chronicle.v1.RetrohuntMetadata;
import google.cloud.chronicle.v1.Rule;
import google.cloud.chronicle.v1.RuleDeployment;
import google.cloud.chronicle.v1.UpdateRuleDeploymentRequest;
import google.cloud.chronicle.v1.UpdateRuleRequest;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the RuleService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcRuleServiceStub extends RuleServiceStub {
  private static final MethodDescriptor<CreateRuleRequest, Rule> createRuleMethodDescriptor =
      MethodDescriptor.<CreateRuleRequest, Rule>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.chronicle.v1.RuleService/CreateRule")
          .setRequestMarshaller(ProtoUtils.marshaller(CreateRuleRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Rule.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<GetRuleRequest, Rule> getRuleMethodDescriptor =
      MethodDescriptor.<GetRuleRequest, Rule>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.chronicle.v1.RuleService/GetRule")
          .setRequestMarshaller(ProtoUtils.marshaller(GetRuleRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Rule.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<ListRulesRequest, ListRulesResponse>
      listRulesMethodDescriptor =
          MethodDescriptor.<ListRulesRequest, ListRulesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.chronicle.v1.RuleService/ListRules")
              .setRequestMarshaller(ProtoUtils.marshaller(ListRulesRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ListRulesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateRuleRequest, Rule> updateRuleMethodDescriptor =
      MethodDescriptor.<UpdateRuleRequest, Rule>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.chronicle.v1.RuleService/UpdateRule")
          .setRequestMarshaller(ProtoUtils.marshaller(UpdateRuleRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Rule.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<DeleteRuleRequest, Empty> deleteRuleMethodDescriptor =
      MethodDescriptor.<DeleteRuleRequest, Empty>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.chronicle.v1.RuleService/DeleteRule")
          .setRequestMarshaller(ProtoUtils.marshaller(DeleteRuleRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<ListRuleRevisionsRequest, ListRuleRevisionsResponse>
      listRuleRevisionsMethodDescriptor =
          MethodDescriptor.<ListRuleRevisionsRequest, ListRuleRevisionsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.chronicle.v1.RuleService/ListRuleRevisions")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListRuleRevisionsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListRuleRevisionsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateRetrohuntRequest, Operation>
      createRetrohuntMethodDescriptor =
          MethodDescriptor.<CreateRetrohuntRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.chronicle.v1.RuleService/CreateRetrohunt")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateRetrohuntRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetRetrohuntRequest, Retrohunt>
      getRetrohuntMethodDescriptor =
          MethodDescriptor.<GetRetrohuntRequest, Retrohunt>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.chronicle.v1.RuleService/GetRetrohunt")
              .setRequestMarshaller(ProtoUtils.marshaller(GetRetrohuntRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Retrohunt.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListRetrohuntsRequest, ListRetrohuntsResponse>
      listRetrohuntsMethodDescriptor =
          MethodDescriptor.<ListRetrohuntsRequest, ListRetrohuntsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.chronicle.v1.RuleService/ListRetrohunts")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListRetrohuntsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListRetrohuntsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetRuleDeploymentRequest, RuleDeployment>
      getRuleDeploymentMethodDescriptor =
          MethodDescriptor.<GetRuleDeploymentRequest, RuleDeployment>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.chronicle.v1.RuleService/GetRuleDeployment")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetRuleDeploymentRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(RuleDeployment.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListRuleDeploymentsRequest, ListRuleDeploymentsResponse>
      listRuleDeploymentsMethodDescriptor =
          MethodDescriptor.<ListRuleDeploymentsRequest, ListRuleDeploymentsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.chronicle.v1.RuleService/ListRuleDeployments")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListRuleDeploymentsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListRuleDeploymentsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateRuleDeploymentRequest, RuleDeployment>
      updateRuleDeploymentMethodDescriptor =
          MethodDescriptor.<UpdateRuleDeploymentRequest, RuleDeployment>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.chronicle.v1.RuleService/UpdateRuleDeployment")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateRuleDeploymentRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(RuleDeployment.getDefaultInstance()))
              .build();

  private final UnaryCallable<CreateRuleRequest, Rule> createRuleCallable;
  private final UnaryCallable<GetRuleRequest, Rule> getRuleCallable;
  private final UnaryCallable<ListRulesRequest, ListRulesResponse> listRulesCallable;
  private final UnaryCallable<ListRulesRequest, ListRulesPagedResponse> listRulesPagedCallable;
  private final UnaryCallable<UpdateRuleRequest, Rule> updateRuleCallable;
  private final UnaryCallable<DeleteRuleRequest, Empty> deleteRuleCallable;
  private final UnaryCallable<ListRuleRevisionsRequest, ListRuleRevisionsResponse>
      listRuleRevisionsCallable;
  private final UnaryCallable<ListRuleRevisionsRequest, ListRuleRevisionsPagedResponse>
      listRuleRevisionsPagedCallable;
  private final UnaryCallable<CreateRetrohuntRequest, Operation> createRetrohuntCallable;
  private final OperationCallable<CreateRetrohuntRequest, Retrohunt, RetrohuntMetadata>
      createRetrohuntOperationCallable;
  private final UnaryCallable<GetRetrohuntRequest, Retrohunt> getRetrohuntCallable;
  private final UnaryCallable<ListRetrohuntsRequest, ListRetrohuntsResponse> listRetrohuntsCallable;
  private final UnaryCallable<ListRetrohuntsRequest, ListRetrohuntsPagedResponse>
      listRetrohuntsPagedCallable;
  private final UnaryCallable<GetRuleDeploymentRequest, RuleDeployment> getRuleDeploymentCallable;
  private final UnaryCallable<ListRuleDeploymentsRequest, ListRuleDeploymentsResponse>
      listRuleDeploymentsCallable;
  private final UnaryCallable<ListRuleDeploymentsRequest, ListRuleDeploymentsPagedResponse>
      listRuleDeploymentsPagedCallable;
  private final UnaryCallable<UpdateRuleDeploymentRequest, RuleDeployment>
      updateRuleDeploymentCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcRuleServiceStub create(RuleServiceStubSettings settings)
      throws IOException {
    return new GrpcRuleServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcRuleServiceStub create(ClientContext clientContext) throws IOException {
    return new GrpcRuleServiceStub(RuleServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcRuleServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcRuleServiceStub(
        RuleServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcRuleServiceStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcRuleServiceStub(RuleServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcRuleServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcRuleServiceStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcRuleServiceStub(
      RuleServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<CreateRuleRequest, Rule> createRuleTransportSettings =
        GrpcCallSettings.<CreateRuleRequest, Rule>newBuilder()
            .setMethodDescriptor(createRuleMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetRuleRequest, Rule> getRuleTransportSettings =
        GrpcCallSettings.<GetRuleRequest, Rule>newBuilder()
            .setMethodDescriptor(getRuleMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListRulesRequest, ListRulesResponse> listRulesTransportSettings =
        GrpcCallSettings.<ListRulesRequest, ListRulesResponse>newBuilder()
            .setMethodDescriptor(listRulesMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateRuleRequest, Rule> updateRuleTransportSettings =
        GrpcCallSettings.<UpdateRuleRequest, Rule>newBuilder()
            .setMethodDescriptor(updateRuleMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("rule.name", String.valueOf(request.getRule().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteRuleRequest, Empty> deleteRuleTransportSettings =
        GrpcCallSettings.<DeleteRuleRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteRuleMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListRuleRevisionsRequest, ListRuleRevisionsResponse>
        listRuleRevisionsTransportSettings =
            GrpcCallSettings.<ListRuleRevisionsRequest, ListRuleRevisionsResponse>newBuilder()
                .setMethodDescriptor(listRuleRevisionsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<CreateRetrohuntRequest, Operation> createRetrohuntTransportSettings =
        GrpcCallSettings.<CreateRetrohuntRequest, Operation>newBuilder()
            .setMethodDescriptor(createRetrohuntMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetRetrohuntRequest, Retrohunt> getRetrohuntTransportSettings =
        GrpcCallSettings.<GetRetrohuntRequest, Retrohunt>newBuilder()
            .setMethodDescriptor(getRetrohuntMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListRetrohuntsRequest, ListRetrohuntsResponse>
        listRetrohuntsTransportSettings =
            GrpcCallSettings.<ListRetrohuntsRequest, ListRetrohuntsResponse>newBuilder()
                .setMethodDescriptor(listRetrohuntsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetRuleDeploymentRequest, RuleDeployment> getRuleDeploymentTransportSettings =
        GrpcCallSettings.<GetRuleDeploymentRequest, RuleDeployment>newBuilder()
            .setMethodDescriptor(getRuleDeploymentMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListRuleDeploymentsRequest, ListRuleDeploymentsResponse>
        listRuleDeploymentsTransportSettings =
            GrpcCallSettings.<ListRuleDeploymentsRequest, ListRuleDeploymentsResponse>newBuilder()
                .setMethodDescriptor(listRuleDeploymentsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<UpdateRuleDeploymentRequest, RuleDeployment>
        updateRuleDeploymentTransportSettings =
            GrpcCallSettings.<UpdateRuleDeploymentRequest, RuleDeployment>newBuilder()
                .setMethodDescriptor(updateRuleDeploymentMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "rule_deployment.name",
                          String.valueOf(request.getRuleDeployment().getName()));
                      return builder.build();
                    })
                .build();

    this.createRuleCallable =
        callableFactory.createUnaryCallable(
            createRuleTransportSettings, settings.createRuleSettings(), clientContext);
    this.getRuleCallable =
        callableFactory.createUnaryCallable(
            getRuleTransportSettings, settings.getRuleSettings(), clientContext);
    this.listRulesCallable =
        callableFactory.createUnaryCallable(
            listRulesTransportSettings, settings.listRulesSettings(), clientContext);
    this.listRulesPagedCallable =
        callableFactory.createPagedCallable(
            listRulesTransportSettings, settings.listRulesSettings(), clientContext);
    this.updateRuleCallable =
        callableFactory.createUnaryCallable(
            updateRuleTransportSettings, settings.updateRuleSettings(), clientContext);
    this.deleteRuleCallable =
        callableFactory.createUnaryCallable(
            deleteRuleTransportSettings, settings.deleteRuleSettings(), clientContext);
    this.listRuleRevisionsCallable =
        callableFactory.createUnaryCallable(
            listRuleRevisionsTransportSettings,
            settings.listRuleRevisionsSettings(),
            clientContext);
    this.listRuleRevisionsPagedCallable =
        callableFactory.createPagedCallable(
            listRuleRevisionsTransportSettings,
            settings.listRuleRevisionsSettings(),
            clientContext);
    this.createRetrohuntCallable =
        callableFactory.createUnaryCallable(
            createRetrohuntTransportSettings, settings.createRetrohuntSettings(), clientContext);
    this.createRetrohuntOperationCallable =
        callableFactory.createOperationCallable(
            createRetrohuntTransportSettings,
            settings.createRetrohuntOperationSettings(),
            clientContext,
            operationsStub);
    this.getRetrohuntCallable =
        callableFactory.createUnaryCallable(
            getRetrohuntTransportSettings, settings.getRetrohuntSettings(), clientContext);
    this.listRetrohuntsCallable =
        callableFactory.createUnaryCallable(
            listRetrohuntsTransportSettings, settings.listRetrohuntsSettings(), clientContext);
    this.listRetrohuntsPagedCallable =
        callableFactory.createPagedCallable(
            listRetrohuntsTransportSettings, settings.listRetrohuntsSettings(), clientContext);
    this.getRuleDeploymentCallable =
        callableFactory.createUnaryCallable(
            getRuleDeploymentTransportSettings,
            settings.getRuleDeploymentSettings(),
            clientContext);
    this.listRuleDeploymentsCallable =
        callableFactory.createUnaryCallable(
            listRuleDeploymentsTransportSettings,
            settings.listRuleDeploymentsSettings(),
            clientContext);
    this.listRuleDeploymentsPagedCallable =
        callableFactory.createPagedCallable(
            listRuleDeploymentsTransportSettings,
            settings.listRuleDeploymentsSettings(),
            clientContext);
    this.updateRuleDeploymentCallable =
        callableFactory.createUnaryCallable(
            updateRuleDeploymentTransportSettings,
            settings.updateRuleDeploymentSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<CreateRuleRequest, Rule> createRuleCallable() {
    return createRuleCallable;
  }

  @Override
  public UnaryCallable<GetRuleRequest, Rule> getRuleCallable() {
    return getRuleCallable;
  }

  @Override
  public UnaryCallable<ListRulesRequest, ListRulesResponse> listRulesCallable() {
    return listRulesCallable;
  }

  @Override
  public UnaryCallable<ListRulesRequest, ListRulesPagedResponse> listRulesPagedCallable() {
    return listRulesPagedCallable;
  }

  @Override
  public UnaryCallable<UpdateRuleRequest, Rule> updateRuleCallable() {
    return updateRuleCallable;
  }

  @Override
  public UnaryCallable<DeleteRuleRequest, Empty> deleteRuleCallable() {
    return deleteRuleCallable;
  }

  @Override
  public UnaryCallable<ListRuleRevisionsRequest, ListRuleRevisionsResponse>
      listRuleRevisionsCallable() {
    return listRuleRevisionsCallable;
  }

  @Override
  public UnaryCallable<ListRuleRevisionsRequest, ListRuleRevisionsPagedResponse>
      listRuleRevisionsPagedCallable() {
    return listRuleRevisionsPagedCallable;
  }

  @Override
  public UnaryCallable<CreateRetrohuntRequest, Operation> createRetrohuntCallable() {
    return createRetrohuntCallable;
  }

  @Override
  public OperationCallable<CreateRetrohuntRequest, Retrohunt, RetrohuntMetadata>
      createRetrohuntOperationCallable() {
    return createRetrohuntOperationCallable;
  }

  @Override
  public UnaryCallable<GetRetrohuntRequest, Retrohunt> getRetrohuntCallable() {
    return getRetrohuntCallable;
  }

  @Override
  public UnaryCallable<ListRetrohuntsRequest, ListRetrohuntsResponse> listRetrohuntsCallable() {
    return listRetrohuntsCallable;
  }

  @Override
  public UnaryCallable<ListRetrohuntsRequest, ListRetrohuntsPagedResponse>
      listRetrohuntsPagedCallable() {
    return listRetrohuntsPagedCallable;
  }

  @Override
  public UnaryCallable<GetRuleDeploymentRequest, RuleDeployment> getRuleDeploymentCallable() {
    return getRuleDeploymentCallable;
  }

  @Override
  public UnaryCallable<ListRuleDeploymentsRequest, ListRuleDeploymentsResponse>
      listRuleDeploymentsCallable() {
    return listRuleDeploymentsCallable;
  }

  @Override
  public UnaryCallable<ListRuleDeploymentsRequest, ListRuleDeploymentsPagedResponse>
      listRuleDeploymentsPagedCallable() {
    return listRuleDeploymentsPagedCallable;
  }

  @Override
  public UnaryCallable<UpdateRuleDeploymentRequest, RuleDeployment> updateRuleDeploymentCallable() {
    return updateRuleDeploymentCallable;
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
