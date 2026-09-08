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

import com.google.api.HttpRule;
import com.google.api.core.InternalApi;
import com.google.api.gax.httpjson.ApiMethodDescriptor;
import com.google.api.gax.httpjson.FieldsExtractor;
import com.google.api.gax.httpjson.HttpJsonCallSettings;
import com.google.api.gax.httpjson.HttpJsonLongRunningClient;
import com.google.api.gax.httpjson.HttpJsonOperationSnapshot;
import com.google.api.gax.httpjson.HttpJsonStubCallableFactory;
import com.google.api.gax.httpjson.ProtoMessageRequestFormatter;
import com.google.api.gax.httpjson.ProtoMessageResponseParser;
import com.google.api.gax.httpjson.ProtoRestSerializer;
import com.google.api.gax.httpjson.longrunning.stub.HttpJsonOperationsStub;
import com.google.api.gax.longrunning.OperationSnapshot;
import com.google.api.gax.rpc.LongRunningClient;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.api.generator.engine.ast.AssignmentExpr;
import com.google.api.generator.engine.ast.ConcreteReference;
import com.google.api.generator.engine.ast.Expr;
import com.google.api.generator.engine.ast.ExprStatement;
import com.google.api.generator.engine.ast.LambdaExpr;
import com.google.api.generator.engine.ast.MethodDefinition;
import com.google.api.generator.engine.ast.MethodInvocationExpr;
import com.google.api.generator.engine.ast.NewObjectExpr;
import com.google.api.generator.engine.ast.PrimitiveValue;
import com.google.api.generator.engine.ast.ScopeNode;
import com.google.api.generator.engine.ast.Statement;
import com.google.api.generator.engine.ast.StringObjectValue;
import com.google.api.generator.engine.ast.ThisObjectValue;
import com.google.api.generator.engine.ast.ThrowExpr;
import com.google.api.generator.engine.ast.TypeNode;
import com.google.api.generator.engine.ast.ValueExpr;
import com.google.api.generator.engine.ast.VaporReference;
import com.google.api.generator.engine.ast.Variable;
import com.google.api.generator.engine.ast.VariableExpr;
import com.google.api.generator.gapic.composer.common.AbstractTransportServiceStubClassComposer;
import com.google.api.generator.gapic.composer.store.TypeStore;
import com.google.api.generator.gapic.model.GapicContext;
import com.google.api.generator.gapic.model.Message;
import com.google.api.generator.gapic.model.Method;
import com.google.api.generator.gapic.model.OperationResponse;
import com.google.api.generator.gapic.model.Service;
import com.google.api.generator.gapic.utils.JavaStyle;
import com.google.common.collect.BiMap;
import com.google.common.collect.ImmutableMap;
import com.google.protobuf.TypeRegistry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import org.jspecify.annotations.NullMarked;

@NullMarked
public class HttpJsonServiceStubClassComposer extends AbstractTransportServiceStubClassComposer {
  private static final HttpJsonServiceStubClassComposer INSTANCE =
      new HttpJsonServiceStubClassComposer();

  static final TypeStore FIXED_REST_TYPESTORE = createStaticTypes();
  static final VariableExpr TYPE_REGISTRY_VAR_EXPR =
      VariableExpr.builder()
          .setVariable(
              Variable.builder()
                  .setName("typeRegistry")
                  .setType(FIXED_REST_TYPESTORE.get(TypeRegistry.class.getSimpleName()))
                  .build())
          .build();
  private static final String LRO_NAME_PREFIX = "google.longrunning.Operations";

  protected HttpJsonServiceStubClassComposer() {
    super(RestContext.instance());
  }

  public static HttpJsonServiceStubClassComposer instance() {
    return INSTANCE;
  }

  private static TypeStore createStaticTypes() {
    return new TypeStore(
        Arrays.asList(
            ApiMethodDescriptor.class,
            ArrayList.class,
            FieldsExtractor.class,
            InternalApi.class,
            HashMap.class,
            HttpJsonCallSettings.class,
            HttpJsonOperationSnapshot.class,
            HttpJsonStubCallableFactory.class,
            HttpRule.class,
            Map.class,
            ImmutableMap.class,
            ProtoMessageRequestFormatter.class,
            ProtoMessageResponseParser.class,
            ProtoRestSerializer.class,
            TypeRegistry.class));
  }

  @Override
  protected boolean generateOperationsStubLogic(Service service) {
    return service.hasLroMethods();
  }

  @Override
  protected Statement createMethodDescriptorVariableDecl(
      Service service,
      Method protoMethod,
      VariableExpr methodDescriptorVarExpr,
      Map<String, Message> messageTypes,
      boolean restNumericEnumsEnabled) {
    MethodInvocationExpr expr =
        HttpJsonDescriptorComposer.createMethodDescriptorExpr(
            service, protoMethod, methodDescriptorVarExpr, restNumericEnumsEnabled, null);

    BiFunction<String, List<Expr>, Function<MethodInvocationExpr, MethodInvocationExpr>>
        methodMaker = HttpJsonDescriptorComposer.getMethodMaker();

    if (protoMethod.isOperationPollingMethod() || protoMethod.hasLro()) {
      expr =
          methodMaker
              .apply(
                  "setOperationSnapshotFactory",
                  setOperationSnapshotFactoryExpr(protoMethod, messageTypes))
              .apply(expr);
    }

    if (protoMethod.isOperationPollingMethod()) {
      expr =
          methodMaker
              .apply(
                  "setPollingRequestFactory",
                  setPollingRequestFactoryExpr(protoMethod, messageTypes))
              .apply(expr);
    }

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

  @Override
  protected List<MethodDefinition> createOperationsStubGetterMethod(
      Service service, VariableExpr operationsStubVarExpr) {
    if (!service.hasStandardLroMethods()) {
      return Collections.emptyList();
    }
    return super.createOperationsStubGetterMethod(service, operationsStubVarExpr);
  }

  @Override
  protected List<MethodDefinition> createGetMethodDescriptorsMethod(
      Service service,
      TypeStore typeStore,
      Map<String, VariableExpr> protoMethodNameToDescriptorVarExprs) {
    return Collections.singletonList(
        HttpJsonDescriptorComposer.createGetMethodDescriptorsMethod(
            protoMethodNameToDescriptorVarExprs.values()));
  }

  static BiFunction<String, List<Expr>, Function<MethodInvocationExpr, MethodInvocationExpr>>
      getMethodMaker() {
    return HttpJsonDescriptorComposer.getMethodMaker();
  }

  // Generates get[camelCase(fieldName)]
  private String getMethodFormat(String fieldName) {
    return "get" + JavaStyle.toUpperCamelCase(fieldName);
  }

  // Generates set[camelCase(fieldName)]
  private String setMethodFormat(String fieldName) {
    return "set" + JavaStyle.toUpperCamelCase(fieldName);
  }

  // Generates: [nameVar].append(":").append([requestVar].get[FieldName]());
  private ExprStatement appendField(
      VariableExpr nameVar, VariableExpr requestVar, String fieldName) {
    BiFunction<String, List<Expr>, Function<MethodInvocationExpr, MethodInvocationExpr>>
        methodMaker = getMethodMaker();
    ValueExpr colonValueExpr =
        ValueExpr.builder().setValue(StringObjectValue.builder().setValue(":").build()).build();
    MethodInvocationExpr opNameAppendColonExpr =
        MethodInvocationExpr.builder()
            .setMethodName("append")
            .setArguments(colonValueExpr)
            .setExprReferenceExpr(nameVar)
            .build();
    MethodInvocationExpr getField =
        MethodInvocationExpr.builder()
            .setExprReferenceExpr(requestVar)
            .setMethodName(getMethodFormat(fieldName))
            .build();
    opNameAppendColonExpr =
        methodMaker
            .apply("append", Collections.singletonList(getField))
            .apply(opNameAppendColonExpr);
    return ExprStatement.withExpr(opNameAppendColonExpr);
  }

  // returns var.get(num);
  private MethodInvocationExpr getExpr(VariableExpr var, String num) {
    return MethodInvocationExpr.builder()
        .setExprReferenceExpr(var)
        .setMethodName("get")
        .setArguments(
            ValueExpr.builder()
                .setValue(PrimitiveValue.builder().setValue(num).setType(TypeNode.INT).build())
                .build())
        .build();
  }

  private List<Expr> setOperationSnapshotFactoryExpr(
      Method protoMethod, Map<String, Message> messageTypes) {

    // Generate input variables for create()
    VariableExpr requestVarExpr =
        VariableExpr.withVariable(
            Variable.builder().setType(protoMethod.inputType()).setName("request").build());
    VariableExpr responseVarExpr =
        VariableExpr.withVariable(
            Variable.builder().setType(protoMethod.outputType()).setName("response").build());

    MethodInvocationExpr buildExpr;
    List<Statement> createBody = new ArrayList<>(4);

    TypeNode httpJsonOperationSnapshotType =
        FIXED_REST_TYPESTORE.get(HttpJsonOperationSnapshot.class.getSimpleName());
    TypeNode operationSnapshotType = FIXED_TYPESTORE.get(OperationSnapshot.class.getSimpleName());

    Message inputOperationMessage =
        messageTypes.get(protoMethod.inputType().reference().fullName());
    Message outputOperationMessage =
        messageTypes.get(protoMethod.outputType().reference().fullName());
    OperationResponse operationResponse = outputOperationMessage.operationResponse();

    if (operationResponse == null) {
      // AIP-151 LRO
      // HttpJsonOperationSnapshot.create(response)
      buildExpr =
          MethodInvocationExpr.builder()
              .setStaticReferenceType(httpJsonOperationSnapshotType)
              .setMethodName("create")
              .setArguments(responseVarExpr)
              .setReturnType(operationSnapshotType)
              .build();
    } else {
      BiFunction<String, List<Expr>, Function<MethodInvocationExpr, MethodInvocationExpr>>
          methodMaker = getMethodMaker();

      // Generate opName
      TypeNode stringBuilderType =
          TypeNode.withReference(ConcreteReference.withClazz(StringBuilder.class));
      VariableExpr opNameVarExpr =
          VariableExpr.withVariable(
              Variable.builder().setType(stringBuilderType).setName("opName").build());
      MethodInvocationExpr getId =
          MethodInvocationExpr.builder()
              .setExprReferenceExpr(responseVarExpr)
              .setMethodName(getMethodFormat(operationResponse.nameFieldName()))
              .build();
      Expr opNameObjectExpr =
          NewObjectExpr.builder().setType(stringBuilderType).setArguments(getId).build();
      AssignmentExpr opNameAssignExpr =
          AssignmentExpr.builder()
              .setVariableExpr(opNameVarExpr.toBuilder().setIsDecl(true).build())
              .setValueExpr(opNameObjectExpr)
              .build();
      createBody.add(ExprStatement.withExpr(opNameAssignExpr));

      // Generate compound operation name
      if (!protoMethod.isOperationPollingMethod()) {
        // TODO: Change to ordered map
        Map<String, String> requestFields = inputOperationMessage.operationRequestFields();
        List<String> fieldAnnotationNames = new ArrayList<>(requestFields.keySet());
        Collections.sort(fieldAnnotationNames);
        for (String fieldName : fieldAnnotationNames) {
          createBody.add(appendField(opNameVarExpr, requestVarExpr, requestFields.get(fieldName)));
        }
      }

      // Generate check for status == done
      MethodInvocationExpr getStatusExpr =
          MethodInvocationExpr.builder()
              .setExprReferenceExpr(responseVarExpr)
              .setMethodName(getMethodFormat(operationResponse.statusFieldName()))
              .build();

      String statusTypeName = operationResponse.statusFieldTypeName();
      String statusClassName = statusTypeName.substring(statusTypeName.lastIndexOf('.') + 1);

      TypeNode opType =
          protoMethod.hasLro() ? protoMethod.lro().responseType() : protoMethod.outputType();

      TypeNode statusType =
          TypeNode.withReference(
              VaporReference.builder()
                  .setName(statusClassName)
                  .setPakkage(opType.reference().fullName())
                  .setIsStaticImport(false)
                  .build());
      VariableExpr statusDoneExpr =
          VariableExpr.builder()
              .setVariable(Variable.builder().setName("DONE").setType(TypeNode.INT).build())
              .setStaticReferenceType(statusType)
              .build();
      MethodInvocationExpr statusEqualsExpr =
          MethodInvocationExpr.builder()
              .setExprReferenceExpr(statusDoneExpr)
              .setMethodName("equals")
              .setArguments(getStatusExpr)
              .build();

      // Generate return statement

      // Generate getter methods from annotations
      MethodInvocationExpr opNameToStringExpr =
          MethodInvocationExpr.builder()
              .setExprReferenceExpr(opNameVarExpr)
              .setMethodName("toString")
              .build();
      MethodInvocationExpr getHttpErrorStatusCodeExpr =
          MethodInvocationExpr.builder()
              .setExprReferenceExpr(responseVarExpr)
              .setMethodName(getMethodFormat(operationResponse.errorCodeFieldName()))
              .build();
      MethodInvocationExpr getHttpErrorMessageExpr =
          MethodInvocationExpr.builder()
              .setExprReferenceExpr(responseVarExpr)
              .setMethodName(getMethodFormat(operationResponse.errorMessageFieldName()))
              .build();
      MethodInvocationExpr newBuilderExpr =
          MethodInvocationExpr.builder()
              .setStaticReferenceType(httpJsonOperationSnapshotType)
              .setMethodName("newBuilder")
              .build();

      newBuilderExpr =
          methodMaker
              .apply("setName", Collections.singletonList(opNameToStringExpr))
              .apply(newBuilderExpr);
      newBuilderExpr =
          methodMaker
              .apply("setMetadata", Collections.singletonList(responseVarExpr))
              .apply(newBuilderExpr);
      newBuilderExpr =
          methodMaker
              .apply("setDone", Collections.singletonList(statusEqualsExpr))
              .apply(newBuilderExpr);
      newBuilderExpr =
          methodMaker
              .apply("setResponse", Collections.singletonList(responseVarExpr))
              .apply(newBuilderExpr);
      newBuilderExpr =
          methodMaker
              .apply("setError", Arrays.asList(getHttpErrorStatusCodeExpr, getHttpErrorMessageExpr))
              .apply(newBuilderExpr);

      buildExpr =
          MethodInvocationExpr.builder()
              .setExprReferenceExpr(newBuilderExpr)
              .setMethodName("build")
              .setReturnType(operationSnapshotType)
              .build();
    }
    // Generate lambda anonymous class
    return Collections.singletonList(
        LambdaExpr.builder()
            .setArguments(
                requestVarExpr.toBuilder().setIsDecl(true).build(),
                responseVarExpr.toBuilder().setIsDecl(true).build())
            .setBody(createBody)
            .setReturnExpr(buildExpr)
            .build());
  }

  private List<Expr> setPollingRequestFactoryExpr(
      Method protoMethod, Map<String, Message> messageTypes) {
    BiFunction<String, List<Expr>, Function<MethodInvocationExpr, MethodInvocationExpr>>
        methodMaker = getMethodMaker();

    Message inputOperationMessage =
        messageTypes.get(protoMethod.inputType().reference().fullName());

    List<Statement> createBody = new ArrayList<>(1);

    // Generate input variables for create
    VariableExpr compoundOperationIdVarExpr =
        VariableExpr.builder()
            .setVariable(
                Variable.builder().setType(TypeNode.STRING).setName("compoundOperationId").build())
            .build();

    // Generate idComponenets
    TypeNode listStringType =
        TypeNode.withReference(
            ConcreteReference.builder()
                .setClazz(List.class)
                .setGenerics(ConcreteReference.withClazz(String.class))
                .build());
    TypeNode arrayListStringType =
        TypeNode.withReference(
            ConcreteReference.builder()
                .setClazz(ArrayList.class)
                .setGenerics(ConcreteReference.withClazz(String.class))
                .build());
    TypeNode arraysType = TypeNode.withReference(ConcreteReference.withClazz(Arrays.class));
    VariableExpr idComponentsVarExpr =
        VariableExpr.withVariable(
            Variable.builder().setName("idComponents").setType(listStringType).build());
    MethodInvocationExpr compoundOperationIdSplitExpr =
        MethodInvocationExpr.builder()
            .setExprReferenceExpr(compoundOperationIdVarExpr)
            .setMethodName("split")
            .setArguments(ValueExpr.withValue(StringObjectValue.withValue(":")))
            .setReturnType(arrayListStringType)
            .build();
    MethodInvocationExpr asListExpr =
        MethodInvocationExpr.builder()
            .setStaticReferenceType(arraysType)
            .setMethodName("asList")
            .setArguments(compoundOperationIdSplitExpr)
            .setReturnType(arrayListStringType)
            .build();
    AssignmentExpr idComponentsAssignExpr =
        AssignmentExpr.builder()
            .setVariableExpr(idComponentsVarExpr.toBuilder().setIsDecl(true).build())
            .setValueExpr(asListExpr)
            .build();
    createBody.add(ExprStatement.withExpr(idComponentsAssignExpr));

    // Generate return statement
    TypeNode getOperationRequestType = TypeNode.withReference(protoMethod.inputType().reference());
    MethodInvocationExpr newBuilderExpr =
        MethodInvocationExpr.builder()
            .setStaticReferenceType(getOperationRequestType)
            .setMethodName("newBuilder")
            .build();
    BiMap<String, String> responseFieldsMap = inputOperationMessage.operationResponseFields();
    List<String> responseFieldAnnotationNames = new ArrayList<>(responseFieldsMap.keySet());
    Collections.sort(responseFieldAnnotationNames);
    Set<String> responseFieldsNames = responseFieldsMap.inverse().keySet();
    Set<String> allFieldsNames = inputOperationMessage.fieldMap().keySet();
    ArrayList<String> nonResponseFieldsNames = new ArrayList<>();
    for (String fieldName : allFieldsNames) {
      if (!responseFieldsNames.contains(fieldName)) {
        nonResponseFieldsNames.add(fieldName);
      }
    }
    Collections.sort(nonResponseFieldsNames);
    int index = 0;
    for (String fieldAnnotationName : responseFieldAnnotationNames) {
      newBuilderExpr =
          methodMaker
              .apply(
                  setMethodFormat(responseFieldsMap.get(fieldAnnotationName)),
                  Collections.singletonList(getExpr(idComponentsVarExpr, Integer.toString(index))))
              .apply(newBuilderExpr);
      index++;
    }
    for (String fieldName : nonResponseFieldsNames) {
      newBuilderExpr =
          methodMaker
              .apply(
                  setMethodFormat(fieldName),
                  Collections.singletonList(getExpr(idComponentsVarExpr, Integer.toString(index))))
              .apply(newBuilderExpr);
      index++;
    }

    MethodInvocationExpr buildExpr =
        MethodInvocationExpr.builder()
            .setExprReferenceExpr(newBuilderExpr)
            .setMethodName("build")
            .setReturnType(getOperationRequestType)
            .build();

    // Return lambda anonymous class
    return Collections.singletonList(
        LambdaExpr.builder()
            .setArguments(compoundOperationIdVarExpr.toBuilder().setIsDecl(true).build())
            .setBody(createBody)
            .setReturnExpr(buildExpr)
            .build());
  }

  static String getProtoRpcName(Service protoService, Method protoMethod) {
    return HttpJsonDescriptorComposer.getProtoRpcFullMethodName(protoService, protoMethod);
  }

  @Override
  protected List<Expr> createOperationsStubInitExpr(
      GapicContext context,
      Service service,
      Expr thisExpr,
      VariableExpr operationsStubClassVarExpr,
      VariableExpr clientContextVarExpr,
      VariableExpr callableFactoryVarExpr) {
    TypeNode operationsStubType = getTransportOperationsStubType(service);
    String standardOpStub = HttpJsonOperationsStub.class.getName();

    List<Expr> arguments =
        new ArrayList<>(Arrays.asList(clientContextVarExpr, callableFactoryVarExpr));
    if (standardOpStub.equals(operationsStubType.reference().fullName())) {
      arguments.add(TYPE_REGISTRY_VAR_EXPR);
    }

    // If the Service contains custom HttpRules for Operations, we pass a map of the custom rules to
    // the Operations Client
    Map<String, HttpRule> operationCustomHttpRules = parseOperationsCustomHttpRules(context);
    if (operationCustomHttpRules.size() > 0) {
      Expr operationCustomHttpBindingsBuilderExpr =
          MethodInvocationExpr.builder()
              .setStaticReferenceType(FIXED_REST_TYPESTORE.get(ImmutableMap.class.getSimpleName()))
              .setMethodName("builder")
              .setGenerics(
                  Arrays.asList(
                      TypeNode.STRING.reference(),
                      FIXED_REST_TYPESTORE.get(HttpRule.class.getSimpleName()).reference()))
              .build();

      // Sorting is done to ensure consistent ordering of the entries in the Custom HttpRule Map
      for (String selector :
          operationCustomHttpRules.keySet().stream().sorted().collect(Collectors.toList())) {
        HttpRule httpRule = operationCustomHttpRules.get(selector);
        Expr httpRuleBuilderExpr = createHttpRuleExpr(httpRule, true);

        operationCustomHttpBindingsBuilderExpr =
            MethodInvocationExpr.builder()
                .setExprReferenceExpr(operationCustomHttpBindingsBuilderExpr)
                .setMethodName("put")
                .setArguments(
                    Arrays.asList(
                        ValueExpr.withValue(StringObjectValue.withValue(selector)),
                        httpRuleBuilderExpr))
                .build();
      }

      operationCustomHttpBindingsBuilderExpr =
          MethodInvocationExpr.builder()
              .setExprReferenceExpr(operationCustomHttpBindingsBuilderExpr)
              .setMethodName("build")
              .setReturnType(FIXED_REST_TYPESTORE.get(ImmutableMap.class.getSimpleName()))
              .build();

      arguments.add(operationCustomHttpBindingsBuilderExpr);
    }

    return Collections.singletonList(
        AssignmentExpr.builder()
            .setVariableExpr(
                operationsStubClassVarExpr.toBuilder().setExprReferenceExpr(thisExpr).build())
            .setValueExpr(
                MethodInvocationExpr.builder()
                    .setStaticReferenceType(operationsStubType)
                    .setMethodName("create")
                    .setArguments(arguments)
                    .setReturnType(operationsStubClassVarExpr.type())
                    .build())
            .build());
  }

  /* Build an Expr that creates an HttpRule. Creates a builder and adds the http verb, custom path, and any additional bindings. `additional_bindings` can only be nested one layer deep, so we only check once */
  private Expr createHttpRuleExpr(HttpRule httpRule, boolean checkAdditionalBindings) {
    Expr httpRuleBuilderExpr =
        MethodInvocationExpr.builder()
            .setStaticReferenceType(FIXED_REST_TYPESTORE.get(HttpRule.class.getSimpleName()))
            .setMethodName("newBuilder")
            .build();

    httpRuleBuilderExpr =
        MethodInvocationExpr.builder()
            .setExprReferenceExpr(httpRuleBuilderExpr)
            // toLowerCase as the PatternCase result is all uppercase
            .setMethodName(setMethodFormat(httpRule.getPatternCase().toString().toLowerCase()))
            .setArguments(
                ValueExpr.withValue(
                    StringObjectValue.withValue(getOperationsURIValueFromHttpRule(httpRule))))
            .setReturnType(FIXED_REST_TYPESTORE.get(HttpRule.class.getSimpleName()))
            .build();

    if (checkAdditionalBindings) {
      for (HttpRule additionalBindings : httpRule.getAdditionalBindingsList()) {
        httpRuleBuilderExpr =
            MethodInvocationExpr.builder()
                .setExprReferenceExpr(httpRuleBuilderExpr)
                .setMethodName("addAdditionalBindings")
                .setArguments(Arrays.asList(createHttpRuleExpr(additionalBindings, false)))
                .build();
      }
    }

    httpRuleBuilderExpr =
        MethodInvocationExpr.builder()
            .setExprReferenceExpr(httpRuleBuilderExpr)
            .setMethodName("build")
            .setReturnType(FIXED_REST_TYPESTORE.get(HttpRule.class.getSimpleName()))
            .build();
    return httpRuleBuilderExpr;
  }

  /* Parses the Service Yaml file's for custom HttpRules. Filter the HttpRules for ones that match Operations */
  Map<String, HttpRule> parseOperationsCustomHttpRules(GapicContext context) {
    Predicate<HttpRule> predicate = x -> x.getSelector().contains(LRO_NAME_PREFIX);
    com.google.api.Service service = context.serviceYamlProto();
    if (service == null || service.getHttp() == null) {
      return ImmutableMap.of();
    }
    return service.getHttp().getRulesList().stream()
        .filter(predicate)
        .collect(Collectors.toMap(HttpRule::getSelector, x -> x));
  }

  /* This is meant to be used for the OperationsClient Mixin OperationsClient's RPCs are mapped to GET/POST/DELETE and this function only expects those HttpVerbs to be used */
  String getOperationsURIValueFromHttpRule(HttpRule httpRule) {
    switch (httpRule.getPatternCase().getNumber()) {
      case 2:
        return httpRule.getGet();
      case 4:
        return httpRule.getPost();
      case 5:
        return httpRule.getDelete();
      default:
        throw new IllegalArgumentException(
            "Operations HttpRule should only contain GET/POST/DELETE. Invalid: "
                + httpRule.getSelector());
    }
  }

  @Override
  protected List<Statement> createLongRunningClient(Service service, TypeStore typeStore) {
    Method pollingMethod = service.operationPollingMethod();
    if (pollingMethod != null) {
      Expr thisExpr =
          ValueExpr.withValue(
              ThisObjectValue.withType(
                  typeStore.get(
                      getTransportContext()
                          .classNames()
                          .getTransportServiceStubClassName(service))));

      VariableExpr callable =
          VariableExpr.withVariable(
              Variable.builder()
                  .setName(pollingMethod.name().toLowerCase() + "Callable")
                  .setType(TypeNode.withReference(ConcreteReference.withClazz(UnaryCallable.class)))
                  .build());
      VariableExpr methodDescriptor =
          VariableExpr.withVariable(
              Variable.builder()
                  .setName(pollingMethod.name().toLowerCase() + "MethodDescriptor")
                  .setType(
                      TypeNode.withReference(
                          ConcreteReference.withClazz(ApiMethodDescriptor.class)))
                  .build());

      TypeNode httpJsonLongRunningClientType =
          TypeNode.withReference(
              ConcreteReference.builder()
                  .setClazz(HttpJsonLongRunningClient.class)
                  .setGenerics(
                      Arrays.asList(
                          pollingMethod.inputType().reference(),
                          pollingMethod.outputType().reference()))
                  .build());

      NewObjectExpr HttpJsonLongRunningClient =
          NewObjectExpr.builder()
              .setType(httpJsonLongRunningClientType)
              .setArguments(
                  Arrays.asList(
                      callable,
                      MethodInvocationExpr.builder()
                          .setExprReferenceExpr(methodDescriptor)
                          .setMethodName("getOperationSnapshotFactory")
                          .build(),
                      MethodInvocationExpr.builder()
                          .setExprReferenceExpr(methodDescriptor)
                          .setMethodName("getPollingRequestFactory")
                          .build()))
              .build();

      AssignmentExpr assignLongRunningClient =
          AssignmentExpr.builder()
              .setVariableExpr(
                  VariableExpr.builder()
                      .setExprReferenceExpr(thisExpr)
                      .setVariable(
                          Variable.builder()
                              .setName("longRunningClient")
                              .setType(
                                  TypeNode.withReference(
                                      ConcreteReference.withClazz(LongRunningClient.class)))
                              .build())
                      .build())
              .setValueExpr(HttpJsonLongRunningClient)
              .build();

      return Arrays.asList(ExprStatement.withExpr(assignLongRunningClient));
    } else {
      return Collections.emptyList();
    }
  }

  @Override
  protected VariableExpr declareLongRunningClient() {
    return VariableExpr.withVariable(
        Variable.builder()
            .setName("longRunningClient")
            .setType(TypeNode.withReference(ConcreteReference.withClazz(LongRunningClient.class)))
            .build());
  }

  @Override
  protected List<Statement> createTypeRegistry(Service service) {
    TypeNode typeRegistryType = FIXED_REST_TYPESTORE.get(TypeRegistry.class.getSimpleName());

    VariableExpr typeRegistryVarExpr =
        TYPE_REGISTRY_VAR_EXPR.toBuilder()
            .setIsDecl(true)
            .setIsStatic(true)
            .setScope(ScopeNode.PRIVATE)
            .setIsFinal(true)
            .build();

    Map<String, TypeNode> anyTypes = new HashMap<>();
    for (Method method : service.methods()) {
      if (method.hasLro()) {
        TypeNode anyType = method.lro().responseType();
        anyTypes.put(anyType.reference().fullName(), anyType);
        anyType = method.lro().metadataType();
        anyTypes.put(anyType.reference().fullName(), anyType);
      }
    }

    Expr typeRegistryBuilderExpr =
        MethodInvocationExpr.builder()
            .setStaticReferenceType(typeRegistryType)
            .setMethodName("newBuilder")
            .build();

    for (TypeNode anyType : anyTypes.values()) {
      typeRegistryBuilderExpr =
          MethodInvocationExpr.builder()
              .setExprReferenceExpr(typeRegistryBuilderExpr)
              .setMethodName("add")
              .setArguments(
                  MethodInvocationExpr.builder()
                      .setStaticReferenceType(anyType)
                      .setMethodName("getDescriptor")
                      .build())
              .build();
    }

    typeRegistryBuilderExpr =
        MethodInvocationExpr.builder()
            .setExprReferenceExpr(typeRegistryBuilderExpr)
            .setMethodName("build")
            .setReturnType(typeRegistryType)
            .build();

    return Collections.singletonList(
        ExprStatement.withExpr(
            AssignmentExpr.builder()
                .setVariableExpr(typeRegistryVarExpr)
                .setValueExpr(typeRegistryBuilderExpr)
                .build()));
  }

  @Override
  protected List<MethodDefinition> createClassMethods(
      GapicContext context,
      Service service,
      TypeStore typeStore,
      Map<String, VariableExpr> classMemberVarExprs,
      Map<String, VariableExpr> callableClassMemberVarExprs,
      Map<String, VariableExpr> protoMethodNameToDescriptorVarExprs,
      List<Statement> classStatements) {
    List<MethodDefinition> javaMethods = new ArrayList<>();
    javaMethods.addAll(
        super.createClassMethods(
            context,
            service,
            typeStore,
            classMemberVarExprs,
            callableClassMemberVarExprs,
            protoMethodNameToDescriptorVarExprs,
            classStatements));
    javaMethods.addAll(createInvalidClassMethods(service));
    return javaMethods;
  }

  private List<MethodDefinition> createInvalidClassMethods(Service service) {
    List<MethodDefinition> methodDefinitions = new ArrayList<>();
    for (Method protoMethod : service.methods()) {
      if (protoMethod.isSupportedByTransport(getTransportContext().transport())) {
        continue;
      }
      String javaStyleProtoMethodName = JavaStyle.toLowerCamelCase(protoMethod.name());
      String callableName = String.format(CALLABLE_CLASS_MEMBER_PATTERN, javaStyleProtoMethodName);
      methodDefinitions.add(
          MethodDefinition.builder()
              .setIsOverride(true)
              .setScope(ScopeNode.PUBLIC)
              .setName(callableName)
              .setReturnType(getCallableType(protoMethod))
              .setBody(
                  Arrays.asList(
                      ExprStatement.withExpr(
                          ThrowExpr.builder()
                              .setType(FIXED_TYPESTORE.get("UnsupportedOperationException"))
                              .setMessageExpr(
                                  String.format(
                                      "Not implemented: %s(). %s transport is not implemented for"
                                          + " this method yet.",
                                      callableName, getTransportContext().transport()))
                              .build())))
              .build());
    }
    return methodDefinitions;
  }
}
