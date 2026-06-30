// Copyright 2020 Google LLC
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

import com.google.api.core.BetaApi;
import com.google.api.generator.engine.ast.AnnotationNode;
import com.google.api.generator.engine.ast.AssignmentExpr;
import com.google.api.generator.engine.ast.ClassDefinition;
import com.google.api.generator.engine.ast.ConcreteReference;
import com.google.api.generator.engine.ast.Expr;
import com.google.api.generator.engine.ast.ExprStatement;
import com.google.api.generator.engine.ast.MethodDefinition;
import com.google.api.generator.engine.ast.MethodInvocationExpr;
import com.google.api.generator.engine.ast.NewObjectExpr;
import com.google.api.generator.engine.ast.ScopeNode;
import com.google.api.generator.engine.ast.Statement;
import com.google.api.generator.engine.ast.TypeNode;
import com.google.api.generator.engine.ast.Variable;
import com.google.api.generator.engine.ast.VariableExpr;
import com.google.api.generator.gapic.composer.common.ClassComposer;
import com.google.api.generator.gapic.composer.store.TypeStore;
import com.google.api.generator.gapic.composer.utils.ClassNames;
import com.google.api.generator.gapic.model.GapicClass;
import com.google.api.generator.gapic.model.GapicClass.Kind;
import com.google.api.generator.gapic.model.GapicContext;
import com.google.api.generator.gapic.model.Service;
import com.google.protobuf.AbstractMessage;
import io.grpc.ServerServiceDefinition;
import java.util.Arrays;
import java.util.List;
import javax.annotation.Generated;

public class MockServiceClassComposer implements ClassComposer {
  private static final MockServiceClassComposer INSTANCE = new MockServiceClassComposer();
  private static final String SERVICE_IMPL_VAR_NAME = "serviceImpl";

  private MockServiceClassComposer() {}

  public static MockServiceClassComposer instance() {
    return INSTANCE;
  }

  @Override
  public GapicClass generate(GapicContext ignored, Service service) {
    TypeStore typeStore = createTypes(service);
    String className = ClassNames.getMockServiceClassName(service);
    GapicClass.Kind kind = Kind.TEST;
    String pakkage = service.pakkage();

    ClassDefinition classDef =
        ClassDefinition.builder()
            .setPackageString(pakkage)
            .setAnnotations(createClassAnnotations(typeStore))
            .setScope(ScopeNode.PUBLIC)
            .setName(className)
            .setImplementsTypes(createClassImplements(typeStore))
            .setStatements(createFieldDeclarations(service, typeStore))
            .setMethods(createClassMethods(service, typeStore))
            .build();
    return GapicClass.create(kind, classDef);
  }

  private static List<Statement> createFieldDeclarations(Service service, TypeStore typeStore) {
    return Arrays.asList(
        ExprStatement.withExpr(
            VariableExpr.builder()
                .setVariable(getServiceImplVariable(service, typeStore))
                .setScope(ScopeNode.PRIVATE)
                .setIsFinal(true)
                .setIsDecl(true)
                .build()));
  }

  private static List<AnnotationNode> createClassAnnotations(TypeStore typeStore) {
    return Arrays.asList(
        AnnotationNode.builder().setType(typeStore.get("BetaApi")).build(),
        AnnotationNode.builder()
            .setType(typeStore.get("Generated"))
            .setDescription("by gapic-generator-java")
            .build());
  }

  private static List<TypeNode> createClassImplements(TypeStore typeStore) {
    return Arrays.asList(typeStore.get("MockGrpcService"));
  }

  private static List<MethodDefinition> createClassMethods(Service service, TypeStore typeStore) {
    VariableExpr serviceImplVarExpr =
        VariableExpr.withVariable(getServiceImplVariable(service, typeStore));
    return Arrays.asList(
        createConstructor(service, serviceImplVarExpr, typeStore),
        createGetRequestsMethod(serviceImplVarExpr, typeStore),
        createAddResponseMethod(serviceImplVarExpr, typeStore),
        createAddExceptionMethod(serviceImplVarExpr),
        createGetServiceDefinitionMethod(serviceImplVarExpr, typeStore),
        createResetMethod(serviceImplVarExpr));
  }

  private static MethodDefinition createConstructor(
      Service service, VariableExpr serviceImplVarExpr, TypeStore typeStore) {
    String mockImplName = ClassNames.getMockServiceImplClassName(service);
    Expr serviceImplAssignExpr =
        AssignmentExpr.builder()
            .setVariableExpr(serviceImplVarExpr)
            .setValueExpr(NewObjectExpr.builder().setType(typeStore.get(mockImplName)).build())
            .build();

    return MethodDefinition.constructorBuilder()
        .setScope(ScopeNode.PUBLIC)
        .setBody(Arrays.asList(ExprStatement.withExpr(serviceImplAssignExpr)))
        .setReturnType(typeStore.get(ClassNames.getMockServiceClassName(service)))
        .build();
  }

  private static MethodDefinition createGetRequestsMethod(
      VariableExpr serviceImplVarExpr, TypeStore typeStore) {
    TypeNode returnType =
        TypeNode.withReference(
            ConcreteReference.builder()
                .setClazz(List.class)
                .setGenerics(Arrays.asList(typeStore.get("AbstractMessage").reference()))
                .build());
    String methodName = "getRequests";
    Expr returnExpr =
        MethodInvocationExpr.builder()
            .setMethodName(methodName)
            .setReturnType(returnType)
            .setExprReferenceExpr(serviceImplVarExpr)
            .build();
    return MethodDefinition.builder()
        .setIsOverride(true)
        .setScope(ScopeNode.PUBLIC)
        .setReturnType(returnType)
        .setName(methodName)
        .setReturnExpr(returnExpr)
        .build();
  }

  private static MethodDefinition createAddResponseMethod(
      VariableExpr serviceImplVarExpr, TypeStore typeStore) {
    String methodName = "addResponse";
    VariableExpr responseArgExpr =
        VariableExpr.withVariable(
            Variable.builder()
                .setName("response")
                .setType(typeStore.get("AbstractMessage"))
                .build());

    Expr methodInvocationExpr =
        MethodInvocationExpr.builder()
            .setMethodName(methodName)
            .setArguments(Arrays.asList(responseArgExpr))
            .setExprReferenceExpr(serviceImplVarExpr)
            .build();
    return MethodDefinition.builder()
        .setIsOverride(true)
        .setScope(ScopeNode.PUBLIC)
        .setReturnType(TypeNode.VOID)
        .setName(methodName)
        .setArguments(Arrays.asList(responseArgExpr.toBuilder().setIsDecl(true).build()))
        .setBody(Arrays.asList(ExprStatement.withExpr(methodInvocationExpr)))
        .build();
  }

  private static MethodDefinition createAddExceptionMethod(VariableExpr serviceImplVarExpr) {
    String methodName = "addException";
    VariableExpr exceptionArgExpr =
        VariableExpr.withVariable(
            Variable.builder()
                .setName("exception")
                .setType(TypeNode.withReference(ConcreteReference.withClazz(Exception.class)))
                .build());
    Expr methodInvocationExpr =
        MethodInvocationExpr.builder()
            .setMethodName(methodName)
            .setArguments(Arrays.asList(exceptionArgExpr))
            .setExprReferenceExpr(serviceImplVarExpr)
            .build();
    return MethodDefinition.builder()
        .setIsOverride(true)
        .setScope(ScopeNode.PUBLIC)
        .setReturnType(TypeNode.VOID)
        .setName(methodName)
        .setArguments(Arrays.asList(exceptionArgExpr.toBuilder().setIsDecl(true).build()))
        .setBody(Arrays.asList(ExprStatement.withExpr(methodInvocationExpr)))
        .build();
  }

  private static MethodDefinition createGetServiceDefinitionMethod(
      VariableExpr serviceImplVarExpr, TypeStore typeStore) {
    TypeNode returnType = typeStore.get("ServerServiceDefinition");
    Expr methodInvocationExpr =
        MethodInvocationExpr.builder()
            .setMethodName("bindService")
            .setExprReferenceExpr(serviceImplVarExpr)
            .setReturnType(returnType)
            .build();
    return MethodDefinition.builder()
        .setIsOverride(true)
        .setScope(ScopeNode.PUBLIC)
        .setReturnType(returnType)
        .setName("getServiceDefinition")
        .setReturnExpr(methodInvocationExpr)
        .build();
  }

  private static MethodDefinition createResetMethod(VariableExpr serviceImplVarExpr) {
    String methodName = "reset";
    return MethodDefinition.builder()
        .setIsOverride(true)
        .setScope(ScopeNode.PUBLIC)
        .setReturnType(TypeNode.VOID)
        .setName(methodName)
        .setBody(
            Arrays.asList(
                ExprStatement.withExpr(
                    MethodInvocationExpr.builder()
                        .setMethodName(methodName)
                        .setExprReferenceExpr(serviceImplVarExpr)
                        .build())))
        .build();
  }

  private static TypeStore createTypes(Service service) {
    List<Class<?>> concreteClazzes =
        Arrays.asList(
            AbstractMessage.class, BetaApi.class, Generated.class, ServerServiceDefinition.class);
    TypeStore typeStore = new TypeStore(concreteClazzes);

    typeStore.put("com.google.api.gax.grpc.testing", "MockGrpcService");
    typeStore.putAll(
        service.pakkage(),
        Arrays.asList(
            ClassNames.getMockServiceImplClassName(service),
            ClassNames.getMockServiceClassName(service)));
    return typeStore;
  }

  private static Variable getServiceImplVariable(Service service, TypeStore typeStore) {
    return Variable.builder()
        .setName(SERVICE_IMPL_VAR_NAME)
        .setType(typeStore.get(ClassNames.getMockServiceImplClassName(service)))
        .build();
  }
}
