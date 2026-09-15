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
import com.google.api.gax.httpjson.HttpJsonCallContext;
import com.google.api.gax.httpjson.HttpJsonCallSettings;
import com.google.api.gax.httpjson.HttpJsonCallableFactory;
import com.google.api.gax.httpjson.HttpJsonTransportChannel;
import com.google.api.gax.httpjson.ManagedHttpJsonChannel;
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
import com.google.api.generator.engine.ast.LambdaExpr;
import com.google.api.generator.engine.ast.MethodDefinition;
import com.google.api.generator.engine.ast.MethodInvocationExpr;
import com.google.api.generator.engine.ast.NewObjectExpr;
import com.google.api.generator.engine.ast.RelationalOperationExpr;
import com.google.api.generator.engine.ast.ScopeNode;
import com.google.api.generator.engine.ast.Statement;
import com.google.api.generator.engine.ast.TernaryExpr;
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
import com.google.common.collect.Maps;
import com.google.protobuf.TypeRegistry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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
  /**
   * The canonical path prefix defined by the Unified Resumable Upload protocol, prepended to the
   * start URI path of every resumable upload RPC (e.g. {@code /v1/media/upload} becomes {@code
   * /resumable/upload/v1/media/upload}).
   *
   * <p>This value is not service-specific: Google Front End routes the {@code /resumable/upload}
   * path to the upload service for every API that enables resumable uploads. Making the prefix
   * configurable via a generator option is planned as future work.
   */
  private static final String RESUMABLE_UPLOAD_PATH_PREFIX = "resumable/upload";

  private static final List<Class<?>> STATIC_TYPES =
      Arrays.asList(
          ApiMethodDescriptor.class,
          ArrayList.class,
          Arrays.class,
          BackgroundResource.class,
          BackgroundResourceAggregation.class,
          BetaApi.class,
          ClientContext.class,
          Collections.class,
          Generated.class,
          HashMap.class,
          HttpJsonCallContext.class,
          HttpJsonCallSettings.class,
          HttpJsonCallableFactory.class,
          HttpJsonTransportChannel.class,
          InternalApi.class,
          InterruptedException.class,
          List.class,
          ManagedHttpJsonChannel.class,
          Maps.class,
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
                  .setName(String.format("%sStartUploadMethodDescriptor", javaStyleName))
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
    TypeNode clientContextType = FIXED_TYPESTORE.get(ClientContext.class.getSimpleName());
    TypeNode stubSettingsType = typeStore.get(String.format(STUB_SETTINGS_PATTERN, service.name()));

    VariableExpr clientContextVarExpr =
        VariableExpr.withVariable(
            Variable.builder().setName("clientContext").setType(clientContextType).build());
    VariableExpr settingsVarExpr =
        VariableExpr.withVariable(
            Variable.builder().setName("settings").setType(stubSettingsType).build());

    MethodDefinition createMethod =
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
            .build();

    return Arrays.asList(
        createMethod,
        createCreateFromMethod(
            thisClassType, stubSettingsType, clientContextVarExpr, settingsVarExpr));
  }

  /**
   * Generates the {@code createFrom(ClientContext, StubSettings)} factory.
   *
   * <p>Resumable uploads always execute over HTTP/JSON, even when the enclosing transport stub uses
   * a different transport, so the upload stub cannot share the caller's transport channel and has
   * to stand up its own. Everything that is transport independent -- credentials, external headers,
   * executor and clock -- is inherited from the given {@link
   * com.google.api.gax.rpc.ClientContext}, so a caller-supplied context is fully honored. Owning
   * this derivation here keeps it out of every transport stub that happens to have an upload RPC.
   */
  private static MethodDefinition createCreateFromMethod(
      TypeNode thisClassType,
      TypeNode stubSettingsType,
      VariableExpr clientContextVarExpr,
      VariableExpr settingsVarExpr) {
    TypeNode clientContextType = FIXED_TYPESTORE.get(ClientContext.class.getSimpleName());
    TypeNode managedChannelType =
        FIXED_TYPESTORE.get(ManagedHttpJsonChannel.class.getSimpleName());
    TypeNode transportChannelType =
        FIXED_TYPESTORE.get(HttpJsonTransportChannel.class.getSimpleName());
    TypeNode callContextType = FIXED_TYPESTORE.get(HttpJsonCallContext.class.getSimpleName());

    MethodInvocationExpr getCredentialsExpr =
        MethodInvocationExpr.builder()
            .setExprReferenceExpr(clientContextVarExpr)
            .setMethodName("getCredentials")
            .setReturnType(TypeNode.OBJECT)
            .build();
    Expr getExecutorExpr =
        MethodInvocationExpr.builder()
            .setExprReferenceExpr(clientContextVarExpr)
            .setMethodName("getExecutor")
            .build();
    Expr getHeadersExpr =
        MethodInvocationExpr.builder()
            .setExprReferenceExpr(clientContextVarExpr)
            .setMethodName("getHeaders")
            .build();
    Expr getClockExpr =
        MethodInvocationExpr.builder()
            .setExprReferenceExpr(clientContextVarExpr)
            .setMethodName("getClock")
            .build();

    // String uploadEndpoint =
    //     clientContext.getEndpoint() != null ? clientContext.getEndpoint() : settings.getEndpoint();
    //
    // The context wins: on the create(ClientContext) entry point the settings are pure defaults and
    // all of the real configuration lives in the context.
    Expr contextEndpointExpr =
        MethodInvocationExpr.builder()
            .setExprReferenceExpr(clientContextVarExpr)
            .setMethodName("getEndpoint")
            .setReturnType(TypeNode.STRING)
            .build();
    Expr settingsEndpointExpr =
        MethodInvocationExpr.builder()
            .setExprReferenceExpr(settingsVarExpr)
            .setMethodName("getEndpoint")
            .setReturnType(TypeNode.STRING)
            .build();
    VariableExpr uploadEndpointVarExpr =
        VariableExpr.withVariable(
            Variable.builder().setName("uploadEndpoint").setType(TypeNode.STRING).build());
    Statement uploadEndpointDeclStmt =
        ExprStatement.withExpr(
            AssignmentExpr.builder()
                .setVariableExpr(uploadEndpointVarExpr.toBuilder().setIsDecl(true).build())
                .setValueExpr(
                    TernaryExpr.builder()
                        .setConditionExpr(
                            RelationalOperationExpr.notEqualToWithExprs(
                                contextEndpointExpr, ValueExpr.createNullExpr()))
                        .setThenExpr(contextEndpointExpr)
                        .setElseExpr(settingsEndpointExpr)
                        .build())
                .build());

    // ManagedHttpJsonChannel httpJsonManagedChannel =
    //     ManagedHttpJsonChannel.newBuilder()
    //         .setEndpoint(uploadEndpoint)
    //         .setExecutor(clientContext.getExecutor())
    //         .build();
    VariableExpr httpJsonManagedChannelVarExpr =
        VariableExpr.withVariable(
            Variable.builder()
                .setName("httpJsonManagedChannel")
                .setType(managedChannelType)
                .build());
    Expr channelBuilderExpr =
        MethodInvocationExpr.builder()
            .setStaticReferenceType(managedChannelType)
            .setMethodName(NEW_BUILDER_METHOD_NAME)
            .build();
    channelBuilderExpr =
        MethodInvocationExpr.builder()
            .setExprReferenceExpr(channelBuilderExpr)
            .setMethodName("setEndpoint")
            .setArguments(Arrays.asList(uploadEndpointVarExpr))
            .build();
    channelBuilderExpr =
        MethodInvocationExpr.builder()
            .setExprReferenceExpr(channelBuilderExpr)
            .setMethodName("setExecutor")
            .setArguments(Arrays.asList(getExecutorExpr))
            .build();
    channelBuilderExpr =
        MethodInvocationExpr.builder()
            .setExprReferenceExpr(channelBuilderExpr)
            .setMethodName(BUILD_METHOD_NAME)
            .setReturnType(managedChannelType)
            .build();
    Statement httpJsonManagedChannelDeclStmt =
        ExprStatement.withExpr(
            AssignmentExpr.builder()
                .setVariableExpr(httpJsonManagedChannelVarExpr.toBuilder().setIsDecl(true).build())
                .setValueExpr(channelBuilderExpr)
                .build());

    // HttpJsonTransportChannel httpJsonTransportChannel =
    //     HttpJsonTransportChannel.create(httpJsonManagedChannel);
    VariableExpr httpJsonTransportChannelVarExpr =
        VariableExpr.withVariable(
            Variable.builder()
                .setName("httpJsonTransportChannel")
                .setType(transportChannelType)
                .build());
    Statement httpJsonTransportChannelDeclStmt =
        ExprStatement.withExpr(
            AssignmentExpr.builder()
                .setVariableExpr(
                    httpJsonTransportChannelVarExpr.toBuilder().setIsDecl(true).build())
                .setValueExpr(
                    MethodInvocationExpr.builder()
                        .setStaticReferenceType(transportChannelType)
                        .setMethodName("create")
                        .setArguments(Arrays.asList(httpJsonManagedChannelVarExpr))
                        .setReturnType(transportChannelType)
                        .build())
                .build());

    // The internal headers are rebuilt for the HTTP/JSON transport rather than forwarded from the
    // caller's ClientContext, whose x-goog-api-client may report a different transport. The user's
    // external headers are forwarded as-is and take precedence.
    Expr internalHeadersExpr =
        MethodInvocationExpr.builder()
            .setStaticReferenceType(stubSettingsType)
            .setMethodName("defaultHttpJsonApiClientHeaderProviderBuilder")
            .build();
    internalHeadersExpr =
        MethodInvocationExpr.builder()
            .setExprReferenceExpr(internalHeadersExpr)
            .setMethodName(BUILD_METHOD_NAME)
            .build();
    internalHeadersExpr =
        MethodInvocationExpr.builder()
            .setExprReferenceExpr(internalHeadersExpr)
            .setMethodName("getHeaders")
            .build();

    TypeNode stringToStringMapType =
        TypeNode.withReference(
            ConcreteReference.builder()
                .setClazz(Map.class)
                .setGenerics(
                    Arrays.asList(TypeNode.STRING.reference(), TypeNode.STRING.reference()))
                .build());
    VariableExpr uploadHeadersVarExpr =
        VariableExpr.withVariable(
            Variable.builder().setName("uploadHeaders").setType(stringToStringMapType).build());
    Statement uploadHeadersDeclStmt =
        ExprStatement.withExpr(
            AssignmentExpr.builder()
                .setVariableExpr(uploadHeadersVarExpr.toBuilder().setIsDecl(true).build())
                .setValueExpr(
                    NewObjectExpr.builder()
                        .setType(FIXED_TYPESTORE.get(HashMap.class.getSimpleName()))
                        .setIsGeneric(true)
                        .setArguments(Arrays.asList(internalHeadersExpr))
                        .build())
                .build());
    Statement uploadHeadersPutAllStmt =
        ExprStatement.withExpr(
            MethodInvocationExpr.builder()
                .setExprReferenceExpr(uploadHeadersVarExpr)
                .setMethodName("putAll")
                .setArguments(Arrays.asList(getHeadersExpr))
                .build());

    // Maps.transformValues(uploadHeaders, value -> Collections.singletonList(value))
    VariableExpr headerValueVarExpr =
        VariableExpr.withVariable(
            Variable.builder().setName("value").setType(TypeNode.STRING).build());
    Expr extraHeadersExpr =
        MethodInvocationExpr.builder()
            .setStaticReferenceType(FIXED_TYPESTORE.get(Maps.class.getSimpleName()))
            .setMethodName("transformValues")
            .setArguments(
                Arrays.asList(
                    uploadHeadersVarExpr,
                    LambdaExpr.builder()
                        .setArguments(headerValueVarExpr.toBuilder().setIsDecl(true).build())
                        .setReturnExpr(
                            MethodInvocationExpr.builder()
                                .setStaticReferenceType(
                                    FIXED_TYPESTORE.get(Collections.class.getSimpleName()))
                                .setMethodName("singletonList")
                                .setArguments(Arrays.asList(headerValueVarExpr))
                                .build())
                        .build()))
            .build();

    // The resumable upload callables read credentials and headers exclusively from the default call
    // context, so they must be attached here rather than to the ClientContext itself.
    Expr defaultCallContextExpr =
        MethodInvocationExpr.builder()
            .setStaticReferenceType(callContextType)
            .setMethodName("createDefault")
            .build();
    defaultCallContextExpr =
        MethodInvocationExpr.builder()
            .setExprReferenceExpr(defaultCallContextExpr)
            .setMethodName("withTransportChannel")
            .setArguments(Arrays.asList(httpJsonTransportChannelVarExpr))
            .setReturnType(callContextType)
            .build();
    defaultCallContextExpr =
        MethodInvocationExpr.builder()
            .setExprReferenceExpr(defaultCallContextExpr)
            .setMethodName("withCredentials")
            .setArguments(Arrays.asList(getCredentialsExpr))
            .setReturnType(callContextType)
            .build();
    defaultCallContextExpr =
        MethodInvocationExpr.builder()
            .setExprReferenceExpr(defaultCallContextExpr)
            .setMethodName("withExtraHeaders")
            .setArguments(Arrays.asList(extraHeadersExpr))
            .setReturnType(callContextType)
            .build();

    Expr backgroundResourcesExpr =
        MethodInvocationExpr.builder()
            .setStaticReferenceType(FIXED_TYPESTORE.get(Arrays.class.getSimpleName()))
            .setMethodName("asList")
            .setArguments(Arrays.asList(httpJsonTransportChannelVarExpr))
            .build();

    Expr contextBuilderExpr =
        MethodInvocationExpr.builder()
            .setStaticReferenceType(clientContextType)
            .setMethodName(NEW_BUILDER_METHOD_NAME)
            .build();
    contextBuilderExpr =
        MethodInvocationExpr.builder()
            .setExprReferenceExpr(contextBuilderExpr)
            .setMethodName("setCredentials")
            .setArguments(Arrays.asList(getCredentialsExpr))
            .build();
    contextBuilderExpr =
        MethodInvocationExpr.builder()
            .setExprReferenceExpr(contextBuilderExpr)
            .setMethodName("setEndpoint")
            .setArguments(Arrays.asList(uploadEndpointVarExpr))
            .build();
    contextBuilderExpr =
        MethodInvocationExpr.builder()
            .setExprReferenceExpr(contextBuilderExpr)
            .setMethodName("setExecutor")
            .setArguments(Arrays.asList(getExecutorExpr))
            .build();
    contextBuilderExpr =
        MethodInvocationExpr.builder()
            .setExprReferenceExpr(contextBuilderExpr)
            .setMethodName("setClock")
            .setArguments(Arrays.asList(getClockExpr))
            .build();
    contextBuilderExpr =
        MethodInvocationExpr.builder()
            .setExprReferenceExpr(contextBuilderExpr)
            .setMethodName("setTransportChannel")
            .setArguments(Arrays.asList(httpJsonTransportChannelVarExpr))
            .build();
    contextBuilderExpr =
        MethodInvocationExpr.builder()
            .setExprReferenceExpr(contextBuilderExpr)
            .setMethodName("setDefaultCallContext")
            .setArguments(Arrays.asList(defaultCallContextExpr))
            .build();
    contextBuilderExpr =
        MethodInvocationExpr.builder()
            .setExprReferenceExpr(contextBuilderExpr)
            .setMethodName("setBackgroundResources")
            .setArguments(Arrays.asList(backgroundResourcesExpr))
            .build();
    contextBuilderExpr =
        MethodInvocationExpr.builder()
            .setExprReferenceExpr(contextBuilderExpr)
            .setMethodName(BUILD_METHOD_NAME)
            .setReturnType(clientContextType)
            .build();

    VariableExpr httpJsonClientContextVarExpr =
        VariableExpr.withVariable(
            Variable.builder()
                .setName("httpJsonClientContext")
                .setType(clientContextType)
                .build());
    Statement httpJsonClientContextDeclStmt =
        ExprStatement.withExpr(
            AssignmentExpr.builder()
                .setVariableExpr(httpJsonClientContextVarExpr.toBuilder().setIsDecl(true).build())
                .setValueExpr(contextBuilderExpr)
                .build());

    CommentStatement methodComment =
        CommentStatement.withComment(
            JavaDocComment.builder()
                .addComment(
                    "Constructs an instance from the given client context, deriving a dedicated"
                        + " HTTP/JSON client context for the upload transport.")
                .addParagraph(
                    "Resumable uploads always execute over HTTP/JSON, so the upload stub stands up"
                        + " its own transport channel instead of sharing the caller's. Credentials,"
                        + " headers, executor and clock are inherited from the given client"
                        + " context. The returned stub is registered as a background resource of"
                        + " the caller and is closed with it.")
                .build());

    return MethodDefinition.builder()
        .setHeaderCommentStatements(Arrays.asList(methodComment))
        .setScope(ScopeNode.PUBLIC)
        .setIsStatic(true)
        .setReturnType(thisClassType)
        .setName("createFrom")
        .setArguments(
            Arrays.asList(
                clientContextVarExpr.toBuilder().setIsDecl(true).build(),
                settingsVarExpr.toBuilder().setIsDecl(true).build()))
        .setBody(
            Arrays.asList(
                uploadEndpointDeclStmt,
                httpJsonManagedChannelDeclStmt,
                httpJsonTransportChannelDeclStmt,
                uploadHeadersDeclStmt,
                uploadHeadersPutAllStmt,
                httpJsonClientContextDeclStmt))
        .setReturnExpr(
            MethodInvocationExpr.builder()
                .setMethodName("create")
                .setArguments(Arrays.asList(httpJsonClientContextVarExpr, settingsVarExpr))
                .setReturnType(thisClassType)
                .build())
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
    return HttpJsonDescriptorComposer.createMethodDescriptorVariableDecl(
        service,
        protoMethod,
        methodDescriptorVarExpr,
        restNumericEnumsEnabled,
        RESUMABLE_UPLOAD_PATH_PREFIX);
  }

  private static MethodDefinition createGetMethodDescriptorsMethod(
      Map<String, VariableExpr> protoMethodNameToDescriptorVarExprs) {
    return HttpJsonDescriptorComposer.createGetMethodDescriptorsMethod(
        protoMethodNameToDescriptorVarExprs.values());
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
