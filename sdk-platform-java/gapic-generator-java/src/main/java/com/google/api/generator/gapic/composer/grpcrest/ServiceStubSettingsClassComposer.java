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

package com.google.api.generator.gapic.composer.grpcrest;

import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.generator.engine.ast.CommentStatement;
import com.google.api.generator.engine.ast.ConcreteReference;
import com.google.api.generator.engine.ast.Expr;
import com.google.api.generator.engine.ast.MethodDefinition;
import com.google.api.generator.engine.ast.MethodInvocationExpr;
import com.google.api.generator.engine.ast.PrimitiveValue;
import com.google.api.generator.engine.ast.ScopeNode;
import com.google.api.generator.engine.ast.TypeNode;
import com.google.api.generator.engine.ast.ValueExpr;
import com.google.api.generator.engine.ast.Variable;
import com.google.api.generator.engine.ast.VariableExpr;
import com.google.api.generator.gapic.composer.comment.SettingsCommentComposer;
import com.google.api.generator.gapic.composer.common.AbstractServiceStubSettingsClassComposer;
import com.google.api.generator.gapic.composer.store.TypeStore;
import com.google.api.generator.gapic.composer.utils.ClassNames;
import com.google.api.generator.gapic.model.Service;
import com.google.api.generator.gapic.model.Transport;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ServiceStubSettingsClassComposer extends AbstractServiceStubSettingsClassComposer {
  private static final ServiceStubSettingsClassComposer INSTANCE =
      new ServiceStubSettingsClassComposer();

  public static ServiceStubSettingsClassComposer instance() {
    return INSTANCE;
  }

  protected ServiceStubSettingsClassComposer() {
    super(GrpcRestContext.instance());
  }

  @Override
  protected Expr initializeTransportProviderBuilder(
      MethodInvocationExpr transportChannelProviderBuilderExpr, TypeNode returnType) {
    if (!returnType.reference().isFromPackage("com.google.api.gax.grpc")) {
      return transportChannelProviderBuilderExpr;
    }

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
  protected MethodDefinition createDefaultCredentialsProviderBuilderMethod() {
    TypeNode returnType =
        TypeNode.withReference(
            ConcreteReference.withClazz(GoogleCredentialsProvider.Builder.class));
    MethodInvocationExpr credsProviderBuilderExpr =
        MethodInvocationExpr.builder()
            .setStaticReferenceType(FIXED_TYPESTORE.get("GoogleCredentialsProvider"))
            .setMethodName("newBuilder")
            .build();
    credsProviderBuilderExpr =
        MethodInvocationExpr.builder()
            .setExprReferenceExpr(credsProviderBuilderExpr)
            .setMethodName("setScopesToApply")
            .setArguments(DEFAULT_SERVICE_SCOPES_VAR_EXPR)
            .setReturnType(returnType)
            .build();

    // This section is specific to GAPIC clients. It sets UseJwtAccessWithScope value to true to
    // enable self signed JWT feature.
    credsProviderBuilderExpr =
        MethodInvocationExpr.builder()
            .setExprReferenceExpr(credsProviderBuilderExpr)
            .setMethodName("setUseJwtAccessWithScope")
            .setArguments(
                ValueExpr.withValue(
                    PrimitiveValue.builder().setType(TypeNode.BOOLEAN).setValue("true").build()))
            .setReturnType(returnType)
            .build();

    return MethodDefinition.builder()
        .setHeaderCommentStatements(
            SettingsCommentComposer.DEFAULT_CREDENTIALS_PROVIDER_BUILDER_METHOD_COMMENT)
        .setScope(ScopeNode.PUBLIC)
        .setIsStatic(true)
        .setReturnType(returnType)
        .setName("defaultCredentialsProviderBuilder")
        .setReturnExpr(credsProviderBuilderExpr)
        .build();
  }

  @Override
  protected List<MethodDefinition> createApiClientHeaderProviderBuilderMethods(
      Service service, TypeStore typeStore) {

    TypeNode returnType =
        TypeNode.withReference(ConcreteReference.withClazz(ApiClientHeaderProvider.Builder.class));

    List<MethodDefinition> methodDefinitions = new ArrayList<>();
    methodDefinitions.add(
        createApiClientHeaderProviderBuilderMethod(
            service,
            typeStore,
            "defaultGrpcApiClientHeaderProviderBuilder",
            TypeNode.withReference(ConcreteReference.withClazz(GaxGrpcProperties.class)),
            "getGrpcTokenName",
            "getGrpcVersion"));
    if (service.hasAnyEnabledMethodsForTransport(Transport.REST)) {
      methodDefinitions.add(
          createApiClientHeaderProviderBuilderMethod(
              service,
              typeStore,
              "defaultHttpJsonApiClientHeaderProviderBuilder",
              TypeNode.withReference(ConcreteReference.withClazz(GaxHttpJsonProperties.class)),
              "getHttpJsonTokenName",
              "getHttpJsonVersion"));
    }
    methodDefinitions.add(
        MethodDefinition.builder()
            .setScope(ScopeNode.PUBLIC)
            .setIsStatic(true)
            .setReturnType(returnType)
            .setName("defaultApiClientHeaderProviderBuilder")
            .setReturnExpr(
                MethodInvocationExpr.builder()
                    .setStaticReferenceType(
                        typeStore.get(ClassNames.getServiceStubSettingsClassName(service)))
                    .setMethodName("defaultGrpcApiClientHeaderProviderBuilder")
                    .setReturnType(returnType)
                    .build())
            .build());
    return methodDefinitions;
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

  @Override
  protected List<MethodDefinition> createNestedClassCreateDefaultMethods(
      Service service, TypeStore typeStore) {
    List<MethodDefinition> methodDefinitions = new ArrayList<>();
    methodDefinitions.add(
        createNestedClassCreateDefaultMethod(
            typeStore,
            "createDefault",
            "defaultTransportChannelProvider",
            null,
            "defaultApiClientHeaderProviderBuilder"));
    if (service.hasAnyEnabledMethodsForTransport(Transport.REST)) {
      methodDefinitions.add(
          createNestedClassCreateDefaultMethod(
              typeStore,
              "createHttpJsonDefault",
              null,
              "defaultHttpJsonTransportProviderBuilder",
              "defaultHttpJsonApiClientHeaderProviderBuilder"));
    }
    return methodDefinitions;
  }

  @Override
  protected List<MethodDefinition> createNewBuilderMethods(
      Service service,
      TypeStore typeStore,
      String newBuilderMethodName,
      String createDefaultMethodName,
      CommentStatement methodComment) {
    List<MethodDefinition> methods = new ArrayList<>();
    Iterator<String> transportNames = getTransportContext().transportNames().iterator();
    methods.addAll(
        super.createNewBuilderMethods(
            service,
            typeStore,
            "newBuilder",
            "createDefault",
            new SettingsCommentComposer(transportNames.next())
                .getNewTransportBuilderMethodComment()));
    if (service.hasAnyEnabledMethodsForTransport(Transport.REST)) {
      methods.addAll(
          super.createNewBuilderMethods(
              service,
              typeStore,
              "newHttpJsonBuilder",
              "createHttpJsonDefault",
              new SettingsCommentComposer(transportNames.next())
                  .getNewTransportBuilderMethodComment()));
    }
    return methods;
  }
}
