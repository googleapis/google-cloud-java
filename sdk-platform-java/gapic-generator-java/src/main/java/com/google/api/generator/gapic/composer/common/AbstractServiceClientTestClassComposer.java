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

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiStreamObserver;
import com.google.api.gax.rpc.BidiStreamingCallable;
import com.google.api.gax.rpc.ClientStreamingCallable;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.ServerStreamingCallable;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.generator.engine.ast.AnnotationNode;
import com.google.api.generator.engine.ast.AssignmentExpr;
import com.google.api.generator.engine.ast.ClassDefinition;
import com.google.api.generator.engine.ast.CommentStatement;
import com.google.api.generator.engine.ast.ConcreteReference;
import com.google.api.generator.engine.ast.EmptyLineStatement;
import com.google.api.generator.engine.ast.Expr;
import com.google.api.generator.engine.ast.ExprStatement;
import com.google.api.generator.engine.ast.LineComment;
import com.google.api.generator.engine.ast.MethodDefinition;
import com.google.api.generator.engine.ast.MethodInvocationExpr;
import com.google.api.generator.engine.ast.PrimitiveValue;
import com.google.api.generator.engine.ast.Reference;
import com.google.api.generator.engine.ast.ScopeNode;
import com.google.api.generator.engine.ast.Statement;
import com.google.api.generator.engine.ast.StringObjectValue;
import com.google.api.generator.engine.ast.TryCatchStatement;
import com.google.api.generator.engine.ast.TypeNode;
import com.google.api.generator.engine.ast.ValueExpr;
import com.google.api.generator.engine.ast.VaporReference;
import com.google.api.generator.engine.ast.Variable;
import com.google.api.generator.engine.ast.VariableExpr;
import com.google.api.generator.gapic.composer.defaultvalue.DefaultValueComposer;
import com.google.api.generator.gapic.composer.store.TypeStore;
import com.google.api.generator.gapic.composer.utils.ClassNames;
import com.google.api.generator.gapic.composer.utils.CommonStrings;
import com.google.api.generator.gapic.model.Field;
import com.google.api.generator.gapic.model.GapicClass;
import com.google.api.generator.gapic.model.GapicClass.Kind;
import com.google.api.generator.gapic.model.GapicContext;
import com.google.api.generator.gapic.model.Message;
import com.google.api.generator.gapic.model.Method;
import com.google.api.generator.gapic.model.MethodArgument;
import com.google.api.generator.gapic.model.ResourceName;
import com.google.api.generator.gapic.model.Service;
import com.google.api.generator.gapic.utils.JavaStyle;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Any;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public abstract class AbstractServiceClientTestClassComposer implements ClassComposer {

  protected static final Statement EMPTY_LINE_STATEMENT = EmptyLineStatement.create();

  protected static final String CLIENT_VAR_NAME = "client";
  private static final String MOCK_SERVICE_VAR_NAME_PATTERN = "mock%s";

  protected static final TypeStore FIXED_TYPESTORE = createStaticTypes();
  protected static final AnnotationNode TEST_ANNOTATION =
      AnnotationNode.withType(FIXED_TYPESTORE.get("Test"));

  private final TransportContext transportContext;

  protected AbstractServiceClientTestClassComposer(TransportContext transportContext) {
    this.transportContext = transportContext;
  }

  public TransportContext getTransportContext() {
    return transportContext;
  }

  @Override
  public GapicClass generate(GapicContext context, Service service) {
    return generate(ClassNames.getServiceClientTestClassName(service), context, service);
  }

  protected GapicClass generate(String className, GapicContext context, Service service) {
    // Do not generate Client Test code for Transport if there are no matching RPCs for a Transport
    if (!service.hasAnyEnabledMethodsForTransport(getTransportContext().transport())) {
      return GapicClass.createNonGeneratedGapicClass();
    }

    Map<String, ResourceName> resourceNames = context.helperResourceNames();
    String pakkage = service.pakkage();
    TypeStore typeStore = new TypeStore();
    addDynamicTypes(context, service, typeStore);
    GapicClass.Kind kind = Kind.MAIN;

    Map<String, VariableExpr> classMemberVarExprs =
        createClassMemberVarExprs(service, context, typeStore);

    ClassDefinition classDef =
        ClassDefinition.builder()
            .setPackageString(pakkage)
            .setAnnotations(createClassAnnotations())
            .setScope(ScopeNode.PUBLIC)
            .setName(className)
            .setStatements(createClassMemberFieldDecls(classMemberVarExprs))
            .setMethods(
                createClassMethods(service, context, classMemberVarExprs, typeStore, resourceNames))
            .build();
    return GapicClass.create(kind, classDef);
  }

  private List<AnnotationNode> createClassAnnotations() {
    return Arrays.asList(
        AnnotationNode.builder()
            .setType(FIXED_TYPESTORE.get("Generated"))
            .setDescription("by gapic-generator-java")
            .build());
  }

  protected abstract Map<String, VariableExpr> createClassMemberVarExprs(
      Service service, GapicContext context, TypeStore typeStore);

  protected List<Statement> createClassMemberFieldDecls(
      Map<String, VariableExpr> classMemberVarExprs) {
    Function<VariableExpr, Boolean> isMockVarExprFn =
        v -> v.type().reference().name().startsWith("Mock");

    // Ordering matters for pretty-printing and ensuring that test output is deterministic.
    List<Statement> fieldDeclStatements = new ArrayList<>();

    // Static fields go first.
    fieldDeclStatements.addAll(
        classMemberVarExprs.values().stream()
            .filter(v -> isMockVarExprFn.apply(v))
            .map(
                v ->
                    ExprStatement.withExpr(
                        v.toBuilder()
                            .setIsDecl(true)
                            .setScope(ScopeNode.PRIVATE)
                            .setIsStatic(true)
                            .build()))
            .collect(Collectors.toList()));

    fieldDeclStatements.addAll(
        classMemberVarExprs.values().stream()
            .filter(v -> !isMockVarExprFn.apply(v))
            .map(
                v ->
                    ExprStatement.withExpr(
                        v.toBuilder().setIsDecl(true).setScope(ScopeNode.PRIVATE).build()))
            .collect(Collectors.toList()));
    return fieldDeclStatements;
  }

  private List<MethodDefinition> createClassMethods(
      Service service,
      GapicContext context,
      Map<String, VariableExpr> classMemberVarExprs,
      TypeStore typeStore,
      Map<String, ResourceName> resourceNames) {
    List<MethodDefinition> javaMethods = new ArrayList<>();
    javaMethods.addAll(createTestAdminMethods(service, context, classMemberVarExprs, typeStore));
    javaMethods.addAll(createTestMethods(service, context, classMemberVarExprs, resourceNames));
    return javaMethods;
  }

  private List<MethodDefinition> createTestAdminMethods(
      Service service,
      GapicContext context,
      Map<String, VariableExpr> classMemberVarExprs,
      TypeStore typeStore) {
    List<MethodDefinition> javaMethods = new ArrayList<>();
    javaMethods.add(
        createStartStaticServerMethod(
            service, context, classMemberVarExprs, typeStore, "newBuilder"));
    javaMethods.add(createStopServerMethod(service, classMemberVarExprs));
    javaMethods.add(createSetUpMethod(service, classMemberVarExprs, typeStore));
    javaMethods.add(createTearDownMethod(service, classMemberVarExprs));
    return javaMethods;
  }

  protected abstract MethodDefinition createStartStaticServerMethod(
      Service service,
      GapicContext context,
      Map<String, VariableExpr> classMemberVarExprs,
      TypeStore typeStore,
      String newBuilderMethod);

  protected abstract MethodDefinition createStopServerMethod(
      Service service, Map<String, VariableExpr> classMemberVarExprs);

  protected abstract MethodDefinition createSetUpMethod(
      Service service, Map<String, VariableExpr> classMemberVarExprs, TypeStore typeStore);

  protected abstract MethodDefinition createTearDownMethod(
      Service service, Map<String, VariableExpr> classMemberVarExprs);

  private List<MethodDefinition> createTestMethods(
      Service service,
      GapicContext context,
      Map<String, VariableExpr> classMemberVarExprs,
      Map<String, ResourceName> resourceNames) {
    Map<String, Message> messageTypes = context.messages();
    List<MethodDefinition> javaMethods = new ArrayList<>();
    for (Method method : service.methods()) {
      if (!method.isSupportedByTransport(getTransportContext().transport())) {
        javaMethods.add(createUnsupportedTestMethod(method));
        continue;
      }
      Service matchingService = service;
      if (method.isMixin()) {
        int dotIndex = method.mixedInApiName().lastIndexOf(".");
        String mixinServiceName = method.mixedInApiName().substring(dotIndex + 1);
        String mixinServiceProtoPackage = method.mixedInApiName().substring(0, dotIndex);
        Optional<Service> mixinServiceOpt =
            context.mixinServices().stream()
                .filter(
                    s ->
                        s.name().equals(mixinServiceName)
                            && s.protoPakkage().equals(mixinServiceProtoPackage))
                .findFirst();
        if (mixinServiceOpt.isPresent()) {
          matchingService = mixinServiceOpt.get();
        }
      }

      // Ignore variants for streaming methods as well.
      if (method.methodSignatures().isEmpty() || !method.stream().equals(Method.Stream.NONE)) {
        javaMethods.add(
            createRpcTestMethod(
                method,
                service,
                matchingService,
                Collections.emptyList(),
                0,
                true,
                classMemberVarExprs,
                resourceNames,
                messageTypes));
        javaMethods.add(
            createRpcExceptionTestMethod(
                method,
                matchingService,
                Collections.emptyList(),
                0,
                classMemberVarExprs,
                resourceNames,
                messageTypes));
      } else {
        for (int i = 0; i < method.methodSignatures().size(); i++) {
          javaMethods.add(
              createRpcTestMethod(
                  method,
                  service,
                  matchingService,
                  method.methodSignatures().get(i),
                  i,
                  false,
                  classMemberVarExprs,
                  resourceNames,
                  messageTypes));
          javaMethods.add(
              createRpcExceptionTestMethod(
                  method,
                  matchingService,
                  method.methodSignatures().get(i),
                  i,
                  classMemberVarExprs,
                  resourceNames,
                  messageTypes));
        }
      }
    }
    return javaMethods;
  }

  /**
   * Creates a test method for a given RPC, e.g. createAssetTest.
   *
   * @param method the RPC for which this test method is created.
   * @param apiService the host service under test.
   * @param rpcService the service that {@code method} belongs to. This is not equal to {@code
   *     apiService} only when {@code method} is a mixin, in which case {@code rpcService} is the
   *     mixed-in service. If {@code apiService} and {@code rpcService} are different, they will be
   *     used only for pagination. Otherwise, {@code rpcService} subsumes {@code apiService}.
   * @param methodSignature the method signature of the RPC under test.
   * @param variantIndex the nth variant of the RPC under test. This applies when we have
   *     polymorphism due to the presence of several method signature annotations in the proto.
   * @param isRequestArg whether the RPC variant under test take only the request proto message.
   * @param classMemberVarExprs the class members in the generated test class.
   * @param resourceNames the resource names available for use.
   * @param messageTypes the proto message types available for use.
   */
  private MethodDefinition createRpcTestMethod(
      Method method,
      Service apiService,
      Service rpcService,
      List<MethodArgument> methodSignature,
      int variantIndex,
      boolean isRequestArg,
      Map<String, VariableExpr> classMemberVarExprs,
      Map<String, ResourceName> resourceNames,
      Map<String, Message> messageTypes) {
    if (!method.stream().equals(Method.Stream.NONE)) {
      return createStreamingRpcTestMethod(
          rpcService, method, classMemberVarExprs, resourceNames, messageTypes);
    }
    // Construct the expected response.
    TypeNode methodOutputType = method.hasLro() ? method.lro().responseType() : method.outputType();
    List<Expr> methodExprs = new ArrayList<>();

    TypeNode repeatedResponseType = null;
    VariableExpr responsesElementVarExpr = null;
    String mockServiceVarName = getMockServiceVarName(rpcService);
    if (method.isPaged()) {
      Message methodOutputMessage = messageTypes.get(method.outputType().reference().fullName());
      Field repeatedPagedResultsField = methodOutputMessage.findAndUnwrapPaginatedRepeatedField();
      Preconditions.checkNotNull(
          repeatedPagedResultsField,
          String.format(
              "No repeated field found for paged method %s with output message type %s",
              method.name(), methodOutputMessage.name()));

      if (repeatedPagedResultsField.isMap()) {
        repeatedResponseType =
            TypeNode.withReference(repeatedPagedResultsField.type().reference().generics().get(1));
      } else {
        // Must be a non-repeated type.
        repeatedResponseType = repeatedPagedResultsField.type();
      }

      responsesElementVarExpr =
          VariableExpr.withVariable(
              Variable.builder().setType(repeatedResponseType).setName("responsesElement").build());
      methodExprs.add(
          AssignmentExpr.builder()
              .setVariableExpr(responsesElementVarExpr.toBuilder().setIsDecl(true).build())
              .setValueExpr(
                  DefaultValueComposer.createValue(
                      Field.builder()
                          .setType(repeatedResponseType)
                          .setName("responsesElement")
                          .setIsMessage(!repeatedResponseType.isProtoPrimitiveType())
                          .build()))
              .build());
    }

    VariableExpr expectedResponseVarExpr =
        VariableExpr.withVariable(
            Variable.builder().setType(methodOutputType).setName("expectedResponse").build());
    Expr expectedResponseValExpr = null;
    if (method.isPaged()) {
      Message methodOutputMessage = messageTypes.get(method.outputType().reference().fullName());
      Field firstRepeatedField = methodOutputMessage.findAndUnwrapPaginatedRepeatedField();
      Preconditions.checkNotNull(
          firstRepeatedField,
          String.format(
              "Expected paged RPC %s to have a repeated field in the response %s but found none",
              method.name(), methodOutputMessage.name()));

      expectedResponseValExpr =
          DefaultValueComposer.createSimplePagedResponseValue(
              method.outputType(),
              firstRepeatedField.name(),
              responsesElementVarExpr,
              firstRepeatedField.isMap());
    } else {
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
    }

    methodExprs.add(
        AssignmentExpr.builder()
            .setVariableExpr(expectedResponseVarExpr.toBuilder().setIsDecl(true).build())
            .setValueExpr(expectedResponseValExpr)
            .build());

    if (method.hasLro()
        && (method.lro().operationServiceStubType() == null
            || !method.lro().responseType().equals(method.outputType()))) {

      VariableExpr resultOperationVarExpr =
          VariableExpr.withVariable(
              Variable.builder()
                  .setType(FIXED_TYPESTORE.get("Operation"))
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
    List<Statement> methodStatements = new ArrayList<>();
    methodStatements.addAll(
        methodExprs.stream().map(e -> ExprStatement.withExpr(e)).collect(Collectors.toList()));
    methodExprs.clear();
    methodStatements.add(EMPTY_LINE_STATEMENT);

    // Construct the request or method arguments.
    VariableExpr requestVarExpr = null;
    Message requestMessage = null;
    List<VariableExpr> argExprs = new ArrayList<>();
    if (isRequestArg) {
      requestVarExpr =
          VariableExpr.withVariable(
              Variable.builder().setType(method.inputType()).setName("request").build());
      argExprs.add(requestVarExpr);
      requestMessage = messageTypes.get(method.inputType().reference().fullName());
      Preconditions.checkNotNull(requestMessage);
      Map<String, String> pathParamValuePatterns = Collections.emptyMap();
      if (getTransportContext().useValuePatterns() && method.hasHttpBindings()) {
        pathParamValuePatterns = method.httpBindings().getPathParametersValuePatterns();
      }

      Expr valExpr =
          DefaultValueComposer.createSimpleMessageBuilderValue(
              requestMessage,
              resourceNames,
              messageTypes,
              pathParamValuePatterns,
              method.httpBindings());
      methodExprs.add(
          AssignmentExpr.builder()
              .setVariableExpr(requestVarExpr.toBuilder().setIsDecl(true).build())
              .setValueExpr(valExpr)
              .build());
    } else {
      Map<String, String> valuePatterns = Collections.emptyMap();
      if (getTransportContext().useValuePatterns() && method.hasHttpBindings()) {
        valuePatterns = method.httpBindings().getPathParametersValuePatterns();
      }
      for (MethodArgument methodArg : methodSignature) {
        String methodArgName = JavaStyle.toLowerCamelCase(methodArg.name());
        VariableExpr varExpr =
            VariableExpr.withVariable(
                Variable.builder().setType(methodArg.type()).setName(methodArgName).build());
        argExprs.add(varExpr);
        Expr valExpr =
            DefaultValueComposer.createMethodArgValue(
                methodArg, resourceNames, messageTypes, valuePatterns, method.httpBindings());
        methodExprs.add(
            AssignmentExpr.builder()
                .setVariableExpr(varExpr.toBuilder().setIsDecl(true).build())
                .setValueExpr(valExpr)
                .build());
      }
    }
    methodStatements.addAll(
        methodExprs.stream().map(e -> ExprStatement.withExpr(e)).collect(Collectors.toList()));
    methodExprs.clear();
    methodStatements.add(EMPTY_LINE_STATEMENT);

    // Call the RPC Java method.
    VariableExpr actualResponseVarExpr =
        VariableExpr.withVariable(
            Variable.builder()
                .setType(
                    !method.isPaged()
                        ? methodOutputType
                        // If this method is a paginated mixin, use the host service, since
                        // ServiceClient defines the paged response class and the mixed-in service
                        // does not have a client.
                        : getPagedResponseType(method, method.isMixin() ? apiService : rpcService))
                .setName(method.isPaged() ? "pagedListResponse" : "actualResponse")
                .build());
    Expr rpcJavaMethodInvocationExpr =
        MethodInvocationExpr.builder()
            .setExprReferenceExpr(classMemberVarExprs.get("client"))
            .setMethodName(
                JavaStyle.toLowerCamelCase(method.name()) + (method.hasLro() ? "Async" : ""))
            .setArguments(argExprs.stream().map(e -> (Expr) e).collect(Collectors.toList()))
            .setReturnType(actualResponseVarExpr.type())
            .build();
    if (method.hasLro()) {
      rpcJavaMethodInvocationExpr =
          MethodInvocationExpr.builder()
              .setExprReferenceExpr(rpcJavaMethodInvocationExpr)
              .setMethodName("get")
              .setReturnType(rpcJavaMethodInvocationExpr.type())
              .build();
    }

    boolean returnsVoid = isProtoEmptyType(methodOutputType);
    if (returnsVoid) {
      methodExprs.add(rpcJavaMethodInvocationExpr);
    } else {
      methodExprs.add(
          AssignmentExpr.builder()
              .setVariableExpr(actualResponseVarExpr.toBuilder().setIsDecl(true).build())
              .setValueExpr(rpcJavaMethodInvocationExpr)
              .build());
    }

    if (method.isPaged()) {
      Message methodOutputMessage = messageTypes.get(method.outputType().reference().fullName());
      Field repeatedPagedResultsField = methodOutputMessage.findAndUnwrapPaginatedRepeatedField();

      // Assign the resources variable.
      VariableExpr resourcesVarExpr =
          VariableExpr.withVariable(
              Variable.builder()
                  .setType(
                      TypeNode.withReference(
                          ConcreteReference.builder()
                              .setClazz(List.class)
                              .setGenerics(
                                  Arrays.asList(repeatedPagedResultsField.type().reference()))
                              .build()))
                  .setName("resources")
                  .build());
      Expr iterateAllExpr =
          MethodInvocationExpr.builder()
              .setExprReferenceExpr(actualResponseVarExpr)
              .setMethodName("iterateAll")
              .build();
      Expr resourcesValExpr =
          MethodInvocationExpr.builder()
              .setStaticReferenceType(FIXED_TYPESTORE.get("Lists"))
              .setMethodName("newArrayList")
              .setArguments(iterateAllExpr)
              .setReturnType(resourcesVarExpr.type())
              .build();

      methodStatements.addAll(
          methodExprs.stream().map(e -> ExprStatement.withExpr(e)).collect(Collectors.toList()));
      methodExprs.clear();
      methodStatements.add(EMPTY_LINE_STATEMENT);

      methodStatements.add(
          ExprStatement.withExpr(
              AssignmentExpr.builder()
                  .setVariableExpr(resourcesVarExpr.toBuilder().setIsDecl(true).build())
                  .setValueExpr(resourcesValExpr)
                  .build()));
      methodStatements.add(EMPTY_LINE_STATEMENT);

      // Assert the size is equivalent.
      methodExprs.add(
          MethodInvocationExpr.builder()
              .setStaticReferenceType(FIXED_TYPESTORE.get("Assert"))
              .setMethodName("assertEquals")
              .setArguments(
                  ValueExpr.withValue(
                      PrimitiveValue.builder().setType(TypeNode.INT).setValue("1").build()),
                  MethodInvocationExpr.builder()
                      .setExprReferenceExpr(resourcesVarExpr)
                      .setMethodName("size")
                      .setReturnType(TypeNode.INT)
                      .build())
              .build());

      // Assert the responses are equivalent.
      Preconditions.checkNotNull(
          repeatedPagedResultsField,
          String.format(
              "No repeated field found for paged method %s with output message type %s",
              method.name(), methodOutputMessage.name()));

      Expr zeroExpr =
          ValueExpr.withValue(PrimitiveValue.builder().setType(TypeNode.INT).setValue("0").build());

      // Generated code:
      // Assert.assertEquals(
      //   expectedResponse.getItemsMap().entrySet().iterator().next(), resources.get(0));
      // )
      Expr expectedPagedResponseExpr;
      if (repeatedPagedResultsField.isMap()) {
        expectedPagedResponseExpr =
            MethodInvocationExpr.builder()
                .setMethodName("next")
                .setExprReferenceExpr(
                    MethodInvocationExpr.builder()
                        .setMethodName("iterator")
                        .setExprReferenceExpr(
                            MethodInvocationExpr.builder()
                                .setMethodName("entrySet")
                                .setExprReferenceExpr(
                                    MethodInvocationExpr.builder()
                                        .setExprReferenceExpr(expectedResponseVarExpr)
                                        .setMethodName(
                                            String.format(
                                                "get%sMap",
                                                JavaStyle.toUpperCamelCase(
                                                    repeatedPagedResultsField.name())))
                                        .build())
                                .build())
                        .build())
                .build();

      } else {
        // Generated code:
        // Assert.assertEquals(expectedResponse.getItemsList().get(0), resources.get(0));
        expectedPagedResponseExpr =
            MethodInvocationExpr.builder()
                .setExprReferenceExpr(expectedResponseVarExpr)
                .setMethodName(
                    String.format(
                        "get%sList", JavaStyle.toUpperCamelCase(repeatedPagedResultsField.name())))
                .build();
        expectedPagedResponseExpr =
            MethodInvocationExpr.builder()
                .setExprReferenceExpr(expectedPagedResponseExpr)
                .setMethodName("get")
                .setArguments(zeroExpr)
                .build();
      }
      Expr actualPagedResponseExpr =
          MethodInvocationExpr.builder()
              .setExprReferenceExpr(resourcesVarExpr)
              .setMethodName("get")
              .setArguments(zeroExpr)
              .build();

      methodExprs.add(
          MethodInvocationExpr.builder()
              .setStaticReferenceType(FIXED_TYPESTORE.get("Assert"))
              .setMethodName("assertEquals")
              .setArguments(expectedPagedResponseExpr, actualPagedResponseExpr)
              .build());
    } else if (!returnsVoid) {
      methodExprs.add(
          MethodInvocationExpr.builder()
              .setStaticReferenceType(FIXED_TYPESTORE.get("Assert"))
              .setMethodName("assertEquals")
              .setArguments(expectedResponseVarExpr, actualResponseVarExpr)
              .build());
    }
    methodStatements.addAll(
        methodExprs.stream().map(e -> ExprStatement.withExpr(e)).collect(Collectors.toList()));
    methodExprs.clear();
    methodStatements.add(EMPTY_LINE_STATEMENT);

    methodStatements.addAll(
        constructRpcTestCheckerLogic(
            method,
            methodSignature,
            rpcService,
            isRequestArg,
            classMemberVarExprs,
            requestVarExpr,
            requestMessage));

    String testMethodName =
        String.format(
            "%sTest%s",
            JavaStyle.toLowerCamelCase(method.name()), variantIndex > 0 ? variantIndex + 1 : "");

    return MethodDefinition.builder()
        .setAnnotations(Arrays.asList(TEST_ANNOTATION))
        .setScope(ScopeNode.PUBLIC)
        .setReturnType(TypeNode.VOID)
        .setName(testMethodName)
        .setThrowsExceptions(Arrays.asList(TypeNode.withExceptionClazz(Exception.class)))
        .setBody(methodStatements)
        .build();
  }

  protected abstract List<Statement> constructRpcTestCheckerLogic(
      Method method,
      List<MethodArgument> methodSignature,
      Service service,
      boolean isRequestArg,
      Map<String, VariableExpr> classMemberVarExprs,
      VariableExpr requestVarExpr,
      Message requestMessage);

  protected abstract MethodDefinition createStreamingRpcTestMethod(
      Service service,
      Method method,
      Map<String, VariableExpr> classMemberVarExprs,
      Map<String, ResourceName> resourceNames,
      Map<String, Message> messageTypes);

  /**
   * Creates a test method to exercise exceptions for a given RPC, e.g. createAssetTest.
   *
   * @param method the RPC for which this test method is created.
   * @param service the service that {@code method} belongs to.
   * @param methodSignature the method signature of the RPC under test.
   * @param variantIndex the nth variant of the RPC under test. This applies when we have
   *     polymorphism due to the presence of several method signature annotations in the proto.
   * @param classMemberVarExprs the class members in the generated test class.
   * @param resourceNames the resource names available for use.
   * @param messageTypes the proto message types available for use.
   */
  protected abstract MethodDefinition createRpcExceptionTestMethod(
      Method method,
      Service service,
      List<MethodArgument> methodSignature,
      int variantIndex,
      Map<String, VariableExpr> classMemberVarExprs,
      Map<String, ResourceName> resourceNames,
      Map<String, Message> messageTypes);

  protected abstract List<Statement> createStreamingRpcExceptionTestStatements(
      Method method,
      Map<String, VariableExpr> classMemberVarExprs,
      Map<String, ResourceName> resourceNames,
      Map<String, Message> messageTypes);

  protected MethodDefinition createUnsupportedTestMethod(Method method) {
    String javaMethodName = JavaStyle.toLowerCamelCase(method.name());
    String exceptionTestMethodName = String.format("%sUnsupportedMethodTest", javaMethodName);

    List<Statement> methodBody =
        Collections.singletonList(
            CommentStatement.withComment(
                LineComment.withComment(
                    "The "
                        + javaMethodName
                        + "() method is not supported in "
                        + String.join("+", getTransportContext().transportNames())
                        + " transport.\n"
                        + "This empty test is generated for technical reasons.")));

    return MethodDefinition.builder()
        .setAnnotations(Arrays.asList(TEST_ANNOTATION))
        .setScope(ScopeNode.PUBLIC)
        .setReturnType(TypeNode.VOID)
        .setName(exceptionTestMethodName)
        .setThrowsExceptions(Arrays.asList(TypeNode.withExceptionClazz(Exception.class)))
        .setBody(methodBody)
        .build();
  }

  protected List<Statement> createRpcExceptionTestStatements(
      Method method,
      List<MethodArgument> methodSignature,
      Map<String, VariableExpr> classMemberVarExprs,
      Map<String, ResourceName> resourceNames,
      Map<String, Message> messageTypes) {
    List<VariableExpr> argVarExprs = new ArrayList<>();
    List<Expr> tryBodyExprs = new ArrayList<>();

    if (methodSignature.isEmpty()) {
      // Construct the actual request.
      VariableExpr varExpr =
          VariableExpr.withVariable(
              Variable.builder().setType(method.inputType()).setName("request").build());
      argVarExprs.add(varExpr);
      Message requestMessage = messageTypes.get(method.inputType().reference().fullName());
      Preconditions.checkNotNull(requestMessage);
      Map<String, String> valuePatterns = Collections.emptyMap();
      if (getTransportContext().useValuePatterns() && method.hasHttpBindings()) {
        valuePatterns = method.httpBindings().getPathParametersValuePatterns();
      }
      Expr valExpr =
          DefaultValueComposer.createSimpleMessageBuilderValue(
              requestMessage, resourceNames, messageTypes, valuePatterns, method.httpBindings());
      tryBodyExprs.add(
          AssignmentExpr.builder()
              .setVariableExpr(varExpr.toBuilder().setIsDecl(true).build())
              .setValueExpr(valExpr)
              .build());
    } else {
      Map<String, String> valuePatterns = Collections.emptyMap();
      if (getTransportContext().useValuePatterns() && method.hasHttpBindings()) {
        valuePatterns = method.httpBindings().getPathParametersValuePatterns();
      }
      for (MethodArgument methodArg : methodSignature) {
        String methodArgName = JavaStyle.toLowerCamelCase(methodArg.name());
        VariableExpr varExpr =
            VariableExpr.withVariable(
                Variable.builder().setType(methodArg.type()).setName(methodArgName).build());
        argVarExprs.add(varExpr);
        Expr valExpr =
            DefaultValueComposer.createMethodArgValue(
                methodArg, resourceNames, messageTypes, valuePatterns, method.httpBindings());
        tryBodyExprs.add(
            AssignmentExpr.builder()
                .setVariableExpr(varExpr.toBuilder().setIsDecl(true).build())
                .setValueExpr(valExpr)
                .build());
      }
    }
    String rpcJavaName = JavaStyle.toLowerCamelCase(method.name());
    if (method.hasLro()) {
      rpcJavaName += "Async";
    }
    MethodInvocationExpr rpcJavaMethodInvocationExpr =
        MethodInvocationExpr.builder()
            .setExprReferenceExpr(classMemberVarExprs.get("client"))
            .setMethodName(rpcJavaName)
            .setArguments(argVarExprs.stream().map(e -> (Expr) e).collect(Collectors.toList()))
            .build();
    if (method.hasLro()) {
      rpcJavaMethodInvocationExpr =
          MethodInvocationExpr.builder()
              .setExprReferenceExpr(rpcJavaMethodInvocationExpr)
              .setMethodName("get")
              .build();
    }
    tryBodyExprs.add(rpcJavaMethodInvocationExpr);

    VariableExpr catchExceptionVarExpr =
        VariableExpr.builder()
            .setVariable(
                Variable.builder()
                    .setType(
                        TypeNode.withExceptionClazz(
                            method.hasLro()
                                ? ExecutionException.class
                                : InvalidArgumentException.class))
                    .setName("e")
                    .build())
            .build();

    List<Statement> catchBody =
        method.hasLro()
            ? createRpcLroExceptionTestCatchBody(catchExceptionVarExpr, false)
            : Arrays.asList(
                CommentStatement.withComment(LineComment.withComment("Expected exception.")));
    // Assert a failure if no exception was raised.
    tryBodyExprs.add(
        MethodInvocationExpr.builder()
            .setStaticReferenceType(FIXED_TYPESTORE.get("Assert"))
            .setMethodName("fail")
            .setArguments(ValueExpr.withValue(StringObjectValue.withValue("No exception raised")))
            .build());

    TryCatchStatement tryCatchBlock =
        TryCatchStatement.builder()
            .setTryBody(
                tryBodyExprs.stream()
                    .map(e -> ExprStatement.withExpr(e))
                    .collect(Collectors.toList()))
            .addCatch(catchExceptionVarExpr.toBuilder().setIsDecl(true).build(), catchBody)
            .build();

    return Arrays.asList(EMPTY_LINE_STATEMENT, tryCatchBlock);
  }

  protected abstract List<Statement> createRpcLroExceptionTestCatchBody(
      VariableExpr exceptionExpr, boolean isStreaming);

  /* =========================================
   * Type creator methods.
   * =========================================
   */

  private static TypeStore createStaticTypes() {
    List<Class<?>> concreteClazzes =
        Arrays.asList(
            AbstractMessage.class,
            After.class,
            AfterClass.class,
            Any.class,
            ApiClientHeaderProvider.class,
            ApiStreamObserver.class,
            Arrays.class,
            Assert.class,
            Before.class,
            BeforeClass.class,
            BidiStreamingCallable.class,
            ClientStreamingCallable.class,
            ExecutionException.class,
            Generated.class,
            IOException.class,
            InvalidArgumentException.class,
            List.class,
            Lists.class,
            NoCredentialsProvider.class,
            Operation.class,
            ServerStreamingCallable.class,
            StatusCode.class,
            Test.class,
            UUID.class);
    return new TypeStore(concreteClazzes);
  }

  private void addDynamicTypes(GapicContext context, Service service, TypeStore typeStore) {
    typeStore.putAll(
        service.pakkage(),
        Arrays.asList(
            ClassNames.getMockServiceClassName(service),
            ClassNames.getServiceClientClassName(service),
            ClassNames.getServiceSettingsClassName(service)));
    String stubPakkage = String.format("%s.stub", service.pakkage());
    typeStore.put(
        stubPakkage, getTransportContext().classNames().getTransportServiceStubClassName(service));
    // Pagination types.
    typeStore.putAll(
        service.pakkage(),
        service.methods().stream()
            .filter(m -> m.isPaged())
            .map(m -> String.format(CommonStrings.PAGED_RESPONSE_TYPE_NAME_PATTERN, m.name()))
            .collect(Collectors.toList()),
        true,
        ClassNames.getServiceClientClassName(service));
    for (Service mixinService : context.mixinServices()) {
      typeStore.put(mixinService.pakkage(), ClassNames.getMockServiceClassName(mixinService));
      for (Method mixinMethod : mixinService.methods()) {
        if (!mixinMethod.isPaged()) {
          continue;
        }
        typeStore.put(
            service.pakkage(),
            String.format(CommonStrings.PAGED_RESPONSE_TYPE_NAME_PATTERN, mixinMethod.name()),
            true,
            ClassNames.getServiceClientClassName(service));
      }
    }
  }

  protected static TypeNode getCallableType(Method protoMethod) {
    Preconditions.checkState(
        !protoMethod.stream().equals(Method.Stream.NONE),
        "No callable type exists for non-streaming methods.");

    Class<?> callableClazz = ClientStreamingCallable.class;
    switch (protoMethod.stream()) {
      case BIDI:
        callableClazz = BidiStreamingCallable.class;
        break;
      case SERVER:
        callableClazz = ServerStreamingCallable.class;
        break;
      case CLIENT:
      // Fall through.
      case NONE:
      // Fall through
      default:
        // Fall through
    }

    List<Reference> generics = new ArrayList<>();
    generics.add(protoMethod.inputType().reference());
    generics.add(protoMethod.outputType().reference());

    return TypeNode.withReference(
        ConcreteReference.builder().setClazz(callableClazz).setGenerics(generics).build());
  }

  private static TypeNode getPagedResponseType(Method method, Service service) {
    return TypeNode.withReference(
        VaporReference.builder()
            .setName(String.format(CommonStrings.PAGED_RESPONSE_TYPE_NAME_PATTERN, method.name()))
            .setPakkage(service.pakkage())
            .setEnclosingClassNames(ClassNames.getServiceClientClassName(service))
            .setIsStaticImport(true)
            .build());
  }

  protected static String getCallableMethodName(Method protoMethod) {
    Preconditions.checkState(
        !protoMethod.stream().equals(Method.Stream.NONE),
        "No callable type exists for non-streaming methods.");

    switch (protoMethod.stream()) {
      case BIDI:
        return "bidiStreamingCall";
      case SERVER:
        return "serverStreamingCall";
      case CLIENT:
      // Fall through.
      case NONE:
      // Fall through
      default:
        return "clientStreamingCall";
    }
  }

  protected String getMockServiceVarName(Service service) {
    return String.format(MOCK_SERVICE_VAR_NAME_PATTERN, service.name());
  }

  private static boolean isProtoEmptyType(TypeNode type) {
    return type.reference().pakkage().equals("com.google.protobuf")
        && type.reference().name().equals("Empty");
  }
}
