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

package com.google.api.generator.gapic.composer.grpc;

import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.grpc.testing.MockStreamObserver;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.generator.engine.ast.AnnotationNode;
import com.google.api.generator.engine.ast.AssignmentExpr;
import com.google.api.generator.engine.ast.CastExpr;
import com.google.api.generator.engine.ast.ConcreteReference;
import com.google.api.generator.engine.ast.EnumRefExpr;
import com.google.api.generator.engine.ast.Expr;
import com.google.api.generator.engine.ast.ExprStatement;
import com.google.api.generator.engine.ast.InstanceofExpr;
import com.google.api.generator.engine.ast.MethodDefinition;
import com.google.api.generator.engine.ast.MethodInvocationExpr;
import com.google.api.generator.engine.ast.NewObjectExpr;
import com.google.api.generator.engine.ast.PrimitiveValue;
import com.google.api.generator.engine.ast.ScopeNode;
import com.google.api.generator.engine.ast.Statement;
import com.google.api.generator.engine.ast.StringObjectValue;
import com.google.api.generator.engine.ast.TryCatchStatement;
import com.google.api.generator.engine.ast.TypeNode;
import com.google.api.generator.engine.ast.ValueExpr;
import com.google.api.generator.engine.ast.Variable;
import com.google.api.generator.engine.ast.VariableExpr;
import com.google.api.generator.gapic.composer.common.AbstractServiceClientTestClassComposer;
import com.google.api.generator.gapic.composer.defaultvalue.DefaultValueComposer;
import com.google.api.generator.gapic.composer.store.TypeStore;
import com.google.api.generator.gapic.composer.utils.ClassNames;
import com.google.api.generator.gapic.model.Field;
import com.google.api.generator.gapic.model.GapicContext;
import com.google.api.generator.gapic.model.Message;
import com.google.api.generator.gapic.model.Method;
import com.google.api.generator.gapic.model.MethodArgument;
import com.google.api.generator.gapic.model.ResourceName;
import com.google.api.generator.gapic.model.Service;
import com.google.api.generator.gapic.utils.JavaStyle;
import com.google.common.base.Preconditions;
import com.google.protobuf.AbstractMessage;
import io.grpc.StatusRuntimeException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ExecutionException;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ServiceClientTestClassComposer extends AbstractServiceClientTestClassComposer {

  private static final String SERVICE_HELPER_VAR_NAME = "mockServiceHelper";
  private static final String CHANNEL_PROVIDER_VAR_NAME = "channelProvider";

  private static final ServiceClientTestClassComposer INSTANCE =
      new ServiceClientTestClassComposer();

  private static final TypeStore FIXED_GRPC_TYPESTORE = createStaticTypes();

  private static final TypeNode LIST_TYPE =
      TypeNode.withReference(ConcreteReference.withClazz(List.class));
  private static final TypeNode MAP_TYPE =
      TypeNode.withReference(ConcreteReference.withClazz(Map.class));
  private static final TypeNode RESOURCE_NAME_TYPE =
      TypeNode.withReference(
          ConcreteReference.withClazz(com.google.api.resourcenames.ResourceName.class));

  // Avoid conflicting types with com.google.rpc.Status.
  private static final TypeNode GRPC_STATUS_TYPE =
      TypeNode.withReference(
          ConcreteReference.builder().setClazz(io.grpc.Status.class).setUseFullName(true).build());

  protected ServiceClientTestClassComposer() {
    super(GrpcContext.instance());
  }

  public static AbstractServiceClientTestClassComposer instance() {
    return INSTANCE;
  }

  private static TypeStore createStaticTypes() {
    List<Class<?>> concreteClazzes =
        Arrays.asList(
            GaxGrpcProperties.class,
            LocalChannelProvider.class,
            MockGrpcService.class,
            MockServiceHelper.class,
            MockStreamObserver.class,
            StatusRuntimeException.class);

    return new TypeStore(concreteClazzes);
  }

  @Override
  protected Map<String, VariableExpr> createClassMemberVarExprs(
      Service service, GapicContext context, TypeStore typeStore) {
    BiFunction<String, TypeNode, VariableExpr> varExprFn =
        (name, type) ->
            VariableExpr.withVariable(Variable.builder().setName(name).setType(type).build());
    // Keep keys sorted in alphabetical order to ensure that the test output is deterministic.
    Map<String, TypeNode> fields = new TreeMap<>();
    fields.put(
        getMockServiceVarName(service), typeStore.get(ClassNames.getMockServiceClassName(service)));
    for (Service mixinService : context.mixinServices()) {
      fields.put(
          getMockServiceVarName(mixinService),
          typeStore.get(ClassNames.getMockServiceClassName(mixinService)));
    }
    fields.put(SERVICE_HELPER_VAR_NAME, FIXED_GRPC_TYPESTORE.get("MockServiceHelper"));
    fields.put(CLIENT_VAR_NAME, typeStore.get(ClassNames.getServiceClientClassName(service)));
    fields.put(CHANNEL_PROVIDER_VAR_NAME, FIXED_GRPC_TYPESTORE.get("LocalChannelProvider"));

    return fields.entrySet().stream()
        .collect(
            Collectors.toMap(
                Map.Entry::getKey,
                e -> varExprFn.apply(e.getKey(), e.getValue()),
                (u, v) -> {
                  throw new IllegalStateException();
                },
                TreeMap::new));
  }

  @Override
  protected MethodDefinition createStartStaticServerMethod(
      Service service,
      GapicContext context,
      Map<String, VariableExpr> classMemberVarExprs,
      TypeStore typeStore,
      String newBuilderMethod) {
    VariableExpr serviceHelperVarExpr = classMemberVarExprs.get(SERVICE_HELPER_VAR_NAME);
    Function<Service, VariableExpr> serviceToVarExprFn =
        s -> classMemberVarExprs.get(getMockServiceVarName(s));
    Function<Service, Expr> serviceToVarInitExprFn =
        s -> {
          VariableExpr mockServiceVarExpr = serviceToVarExprFn.apply(s);
          return AssignmentExpr.builder()
              .setVariableExpr(mockServiceVarExpr)
              .setValueExpr(NewObjectExpr.builder().setType(mockServiceVarExpr.type()).build())
              .build();
        };
    List<Expr> varInitExprs = new ArrayList<>();
    List<Expr> mockServiceVarExprs = new ArrayList<>();
    varInitExprs.add(serviceToVarInitExprFn.apply(service));
    mockServiceVarExprs.add(serviceToVarExprFn.apply(service));
    // Careful: Java 8 and 11 make different ordering choices if this set is not explicitly sorted.
    // Context: https://github.com/googleapis/sdk-platform-java/pull/750
    for (Service mixinService :
        context.mixinServices().stream()
            .sorted((s1, s2) -> s2.name().compareTo(s1.name()))
            .collect(Collectors.toList())) {
      varInitExprs.add(serviceToVarInitExprFn.apply(mixinService));
      mockServiceVarExprs.add(serviceToVarExprFn.apply(mixinService));
    }

    MethodInvocationExpr firstArg =
        MethodInvocationExpr.builder()
            .setStaticReferenceType(FIXED_TYPESTORE.get("UUID"))
            .setMethodName("randomUUID")
            .build();
    firstArg =
        MethodInvocationExpr.builder()
            .setExprReferenceExpr(firstArg)
            .setMethodName("toString")
            .build();

    MethodInvocationExpr secondArg =
        MethodInvocationExpr.builder()
            .setStaticReferenceType(FIXED_TYPESTORE.get("Arrays"))
            .setGenerics(Arrays.asList(FIXED_GRPC_TYPESTORE.get("MockGrpcService").reference()))
            .setMethodName("asList")
            .setArguments(mockServiceVarExprs)
            .build();

    Expr initServiceHelperExpr =
        AssignmentExpr.builder()
            .setVariableExpr(serviceHelperVarExpr)
            .setValueExpr(
                NewObjectExpr.builder()
                    .setType(serviceHelperVarExpr.type())
                    .setArguments(Arrays.asList(firstArg, secondArg))
                    .build())
            .build();

    Expr startServiceHelperExpr =
        MethodInvocationExpr.builder()
            .setExprReferenceExpr(serviceHelperVarExpr)
            .setMethodName("start")
            .build();
    varInitExprs.add(initServiceHelperExpr);
    varInitExprs.add(startServiceHelperExpr);

    return MethodDefinition.builder()
        .setAnnotations(Arrays.asList(AnnotationNode.withType(FIXED_TYPESTORE.get("BeforeClass"))))
        .setScope(ScopeNode.PUBLIC)
        .setIsStatic(true)
        .setReturnType(TypeNode.VOID)
        .setName("startStaticServer")
        .setBody(
            varInitExprs.stream().map(e -> ExprStatement.withExpr(e)).collect(Collectors.toList()))
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
                        .setExprReferenceExpr(classMemberVarExprs.get(SERVICE_HELPER_VAR_NAME))
                        .setMethodName("stop")
                        .build())))
        .build();
  }

  @Override
  protected MethodDefinition createSetUpMethod(
      Service service, Map<String, VariableExpr> classMemberVarExprs, TypeStore typeStore) {
    VariableExpr clientVarExpr = classMemberVarExprs.get(CLIENT_VAR_NAME);
    VariableExpr serviceHelperVarExpr = classMemberVarExprs.get(SERVICE_HELPER_VAR_NAME);
    VariableExpr channelProviderVarExpr = classMemberVarExprs.get(CHANNEL_PROVIDER_VAR_NAME);

    Expr resetServiceHelperExpr =
        MethodInvocationExpr.builder()
            .setExprReferenceExpr(serviceHelperVarExpr)
            .setMethodName("reset")
            .build();
    Expr channelProviderInitExpr =
        AssignmentExpr.builder()
            .setVariableExpr(channelProviderVarExpr)
            .setValueExpr(
                MethodInvocationExpr.builder()
                    .setExprReferenceExpr(serviceHelperVarExpr)
                    .setMethodName("createChannelProvider")
                    .setReturnType(channelProviderVarExpr.type())
                    .build())
            .build();

    TypeNode settingsType = typeStore.get(ClassNames.getServiceSettingsClassName(service));
    VariableExpr localSettingsVarExpr =
        VariableExpr.withVariable(
            Variable.builder().setName("settings").setType(settingsType).build());

    Expr settingsBuilderExpr =
        MethodInvocationExpr.builder()
            .setStaticReferenceType(settingsType)
            .setMethodName("newBuilder")
            .build();
    Function<Expr, BiFunction<String, Expr, MethodInvocationExpr>> methodBuilderFn =
        methodExpr ->
            (mName, argExpr) ->
                MethodInvocationExpr.builder()
                    .setExprReferenceExpr(methodExpr)
                    .setMethodName(mName)
                    .setArguments(Arrays.asList(argExpr))
                    .build();
    settingsBuilderExpr =
        methodBuilderFn
            .apply(settingsBuilderExpr)
            .apply(
                "setTransportChannelProvider", classMemberVarExprs.get(CHANNEL_PROVIDER_VAR_NAME));
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
        .setAnnotations(Arrays.asList(AnnotationNode.withType(FIXED_TYPESTORE.get("Before"))))
        .setScope(ScopeNode.PUBLIC)
        .setReturnType(TypeNode.VOID)
        .setName("setUp")
        .setThrowsExceptions(Arrays.asList(FIXED_TYPESTORE.get("IOException")))
        .setBody(
            Arrays.asList(
                    resetServiceHelperExpr,
                    channelProviderInitExpr,
                    initLocalSettingsExpr,
                    initClientExpr)
                .stream()
                .map(e -> ExprStatement.withExpr(e))
                .collect(Collectors.toList()))
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
                        .setExprReferenceExpr(classMemberVarExprs.get(CLIENT_VAR_NAME))
                        .setMethodName("close")
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
      VariableExpr requestVarExpr, // Nullable
      Message requestMessage) {
    List<Expr> methodExprs = new ArrayList<>();
    List<Statement> methodStatements = new ArrayList<>();

    // Construct the request checker logic.
    VariableExpr actualRequestsVarExpr =
        VariableExpr.withVariable(
            Variable.builder()
                .setType(
                    TypeNode.withReference(
                        ConcreteReference.builder()
                            .setClazz(List.class)
                            .setGenerics(
                                Arrays.asList(ConcreteReference.withClazz(AbstractMessage.class)))
                            .build()))
                .setName("actualRequests")
                .build());
    methodExprs.add(
        AssignmentExpr.builder()
            .setVariableExpr(actualRequestsVarExpr.toBuilder().setIsDecl(true).build())
            .setValueExpr(
                MethodInvocationExpr.builder()
                    .setExprReferenceExpr(classMemberVarExprs.get(getMockServiceVarName(service)))
                    .setMethodName("getRequests")
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

    VariableExpr actualRequestVarExpr =
        VariableExpr.withVariable(
            Variable.builder().setType(method.inputType()).setName("actualRequest").build());
    Expr getFirstRequestExpr =
        MethodInvocationExpr.builder()
            .setExprReferenceExpr(actualRequestsVarExpr)
            .setMethodName("get")
            .setArguments(
                ValueExpr.withValue(
                    PrimitiveValue.builder().setType(TypeNode.INT).setValue("0").build()))
            .setReturnType(FIXED_TYPESTORE.get("AbstractMessage"))
            .build();
    getFirstRequestExpr =
        CastExpr.builder().setType(method.inputType()).setExpr(getFirstRequestExpr).build();
    methodExprs.add(
        AssignmentExpr.builder()
            .setVariableExpr(actualRequestVarExpr.toBuilder().setIsDecl(true).build())
            .setValueExpr(getFirstRequestExpr)
            .build());
    methodStatements.addAll(
        methodExprs.stream().map(e -> ExprStatement.withExpr(e)).collect(Collectors.toList()));
    methodExprs.clear();
    methodStatements.add(EMPTY_LINE_STATEMENT);

    // Assert field equality.
    if (isRequestArg) {
      // TODO(miraleung): Replace these with a simple request object equals?
      Preconditions.checkNotNull(requestVarExpr);
      Preconditions.checkNotNull(requestMessage);
      for (Field field : requestMessage.fields()) {
        Expr expectedFieldExpr = createGetter(requestVarExpr, field);
        Expr actualFieldExpr = createGetter(actualRequestVarExpr, field);
        methodExprs.add(createAssertEquals(expectedFieldExpr, actualFieldExpr, field.type()));
      }
    } else {
      for (MethodArgument arg : methodSignature) {
        Expr root = actualRequestVarExpr;
        for (Field field : arg.nestedFields()) {
          root = createGetter(root, field);
        }
        MethodInvocationExpr actual = createGetter(root, arg.field());

        Expr expectedFieldExpr =
            VariableExpr.withVariable(
                Variable.builder()
                    .setName(JavaStyle.toLowerCamelCase(arg.name()))
                    .setType(arg.type())
                    .build());
        if (RESOURCE_NAME_TYPE.isSupertypeOrEquals(arg.type())) {
          expectedFieldExpr =
              MethodInvocationExpr.builder()
                  .setExprReferenceExpr(expectedFieldExpr)
                  .setMethodName("toString")
                  .build();
        }

        methodExprs.add(createAssertEquals(expectedFieldExpr, actual, arg.type()));
      }
    }

    // Assert header equality.
    Expr headerKeyExpr =
        MethodInvocationExpr.builder()
            .setStaticReferenceType(FIXED_TYPESTORE.get("ApiClientHeaderProvider"))
            .setMethodName("getDefaultApiClientHeaderKey")
            .build();
    Expr headerPatternExpr =
        MethodInvocationExpr.builder()
            .setStaticReferenceType(FIXED_GRPC_TYPESTORE.get("GaxGrpcProperties"))
            .setMethodName("getDefaultApiClientHeaderPattern")
            .build();
    Expr headerSentExpr =
        MethodInvocationExpr.builder()
            .setExprReferenceExpr(classMemberVarExprs.get("channelProvider"))
            .setMethodName("isHeaderSent")
            .setArguments(headerKeyExpr, headerPatternExpr)
            .build();
    methodExprs.add(
        MethodInvocationExpr.builder()
            .setStaticReferenceType(FIXED_TYPESTORE.get("Assert"))
            .setMethodName("assertTrue")
            .setArguments(headerSentExpr)
            .build());
    methodStatements.addAll(
        methodExprs.stream().map(e -> ExprStatement.withExpr(e)).collect(Collectors.toList()));
    methodExprs.clear();

    return methodStatements;
  }

  private static MethodInvocationExpr createAssertEquals(
      Expr expected, Expr actual, TypeNode type) {

    ArrayList<Expr> assertionArgs = new ArrayList<>();
    assertionArgs.add(expected);
    assertionArgs.add(actual);

    if (TypeNode.isFloatingPointType(type)) {
      boolean isFloat = type.equals(TypeNode.FLOAT);
      assertionArgs.add(
          ValueExpr.withValue(
              PrimitiveValue.builder()
                  .setType(isFloat ? TypeNode.FLOAT : TypeNode.DOUBLE)
                  .setValue(String.format("0.0001%s", isFloat ? "f" : ""))
                  .build()));
    }

    return MethodInvocationExpr.builder()
        .setStaticReferenceType(FIXED_TYPESTORE.get("Assert"))
        .setMethodName("assertEquals")
        .setArguments(assertionArgs)
        .build();
  }

  private static MethodInvocationExpr createGetter(Expr exprReference, Field field) {
    return MethodInvocationExpr.builder()
        .setExprReferenceExpr(exprReference)
        .setMethodName(
            String.format(
                createGetterNamePattern(field.type()), JavaStyle.toUpperCamelCase(field.name())))
        .build();
  }

  private static String createGetterNamePattern(TypeNode type) {
    String fieldGetterMethodNamePattern = "get%s";
    if (LIST_TYPE.isSupertypeOrEquals(type)) {
      fieldGetterMethodNamePattern = "get%sList";
    } else if (MAP_TYPE.isSupertypeOrEquals(type)) {
      fieldGetterMethodNamePattern = "get%sMap";
    }
    return fieldGetterMethodNamePattern;
  }

  @Override
  protected MethodDefinition createStreamingRpcTestMethod(
      Service service,
      Method method,
      Map<String, VariableExpr> classMemberVarExprs,
      Map<String, ResourceName> resourceNames,
      Map<String, Message> messageTypes) {
    TypeNode methodOutputType = method.hasLro() ? method.lro().responseType() : method.outputType();
    List<Expr> methodExprs = new ArrayList<>();
    VariableExpr expectedResponseVarExpr =
        VariableExpr.withVariable(
            Variable.builder().setType(methodOutputType).setName("expectedResponse").build());
    Expr expectedResponseValExpr = null;
    if (messageTypes.containsKey(methodOutputType.reference().fullName())) {
      expectedResponseValExpr =
          DefaultValueComposer.createSimpleMessageBuilderValue(
              messageTypes.get(methodOutputType.reference().fullName()),
              resourceNames,
              messageTypes,
              method.httpBindings());
    } else {
      // Wrap this in a field so we don't have to split the helper into lots of different methods,
      // or duplicate it for VariableExpr.
      expectedResponseValExpr =
          DefaultValueComposer.createValue(
              Field.builder()
                  .setType(methodOutputType)
                  .setIsMessage(true)
                  .setName("expectedResponse")
                  .build());
    }
    methodExprs.add(
        AssignmentExpr.builder()
            .setVariableExpr(expectedResponseVarExpr.toBuilder().setIsDecl(true).build())
            .setValueExpr(expectedResponseValExpr)
            .build());

    String mockServiceVarName = getMockServiceVarName(service);
    if (method.hasLro()) {
      VariableExpr resultOperationVarExpr =
          VariableExpr.withVariable(
              Variable.builder()
                  .setType(FIXED_GRPC_TYPESTORE.get("Operation"))
                  .setName("resultOperation")
                  .build());
      methodExprs.add(
          AssignmentExpr.builder()
              .setVariableExpr(resultOperationVarExpr.toBuilder().setIsDecl(true).build())
              .setValueExpr(
                  DefaultValueComposer.createSimpleOperationBuilderValue(
                      String.format("%sTest", JavaStyle.toLowerCamelCase(method.name())),
                      expectedResponseVarExpr))
              .build());
      methodExprs.add(
          MethodInvocationExpr.builder()
              .setExprReferenceExpr(classMemberVarExprs.get(mockServiceVarName))
              .setMethodName("addResponse")
              .setArguments(resultOperationVarExpr)
              .build());
    } else {
      methodExprs.add(
          MethodInvocationExpr.builder()
              .setExprReferenceExpr(classMemberVarExprs.get(mockServiceVarName))
              .setMethodName("addResponse")
              .setArguments(expectedResponseVarExpr)
              .build());
    }

    // Construct the request or method arguments.
    VariableExpr requestVarExpr =
        VariableExpr.withVariable(
            Variable.builder().setType(method.inputType()).setName("request").build());
    Message requestMessage = messageTypes.get(method.inputType().reference().fullName());
    Preconditions.checkNotNull(requestMessage);
    Expr valExpr =
        DefaultValueComposer.createSimpleMessageBuilderValue(
            requestMessage, resourceNames, messageTypes, method.httpBindings());
    methodExprs.add(
        AssignmentExpr.builder()
            .setVariableExpr(requestVarExpr.toBuilder().setIsDecl(true).build())
            .setValueExpr(valExpr)
            .build());

    List<Statement> methodStatements = new ArrayList<>();
    methodStatements.addAll(
        methodExprs.stream().map(e -> ExprStatement.withExpr(e)).collect(Collectors.toList()));
    methodExprs.clear();
    methodStatements.add(EMPTY_LINE_STATEMENT);

    // Construct the mock stream observer.
    VariableExpr responseObserverVarExpr =
        VariableExpr.withVariable(
            Variable.builder()
                .setType(
                    TypeNode.withReference(
                        FIXED_GRPC_TYPESTORE
                            .get("MockStreamObserver")
                            .reference()
                            .copyAndSetGenerics(Arrays.asList(method.outputType().reference()))))
                .setName("responseObserver")
                .build());

    methodStatements.add(
        ExprStatement.withExpr(
            AssignmentExpr.builder()
                .setVariableExpr(responseObserverVarExpr.toBuilder().setIsDecl(true).build())
                .setValueExpr(
                    NewObjectExpr.builder()
                        .setType(FIXED_GRPC_TYPESTORE.get("MockStreamObserver"))
                        .setIsGeneric(true)
                        .build())
                .build()));
    methodStatements.add(EMPTY_LINE_STATEMENT);

    // Build the callable variable and assign it.
    VariableExpr callableVarExpr =
        VariableExpr.withVariable(
            Variable.builder().setType(getCallableType(method)).setName("callable").build());
    Expr streamingCallExpr =
        MethodInvocationExpr.builder()
            .setExprReferenceExpr(classMemberVarExprs.get("client"))
            .setMethodName(String.format("%sCallable", JavaStyle.toLowerCamelCase(method.name())))
            .setReturnType(callableVarExpr.type())
            .build();
    methodExprs.add(
        AssignmentExpr.builder()
            .setVariableExpr(callableVarExpr.toBuilder().setIsDecl(true).build())
            .setValueExpr(streamingCallExpr)
            .build());

    // Call the streaming-variant callable method.
    if (method.stream().equals(Method.Stream.SERVER)) {
      methodExprs.add(
          MethodInvocationExpr.builder()
              .setExprReferenceExpr(callableVarExpr)
              .setMethodName("serverStreamingCall")
              .setArguments(requestVarExpr, responseObserverVarExpr)
              .build());
    } else {
      VariableExpr requestObserverVarExpr =
          VariableExpr.withVariable(
              Variable.builder()
                  .setType(
                      TypeNode.withReference(
                          FIXED_TYPESTORE
                              .get("ApiStreamObserver")
                              .reference()
                              .copyAndSetGenerics(Arrays.asList(method.inputType().reference()))))
                  .setName("requestObserver")
                  .build());
      List<Expr> callableMethodArgs = new ArrayList<>();
      if (!method.stream().equals(Method.Stream.BIDI)
          && !method.stream().equals(Method.Stream.CLIENT)) {
        callableMethodArgs.add(requestVarExpr);
      }
      callableMethodArgs.add(responseObserverVarExpr);
      methodExprs.add(
          AssignmentExpr.builder()
              .setVariableExpr(requestObserverVarExpr.toBuilder().setIsDecl(true).build())
              .setValueExpr(
                  MethodInvocationExpr.builder()
                      .setExprReferenceExpr(callableVarExpr)
                      .setMethodName(getCallableMethodName(method))
                      .setArguments(callableMethodArgs)
                      .setReturnType(requestObserverVarExpr.type())
                      .build())
              .build());

      methodStatements.addAll(
          methodExprs.stream().map(e -> ExprStatement.withExpr(e)).collect(Collectors.toList()));
      methodExprs.clear();
      methodStatements.add(EMPTY_LINE_STATEMENT);

      methodExprs.add(
          MethodInvocationExpr.builder()
              .setExprReferenceExpr(requestObserverVarExpr)
              .setMethodName("onNext")
              .setArguments(requestVarExpr)
              .build());
      methodExprs.add(
          MethodInvocationExpr.builder()
              .setExprReferenceExpr(requestObserverVarExpr)
              .setMethodName("onCompleted")
              .build());
    }
    methodStatements.addAll(
        methodExprs.stream().map(e -> ExprStatement.withExpr(e)).collect(Collectors.toList()));
    methodExprs.clear();
    methodStatements.add(EMPTY_LINE_STATEMENT);

    // Check the actual responses.
    VariableExpr actualResponsesVarExpr =
        VariableExpr.withVariable(
            Variable.builder()
                .setType(
                    TypeNode.withReference(
                        ConcreteReference.builder()
                            .setClazz(List.class)
                            .setGenerics(Arrays.asList(method.outputType().reference()))
                            .build()))
                .setName("actualResponses")
                .build());

    Expr getFutureResponseExpr =
        MethodInvocationExpr.builder()
            .setExprReferenceExpr(responseObserverVarExpr)
            .setMethodName("future")
            .build();
    getFutureResponseExpr =
        MethodInvocationExpr.builder()
            .setExprReferenceExpr(getFutureResponseExpr)
            .setMethodName("get")
            .setReturnType(actualResponsesVarExpr.type())
            .build();
    methodExprs.add(
        AssignmentExpr.builder()
            .setVariableExpr(actualResponsesVarExpr.toBuilder().setIsDecl(true).build())
            .setValueExpr(getFutureResponseExpr)
            .build());

    // Assert the size is equivalent.
    methodExprs.add(
        MethodInvocationExpr.builder()
            .setStaticReferenceType(FIXED_TYPESTORE.get("Assert"))
            .setMethodName("assertEquals")
            .setArguments(
                ValueExpr.withValue(
                    PrimitiveValue.builder().setType(TypeNode.INT).setValue("1").build()),
                MethodInvocationExpr.builder()
                    .setExprReferenceExpr(actualResponsesVarExpr)
                    .setMethodName("size")
                    .setReturnType(TypeNode.INT)
                    .build())
            .build());

    // Assert the responses are equivalent.
    Expr zeroExpr =
        ValueExpr.withValue(PrimitiveValue.builder().setType(TypeNode.INT).setValue("0").build());
    Expr actualResponseExpr =
        MethodInvocationExpr.builder()
            .setExprReferenceExpr(actualResponsesVarExpr)
            .setMethodName("get")
            .setArguments(zeroExpr)
            .build();

    methodExprs.add(
        MethodInvocationExpr.builder()
            .setStaticReferenceType(FIXED_TYPESTORE.get("Assert"))
            .setMethodName("assertEquals")
            .setArguments(expectedResponseVarExpr, actualResponseExpr)
            .build());

    methodStatements.addAll(
        methodExprs.stream().map(e -> ExprStatement.withExpr(e)).collect(Collectors.toList()));
    methodExprs.clear();
    methodStatements.add(EMPTY_LINE_STATEMENT);

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
                .setType(FIXED_GRPC_TYPESTORE.get("StatusRuntimeException"))
                .setName("exception")
                .build());

    // First two assignment lines.
    Expr exceptionAssignExpr =
        AssignmentExpr.builder()
            .setVariableExpr(exceptionVarExpr.toBuilder().setIsDecl(true).build())
            .setValueExpr(
                NewObjectExpr.builder()
                    .setType(FIXED_GRPC_TYPESTORE.get("StatusRuntimeException"))
                    .setArguments(
                        EnumRefExpr.builder()
                            .setType(GRPC_STATUS_TYPE)
                            .setName("INVALID_ARGUMENT")
                            .build())
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
    // Build the request variable and assign it.
    VariableExpr requestVarExpr =
        VariableExpr.withVariable(
            Variable.builder().setType(method.inputType()).setName("request").build());
    Message requestMessage = messageTypes.get(method.inputType().reference().fullName());
    Preconditions.checkNotNull(requestMessage);
    Expr valExpr =
        DefaultValueComposer.createSimpleMessageBuilderValue(
            requestMessage, resourceNames, messageTypes, method.httpBindings());

    List<Statement> statements = new ArrayList<>();
    statements.add(
        ExprStatement.withExpr(
            AssignmentExpr.builder()
                .setVariableExpr(requestVarExpr.toBuilder().setIsDecl(true).build())
                .setValueExpr(valExpr)
                .build()));
    statements.add(EMPTY_LINE_STATEMENT);

    // Build the responseObserver variable.
    VariableExpr responseObserverVarExpr =
        VariableExpr.withVariable(
            Variable.builder()
                .setType(
                    TypeNode.withReference(
                        FIXED_GRPC_TYPESTORE
                            .get("MockStreamObserver")
                            .reference()
                            .copyAndSetGenerics(Arrays.asList(method.outputType().reference()))))
                .setName("responseObserver")
                .build());

    statements.add(
        ExprStatement.withExpr(
            AssignmentExpr.builder()
                .setVariableExpr(responseObserverVarExpr.toBuilder().setIsDecl(true).build())
                .setValueExpr(
                    NewObjectExpr.builder()
                        .setType(FIXED_GRPC_TYPESTORE.get("MockStreamObserver"))
                        .setIsGeneric(true)
                        .build())
                .build()));
    statements.add(EMPTY_LINE_STATEMENT);

    // Build the callable variable and assign it.
    VariableExpr callableVarExpr =
        VariableExpr.withVariable(
            Variable.builder().setType(getCallableType(method)).setName("callable").build());
    Expr streamingCallExpr =
        MethodInvocationExpr.builder()
            .setExprReferenceExpr(classMemberVarExprs.get("client"))
            .setMethodName(String.format("%sCallable", JavaStyle.toLowerCamelCase(method.name())))
            .setReturnType(callableVarExpr.type())
            .build();

    List<Expr> exprs = new ArrayList<>();
    exprs.add(
        AssignmentExpr.builder()
            .setVariableExpr(callableVarExpr.toBuilder().setIsDecl(true).build())
            .setValueExpr(streamingCallExpr)
            .build());

    if (method.stream().equals(Method.Stream.SERVER)) {
      exprs.add(
          MethodInvocationExpr.builder()
              .setExprReferenceExpr(callableVarExpr)
              .setMethodName("serverStreamingCall")
              .setArguments(requestVarExpr, responseObserverVarExpr)
              .build());
    } else {
      // Call the streaming-variant callable method.
      VariableExpr requestObserverVarExpr =
          VariableExpr.withVariable(
              Variable.builder()
                  .setType(
                      TypeNode.withReference(
                          FIXED_TYPESTORE
                              .get("ApiStreamObserver")
                              .reference()
                              .copyAndSetGenerics(Arrays.asList(method.inputType().reference()))))
                  .setName("requestObserver")
                  .build());

      List<Expr> callableMethodArgs = new ArrayList<>();
      if (!method.stream().equals(Method.Stream.BIDI)
          && !method.stream().equals(Method.Stream.CLIENT)) {
        callableMethodArgs.add(requestVarExpr);
      }
      callableMethodArgs.add(responseObserverVarExpr);
      exprs.add(
          AssignmentExpr.builder()
              .setVariableExpr(requestObserverVarExpr.toBuilder().setIsDecl(true).build())
              .setValueExpr(
                  MethodInvocationExpr.builder()
                      .setExprReferenceExpr(callableVarExpr)
                      .setMethodName(getCallableMethodName(method))
                      .setArguments(callableMethodArgs)
                      .setReturnType(requestObserverVarExpr.type())
                      .build())
              .build());

      statements.addAll(
          exprs.stream().map(e -> ExprStatement.withExpr(e)).collect(Collectors.toList()));
      exprs.clear();
      statements.add(EMPTY_LINE_STATEMENT);

      exprs.add(
          MethodInvocationExpr.builder()
              .setExprReferenceExpr(requestObserverVarExpr)
              .setMethodName("onNext")
              .setArguments(requestVarExpr)
              .build());
    }
    statements.addAll(
        exprs.stream().map(e -> ExprStatement.withExpr(e)).collect(Collectors.toList()));
    exprs.clear();
    statements.add(EMPTY_LINE_STATEMENT);

    List<Expr> tryBodyExprs = new ArrayList<>();
    // TODO(v2): This variable is unused in the generated test, it can be deleted.
    VariableExpr actualResponsesVarExpr =
        VariableExpr.withVariable(
            Variable.builder()
                .setType(
                    TypeNode.withReference(
                        ConcreteReference.builder()
                            .setClazz(List.class)
                            .setGenerics(Arrays.asList(method.outputType().reference()))
                            .build()))
                .setName("actualResponses")
                .build());

    Expr getFutureResponseExpr =
        MethodInvocationExpr.builder()
            .setExprReferenceExpr(responseObserverVarExpr)
            .setMethodName("future")
            .build();
    getFutureResponseExpr =
        MethodInvocationExpr.builder()
            .setExprReferenceExpr(getFutureResponseExpr)
            .setMethodName("get")
            .setReturnType(actualResponsesVarExpr.type())
            .build();
    tryBodyExprs.add(
        AssignmentExpr.builder()
            .setVariableExpr(actualResponsesVarExpr.toBuilder().setIsDecl(true).build())
            .setValueExpr(getFutureResponseExpr)
            .build());
    // Assert a failure if no exception was raised.
    tryBodyExprs.add(
        MethodInvocationExpr.builder()
            .setStaticReferenceType(FIXED_TYPESTORE.get("Assert"))
            .setMethodName("fail")
            .setArguments(ValueExpr.withValue(StringObjectValue.withValue("No exception thrown")))
            .build());

    VariableExpr catchExceptionVarExpr =
        VariableExpr.builder()
            .setVariable(
                Variable.builder()
                    .setType(TypeNode.withExceptionClazz(ExecutionException.class))
                    .setName("e")
                    .build())
            .build();

    TryCatchStatement tryCatchBlock =
        TryCatchStatement.builder()
            .setTryBody(
                tryBodyExprs.stream()
                    .map(e -> ExprStatement.withExpr(e))
                    .collect(Collectors.toList()))
            .addCatch(
                catchExceptionVarExpr.toBuilder().setIsDecl(true).build(),
                createRpcLroExceptionTestCatchBody(catchExceptionVarExpr, true))
            .build();

    statements.add(tryCatchBlock);
    return statements;
  }

  @Override
  protected List<Statement> createRpcLroExceptionTestCatchBody(
      VariableExpr exceptionExpr, boolean isStreaming) {
    List<Expr> catchBodyExprs = new ArrayList<>();

    Expr testExpectedValueExpr =
        VariableExpr.builder()
            .setVariable(Variable.builder().setType(TypeNode.CLASS_OBJECT).setName("class").build())
            .setStaticReferenceType(FIXED_TYPESTORE.get("InvalidArgumentException"))
            .build();
    Expr getCauseExpr =
        MethodInvocationExpr.builder()
            .setExprReferenceExpr(exceptionExpr)
            .setMethodName("getCause")
            .setReturnType(TypeNode.withReference(ConcreteReference.withClazz(Throwable.class)))
            .build();
    Expr testActualValueExpr =
        MethodInvocationExpr.builder()
            .setExprReferenceExpr(getCauseExpr)
            .setMethodName("getClass")
            .build();

    if (isStreaming) {
      InstanceofExpr checkInstanceExpr =
          InstanceofExpr.builder()
              .setExpr(getCauseExpr)
              .setCheckType(FIXED_TYPESTORE.get("InvalidArgumentException"))
              .build();
      catchBodyExprs.add(
          MethodInvocationExpr.builder()
              .setStaticReferenceType(FIXED_TYPESTORE.get("Assert"))
              .setMethodName("assertTrue")
              .setArguments(checkInstanceExpr)
              .build());
    } else {
      // Constructs `Assert.assertEquals(InvalidArgumentException.class, e.getCaus().getClass());`.
      catchBodyExprs.add(
          MethodInvocationExpr.builder()
              .setStaticReferenceType(FIXED_TYPESTORE.get("Assert"))
              .setMethodName("assertEquals")
              .setArguments(testExpectedValueExpr, testActualValueExpr)
              .build());
    }

    // Construct the apiException variable.
    VariableExpr apiExceptionVarExpr =
        VariableExpr.withVariable(
            Variable.builder()
                .setType(FIXED_TYPESTORE.get("InvalidArgumentException"))
                .setName("apiException")
                .build());
    Expr castedCauseExpr =
        CastExpr.builder()
            .setType(FIXED_TYPESTORE.get("InvalidArgumentException"))
            .setExpr(getCauseExpr)
            .build();
    catchBodyExprs.add(
        AssignmentExpr.builder()
            .setVariableExpr(apiExceptionVarExpr.toBuilder().setIsDecl(true).build())
            .setValueExpr(castedCauseExpr)
            .build());

    // Construct the last assert statement.
    testExpectedValueExpr =
        EnumRefExpr.builder()
            .setType(
                TypeNode.withReference(
                    ConcreteReference.builder()
                        .setClazz(StatusCode.Code.class)
                        .setIsStaticImport(false)
                        .build()))
            .setName("INVALID_ARGUMENT")
            .build();
    testActualValueExpr =
        MethodInvocationExpr.builder()
            .setExprReferenceExpr(apiExceptionVarExpr)
            .setMethodName("getStatusCode")
            .build();
    testActualValueExpr =
        MethodInvocationExpr.builder()
            .setExprReferenceExpr(testActualValueExpr)
            .setMethodName("getCode")
            .build();
    catchBodyExprs.add(
        MethodInvocationExpr.builder()
            .setStaticReferenceType(FIXED_TYPESTORE.get("Assert"))
            .setMethodName("assertEquals")
            .setArguments(testExpectedValueExpr, testActualValueExpr)
            .build());

    return catchBodyExprs.stream().map(e -> ExprStatement.withExpr(e)).collect(Collectors.toList());
  }
}
