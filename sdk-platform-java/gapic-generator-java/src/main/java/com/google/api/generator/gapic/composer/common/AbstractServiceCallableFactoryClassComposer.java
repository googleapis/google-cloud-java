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

package com.google.api.generator.gapic.composer.common;

import com.google.api.core.BetaApi;
import com.google.api.gax.rpc.BatchingCallSettings;
import com.google.api.gax.rpc.BidiStreamingCallable;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ClientStreamingCallable;
import com.google.api.gax.rpc.OperationCallSettings;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.ServerStreamingCallSettings;
import com.google.api.gax.rpc.ServerStreamingCallable;
import com.google.api.gax.rpc.StreamingCallSettings;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.api.generator.engine.ast.AnnotationNode;
import com.google.api.generator.engine.ast.ClassDefinition;
import com.google.api.generator.engine.ast.MethodDefinition;
import com.google.api.generator.engine.ast.MethodInvocationExpr;
import com.google.api.generator.engine.ast.ScopeNode;
import com.google.api.generator.engine.ast.TypeNode;
import com.google.api.generator.engine.ast.Variable;
import com.google.api.generator.engine.ast.VariableExpr;
import com.google.api.generator.gapic.composer.comment.StubCommentComposer;
import com.google.api.generator.gapic.composer.store.TypeStore;
import com.google.api.generator.gapic.composer.utils.PackageChecker;
import com.google.api.generator.gapic.model.GapicClass;
import com.google.api.generator.gapic.model.GapicClass.Kind;
import com.google.api.generator.gapic.model.GapicContext;
import com.google.api.generator.gapic.model.Service;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.Generated;

public abstract class AbstractServiceCallableFactoryClassComposer implements ClassComposer {
  private final TransportContext transportContext;

  protected AbstractServiceCallableFactoryClassComposer(TransportContext transportContext) {
    this.transportContext = transportContext;
  }

  protected TransportContext getTransportContext() {
    return transportContext;
  }

  @Override
  public GapicClass generate(GapicContext context, Service service) {
    // Do not generate the Callable Factory if there are no RPCs enabled for the Transport
    if (!service.hasAnyEnabledMethodsForTransport(getTransportContext().transport())) {
      return GapicClass.createNonGeneratedGapicClass();
    }

    TypeStore typeStore = createTypes(service);

    String className =
        getTransportContext().classNames().getTransportServiceCallableFactoryClassName(service);
    GapicClass.Kind kind = Kind.STUB;
    String pakkage = String.format("%s.stub", service.pakkage());

    StubCommentComposer commentComposer =
        new StubCommentComposer(getTransportContext().transportNames().get(0));
    ClassDefinition classDef =
        ClassDefinition.builder()
            .setPackageString(pakkage)
            .setHeaderCommentStatements(
                commentComposer.createTransportServiceCallableFactoryClassHeaderComments(
                    service.name(), service.isDeprecated()))
            .setAnnotations(createClassAnnotations(service, typeStore))
            .setImplementsTypes(createClassImplements(service, typeStore))
            .setName(className)
            .setMethods(createClassMethods(service, typeStore))
            .setScope(ScopeNode.PUBLIC)
            .build();
    return GapicClass.create(kind, classDef);
  }

  protected List<AnnotationNode> createClassAnnotations(Service service, TypeStore typeStore) {
    List<AnnotationNode> annotations = new ArrayList<>();
    if (!PackageChecker.isGaApi(service.pakkage())) {
      annotations.add(AnnotationNode.withType(typeStore.get("BetaApi")));
    }

    if (service.isDeprecated()) {
      annotations.add(AnnotationNode.withType(TypeNode.DEPRECATED));
    }

    annotations.add(
        AnnotationNode.builder()
            .setType(typeStore.get("Generated"))
            .setDescription("by gapic-generator-java")
            .build());
    return annotations;
  }

  /**
   * Construct the type to be implemented by the generated callable factory.
   *
   * @param typeStore type store with common types
   * @return {@code TypeNode} containing the interface to be implemented by the generated callable
   *     factory class.
   */
  protected abstract List<TypeNode> createClassImplements(Service service, TypeStore typeStore);

  protected List<MethodDefinition> createClassMethods(Service service, TypeStore typeStore) {
    return Arrays.asList(
        createUnaryCallableMethod(service, typeStore),
        createPagedCallableMethod(service, typeStore),
        createBatchingCallableMethod(service, typeStore),
        createOperationCallableMethod(service, typeStore));
  }

  protected MethodDefinition createUnaryCallableMethod(Service service, TypeStore typeStore) {
    String methodVariantName = "Unary";
    String requestTemplateName = "RequestT";
    String responseTemplateName = "ResponseT";
    List<String> methodTemplateNames = Arrays.asList(requestTemplateName, responseTemplateName);
    return createGenericCallableMethod(
        service,
        typeStore,
        /* methodTemplateNames= */ methodTemplateNames,
        /* returnCallableKindName= */ methodVariantName,
        /* returnCallableTemplateNames= */ methodTemplateNames,
        /* methodVariantName= */ methodVariantName,
        /* transportCallSettingsTemplateObjects= */ methodTemplateNames.stream()
            .map(n -> (Object) n)
            .collect(Collectors.toList()),
        /* callSettingsVariantName= */ methodVariantName,
        /* callSettingsTemplateObjects= */ methodTemplateNames.stream()
            .map(n -> (Object) n)
            .collect(Collectors.toList()));
  }

  protected MethodDefinition createPagedCallableMethod(Service service, TypeStore typeStore) {
    String methodVariantName = "Paged";
    String requestTemplateName = "RequestT";
    String pagedResponseTemplateName = "PagedListResponseT";
    String responseTemplateName = "ResponseT";
    List<String> methodTemplateNames =
        Arrays.asList(requestTemplateName, responseTemplateName, pagedResponseTemplateName);
    return createGenericCallableMethod(
        service,
        typeStore,
        /* methodTemplateNames= */ methodTemplateNames,
        /* returnCallableKindName= */ "Unary",
        /* returnCallableTemplateNames= */ Arrays.asList(
            requestTemplateName, pagedResponseTemplateName),
        /* methodVariantName= */ methodVariantName,
        /* transportCallSettingsTemplateObjects= */ Arrays.asList(
            requestTemplateName, responseTemplateName),
        /* callSettingsVariantName= */ methodVariantName,
        /* callSettingsTemplateObjects= */ methodTemplateNames.stream()
            .map(n -> (Object) n)
            .collect(Collectors.toList()));
  }

  protected MethodDefinition createBatchingCallableMethod(Service service, TypeStore typeStore) {
    String methodVariantName = "Batching";
    String requestTemplateName = "RequestT";
    String responseTemplateName = "ResponseT";
    List<String> methodTemplateNames = Arrays.asList(requestTemplateName, responseTemplateName);
    return createGenericCallableMethod(
        service,
        typeStore,
        /* methodTemplateNames= */ methodTemplateNames,
        /* returnCallableKindName= */ "Unary",
        /* returnCallableTemplateNames= */ methodTemplateNames,
        /* methodVariantName= */ methodVariantName,
        /* transportCallSettingsTemplateObjects= */ methodTemplateNames.stream()
            .map(n -> (Object) n)
            .collect(Collectors.toList()),
        /* callSettingsVariantName= */ methodVariantName,
        /* callSettingsTemplateObjects= */ methodTemplateNames.stream()
            .map(n -> (Object) n)
            .collect(Collectors.toList()));
  }

  protected abstract MethodDefinition createOperationCallableMethod(
      Service service, TypeStore typeStore);

  protected MethodDefinition createServerStreamingCallableMethod(
      Service service, TypeStore typeStore) {
    String methodVariantName = "ServerStreaming";
    String requestTemplateName = "RequestT";
    String responseTemplateName = "ResponseT";
    List<String> methodTemplateNames = Arrays.asList(requestTemplateName, responseTemplateName);
    return createGenericCallableMethod(
        service,
        typeStore,
        /* methodTemplateNames= */ methodTemplateNames,
        /* returnCallableKindName= */ methodVariantName,
        /* returnCallableTemplateNames= */ methodTemplateNames,
        /* methodVariantName= */ methodVariantName,
        /* grpcCallSettingsTemplateObjects= */ methodTemplateNames.stream()
            .map(n -> (Object) n)
            .collect(Collectors.toList()),
        /* callSettingsVariantName= */ methodVariantName,
        /* callSettingsTemplateObjects= */ methodTemplateNames.stream()
            .map(n -> (Object) n)
            .collect(Collectors.toList()));
  }

  protected MethodDefinition createGenericCallableMethod(
      Service service,
      TypeStore typeStore,
      List<String> methodTemplateNames,
      String returnCallableKindName,
      List<String> returnCallableTemplateNames,
      String methodVariantName,
      List<Object> transportCallSettingsTemplateObjects,
      String callSettingsVariantName,
      List<Object> callSettingsTemplateObjects) {
    return createGenericCallableMethod(
        service,
        typeStore,
        methodTemplateNames,
        returnCallableKindName,
        returnCallableTemplateNames,
        methodVariantName,
        transportCallSettingsTemplateObjects,
        callSettingsVariantName,
        callSettingsTemplateObjects,
        Collections.emptyList());
  }

  protected MethodDefinition createGenericCallableMethod(
      Service service,
      TypeStore typeStore,
      List<String> methodTemplateNames,
      String returnCallableKindName,
      List<String> returnCallableTemplateNames,
      String methodVariantName,
      List<Object> transportCallSettingsTemplateObjects,
      String callSettingsVariantName,
      List<Object> callSettingsTemplateObjects,
      List<AnnotationNode> annotations) {

    String methodName = String.format("create%sCallable", methodVariantName);
    String callSettingsTypeName = String.format("%sCallSettings", callSettingsVariantName);
    String returnTypeName = String.format("%sCallable", returnCallableKindName);
    boolean isOperationCallable = methodVariantName.equals("Operation");

    List<VariableExpr> arguments = new ArrayList<>();
    arguments.add(
        VariableExpr.builder()
            .setVariable(
                Variable.builder()
                    .setName(getTransportContext().transportCallSettingsName())
                    .setType(getTransportContext().transportCallSettingsType())
                    .build())
            .setIsDecl(true)
            .setTemplateObjects(transportCallSettingsTemplateObjects)
            .build());
    arguments.add(
        VariableExpr.builder()
            .setVariable(
                Variable.builder()
                    .setName("callSettings")
                    .setType(typeStore.get(callSettingsTypeName))
                    .build())
            .setIsDecl(true)
            .setTemplateObjects(callSettingsTemplateObjects)
            .build());
    arguments.add(
        VariableExpr.builder()
            .setVariable(
                Variable.builder()
                    .setName("clientContext")
                    .setType(typeStore.get("ClientContext"))
                    .build())
            .setIsDecl(true)
            .build());
    if (isOperationCallable) {
      arguments.add(
          VariableExpr.builder()
              .setVariable(
                  Variable.builder()
                      .setName("operationsStub")
                      .setType(getOperationsStubType(service))
                      .build())
              .setIsDecl(true)
              .build());
    }

    TypeNode returnType = typeStore.get(returnTypeName);
    MethodInvocationExpr returnExpr =
        MethodInvocationExpr.builder()
            .setMethodName(methodName)
            .setStaticReferenceType(getTransportContext().transportCallableFactoryType())
            .setArguments(
                arguments.stream()
                    .map(v -> v.toBuilder().setIsDecl(false).build())
                    .collect(Collectors.toList()))
            .setReturnType(returnType)
            .build();

    return MethodDefinition.builder()
        .setIsOverride(true)
        .setScope(ScopeNode.PUBLIC)
        .setTemplateNames(methodTemplateNames)
        .setReturnType(returnType)
        .setReturnTemplateNames(returnCallableTemplateNames)
        .setName(methodName)
        .setArguments(arguments)
        .setReturnExpr(returnExpr)
        .setAnnotations(annotations)
        .build();
  }

  protected TypeNode getOperationsStubType(Service service) {
    TypeNode operationsStubType = service.operationServiceStubType();
    if (operationsStubType == null) {
      operationsStubType = getTransportContext().operationsStubTypes().get(0);
    }
    return operationsStubType;
  }

  private TypeStore createTypes(Service service) {
    List<Class<?>> concreteClazzes =
        Arrays.asList(
            // Gax-java classes.
            BatchingCallSettings.class,
            BetaApi.class,
            BidiStreamingCallable.class,
            ClientContext.class,
            ClientStreamingCallable.class,
            OperationCallSettings.class,
            OperationCallable.class,
            PagedCallSettings.class,
            ServerStreamingCallSettings.class,
            ServerStreamingCallable.class,
            StreamingCallSettings.class,
            UnaryCallSettings.class,
            UnaryCallable.class,
            Generated.class,
            UnsupportedOperationException.class);
    return new TypeStore(concreteClazzes);
  }
}
