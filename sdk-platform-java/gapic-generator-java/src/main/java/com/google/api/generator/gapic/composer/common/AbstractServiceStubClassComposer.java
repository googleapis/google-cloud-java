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
import com.google.api.core.InternalApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.BidiStreamingCallable;
import com.google.api.gax.rpc.ClientStreamingCallable;
import com.google.api.gax.rpc.LongRunningClient;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.ServerStreamingCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.api.generator.engine.ast.AnnotationNode;
import com.google.api.generator.engine.ast.ClassDefinition;
import com.google.api.generator.engine.ast.ConcreteReference;
import com.google.api.generator.engine.ast.ExprStatement;
import com.google.api.generator.engine.ast.MethodDefinition;
import com.google.api.generator.engine.ast.Reference;
import com.google.api.generator.engine.ast.ScopeNode;
import com.google.api.generator.engine.ast.ThrowExpr;
import com.google.api.generator.engine.ast.TypeNode;
import com.google.api.generator.gapic.composer.comment.StubCommentComposer;
import com.google.api.generator.gapic.composer.store.TypeStore;
import com.google.api.generator.gapic.composer.utils.ClassNames;
import com.google.api.generator.gapic.composer.utils.CommonStrings;
import com.google.api.generator.gapic.composer.utils.PackageChecker;
import com.google.api.generator.gapic.model.GapicClass;
import com.google.api.generator.gapic.model.GapicClass.Kind;
import com.google.api.generator.gapic.model.GapicContext;
import com.google.api.generator.gapic.model.Message;
import com.google.api.generator.gapic.model.Method;
import com.google.api.generator.gapic.model.Service;
import com.google.api.generator.gapic.utils.JavaStyle;
import com.google.common.collect.ImmutableList;
import com.google.longrunning.Operation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.annotation.Generated;

public abstract class AbstractServiceStubClassComposer implements ClassComposer {

  private final TransportContext transportContext;

  protected AbstractServiceStubClassComposer(TransportContext transportContext) {
    this.transportContext = transportContext;
  }

  protected TransportContext getTransportContext() {
    return transportContext;
  }

  @Override
  public GapicClass generate(GapicContext context, Service service) {
    Map<String, Message> messageTypes = context.messages();
    TypeStore typeStore = createTypes(service, messageTypes);
    String className = ClassNames.getServiceStubClassName(service);
    GapicClass.Kind kind = Kind.STUB;
    String pakkage = String.format("%s.stub", service.pakkage());

    ClassDefinition classDef =
        ClassDefinition.builder()
            .setPackageString(pakkage)
            .setHeaderCommentStatements(
                StubCommentComposer.createServiceStubClassHeaderComments(
                    service.name(), service.isDeprecated()))
            .setAnnotations(createClassAnnotations(service, typeStore))
            .setIsAbstract(true)
            .setImplementsTypes(createClassImplements(typeStore))
            .setName(className)
            .setMethods(createClassMethods(service, messageTypes, typeStore))
            .setScope(ScopeNode.PUBLIC)
            .build();
    return GapicClass.create(kind, classDef);
  }

  private static List<AnnotationNode> createClassAnnotations(Service service, TypeStore typeStore) {
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

  private static List<TypeNode> createClassImplements(TypeStore typeStore) {
    return Arrays.asList(typeStore.get("BackgroundResource"));
  }

  private List<MethodDefinition> createClassMethods(
      Service service, Map<String, Message> messageTypes, TypeStore typeStore) {
    List<MethodDefinition> methods = new ArrayList<>();
    if (service.hasStandardLroMethods()) {
      TypeNode operationsStubType = service.operationServiceStubType();
      methods.addAll(createOperationsStubGetters(typeStore, operationsStubType));
    }

    if (service.operationPollingMethod() != null) {
      methods.addAll(createLongRunningClientGetters(typeStore));
    }
    methods.addAll(createCallableGetters(service, messageTypes, typeStore));
    methods.addAll(createBackgroundResourceMethodOverrides());
    return methods;
  }

  private List<MethodDefinition> createCallableGetters(
      Service service, Map<String, Message> messageTypes, TypeStore typeStore) {
    // Use a traditional for-loop since the output cardinality is not necessarily 1:1 with that of
    // service.methods().
    List<MethodDefinition> javaMethods = new ArrayList<>();
    for (Method method : service.methods()) {
      if (method.hasLro()) {
        javaMethods.add(createOperationCallableGetter(method, typeStore));
      }
      if (method.isPaged()) {
        javaMethods.add(createPagedCallableGetter(method, typeStore));
      }
      javaMethods.add(createCallableGetter(method, typeStore));
    }
    return javaMethods;
  }

  private MethodDefinition createOperationCallableGetter(Method method, TypeStore typeStore) {
    return createCallableGetterHelper(method, typeStore, true, false);
  }

  private MethodDefinition createPagedCallableGetter(Method method, TypeStore typeStore) {
    return createCallableGetterHelper(method, typeStore, false, true);
  }

  private MethodDefinition createCallableGetter(Method method, TypeStore typeStore) {
    return createCallableGetterHelper(method, typeStore, false, false);
  }

  private MethodDefinition createCallableGetterHelper(
      Method method, TypeStore typeStore, boolean isLroCallable, boolean isPaged) {
    TypeNode returnType;
    switch (method.stream()) {
      case CLIENT:
        returnType = typeStore.get("ClientStreamingCallable");
        break;
      case SERVER:
        returnType = typeStore.get("ServerStreamingCallable");
        break;
      case BIDI:
        returnType = typeStore.get("BidiStreamingCallable");
        break;
      case NONE:
      // Fall through.
      default:
        returnType = typeStore.get(isLroCallable ? "OperationCallable" : "UnaryCallable");
    }

    String methodName =
        String.format(
            "%s%sCallable",
            JavaStyle.toLowerCamelCase(method.name()),
            (isLroCallable ? "Operation" : isPaged ? "Paged" : ""));
    List<Reference> genericRefs = new ArrayList<>();
    genericRefs.add(method.inputType().reference());
    if (method.hasLro() && isLroCallable) {
      genericRefs.add(method.lro().responseType().reference());
      genericRefs.add(method.lro().metadataType().reference());
    } else if (isPaged) {
      genericRefs.add(
          typeStore
              .get(String.format(CommonStrings.PAGED_RESPONSE_TYPE_NAME_PATTERN, method.name()))
              .reference());
    } else {
      genericRefs.add(method.outputType().reference());
    }

    List<AnnotationNode> annotations = new ArrayList<>();
    if (method.isDeprecated()) {
      annotations.add(AnnotationNode.withType(TypeNode.DEPRECATED));
    }
    if (method.isInternalApi()) {
      annotations.add(
          AnnotationNode.withTypeAndDescription(
              typeStore.get("InternalApi"), CommonStrings.INTERNAL_API_WARNING));
    }

    returnType = TypeNode.withReference(returnType.reference().copyAndSetGenerics(genericRefs));

    return createCallableGetterMethodDefinition(returnType, methodName, annotations, typeStore);
  }

  private List<MethodDefinition> createOperationsStubGetters(
      TypeStore typeStore, TypeNode operationsStubType) {
    List<MethodDefinition> getters = new ArrayList<>();

    Iterator<String> operationStubNameIt =
        getTransportContext().transportOperationsStubNames().iterator();
    Iterator<TypeNode> operationStubTypeIt = getTransportContext().operationsStubTypes().iterator();

    while (operationStubNameIt.hasNext() && operationStubTypeIt.hasNext()) {
      String methodName =
          String.format("get%s", JavaStyle.toUpperCamelCase(operationStubNameIt.next()));
      // TODO: refactor this
      TypeNode actualOperationsStubType = operationStubTypeIt.next();
      if (operationsStubType != null) {
        actualOperationsStubType = operationsStubType;
      }

      getters.add(
          createOperationsStubGetterMethodDefinition(
              actualOperationsStubType, methodName, typeStore));
    }

    return getters;
  }

  private List<MethodDefinition> createLongRunningClientGetters(TypeStore typeStore) {
    return ImmutableList.of(
        createCallableGetterMethodDefinition(
            TypeNode.withReference(ConcreteReference.withClazz(LongRunningClient.class)),
            "longRunningClient",
            Collections.emptyList(),
            typeStore));
  }

  private static List<MethodDefinition> createBackgroundResourceMethodOverrides() {
    MethodDefinition closeMethod =
        MethodDefinition.builder()
            .setIsOverride(true)
            .setScope(ScopeNode.PUBLIC)
            .setIsAbstract(true)
            .setReturnType(TypeNode.VOID)
            .setName("close")
            .build();
    return Arrays.asList(closeMethod);
  }

  private static TypeStore createTypes(Service service, Map<String, Message> messageTypes) {
    List<Class<?>> concreteClazzes =
        Arrays.asList(
            BackgroundResource.class,
            BetaApi.class,
            InternalApi.class,
            BidiStreamingCallable.class,
            ClientStreamingCallable.class,
            Generated.class,
            Operation.class,
            OperationCallable.class,
            ServerStreamingCallable.class,
            UnaryCallable.class,
            UnsupportedOperationException.class);
    TypeStore typeStore = new TypeStore(concreteClazzes);

    typeStore.put("com.google.longrunning.stub", "OperationsStub");

    // Pagination types.
    typeStore.putAll(
        service.pakkage(),
        service.methods().stream()
            .filter(m -> m.isPaged())
            .map(m -> String.format(CommonStrings.PAGED_RESPONSE_TYPE_NAME_PATTERN, m.name()))
            .collect(Collectors.toList()),
        true,
        ClassNames.getServiceClientClassName(service));

    return typeStore;
  }

  protected MethodDefinition createCallableGetterMethodDefinition(
      TypeNode returnType,
      String methodName,
      List<AnnotationNode> annotations,
      TypeStore typeStore) {
    return MethodDefinition.builder()
        .setScope(ScopeNode.PUBLIC)
        .setAnnotations(annotations)
        .setName(methodName)
        .setReturnType(returnType)
        .setBody(
            Arrays.asList(
                ExprStatement.withExpr(
                    ThrowExpr.builder()
                        .setType(typeStore.get("UnsupportedOperationException"))
                        .setMessageExpr(String.format("Not implemented: %s()", methodName))
                        .build())))
        .build();
  }

  protected MethodDefinition createOperationsStubGetterMethodDefinition(
      TypeNode returnType, String methodName, TypeStore typeStore) {
    return MethodDefinition.builder()
        .setScope(ScopeNode.PUBLIC)
        .setReturnType(returnType)
        .setName(methodName)
        .setBody(
            Arrays.asList(
                ExprStatement.withExpr(
                    ThrowExpr.builder()
                        .setType(typeStore.get("UnsupportedOperationException"))
                        .setMessageExpr(String.format("Not implemented: %s()", methodName))
                        .build())))
        .build();
  }
}
