// Copyright 2026 Google LLC
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

import com.google.api.core.BetaApi;
import com.google.api.core.InternalApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.httpjson.ApiMethodDescriptor;
import com.google.api.gax.httpjson.HttpJsonCallSettings;
import com.google.api.gax.httpjson.HttpJsonCallableFactory;
import com.google.api.gax.httpjson.ProtoMessageRequestFormatter;
import com.google.api.gax.httpjson.ProtoMessageResponseParser;
import com.google.api.gax.httpjson.ProtoRestSerializer;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ResumableUploadCallable;
import com.google.api.generator.engine.ast.AnnotationNode;
import com.google.api.generator.engine.ast.AssignmentExpr;
import com.google.api.generator.engine.ast.ClassDefinition;
import com.google.api.generator.engine.ast.CommentStatement;
import com.google.api.generator.engine.ast.ConcreteReference;
import com.google.api.generator.engine.ast.EmptyLineStatement;
import com.google.api.generator.engine.ast.Expr;
import com.google.api.generator.engine.ast.ExprStatement;
import com.google.api.generator.engine.ast.JavaDocComment;
import com.google.api.generator.engine.ast.MethodDefinition;
import com.google.api.generator.engine.ast.MethodInvocationExpr;
import com.google.api.generator.engine.ast.NewObjectExpr;
import com.google.api.generator.engine.ast.ScopeNode;
import com.google.api.generator.engine.ast.Statement;
import com.google.api.generator.engine.ast.StringObjectValue;
import com.google.api.generator.engine.ast.ThisObjectValue;
import com.google.api.generator.engine.ast.ThrowExpr;
import com.google.api.generator.engine.ast.TryCatchStatement;
import com.google.api.generator.engine.ast.TypeNode;
import com.google.api.generator.engine.ast.ValueExpr;
import com.google.api.generator.engine.ast.Variable;
import com.google.api.generator.engine.ast.VariableExpr;
import com.google.api.generator.gapic.composer.common.ClassComposer;
import com.google.api.generator.gapic.composer.store.TypeStore;
import com.google.api.generator.gapic.composer.utils.PackageChecker;
import com.google.api.generator.gapic.model.GapicClass;
import com.google.api.generator.gapic.model.GapicClass.Kind;
import com.google.api.generator.gapic.model.GapicContext;
import com.google.api.generator.gapic.model.Method;
import com.google.api.generator.gapic.model.Service;
import com.google.api.generator.gapic.utils.JavaStyle;
import com.google.protobuf.TypeRegistry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;

@NullMarked
public class HttpJsonServiceResumableUploadStubClassComposer implements ClassComposer {
  private static final HttpJsonServiceResumableUploadStubClassComposer INSTANCE =
      new HttpJsonServiceResumableUploadStubClassComposer();

  private static final Statement EMPTY_LINE_STATEMENT = EmptyLineStatement.create();
  private static final String RESUMABLE_UPLOAD_PATH_PREFIX = "resumable/upload";

  private static final List<Class<?>> STATIC_TYPES =
      Arrays.asList(
          ApiMethodDescriptor.class,
          ArrayList.class,
          BackgroundResource.class,
          BackgroundResourceAggregation.class,
          BetaApi.class,
          ClientContext.class,
          Generated.class,
          HttpJsonCallSettings.class,
          HttpJsonCallableFactory.class,
          InternalApi.class,
          InterruptedException.class,
          List.class,
          NullMarked.class,
          ProtoMessageRequestFormatter.class,
          ProtoMessageResponseParser.class,
          ProtoRestSerializer.class,
          ResumableUploadCallable.class,
          TimeUnit.class,
          TypeRegistry.class);

  private static final TypeStore FIXED_TYPESTORE = new TypeStore(STATIC_TYPES);

  protected HttpJsonServiceResumableUploadStubClassComposer() {}

  public static HttpJsonServiceResumableUploadStubClassComposer instance() {
    return INSTANCE;
  }

  @Override
  public GapicClass generate(GapicContext context, Service service) {
    List<Method> resumableUploadMethods =
        service.methods().stream().filter(Method::isResumableUpload).collect(Collectors.toList());
    if (resumableUploadMethods.isEmpty()) {
      return GapicClass.createNonGeneratedGapicClass();
    }

    String pakkage = service.pakkage() + ".stub";
    String className = String.format("HttpJson%sResumableUploadStub", service.name());
    TypeStore typeStore = createDynamicTypes(service, pakkage, resumableUploadMethods);

    // Member: typeRegistry
    VariableExpr typeRegistryVarExpr =
        VariableExpr.builder()
            .setVariable(
                Variable.builder()
                    .setName("typeRegistry")
                    .setType(FIXED_TYPESTORE.get(TypeRegistry.class.getSimpleName()))
                    .build())
            .build();

    Statement typeRegistryDecl =
        ExprStatement.withExpr(
            AssignmentExpr.builder()
                .setVariableExpr(
                    typeRegistryVarExpr.toBuilder()
                        .setIsDecl(true)
                        .setScope(ScopeNode.PRIVATE)
                        .setIsStatic(true)
                        .setIsFinal(true)
                        .build())
                .setValueExpr(
                    MethodInvocationExpr.builder()
                        .setExprReferenceExpr(
                            MethodInvocationExpr.builder()
                                .setStaticReferenceType(
                                    FIXED_TYPESTORE.get(TypeRegistry.class.getSimpleName()))
                                .setMethodName("newBuilder")
                                .build())
                        .setMethodName("build")
                        .setReturnType(FIXED_TYPESTORE.get(TypeRegistry.class.getSimpleName()))
                        .build())
                .build());

    // Method descriptors
    Map<String, VariableExpr> protoMethodNameToDescriptorVarExprs = new LinkedHashMap<>();
    List<Statement> methodDescriptorDecls = new ArrayList<>();
    for (Method method : resumableUploadMethods) {
      String javaStyleName = JavaStyle.toLowerCamelCase(method.name());
      VariableExpr descriptorVarExpr =
          VariableExpr.withVariable(
              Variable.builder()
                  .setName(String.format("%sMethodDescriptor", javaStyleName))
                  .setType(
                      TypeNode.withReference(
                          ConcreteReference.builder()
                              .setClazz(ApiMethodDescriptor.class)
                              .setGenerics(
                                  Arrays.asList(
                                      method.inputType().reference(),
                                      method.outputType().reference()))
                              .build()))
                  .build());
      protoMethodNameToDescriptorVarExprs.put(method.name(), descriptorVarExpr);
      methodDescriptorDecls.add(
          createMethodDescriptorVariableDecl(
              service, method, descriptorVarExpr, context.restNumericEnumsEnabled()));
    }

    // Member: backgroundResources
    VariableExpr backgroundResourcesVarExpr =
        VariableExpr.withVariable(
            Variable.builder()
                .setName("backgroundResources")
                .setType(FIXED_TYPESTORE.get(BackgroundResource.class.getSimpleName()))
                .build());

    // Members: callables
    Map<String, VariableExpr> callableClassMembers = new LinkedHashMap<>();
    for (Method method : resumableUploadMethods) {
      String javaStyleName = JavaStyle.toLowerCamelCase(method.name());
      String callableName = String.format("%sCallable", javaStyleName);
      TypeNode callableType =
          TypeNode.withReference(
              ConcreteReference.builder()
                  .setClazz(ResumableUploadCallable.class)
                  .setGenerics(
                      Arrays.asList(
                          method.inputType().reference(), method.outputType().reference()))
                  .build());
      callableClassMembers.put(
          callableName,
          VariableExpr.withVariable(
              Variable.builder().setName(callableName).setType(callableType).build()));
    }

    // Class statements
    List<Statement> classStatements = new ArrayList<>();
    classStatements.add(typeRegistryDecl);
    classStatements.add(EMPTY_LINE_STATEMENT);
    classStatements.addAll(methodDescriptorDecls);
    classStatements.add(EMPTY_LINE_STATEMENT);
    classStatements.add(
        ExprStatement.withExpr(
            backgroundResourcesVarExpr.toBuilder()
                .setIsDecl(true)
                .setScope(ScopeNode.PRIVATE)
                .setIsFinal(true)
                .build()));
    for (VariableExpr callableVar : callableClassMembers.values()) {
      classStatements.add(
          ExprStatement.withExpr(
              callableVar.toBuilder()
                  .setIsDecl(true)
                  .setScope(ScopeNode.PRIVATE)
                  .setIsFinal(true)
                  .build()));
    }

    // Methods
    List<MethodDefinition> methodDefinitions = new ArrayList<>();
    methodDefinitions.addAll(createStaticCreatorMethods(service, typeStore, className));
    methodDefinitions.addAll(
        createConstructorMethods(
            service,
            typeStore,
            className,
            backgroundResourcesVarExpr,
            callableClassMembers,
            protoMethodNameToDescriptorVarExprs,
            resumableUploadMethods));
    methodDefinitions.add(createGetMethodDescriptorsMethod(protoMethodNameToDescriptorVarExprs));
    methodDefinitions.addAll(createCallableGetterMethods(callableClassMembers));
    methodDefinitions.addAll(createBackgroundResourceMethods(backgroundResourcesVarExpr));

    ClassDefinition classDef =
        ClassDefinition.builder()
            .setPackageString(pakkage)
            .setHeaderCommentStatements(createClassHeaderComments(service))
            .setAnnotations(createClassAnnotations(service))
            .setScope(ScopeNode.PUBLIC)
            .setName(className)
            .setImplementsTypes(
                Arrays.asList(FIXED_TYPESTORE.get(BackgroundResource.class.getSimpleName())))
            .setMethods(methodDefinitions)
            .setStatements(classStatements)
            .build();

    return GapicClass.create(Kind.STUB, classDef);
  }

  private static List<MethodDefinition> createStaticCreatorMethods(
      Service service, TypeStore typeStore, String className) {
    TypeNode thisClassType = typeStore.get(className);
    TypeNode clientContextType = FIXED_TYPESTORE.get("ClientContext");
    TypeNode stubSettingsType = typeStore.get(String.format("%sStubSettings", service.name()));

    VariableExpr clientContextVarExpr =
        VariableExpr.withVariable(
            Variable.builder().setName("clientContext").setType(clientContextType).build());
    VariableExpr settingsVarExpr =
        VariableExpr.withVariable(
            Variable.builder().setName("settings").setType(stubSettingsType).build());

    return Arrays.asList(
        MethodDefinition.builder()
            .setScope(ScopeNode.PUBLIC)
            .setIsStatic(true)
            .setReturnType(thisClassType)
            .setName("create")
            .setArguments(
                Arrays.asList(
                    clientContextVarExpr.toBuilder().setIsDecl(true).build(),
                    settingsVarExpr.toBuilder().setIsDecl(true).build()))
            .setReturnExpr(
                NewObjectExpr.builder()
                    .setType(thisClassType)
                    .setArguments(Arrays.asList(clientContextVarExpr, settingsVarExpr))
                    .build())
            .build());
  }

  private static List<MethodDefinition> createConstructorMethods(
      Service service,
      TypeStore typeStore,
      String className,
      VariableExpr backgroundResourcesVarExpr,
      Map<String, VariableExpr> callableClassMembers,
      Map<String, VariableExpr> protoMethodNameToDescriptorVarExprs,
      List<Method> resumableUploadMethods) {
    TypeNode thisClassType = typeStore.get(className);
    TypeNode clientContextType = FIXED_TYPESTORE.get("ClientContext");
    TypeNode stubSettingsType = typeStore.get(String.format("%sStubSettings", service.name()));

    VariableExpr clientContextVarExpr =
        VariableExpr.withVariable(
            Variable.builder().setName("clientContext").setType(clientContextType).build());
    VariableExpr settingsVarExpr =
        VariableExpr.withVariable(
            Variable.builder().setName("settings").setType(stubSettingsType).build());

    Expr thisExpr = ValueExpr.withValue(ThisObjectValue.withType(thisClassType));
    List<Statement> ctorStatements = new ArrayList<>();

    for (Method method : resumableUploadMethods) {
      String javaStyleName = JavaStyle.toLowerCamelCase(method.name());
      VariableExpr descriptorVarExpr = protoMethodNameToDescriptorVarExprs.get(method.name());
      VariableExpr callableVarExpr =
          callableClassMembers.get(String.format("%sCallable", javaStyleName));

      TypeNode httpJsonCallSettingsType =
          TypeNode.withReference(
              ConcreteReference.builder()
                  .setClazz(HttpJsonCallSettings.class)
                  .setGenerics(
                      Arrays.asList(
                          method.inputType().reference(), method.outputType().reference()))
                  .build());

      VariableExpr transportSettingsVarExpr =
          VariableExpr.builder()
              .setVariable(
                  Variable.builder()
                      .setName(String.format("%sTransportSettings", javaStyleName))
                      .setType(httpJsonCallSettingsType)
                      .build())
              .setIsDecl(true)
              .build();

      MethodInvocationExpr callSettingsBuilderExpr =
          MethodInvocationExpr.builder()
              .setStaticReferenceType(
                  FIXED_TYPESTORE.get(HttpJsonCallSettings.class.getSimpleName()))
              .setGenerics(
                  Arrays.asList(method.inputType().reference(), method.outputType().reference()))
              .setMethodName("newBuilder")
              .build();
      callSettingsBuilderExpr =
          MethodInvocationExpr.builder()
              .setExprReferenceExpr(callSettingsBuilderExpr)
              .setMethodName("setMethodDescriptor")
              .setArguments(Arrays.asList(descriptorVarExpr))
              .build();
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
      callSettingsBuilderExpr =
          MethodInvocationExpr.builder()
              .setExprReferenceExpr(callSettingsBuilderExpr)
              .setMethodName("build")
              .setReturnType(httpJsonCallSettingsType)
              .build();

      ctorStatements.add(
          ExprStatement.withExpr(
              AssignmentExpr.builder()
                  .setVariableExpr(transportSettingsVarExpr)
                  .setValueExpr(callSettingsBuilderExpr)
                  .build()));

      MethodInvocationExpr getSettingsExpr =
          MethodInvocationExpr.builder()
              .setExprReferenceExpr(settingsVarExpr)
              .setMethodName(String.format("%sSettings", javaStyleName))
              .build();

      MethodInvocationExpr createCallableExpr =
          MethodInvocationExpr.builder()
              .setStaticReferenceType(
                  FIXED_TYPESTORE.get(HttpJsonCallableFactory.class.getSimpleName()))
              .setMethodName("createResumableUploadCallable")
              .setArguments(
                  Arrays.asList(
                      transportSettingsVarExpr.toBuilder().setIsDecl(false).build(),
                      getSettingsExpr,
                      clientContextVarExpr))
              .setReturnType(callableVarExpr.type())
              .build();

      ctorStatements.add(
          ExprStatement.withExpr(
              AssignmentExpr.builder()
                  .setVariableExpr(
                      callableVarExpr.toBuilder().setExprReferenceExpr(thisExpr).build())
                  .setValueExpr(createCallableExpr)
                  .build()));
      ctorStatements.add(EMPTY_LINE_STATEMENT);
    }

    MethodInvocationExpr getBackgroundResourcesExpr =
        MethodInvocationExpr.builder()
            .setExprReferenceExpr(clientContextVarExpr)
            .setMethodName("getBackgroundResources")
            .build();

    Expr newBackgroundResourceExpr =
        NewObjectExpr.builder()
            .setType(FIXED_TYPESTORE.get(BackgroundResourceAggregation.class.getSimpleName()))
            .setArguments(Arrays.asList(getBackgroundResourcesExpr))
            .build();

    ctorStatements.add(
        ExprStatement.withExpr(
            AssignmentExpr.builder()
                .setVariableExpr(
                    backgroundResourcesVarExpr.toBuilder().setExprReferenceExpr(thisExpr).build())
                .setValueExpr(newBackgroundResourceExpr)
                .build()));

    CommentStatement ctorComment =
        CommentStatement.withComment(
            JavaDocComment.withComment(
                String.format(
                    "Constructs an instance of %s, using the given settings. This is protected so"
                        + " that it is easy to make a subclass, but otherwise, the static factory"
                        + " methods should be preferred.",
                    className)));

    return Arrays.asList(
        MethodDefinition.constructorBuilder()
            .setScope(ScopeNode.PROTECTED)
            .setReturnType(thisClassType)
            .setHeaderCommentStatements(Arrays.asList(ctorComment))
            .setArguments(
                Arrays.asList(
                    clientContextVarExpr.toBuilder().setIsDecl(true).build(),
                    settingsVarExpr.toBuilder().setIsDecl(true).build()))
            .setBody(ctorStatements)
            .build());
  }

  private static Statement createMethodDescriptorVariableDecl(
      Service service,
      Method protoMethod,
      VariableExpr methodDescriptorVarExpr,
      boolean restNumericEnumsEnabled) {
    MethodInvocationExpr expr =
        MethodInvocationExpr.builder()
            .setMethodName("newBuilder")
            .setStaticReferenceType(FIXED_TYPESTORE.get(ApiMethodDescriptor.class.getSimpleName()))
            .setGenerics(methodDescriptorVarExpr.variable().type().reference().generics())
            .build();

    BiFunction<String, List<Expr>, Function<MethodInvocationExpr, MethodInvocationExpr>>
        methodMaker = HttpJsonServiceStubClassComposer.getMethodMaker();

    String codeMethodArgName =
        HttpJsonServiceStubClassComposer.getProtoRpcName(service, protoMethod);
    expr =
        methodMaker
            .apply(
                "setFullMethodName",
                Arrays.asList(ValueExpr.withValue(StringObjectValue.withValue(codeMethodArgName))))
            .apply(expr);

    expr =
        methodMaker
            .apply(
                "setHttpMethod",
                HttpJsonServiceStubClassComposer.getHttpMethodTypeExpr(protoMethod))
            .apply(expr);
    expr =
        methodMaker
            .apply("setType", HttpJsonServiceStubClassComposer.getMethodTypeExpr(protoMethod))
            .apply(expr);
    expr =
        methodMaker
            .apply(
                "setRequestFormatter",
                HttpJsonServiceStubClassComposer.getRequestFormatterExpr(
                    protoMethod, restNumericEnumsEnabled, RESUMABLE_UPLOAD_PATH_PREFIX))
            .apply(expr);
    expr =
        methodMaker
            .apply(
                "setResponseParser",
                HttpJsonServiceStubClassComposer.setResponseParserExpr(protoMethod))
            .apply(expr);

    expr =
        MethodInvocationExpr.builder()
            .setMethodName("build")
            .setExprReferenceExpr(expr)
            .setReturnType(methodDescriptorVarExpr.type())
            .build();

    return ExprStatement.withExpr(
        AssignmentExpr.builder()
            .setVariableExpr(
                methodDescriptorVarExpr.toBuilder()
                    .setIsDecl(true)
                    .setScope(ScopeNode.PRIVATE)
                    .setIsStatic(true)
                    .setIsFinal(true)
                    .build())
            .setValueExpr(expr)
            .build());
  }

  private static MethodDefinition createGetMethodDescriptorsMethod(
      Map<String, VariableExpr> protoMethodNameToDescriptorVarExprs) {
    VariableExpr methodDescriptorsVarExpr =
        VariableExpr.withVariable(
            Variable.builder()
                .setType(
                    TypeNode.withReference(
                        ConcreteReference.builder()
                            .setClazz(List.class)
                            .setGenerics(
                                Arrays.asList(
                                    FIXED_TYPESTORE.get("ApiMethodDescriptor").reference()))
                            .build()))
                .setName("methodDescriptors")
                .build());

    List<Expr> bodyExprs = new ArrayList<>();
    bodyExprs.add(
        AssignmentExpr.builder()
            .setVariableExpr(methodDescriptorsVarExpr.toBuilder().setIsDecl(true).build())
            .setValueExpr(
                NewObjectExpr.builder()
                    .setType(FIXED_TYPESTORE.get("ArrayList"))
                    .setIsGeneric(true)
                    .build())
            .build());

    for (VariableExpr methodDescriptorVarExpr : protoMethodNameToDescriptorVarExprs.values()) {
      bodyExprs.add(
          MethodInvocationExpr.builder()
              .setExprReferenceExpr(methodDescriptorsVarExpr)
              .setMethodName("add")
              .setArguments(methodDescriptorVarExpr)
              .build());
    }

    return MethodDefinition.builder()
        .setScope(ScopeNode.PUBLIC)
        .setIsStatic(true)
        .setReturnType(methodDescriptorsVarExpr.type())
        .setReturnExpr(methodDescriptorsVarExpr)
        .setAnnotations(Arrays.asList(AnnotationNode.withType(FIXED_TYPESTORE.get("InternalApi"))))
        .setName("getMethodDescriptors")
        .setBody(bodyExprs.stream().map(ExprStatement::withExpr).collect(Collectors.toList()))
        .build();
  }

  private static List<MethodDefinition> createCallableGetterMethods(
      Map<String, VariableExpr> callableClassMembers) {
    return callableClassMembers.entrySet().stream()
        .map(
            e ->
                MethodDefinition.builder()
                    .setScope(ScopeNode.PUBLIC)
                    .setReturnType(e.getValue().type())
                    .setName(e.getKey())
                    .setReturnExpr(e.getValue())
                    .build())
        .collect(Collectors.toList());
  }

  private static List<MethodDefinition> createBackgroundResourceMethods(
      VariableExpr backgroundResourcesVarExpr) {
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

  private static List<AnnotationNode> createClassAnnotations(Service service) {
    List<AnnotationNode> annotations = new ArrayList<>();
    annotations.add(
        AnnotationNode.builder()
            .setType(FIXED_TYPESTORE.get("Generated"))
            .setDescription("by gapic-generator-java")
            .build());
    annotations.add(AnnotationNode.withType(FIXED_TYPESTORE.get("InternalApi")));
    annotations.add(AnnotationNode.withType(FIXED_TYPESTORE.get("NullMarked")));
    if (!PackageChecker.isGaApi(service.pakkage())) {
      annotations.add(AnnotationNode.withType(FIXED_TYPESTORE.get("BetaApi")));
    }
    if (service.isDeprecated()) {
      annotations.add(AnnotationNode.withType(TypeNode.DEPRECATED));
    }
    return annotations;
  }

  private static List<CommentStatement> createClassHeaderComments(Service service) {
    return Arrays.asList(
        CommentStatement.withComment(
            JavaDocComment.withComment(
                String.format(
                    "REST stub transport for the resumable upload methods of %s.\n\n"
                        + "<p>This class is for advanced usage and reflects the underlying API"
                        + " directly.",
                    service.name()))));
  }

  private static TypeStore createDynamicTypes(
      Service service, String pakkage, List<Method> resumableUploadMethods) {
    TypeStore typeStore = new TypeStore(STATIC_TYPES);
    typeStore.put(pakkage, String.format("HttpJson%sResumableUploadStub", service.name()));
    typeStore.put(pakkage, String.format("%sStubSettings", service.name()));
    for (Method method : resumableUploadMethods) {
      typeStore.put(
          method.inputType().reference().pakkage(), method.inputType().reference().name());
      typeStore.put(
          method.outputType().reference().pakkage(), method.outputType().reference().name());
    }
    return typeStore;
  }
}
