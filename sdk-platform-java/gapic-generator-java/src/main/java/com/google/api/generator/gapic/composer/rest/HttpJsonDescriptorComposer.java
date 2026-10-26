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

import com.google.api.core.InternalApi;
import com.google.api.gax.httpjson.ApiMethodDescriptor;
import com.google.api.gax.httpjson.ApiMethodDescriptor.MethodType;
import com.google.api.gax.httpjson.FieldsExtractor;
import com.google.api.gax.httpjson.ProtoMessageRequestFormatter;
import com.google.api.gax.httpjson.ProtoMessageResponseParser;
import com.google.api.gax.httpjson.ProtoRestSerializer;
import com.google.api.generator.engine.ast.AnnotationNode;
import com.google.api.generator.engine.ast.AssignmentExpr;
import com.google.api.generator.engine.ast.ConcreteReference;
import com.google.api.generator.engine.ast.EnumRefExpr;
import com.google.api.generator.engine.ast.Expr;
import com.google.api.generator.engine.ast.ExprStatement;
import com.google.api.generator.engine.ast.IfStatement;
import com.google.api.generator.engine.ast.LambdaExpr;
import com.google.api.generator.engine.ast.MethodDefinition;
import com.google.api.generator.engine.ast.MethodInvocationExpr;
import com.google.api.generator.engine.ast.NewObjectExpr;
import com.google.api.generator.engine.ast.PrimitiveValue;
import com.google.api.generator.engine.ast.ScopeNode;
import com.google.api.generator.engine.ast.Statement;
import com.google.api.generator.engine.ast.StringObjectValue;
import com.google.api.generator.engine.ast.TypeNode;
import com.google.api.generator.engine.ast.ValueExpr;
import com.google.api.generator.engine.ast.Variable;
import com.google.api.generator.engine.ast.VariableExpr;
import com.google.api.generator.gapic.composer.store.TypeStore;
import com.google.api.generator.gapic.model.HttpBindings.HttpBinding;
import com.google.api.generator.gapic.model.Method;
import com.google.api.generator.gapic.model.Service;
import com.google.api.generator.gapic.utils.JavaStyle;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.protobuf.TypeRegistry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

@NullMarked
final class HttpJsonDescriptorComposer {

  private static final String BUILD_METHOD_NAME = "build";
  private static final String NEW_BUILDER_METHOD_NAME = "newBuilder";
  private static final String SLASH = "/";

  private static final TypeStore FIXED_REST_TYPESTORE = createStaticTypes();

  private static final VariableExpr TYPE_REGISTRY_VAR_EXPR =
      VariableExpr.builder()
          .setVariable(
              Variable.builder()
                  .setName("typeRegistry")
                  .setType(FIXED_REST_TYPESTORE.get(TypeRegistry.class.getSimpleName()))
                  .build())
          .build();

  private HttpJsonDescriptorComposer() {}

  private static TypeStore createStaticTypes() {
    return new TypeStore(
        Arrays.asList(
            ApiMethodDescriptor.class,
            ArrayList.class,
            FieldsExtractor.class,
            HashMap.class,
            InternalApi.class,
            List.class,
            ProtoMessageRequestFormatter.class,
            ProtoMessageResponseParser.class,
            ProtoRestSerializer.class,
            TypeRegistry.class));
  }

  static BiFunction<String, List<Expr>, Function<MethodInvocationExpr, MethodInvocationExpr>>
      getMethodMaker() {
    return (mName, argExpr) ->
        m ->
            MethodInvocationExpr.builder()
                .setMethodName(mName)
                .setArguments(argExpr)
                .setExprReferenceExpr(m)
                .build();
  }

  static String prependPathPrefix(String path, @Nullable String pathPrefix) {
    if (pathPrefix == null) {
      return path;
    }
    String normalizedPrefix = pathPrefix.startsWith(SLASH) ? pathPrefix : SLASH + pathPrefix;
    if (normalizedPrefix.endsWith(SLASH)) {
      normalizedPrefix = normalizedPrefix.substring(0, normalizedPrefix.length() - 1);
    }
    return normalizedPrefix + (path.startsWith(SLASH) ? path : SLASH + path);
  }

  static String getProtoRpcFullMethodName(Service protoService, Method protoMethod) {
    if (protoMethod.isMixin()) {
      return String.format("%s/%s", protoMethod.mixedInApiName(), protoMethod.name());
    }
    return String.format(
        "%s.%s/%s", protoService.protoPakkage(), protoService.name(), protoMethod.name());
  }

  static List<Expr> getHttpMethodTypeExpr(Method protoMethod) {
    return Collections.singletonList(
        ValueExpr.withValue(
            StringObjectValue.withValue(protoMethod.httpBindings().httpVerb().toString())));
  }

  static List<Expr> getMethodTypeExpr(Method protoMethod) {
    MethodType methodType;
    switch (protoMethod.stream()) {
      case NONE:
        methodType = MethodType.UNARY;
        break;
      case SERVER:
        methodType = MethodType.SERVER_STREAMING;
        break;
      case CLIENT:
      case BIDI:
      default:
        throw new UnsupportedOperationException(
            String.format(
                "Methods of type %s are not supported by REST transport", protoMethod.stream()));
    }
    EnumRefExpr expr =
        EnumRefExpr.builder()
            .setName(methodType.toString())
            .setType(
                TypeNode.withReference(
                    ConcreteReference.builder()
                        .setClazz(ApiMethodDescriptor.MethodType.class)
                        .build()))
            .build();
    return Collections.singletonList(expr);
  }

  static List<Expr> getRequestFormatterExpr(Method protoMethod, boolean restNumericEnumsEnabled) {
    return getRequestFormatterExpr(protoMethod, restNumericEnumsEnabled, null);
  }

  static List<Expr> getRequestFormatterExpr(
      Method protoMethod, boolean restNumericEnumsEnabled, @Nullable String pathPrefix) {
    BiFunction<String, List<Expr>, Function<MethodInvocationExpr, MethodInvocationExpr>>
        methodMaker = getMethodMaker();

    MethodInvocationExpr expr =
        MethodInvocationExpr.builder()
            .setStaticReferenceType(
                FIXED_REST_TYPESTORE.get(ProtoMessageRequestFormatter.class.getSimpleName()))
            .setMethodName(NEW_BUILDER_METHOD_NAME)
            .setGenerics(Collections.singletonList(protoMethod.inputType().reference()))
            .build();

    TypeNode extractorVarType =
        TypeNode.withReference(
            ConcreteReference.builder()
                .setClazz(Map.class)
                .setGenerics(TypeNode.STRING.reference(), TypeNode.STRING.reference())
                .build());

    String pathPattern =
        prependPathPrefix(protoMethod.httpBindings().lowerCamelPattern(), pathPrefix);

    expr =
        methodMaker
            .apply(
                "setPath",
                Arrays.asList(
                    ValueExpr.withValue(StringObjectValue.withValue(pathPattern)),
                    createFieldsExtractorClassInstance(
                        protoMethod,
                        extractorVarType,
                        protoMethod.httpBindings().pathParameters(),
                        "putPathParam",
                        restNumericEnumsEnabled)))
            .apply(expr);

    if (!protoMethod.httpBindings().lowerCamelAdditionalPatterns().isEmpty()) {
      expr =
          methodMaker
              .apply(
                  "setAdditionalPaths",
                  protoMethod.httpBindings().lowerCamelAdditionalPatterns().stream()
                      .map(
                          a ->
                              ValueExpr.withValue(
                                  StringObjectValue.withValue(prependPathPrefix(a, pathPrefix))))
                      .collect(Collectors.toList()))
              .apply(expr);
    }
    TypeNode fieldsVarGenericType =
        TypeNode.withReference(
            ConcreteReference.builder()
                .setClazz(List.class)
                .setGenerics(TypeNode.STRING.reference())
                .build());

    extractorVarType =
        TypeNode.withReference(
            ConcreteReference.builder()
                .setClazz(Map.class)
                .setGenerics(TypeNode.STRING.reference(), fieldsVarGenericType.reference())
                .build());

    expr =
        methodMaker
            .apply(
                "setQueryParamsExtractor",
                Arrays.asList(
                    createFieldsExtractorClassInstance(
                        protoMethod,
                        extractorVarType,
                        protoMethod.httpBindings().queryParameters(),
                        "putQueryParam",
                        restNumericEnumsEnabled)))
            .apply(expr);

    extractorVarType = TypeNode.STRING;
    boolean asteriskBody = protoMethod.httpBindings().isAsteriskBody();
    expr =
        methodMaker
            .apply(
                "setRequestBodyExtractor",
                Arrays.asList(
                    createBodyFieldsExtractorClassInstance(
                        protoMethod,
                        extractorVarType,
                        asteriskBody
                            ? protoMethod.httpBindings().pathParameters()
                            : protoMethod.httpBindings().bodyParameters(),
                        "toBody",
                        asteriskBody,
                        restNumericEnumsEnabled)))
            .apply(expr);

    expr = methodMaker.apply(BUILD_METHOD_NAME, Collections.emptyList()).apply(expr);

    return Collections.singletonList(expr);
  }

  static List<Expr> setResponseParserExpr(Method protoMethod) {
    BiFunction<String, List<Expr>, Function<MethodInvocationExpr, MethodInvocationExpr>>
        methodMaker = getMethodMaker();

    MethodInvocationExpr expr =
        MethodInvocationExpr.builder()
            .setStaticReferenceType(
                FIXED_REST_TYPESTORE.get(ProtoMessageResponseParser.class.getSimpleName()))
            .setMethodName(NEW_BUILDER_METHOD_NAME)
            .setGenerics(Collections.singletonList(protoMethod.outputType().reference()))
            .build();

    expr =
        methodMaker
            .apply(
                "setDefaultInstance",
                Arrays.asList(
                    MethodInvocationExpr.builder()
                        .setStaticReferenceType(protoMethod.outputType())
                        .setMethodName("getDefaultInstance")
                        .setReturnType(protoMethod.outputType())
                        .build()))
            .apply(expr);

    expr =
        methodMaker
            .apply("setDefaultTypeRegistry", Arrays.asList(TYPE_REGISTRY_VAR_EXPR))
            .apply(expr);
    expr = methodMaker.apply(BUILD_METHOD_NAME, Collections.emptyList()).apply(expr);

    return Collections.singletonList(expr);
  }

  static MethodInvocationExpr createMethodDescriptorExpr(
      Service service,
      Method protoMethod,
      VariableExpr methodDescriptorVarExpr,
      boolean restNumericEnumsEnabled,
      @Nullable String pathPrefix) {
    MethodInvocationExpr expr =
        MethodInvocationExpr.builder()
            .setMethodName(NEW_BUILDER_METHOD_NAME)
            .setStaticReferenceType(
                FIXED_REST_TYPESTORE.get(ApiMethodDescriptor.class.getSimpleName()))
            .setGenerics(methodDescriptorVarExpr.variable().type().reference().generics())
            .build();

    BiFunction<String, List<Expr>, Function<MethodInvocationExpr, MethodInvocationExpr>>
        methodMaker = getMethodMaker();

    String codeMethodArgName = getProtoRpcFullMethodName(service, protoMethod);
    expr =
        methodMaker
            .apply(
                "setFullMethodName",
                Arrays.asList(ValueExpr.withValue(StringObjectValue.withValue(codeMethodArgName))))
            .apply(expr);

    expr = methodMaker.apply("setHttpMethod", getHttpMethodTypeExpr(protoMethod)).apply(expr);
    expr = methodMaker.apply("setType", getMethodTypeExpr(protoMethod)).apply(expr);
    expr =
        methodMaker
            .apply(
                "setRequestFormatter",
                getRequestFormatterExpr(protoMethod, restNumericEnumsEnabled, pathPrefix))
            .apply(expr);
    expr = methodMaker.apply("setResponseParser", setResponseParserExpr(protoMethod)).apply(expr);

    return expr;
  }

  static Statement createMethodDescriptorVariableDecl(
      Service service,
      Method protoMethod,
      VariableExpr methodDescriptorVarExpr,
      boolean restNumericEnumsEnabled,
      @Nullable String pathPrefix) {
    MethodInvocationExpr expr =
        createMethodDescriptorExpr(
            service, protoMethod, methodDescriptorVarExpr, restNumericEnumsEnabled, pathPrefix);

    expr =
        MethodInvocationExpr.builder()
            .setMethodName(BUILD_METHOD_NAME)
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

  static MethodDefinition createGetMethodDescriptorsMethod(
      Collection<VariableExpr> methodDescriptorVarExprs) {
    List<Expr> bodyExprs = new ArrayList<>();

    VariableExpr methodDescriptorsVarExpr =
        VariableExpr.withVariable(
            Variable.builder()
                .setType(
                    TypeNode.withReference(
                        ConcreteReference.builder()
                            .setClazz(List.class)
                            .setGenerics(
                                Arrays.asList(
                                    FIXED_REST_TYPESTORE.get("ApiMethodDescriptor").reference()))
                            .build()))
                .setName("methodDescriptors")
                .build());

    bodyExprs.add(
        AssignmentExpr.builder()
            .setVariableExpr(methodDescriptorsVarExpr.toBuilder().setIsDecl(true).build())
            .setValueExpr(
                NewObjectExpr.builder()
                    .setType(FIXED_REST_TYPESTORE.get("ArrayList"))
                    .setIsGeneric(true)
                    .build())
            .build());

    for (VariableExpr methodDescriptorVarExpr : methodDescriptorVarExprs) {
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
        .setAnnotations(
            Arrays.asList(
                AnnotationNode.withType(
                    TypeNode.withReference(ConcreteReference.withClazz(InternalApi.class)))))
        .setName("getMethodDescriptors")
        .setBody(bodyExprs.stream().map(ExprStatement::withExpr).collect(Collectors.toList()))
        .build();
  }

  private static Expr createBodyFieldsExtractorClassInstance(
      Method method,
      TypeNode extractorReturnType,
      Set<HttpBinding> httpBindingFieldNames,
      String serializerMethodName,
      boolean asteriskBody,
      boolean restNumericEnumEnabled) {
    List<Statement> bodyStatements = new ArrayList<>();

    Expr returnExpr = null;
    Expr serializerExpr =
        MethodInvocationExpr.builder()
            .setMethodName("create")
            .setStaticReferenceType(
                FIXED_REST_TYPESTORE.get(ProtoRestSerializer.class.getSimpleName()))
            .build();

    VariableExpr requestVarExpr =
        VariableExpr.withVariable(
            Variable.builder().setType(method.inputType()).setName("request").build());
    Expr bodyRequestExpr = requestVarExpr;
    String requestMethodPrefix = "get";
    String bodyParamName = null;

    if (asteriskBody) {
      bodyRequestExpr =
          MethodInvocationExpr.builder()
              .setExprReferenceExpr(requestVarExpr)
              .setMethodName("toBuilder")
              .build();
      requestMethodPrefix = "clear";
    }

    Expr prevExpr = bodyRequestExpr;
    for (HttpBinding httpBindingFieldName : httpBindingFieldNames) {
      MethodInvocationExpr.Builder requestFieldMethodExprBuilder =
          MethodInvocationExpr.builder().setExprReferenceExpr(prevExpr);
      bodyParamName =
          !Strings.isNullOrEmpty(httpBindingFieldName.jsonName())
              ? httpBindingFieldName.jsonName()
              : JavaStyle.toLowerCamelCase(httpBindingFieldName.name());
      String[] descendantFields = httpBindingFieldName.name().split("\\.");
      if (asteriskBody && descendantFields.length > 1) {
        continue;
      }

      for (int i = 0; i < descendantFields.length; i++) {
        String currFieldName = descendantFields[i];
        String bindingFieldMethodName =
            String.format("%s%s", requestMethodPrefix, JavaStyle.toUpperCamelCase(currFieldName));
        requestFieldMethodExprBuilder =
            requestFieldMethodExprBuilder.setMethodName(bindingFieldMethodName);

        if (i < descendantFields.length - 1) {
          requestFieldMethodExprBuilder =
              MethodInvocationExpr.builder()
                  .setExprReferenceExpr(requestFieldMethodExprBuilder.build());
        }
      }
      prevExpr = requestFieldMethodExprBuilder.build();
    }

    if (httpBindingFieldNames.isEmpty() && !asteriskBody) {
      returnExpr = ValueExpr.createNullExpr();
    } else {
      ImmutableList.Builder<Expr> paramsPutArgs = ImmutableList.builder();
      if (asteriskBody) {
        prevExpr =
            MethodInvocationExpr.builder()
                .setExprReferenceExpr(prevExpr)
                .setMethodName(BUILD_METHOD_NAME)
                .build();
        bodyParamName = "*";
      }
      paramsPutArgs.add(ValueExpr.withValue(StringObjectValue.withValue(bodyParamName)));
      paramsPutArgs.add(prevExpr);

      PrimitiveValue primitiveValue =
          PrimitiveValue.builder()
              .setType(TypeNode.BOOLEAN)
              .setValue(String.valueOf(restNumericEnumEnabled))
              .build();
      paramsPutArgs.add(ValueExpr.withValue(primitiveValue));

      returnExpr =
          MethodInvocationExpr.builder()
              .setExprReferenceExpr(serializerExpr)
              .setMethodName(serializerMethodName)
              .setArguments(paramsPutArgs.build())
              .setReturnType(extractorReturnType)
              .build();
    }

    return LambdaExpr.builder()
        .setArguments(requestVarExpr.toBuilder().setIsDecl(true).build())
        .setBody(bodyStatements)
        .setReturnExpr(returnExpr)
        .build();
  }

  private static Expr createFieldsExtractorClassInstance(
      Method method,
      TypeNode extractorReturnType,
      Set<HttpBinding> httpBindingFieldNames,
      String serializerMethodName,
      boolean restNumericEnumsEnabled) {
    List<Statement> bodyStatements = new ArrayList<>();

    VariableExpr fieldsVarExpr =
        VariableExpr.withVariable(
            Variable.builder().setName("fields").setType(extractorReturnType).build());
    Expr fieldsAssignExpr =
        AssignmentExpr.builder()
            .setVariableExpr(fieldsVarExpr.toBuilder().setIsDecl(true).build())
            .setValueExpr(
                NewObjectExpr.builder()
                    .setType(FIXED_REST_TYPESTORE.get(HashMap.class.getSimpleName()))
                    .setIsGeneric(true)
                    .build())
            .build();

    bodyStatements.add(ExprStatement.withExpr(fieldsAssignExpr));

    TypeNode serializerVarType =
        TypeNode.withReference(
            ConcreteReference.builder()
                .setClazz(ProtoRestSerializer.class)
                .setGenerics(method.inputType().reference())
                .build());

    VariableExpr serializerVarExpr =
        VariableExpr.withVariable(
            Variable.builder().setName("serializer").setType(serializerVarType).build());

    Expr serializerAssignExpr =
        AssignmentExpr.builder()
            .setVariableExpr(serializerVarExpr.toBuilder().setIsDecl(true).build())
            .setValueExpr(
                MethodInvocationExpr.builder()
                    .setStaticReferenceType(
                        FIXED_REST_TYPESTORE.get(ProtoRestSerializer.class.getSimpleName()))
                    .setMethodName("create")
                    .setReturnType(serializerVarType)
                    .build())
            .build();

    bodyStatements.add(ExprStatement.withExpr(serializerAssignExpr));

    VariableExpr requestVarExpr =
        VariableExpr.withVariable(
            Variable.builder().setType(method.inputType()).setName("request").build());

    for (HttpBinding httpBindingFieldName : httpBindingFieldNames) {
      MethodInvocationExpr.Builder requestFieldGetterExprBuilder =
          MethodInvocationExpr.builder().setExprReferenceExpr(requestVarExpr);
      MethodInvocationExpr.Builder requestFieldHasExprBuilder =
          MethodInvocationExpr.builder().setExprReferenceExpr(requestVarExpr);
      String[] descendantFields = httpBindingFieldName.name().split("\\.");
      for (int i = 0; i < descendantFields.length; i++) {
        String currFieldName = descendantFields[i];
        String bindingFieldMethodName =
            getBindingFieldMethodName(
                httpBindingFieldName,
                descendantFields.length,
                i,
                JavaStyle.toUpperCamelCase(currFieldName));
        requestFieldGetterExprBuilder =
            requestFieldGetterExprBuilder.setMethodName(bindingFieldMethodName);

        String bindingFieldHasMethodName =
            (i < descendantFields.length - 1)
                ? bindingFieldMethodName
                : String.format("has%s", JavaStyle.toUpperCamelCase(currFieldName));
        requestFieldHasExprBuilder =
            requestFieldHasExprBuilder
                .setMethodName(bindingFieldHasMethodName)
                .setReturnType(TypeNode.BOOLEAN);

        if (i < descendantFields.length - 1) {
          requestFieldGetterExprBuilder =
              MethodInvocationExpr.builder()
                  .setExprReferenceExpr(requestFieldGetterExprBuilder.build());
          requestFieldHasExprBuilder =
              MethodInvocationExpr.builder()
                  .setExprReferenceExpr(requestFieldHasExprBuilder.build());
        }
      }

      MethodInvocationExpr requestBuilderExpr = requestFieldGetterExprBuilder.build();
      MethodInvocationExpr requestHasExpr = requestFieldHasExprBuilder.build();

      ImmutableList.Builder<Expr> paramsPutArgs = ImmutableList.builder();
      paramsPutArgs.add(fieldsVarExpr);
      paramsPutArgs.add(
          ValueExpr.withValue(
              StringObjectValue.withValue(
                  (httpBindingFieldName.jsonName() != null)
                      ? httpBindingFieldName.jsonName()
                      : JavaStyle.toLowerCamelCase(httpBindingFieldName.name()))));
      paramsPutArgs.add(requestBuilderExpr);

      Expr paramsPutExpr =
          MethodInvocationExpr.builder()
              .setExprReferenceExpr(serializerVarExpr)
              .setMethodName(serializerMethodName)
              .setArguments(paramsPutArgs.build())
              .setReturnType(extractorReturnType)
              .build();

      if (httpBindingFieldName.isOptional()) {
        bodyStatements.add(
            IfStatement.builder()
                .setConditionExpr(requestHasExpr)
                .setBody(Arrays.asList(ExprStatement.withExpr(paramsPutExpr)))
                .build());
      } else {
        bodyStatements.add(ExprStatement.withExpr(paramsPutExpr));
      }
    }

    if (restNumericEnumsEnabled && serializerMethodName.equals("putQueryParam")) {
      ImmutableList.Builder<Expr> paramsPutArgs = ImmutableList.builder();
      paramsPutArgs.add(fieldsVarExpr);
      paramsPutArgs.add(ValueExpr.withValue(StringObjectValue.withValue("$alt")));
      paramsPutArgs.add(ValueExpr.withValue(StringObjectValue.withValue("json;enum-encoding=int")));

      Expr paramsPutExpr =
          MethodInvocationExpr.builder()
              .setExprReferenceExpr(serializerVarExpr)
              .setMethodName(serializerMethodName)
              .setArguments(paramsPutArgs.build())
              .setReturnType(extractorReturnType)
              .build();
      bodyStatements.add(ExprStatement.withExpr(paramsPutExpr));
    }

    return LambdaExpr.builder()
        .setArguments(requestVarExpr.toBuilder().setIsDecl(true).build())
        .setBody(bodyStatements)
        .setReturnExpr(fieldsVarExpr)
        .build();
  }

  static String getBindingFieldMethodName(
      HttpBinding httpBindingField, int descendantFieldsLengths, int index, String currFieldName) {
    if (index == descendantFieldsLengths - 1) {
      if (httpBindingField.isRepeated()) {
        return String.format("get%sList", currFieldName);
      }
      if (httpBindingField.isEnum()) {
        return String.format("get%sValue", currFieldName);
      }
    }
    return String.format("get%s", currFieldName);
  }
}
