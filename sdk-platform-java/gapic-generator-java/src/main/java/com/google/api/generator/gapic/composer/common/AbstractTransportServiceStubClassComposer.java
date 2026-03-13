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
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.longrunning.OperationSnapshot;
import com.google.api.gax.rpc.BidiStreamingCallable;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ClientStreamingCallable;
import com.google.api.gax.rpc.LongRunningClient;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.RequestParamsExtractor;
import com.google.api.gax.rpc.ServerStreamingCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.api.generator.engine.ast.AnnotationNode;
import com.google.api.generator.engine.ast.AssignmentExpr;
import com.google.api.generator.engine.ast.ClassDefinition;
import com.google.api.generator.engine.ast.CommentStatement;
import com.google.api.generator.engine.ast.ConcreteReference;
import com.google.api.generator.engine.ast.EmptyLineStatement;
import com.google.api.generator.engine.ast.Expr;
import com.google.api.generator.engine.ast.ExprStatement;
import com.google.api.generator.engine.ast.IfStatement;
import com.google.api.generator.engine.ast.JavaDocComment;
import com.google.api.generator.engine.ast.LambdaExpr;
import com.google.api.generator.engine.ast.LogicalOperationExpr;
import com.google.api.generator.engine.ast.MethodDefinition;
import com.google.api.generator.engine.ast.MethodInvocationExpr;
import com.google.api.generator.engine.ast.NewObjectExpr;
import com.google.api.generator.engine.ast.Reference;
import com.google.api.generator.engine.ast.ReferenceConstructorExpr;
import com.google.api.generator.engine.ast.RelationalOperationExpr;
import com.google.api.generator.engine.ast.ScopeNode;
import com.google.api.generator.engine.ast.Statement;
import com.google.api.generator.engine.ast.StringObjectValue;
import com.google.api.generator.engine.ast.ThisObjectValue;
import com.google.api.generator.engine.ast.ThrowExpr;
import com.google.api.generator.engine.ast.TryCatchStatement;
import com.google.api.generator.engine.ast.TypeNode;
import com.google.api.generator.engine.ast.ValueExpr;
import com.google.api.generator.engine.ast.VaporReference;
import com.google.api.generator.engine.ast.Variable;
import com.google.api.generator.engine.ast.VariableExpr;
import com.google.api.generator.gapic.composer.comment.StubCommentComposer;
import com.google.api.generator.gapic.composer.store.TypeStore;
import com.google.api.generator.gapic.composer.utils.CommonStrings;
import com.google.api.generator.gapic.composer.utils.PackageChecker;
import com.google.api.generator.gapic.model.Field;
import com.google.api.generator.gapic.model.GapicClass;
import com.google.api.generator.gapic.model.GapicClass.Kind;
import com.google.api.generator.gapic.model.GapicContext;
import com.google.api.generator.gapic.model.GapicServiceConfig;
import com.google.api.generator.gapic.model.HttpBindings;
import com.google.api.generator.gapic.model.Message;
import com.google.api.generator.gapic.model.Method;
import com.google.api.generator.gapic.model.RoutingHeaderRule;
import com.google.api.generator.gapic.model.Service;
import com.google.api.generator.gapic.model.Transport;
import com.google.api.generator.gapic.utils.JavaStyle;
import com.google.api.pathtemplate.PathTemplate;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.base.Splitter;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.longrunning.Operation;
import com.google.protobuf.TypeRegistry;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import javax.annotation.Generated;
import javax.annotation.Nullable;

public abstract class AbstractTransportServiceStubClassComposer implements ClassComposer {
  private static final Statement EMPTY_LINE_STATEMENT = EmptyLineStatement.create();

  private static final String METHOD_DESCRIPTOR_NAME_PATTERN = "%sMethodDescriptor";
  private static final String PAGED_CALLABLE_CLASS_MEMBER_PATTERN = "%sPagedCallable";

  private static final String BACKGROUND_RESOURCES_MEMBER_NAME = "backgroundResources";
  private static final String CALLABLE_FACTORY_MEMBER_NAME = "callableFactory";
  protected static final String CALLABLE_CLASS_MEMBER_PATTERN = "%sCallable";
  private static final String OPERATION_CALLABLE_CLASS_MEMBER_PATTERN = "%sOperationCallable";

  protected static final TypeStore FIXED_TYPESTORE = createStaticTypes();

  private final TransportContext transportContext;

  protected AbstractTransportServiceStubClassComposer(TransportContext transportContext) {
    this.transportContext = transportContext;
  }

  public TransportContext getTransportContext() {
    return transportContext;
  }

  private static TypeStore createStaticTypes() {
    List<Class<?>> concreteClazzes =
        Arrays.asList(
            BackgroundResource.class,
            BackgroundResourceAggregation.class,
            BetaApi.class,
            BidiStreamingCallable.class,
            ClientContext.class,
            ClientStreamingCallable.class,
            Generated.class,
            ImmutableMap.class,
            InterruptedException.class,
            IOException.class,
            Operation.class,
            OperationCallable.class,
            OperationSnapshot.class,
            RequestParamsExtractor.class,
            UUID.class,
            ServerStreamingCallable.class,
            TimeUnit.class,
            TypeRegistry.class,
            UnaryCallable.class,
            UnsupportedOperationException.class);
    return new TypeStore(concreteClazzes);
  }

  @Override
  public GapicClass generate(GapicContext context, Service service) {
    if (!service.hasAnyEnabledMethodsForTransport(getTransportContext().transport())) {
      return GapicClass.createNonGeneratedGapicClass();
    }

    String pakkage = service.pakkage() + ".stub";
    TypeStore typeStore = createDynamicTypes(service, pakkage);
    String className = getTransportContext().classNames().getTransportServiceStubClassName(service);
    GapicClass.Kind kind = Kind.STUB;

    Map<String, VariableExpr> protoMethodNameToDescriptorVarExprs =
        createProtoMethodNameToDescriptorClassMembers(
            service, getTransportContext().methodDescriptorClass());

    Map<String, VariableExpr> callableClassMemberVarExprs =
        createCallableClassMembers(service, typeStore);

    Map<String, VariableExpr> classMemberVarExprs = new LinkedHashMap<>();
    classMemberVarExprs.put(
        BACKGROUND_RESOURCES_MEMBER_NAME,
        VariableExpr.withVariable(
            Variable.builder()
                .setName(BACKGROUND_RESOURCES_MEMBER_NAME)
                .setType(FIXED_TYPESTORE.get("BackgroundResource"))
                .build()));
    if (generateOperationsStubLogic(service)) {
      // Transport-specific service stub may have only one element of the following, thus get(0).
      TypeNode operationsStubType = getTransportOperationsStubType(service);
      classMemberVarExprs.put(
          getTransportContext().transportOperationsStubNames().get(0),
          VariableExpr.withVariable(
              Variable.builder()
                  .setName(getTransportContext().transportOperationsStubNames().get(0))
                  .setType(operationsStubType)
                  .build()));
    }

    boolean operationPollingMethod = checkOperationPollingMethod(service);
    if (operationPollingMethod) {
      VariableExpr longRunningVarExpr = declareLongRunningClient();
      if (longRunningVarExpr != null) {
        classMemberVarExprs.put("longRunningClient", longRunningVarExpr);
      }
    }

    classMemberVarExprs.put(
        CALLABLE_FACTORY_MEMBER_NAME,
        VariableExpr.withVariable(
            Variable.builder()
                .setName(CALLABLE_FACTORY_MEMBER_NAME)
                .setType(getTransportContext().stubCallableFactoryType())
                .build()));

    Map<String, Message> messageTypes = context.messages();
    List<Statement> classStatements =
        createClassStatements(
            service,
            protoMethodNameToDescriptorVarExprs,
            callableClassMemberVarExprs,
            classMemberVarExprs,
            messageTypes,
            context.restNumericEnumsEnabled());

    List<MethodDefinition> methodDefinitions =
        createClassMethods(
            context,
            service,
            typeStore,
            classMemberVarExprs,
            callableClassMemberVarExprs,
            protoMethodNameToDescriptorVarExprs,
            classStatements);
    methodDefinitions.addAll(
        createStubOverrideMethods(
            classMemberVarExprs.get(BACKGROUND_RESOURCES_MEMBER_NAME), service));

    StubCommentComposer commentComposer =
        new StubCommentComposer(getTransportContext().transportNames().get(0));

    ClassDefinition classDef =
        ClassDefinition.builder()
            .setPackageString(pakkage)
            .setHeaderCommentStatements(
                commentComposer.createTransportServiceStubClassHeaderComments(
                    service.name(), service.isDeprecated()))
            .setAnnotations(createClassAnnotations(service))
            .setScope(ScopeNode.PUBLIC)
            .setName(className)
            .setExtendsType(
                typeStore.get(getTransportContext().classNames().getServiceStubClassName(service)))
            .setMethods(methodDefinitions)
            .setStatements(classStatements)
            .build();
    return GapicClass.create(kind, classDef);
  }

  protected abstract Statement createMethodDescriptorVariableDecl(
      Service service,
      Method protoMethod,
      VariableExpr methodDescriptorVarExpr,
      Map<String, Message> messageTypes,
      boolean restNumericEnumsEnabled);

  protected boolean generateOperationsStubLogic(Service service) {
    return true;
  }

  protected List<MethodDefinition> createOperationsStubGetterMethod(
      Service service, VariableExpr operationsStubVarExpr) {
    if (!generateOperationsStubLogic(service)) {
      return Collections.emptyList();
    }

    String methodName =
        String.format(
            "get%s",
            JavaStyle.toUpperCamelCase(
                getTransportContext().transportOperationsStubNames().get(0)));

    return Arrays.asList(
        MethodDefinition.builder()
            .setScope(ScopeNode.PUBLIC)
            .setReturnType(operationsStubVarExpr.type())
            .setName(methodName)
            .setReturnExpr(operationsStubVarExpr)
            .build());
  }

  protected Expr createTransportSettingsInitExpr(
      Method method,
      VariableExpr transportSettingsVarExpr,
      VariableExpr methodDescriptorVarExpr,
      List<Statement> classStatements,
      ImmutableMap<String, Message> messageTypes) {
    MethodInvocationExpr callSettingsBuilderExpr =
        MethodInvocationExpr.builder()
            .setStaticReferenceType(getTransportContext().transportCallSettingsType())
            .setGenerics(transportSettingsVarExpr.type().reference().generics())
            .setMethodName("newBuilder")
            .build();
    callSettingsBuilderExpr =
        MethodInvocationExpr.builder()
            .setExprReferenceExpr(callSettingsBuilderExpr)
            .setMethodName("setMethodDescriptor")
            .setArguments(Arrays.asList(methodDescriptorVarExpr))
            .build();

    // Transport is set to be either REST or GRPC from the sub composers
    if (getTransportContext().transport() == Transport.REST) {
      callSettingsBuilderExpr =
          MethodInvocationExpr.builder()
              .setExprReferenceExpr(callSettingsBuilderExpr)
              .setMethodName("setTypeRegistry")
              .setArguments(
                  Arrays.asList(
                      VariableExpr.builder()
                          .setVariable(
                              Variable.builder()
                                  .setName("typeRegistry")
                                  .setType(FIXED_TYPESTORE.get(TypeRegistry.class.getSimpleName()))
                                  .build())
                          .build()))
              .build();
    }

    if (method.shouldSetParamsExtractor()) {
      callSettingsBuilderExpr =
          MethodInvocationExpr.builder()
              .setExprReferenceExpr(callSettingsBuilderExpr)
              .setMethodName("setParamsExtractor")
              .setArguments(createRequestParamsExtractorClassInstance(method, classStatements))
              .build();
    }

    if (method.hasAutoPopulatedFields() && shouldGenerateRequestMutator(method, messageTypes)) {
      callSettingsBuilderExpr =
          MethodInvocationExpr.builder()
              .setExprReferenceExpr(callSettingsBuilderExpr)
              .setMethodName("setRequestMutator")
              .setArguments(createRequestMutatorClassInstance(method, messageTypes))
              .build();
    }

    callSettingsBuilderExpr =
        MethodInvocationExpr.builder()
            .setExprReferenceExpr(callSettingsBuilderExpr)
            .setMethodName("build")
            .setReturnType(transportSettingsVarExpr.type())
            .build();
    return AssignmentExpr.builder()
        .setVariableExpr(transportSettingsVarExpr.toBuilder().setIsDecl(true).build())
        .setValueExpr(callSettingsBuilderExpr)
        .build();
  }

  protected List<MethodDefinition> createGetMethodDescriptorsMethod(
      Service service,
      TypeStore typeStore,
      Map<String, VariableExpr> protoMethodNameToDescriptorVarExprs) {
    return Arrays.asList();
  }

  protected List<Statement> createTypeRegistry(Service service) {
    return Arrays.asList();
  }

  protected List<Statement> createClassStatements(
      Service service,
      Map<String, VariableExpr> protoMethodNameToDescriptorVarExprs,
      Map<String, VariableExpr> callableClassMemberVarExprs,
      Map<String, VariableExpr> classMemberVarExprs,
      Map<String, Message> messageTypes,
      boolean restNumericEnumsEnabled) {
    List<Statement> classStatements = new ArrayList<>();

    classStatements.addAll(createTypeRegistry(service));
    if (!classStatements.isEmpty()) {
      classStatements.add(EMPTY_LINE_STATEMENT);
    }

    for (Statement statement :
        createMethodDescriptorVariableDecls(
            service, protoMethodNameToDescriptorVarExprs, messageTypes, restNumericEnumsEnabled)) {
      classStatements.add(statement);
      classStatements.add(EMPTY_LINE_STATEMENT);
    }

    classStatements.addAll(createClassMemberFieldDeclarations(callableClassMemberVarExprs));
    classStatements.add(EMPTY_LINE_STATEMENT);

    classStatements.addAll(createClassMemberFieldDeclarations(classMemberVarExprs));
    classStatements.add(EMPTY_LINE_STATEMENT);

    return classStatements;
  }

  protected List<Statement> createMethodDescriptorVariableDecls(
      Service service,
      Map<String, VariableExpr> protoMethodNameToDescriptorVarExprs,
      Map<String, Message> messageTypes,
      boolean restNumericEnumsEnabled) {
    return service.methods().stream()
        .filter(x -> x.isSupportedByTransport(getTransportContext().transport()))
        .map(
            m ->
                createMethodDescriptorVariableDecl(
                    service,
                    m,
                    protoMethodNameToDescriptorVarExprs.get(m.name()),
                    messageTypes,
                    restNumericEnumsEnabled))
        .collect(Collectors.toList());
  }

  private static List<Statement> createClassMemberFieldDeclarations(
      Map<String, VariableExpr> fieldNameToVarExprs) {
    return fieldNameToVarExprs.values().stream()
        .map(
            v ->
                ExprStatement.withExpr(
                    v.toBuilder()
                        .setIsDecl(true)
                        .setScope(ScopeNode.PRIVATE)
                        .setIsFinal(true)
                        .build()))
        .collect(Collectors.toList());
  }

  protected Map<String, VariableExpr> createProtoMethodNameToDescriptorClassMembers(
      Service service, Class<?> descriptorClass) {
    return service.methods().stream()
        .filter(x -> x.isSupportedByTransport(getTransportContext().transport()))
        .collect(
            Collectors.toMap(
                Method::name,
                m ->
                    VariableExpr.withVariable(
                        Variable.builder()
                            .setName(
                                String.format(
                                    METHOD_DESCRIPTOR_NAME_PATTERN,
                                    JavaStyle.toLowerCamelCase(m.name())))
                            .setType(
                                TypeNode.withReference(
                                    ConcreteReference.builder()
                                        .setClazz(descriptorClass)
                                        .setGenerics(
                                            Arrays.asList(
                                                m.inputType().reference(),
                                                m.outputType().reference()))
                                        .build()))
                            .build()),
                (u, v) -> {
                  throw new IllegalStateException();
                },
                LinkedHashMap::new));
  }

  private Map<String, VariableExpr> createCallableClassMembers(
      Service service, TypeStore typeStore) {
    Map<String, VariableExpr> callableClassMembers = new LinkedHashMap<>();
    // Using a for-loop because the output cardinality is not a 1:1 mapping to the input set.
    for (Method protoMethod : service.methods()) {
      if (!protoMethod.isSupportedByTransport(getTransportContext().transport())) {
        continue;
      }
      String javaStyleProtoMethodName = JavaStyle.toLowerCamelCase(protoMethod.name());
      String callableName = String.format(CALLABLE_CLASS_MEMBER_PATTERN, javaStyleProtoMethodName);
      callableClassMembers.put(callableName, getCallableExpr(protoMethod, callableName));
      if (protoMethod.hasLro()) {
        callableName =
            String.format(OPERATION_CALLABLE_CLASS_MEMBER_PATTERN, javaStyleProtoMethodName);
        callableClassMembers.put(callableName, getOperationCallableExpr(protoMethod, callableName));
      }
      if (protoMethod.isPaged()) {
        callableName = String.format(PAGED_CALLABLE_CLASS_MEMBER_PATTERN, javaStyleProtoMethodName);
        callableClassMembers.put(
            callableName, getPagedCallableExpr(typeStore, protoMethod, callableName));
      }
    }
    return callableClassMembers;
  }

  private VariableExpr getCallableExpr(Method protoMethod, String callableName) {
    return VariableExpr.withVariable(
        Variable.builder().setName(callableName).setType(getCallableType(protoMethod)).build());
  }

  private VariableExpr getPagedCallableExpr(
      TypeStore typeStore, Method protoMethod, String callableName) {
    return VariableExpr.withVariable(
        Variable.builder()
            .setName(callableName)
            .setType(
                TypeNode.withReference(
                    getCallableType(protoMethod)
                        .reference()
                        .copyAndSetGenerics(
                            Arrays.asList(
                                protoMethod.inputType().reference(),
                                typeStore
                                    .get(
                                        String.format(
                                            CommonStrings.PAGED_RESPONSE_TYPE_NAME_PATTERN,
                                            protoMethod.name()))
                                    .reference()))))
            .build());
  }

  private VariableExpr getOperationCallableExpr(Method protoMethod, String callableName) {
    return VariableExpr.withVariable(
        Variable.builder()
            .setName(callableName)
            .setType(
                TypeNode.withReference(
                    ConcreteReference.builder()
                        .setClazz(OperationCallable.class)
                        .setGenerics(
                            Arrays.asList(
                                protoMethod.inputType().reference(),
                                protoMethod.lro().responseType().reference(),
                                protoMethod.lro().metadataType().reference()))
                        .build()))
            .build());
  }

  protected List<AnnotationNode> createClassAnnotations(Service service) {
    List<AnnotationNode> annotations = new ArrayList<>();
    if (!PackageChecker.isGaApi(service.pakkage())) {
      annotations.add(AnnotationNode.withType(FIXED_TYPESTORE.get("BetaApi")));
    }

    if (service.isDeprecated()) {
      annotations.add(AnnotationNode.withType(TypeNode.DEPRECATED));
    }

    annotations.add(
        AnnotationNode.builder()
            .setType(FIXED_TYPESTORE.get("Generated"))
            .setDescription("by gapic-generator-java")
            .build());
    return annotations;
  }

  protected List<MethodDefinition> createClassMethods(
      GapicContext context,
      Service service,
      TypeStore typeStore,
      Map<String, VariableExpr> classMemberVarExprs,
      Map<String, VariableExpr> callableClassMemberVarExprs,
      Map<String, VariableExpr> protoMethodNameToDescriptorVarExprs,
      List<Statement> classStatements) {
    List<MethodDefinition> javaMethods = new ArrayList<>();
    javaMethods.addAll(createStaticCreatorMethods(service, typeStore, "newBuilder"));
    javaMethods.addAll(
        createConstructorMethods(
            context,
            service,
            typeStore,
            classMemberVarExprs,
            protoMethodNameToDescriptorVarExprs,
            classStatements));
    javaMethods.addAll(
        createGetMethodDescriptorsMethod(service, typeStore, protoMethodNameToDescriptorVarExprs));
    javaMethods.addAll(
        createOperationsStubGetterMethod(
            service,
            classMemberVarExprs.get(getTransportContext().transportOperationsStubNames().get(0))));
    javaMethods.addAll(createCallableGetterMethods(callableClassMemberVarExprs));
    return javaMethods;
  }

  protected List<MethodDefinition> createStaticCreatorMethods(
      Service service, TypeStore typeStore, String newBuilderMethod) {
    TypeNode creatorMethodReturnType =
        typeStore.get(getTransportContext().classNames().getTransportServiceStubClassName(service));
    Function<List<VariableExpr>, MethodDefinition.Builder> creatorMethodStarterFn =
        argList ->
            MethodDefinition.builder()
                .setScope(ScopeNode.PUBLIC)
                .setIsStatic(true)
                .setIsFinal(true)
                .setReturnType(creatorMethodReturnType)
                .setName("create")
                .setArguments(
                    argList.stream()
                        .map(v -> v.toBuilder().setIsDecl(true).build())
                        .collect(Collectors.toList()))
                .setThrowsExceptions(
                    Arrays.asList(
                        TypeNode.withReference(ConcreteReference.withClazz(IOException.class))));

    Function<List<Expr>, Expr> instantiatorExprFn =
        argList ->
            NewObjectExpr.builder().setType(creatorMethodReturnType).setArguments(argList).build();

    TypeNode stubSettingsType =
        typeStore.get(getTransportContext().classNames().getServiceStubSettingsClassName(service));
    VariableExpr settingsVarExpr =
        VariableExpr.withVariable(
            Variable.builder().setName("settings").setType(stubSettingsType).build());

    TypeNode clientContextType = FIXED_TYPESTORE.get("ClientContext");
    VariableExpr clientContextVarExpr =
        VariableExpr.withVariable(
            Variable.builder().setName("clientContext").setType(clientContextType).build());

    VariableExpr callableFactoryVarExpr =
        VariableExpr.withVariable(
            Variable.builder()
                .setName("callableFactory")
                .setType(getTransportContext().stubCallableFactoryType())
                .build());

    MethodInvocationExpr clientContextCreateMethodExpr =
        MethodInvocationExpr.builder()
            .setMethodName("create")
            .setStaticReferenceType(clientContextType)
            .setArguments(Arrays.asList(settingsVarExpr))
            .build();
    MethodInvocationExpr settingsBuilderMethodExpr =
        MethodInvocationExpr.builder()
            .setMethodName(newBuilderMethod)
            .setStaticReferenceType(stubSettingsType)
            .build();
    settingsBuilderMethodExpr =
        MethodInvocationExpr.builder()
            .setMethodName("build")
            .setExprReferenceExpr(settingsBuilderMethodExpr)
            .build();

    return Arrays.asList(
        creatorMethodStarterFn
            .apply(Arrays.asList(settingsVarExpr))
            .setReturnExpr(
                instantiatorExprFn.apply(
                    Arrays.asList(settingsVarExpr, clientContextCreateMethodExpr)))
            .build(),
        creatorMethodStarterFn
            .apply(Arrays.asList(clientContextVarExpr))
            .setReturnExpr(
                instantiatorExprFn.apply(
                    Arrays.asList(settingsBuilderMethodExpr, clientContextVarExpr)))
            .build(),
        creatorMethodStarterFn
            .apply(Arrays.asList(clientContextVarExpr, callableFactoryVarExpr))
            .setReturnExpr(
                instantiatorExprFn.apply(
                    Arrays.asList(
                        settingsBuilderMethodExpr, clientContextVarExpr, callableFactoryVarExpr)))
            .build());
  }

  protected List<MethodDefinition> createConstructorMethods(
      GapicContext context,
      Service service,
      TypeStore typeStore,
      Map<String, VariableExpr> classMemberVarExprs,
      Map<String, VariableExpr> protoMethodNameToDescriptorVarExprs,
      List<Statement> classStatements) {
    TypeNode stubSettingsType =
        typeStore.get(getTransportContext().classNames().getServiceStubSettingsClassName(service));
    VariableExpr settingsVarExpr =
        VariableExpr.withVariable(
            Variable.builder().setName("settings").setType(stubSettingsType).build());

    TypeNode clientContextType = FIXED_TYPESTORE.get("ClientContext");
    VariableExpr clientContextVarExpr =
        VariableExpr.withVariable(
            Variable.builder().setName("clientContext").setType(clientContextType).build());

    VariableExpr callableFactoryVarExpr =
        VariableExpr.withVariable(
            Variable.builder()
                .setName("callableFactory")
                .setType(getTransportContext().stubCallableFactoryType())
                .build());

    TypeNode thisClassType =
        typeStore.get(getTransportContext().classNames().getTransportServiceStubClassName(service));
    TypeNode ioExceptionType =
        TypeNode.withReference(ConcreteReference.withClazz(IOException.class));

    BiFunction<List<VariableExpr>, List<Statement>, MethodDefinition> ctorMakerFn =
        (args, body) ->
            MethodDefinition.constructorBuilder()
                .setScope(ScopeNode.PROTECTED)
                .setReturnType(thisClassType)
                .setHeaderCommentStatements(Arrays.asList(createProtectedCtorComment(service)))
                .setArguments(
                    args.stream()
                        .map(v -> v.toBuilder().setIsDecl(true).build())
                        .collect(Collectors.toList()))
                .setThrowsExceptions(Arrays.asList(ioExceptionType))
                .setBody(body)
                .build();

    // First constructor method.
    MethodDefinition firstCtor =
        ctorMakerFn.apply(
            Arrays.asList(settingsVarExpr, clientContextVarExpr),
            Arrays.asList(
                ExprStatement.withExpr(
                    ReferenceConstructorExpr.thisBuilder()
                        .setType(thisClassType)
                        .setArguments(
                            settingsVarExpr,
                            clientContextVarExpr,
                            NewObjectExpr.builder()
                                .setType(
                                    typeStore.get(
                                        getTransportContext()
                                            .classNames()
                                            .getTransportServiceCallableFactoryClassName(service)))
                                .build())
                        .build())));

    Expr thisExpr =
        ValueExpr.withValue(
            ThisObjectValue.withType(
                typeStore.get(
                    getTransportContext().classNames().getTransportServiceStubClassName(service))));
    // Body of the second constructor method.
    List<Statement> secondCtorStatements = new ArrayList<>();
    List<Expr> secondCtorExprs = new ArrayList<>();
    secondCtorExprs.add(
        AssignmentExpr.builder()
            .setVariableExpr(
                classMemberVarExprs.get("callableFactory").toBuilder()
                    .setExprReferenceExpr(thisExpr)
                    .build())
            .setValueExpr(callableFactoryVarExpr)
            .build());
    VariableExpr operationsStubClassVarExpr =
        classMemberVarExprs.get(getTransportContext().transportOperationsStubNames().get(0));
    // TODO: refactor this
    if (generateOperationsStubLogic(service)) {
      secondCtorExprs.addAll(
          createOperationsStubInitExpr(
              context,
              service,
              thisExpr,
              operationsStubClassVarExpr,
              clientContextVarExpr,
              callableFactoryVarExpr));
    }
    secondCtorStatements.addAll(
        secondCtorExprs.stream().map(ExprStatement::withExpr).collect(Collectors.toList()));
    secondCtorExprs.clear();
    secondCtorStatements.add(EMPTY_LINE_STATEMENT);

    // Transport settings local variables.
    Map<String, VariableExpr> javaStyleMethodNameToTransportSettingsVarExprs =
        service.methods().stream()
            .filter(x -> x.isSupportedByTransport(getTransportContext().transport()))
            .collect(
                Collectors.toMap(
                    m -> JavaStyle.toLowerCamelCase(m.name()),
                    m ->
                        VariableExpr.withVariable(
                            Variable.builder()
                                .setName(
                                    String.format(
                                        "%sTransportSettings",
                                        JavaStyle.toLowerCamelCase(m.name())))
                                .setType(
                                    TypeNode.withReference(
                                        ConcreteReference.builder()
                                            .setClazz(getTransportContext().callSettingsClass())
                                            .setGenerics(
                                                Arrays.asList(
                                                    m.inputType().reference(),
                                                    m.outputType().reference()))
                                            .build()))
                                .build())));

    secondCtorExprs.addAll(
        service.methods().stream()
            .filter(x -> x.isSupportedByTransport(getTransportContext().transport()))
            .map(
                m ->
                    createTransportSettingsInitExpr(
                        m,
                        javaStyleMethodNameToTransportSettingsVarExprs.get(
                            JavaStyle.toLowerCamelCase(m.name())),
                        protoMethodNameToDescriptorVarExprs.get(m.name()),
                        classStatements,
                        context.messages()))
            .collect(Collectors.toList()));
    secondCtorStatements.addAll(
        secondCtorExprs.stream().map(ExprStatement::withExpr).collect(Collectors.toList()));
    secondCtorExprs.clear();
    secondCtorStatements.add(EMPTY_LINE_STATEMENT);

    // Initialize <method>Callable variables.
    // The logic inside createCallableInitExprs() is very similar to createCallableClassMembers().
    // It is mostly duplicated because `createCallableClassMembers` returns a heuristic to
    // determine the RPC type. The RPCs are mapped by name and the types are determined by the
    // generated name and was problematic for certain RPC names. For example, the GetApiOperation
    // RPC name would have a mapping of GetApiOperationCallable, and the `createCallableInitExprs`
    // method would attempt to generate LRO code because of the `OperationCallable` suffix.
    // Instead, we now pass the method object which is the SoT for the type of the method and not
    // based on heuristics/ suffix.
    for (Method method : service.methods()) {
      // Do not generate callables for non supported RPCs (i.e. Bidi-Streaming and Client Streaming
      // for HttpJson)
      if (!method.isSupportedByTransport(getTransportContext().transport())) {
        continue;
      }
      secondCtorExprs.addAll(
          createCallableInitExprs(
              context,
              service,
              method,
              typeStore,
              callableFactoryVarExpr,
              settingsVarExpr,
              clientContextVarExpr,
              operationsStubClassVarExpr,
              thisExpr,
              javaStyleMethodNameToTransportSettingsVarExprs));
    }
    secondCtorStatements.addAll(
        secondCtorExprs.stream().map(ExprStatement::withExpr).collect(Collectors.toList()));
    secondCtorExprs.clear();
    secondCtorStatements.add(EMPTY_LINE_STATEMENT);

    secondCtorStatements.addAll(createLongRunningClient(service, typeStore));

    // Instantiate backgroundResources.
    MethodInvocationExpr getBackgroundResourcesMethodExpr =
        MethodInvocationExpr.builder()
            .setExprReferenceExpr(clientContextVarExpr)
            .setMethodName("getBackgroundResources")
            .build();

    VariableExpr backgroundResourcesVarExpr = classMemberVarExprs.get("backgroundResources");
    secondCtorExprs.add(
        AssignmentExpr.builder()
            .setVariableExpr(
                backgroundResourcesVarExpr.toBuilder().setExprReferenceExpr(thisExpr).build())
            .setValueExpr(
                NewObjectExpr.builder()
                    .setType(FIXED_TYPESTORE.get("BackgroundResourceAggregation"))
                    .setArguments(Arrays.asList(getBackgroundResourcesMethodExpr))
                    .build())
            .build());
    secondCtorStatements.addAll(
        secondCtorExprs.stream().map(ExprStatement::withExpr).collect(Collectors.toList()));
    secondCtorExprs.clear();

    // Second constructor method.
    MethodDefinition secondCtor =
        ctorMakerFn.apply(
            Arrays.asList(settingsVarExpr, clientContextVarExpr, callableFactoryVarExpr),
            secondCtorStatements);

    return Arrays.asList(firstCtor, secondCtor);
  }

  protected List<Expr> createOperationsStubInitExpr(
      GapicContext context,
      Service service,
      Expr thisExpr,
      VariableExpr operationsStubClassVarExpr,
      VariableExpr clientContextVarExpr,
      VariableExpr callableFactoryVarExpr) {
    TypeNode operationsStubType = getTransportOperationsStubType(service);
    return Collections.singletonList(
        AssignmentExpr.builder()
            .setVariableExpr(
                operationsStubClassVarExpr.toBuilder().setExprReferenceExpr(thisExpr).build())
            .setValueExpr(
                MethodInvocationExpr.builder()
                    .setStaticReferenceType(operationsStubType)
                    .setMethodName("create")
                    .setArguments(Arrays.asList(clientContextVarExpr, callableFactoryVarExpr))
                    .setReturnType(operationsStubClassVarExpr.type())
                    .build())
            .build());
  }

  protected List<Statement> createLongRunningClient(Service service, TypeStore typeStore) {
    return ImmutableList.of();
  }

  @Nullable
  protected VariableExpr declareLongRunningClient() {
    return null;
  }

  // Can return multiple Exprs for a single RPC. Each of the Exprs will initialize a callable
  // in the constructor. The possible combinations are Normal (Unary, Streaming, Batching) and
  // either Operation or Paged (if needed). It is not possible to have three callable Exprs
  // returned because LROs are not paged, so it will either be an additional LRO or paged callable.
  private List<Expr> createCallableInitExprs(
      GapicContext context,
      Service service,
      Method method,
      TypeStore typeStore,
      VariableExpr callableFactoryVarExpr,
      VariableExpr settingsVarExpr,
      VariableExpr clientContextVarExpr,
      VariableExpr operationsStubClassVarExpr,
      Expr thisExpr,
      Map<String, VariableExpr> javaStyleMethodNameToTransportSettingsVarExprs) {
    List<Expr> callableInitExprs = new ArrayList<>();
    String javaStyleProtoMethodName = JavaStyle.toLowerCamelCase(method.name());

    Expr transportSettingsVarExpr =
        javaStyleMethodNameToTransportSettingsVarExprs.get(javaStyleProtoMethodName);
    Preconditions.checkNotNull(
        transportSettingsVarExpr,
        String.format(
            "No transport settings variable found for method name %s", javaStyleProtoMethodName));

    // Build the normal callable which will be generated for every RPC
    VariableExpr callableVarExpr =
        getCallableExpr(
            method, String.format(CALLABLE_CLASS_MEMBER_PATTERN, javaStyleProtoMethodName));
    List<Expr> creatorMethodArgVarExprs =
        Arrays.asList(
            transportSettingsVarExpr,
            MethodInvocationExpr.builder()
                .setExprReferenceExpr(settingsVarExpr)
                .setMethodName(String.format("%sSettings", javaStyleProtoMethodName))
                .build(),
            clientContextVarExpr);
    AssignmentExpr callableExpr =
        buildCallableTransportExpr(
            context,
            service,
            callableFactoryVarExpr,
            thisExpr,
            javaStyleProtoMethodName,
            callableVarExpr,
            creatorMethodArgVarExprs);
    callableInitExprs.add(callableExpr);

    // Build an additional paged callable if the RPC is paged. The creatorMethodArgVarExprs is the
    // same as the normal callable
    if (method.isPaged()) {
      callableVarExpr =
          getPagedCallableExpr(
              typeStore,
              method,
              String.format(PAGED_CALLABLE_CLASS_MEMBER_PATTERN, javaStyleProtoMethodName));
      callableExpr =
          buildCallableTransportExpr(
              context,
              service,
              callableFactoryVarExpr,
              thisExpr,
              javaStyleProtoMethodName,
              callableVarExpr,
              creatorMethodArgVarExprs);
      callableInitExprs.add(callableExpr);
    }

    // Build an additional operation callable if the RPC is an LRO. Rebuild the
    // creatorMethodArgVarExprs as LROs have a special OperationSettings
    if (method.hasLro()) {
      callableVarExpr =
          getOperationCallableExpr(
              method,
              String.format(OPERATION_CALLABLE_CLASS_MEMBER_PATTERN, javaStyleProtoMethodName));
      creatorMethodArgVarExprs =
          Arrays.asList(
              transportSettingsVarExpr,
              MethodInvocationExpr.builder()
                  .setExprReferenceExpr(settingsVarExpr)
                  .setMethodName(String.format("%sOperationSettings", javaStyleProtoMethodName))
                  .build(),
              clientContextVarExpr,
              operationsStubClassVarExpr);
      callableExpr =
          buildCallableTransportExpr(
              context,
              service,
              callableFactoryVarExpr,
              thisExpr,
              javaStyleProtoMethodName,
              callableVarExpr,
              creatorMethodArgVarExprs);
      callableInitExprs.add(callableExpr);
    }

    return callableInitExprs;
  }

  private AssignmentExpr buildCallableTransportExpr(
      GapicContext context,
      Service service,
      VariableExpr callableFactoryVarExpr,
      Expr thisExpr,
      String methodName,
      VariableExpr callableVarExpr,
      List<Expr> creatorMethodArgVarExprs) {
    Optional<String> callableCreatorMethodName =
        getCallableCreatorMethodName(
            context, service, callableVarExpr.type(), JavaStyle.toUpperCamelCase(methodName));

    Expr initExpr;
    if (callableCreatorMethodName.isPresent()) {
      initExpr =
          MethodInvocationExpr.builder()
              .setExprReferenceExpr(callableFactoryVarExpr)
              .setMethodName(callableCreatorMethodName.get())
              .setArguments(creatorMethodArgVarExprs)
              .setReturnType(callableVarExpr.type())
              .build();
    } else {
      initExpr = ValueExpr.createNullExpr();
    }

    return AssignmentExpr.builder()
        .setVariableExpr(callableVarExpr.toBuilder().setExprReferenceExpr(thisExpr).build())
        .setValueExpr(initExpr)
        .build();
  }

  protected Optional<String> getCallableCreatorMethodName(
      GapicContext context,
      Service service,
      TypeNode callableVarExprType,
      String serviceMethodName) {
    GapicServiceConfig serviceConfig = context.serviceConfig();
    if (serviceConfig != null
        && serviceConfig.hasBatchingSetting(
            service.protoPakkage(), service.name(), serviceMethodName)) {
      return Optional.of("createBatchingCallable");
    }
    // Special handling for pagination methods.
    if (callableVarExprType.reference().generics().size() == 2
        && callableVarExprType.reference().generics().get(1).name().endsWith("PagedResponse")) {
      return Optional.of("createPagedCallable");
    }

    String typeName = callableVarExprType.reference().name();
    if (typeName.startsWith("Client")) {
      return Optional.of("createClientStreamingCallable");
    }
    if (typeName.startsWith("Server")) {
      return Optional.of("createServerStreamingCallable");
    }
    if (typeName.startsWith("Bidi")) {
      return Optional.of("createBidiStreamingCallable");
    }
    if (typeName.startsWith("Operation")) {
      return Optional.of("createOperationCallable");
    }
    return Optional.of("createUnaryCallable");
  }

  private static List<MethodDefinition> createCallableGetterMethods(
      Map<String, VariableExpr> callableClassMemberVarExprs) {
    return callableClassMemberVarExprs.entrySet().stream()
        .map(
            e ->
                MethodDefinition.builder()
                    .setIsOverride(true)
                    .setScope(ScopeNode.PUBLIC)
                    .setReturnType(e.getValue().type())
                    .setName(e.getKey())
                    .setReturnExpr(e.getValue())
                    .build())
        .collect(Collectors.toList());
  }

  private List<MethodDefinition> createStubOverrideMethods(
      VariableExpr backgroundResourcesVarExpr, Service service) {
    Function<String, MethodDefinition.Builder> methodMakerStarterFn =
        methodName ->
            MethodDefinition.builder()
                .setIsOverride(true)
                .setScope(ScopeNode.PUBLIC)
                .setName(methodName);

    Function<String, MethodDefinition> voidMethodMakerFn =
        methodName ->
            methodMakerStarterFn
                .apply(methodName)
                .setReturnType(TypeNode.VOID)
                .setBody(
                    Arrays.asList(
                        ExprStatement.withExpr(
                            MethodInvocationExpr.builder()
                                .setExprReferenceExpr(backgroundResourcesVarExpr)
                                .setMethodName(methodName)
                                .build())))
                .build();

    Function<String, MethodDefinition> booleanMethodMakerFn =
        methodName ->
            methodMakerStarterFn
                .apply(methodName)
                .setReturnType(TypeNode.BOOLEAN)
                .setReturnExpr(
                    MethodInvocationExpr.builder()
                        .setExprReferenceExpr(backgroundResourcesVarExpr)
                        .setMethodName(methodName)
                        .setReturnType(TypeNode.BOOLEAN)
                        .build())
                .build();

    // Generate the close() method:
    //   @Override
    //   public final void close() {
    //     try {
    //       backgroundResources.close();
    //     } catch (RuntimeException e) {
    //       throw e;
    //     } catch (Exception e) {
    //       throw new IllegalStateException("Failed to close resource", e);
    //     }
    //  }

    VariableExpr catchRuntimeExceptionVarExpr =
        VariableExpr.builder()
            .setVariable(
                Variable.builder()
                    .setType(TypeNode.withExceptionClazz(RuntimeException.class))
                    .setName("e")
                    .build())
            .build();
    VariableExpr catchExceptionVarExpr =
        VariableExpr.builder()
            .setVariable(
                Variable.builder()
                    .setType(TypeNode.withExceptionClazz(Exception.class))
                    .setName("e")
                    .build())
            .build();
    List<MethodDefinition> javaMethods = new ArrayList<>();
    if (service.operationPollingMethod() != null) {
      javaMethods.addAll(createLongRunningClientGetters());
    }
    javaMethods.add(
        methodMakerStarterFn
            .apply("close")
            .setIsFinal(true)
            .setReturnType(TypeNode.VOID)
            .setBody(
                Arrays.asList(
                    TryCatchStatement.builder()
                        .setTryBody(
                            Arrays.asList(
                                ExprStatement.withExpr(
                                    MethodInvocationExpr.builder()
                                        .setExprReferenceExpr(backgroundResourcesVarExpr)
                                        .setMethodName("close")
                                        .build())))
                        .addCatch(
                            catchRuntimeExceptionVarExpr.toBuilder().setIsDecl(true).build(),
                            Arrays.asList(
                                ExprStatement.withExpr(
                                    ThrowExpr.builder()
                                        .setThrowExpr(catchRuntimeExceptionVarExpr)
                                        .build())))
                        .addCatch(
                            catchExceptionVarExpr.toBuilder().setIsDecl(true).build(),
                            Arrays.asList(
                                ExprStatement.withExpr(
                                    ThrowExpr.builder()
                                        .setType(
                                            TypeNode.withExceptionClazz(
                                                IllegalStateException.class))
                                        .setMessageExpr("Failed to close resource")
                                        .setCauseExpr(catchExceptionVarExpr)
                                        .build())))
                        .build()))
            .build());
    javaMethods.add(voidMethodMakerFn.apply("shutdown"));
    javaMethods.add(booleanMethodMakerFn.apply("isShutdown"));
    javaMethods.add(booleanMethodMakerFn.apply("isTerminated"));
    javaMethods.add(voidMethodMakerFn.apply("shutdownNow"));

    List<VariableExpr> awaitTerminationArgs =
        Arrays.asList(
            VariableExpr.withVariable(
                Variable.builder().setName("duration").setType(TypeNode.LONG).build()),
            VariableExpr.withVariable(
                Variable.builder()
                    .setName("unit")
                    .setType(FIXED_TYPESTORE.get("TimeUnit"))
                    .build()));
    javaMethods.add(
        methodMakerStarterFn
            .apply("awaitTermination")
            .setReturnType(TypeNode.BOOLEAN)
            .setArguments(
                awaitTerminationArgs.stream()
                    .map(v -> v.toBuilder().setIsDecl(true).build())
                    .collect(Collectors.toList()))
            .setThrowsExceptions(Arrays.asList(FIXED_TYPESTORE.get("InterruptedException")))
            .setReturnExpr(
                MethodInvocationExpr.builder()
                    .setExprReferenceExpr(backgroundResourcesVarExpr)
                    .setMethodName("awaitTermination")
                    .setArguments(
                        awaitTerminationArgs.stream()
                            .map(v -> (Expr) v)
                            .collect(Collectors.toList()))
                    .setReturnType(TypeNode.BOOLEAN)
                    .build())
            .build());
    return javaMethods;
  }

  private boolean checkOperationPollingMethod(Service service) {
    return service.methods().stream()
        .filter(x -> x.isSupportedByTransport(getTransportContext().transport()))
        .anyMatch(Method::isOperationPollingMethod);
  }

  protected List<MethodDefinition> createLongRunningClientGetters() {
    VariableExpr longRunningClient =
        VariableExpr.withVariable(
            Variable.builder()
                .setName("longRunningClient")
                .setType(
                    TypeNode.withReference(ConcreteReference.withClazz(LongRunningClient.class)))
                .build());

    return ImmutableList.of(
        MethodDefinition.builder()
            .setName("longRunningClient")
            .setScope(ScopeNode.PUBLIC)
            .setIsOverride(true)
            .setReturnType(
                TypeNode.withReference(ConcreteReference.withClazz(LongRunningClient.class)))
            .setReturnExpr(longRunningClient)
            .build());
  }

  private TypeStore createDynamicTypes(Service service, String stubPakkage) {
    TypeStore typeStore = new TypeStore();
    typeStore.putAll(
        stubPakkage,
        Arrays.asList(
            getTransportContext().classNames().getTransportServiceStubClassName(service),
            getTransportContext().classNames().getServiceStubSettingsClassName(service),
            getTransportContext().classNames().getServiceStubClassName(service),
            getTransportContext()
                .classNames()
                .getTransportServiceCallableFactoryClassName(service)));
    // Pagination types.
    typeStore.putAll(
        service.pakkage(),
        service.methods().stream()
            .filter(x -> x.isSupportedByTransport(getTransportContext().transport()))
            .filter(Method::isPaged)
            .map(m -> String.format(CommonStrings.PAGED_RESPONSE_TYPE_NAME_PATTERN, m.name()))
            .collect(Collectors.toList()),
        true,
        getTransportContext().classNames().getServiceClientClassName(service));
    return typeStore;
  }

  protected static TypeNode getCallableType(Method protoMethod) {
    TypeNode callableType = FIXED_TYPESTORE.get("UnaryCallable");
    switch (protoMethod.stream()) {
      case CLIENT:
        callableType = FIXED_TYPESTORE.get("ClientStreamingCallable");
        break;
      case SERVER:
        callableType = FIXED_TYPESTORE.get("ServerStreamingCallable");
        break;
      case BIDI:
        callableType = FIXED_TYPESTORE.get("BidiStreamingCallable");
        break;
      case NONE:
      // Fall through
      default:
        // Fall through
    }

    return TypeNode.withReference(
        callableType
            .reference()
            .copyAndSetGenerics(
                Arrays.asList(
                    protoMethod.inputType().reference(), protoMethod.outputType().reference())));
  }

  private CommentStatement createProtectedCtorComment(Service service) {
    return CommentStatement.withComment(
        JavaDocComment.withComment(
            String.format(
                "Constructs an instance of %s, using the given settings. This is protected so that"
                    + " it is easy to make a subclass, but otherwise, the static factory methods"
                    + " should be  preferred.",
                getTransportContext().classNames().getTransportServiceStubClassName(service))));
  }

  protected String getProtoRpcFullMethodName(Service protoService, Method protoMethod) {
    if (protoMethod.isMixin()) {
      return String.format("%s/%s", protoMethod.mixedInApiName(), protoMethod.name());
    }

    return String.format(
        "%s.%s/%s", protoService.protoPakkage(), protoService.name(), protoMethod.name());
  }

  protected TypeNode getTransportOperationsStubType(Service service) {
    TypeNode transportOpeationsStubType = service.operationServiceStubType();
    if (transportOpeationsStubType == null) {
      transportOpeationsStubType = getTransportContext().transportOperationsStubTypes().get(0);
    } else {
      transportOpeationsStubType =
          TypeNode.withReference(
              VaporReference.builder()
                  .setName("HttpJson" + transportOpeationsStubType.reference().simpleName())
                  .setPakkage(transportOpeationsStubType.reference().pakkage())
                  .build());
    }

    return transportOpeationsStubType;
  }

  protected static LambdaExpr createRequestMutatorClassInstance(
      Method method, ImmutableMap<String, Message> messageTypes) {
    List<Statement> bodyStatements = new ArrayList<>();
    VariableExpr requestVarExpr = createRequestVarExpr(method);

    Reference requestBuilderRef =
        VaporReference.builder()
            .setEnclosingClassNames(method.inputType().reference().name())
            .setName("Builder")
            .setPakkage(method.inputType().reference().pakkage())
            .build();

    TypeNode requestBuilderType = TypeNode.withReference(requestBuilderRef);

    VariableExpr requestBuilderVarExpr =
        VariableExpr.builder()
            .setVariable(
                Variable.builder().setName("requestBuilder").setType(requestBuilderType).build())
            .setIsDecl(true)
            .build();

    MethodInvocationExpr setRequestBuilderInvocationExpr =
        MethodInvocationExpr.builder()
            .setExprReferenceExpr(requestVarExpr)
            .setMethodName("toBuilder")
            .setReturnType(requestBuilderType)
            .build();

    Expr requestBuilderExpr =
        AssignmentExpr.builder()
            .setVariableExpr(requestBuilderVarExpr)
            .setValueExpr(setRequestBuilderInvocationExpr)
            .build();

    bodyStatements.add(ExprStatement.withExpr(requestBuilderExpr));

    VariableExpr returnBuilderVarExpr =
        VariableExpr.builder()
            .setVariable(
                Variable.builder().setName("requestBuilder").setType(requestBuilderType).build())
            .setIsDecl(false)
            .build();

    MethodInvocationExpr.Builder returnExpr =
        MethodInvocationExpr.builder()
            .setExprReferenceExpr(returnBuilderVarExpr)
            .setMethodName("build");

    createRequestMutatorBody(method, messageTypes, bodyStatements, returnBuilderVarExpr);

    return LambdaExpr.builder()
        .setArguments(requestVarExpr.toBuilder().setIsDecl(true).build())
        .setBody(bodyStatements)
        .setReturnExpr(returnExpr.build())
        .build();
  }

  @VisibleForTesting
  static List<Statement> createRequestMutatorBody(
      Method method,
      ImmutableMap<String, Message> messageTypes,
      List<Statement> bodyStatements,
      VariableExpr returnBuilderVarExpr) {

    Message methodRequestMessage = messageTypes.get(method.inputType().reference().fullName());
    method.autoPopulatedFields().stream()
        // Map each field name to its corresponding Field object, if present
        .map(
            fieldName ->
                methodRequestMessage.fields().stream()
                    .filter(field -> field.name().equals(fieldName))
                    .findFirst())
        .filter(Optional::isPresent) // Keep only the existing Fields
        .map(Optional::get) // Extract the Field from the Optional
        .filter(Field::canBeAutoPopulated) // Filter fields that can be autopopulated
        .forEach(
            matchedField -> {
              // Create statements for each autopopulated Field
              bodyStatements.add(
                  createAutoPopulatedRequestStatement(
                      method, matchedField.name(), returnBuilderVarExpr));
            });
    return bodyStatements;
  }

  @VisibleForTesting
  static Statement createAutoPopulatedRequestStatement(
      Method method, String fieldName, VariableExpr returnBuilderVarExpr) {

    VariableExpr requestVarExpr = createRequestVarExpr(method);

    // Expected expression: request.getRequestId()
    MethodInvocationExpr getAutoPopulatedFieldInvocationExpr =
        MethodInvocationExpr.builder()
            .setExprReferenceExpr(requestVarExpr)
            .setMethodName(String.format("get%s", JavaStyle.toUpperCamelCase(fieldName)))
            .setReturnType(TypeNode.STRING)
            .build();

    VariableExpr stringsVar =
        VariableExpr.withVariable(
            Variable.builder()
                .setType(TypeNode.withReference(ConcreteReference.withClazz(Strings.class)))
                .setName("Strings")
                .build());

    // Expected expression: Strings.isNullOrEmpty(request.getRequestId())
    MethodInvocationExpr isNullOrEmptyFieldInvocationExpr =
        MethodInvocationExpr.builder()
            .setExprReferenceExpr(stringsVar)
            .setMethodName("isNullOrEmpty")
            .setReturnType(TypeNode.BOOLEAN)
            .setArguments(getAutoPopulatedFieldInvocationExpr)
            .build();

    // Note: Currently, autopopulation is only for UUID.
    VariableExpr uuidVarExpr =
        VariableExpr.withVariable(
            Variable.builder()
                .setType(
                    TypeNode.withReference(
                        ConcreteReference.builder().setClazz(UUID.class).build()))
                .setName("UUID")
                .build());

    // Expected expression: UUID.randomUUID()
    MethodInvocationExpr autoPopulatedFieldsArgsHelper =
        MethodInvocationExpr.builder()
            .setExprReferenceExpr(uuidVarExpr)
            .setMethodName("randomUUID")
            .setReturnType(
                TypeNode.withReference(ConcreteReference.builder().setClazz(UUID.class).build()))
            .build();

    // Expected expression: UUID.randomUUID().toString()
    MethodInvocationExpr autoPopulatedFieldsArgsToString =
        MethodInvocationExpr.builder()
            .setExprReferenceExpr(autoPopulatedFieldsArgsHelper)
            .setMethodName("toString")
            .setReturnType(TypeNode.STRING)
            .build();

    // Expected expression: requestBuilder().setField(UUID.randomUUID().toString())
    MethodInvocationExpr setAutoPopulatedFieldInvocationExpr =
        MethodInvocationExpr.builder()
            .setArguments(autoPopulatedFieldsArgsToString)
            .setExprReferenceExpr(returnBuilderVarExpr)
            .setMethodName(String.format("set%s", JavaStyle.toUpperCamelCase(fieldName)))
            .setReturnType(method.inputType())
            .build();

    return IfStatement.builder()
        .setConditionExpr(isNullOrEmptyFieldInvocationExpr)
        .setBody(Arrays.asList(ExprStatement.withExpr(setAutoPopulatedFieldInvocationExpr)))
        .build();
  }

  /**
   * The Request Mutator should only be generated if the field exists in the Message and is properly
   * configured in the Message(see {@link Field#canBeAutoPopulated()})
   */
  @VisibleForTesting
  static Boolean shouldGenerateRequestMutator(
      Method method, ImmutableMap<String, Message> messageTypes) {
    if (method.inputType().reference() == null
        || method.inputType().reference().fullName() == null) {
      return false;
    }
    String methodRequestName = method.inputType().reference().fullName();

    Message methodRequestMessage = messageTypes.get(methodRequestName);
    if (methodRequestMessage == null || methodRequestMessage.fields() == null) {
      return false;
    }
    return method.autoPopulatedFields().stream().anyMatch(shouldAutoPopulate(methodRequestMessage));
  }

  /**
   * The field has to exist in the Message and properly configured in the Message(see {@link
   * Field#canBeAutoPopulated()})
   */
  private static Predicate<String> shouldAutoPopulate(Message methodRequestMessage) {
    return fieldName ->
        methodRequestMessage.fields().stream()
            .anyMatch(field -> field.name().equals(fieldName) && field.canBeAutoPopulated());
  }

  protected LambdaExpr createRequestParamsExtractorClassInstance(
      Method method, List<Statement> classStatements) {
    List<Statement> bodyStatements = new ArrayList<>();
    VariableExpr requestVarExpr = createRequestVarExpr(method);
    TypeNode returnType =
        TypeNode.withReference(
            ConcreteReference.builder()
                .setClazz(Map.class)
                .setGenerics(TypeNode.STRING.reference(), TypeNode.STRING.reference())
                .build());
    MethodInvocationExpr.Builder returnExpr =
        MethodInvocationExpr.builder().setReturnType(returnType);
    // If the google.api.routing annotation is present(even with empty routing parameters),
    // the implicit routing headers specified in the google.api.http annotation should not be sent
    if (method.routingHeaderRule() == null) {
      createRequestParamsExtractorBodyForHttpBindings(
          method, requestVarExpr, bodyStatements, returnExpr);
    } else {
      createRequestParamsExtractorBodyForRoutingHeaders(
          method, requestVarExpr, classStatements, bodyStatements, returnExpr);
    }

    // Overrides extract().
    // https://github.com/googleapis/gax-java/blob/8d45d186e36ae97b789a6f89d80ae5213a773b65/gax/src/main/java/com/google/api/gax/rpc/RequestParamsExtractor.java#L55
    return LambdaExpr.builder()
        .setArguments(requestVarExpr.toBuilder().setIsDecl(true).build())
        .setBody(bodyStatements)
        .setReturnExpr(returnExpr.build())
        .build();
  }

  private void createRequestParamsExtractorBodyForHttpBindings(
      Method method,
      VariableExpr requestVarExpr,
      List<Statement> bodyStatements,
      MethodInvocationExpr.Builder returnExprBuilder) {
    TypeNode routingHeadersBuilderType =
        TypeNode.withReference(
            ConcreteReference.builder().setClazz(RequestParamsBuilder.class).build());
    VariableExpr routingHeadersBuilderVarExpr =
        VariableExpr.builder()
            .setVariable(
                Variable.builder().setName("builder").setType(routingHeadersBuilderType).build())
            .setIsDecl(true)
            .build();
    MethodInvocationExpr routingHeaderBuilderInvokeExpr =
        MethodInvocationExpr.builder()
            .setStaticReferenceType(routingHeadersBuilderType)
            .setMethodName("create")
            .setReturnType(routingHeadersBuilderType)
            .build();
    Expr routingHeadersBuilderInitExpr =
        AssignmentExpr.builder()
            .setVariableExpr(routingHeadersBuilderVarExpr)
            .setValueExpr(routingHeaderBuilderInvokeExpr)
            .build();
    bodyStatements.add(ExprStatement.withExpr(routingHeadersBuilderInitExpr));
    VariableExpr routingHeadersBuilderVarNonDeclExpr =
        VariableExpr.builder()
            .setVariable(
                Variable.builder().setName("builder").setType(routingHeadersBuilderType).build())
            .build();
    for (HttpBindings.HttpBinding httpBindingFieldBinding :
        method.httpBindings().pathParameters()) {
      MethodInvocationExpr requestBuilderExpr =
          createRequestFieldGetterExpr(
              requestVarExpr,
              httpBindingFieldBinding.name(),
              httpBindingFieldBinding.field() != null && httpBindingFieldBinding.field().isEnum());
      Expr valueOfExpr =
          MethodInvocationExpr.builder()
              .setStaticReferenceType(TypeNode.STRING)
              .setMethodName("valueOf")
              .setArguments(requestBuilderExpr)
              .build();

      Expr paramsAddExpr =
          MethodInvocationExpr.builder()
              .setExprReferenceExpr(routingHeadersBuilderVarNonDeclExpr)
              .setMethodName("add")
              .setArguments(
                  ValueExpr.withValue(StringObjectValue.withValue(httpBindingFieldBinding.name())),
                  valueOfExpr)
              .build();
      bodyStatements.add(ExprStatement.withExpr(paramsAddExpr));
    }

    returnExprBuilder
        .setExprReferenceExpr(routingHeadersBuilderVarNonDeclExpr)
        .setMethodName("build");
  }

  private void createRequestParamsExtractorBodyForRoutingHeaders(
      Method method,
      VariableExpr requestVarExpr,
      List<Statement> classStatements,
      List<Statement> bodyStatements,
      MethodInvocationExpr.Builder returnExprBuilder) {
    TypeNode routingHeadersBuilderType =
        TypeNode.withReference(
            ConcreteReference.builder().setClazz(RequestParamsBuilder.class).build());
    VariableExpr routingHeadersBuilderVarExpr =
        VariableExpr.builder()
            .setVariable(
                Variable.builder().setName("builder").setType(routingHeadersBuilderType).build())
            .setIsDecl(true)
            .build();
    MethodInvocationExpr routingHeaderBuilderInvokeExpr =
        MethodInvocationExpr.builder()
            .setStaticReferenceType(routingHeadersBuilderType)
            .setMethodName("create")
            .setReturnType(routingHeadersBuilderType)
            .build();
    Expr routingHeadersBuilderInitExpr =
        AssignmentExpr.builder()
            .setVariableExpr(routingHeadersBuilderVarExpr)
            .setValueExpr(routingHeaderBuilderInvokeExpr)
            .build();
    bodyStatements.add(ExprStatement.withExpr(routingHeadersBuilderInitExpr));
    List<RoutingHeaderRule.RoutingHeaderParam> routingHeaderParams =
        method.routingHeaderRule().routingHeaderParams();
    VariableExpr routingHeadersBuilderVarNonDeclExpr =
        VariableExpr.builder()
            .setVariable(
                Variable.builder().setName("builder").setType(routingHeadersBuilderType).build())
            .build();
    for (int i = 0; i < routingHeaderParams.size(); i++) {
      RoutingHeaderRule.RoutingHeaderParam routingHeaderParam = routingHeaderParams.get(i);
      // Explicit routing headers are implemented as strings currently, hence sending "false"
      // in isFieldEnum() for it.
      MethodInvocationExpr requestFieldGetterExpr =
          createRequestFieldGetterExpr(requestVarExpr, routingHeaderParam.fieldName(), false);
      Expr routingHeaderKeyExpr =
          ValueExpr.withValue(StringObjectValue.withValue(routingHeaderParam.key()));
      String pathTemplateName =
          String.format("%s_%s_PATH_TEMPLATE", JavaStyle.toUpperSnakeCase(method.name()), i);
      TypeNode pathTemplateType =
          TypeNode.withReference(ConcreteReference.withClazz(PathTemplate.class));
      Variable pathTemplateVar =
          Variable.builder().setType(pathTemplateType).setName(pathTemplateName).build();
      Expr routingHeaderPatternExpr = VariableExpr.withVariable(pathTemplateVar);
      Statement pathTemplateClassVar =
          createPathTemplateClassStatement(routingHeaderParam, pathTemplateType, pathTemplateVar);
      classStatements.add(pathTemplateClassVar);
      MethodInvocationExpr addParamMethodExpr =
          MethodInvocationExpr.builder()
              .setExprReferenceExpr(routingHeadersBuilderVarNonDeclExpr)
              .setMethodName("add")
              .setArguments(requestFieldGetterExpr, routingHeaderKeyExpr, routingHeaderPatternExpr)
              .build();

      ExprStatement addParamStatement = ExprStatement.withExpr(addParamMethodExpr);
      // No need to add null check if there is no nested fields
      if (routingHeaderParam.getDescendantFieldNames().size() == 1) {
        bodyStatements.add(addParamStatement);
      } else {
        IfStatement ifStatement =
            IfStatement.builder()
                .setConditionExpr(
                    fieldValuesNotNullConditionExpr(
                        requestVarExpr, routingHeaderParam.getDescendantFieldNames()))
                .setBody(ImmutableList.of(addParamStatement))
                .build();
        bodyStatements.add(ifStatement);
      }
    }
    returnExprBuilder
        .setExprReferenceExpr(routingHeadersBuilderVarNonDeclExpr)
        .setMethodName("build");
  }

  private Statement createPathTemplateClassStatement(
      RoutingHeaderRule.RoutingHeaderParam routingHeaderParam,
      TypeNode pathTemplateType,
      Variable pathTemplateVar) {
    VariableExpr pathTemplateVarExpr =
        VariableExpr.builder()
            .setVariable(pathTemplateVar)
            .setIsDecl(true)
            .setIsStatic(true)
            .setIsFinal(true)
            .setScope(ScopeNode.PRIVATE)
            .build();
    ValueExpr valueExpr =
        ValueExpr.withValue(StringObjectValue.withValue(routingHeaderParam.pattern()));
    Expr pathTemplateExpr =
        AssignmentExpr.builder()
            .setVariableExpr(pathTemplateVarExpr)
            .setValueExpr(
                MethodInvocationExpr.builder()
                    .setStaticReferenceType(pathTemplateType)
                    .setMethodName("create")
                    .setArguments(valueExpr)
                    .setReturnType(pathTemplateType)
                    .build())
            .build();
    return ExprStatement.withExpr(pathTemplateExpr);
  }

  private Expr fieldValuesNotNullConditionExpr(
      VariableExpr requestVarExpr, List<String> fieldNames) {
    MethodInvocationExpr.Builder requestFieldGetterExprBuilder =
        MethodInvocationExpr.builder().setExprReferenceExpr(requestVarExpr);
    Expr fieldValuesNotNullExpr = null;
    for (int i = 0; i < fieldNames.size() - 1; i++) {
      String currFieldName = fieldNames.get(i);
      String bindingFieldMethodName =
          String.format("get%s", JavaStyle.toUpperCamelCase(currFieldName));
      requestFieldGetterExprBuilder =
          requestFieldGetterExprBuilder.setMethodName(bindingFieldMethodName);
      // set return type of each method invocation to String just to pass the validation for
      // RelationalOperationExpr that both side of relational operation needs to be a valid equality
      // type
      MethodInvocationExpr requestGetterExpr =
          requestFieldGetterExprBuilder.setReturnType(TypeNode.STRING).build();
      Expr currentValueNotNullExpr =
          RelationalOperationExpr.notEqualToWithExprs(
              requestGetterExpr, ValueExpr.createNullExpr());
      if (fieldValuesNotNullExpr == null) {
        fieldValuesNotNullExpr = currentValueNotNullExpr;
      } else {
        fieldValuesNotNullExpr =
            LogicalOperationExpr.logicalAndWithExprs(
                fieldValuesNotNullExpr, currentValueNotNullExpr);
      }
      requestFieldGetterExprBuilder =
          MethodInvocationExpr.builder().setExprReferenceExpr(requestGetterExpr);
    }
    return fieldValuesNotNullExpr;
  }

  private MethodInvocationExpr createRequestFieldGetterExpr(
      VariableExpr requestVarExpr, String fieldName, boolean isFieldEnum) {
    MethodInvocationExpr.Builder requestFieldGetterExprBuilder =
        MethodInvocationExpr.builder().setExprReferenceExpr(requestVarExpr);
    List<String> descendantFields = Splitter.on(".").splitToList(fieldName);
    // Handle foo.bar cases by descending into the subfields.
    // e.g. foo.bar -> request.getFoo().getBar()
    for (int i = 0; i < descendantFields.size(); i++) {
      String currFieldName = descendantFields.get(i);
      String bindingFieldMethodName =
          String.format("get%s", JavaStyle.toUpperCamelCase(currFieldName));

      // Only at the last descendant field, if enum, we want to extract the value.
      // For example, consider the chain request.getFoo().getBar().
      // If you added "Value" to both fields (getFooValue().getBarValue()),
      // it would not work correctly, as getFooValue() may return an int or some other type,
      // and calling getBarValue() on it wouldn't make sense
      // By adding "Value" only at the last descendant field,
      // you ensure that the modification aligns with the expected method
      // chaining behavior and correctly retrieves the underlying value of the enum field."
      if (i == descendantFields.size() - 1 && isFieldEnum) {
        bindingFieldMethodName = bindingFieldMethodName + "Value";
      }
      requestFieldGetterExprBuilder =
          requestFieldGetterExprBuilder.setMethodName(bindingFieldMethodName);
      if (i < descendantFields.size() - 1) {
        requestFieldGetterExprBuilder =
            MethodInvocationExpr.builder()
                .setExprReferenceExpr(requestFieldGetterExprBuilder.build());
      }
    }
    return requestFieldGetterExprBuilder.build();
  }

  private static VariableExpr createRequestVarExpr(Method method) {
    return VariableExpr.withVariable(
        Variable.builder().setType(method.inputType()).setName("request").build());
  }
}
