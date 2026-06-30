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

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.BetaApi;
import com.google.api.core.InternalApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.longrunning.OperationFuture;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.BidiStreamingCallable;
import com.google.api.gax.rpc.ClientStreamingCallable;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.ServerStreamingCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.api.generator.engine.ast.AnnotationNode;
import com.google.api.generator.engine.ast.AssignmentExpr;
import com.google.api.generator.engine.ast.CastExpr;
import com.google.api.generator.engine.ast.ClassDefinition;
import com.google.api.generator.engine.ast.CommentStatement;
import com.google.api.generator.engine.ast.ConcreteReference;
import com.google.api.generator.engine.ast.Expr;
import com.google.api.generator.engine.ast.ExprStatement;
import com.google.api.generator.engine.ast.LambdaExpr;
import com.google.api.generator.engine.ast.MethodDefinition;
import com.google.api.generator.engine.ast.MethodInvocationExpr;
import com.google.api.generator.engine.ast.NewObjectExpr;
import com.google.api.generator.engine.ast.PrimitiveValue;
import com.google.api.generator.engine.ast.Reference;
import com.google.api.generator.engine.ast.ReferenceConstructorExpr;
import com.google.api.generator.engine.ast.RelationalOperationExpr;
import com.google.api.generator.engine.ast.ScopeNode;
import com.google.api.generator.engine.ast.Statement;
import com.google.api.generator.engine.ast.SuperObjectValue;
import com.google.api.generator.engine.ast.TernaryExpr;
import com.google.api.generator.engine.ast.ThisObjectValue;
import com.google.api.generator.engine.ast.TypeNode;
import com.google.api.generator.engine.ast.ValueExpr;
import com.google.api.generator.engine.ast.Variable;
import com.google.api.generator.engine.ast.VariableExpr;
import com.google.api.generator.gapic.composer.comment.ServiceClientCommentComposer;
import com.google.api.generator.gapic.composer.samplecode.SampleCodeWriter;
import com.google.api.generator.gapic.composer.samplecode.SampleComposerUtil;
import com.google.api.generator.gapic.composer.samplecode.ServiceClientCallableMethodSampleComposer;
import com.google.api.generator.gapic.composer.samplecode.ServiceClientHeaderSampleComposer;
import com.google.api.generator.gapic.composer.samplecode.ServiceClientMethodSampleComposer;
import com.google.api.generator.gapic.composer.store.TypeStore;
import com.google.api.generator.gapic.composer.utils.ClassNames;
import com.google.api.generator.gapic.composer.utils.CommonStrings;
import com.google.api.generator.gapic.composer.utils.PackageChecker;
import com.google.api.generator.gapic.model.Field;
import com.google.api.generator.gapic.model.GapicClass;
import com.google.api.generator.gapic.model.GapicClass.Kind;
import com.google.api.generator.gapic.model.GapicContext;
import com.google.api.generator.gapic.model.LongrunningOperation;
import com.google.api.generator.gapic.model.Message;
import com.google.api.generator.gapic.model.Method;
import com.google.api.generator.gapic.model.Method.Stream;
import com.google.api.generator.gapic.model.MethodArgument;
import com.google.api.generator.gapic.model.ResourceName;
import com.google.api.generator.gapic.model.Sample;
import com.google.api.generator.gapic.model.Service;
import com.google.api.generator.gapic.utils.JavaStyle;
import com.google.api.generator.util.TriFunction;
import com.google.api.generator.util.Trie;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.gapic.metadata.GapicMetadata;
import com.google.longrunning.Operation;
import com.google.rpc.Status;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.annotation.Generated;

public abstract class AbstractServiceClientClassComposer implements ClassComposer {
  private static final String CALLABLE_NAME_PATTERN = "%sCallable";
  private static final String PAGED_CALLABLE_NAME_PATTERN = "%sPagedCallable";
  private static final String OPERATION_CALLABLE_NAME_PATTERN = "%sOperationCallable";

  private static final Reference LIST_REFERENCE = ConcreteReference.withClazz(List.class);
  private static final Reference MAP_REFERENCE = ConcreteReference.withClazz(Map.class);

  private enum CallableMethodKind {
    REGULAR,
    LRO,
    PAGED,
  }

  private final TransportContext transportContext;

  protected AbstractServiceClientClassComposer(TransportContext transportContext) {
    this.transportContext = transportContext;
  }

  protected TransportContext getTransportContext() {
    return transportContext;
  }

  private static List<AnnotationNode> createMethodAnnotations(Method method, TypeStore typeStore) {
    List<AnnotationNode> annotations = new ArrayList<>();
    if (method.isDeprecated()) {
      annotations.add(AnnotationNode.withType(TypeNode.DEPRECATED));
    }

    if (method.isInternalApi()) {
      annotations.add(
          AnnotationNode.withTypeAndDescription(
              typeStore.get("InternalApi"), CommonStrings.INTERNAL_API_WARNING));
    }

    return annotations;
  }

  @Override
  public GapicClass generate(GapicContext context, Service service) {
    Map<String, ResourceName> resourceNames = context.helperResourceNames();
    Map<String, Message> messageTypes = context.messages();
    TypeStore typeStore = createTypes(service, messageTypes);
    String className = ClassNames.getServiceClientClassName(service);
    GapicClass.Kind kind = Kind.MAIN;
    String pakkage = service.pakkage();
    boolean hasLroClient = service.hasStandardLroMethods();
    List<Sample> samples = new ArrayList<>();
    Map<String, List<String>> grpcRpcsToJavaMethodNames = new HashMap<>();
    Map<String, List<String>> methodVariantsForClientHeader = new HashMap<>();

    ClassDefinition classDef =
        ClassDefinition.builder()
            .setPackageString(pakkage)
            .setAnnotations(createClassAnnotations(service, typeStore))
            .setScope(ScopeNode.PUBLIC)
            .setName(className)
            .setImplementsTypes(createClassImplements(typeStore))
            .setStatements(createFieldDeclarations(service, typeStore, hasLroClient))
            .setMethods(
                createClassMethods(
                    service,
                    messageTypes,
                    typeStore,
                    resourceNames,
                    hasLroClient,
                    grpcRpcsToJavaMethodNames,
                    methodVariantsForClientHeader,
                    samples))
            .setNestedClasses(createNestedPagingClasses(service, messageTypes, typeStore))
            .setHeaderCommentStatements(
                createClassHeaderComments(
                    methodVariantsForClientHeader,
                    service,
                    typeStore,
                    resourceNames,
                    messageTypes,
                    samples))
            .build();

    updateGapicMetadata(context, service, className, grpcRpcsToJavaMethodNames);
    return GapicClass.create(kind, classDef, SampleComposerUtil.handleDuplicateSamples(samples))
        .withApiShortName(service.apiShortName())
        .withPackageVersion(service.packageVersion());
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

  protected List<CommentStatement> createClassHeaderComments(
      Map<String, List<String>> methodVariantsForClientHeader,
      Service service,
      TypeStore typeStore,
      Map<String, ResourceName> resourceNames,
      Map<String, Message> messageTypes,
      List<Sample> samples) {
    TypeNode clientType = typeStore.get(ClassNames.getServiceClientClassName(service));
    TypeNode settingsType = typeStore.get(ClassNames.getServiceSettingsClassName(service));
    Sample classMethodSampleCode =
        ServiceClientHeaderSampleComposer.composeClassHeaderSample(
            service, clientType, resourceNames, messageTypes);
    Sample credentialsSampleCode =
        ServiceClientHeaderSampleComposer.composeSetCredentialsSample(
            clientType, settingsType, service);
    Sample endpointSampleCode =
        ServiceClientHeaderSampleComposer.composeSetEndpointSample(
            clientType, settingsType, service);
    samples.addAll(Arrays.asList(classMethodSampleCode, credentialsSampleCode, endpointSampleCode));
    return ServiceClientCommentComposer.createClassHeaderComments(
        methodVariantsForClientHeader,
        service,
        SampleCodeWriter.writeInlineSample(classMethodSampleCode.body()),
        SampleCodeWriter.writeInlineSample(credentialsSampleCode.body()),
        SampleCodeWriter.writeInlineSample(endpointSampleCode.body()),
        null,
        null,
        null);
  }

  private List<MethodDefinition> createClassMethods(
      Service service,
      Map<String, Message> messageTypes,
      TypeStore typeStore,
      Map<String, ResourceName> resourceNames,
      boolean hasLroClient,
      Map<String, List<String>> grpcRpcToJavaMethodMetadata,
      Map<String, List<String>> methodVariantsForClientHeader,
      List<Sample> samples) {
    List<MethodDefinition> methods = new ArrayList<>();
    methods.addAll(createStaticCreatorMethods(service, typeStore));
    methods.addAll(createConstructorMethods(service, typeStore, hasLroClient));
    methods.addAll(createGetterMethods(service, typeStore, hasLroClient));
    methods.addAll(
        createServiceMethods(
            service,
            messageTypes,
            typeStore,
            resourceNames,
            grpcRpcToJavaMethodMetadata,
            methodVariantsForClientHeader,
            samples));
    methods.addAll(createBackgroundResourceMethods(service, typeStore));
    return methods;
  }

  private List<Statement> createFieldDeclarations(
      Service service, TypeStore typeStore, boolean hasLroClient) {
    Map<String, TypeNode> fieldNameToTypes = new HashMap<>();
    fieldNameToTypes.put(
        "settings", typeStore.get(ClassNames.getServiceSettingsClassName(service)));
    fieldNameToTypes.put("stub", typeStore.get(ClassNames.getServiceStubClassName(service)));
    if (hasLroClient) {
      Iterator<String> opClientName = getTransportContext().operationsClientNames().iterator();
      Iterator<TypeNode> opClientType = getTransportContext().operationsClientTypes().iterator();

      while (opClientName.hasNext() && opClientType.hasNext()) {
        fieldNameToTypes.put(opClientName.next(), opClientType.next());
      }
    }

    return fieldNameToTypes.entrySet().stream()
        .map(
            e -> {
              String varName = e.getKey();
              TypeNode varType = e.getValue();
              Variable variable = Variable.builder().setName(varName).setType(varType).build();
              VariableExpr varExpr =
                  VariableExpr.builder()
                      .setVariable(variable)
                      .setScope(ScopeNode.PRIVATE)
                      .setIsFinal(true)
                      .setIsDecl(true)
                      .build();
              return ExprStatement.withExpr(varExpr);
            })
        .collect(Collectors.toList());
  }

  private static List<MethodDefinition> createStaticCreatorMethods(
      Service service, TypeStore typeStore) {
    List<MethodDefinition> methods = new ArrayList<>();
    String thisClientName = ClassNames.getServiceClientClassName(service);
    String settingsName = ClassNames.getServiceSettingsClassName(service);
    TypeNode thisClassType = typeStore.get(thisClientName);
    TypeNode exceptionType = typeStore.get("IOException");

    TypeNode settingsType = typeStore.get(settingsName);
    Preconditions.checkNotNull(settingsType, String.format("Type %s not found", settingsName));

    MethodInvocationExpr newBuilderExpr =
        MethodInvocationExpr.builder()
            .setMethodName("newBuilder")
            .setStaticReferenceType(settingsType)
            .build();
    MethodInvocationExpr buildExpr =
        MethodInvocationExpr.builder()
            .setMethodName("build")
            .setExprReferenceExpr(newBuilderExpr)
            .build();
    MethodInvocationExpr createMethodInvocationExpr =
        MethodInvocationExpr.builder()
            .setMethodName("create")
            .setArguments(Arrays.asList(buildExpr))
            .setReturnType(typeStore.get(thisClientName))
            .build();

    MethodDefinition createMethodOne =
        MethodDefinition.builder()
            .setHeaderCommentStatements(
                ServiceClientCommentComposer.createMethodNoArgComment(
                    ClassNames.getServiceClientClassName(service)))
            .setScope(ScopeNode.PUBLIC)
            .setIsStatic(true)
            .setIsFinal(true)
            .setReturnType(thisClassType)
            .setName("create")
            .setThrowsExceptions(Arrays.asList(exceptionType))
            .setReturnExpr(createMethodInvocationExpr)
            .build();
    methods.add(createMethodOne);

    // Second create(ServiceSettings settings) method.
    VariableExpr settingsVarExpr =
        VariableExpr.withVariable(
            Variable.builder().setName("settings").setType(typeStore.get(settingsName)).build());

    methods.add(
        MethodDefinition.builder()
            .setHeaderCommentStatements(
                ServiceClientCommentComposer.createMethodSettingsArgComment(
                    ClassNames.getServiceClientClassName(service)))
            .setScope(ScopeNode.PUBLIC)
            .setIsStatic(true)
            .setIsFinal(true)
            .setReturnType(thisClassType)
            .setName("create")
            .setThrowsExceptions(Arrays.asList(exceptionType))
            .setArguments(settingsVarExpr.toBuilder().setIsDecl(true).build())
            .setReturnExpr(
                NewObjectExpr.builder()
                    .setType(thisClassType)
                    .setArguments(settingsVarExpr)
                    .build())
            .build());

    // Third create(ServiceStub stub) method.
    VariableExpr stubVarExpr =
        VariableExpr.withVariable(
            Variable.builder()
                .setType(typeStore.get(ClassNames.getServiceStubClassName(service)))
                .setName("stub")
                .build());
    methods.add(
        MethodDefinition.builder()
            .setHeaderCommentStatements(
                ServiceClientCommentComposer.createCreateMethodStubArgComment(
                    ClassNames.getServiceClientClassName(service), settingsVarExpr.type()))
            .setScope(ScopeNode.PUBLIC)
            .setIsStatic(true)
            .setIsFinal(true)
            .setReturnType(thisClassType)
            .setName("create")
            .setArguments(stubVarExpr.toBuilder().setIsDecl(true).build())
            .setReturnExpr(
                NewObjectExpr.builder().setType(thisClassType).setArguments(stubVarExpr).build())
            .build());

    return methods;
  }

  private List<MethodDefinition> createConstructorMethods(
      Service service, TypeStore typeStore, boolean hasLroClient) {
    List<MethodDefinition> methods = new ArrayList<>();
    String thisClientName = ClassNames.getServiceClientClassName(service);
    String settingsName = ClassNames.getServiceSettingsClassName(service);
    TypeNode thisClassType = typeStore.get(thisClientName);
    TypeNode stubSettingsType = typeStore.get(ClassNames.getServiceStubSettingsClassName(service));
    TypeNode exceptionType = typeStore.get("IOException");

    VariableExpr settingsVarExpr =
        VariableExpr.withVariable(
            Variable.builder().setName("settings").setType(typeStore.get(settingsName)).build());
    VariableExpr stubVarExpr =
        VariableExpr.withVariable(
            Variable.builder()
                .setType(typeStore.get(ClassNames.getServiceStubClassName(service)))
                .setName("stub")
                .build());

    // Create the ServiceClient(ServiceSettings settings) ctor.
    List<Expr> ctorAssignmentExprs = new ArrayList<>();
    Expr thisExpr = ValueExpr.withValue(ThisObjectValue.withType(thisClassType));
    ctorAssignmentExprs.add(
        AssignmentExpr.builder()
            .setVariableExpr(settingsVarExpr.toBuilder().setExprReferenceExpr(thisExpr).build())
            .setValueExpr(settingsVarExpr)
            .build());
    ctorAssignmentExprs.add(
        AssignmentExpr.builder()
            .setVariableExpr(stubVarExpr.toBuilder().setExprReferenceExpr(thisExpr).build())
            .setValueExpr(
                MethodInvocationExpr.builder()
                    .setExprReferenceExpr(
                        CastExpr.builder()
                            .setType(stubSettingsType)
                            .setExpr(
                                MethodInvocationExpr.builder()
                                    .setExprReferenceExpr(settingsVarExpr)
                                    .setMethodName("getStubSettings")
                                    .setReturnType(stubSettingsType)
                                    .build())
                            .build())
                    .setMethodName("createStub")
                    .setReturnType(stubVarExpr.type())
                    .build())
            .build());

    List<AssignmentExpr> operationsClientAssignExprs =
        createOperationsClientAssignExprs(thisExpr, stubVarExpr);
    if (hasLroClient) {
      ctorAssignmentExprs.addAll(operationsClientAssignExprs);
    }

    methods.add(
        MethodDefinition.constructorBuilder()
            .setHeaderCommentStatements(
                ServiceClientCommentComposer.createProtectedCtorSettingsArgComment(
                    ClassNames.getServiceClientClassName(service)))
            .setScope(ScopeNode.PROTECTED)
            .setReturnType(thisClassType)
            .setArguments(settingsVarExpr.toBuilder().setIsDecl(true).build())
            .setThrowsExceptions(Arrays.asList(exceptionType))
            .setBody(
                ctorAssignmentExprs.stream()
                    .map(e -> ExprStatement.withExpr(e))
                    .collect(Collectors.toList()))
            .build());

    // Create the ServiceClient(ServiceStub stub) ctor.
    ctorAssignmentExprs.clear();
    ctorAssignmentExprs.add(
        AssignmentExpr.builder()
            .setVariableExpr(settingsVarExpr.toBuilder().setExprReferenceExpr(thisExpr).build())
            .setValueExpr(ValueExpr.createNullExpr())
            .build());
    ctorAssignmentExprs.add(
        AssignmentExpr.builder()
            .setVariableExpr(stubVarExpr.toBuilder().setExprReferenceExpr(thisExpr).build())
            .setValueExpr(stubVarExpr)
            .build());
    if (hasLroClient) {
      ctorAssignmentExprs.addAll(operationsClientAssignExprs);
    }
    methods.add(
        MethodDefinition.constructorBuilder()
            .setScope(ScopeNode.PROTECTED)
            .setReturnType(thisClassType)
            .setArguments(stubVarExpr.toBuilder().setIsDecl(true).build())
            .setBody(
                ctorAssignmentExprs.stream()
                    .map(e -> ExprStatement.withExpr(e))
                    .collect(Collectors.toList()))
            .build());

    return methods;
  }

  private List<AssignmentExpr> createOperationsClientAssignExprs(
      Expr thisExpr, VariableExpr stubVarExpr) {
    List<AssignmentExpr> operationsClientAssignExprs = new ArrayList<>();

    Iterator<TypeNode> opClientTypesIt = getTransportContext().operationsClientTypes().iterator();
    Iterator<String> opClientNamesIt = getTransportContext().operationsClientNames().iterator();
    Iterator<String> opStubNamesIt =
        getTransportContext().transportOperationsStubNames().iterator();

    while (opClientTypesIt.hasNext() && opClientNamesIt.hasNext() && opStubNamesIt.hasNext()) {
      TypeNode operationsClientType = opClientTypesIt.next();
      String opClientName = opClientNamesIt.next();
      String opStubName = opStubNamesIt.next();

      VariableExpr operationsClientVarExpr =
          VariableExpr.withVariable(
              Variable.builder().setType(operationsClientType).setName(opClientName).build());

      String operationsStubGetterName =
          String.format("get%s", JavaStyle.toUpperCamelCase(opStubName));

      Expr clientArgExpr =
          MethodInvocationExpr.builder()
              .setExprReferenceExpr(stubVarExpr.toBuilder().setExprReferenceExpr(thisExpr).build())
              .setMethodName(operationsStubGetterName)
              .build();

      AssignmentExpr operationsClientAssignExpr =
          AssignmentExpr.builder()
              .setVariableExpr(
                  operationsClientVarExpr.toBuilder().setExprReferenceExpr(thisExpr).build())
              .setValueExpr(
                  MethodInvocationExpr.builder()
                      .setStaticReferenceType(operationsClientType)
                      .setMethodName("create")
                      .setArguments(clientArgExpr)
                      .setReturnType(operationsClientVarExpr.type())
                      .build())
              .build();
      operationsClientAssignExprs.add(operationsClientAssignExpr);
    }

    return operationsClientAssignExprs;
  }

  private List<MethodDefinition> createGetterMethods(
      Service service, TypeStore typeStore, boolean hasLroClient) {
    Map<String, TypeNode> methodNameToTypes = new LinkedHashMap<>();
    methodNameToTypes.put(
        "getSettings", typeStore.get(ClassNames.getServiceSettingsClassName(service)));
    methodNameToTypes.put("getStub", typeStore.get(ClassNames.getServiceStubClassName(service)));

    Map<String, List<AnnotationNode>> getOperationsClientMethod = new HashMap<>();
    AnnotationNode betaAnnotation =
        AnnotationNode.builder().setType(typeStore.get("BetaApi")).build();

    if (hasLroClient) {
      Iterator<String> opClientNamesIt = getTransportContext().operationsClientNames().iterator();
      Iterator<TypeNode> opClientTypesIt = getTransportContext().operationsClientTypes().iterator();
      List<AnnotationNode> operationClientGetterAnnotations = new ArrayList<>();
      while (opClientNamesIt.hasNext() && opClientTypesIt.hasNext()) {
        String opClientMethodName =
            String.format("get%s", JavaStyle.toUpperCamelCase(opClientNamesIt.next()));
        getOperationsClientMethod.put(opClientMethodName, operationClientGetterAnnotations);
        methodNameToTypes.put(opClientMethodName, opClientTypesIt.next());
        // Only first (default transport) getter is non-beta, all others are
        if (operationClientGetterAnnotations.isEmpty()) {
          operationClientGetterAnnotations = Collections.singletonList(betaAnnotation);
        }
      }
    }

    return methodNameToTypes.entrySet().stream()
        .map(
            e -> {
              String methodName = e.getKey();
              TypeNode methodReturnType = e.getValue();
              String returnVariableName = JavaStyle.toLowerCamelCase(methodName.substring(3));
              MethodDefinition.Builder methodBuilder = MethodDefinition.builder();
              List<AnnotationNode> annotations = getOperationsClientMethod.get(methodName);
              if (annotations != null) {
                methodBuilder =
                    methodBuilder.setHeaderCommentStatements(
                        ServiceClientCommentComposer.GET_OPERATIONS_CLIENT_METHOD_COMMENT);
                methodBuilder.setAnnotations(annotations);
              }
              return methodBuilder
                  .setScope(ScopeNode.PUBLIC)
                  .setName(methodName)
                  .setIsFinal(!methodName.equals("getStub"))
                  .setReturnType(methodReturnType)
                  .setReturnExpr(
                      VariableExpr.builder()
                          .setVariable(
                              Variable.builder()
                                  .setName(returnVariableName)
                                  .setType(methodReturnType)
                                  .build())
                          .build())
                  .build();
            })
        .collect(Collectors.toList());
  }

  private static String getJavaMethod(MethodDefinition m) {
    StringBuilder methodSignature = new StringBuilder();

    // Method name
    methodSignature.append(m.methodIdentifier().name()).append("(");

    // Iterate through and add all parameters
    List<Variable> parameters =
        m.arguments().stream().map(VariableExpr::variable).collect(Collectors.toList());

    // If reference is empty, that means the parameter is a non-Object type. Therefore, use the
    // typeKind directly.
    for (int i = 0; i < parameters.size(); i++) {
      Variable param = parameters.get(i);
      String paramType =
          param.type().reference() != null
              ? param.type().reference().name() + " "
              : param.type().typeKind().name().toLowerCase() + " ";
      String paramName = param.identifier().name();

      methodSignature.append(paramType).append(paramName);

      // Add a comma if there are more parameters
      if (i < parameters.size() - 1) {
        methodSignature.append(", ");
      }
    }

    methodSignature.append(")");

    return methodSignature.toString();
  }

  private static List<MethodDefinition> createServiceMethods(
      Service service,
      Map<String, Message> messageTypes,
      TypeStore typeStore,
      Map<String, ResourceName> resourceNames,
      Map<String, List<String>> grpcRpcToJavaMethodMetadata,
      Map<String, List<String>> methodVariantsForClientHeader,
      List<Sample> samples) {
    List<MethodDefinition> javaMethods = new ArrayList<>();
    Function<MethodDefinition, String> javaMethodNameFn = m -> m.methodIdentifier().name();
    for (Method method : service.methods()) {
      if (!grpcRpcToJavaMethodMetadata.containsKey(method.name())) {
        grpcRpcToJavaMethodMetadata.put(method.name(), new ArrayList<>());
        methodVariantsForClientHeader.put(method.name(), new ArrayList<>());
      }
      if (method.stream().equals(Stream.NONE)) {
        List<MethodDefinition> generatedMethods =
            createMethodVariants(
                method,
                ClassNames.getServiceClientClassName(service),
                messageTypes,
                typeStore,
                resourceNames,
                samples,
                service);

        // Collect data for gapic_metadata.json.
        grpcRpcToJavaMethodMetadata
            .get(method.name())
            .addAll(
                generatedMethods.stream()
                    .map(m -> javaMethodNameFn.apply(m))
                    .collect(Collectors.toList()));

        // Collect data for Client header
        methodVariantsForClientHeader
            .get(method.name())
            .addAll(
                generatedMethods.stream()
                    .map(AbstractServiceClientClassComposer::getJavaMethod)
                    .collect(Collectors.toList()));
        javaMethods.addAll(generatedMethods);

        MethodDefinition generatedMethod =
            createMethodDefaultMethod(
                method,
                ClassNames.getServiceClientClassName(service),
                messageTypes,
                typeStore,
                resourceNames,
                samples,
                service);

        // Collect data for gapic_metadata.json and client header.
        grpcRpcToJavaMethodMetadata.get(method.name()).add(javaMethodNameFn.apply(generatedMethod));
        methodVariantsForClientHeader.get(method.name()).add(getJavaMethod(generatedMethod));
        javaMethods.add(generatedMethod);
      }
      if (method.hasLro()) {
        MethodDefinition generatedMethod =
            createLroCallableMethod(
                service, method, typeStore, messageTypes, resourceNames, samples);

        // Collect data for gapic_metadata.json and client header.
        grpcRpcToJavaMethodMetadata.get(method.name()).add(javaMethodNameFn.apply(generatedMethod));
        methodVariantsForClientHeader.get(method.name()).add(getJavaMethod(generatedMethod));
        javaMethods.add(generatedMethod);
      }
      if (method.isPaged()) {
        MethodDefinition generatedMethod =
            createPagedCallableMethod(
                service, method, typeStore, messageTypes, resourceNames, samples);

        // Collect data for gapic_metadata.json and client header.
        grpcRpcToJavaMethodMetadata.get(method.name()).add(javaMethodNameFn.apply(generatedMethod));
        methodVariantsForClientHeader.get(method.name()).add(getJavaMethod(generatedMethod));
        javaMethods.add(generatedMethod);
      }
      MethodDefinition generatedMethod =
          createCallableMethod(service, method, typeStore, messageTypes, resourceNames, samples);

      // Collect data for the gapic_metadata.json file and client header.
      grpcRpcToJavaMethodMetadata.get(method.name()).add(javaMethodNameFn.apply(generatedMethod));
      methodVariantsForClientHeader.get(method.name()).add(getJavaMethod(generatedMethod));
      javaMethods.add(generatedMethod);
    }
    return javaMethods;
  }

  private static List<MethodDefinition> createMethodVariants(
      Method method,
      String clientName,
      Map<String, Message> messageTypes,
      TypeStore typeStore,
      Map<String, ResourceName> resourceNames,
      List<Sample> samples,
      Service service) {
    List<MethodDefinition> javaMethods = new ArrayList<>();
    String methodName = JavaStyle.toLowerCamelCase(method.name());
    TypeNode methodInputType = method.inputType();
    TypeNode methodOutputType =
        method.isPaged()
            ? typeStore.get(
                String.format(CommonStrings.PAGED_RESPONSE_TYPE_NAME_PATTERN, method.name()))
            : method.outputType();
    if (method.hasLro()) {
      LongrunningOperation lro = method.lro();
      methodOutputType =
          TypeNode.withReference(
              typeStore
                  .get("OperationFuture")
                  .reference()
                  .copyAndSetGenerics(
                      Arrays.asList(
                          lro.responseType().reference(), lro.metadataType().reference())));
    }

    for (List<MethodArgument> signature : method.methodSignatures()) {
      // Get the argument list.
      List<VariableExpr> arguments =
          signature.stream()
              .map(
                  methodArg ->
                      VariableExpr.builder()
                          .setVariable(
                              Variable.builder()
                                  .setName(JavaStyle.toLowerCamelCase(methodArg.name()))
                                  .setType(methodArg.type())
                                  .build())
                          .setIsDecl(true)
                          .build())
              .collect(Collectors.toList());

      // Request proto builder.
      VariableExpr requestVarExpr =
          VariableExpr.builder()
              .setVariable(Variable.builder().setName("request").setType(methodInputType).build())
              .setIsDecl(true)
              .build();

      Expr requestBuilderExpr = createRequestBuilderExpr(method, signature, typeStore);

      AssignmentExpr requestAssignmentExpr =
          AssignmentExpr.builder()
              .setVariableExpr(requestVarExpr)
              .setValueExpr(requestBuilderExpr)
              .build();

      List<Statement> statements = new ArrayList<>();
      statements.add(ExprStatement.withExpr(requestAssignmentExpr));

      MethodInvocationExpr rpcInvocationExpr =
          MethodInvocationExpr.builder()
              .setMethodName(String.format(method.hasLro() ? "%sAsync" : "%s", methodName))
              .setArguments(Arrays.asList(requestVarExpr.toBuilder().setIsDecl(false).build()))
              .setReturnType(methodOutputType)
              .build();

      Optional<Sample> methodSample =
          Optional.of(
              ServiceClientHeaderSampleComposer.composeShowcaseMethodSample(
                  method,
                  typeStore.get(clientName),
                  signature,
                  resourceNames,
                  messageTypes,
                  service));
      Optional<String> methodDocSample = Optional.empty();
      if (methodSample.isPresent()) {
        samples.add(methodSample.get());
        methodDocSample =
            Optional.of(SampleCodeWriter.writeInlineSample(methodSample.get().body()));
      }

      MethodDefinition.Builder methodVariantBuilder =
          MethodDefinition.builder()
              .setHeaderCommentStatements(
                  ServiceClientCommentComposer.createRpcMethodHeaderComment(
                      method, signature, methodDocSample))
              .setScope(ScopeNode.PUBLIC)
              .setIsFinal(true)
              .setName(String.format(method.hasLro() ? "%sAsync" : "%s", methodName))
              .setArguments(arguments);

      if (isProtoEmptyType(methodOutputType)) {
        statements.add(ExprStatement.withExpr(rpcInvocationExpr));
        methodVariantBuilder = methodVariantBuilder.setReturnType(TypeNode.VOID);
      } else {
        methodVariantBuilder =
            methodVariantBuilder.setReturnType(methodOutputType).setReturnExpr(rpcInvocationExpr);
      }

      methodVariantBuilder =
          methodVariantBuilder.setAnnotations(createMethodAnnotations(method, typeStore));
      methodVariantBuilder = methodVariantBuilder.setBody(statements);
      javaMethods.add(methodVariantBuilder.build());
    }

    return javaMethods;
  }

  private static MethodDefinition createMethodDefaultMethod(
      Method method,
      String clientName,
      Map<String, Message> messageTypes,
      TypeStore typeStore,
      Map<String, ResourceName> resourceNames,
      List<Sample> samples,
      Service service) {
    String methodName = JavaStyle.toLowerCamelCase(method.name());
    TypeNode methodInputType = method.inputType();
    TypeNode methodOutputType =
        method.isPaged()
            ? typeStore.get(
                String.format(CommonStrings.PAGED_RESPONSE_TYPE_NAME_PATTERN, method.name()))
            : method.outputType();
    if (method.hasLro()) {
      LongrunningOperation lro = method.lro();
      methodOutputType =
          TypeNode.withReference(
              typeStore
                  .get("OperationFuture")
                  .reference()
                  .copyAndSetGenerics(
                      Arrays.asList(
                          lro.responseType().reference(), lro.metadataType().reference())));
    }

    // Construct the method that accepts a request proto.
    VariableExpr requestArgVarExpr =
        VariableExpr.builder()
            .setVariable(Variable.builder().setName("request").setType(methodInputType).build())
            .setIsDecl(true)
            .build();
    String callableMethodName =
        method.isPaged()
            ? String.format(PAGED_CALLABLE_NAME_PATTERN, methodName)
            : String.format(CALLABLE_NAME_PATTERN, methodName);
    if (method.hasLro()) {
      callableMethodName = String.format(OPERATION_CALLABLE_NAME_PATTERN, methodName);
    }

    Optional<Sample> defaultMethodSample =
        Optional.of(
            ServiceClientMethodSampleComposer.composeCanonicalSample(
                method, typeStore.get(clientName), resourceNames, messageTypes, service));
    Optional<String> defaultMethodDocSample = Optional.empty();
    if (defaultMethodSample.isPresent()) {
      samples.add(defaultMethodSample.get());
      defaultMethodDocSample =
          Optional.of(SampleCodeWriter.writeInlineSample(defaultMethodSample.get().body()));
    }

    MethodInvocationExpr callableMethodExpr =
        MethodInvocationExpr.builder().setMethodName(callableMethodName).build();
    callableMethodExpr =
        MethodInvocationExpr.builder()
            .setMethodName(method.hasLro() ? "futureCall" : "call")
            .setArguments(Arrays.asList(requestArgVarExpr.toBuilder().setIsDecl(false).build()))
            .setExprReferenceExpr(callableMethodExpr)
            .setReturnType(methodOutputType)
            .build();
    MethodDefinition.Builder methodBuilder =
        MethodDefinition.builder()
            .setHeaderCommentStatements(
                ServiceClientCommentComposer.createRpcMethodHeaderComment(
                    method, defaultMethodDocSample))
            .setScope(ScopeNode.PUBLIC)
            .setIsFinal(true)
            .setName(String.format(method.hasLro() ? "%sAsync" : "%s", methodName))
            .setArguments(Arrays.asList(requestArgVarExpr));

    if (isProtoEmptyType(methodOutputType)) {
      methodBuilder =
          methodBuilder
              .setBody(Arrays.asList(ExprStatement.withExpr(callableMethodExpr)))
              .setReturnType(TypeNode.VOID);
    } else {
      methodBuilder =
          methodBuilder.setReturnExpr(callableMethodExpr).setReturnType(methodOutputType);
    }

    methodBuilder.setAnnotations(createMethodAnnotations(method, typeStore));
    return methodBuilder.build();
  }

  private static MethodDefinition createLroCallableMethod(
      Service service,
      Method method,
      TypeStore typeStore,
      Map<String, Message> messageTypes,
      Map<String, ResourceName> resourceNames,
      List<Sample> samples) {
    return createCallableMethod(
        service, method, CallableMethodKind.LRO, typeStore, messageTypes, resourceNames, samples);
  }

  private static MethodDefinition createCallableMethod(
      Service service,
      Method method,
      TypeStore typeStore,
      Map<String, Message> messageTypes,
      Map<String, ResourceName> resourceNames,
      List<Sample> samples) {
    return createCallableMethod(
        service,
        method,
        CallableMethodKind.REGULAR,
        typeStore,
        messageTypes,
        resourceNames,
        samples);
  }

  private static MethodDefinition createPagedCallableMethod(
      Service service,
      Method method,
      TypeStore typeStore,
      Map<String, Message> messageTypes,
      Map<String, ResourceName> resourceNames,
      List<Sample> samples) {
    return createCallableMethod(
        service, method, CallableMethodKind.PAGED, typeStore, messageTypes, resourceNames, samples);
  }

  private static MethodDefinition createCallableMethod(
      Service service,
      Method method,
      CallableMethodKind callableMethodKind,
      TypeStore typeStore,
      Map<String, Message> messageTypes,
      Map<String, ResourceName> resourceNames,
      List<Sample> samples) {
    TypeNode rawCallableReturnType = null;
    if (callableMethodKind.equals(CallableMethodKind.LRO)) {
      rawCallableReturnType = typeStore.get("OperationCallable");
    } else {
      switch (method.stream()) {
        case CLIENT:
          rawCallableReturnType = typeStore.get("ClientStreamingCallable");
          break;
        case SERVER:
          rawCallableReturnType = typeStore.get("ServerStreamingCallable");
          break;
        case BIDI:
          rawCallableReturnType = typeStore.get("BidiStreamingCallable");
          break;
        case NONE:
        // Fall through.
        default:
          rawCallableReturnType = typeStore.get("UnaryCallable");
      }
    }

    // Set generics.
    TypeNode returnType =
        TypeNode.withReference(
            rawCallableReturnType
                .reference()
                .copyAndSetGenerics(getGenericsForCallable(callableMethodKind, method, typeStore)));

    String rawMethodName = JavaStyle.toLowerCamelCase(method.name());
    String methodName = getCallableName(callableMethodKind, rawMethodName);
    TypeNode stubType = typeStore.get(ClassNames.getServiceStubClassName(service));
    MethodInvocationExpr returnExpr =
        MethodInvocationExpr.builder()
            .setExprReferenceExpr(
                VariableExpr.builder()
                    .setVariable(Variable.builder().setName("stub").setType(stubType).build())
                    .build())
            .setMethodName(methodName)
            .setReturnType(returnType)
            .build();

    Optional<Sample> sampleCode = Optional.empty();
    if (callableMethodKind.equals(CallableMethodKind.LRO)) {
      sampleCode =
          Optional.of(
              ServiceClientCallableMethodSampleComposer.composeLroCallableMethod(
                  method,
                  typeStore.get(ClassNames.getServiceClientClassName(service)),
                  resourceNames,
                  messageTypes,
                  service));
    } else if (callableMethodKind.equals(CallableMethodKind.PAGED)) {
      sampleCode =
          Optional.of(
              ServiceClientCallableMethodSampleComposer.composePagedCallableMethod(
                  method,
                  typeStore.get(ClassNames.getServiceClientClassName(service)),
                  resourceNames,
                  messageTypes,
                  service));
    } else if (callableMethodKind.equals(CallableMethodKind.REGULAR)) {
      if (method.stream().equals(Stream.NONE)) {
        sampleCode =
            Optional.of(
                ServiceClientCallableMethodSampleComposer.composeRegularCallableMethod(
                    method,
                    typeStore.get(ClassNames.getServiceClientClassName(service)),
                    resourceNames,
                    messageTypes,
                    service));
      } else {
        sampleCode =
            Optional.of(
                ServiceClientCallableMethodSampleComposer.composeStreamCallableMethod(
                    method,
                    typeStore.get(ClassNames.getServiceClientClassName(service)),
                    resourceNames,
                    messageTypes,
                    service));
      }
    }
    Optional<String> sampleDocCode = Optional.empty();
    if (sampleCode.isPresent()) {
      samples.add(sampleCode.get());
      sampleDocCode = Optional.of(SampleCodeWriter.writeInlineSample(sampleCode.get().body()));
    }

    MethodDefinition.Builder methodDefBuilder = MethodDefinition.builder();

    methodDefBuilder = methodDefBuilder.setAnnotations(createMethodAnnotations(method, typeStore));

    return methodDefBuilder
        .setHeaderCommentStatements(
            ServiceClientCommentComposer.createRpcCallableMethodHeaderComment(
                method, sampleDocCode))
        .setScope(ScopeNode.PUBLIC)
        .setIsFinal(true)
        .setName(methodName)
        .setReturnType(returnType)
        .setReturnExpr(returnExpr)
        .build();
  }

  private static List<MethodDefinition> createBackgroundResourceMethods(
      Service service, TypeStore typeStore) {
    List<MethodDefinition> methods = new ArrayList<>();

    VariableExpr stubVarExpr =
        VariableExpr.withVariable(
            Variable.builder()
                .setType(typeStore.get(ClassNames.getServiceStubClassName(service)))
                .setName("stub")
                .build());
    MethodDefinition closeMethod =
        MethodDefinition.builder()
            .setIsOverride(true)
            .setScope(ScopeNode.PUBLIC)
            .setIsFinal(true)
            .setReturnType(TypeNode.VOID)
            .setName("close")
            .setBody(
                Arrays.asList(
                    ExprStatement.withExpr(
                        MethodInvocationExpr.builder()
                            .setExprReferenceExpr(stubVarExpr)
                            .setMethodName("close")
                            .build())))
            .build();
    methods.add(closeMethod);

    MethodDefinition shutdownMethod =
        MethodDefinition.builder()
            .setIsOverride(true)
            .setScope(ScopeNode.PUBLIC)
            .setReturnType(TypeNode.VOID)
            .setName("shutdown")
            .setBody(
                Arrays.asList(
                    ExprStatement.withExpr(
                        MethodInvocationExpr.builder()
                            .setExprReferenceExpr(stubVarExpr)
                            .setMethodName("shutdown")
                            .build())))
            .build();
    methods.add(shutdownMethod);

    MethodDefinition isShutdownMethod =
        MethodDefinition.builder()
            .setIsOverride(true)
            .setScope(ScopeNode.PUBLIC)
            .setReturnType(TypeNode.BOOLEAN)
            .setName("isShutdown")
            .setReturnExpr(
                MethodInvocationExpr.builder()
                    .setExprReferenceExpr(stubVarExpr)
                    .setMethodName("isShutdown")
                    .setReturnType(TypeNode.BOOLEAN)
                    .build())
            .build();
    methods.add(isShutdownMethod);

    MethodDefinition isTerminatedMethod =
        MethodDefinition.builder()
            .setIsOverride(true)
            .setScope(ScopeNode.PUBLIC)
            .setReturnType(TypeNode.BOOLEAN)
            .setName("isTerminated")
            .setReturnExpr(
                MethodInvocationExpr.builder()
                    .setExprReferenceExpr(stubVarExpr)
                    .setMethodName("isTerminated")
                    .setReturnType(TypeNode.BOOLEAN)
                    .build())
            .build();
    methods.add(isTerminatedMethod);

    MethodDefinition shutdownNowMethod =
        MethodDefinition.builder()
            .setIsOverride(true)
            .setScope(ScopeNode.PUBLIC)
            .setReturnType(TypeNode.VOID)
            .setName("shutdownNow")
            .setBody(
                Arrays.asList(
                    ExprStatement.withExpr(
                        MethodInvocationExpr.builder()
                            .setExprReferenceExpr(stubVarExpr)
                            .setMethodName("shutdownNow")
                            .build())))
            .build();
    methods.add(shutdownNowMethod);

    List<VariableExpr> arguments =
        Arrays.asList(
            VariableExpr.builder()
                .setVariable(Variable.builder().setName("duration").setType(TypeNode.LONG).build())
                .build(),
            VariableExpr.builder()
                .setVariable(
                    Variable.builder().setName("unit").setType(typeStore.get("TimeUnit")).build())
                .build());

    MethodDefinition awaitTerminationMethod =
        MethodDefinition.builder()
            .setIsOverride(true)
            .setScope(ScopeNode.PUBLIC)
            .setReturnType(TypeNode.BOOLEAN)
            .setName("awaitTermination")
            .setArguments(
                arguments.stream()
                    .map(v -> v.toBuilder().setIsDecl(true).build())
                    .collect(Collectors.toList()))
            .setThrowsExceptions(Arrays.asList(typeStore.get("InterruptedException")))
            .setReturnExpr(
                MethodInvocationExpr.builder()
                    .setExprReferenceExpr(stubVarExpr)
                    .setMethodName("awaitTermination")
                    .setArguments(
                        arguments.stream().map(v -> (Expr) v).collect(Collectors.toList()))
                    .setReturnType(TypeNode.BOOLEAN)
                    .build())
            .build();
    methods.add(awaitTerminationMethod);

    return methods;
  }

  private static List<ClassDefinition> createNestedPagingClasses(
      Service service, Map<String, Message> messageTypes, TypeStore typeStore) {
    List<ClassDefinition> nestedClasses = new ArrayList<>();
    for (Method method : service.methods()) {
      if (!method.isPaged()) {
        continue;
      }
      // Find the repeated field.
      Message methodOutputMessage = messageTypes.get(method.outputType().reference().fullName());
      Field repeatedPagedResultsField = methodOutputMessage.findAndUnwrapPaginatedRepeatedField();
      Preconditions.checkNotNull(
          repeatedPagedResultsField,
          String.format(
              "No repeated field found on message %s for method %s",
              methodOutputMessage.name(), method.name()));

      TypeNode repeatedResponseType = repeatedPagedResultsField.type();

      nestedClasses.add(
          createNestedRpcPagedResponseClass(method, repeatedResponseType, messageTypes, typeStore));
      nestedClasses.add(
          createNestedRpcPageClass(method, repeatedResponseType, messageTypes, typeStore));
      nestedClasses.add(
          createNestedRpcFixedSizeCollectionClass(
              method, repeatedResponseType, messageTypes, typeStore));
    }

    return nestedClasses;
  }

  private static ClassDefinition createNestedRpcPagedResponseClass(
      Method method,
      TypeNode repeatedResponseType,
      Map<String, Message> messageTypes,
      TypeStore typeStore) {
    Preconditions.checkState(
        method.isPaged(), String.format("Expected method %s to be paged", method.name()));

    String className = String.format("%sPagedResponse", JavaStyle.toUpperCamelCase(method.name()));
    TypeNode thisClassType = typeStore.get(className);

    String upperJavaMethodName = JavaStyle.toUpperCamelCase(method.name());
    TypeNode methodPageType = typeStore.get(String.format("%sPage", upperJavaMethodName));
    TypeNode classExtendsType =
        TypeNode.withReference(
            ConcreteReference.builder()
                .setClazz(AbstractPagedListResponse.class)
                .setGenerics(
                    Arrays.asList(
                            method.inputType(),
                            method.outputType(),
                            repeatedResponseType,
                            methodPageType,
                            typeStore.get(
                                String.format("%sFixedSizeCollection", upperJavaMethodName)))
                        .stream()
                        .map(t -> t.reference())
                        .collect(Collectors.toList()))
                .build());

    // createAsync method - variables.
    VariableExpr contextVarExpr =
        VariableExpr.withVariable(
            Variable.builder()
                .setName("context")
                .setType(
                    TypeNode.withReference(
                        ConcreteReference.builder()
                            .setClazz(PageContext.class)
                            .setGenerics(
                                Arrays.asList(
                                        method.inputType(),
                                        method.outputType(),
                                        repeatedResponseType)
                                    .stream()
                                    .map(t -> t.reference())
                                    .collect(Collectors.toList()))
                            .build()))
                .build());
    VariableExpr futureResponseVarExpr =
        VariableExpr.withVariable(
            Variable.builder()
                .setName("futureResponse")
                .setType(
                    TypeNode.withReference(
                        ConcreteReference.builder()
                            .setClazz(ApiFuture.class)
                            .setGenerics(Arrays.asList(method.outputType().reference()))
                            .build()))
                .build());

    VariableExpr futurePageVarExpr =
        VariableExpr.withVariable(
            Variable.builder()
                .setName("futurePage")
                .setType(
                    TypeNode.withReference(
                        ConcreteReference.builder()
                            .setClazz(ApiFuture.class)
                            .setGenerics(Arrays.asList(methodPageType.reference()))
                            .build()))
                .build());

    // createAsync method - assignment expression.
    MethodInvocationExpr createPageAsyncExpr =
        MethodInvocationExpr.builder()
            .setStaticReferenceType(methodPageType)
            .setMethodName("createEmptyPage")
            .build();
    createPageAsyncExpr =
        MethodInvocationExpr.builder()
            .setExprReferenceExpr(createPageAsyncExpr)
            .setMethodName("createPageAsync")
            .setArguments(contextVarExpr, futureResponseVarExpr)
            .setReturnType(futurePageVarExpr.type())
            .build();
    AssignmentExpr futurePageAssignExpr =
        AssignmentExpr.builder()
            .setVariableExpr(futurePageVarExpr.toBuilder().setIsDecl(true).build())
            .setValueExpr(createPageAsyncExpr)
            .build();

    // createAsync method - anonymous class expression.
    VariableExpr inputVarExpr =
        VariableExpr.withVariable(
            Variable.builder().setName("input").setType(methodPageType).build());

    // Overrides ApiFunction.apply.
    // (https://github.com/googleapis/api-common-java/blob/debf25960dea0367b0d3b5e16d57d76c1d01947e/src/main/java/com/google/api/core/ApiFunction.java).
    Expr pageToTransformExpr =
        LambdaExpr.builder()
            .setArguments(inputVarExpr.toBuilder().setIsDecl(true).build())
            .setReturnExpr(
                NewObjectExpr.builder().setType(thisClassType).setArguments(inputVarExpr).build())
            .build();

    // createAsync method - return expression.
    TypeNode returnType =
        TypeNode.withReference(
            ConcreteReference.builder()
                .setClazz(ApiFuture.class)
                .setGenerics(Arrays.asList(typeStore.get(className).reference()))
                .build());
    Expr returnExpr =
        MethodInvocationExpr.builder()
            .setStaticReferenceType(typeStore.get("ApiFutures"))
            .setMethodName("transform")
            .setArguments(
                futurePageVarExpr,
                pageToTransformExpr,
                MethodInvocationExpr.builder()
                    .setStaticReferenceType(typeStore.get("MoreExecutors"))
                    .setMethodName("directExecutor")
                    .build())
            .setReturnType(returnType)
            .build();

    MethodDefinition createAsyncMethod =
        MethodDefinition.builder()
            .setScope(ScopeNode.PUBLIC)
            .setIsStatic(true)
            .setReturnType(returnType)
            .setName("createAsync")
            .setArguments(
                Arrays.asList(contextVarExpr, futureResponseVarExpr).stream()
                    .map(e -> e.toBuilder().setIsDecl(true).build())
                    .collect(Collectors.toList()))
            .setBody(Arrays.asList(ExprStatement.withExpr(futurePageAssignExpr)))
            .setReturnExpr(returnExpr)
            .build();

    // Private constructor.
    VariableExpr pageVarExpr =
        VariableExpr.withVariable(
            Variable.builder().setName("page").setType(methodPageType).build());
    MethodDefinition privateCtor =
        MethodDefinition.constructorBuilder()
            .setScope(ScopeNode.PRIVATE)
            .setReturnType(thisClassType)
            .setArguments(pageVarExpr.toBuilder().setIsDecl(true).build())
            .setBody(
                Arrays.asList(
                    ExprStatement.withExpr(
                        // Shortcut.
                        ReferenceConstructorExpr.superBuilder()
                            .setType(methodPageType)
                            .setArguments(
                                pageVarExpr,
                                MethodInvocationExpr.builder()
                                    .setStaticReferenceType(
                                        typeStore.get(
                                            String.format(
                                                "%sFixedSizeCollection", upperJavaMethodName)))
                                    .setMethodName("createEmptyCollection")
                                    .build())
                            .build())))
            .build();

    List<MethodDefinition> javaMethods = new ArrayList<>();
    javaMethods.add(createAsyncMethod);
    javaMethods.add(privateCtor);

    return ClassDefinition.builder()
        .setIsNested(true)
        .setScope(ScopeNode.PUBLIC)
        .setIsStatic(true)
        .setExtendsType(classExtendsType)
        .setName(className)
        .setMethods(javaMethods)
        .build();
  }

  private static ClassDefinition createNestedRpcPageClass(
      Method method,
      TypeNode repeatedResponseType,
      Map<String, Message> messageTypes,
      TypeStore typeStore) {
    Preconditions.checkState(
        method.isPaged(), String.format("Expected method %s to be paged", method.name()));

    String upperJavaMethodName = JavaStyle.toUpperCamelCase(method.name());
    String className = String.format("%sPage", upperJavaMethodName);
    TypeNode classType = typeStore.get(className);
    TypeNode classExtendsType =
        TypeNode.withReference(
            ConcreteReference.builder()
                .setClazz(AbstractPage.class)
                .setGenerics(
                    Arrays.asList(
                            method.inputType(),
                            method.outputType(),
                            repeatedResponseType,
                            classType)
                        .stream()
                        .map(t -> t.reference())
                        .collect(Collectors.toList()))
                .build());

    // Private constructor.
    VariableExpr contextVarExpr =
        VariableExpr.withVariable(
            Variable.builder()
                .setName("context")
                .setType(
                    TypeNode.withReference(
                        ConcreteReference.builder()
                            .setClazz(PageContext.class)
                            .setGenerics(
                                Arrays.asList(
                                        method.inputType(),
                                        method.outputType(),
                                        repeatedResponseType)
                                    .stream()
                                    .map(t -> t.reference())
                                    .collect(Collectors.toList()))
                            .build()))
                .build());
    VariableExpr responseVarExpr =
        VariableExpr.withVariable(
            Variable.builder().setName("response").setType(method.outputType()).build());
    MethodDefinition privateCtor =
        MethodDefinition.constructorBuilder()
            .setScope(ScopeNode.PRIVATE)
            .setReturnType(classType)
            .setArguments(
                Arrays.asList(contextVarExpr, responseVarExpr).stream()
                    .map(e -> e.toBuilder().setIsDecl(true).build())
                    .collect(Collectors.toList()))
            .setBody(
                Arrays.asList(
                    ExprStatement.withExpr(
                        ReferenceConstructorExpr.superBuilder()
                            .setType(classExtendsType)
                            .setArguments(contextVarExpr, responseVarExpr)
                            .build())))
            .build();

    // createEmptyPage method.
    ValueExpr nullExpr = ValueExpr.createNullExpr();
    MethodDefinition createEmptyPageMethod =
        MethodDefinition.builder()
            .setScope(ScopeNode.PRIVATE)
            .setIsStatic(true)
            .setReturnType(classType)
            .setName("createEmptyPage")
            .setReturnExpr(
                NewObjectExpr.builder().setType(classType).setArguments(nullExpr, nullExpr).build())
            .build();

    // createPage method.
    MethodDefinition createPageMethod =
        MethodDefinition.builder()
            .setIsOverride(true)
            .setScope(ScopeNode.PROTECTED)
            .setReturnType(classType)
            .setName("createPage")
            .setArguments(
                Arrays.asList(contextVarExpr, responseVarExpr).stream()
                    .map(e -> e.toBuilder().setIsDecl(true).build())
                    .collect(Collectors.toList()))
            .setReturnExpr(
                NewObjectExpr.builder()
                    .setType(classType)
                    .setArguments(contextVarExpr, responseVarExpr)
                    .build())
            .build();

    // createPageAsync method.
    Function<TypeNode, TypeNode> futureTypeFn =
        t ->
            TypeNode.withReference(
                ConcreteReference.builder()
                    .setClazz(ApiFuture.class)
                    .setGenerics(Arrays.asList(t.reference()))
                    .build());
    VariableExpr futureResponseVarExpr =
        VariableExpr.withVariable(
            Variable.builder()
                .setName("futureResponse")
                .setType(futureTypeFn.apply(method.outputType()))
                .build());
    TypeNode futurePageType = futureTypeFn.apply(classType);
    MethodDefinition createPageAsyncMethod =
        MethodDefinition.builder()
            .setIsOverride(true)
            .setScope(ScopeNode.PUBLIC)
            .setReturnType(futurePageType)
            .setName("createPageAsync")
            .setArguments(
                Arrays.asList(contextVarExpr, futureResponseVarExpr).stream()
                    .map(e -> e.toBuilder().setIsDecl(true).build())
                    .collect(Collectors.toList()))
            .setReturnExpr(
                MethodInvocationExpr.builder()
                    .setExprReferenceExpr(
                        ValueExpr.withValue(SuperObjectValue.withType(classExtendsType)))
                    .setMethodName("createPageAsync")
                    .setArguments(contextVarExpr, futureResponseVarExpr)
                    .setReturnType(futurePageType)
                    .build())
            .build();

    // Build the class.
    List<MethodDefinition> javaMethods = new ArrayList<>();
    javaMethods.add(privateCtor);
    javaMethods.add(createEmptyPageMethod);
    javaMethods.add(createPageMethod);
    javaMethods.add(createPageAsyncMethod);

    return ClassDefinition.builder()
        .setIsNested(true)
        .setScope(ScopeNode.PUBLIC)
        .setIsStatic(true)
        .setExtendsType(classExtendsType)
        .setName(className)
        .setMethods(javaMethods)
        .build();
  }

  private static ClassDefinition createNestedRpcFixedSizeCollectionClass(
      Method method,
      TypeNode repeatedResponseType,
      Map<String, Message> messageTypes,
      TypeStore typeStore) {
    String upperJavaMethodName = JavaStyle.toUpperCamelCase(method.name());
    String className = String.format("%sFixedSizeCollection", upperJavaMethodName);
    TypeNode classType = typeStore.get(className);
    TypeNode methodPageType = typeStore.get(String.format("%sPage", upperJavaMethodName));

    TypeNode classExtendsType =
        TypeNode.withReference(
            ConcreteReference.builder()
                .setClazz(AbstractFixedSizeCollection.class)
                .setGenerics(
                    Arrays.asList(
                            method.inputType(),
                            method.outputType(),
                            repeatedResponseType,
                            methodPageType,
                            classType)
                        .stream()
                        .map(t -> t.reference())
                        .collect(Collectors.toList()))
                .build());

    // Private constructor.
    VariableExpr pagesVarExpr =
        VariableExpr.withVariable(
            Variable.builder()
                .setName("pages")
                .setType(
                    TypeNode.withReference(
                        ConcreteReference.builder()
                            .setClazz(List.class)
                            .setGenerics(Arrays.asList(methodPageType.reference()))
                            .build()))
                .build());
    VariableExpr collectionSizeVarExpr =
        VariableExpr.withVariable(
            Variable.builder().setName("collectionSize").setType(TypeNode.INT).build());

    MethodDefinition privateCtor =
        MethodDefinition.constructorBuilder()
            .setScope(ScopeNode.PRIVATE)
            .setReturnType(classType)
            .setArguments(
                Arrays.asList(pagesVarExpr, collectionSizeVarExpr).stream()
                    .map(e -> e.toBuilder().setIsDecl(true).build())
                    .collect(Collectors.toList()))
            .setBody(
                Arrays.asList(
                    ExprStatement.withExpr(
                        ReferenceConstructorExpr.superBuilder()
                            .setType(classExtendsType)
                            .setArguments(pagesVarExpr, collectionSizeVarExpr)
                            .build())))
            .build();

    // createEmptyCollection method.
    MethodDefinition createEmptyCollectionMethod =
        MethodDefinition.builder()
            .setScope(ScopeNode.PRIVATE)
            .setIsStatic(true)
            .setReturnType(classType)
            .setName("createEmptyCollection")
            .setReturnExpr(
                NewObjectExpr.builder()
                    .setType(classType)
                    .setArguments(
                        ValueExpr.createNullExpr(),
                        ValueExpr.withValue(
                            PrimitiveValue.builder().setType(TypeNode.INT).setValue("0").build()))
                    .build())
            .build();

    // createCollection method.
    MethodDefinition createCollectionMethod =
        MethodDefinition.builder()
            .setIsOverride(true)
            .setScope(ScopeNode.PROTECTED)
            .setReturnType(classType)
            .setName("createCollection")
            .setArguments(
                Arrays.asList(pagesVarExpr, collectionSizeVarExpr).stream()
                    .map(e -> e.toBuilder().setIsDecl(true).build())
                    .collect(Collectors.toList()))
            .setReturnExpr(
                NewObjectExpr.builder()
                    .setType(classType)
                    .setArguments(pagesVarExpr, collectionSizeVarExpr)
                    .build())
            .build();

    List<MethodDefinition> javaMethods = new ArrayList<>();
    javaMethods.add(privateCtor);
    javaMethods.add(createEmptyCollectionMethod);
    javaMethods.add(createCollectionMethod);

    return ClassDefinition.builder()
        .setIsNested(true)
        .setScope(ScopeNode.PUBLIC)
        .setIsStatic(true)
        .setExtendsType(classExtendsType)
        .setName(className)
        .setMethods(javaMethods)
        .build();
  }

  @VisibleForTesting
  static Expr createRequestBuilderExpr(
      Method method, List<MethodArgument> signature, TypeStore typeStore) {
    TypeNode methodInputType = method.inputType();
    Expr newBuilderExpr =
        MethodInvocationExpr.builder()
            .setMethodName("newBuilder")
            .setStaticReferenceType(methodInputType)
            .build();
    // Maintain the args' order of appearance for better determinism.
    List<Field> rootFields = new ArrayList<>();
    Map<Field, Trie<Field>> rootFieldToTrie = new HashMap<>();
    for (MethodArgument arg : signature) {
      Field rootField = arg.nestedFields().isEmpty() ? arg.field() : arg.nestedFields().get(0);
      if (!rootFields.contains(rootField)) {
        rootFields.add(rootField);
      }
      Trie<Field> updatedTrie =
          rootFieldToTrie.containsKey(rootField) ? rootFieldToTrie.get(rootField) : new Trie<>();
      List<Field> nestedFieldsWithChild = new ArrayList<>(arg.nestedFields());
      nestedFieldsWithChild.add(arg.field());
      updatedTrie.insert(nestedFieldsWithChild);
      rootFieldToTrie.put(rootField, updatedTrie);
    }

    Function<Field, Expr> parentPreprocFn =
        field ->
            (Expr)
                MethodInvocationExpr.builder()
                    .setStaticReferenceType(field.type())
                    .setMethodName("newBuilder")
                    .build();
    TriFunction<Field, Expr, Expr, Expr> parentPostprocFn =
        (field, baseRefExpr, leafProcessedExpr) -> {
          boolean isRootNode = field == null;
          return isRootNode
              ? leafProcessedExpr
              : MethodInvocationExpr.builder()
                  .setExprReferenceExpr(baseRefExpr)
                  .setMethodName(String.format("set%s", JavaStyle.toUpperCamelCase(field.name())))
                  .setArguments(
                      MethodInvocationExpr.builder()
                          .setExprReferenceExpr(leafProcessedExpr)
                          .setMethodName("build")
                          .build())
                  .build();
        };

    final Map<Field, MethodArgument> fieldToMethodArg =
        signature.stream().collect(Collectors.toMap(a -> a.field(), a -> a));
    BiFunction<Field, Expr, Expr> leafProcFn =
        (field, parentBaseRefExpr) ->
            (Expr) buildNestedSetterInvocationExpr(fieldToMethodArg.get(field), parentBaseRefExpr);

    for (Field rootField : rootFields) {
      newBuilderExpr =
          rootFieldToTrie
              .get(rootField)
              .dfsTraverseAndReduce(parentPreprocFn, parentPostprocFn, leafProcFn, newBuilderExpr);
    }

    return MethodInvocationExpr.builder()
        .setExprReferenceExpr(newBuilderExpr)
        .setMethodName("build")
        .setReturnType(methodInputType)
        .build();
  }

  @VisibleForTesting
  static MethodInvocationExpr buildNestedSetterInvocationExpr(
      MethodArgument argument, Expr referenceExpr) {
    String argumentName = JavaStyle.toLowerCamelCase(argument.name());
    TypeNode argumentType = argument.type();

    Expr argVarExpr =
        VariableExpr.withVariable(
            Variable.builder().setName(argumentName).setType(argumentType).build());
    if (argument.isResourceNameHelper()) {
      Expr nullExpr = ValueExpr.createNullExpr();
      Expr isNullCheckExpr = RelationalOperationExpr.equalToWithExprs(argVarExpr, nullExpr);
      MethodInvocationExpr toStringExpr =
          MethodInvocationExpr.builder()
              .setExprReferenceExpr(argVarExpr)
              .setMethodName("toString")
              .setReturnType(TypeNode.STRING)
              .build();
      argVarExpr =
          TernaryExpr.builder()
              .setConditionExpr(isNullCheckExpr)
              .setThenExpr(nullExpr)
              .setElseExpr(toStringExpr)
              .build();
    }

    String setterMethodName =
        String.format(
            typeToSetterMethodName(argumentType), JavaStyle.toUpperCamelCase(argumentName));
    return MethodInvocationExpr.builder()
        .setExprReferenceExpr(referenceExpr)
        .setMethodName(setterMethodName)
        .setArguments(argVarExpr)
        .build();
  }

  private static String typeToSetterMethodName(TypeNode type) {
    String setterMethodVariantPattern = "set%s";
    if (TypeNode.isReferenceType(type)) {
      if (LIST_REFERENCE.isSupertypeOrEquals(type.reference())) {
        setterMethodVariantPattern = "addAll%s";
      } else if (MAP_REFERENCE.isSupertypeOrEquals(type.reference())) {
        setterMethodVariantPattern = "putAll%s";
      }
    }
    return setterMethodVariantPattern;
  }

  private static TypeStore createTypes(Service service, Map<String, Message> messageTypes) {
    List<Class<?>> concreteClazzes =
        Arrays.asList(
            AbstractPagedListResponse.class,
            ApiFunction.class,
            ApiFuture.class,
            ApiFutures.class,
            BackgroundResource.class,
            BetaApi.class,
            InternalApi.class,
            BidiStreamingCallable.class,
            ClientStreamingCallable.class,
            Generated.class,
            InterruptedException.class,
            IOException.class,
            MoreExecutors.class,
            Objects.class,
            Operation.class,
            OperationFuture.class,
            OperationCallable.class,
            ServerStreamingCallable.class,
            Status.class,
            Strings.class,
            TimeUnit.class,
            UnaryCallable.class);
    TypeStore typeStore = new TypeStore(concreteClazzes);
    createVaporTypes(service, typeStore);
    return typeStore;
  }

  private static void createVaporTypes(Service service, TypeStore typeStore) {
    // Client stub typeStore.
    typeStore.putAll(
        String.format("%s.stub", service.pakkage()),
        Arrays.asList(
            ClassNames.getServiceStubClassName(service),
            ClassNames.getServiceStubSettingsClassName(service)));

    // Client ServiceClient and ServiceSettings typeStore.
    typeStore.putAll(
        service.pakkage(),
        Arrays.asList(
            ClassNames.getServiceClientClassName(service),
            ClassNames.getServiceSettingsClassName(service)));

    // Nested class typeStore.
    for (Method method : service.methods()) {
      if (!method.isPaged()) {
        continue;
      }
      typeStore.putAll(
          service.pakkage(),
          Arrays.asList("%sPagedResponse", "%sPage", "%sFixedSizeCollection").stream()
              .map(p -> String.format(p, JavaStyle.toUpperCamelCase(method.name())))
              .collect(Collectors.toList()),
          true,
          ClassNames.getServiceClientClassName(service));
    }

    // Pagination types.
    typeStore.putAll(
        service.pakkage(),
        service.methods().stream()
            .filter(m -> m.isPaged())
            .map(m -> String.format(CommonStrings.PAGED_RESPONSE_TYPE_NAME_PATTERN, m.name()))
            .collect(Collectors.toList()),
        true,
        ClassNames.getServiceClientClassName(service));
  }

  private static List<Reference> getGenericsForCallable(
      CallableMethodKind kind, Method method, TypeStore typeStore) {
    if (kind.equals(CallableMethodKind.LRO)) {
      return Arrays.asList(
          method.inputType().reference(),
          method.lro().responseType().reference(),
          method.lro().metadataType().reference());
    }
    if (kind.equals(CallableMethodKind.PAGED)) {
      return Arrays.asList(
          method.inputType().reference(),
          typeStore
              .get(String.format(CommonStrings.PAGED_RESPONSE_TYPE_NAME_PATTERN, method.name()))
              .reference());
    }
    return Arrays.asList(method.inputType().reference(), method.outputType().reference());
  }

  private static String getCallableName(CallableMethodKind kind, String rawMethodName) {
    if (kind.equals(CallableMethodKind.LRO)) {
      return String.format(OPERATION_CALLABLE_NAME_PATTERN, rawMethodName);
    }
    if (kind.equals(CallableMethodKind.PAGED)) {
      return String.format(PAGED_CALLABLE_NAME_PATTERN, rawMethodName);
    }
    return String.format(CALLABLE_NAME_PATTERN, rawMethodName);
  }

  private static boolean isProtoEmptyType(TypeNode type) {
    return type.reference().pakkage().equals("com.google.protobuf")
        && type.reference().name().equals("Empty");
  }

  private static void updateGapicMetadata(
      GapicContext context,
      Service service,
      String clientClassName,
      Map<String, List<String>> grpcRpcToJavaMethodNames) {
    GapicMetadata.Builder metadataBuilder = context.gapicMetadata().toBuilder();
    metadataBuilder =
        metadataBuilder
            .setProtoPackage(service.protoPakkage())
            .setLibraryPackage(service.pakkage());

    GapicMetadata.ServiceAsClient.Builder serviceClientProtoBuilder =
        GapicMetadata.ServiceAsClient.newBuilder().setLibraryClient(clientClassName);

    // Sort for deterministic tests.
    List<String> sortedRpcNames = new ArrayList<>(grpcRpcToJavaMethodNames.keySet());
    Collections.sort(sortedRpcNames);
    for (String rpcName : sortedRpcNames) {
      GapicMetadata.MethodList methodList =
          GapicMetadata.MethodList.newBuilder()
              .addAllMethods(grpcRpcToJavaMethodNames.get(rpcName))
              .build();
      serviceClientProtoBuilder.putRpcs(rpcName, methodList);
    }

    GapicMetadata.ServiceForTransport.Builder grpcServiceClient =
        GapicMetadata.ServiceForTransport.newBuilder()
            .putClients("grpc", serviceClientProtoBuilder.build());

    if (service.hasApiVersion()) {
      grpcServiceClient.setApiVersion(service.apiVersion());
    }

    metadataBuilder = metadataBuilder.putServices(service.name(), grpcServiceClient.build());
    context.updateGapicMetadata(metadataBuilder.build());
  }
}
