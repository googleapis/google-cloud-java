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

package com.google.api.generator.gapic.composer.rest;

import com.google.api.gax.httpjson.HttpJsonCallableFactory;
import com.google.api.gax.httpjson.HttpJsonOperationSnapshotCallable;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.api.generator.engine.ast.AssignmentExpr;
import com.google.api.generator.engine.ast.ConcreteReference;
import com.google.api.generator.engine.ast.ExprStatement;
import com.google.api.generator.engine.ast.MethodDefinition;
import com.google.api.generator.engine.ast.MethodInvocationExpr;
import com.google.api.generator.engine.ast.NewObjectExpr;
import com.google.api.generator.engine.ast.Statement;
import com.google.api.generator.engine.ast.TypeNode;
import com.google.api.generator.engine.ast.VaporReference;
import com.google.api.generator.engine.ast.Variable;
import com.google.api.generator.engine.ast.VariableExpr;
import com.google.api.generator.gapic.composer.common.AbstractServiceCallableFactoryClassComposer;
import com.google.api.generator.gapic.composer.store.TypeStore;
import com.google.api.generator.gapic.model.Service;
import com.google.longrunning.Operation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class HttpJsonServiceCallableFactoryClassComposer
    extends AbstractServiceCallableFactoryClassComposer {
  private static final HttpJsonServiceCallableFactoryClassComposer INSTANCE =
      new HttpJsonServiceCallableFactoryClassComposer();

  private static final TypeNode DEFAULT_OPERATION_TYPE =
      TypeNode.withReference(ConcreteReference.withClazz(Operation.class));

  private HttpJsonServiceCallableFactoryClassComposer() {
    super(RestContext.instance());
  }

  public static HttpJsonServiceCallableFactoryClassComposer instance() {
    return INSTANCE;
  }

  @Override
  protected List<TypeNode> createClassImplements(Service service, TypeStore typeStore) {
    TypeNode operationsStubType = getOperationsStubType(service);

    TypeNode operationType = service.operationType();
    if (operationType == null) {
      operationType = DEFAULT_OPERATION_TYPE;
    }

    return Arrays.asList(
        TypeNode.withReference(
            getTransportContext()
                .stubCallableFactoryType()
                .reference()
                .copyAndSetGenerics(
                    Arrays.asList(operationType.reference(), operationsStubType.reference()))));
  }

  @Override
  protected List<MethodDefinition> createClassMethods(Service service, TypeStore typeStore) {
    List<MethodDefinition> classMethods =
        new ArrayList<>(super.createClassMethods(service, typeStore));
    classMethods.addAll(Arrays.asList(createServerStreamingCallableMethod(service, typeStore)));
    return classMethods;
  }

  @Override
  protected MethodDefinition createOperationCallableMethod(Service service, TypeStore typeStore) {
    String methodVariantName = "Operation";
    String requestTemplateName = "RequestT";
    String responseTemplateName = "ResponseT";

    List<String> methodTemplateNames =
        Arrays.asList(requestTemplateName, responseTemplateName, "MetadataT");

    // Generate generic method without the body
    TypeNode operationType = service.operationType();
    if (operationType == null) {
      operationType = DEFAULT_OPERATION_TYPE;
    }
    MethodDefinition method =
        createGenericCallableMethod(
            service,
            typeStore,
            /* methodTemplateNames= */ methodTemplateNames,
            /* returnCallableKindName= */ methodVariantName,
            /* returnCallableTemplateNames= */ methodTemplateNames,
            /* methodVariantName= */ methodVariantName,
            /* httpJsonCallSettingsTemplateObjects= */ Arrays.asList(
                requestTemplateName, operationType),
            /* callSettingsVariantName= */ methodVariantName,
            /* callSettingsTemplateObjects= */ methodTemplateNames.stream()
                .map(n -> (Object) n)
                .collect(Collectors.toList()),
            Collections.emptyList());

    List<Statement> createOperationCallableBody = new ArrayList<>();
    List<VariableExpr> arguments = new ArrayList<>(method.arguments());

    Variable httpJsonCallSettingsVar = arguments.get(0).variable();
    Variable operationCallSettingsVar = arguments.get(1).variable();
    Variable clientContextVar = arguments.get(2).variable();
    Variable operationsStubVar = arguments.get(3).variable();
    // Generate innerCallable
    VariableExpr innerCallableVarExpr =
        VariableExpr.builder()
            .setVariable(
                Variable.builder()
                    .setName("innerCallable")
                    .setType(
                        TypeNode.withReference(ConcreteReference.withClazz(UnaryCallable.class)))
                    .build())
            .setTemplateObjects(Arrays.asList(requestTemplateName, methodVariantName))
            .build();
    MethodInvocationExpr getInitialCallSettingsExpr =
        MethodInvocationExpr.builder()
            .setExprReferenceExpr(VariableExpr.withVariable(operationCallSettingsVar))
            .setMethodName("getInitialCallSettings")
            .build();
    MethodInvocationExpr createBaseUnaryCallableExpr =
        MethodInvocationExpr.builder()
            .setStaticReferenceType(
                TypeNode.withReference(ConcreteReference.withClazz(HttpJsonCallableFactory.class)))
            .setMethodName("createBaseUnaryCallable")
            .setArguments(
                VariableExpr.withVariable(httpJsonCallSettingsVar),
                getInitialCallSettingsExpr,
                VariableExpr.withVariable(clientContextVar))
            .setReturnType(TypeNode.withReference(ConcreteReference.withClazz(UnaryCallable.class)))
            .build();
    AssignmentExpr innerCallableAssignExpr =
        AssignmentExpr.builder()
            .setVariableExpr(innerCallableVarExpr.toBuilder().setIsDecl(true).build())
            .setValueExpr(createBaseUnaryCallableExpr)
            .build();
    createOperationCallableBody.add(ExprStatement.withExpr(innerCallableAssignExpr));

    // This is a temporary solution
    VaporReference requestT =
        VaporReference.builder()
            .setName("RequestT")
            .setPakkage(service.pakkage() + ".stub")
            .build();

    TypeNode initialCallableType =
        TypeNode.withReference(
            ConcreteReference.builder()
                .setClazz(HttpJsonOperationSnapshotCallable.class)
                .setGenerics(requestT, operationType.reference())
                .build());

    // Generate initialCallable
    VariableExpr initialCallableVarExpr =
        VariableExpr.builder()
            .setVariable(
                Variable.builder().setName("initialCallable").setType(initialCallableType).build())
            .build();
    MethodInvocationExpr getMethodDescriptorExpr =
        MethodInvocationExpr.builder()
            .setExprReferenceExpr(VariableExpr.withVariable(httpJsonCallSettingsVar))
            .setMethodName("getMethodDescriptor")
            .build();
    MethodInvocationExpr getOperationSnapshotFactoryExpr =
        MethodInvocationExpr.builder()
            .setExprReferenceExpr(getMethodDescriptorExpr)
            .setMethodName("getOperationSnapshotFactory")
            .build();

    TypeNode operationSnapshotCallableType =
        TypeNode.withReference(
            ConcreteReference.builder()
                .setClazz(HttpJsonOperationSnapshotCallable.class)
                .setGenerics(requestT, operationType.reference())
                .build());
    NewObjectExpr initialCallableObject =
        NewObjectExpr.builder()
            .setType(operationSnapshotCallableType)
            .setIsGeneric(true)
            .setArguments(innerCallableVarExpr, getOperationSnapshotFactoryExpr)
            .build();
    AssignmentExpr initialCallableAssignExpr =
        AssignmentExpr.builder()
            .setVariableExpr(initialCallableVarExpr.toBuilder().setIsDecl(true).build())
            .setValueExpr(initialCallableObject)
            .build();
    createOperationCallableBody.add(ExprStatement.withExpr(initialCallableAssignExpr));

    // Generate return statement
    MethodInvocationExpr longRunningClient =
        MethodInvocationExpr.builder()
            .setExprReferenceExpr(VariableExpr.withVariable(operationsStubVar))
            .setMethodName("longRunningClient")
            .build();
    MethodInvocationExpr createOperationCallable =
        MethodInvocationExpr.builder()
            .setStaticReferenceType(
                TypeNode.withReference(ConcreteReference.withClazz(HttpJsonCallableFactory.class)))
            .setMethodName("createOperationCallable")
            .setArguments(
                VariableExpr.withVariable(operationCallSettingsVar),
                VariableExpr.withVariable(clientContextVar),
                longRunningClient,
                initialCallableVarExpr)
            .setReturnType(
                TypeNode.withReference(ConcreteReference.withClazz(OperationCallable.class)))
            .build();

    // Add body and return statement to method
    return method.toBuilder()
        .setBody(createOperationCallableBody)
        .setReturnExpr(createOperationCallable)
        .build();
  }
}
