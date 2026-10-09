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
import com.google.api.gax.core.GaxProperties;
import com.google.api.gax.httpjson.ApiMethodDescriptor;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.HttpJsonCallSettings;
import com.google.api.gax.httpjson.HttpJsonCallableFactory;
import com.google.api.gax.httpjson.HttpJsonTransportChannel;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.api.gax.httpjson.ProtoMessageRequestFormatter;
import com.google.api.gax.httpjson.ProtoMessageResponseParser;
import com.google.api.gax.httpjson.ProtoRestSerializer;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
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
import com.google.api.generator.engine.ast.IfStatement;
import com.google.api.generator.engine.ast.JavaDocComment;
import com.google.api.generator.engine.ast.MethodDefinition;
import com.google.api.generator.engine.ast.MethodInvocationExpr;
import com.google.api.generator.engine.ast.NewObjectExpr;
import com.google.api.generator.engine.ast.ReturnExpr;
import com.google.api.generator.engine.ast.ScopeNode;
import com.google.api.generator.engine.ast.Statement;
import com.google.api.generator.engine.ast.StringObjectValue;
import com.google.api.generator.engine.ast.ThisObjectValue;
import com.google.api.generator.engine.ast.TypeNode;
import com.google.api.generator.engine.ast.ValueExpr;
import com.google.api.generator.engine.ast.Variable;
import com.google.api.generator.engine.ast.VariableExpr;
import com.google.api.generator.gapic.composer.comment.CommentComposer;
import com.google.api.generator.gapic.composer.common.BackgroundResourceMethodComposer;
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
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;

@NullMarked
public class HttpJsonServiceResumableUploadStubClassComposer implements ClassComposer {
  private static final HttpJsonServiceResumableUploadStubClassComposer INSTANCE =
      new HttpJsonServiceResumableUploadStubClassComposer();

  private static final Statement EMPTY_LINE_STATEMENT = EmptyLineStatement.create();

  /** Path prefix prepended to the start URI of resumable upload RPCs. */
  private static final String RESUMABLE_UPLOAD_PATH_PREFIX = "resumable/upload";

  private static final List<Class<?>> STATIC_TYPES =
      Arrays.asList(
          ApiClientHeaderProvider.class,
          ApiMethodDescriptor.class,
          BackgroundResource.class,
          BackgroundResourceAggregation.class,
          BetaApi.class,
          ClientContext.class,
          GaxHttpJsonProperties.class,
          GaxProperties.class,
          Generated.class,
          HashMap.class,
          HttpJsonCallSettings.class,
          HttpJsonCallableFactory.class,
          HttpJsonTransportChannel.class,
          InstantiatingHttpJsonChannelProvider.class,
          InternalApi.class,
          InterruptedException.class,
          IOException.class,
          List.class,
          NullMarked.class,
          ProtoMessageRequestFormatter.class,
          ProtoMessageResponseParser.class,
          ProtoRestSerializer.class,
          ResumableUploadCallable.class,
          TimeUnit.class,
          TypeRegistry.class);

  private static final TypeStore FIXED_TYPESTORE = new TypeStore(STATIC_TYPES);

  private static final String BUILD_METHOD_NAME = "build";
  private static final String NEW_BUILDER_METHOD_NAME = "newBuilder";

  private static final String DERIVE_CLIENT_CONTEXT_METHOD_NAME = "deriveHttpJsonClientContext";
  private static final String STUB_SETTINGS_PATTERN = "%sStubSettings";
  private static final String RESUMABLE_UPLOAD_STUB_PATTERN = "HttpJson%sResumableUploadStub";

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
    String className = String.format(RESUMABLE_UPLOAD_STUB_PATTERN, service.name());
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
                                .setMethodName(NEW_BUILDER_METHOD_NAME)
                                .build())
                        .setMethodName(BUILD_METHOD_NAME)
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
    methodDefinitions.addAll(createCallableGetterMethods(callableClassMembers));
    methodDefinitions.addAll(createBackgroundResourceMethods(backgroundResourcesVarExpr));

    ClassDefinition classDef =
        ClassDefinition.builder()
            .setPackageString(pakkage)
            .setHeaderCommentStatements(createClassHeaderComments(service))
            .setAnnotations(createClassAnnotations(service))
            .setScope(ScopeNode.LOCAL)
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
    TypeNode clientContextType = FIXED_TYPESTORE.get(ClientContext.class.getSimpleName());
    TypeNode transportChannelType =
        FIXED_TYPESTORE.get(HttpJsonTransportChannel.class.getSimpleName());
    TypeNode stubSettingsType = typeStore.get(String.format(STUB_SETTINGS_PATTERN, service.name()));

    VariableExpr settingsVarExpr =
        VariableExpr.withVariable(
            Variable.builder().setName("settings").setType(stubSettingsType).build());

    Expr getTransportNameExpr =
        MethodInvocationExpr.builder()
            .setExprReferenceExpr(settingsVarExpr)
            .setMethodName("getTransportChannelProvider")
            .build();
    getTransportNameExpr =
        MethodInvocationExpr.builder()
            .setExprReferenceExpr(getTransportNameExpr)
            .setMethodName("getTransportName")
            .build();

    Expr isHttpJsonConditionExpr =
        MethodInvocationExpr.builder()
            .setExprReferenceExpr(getTransportNameExpr)
            .setMethodName("equals")
            .setArguments(
                MethodInvocationExpr.builder()
                    .setStaticReferenceType(transportChannelType)
                    .setMethodName("getHttpJsonTransportName")
                    .build())
            .setReturnType(TypeNode.BOOLEAN)
            .build();

    Statement createHttpJsonContextStmt =
        IfStatement.builder()
            .setConditionExpr(isHttpJsonConditionExpr)
            .setBody(
                Arrays.asList(
                    ExprStatement.withExpr(
                        ReturnExpr.withExpr(
                            NewObjectExpr.builder()
                                .setType(thisClassType)
                                .setArguments(
                                    Arrays.asList(
                                        MethodInvocationExpr.builder()
                                            .setStaticReferenceType(clientContextType)
                                            .setMethodName("create")
                                            .setArguments(Arrays.asList(settingsVarExpr))
                                            .setReturnType(clientContextType)
                                            .build(),
                                        settingsVarExpr))
                                .build()))))
            .build();

    MethodDefinition createMethod =
        MethodDefinition.builder()
            .setScope(ScopeNode.PUBLIC)
            .setIsStatic(true)
            .setReturnType(thisClassType)
            .setName("create")
            .setThrowsExceptions(
                Arrays.asList(FIXED_TYPESTORE.get(IOException.class.getSimpleName())))
            .setArguments(Arrays.asList(settingsVarExpr.toBuilder().setIsDecl(true).build()))
            .setBody(Arrays.asList(createHttpJsonContextStmt))
            .setReturnExpr(
                NewObjectExpr.builder()
                    .setType(thisClassType)
                    .setArguments(
                        Arrays.asList(
                            MethodInvocationExpr.builder()
                                .setMethodName(DERIVE_CLIENT_CONTEXT_METHOD_NAME)
                                .setArguments(Arrays.asList(settingsVarExpr))
                                .setReturnType(clientContextType)
                                .build(),
                            settingsVarExpr))
                    .build())
            .build();

    return Arrays.asList(
        createMethod,
        createDeriveHttpJsonClientContextMethod(service, stubSettingsType, settingsVarExpr));
  }

  private static MethodDefinition createDeriveHttpJsonClientContextMethod(
      Service service, TypeNode stubSettingsType, VariableExpr settingsVarExpr) {
    TypeNode clientContextType = FIXED_TYPESTORE.get(ClientContext.class.getSimpleName());

    TypeNode gaxHttpJsonPropertiesType =
        FIXED_TYPESTORE.get(GaxHttpJsonProperties.class.getSimpleName());
    Expr internalHeadersExpr =
        MethodInvocationExpr.builder()
            .setStaticReferenceType(
                FIXED_TYPESTORE.get(ApiClientHeaderProvider.class.getSimpleName()))
            .setMethodName(NEW_BUILDER_METHOD_NAME)
            .build();
    internalHeadersExpr =
        MethodInvocationExpr.builder()
            .setExprReferenceExpr(internalHeadersExpr)
            .setMethodName("setGeneratedLibToken")
            .setArguments(
                ValueExpr.withValue(StringObjectValue.withValue("gapic")),
                MethodInvocationExpr.builder()
                    .setStaticReferenceType(
                        FIXED_TYPESTORE.get(GaxProperties.class.getSimpleName()))
                    .setMethodName("getLibraryVersion")
                    .setArguments(
                        VariableExpr.builder()
                            .setVariable(
                                Variable.builder()
                                    .setType(TypeNode.CLASS_OBJECT)
                                    .setName("class")
                                    .build())
                            .setStaticReferenceType(stubSettingsType)
                            .build())
                    .build())
            .build();
    internalHeadersExpr =
        MethodInvocationExpr.builder()
            .setExprReferenceExpr(internalHeadersExpr)
            .setMethodName("setTransportToken")
            .setArguments(
                MethodInvocationExpr.builder()
                    .setStaticReferenceType(gaxHttpJsonPropertiesType)
                    .setMethodName("getHttpJsonTokenName")
                    .build(),
                MethodInvocationExpr.builder()
                    .setStaticReferenceType(gaxHttpJsonPropertiesType)
                    .setMethodName("getHttpJsonVersion")
                    .build())
            .build();
    if (service.hasApiVersion()) {
      internalHeadersExpr =
          MethodInvocationExpr.builder()
              .setExprReferenceExpr(internalHeadersExpr)
              .setMethodName("setApiVersionToken")
              .setArguments(ValueExpr.withValue(StringObjectValue.withValue(service.apiVersion())))
              .build();
    }
    internalHeadersExpr =
        MethodInvocationExpr.builder()
            .setExprReferenceExpr(internalHeadersExpr)
            .setMethodName(BUILD_METHOD_NAME)
            .build();

    Expr channelProviderExpr =
        MethodInvocationExpr.builder()
            .setStaticReferenceType(
                FIXED_TYPESTORE.get(InstantiatingHttpJsonChannelProvider.class.getSimpleName()))
            .setMethodName(NEW_BUILDER_METHOD_NAME)
            .build();
    channelProviderExpr =
        MethodInvocationExpr.builder()
            .setExprReferenceExpr(channelProviderExpr)
            .setMethodName(BUILD_METHOD_NAME)
            .build();

    Expr settingsBuilderExpr =
        MethodInvocationExpr.builder()
            .setExprReferenceExpr(settingsVarExpr)
            .setMethodName("toBuilder")
            .build();
    settingsBuilderExpr =
        MethodInvocationExpr.builder()
            .setExprReferenceExpr(settingsBuilderExpr)
            .setMethodName("setHttpJsonInternalHeaderProvider")
            .setArguments(internalHeadersExpr)
            .build();
    settingsBuilderExpr =
        MethodInvocationExpr.builder()
            .setExprReferenceExpr(settingsBuilderExpr)
            .setMethodName("setTransportChannelProvider")
            .setArguments(channelProviderExpr)
            .build();
    settingsBuilderExpr =
        MethodInvocationExpr.builder()
            .setExprReferenceExpr(settingsBuilderExpr)
            .setMethodName(BUILD_METHOD_NAME)
            .setReturnType(stubSettingsType)
            .build();

    Expr returnExpr =
        MethodInvocationExpr.builder()
            .setStaticReferenceType(clientContextType)
            .setMethodName("create")
            .setArguments(settingsBuilderExpr)
            .setReturnType(clientContextType)
            .build();

    return MethodDefinition.builder()
        .setScope(ScopeNode.PRIVATE)
        .setIsStatic(true)
        .setReturnType(clientContextType)
        .setName(DERIVE_CLIENT_CONTEXT_METHOD_NAME)
        .setThrowsExceptions(Arrays.asList(FIXED_TYPESTORE.get(IOException.class.getSimpleName())))
        .setArguments(Arrays.asList(settingsVarExpr.toBuilder().setIsDecl(true).build()))
        .setReturnExpr(returnExpr)
        .build();
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
    TypeNode clientContextType = FIXED_TYPESTORE.get(ClientContext.class.getSimpleName());
    TypeNode stubSettingsType = typeStore.get(String.format(STUB_SETTINGS_PATTERN, service.name()));

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
              .setMethodName(NEW_BUILDER_METHOD_NAME)
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
              .setMethodName(BUILD_METHOD_NAME)
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

    return Arrays.asList(
        MethodDefinition.constructorBuilder()
            .setScope(ScopeNode.PRIVATE)
            .setReturnType(thisClassType)
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
    return HttpJsonDescriptorComposer.createMethodDescriptorVariableDecl(
        service,
        protoMethod,
        methodDescriptorVarExpr,
        restNumericEnumsEnabled,
        RESUMABLE_UPLOAD_PATH_PREFIX);
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
    return BackgroundResourceMethodComposer.createBackgroundResourceMethods(
        backgroundResourcesVarExpr);
  }

  private static List<AnnotationNode> createClassAnnotations(Service service) {
    List<AnnotationNode> annotations = new ArrayList<>();
    annotations.add(
        AnnotationNode.builder()
            .setType(FIXED_TYPESTORE.get(Generated.class.getSimpleName()))
            .setDescription("by gapic-generator-java")
            .build());
    annotations.add(
        AnnotationNode.withType(FIXED_TYPESTORE.get(InternalApi.class.getSimpleName())));
    annotations.add(AnnotationNode.withType(FIXED_TYPESTORE.get(NullMarked.class.getSimpleName())));
    if (!PackageChecker.isGaApi(service.pakkage())) {
      annotations.add(AnnotationNode.withType(FIXED_TYPESTORE.get(BetaApi.class.getSimpleName())));
    }
    if (service.isDeprecated()) {
      annotations.add(AnnotationNode.withType(TypeNode.DEPRECATED));
    }
    return annotations;
  }

  private static List<CommentStatement> createClassHeaderComments(Service service) {
    JavaDocComment.Builder javaDocBuilder = JavaDocComment.builder();
    return Arrays.asList(
        CommentComposer.AUTO_GENERATED_CLASS_COMMENT,
        CommentStatement.withComment(
            javaDocBuilder
                .addComment(
                    String.format(
                        "REST stub transport for the resumable upload methods of %s.",
                        service.name()))
                .addParagraph(
                    "This class is for advanced usage and reflects the underlying API directly.")
                .build()));
  }

  private static TypeStore createDynamicTypes(
      Service service, String pakkage, List<Method> resumableUploadMethods) {
    TypeStore typeStore = new TypeStore(STATIC_TYPES);
    typeStore.put(pakkage, String.format(RESUMABLE_UPLOAD_STUB_PATTERN, service.name()));
    typeStore.put(pakkage, String.format(STUB_SETTINGS_PATTERN, service.name()));
    for (Method method : resumableUploadMethods) {
      typeStore.put(
          method.inputType().reference().pakkage(), method.inputType().reference().name());
      typeStore.put(
          method.outputType().reference().pakkage(), method.outputType().reference().name());
    }
    return typeStore;
  }
}
