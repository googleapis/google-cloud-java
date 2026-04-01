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

import com.google.api.gax.httpjson.ApiMethodDescriptor;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.StatusCode.Code;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.api.generator.engine.ast.AnnotationNode;
import com.google.api.generator.engine.ast.AssignmentExpr;
import com.google.api.generator.engine.ast.ConcreteReference;
import com.google.api.generator.engine.ast.EnumRefExpr;
import com.google.api.generator.engine.ast.Expr;
import com.google.api.generator.engine.ast.ExprStatement;
import com.google.api.generator.engine.ast.MethodDefinition;
import com.google.api.generator.engine.ast.MethodInvocationExpr;
import com.google.api.generator.engine.ast.NewObjectExpr;
import com.google.api.generator.engine.ast.PrimitiveValue;
import com.google.api.generator.engine.ast.ScopeNode;
import com.google.api.generator.engine.ast.Statement;
import com.google.api.generator.engine.ast.TypeNode;
import com.google.api.generator.engine.ast.ValueExpr;
import com.google.api.generator.engine.ast.Variable;
import com.google.api.generator.engine.ast.VariableExpr;
import com.google.api.generator.gapic.composer.common.AbstractServiceClientTestClassComposer;
import com.google.api.generator.gapic.composer.store.TypeStore;
import com.google.api.generator.gapic.composer.utils.ClassNames;
import com.google.api.generator.gapic.model.GapicContext;
import com.google.api.generator.gapic.model.Message;
import com.google.api.generator.gapic.model.Method;
import com.google.api.generator.gapic.model.MethodArgument;
import com.google.api.generator.gapic.model.ResourceName;
import com.google.api.generator.gapic.model.Service;
import com.google.api.generator.gapic.utils.JavaStyle;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ServiceClientTestClassComposer extends AbstractServiceClientTestClassComposer {

  private static final String MOCK_SERVICE_VAR_NAME = "mockService";

  private static final ServiceClientTestClassComposer INSTANCE =
      new ServiceClientTestClassComposer();

  private static final TypeStore FIXED_REST_TYPESTORE = createStaticTypes();

  protected ServiceClientTestClassComposer() {
    super(RestContext.instance());
  }

  public static AbstractServiceClientTestClassComposer instance() {
    return INSTANCE;
  }

  private static TypeStore createStaticTypes() {
    return new TypeStore(
        Arrays.asList(
            ApiClientHeaderProvider.class,
            ApiException.class,
            ApiExceptionFactory.class,
            ApiMethodDescriptor.class,
            Code.class,
            Exception.class,
            FakeStatusCode.class,
            GaxHttpJsonProperties.class,
            ImmutableList.class,
            MockHttpService.class));
  }

  @Override
  protected Map<String, VariableExpr> createClassMemberVarExprs(
      Service service, GapicContext context, TypeStore typeStore) {
    BiFunction<String, TypeNode, VariableExpr> varExprFn =
        (name, type) ->
            VariableExpr.withVariable(Variable.builder().setName(name).setType(type).build());
    Map<String, TypeNode> fields = new LinkedHashMap<>();
    fields.put(
        MOCK_SERVICE_VAR_NAME, FIXED_REST_TYPESTORE.get(MockHttpService.class.getSimpleName()));
    fields.put(CLIENT_VAR_NAME, typeStore.get(ClassNames.getServiceClientClassName(service)));
    return fields.entrySet().stream()
        .collect(Collectors.toMap(e -> e.getKey(), e -> varExprFn.apply(e.getKey(), e.getValue())));
  }

  @Override
  protected List<Statement> createClassMemberFieldDecls(
      Map<String, VariableExpr> classMemberVarExprs) {
    return classMemberVarExprs.values().stream()
        .map(
            v ->
                ExprStatement.withExpr(
                    v.toBuilder()
                        .setIsDecl(true)
                        .setScope(ScopeNode.PRIVATE)
                        .setIsStatic(true)
                        .build()))
        .collect(Collectors.toList());
  }

  @Override
  protected MethodDefinition createStartStaticServerMethod(
      Service service,
      GapicContext context,
      Map<String, VariableExpr> classMemberVarExprs,
      TypeStore typeStore,
      String newBuilderMethod) {

    VariableExpr mockServiceVarExpr = classMemberVarExprs.get(MOCK_SERVICE_VAR_NAME);
    VariableExpr clientVarExpr = classMemberVarExprs.get(CLIENT_VAR_NAME);
    TypeNode settingsType = typeStore.get(ClassNames.getServiceSettingsClassName(service));
    TypeNode transportStubType =
        typeStore.get(getTransportContext().classNames().getTransportServiceStubClassName(service));

    Function<Expr, BiFunction<String, Expr, MethodInvocationExpr>> methodBuilderFn =
        methodExpr ->
            (mName, argExpr) ->
                MethodInvocationExpr.builder()
                    .setExprReferenceExpr(methodExpr)
                    .setMethodName(mName)
                    .setArguments(Arrays.asList(argExpr))
                    .build();

    Expr initMockServiceExpr =
        AssignmentExpr.builder()
            .setVariableExpr(mockServiceVarExpr)
            .setValueExpr(
                NewObjectExpr.builder()
                    .setType(mockServiceVarExpr.type())
                    .setArguments(
                        MethodInvocationExpr.builder()
                            .setStaticReferenceType(transportStubType)
                            .setMethodName("getMethodDescriptors")
                            .build(),
                        MethodInvocationExpr.builder()
                            .setStaticReferenceType(settingsType)
                            .setMethodName("getDefaultEndpoint")
                            .build())
                    .build())
            .build();

    VariableExpr localSettingsVarExpr =
        VariableExpr.withVariable(
            Variable.builder().setName("settings").setType(settingsType).build());

    Expr settingsBuilderExpr =
        MethodInvocationExpr.builder()
            .setStaticReferenceType(settingsType)
            .setMethodName(newBuilderMethod)
            .build();

    Expr transportChannelProviderExpr =
        MethodInvocationExpr.builder()
            .setStaticReferenceType(settingsType)
            .setMethodName("defaultHttpJsonTransportProviderBuilder")
            .build();

    transportChannelProviderExpr =
        methodBuilderFn
            .apply(transportChannelProviderExpr)
            .apply("setHttpTransport", mockServiceVarExpr);

    transportChannelProviderExpr =
        MethodInvocationExpr.builder()
            .setExprReferenceExpr(transportChannelProviderExpr)
            .setMethodName("build")
            .setReturnType(localSettingsVarExpr.type())
            .build();

    settingsBuilderExpr =
        methodBuilderFn
            .apply(settingsBuilderExpr)
            .apply("setTransportChannelProvider", transportChannelProviderExpr);

    settingsBuilderExpr =
        methodBuilderFn
            .apply(settingsBuilderExpr)
            .apply(
                "setCredentialsProvider",
                MethodInvocationExpr.builder()
                    .setStaticReferenceType(FIXED_TYPESTORE.get("NoCredentialsProvider"))
                    .setMethodName("create")
                    .build());
    settingsBuilderExpr =
        MethodInvocationExpr.builder()
            .setExprReferenceExpr(settingsBuilderExpr)
            .setMethodName("build")
            .setReturnType(localSettingsVarExpr.type())
            .build();

    Expr initLocalSettingsExpr =
        AssignmentExpr.builder()
            .setVariableExpr(localSettingsVarExpr.toBuilder().setIsDecl(true).build())
            .setValueExpr(settingsBuilderExpr)
            .build();

    Expr initClientExpr =
        AssignmentExpr.builder()
            .setVariableExpr(clientVarExpr)
            .setValueExpr(
                MethodInvocationExpr.builder()
                    .setStaticReferenceType(
                        typeStore.get(ClassNames.getServiceClientClassName(service)))
                    .setMethodName("create")
                    .setArguments(Arrays.asList(localSettingsVarExpr))
                    .setReturnType(clientVarExpr.type())
                    .build())
            .build();

    return MethodDefinition.builder()
        .setAnnotations(Arrays.asList(AnnotationNode.withType(FIXED_TYPESTORE.get("BeforeClass"))))
        .setScope(ScopeNode.PUBLIC)
        .setReturnType(TypeNode.VOID)
        .setName("startStaticServer")
        .setThrowsExceptions(Arrays.asList(FIXED_TYPESTORE.get("IOException")))
        .setIsStatic(true)
        .setBody(
            Arrays.asList(initMockServiceExpr, initLocalSettingsExpr, initClientExpr).stream()
                .map(e -> ExprStatement.withExpr(e))
                .collect(Collectors.toList()))
        .build();
  }

  @Override
  protected MethodDefinition createStopServerMethod(
      Service service, Map<String, VariableExpr> classMemberVarExprs) {
    return MethodDefinition.builder()
        .setAnnotations(Arrays.asList(AnnotationNode.withType(FIXED_TYPESTORE.get("AfterClass"))))
        .setScope(ScopeNode.PUBLIC)
        .setIsStatic(true)
        .setReturnType(TypeNode.VOID)
        .setName("stopServer")
        .setBody(
            Arrays.asList(
                ExprStatement.withExpr(
                    MethodInvocationExpr.builder()
                        .setExprReferenceExpr(classMemberVarExprs.get(CLIENT_VAR_NAME))
                        .setMethodName("close")
                        .build())))
        .build();
  }

  @Override
  protected MethodDefinition createSetUpMethod(
      Service service, Map<String, VariableExpr> classMemberVarExprs, TypeStore typeStore) {

    return MethodDefinition.builder()
        .setAnnotations(Arrays.asList(AnnotationNode.withType(FIXED_TYPESTORE.get("Before"))))
        .setScope(ScopeNode.PUBLIC)
        .setReturnType(TypeNode.VOID)
        .setName("setUp")
        .setBody(Arrays.asList())
        .build();
  }

  @Override
  protected MethodDefinition createTearDownMethod(
      Service service, Map<String, VariableExpr> classMemberVarExprs) {
    return MethodDefinition.builder()
        .setAnnotations(Arrays.asList(AnnotationNode.withType(FIXED_TYPESTORE.get("After"))))
        .setScope(ScopeNode.PUBLIC)
        .setReturnType(TypeNode.VOID)
        .setName("tearDown")
        .setThrowsExceptions(
            Arrays.asList(TypeNode.withReference(ConcreteReference.withClazz(Exception.class))))
        .setBody(
            Arrays.asList(
                ExprStatement.withExpr(
                    MethodInvocationExpr.builder()
                        .setExprReferenceExpr(classMemberVarExprs.get(MOCK_SERVICE_VAR_NAME))
                        .setMethodName("reset")
                        .build())))
        .build();
  }

  @Override
  protected List<Statement> constructRpcTestCheckerLogic(
      Method method,
      List<MethodArgument> methodSignature,
      Service service,
      boolean isRequestArg,
      Map<String, VariableExpr> classMemberVarExprs,
      VariableExpr requestVarExpr,
      Message requestMessage) {

    VariableExpr actualRequestsVarExpr =
        VariableExpr.withVariable(
            Variable.builder()
                .setType(
                    TypeNode.withReference(
                        ConcreteReference.builder()
                            .setClazz(List.class)
                            .setGenerics(Arrays.asList(TypeNode.STRING.reference()))
                            .build()))
                .setName("actualRequests")
                .build());

    List<Expr> methodExprs = new ArrayList<>();
    methodExprs.add(
        AssignmentExpr.builder()
            .setVariableExpr(actualRequestsVarExpr.toBuilder().setIsDecl(true).build())
            .setValueExpr(
                MethodInvocationExpr.builder()
                    .setExprReferenceExpr(classMemberVarExprs.get(getMockServiceVarName(service)))
                    .setMethodName("getRequestPaths")
                    .setReturnType(actualRequestsVarExpr.type())
                    .build())
            .build());

    methodExprs.add(
        MethodInvocationExpr.builder()
            .setStaticReferenceType(FIXED_TYPESTORE.get("Assert"))
            .setMethodName("assertEquals")
            .setArguments(
                ValueExpr.withValue(
                    PrimitiveValue.builder().setType(TypeNode.INT).setValue("1").build()),
                MethodInvocationExpr.builder()
                    .setExprReferenceExpr(actualRequestsVarExpr)
                    .setMethodName("size")
                    .build())
            .build());

    List<Statement> methodStatements = new ArrayList<>();
    methodStatements.addAll(
        methodExprs.stream().map(ExprStatement::withExpr).collect(Collectors.toList()));

    methodExprs.clear();
    methodStatements.add(EMPTY_LINE_STATEMENT);

    VariableExpr apiClientHeaderKeyVarExpr =
        VariableExpr.withVariable(
            Variable.builder().setType(TypeNode.STRING).setName("apiClientHeaderKey").build());

    AssignmentExpr apiClientHeaderKeyAssignExpr =
        AssignmentExpr.builder()
            .setVariableExpr(apiClientHeaderKeyVarExpr.toBuilder().setIsDecl(true).build())
            .setValueExpr(
                MethodInvocationExpr.builder()
                    .setMethodName("next")
                    .setReturnType(apiClientHeaderKeyVarExpr.type())
                    .setExprReferenceExpr(
                        MethodInvocationExpr.builder()
                            .setMethodName("iterator")
                            .setExprReferenceExpr(
                                MethodInvocationExpr.builder()
                                    .setMethodName("get")
                                    .setArguments(
                                        MethodInvocationExpr.builder()
                                            .setMethodName("getDefaultApiClientHeaderKey")
                                            .setStaticReferenceType(
                                                FIXED_REST_TYPESTORE.get("ApiClientHeaderProvider"))
                                            .build())
                                    .setExprReferenceExpr(
                                        MethodInvocationExpr.builder()
                                            .setMethodName("getRequestHeaders")
                                            .setExprReferenceExpr(
                                                classMemberVarExprs.get(
                                                    getMockServiceVarName(service)))
                                            .build())
                                    .build())
                            .build())
                    .build())
            .build();

    methodExprs.add(apiClientHeaderKeyAssignExpr);

    methodExprs.add(
        MethodInvocationExpr.builder()
            .setMethodName("assertTrue")
            .setStaticReferenceType(FIXED_TYPESTORE.get("Assert"))
            .setArguments(
                MethodInvocationExpr.builder()
                    .setMethodName("matches")
                    .setExprReferenceExpr(
                        MethodInvocationExpr.builder()
                            .setMethodName("matcher")
                            .setArguments(apiClientHeaderKeyVarExpr)
                            .setExprReferenceExpr(
                                MethodInvocationExpr.builder()
                                    .setMethodName("getDefaultApiClientHeaderPattern")
                                    .setStaticReferenceType(
                                        FIXED_REST_TYPESTORE.get("GaxHttpJsonProperties"))
                                    .build())
                            .build())
                    .build())
            .build());

    methodStatements.addAll(
        methodExprs.stream().map(ExprStatement::withExpr).collect(Collectors.toList()));
    methodExprs.clear();

    return methodStatements;
  }

  @Override
  protected MethodDefinition createStreamingRpcTestMethod(
      Service service,
      Method method,
      Map<String, VariableExpr> classMemberVarExprs,
      Map<String, ResourceName> resourceNames,
      Map<String, Message> messageTypes) {
    // Add some actual statements once implemented
    List<Statement> methodStatements = new ArrayList<>();

    String testMethodName = String.format("%sTest", JavaStyle.toLowerCamelCase(method.name()));
    return MethodDefinition.builder()
        .setAnnotations(Arrays.asList(TEST_ANNOTATION))
        .setScope(ScopeNode.PUBLIC)
        .setReturnType(TypeNode.VOID)
        .setName(testMethodName)
        .setThrowsExceptions(Arrays.asList(TypeNode.withExceptionClazz(Exception.class)))
        .setBody(methodStatements)
        .build();
  }

  @Override
  protected MethodDefinition createRpcExceptionTestMethod(
      Method method,
      Service service,
      List<MethodArgument> methodSignature,
      int variantIndex,
      Map<String, VariableExpr> classMemberVarExprs,
      Map<String, ResourceName> resourceNames,
      Map<String, Message> messageTypes) {
    VariableExpr exceptionVarExpr =
        VariableExpr.withVariable(
            Variable.builder()
                .setType(FIXED_REST_TYPESTORE.get("ApiException"))
                .setName("exception")
                .build());

    // First two assignment lines.
    Expr exceptionAssignExpr =
        AssignmentExpr.builder()
            .setVariableExpr(exceptionVarExpr.toBuilder().setIsDecl(true).build())
            .setValueExpr(
                MethodInvocationExpr.builder()
                    .setMethodName("createException")
                    .setStaticReferenceType(FIXED_REST_TYPESTORE.get("ApiExceptionFactory"))
                    .setArguments(
                        NewObjectExpr.withType(FIXED_REST_TYPESTORE.get("Exception")),
                        MethodInvocationExpr.builder()
                            .setMethodName("of")
                            .setStaticReferenceType(FIXED_REST_TYPESTORE.get("FakeStatusCode"))
                            .setArguments(
                                EnumRefExpr.builder()
                                    .setName("INVALID_ARGUMENT")
                                    .setType(FIXED_REST_TYPESTORE.get("Code"))
                                    .build())
                            .build(),
                        ValueExpr.withValue(
                            PrimitiveValue.builder()
                                .setType(TypeNode.BOOLEAN)
                                .setValue("false")
                                .build()))
                    .setReturnType(exceptionVarExpr.type())
                    .build())
            .build();

    Expr addExceptionExpr =
        MethodInvocationExpr.builder()
            .setExprReferenceExpr(classMemberVarExprs.get(getMockServiceVarName(service)))
            .setMethodName("addException")
            .setArguments(exceptionVarExpr)
            .build();

    // Try-catch block. Build the method call.
    String exceptionTestMethodName =
        String.format(
            "%sExceptionTest%s",
            JavaStyle.toLowerCamelCase(method.name()), variantIndex > 0 ? variantIndex + 1 : "");

    boolean isStreaming = !method.stream().equals(Method.Stream.NONE);
    List<Statement> methodBody = new ArrayList<>();
    methodBody.add(ExprStatement.withExpr(exceptionAssignExpr));
    methodBody.add(ExprStatement.withExpr(addExceptionExpr));
    if (isStreaming) {
      methodBody.addAll(
          createStreamingRpcExceptionTestStatements(
              method, classMemberVarExprs, resourceNames, messageTypes));
    } else {
      methodBody.addAll(
          createRpcExceptionTestStatements(
              method, methodSignature, classMemberVarExprs, resourceNames, messageTypes));
    }

    return MethodDefinition.builder()
        .setAnnotations(Arrays.asList(TEST_ANNOTATION))
        .setScope(ScopeNode.PUBLIC)
        .setReturnType(TypeNode.VOID)
        .setName(exceptionTestMethodName)
        .setThrowsExceptions(Arrays.asList(TypeNode.withExceptionClazz(Exception.class)))
        .setBody(methodBody)
        .build();
  }

  @Override
  protected List<Statement> createStreamingRpcExceptionTestStatements(
      Method method,
      Map<String, VariableExpr> classMemberVarExprs,
      Map<String, ResourceName> resourceNames,
      Map<String, Message> messageTypes) {
    return Collections.emptyList();
  }

  @Override
  protected List<Statement> createRpcLroExceptionTestCatchBody(
      VariableExpr exceptionExpr, boolean isStreaming) {
    return Collections.emptyList();
  }

  @Override
  protected String getMockServiceVarName(Service service) {
    return String.format(MOCK_SERVICE_VAR_NAME);
  }
}
