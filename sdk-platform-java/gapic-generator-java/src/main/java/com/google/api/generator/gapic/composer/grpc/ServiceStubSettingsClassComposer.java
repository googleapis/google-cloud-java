// Copyright 2021 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//      http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.google.api.generator.gapic.composer.grpc;

import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.GrpcTransportChannel;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.generator.engine.ast.Expr;
import com.google.api.generator.engine.ast.MethodDefinition;
import com.google.api.generator.engine.ast.MethodInvocationExpr;
import com.google.api.generator.engine.ast.ScopeNode;
import com.google.api.generator.engine.ast.TypeNode;
import com.google.api.generator.engine.ast.Variable;
import com.google.api.generator.engine.ast.VariableExpr;
import com.google.api.generator.gapic.composer.common.AbstractServiceStubSettingsClassComposer;
import com.google.api.generator.gapic.composer.store.TypeStore;
import com.google.api.generator.gapic.model.Service;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ServiceStubSettingsClassComposer extends AbstractServiceStubSettingsClassComposer {
  private static final ServiceStubSettingsClassComposer INSTANCE =
      new ServiceStubSettingsClassComposer();

  private static final TypeStore FIXED_GRPC_TYPESTORE = createStaticTypes();

  public static ServiceStubSettingsClassComposer instance() {
    return INSTANCE;
  }

  protected ServiceStubSettingsClassComposer() {
    super(GrpcContext.instance());
  }

  private static TypeStore createStaticTypes() {
    List<Class<?>> concreteClazzes =
        Arrays.asList(
            GaxGrpcProperties.class,
            GrpcTransportChannel.class,
            InstantiatingGrpcChannelProvider.class);
    return new TypeStore(concreteClazzes);
  }

  @Override
  protected Expr initializeTransportProviderBuilder(
      MethodInvocationExpr transportChannelProviderBuilderExpr, TypeNode returnType) {
    return MethodInvocationExpr.builder()
        .setExprReferenceExpr(transportChannelProviderBuilderExpr)
        .setMethodName("setMaxInboundMessageSize")
        .setArguments(
            VariableExpr.builder()
                .setVariable(Variable.builder().setType(TypeNode.INT).setName("MAX_VALUE").build())
                .setStaticReferenceType(TypeNode.INT_OBJECT)
                .build())
        .setReturnType(returnType)
        .build();
  }

  @Override
  protected List<MethodDefinition> createApiClientHeaderProviderBuilderMethods(
      Service service, TypeStore typeStore) {
    return Collections.singletonList(
        createApiClientHeaderProviderBuilderMethod(
            service,
            typeStore,
            "defaultApiClientHeaderProviderBuilder",
            FIXED_GRPC_TYPESTORE.get(GaxGrpcProperties.class.getSimpleName()),
            "getGrpcTokenName",
            "getGrpcVersion"));
  }

  @Override
  public MethodDefinition createDefaultTransportChannelProviderMethod() {
    TypeNode returnType = FIXED_TYPESTORE.get("TransportChannelProvider");
    MethodInvocationExpr transportProviderBuilderExpr =
        MethodInvocationExpr.builder().setMethodName("defaultGrpcTransportProviderBuilder").build();
    transportProviderBuilderExpr =
        MethodInvocationExpr.builder()
            .setExprReferenceExpr(transportProviderBuilderExpr)
            .setMethodName("build")
            .setReturnType(returnType)
            .build();
    return MethodDefinition.builder()
        .setScope(ScopeNode.PUBLIC)
        .setIsStatic(true)
        .setReturnType(returnType)
        .setName("defaultTransportChannelProvider")
        .setReturnExpr(transportProviderBuilderExpr)
        .build();
  }
}
