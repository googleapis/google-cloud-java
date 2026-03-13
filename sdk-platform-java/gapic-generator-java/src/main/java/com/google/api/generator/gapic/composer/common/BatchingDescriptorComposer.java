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

import com.google.api.gax.batching.PartitionKey;
import com.google.api.gax.batching.RequestBuilder;
import com.google.api.gax.rpc.BatchedRequestIssuer;
import com.google.api.gax.rpc.BatchingDescriptor;
import com.google.api.generator.engine.ast.AnonymousClassExpr;
import com.google.api.generator.engine.ast.AssignmentExpr;
import com.google.api.generator.engine.ast.ConcreteReference;
import com.google.api.generator.engine.ast.Expr;
import com.google.api.generator.engine.ast.ExprStatement;
import com.google.api.generator.engine.ast.ForStatement;
import com.google.api.generator.engine.ast.GeneralForStatement;
import com.google.api.generator.engine.ast.IfStatement;
import com.google.api.generator.engine.ast.MethodDefinition;
import com.google.api.generator.engine.ast.MethodInvocationExpr;
import com.google.api.generator.engine.ast.NewObjectExpr;
import com.google.api.generator.engine.ast.PrimitiveValue;
import com.google.api.generator.engine.ast.Reference;
import com.google.api.generator.engine.ast.RelationalOperationExpr;
import com.google.api.generator.engine.ast.ScopeNode;
import com.google.api.generator.engine.ast.Statement;
import com.google.api.generator.engine.ast.TypeNode;
import com.google.api.generator.engine.ast.UnaryOperationExpr;
import com.google.api.generator.engine.ast.ValueExpr;
import com.google.api.generator.engine.ast.VaporReference;
import com.google.api.generator.engine.ast.Variable;
import com.google.api.generator.engine.ast.VariableExpr;
import com.google.api.generator.gapic.model.Field;
import com.google.api.generator.gapic.model.GapicBatchingSettings;
import com.google.api.generator.gapic.model.Message;
import com.google.api.generator.gapic.model.Method;
import com.google.api.generator.gapic.utils.JavaStyle;
import com.google.common.base.Preconditions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BatchingDescriptorComposer {
  private static final String BATCHING_DESC_PATTERN = "%s_BATCHING_DESC";

  private static final Reference BATCHING_DESCRIPTOR_REF =
      ConcreteReference.withClazz(BatchingDescriptor.class);
  private static final Reference REQUEST_BUILDER_REF =
      ConcreteReference.withClazz(RequestBuilder.class);
  private static final Reference BATCHED_REQUEST_ISSUER_REF =
      ConcreteReference.withClazz(BatchedRequestIssuer.class);

  private static final TypeNode PARTITION_KEY_TYPE = toType(PartitionKey.class);

  private static final String ADD_ALL_METHOD_PATTERN = "addAll%s";
  private static final String GET_LIST_METHOD_PATTERN = "get%sList";
  private static final String GET_COUNT_METHOD_PATTERN = "get%sCount";

  public static Expr createBatchingDescriptorFieldDeclExpr(
      Method method, GapicBatchingSettings batchingSettings, Map<String, Message> messageTypes) {
    List<MethodDefinition> javaMethods = new ArrayList<>();
    javaMethods.add(createGetBatchPartitionKeyMethod(method, batchingSettings, messageTypes));
    javaMethods.add(createGetRequestBuilderMethod(method, batchingSettings));
    javaMethods.add(createSplitResponseMethod(method, batchingSettings, messageTypes));
    javaMethods.add(createSplitExceptionMethod(method));
    javaMethods.add(createCountElementsMethod(method, batchingSettings));
    javaMethods.add(createCountByteSMethod(method));

    TypeNode batchingDescriptorType =
        toType(BATCHING_DESCRIPTOR_REF, method.inputType(), method.outputType());
    AnonymousClassExpr batchingDescriptorClassExpr =
        AnonymousClassExpr.builder()
            .setType(batchingDescriptorType)
            .setMethods(javaMethods)
            .build();

    String varName =
        String.format(BATCHING_DESC_PATTERN, JavaStyle.toUpperSnakeCase(method.name()));
    return AssignmentExpr.builder()
        .setVariableExpr(
            VariableExpr.builder()
                .setVariable(
                    Variable.builder().setType(batchingDescriptorType).setName(varName).build())
                .setIsDecl(true)
                .setScope(ScopeNode.PRIVATE)
                .setIsStatic(true)
                .setIsFinal(true)
                .build())
        .setValueExpr(batchingDescriptorClassExpr)
        .build();
  }

  private static MethodDefinition createGetBatchPartitionKeyMethod(
      Method method, GapicBatchingSettings batchingSettings, Map<String, Message> messageTypes) {
    String methodInputTypeName = method.inputType().reference().fullName();
    Message inputMessage = messageTypes.get(methodInputTypeName);
    Preconditions.checkNotNull(
        inputMessage,
        String.format(
            "Message %s not found for RPC method %s", methodInputTypeName, method.name()));

    VariableExpr requestVarExpr =
        VariableExpr.withVariable(
            Variable.builder().setType(method.inputType()).setName("request").build());

    List<Expr> partitionKeyArgExprs = new ArrayList<>();
    for (String discriminatorFieldName : batchingSettings.discriminatorFieldNames()) {
      Preconditions.checkNotNull(
          inputMessage.fieldMap().get(discriminatorFieldName),
          String.format(
              "Batching discriminator field %s not found in message %s",
              discriminatorFieldName, inputMessage.name()));
      String getterMethodName =
          String.format("get%s", JavaStyle.toUpperCamelCase(discriminatorFieldName));
      partitionKeyArgExprs.add(
          MethodInvocationExpr.builder()
              .setExprReferenceExpr(requestVarExpr)
              .setMethodName(getterMethodName)
              .build());
    }
    Expr returnExpr =
        NewObjectExpr.builder()
            .setType(PARTITION_KEY_TYPE)
            .setArguments(partitionKeyArgExprs)
            .build();

    return MethodDefinition.builder()
        .setIsOverride(true)
        .setScope(ScopeNode.PUBLIC)
        .setReturnType(PARTITION_KEY_TYPE)
        .setName("getBatchPartitionKey")
        .setArguments(requestVarExpr.toBuilder().setIsDecl(true).build())
        .setReturnExpr(returnExpr)
        .build();
  }

  private static MethodDefinition createGetRequestBuilderMethod(
      Method method, GapicBatchingSettings batchingSettings) {
    TypeNode builderType =
        TypeNode.withReference(
            VaporReference.builder()
                .setEnclosingClassNames(method.inputType().reference().name())
                .setName("Builder")
                .setPakkage(method.inputType().reference().pakkage())
                .build());

    VariableExpr builderVarExpr =
        VariableExpr.withVariable(
            Variable.builder().setType(builderType).setName("builder").build());
    VariableExpr requestVarExpr =
        VariableExpr.withVariable(
            Variable.builder().setType(method.inputType()).setName("request").build());

    Expr toBuilderExpr =
        AssignmentExpr.builder()
            .setVariableExpr(builderVarExpr)
            .setValueExpr(
                MethodInvocationExpr.builder()
                    .setExprReferenceExpr(requestVarExpr)
                    .setMethodName("toBuilder")
                    .setReturnType(builderType)
                    .build())
            .build();

    String upperBatchedFieldName = JavaStyle.toUpperCamelCase(batchingSettings.batchedFieldName());
    String getFooListMethodName = String.format(GET_LIST_METHOD_PATTERN, upperBatchedFieldName);
    Expr getFooListExpr =
        MethodInvocationExpr.builder()
            .setExprReferenceExpr(requestVarExpr)
            .setMethodName(getFooListMethodName)
            .build();

    String addAllMethodName = String.format(ADD_ALL_METHOD_PATTERN, upperBatchedFieldName);
    Expr addAllExpr =
        MethodInvocationExpr.builder()
            .setExprReferenceExpr(builderVarExpr)
            .setMethodName(addAllMethodName)
            .setArguments(getFooListExpr)
            .build();

    MethodDefinition appendRequestMethod =
        MethodDefinition.builder()
            .setIsOverride(true)
            .setScope(ScopeNode.PUBLIC)
            .setReturnType(TypeNode.VOID)
            .setName("appendRequest")
            .setArguments(requestVarExpr.toBuilder().setIsDecl(true).build())
            .setBody(
                Arrays.asList(
                    IfStatement.builder()
                        .setConditionExpr(
                            RelationalOperationExpr.equalToWithExprs(
                                builderVarExpr, ValueExpr.createNullExpr()))
                        .setBody(Arrays.asList(ExprStatement.withExpr(toBuilderExpr)))
                        .setElseBody(Arrays.asList(ExprStatement.withExpr(addAllExpr)))
                        .build()))
            .build();

    MethodDefinition buildMethod =
        MethodDefinition.builder()
            .setIsOverride(true)
            .setScope(ScopeNode.PUBLIC)
            .setReturnType(method.inputType())
            .setName("build")
            .setReturnExpr(
                MethodInvocationExpr.builder()
                    .setExprReferenceExpr(builderVarExpr)
                    .setMethodName("build")
                    .setReturnType(method.inputType())
                    .build())
            .build();

    TypeNode anonClassType = toType(REQUEST_BUILDER_REF, method.inputType());
    AnonymousClassExpr requestBuilderAnonClassExpr =
        AnonymousClassExpr.builder()
            .setType(anonClassType)
            .setStatements(
                Arrays.asList(
                    ExprStatement.withExpr(
                        builderVarExpr.toBuilder()
                            .setIsDecl(true)
                            .setScope(ScopeNode.PRIVATE)
                            .build())))
            .setMethods(Arrays.asList(appendRequestMethod, buildMethod))
            .build();

    return MethodDefinition.builder()
        .setIsOverride(true)
        .setScope(ScopeNode.PUBLIC)
        .setReturnType(anonClassType)
        .setName("getRequestBuilder")
        .setReturnExpr(requestBuilderAnonClassExpr)
        .build();
  }

  private static MethodDefinition createSplitResponseMethod(
      Method method, GapicBatchingSettings batchingSettings, Map<String, Message> messageTypes) {
    VariableExpr batchResponseVarExpr =
        VariableExpr.withVariable(
            Variable.builder().setType(method.outputType()).setName("batchResponse").build());

    TypeNode batchedRequestIssuerType = toType(BATCHED_REQUEST_ISSUER_REF, method.outputType());
    TypeNode batchVarType =
        TypeNode.withReference(
            ConcreteReference.builder()
                .setClazz(Collection.class)
                .setGenerics(
                    Arrays.asList(
                        ConcreteReference.wildcardWithUpperBound(
                            batchedRequestIssuerType.reference())))
                .build());
    VariableExpr batchVarExpr =
        VariableExpr.withVariable(
            Variable.builder().setType(batchVarType).setName("batch").build());

    VariableExpr responderVarExpr =
        VariableExpr.withVariable(
            Variable.builder().setType(batchedRequestIssuerType).setName("responder").build());

    VariableExpr batchMessageIndexVarExpr =
        VariableExpr.withVariable(
            Variable.builder().setType(TypeNode.INT).setName("batchMessageIndex").build());

    VariableExpr subresponseElementsVarExpr = null;
    boolean hasSubresponseField = batchingSettings.subresponseFieldName() != null;

    List<Statement> outerForBody = new ArrayList<>();
    if (hasSubresponseField) {
      Message outputMessage = messageTypes.get(method.outputType().reference().fullName());
      Preconditions.checkNotNull(
          outputMessage, String.format("Output message not found for RPC %s", method.name()));

      Field subresponseElementField =
          outputMessage.fieldMap().get(batchingSettings.subresponseFieldName());
      Preconditions.checkNotNull(
          subresponseElementField,
          String.format(
              "Subresponse field %s not found in message %s",
              batchingSettings.subresponseFieldName(), outputMessage.name()));
      TypeNode subresponseElementType = subresponseElementField.type();
      subresponseElementsVarExpr =
          VariableExpr.withVariable(
              Variable.builder()
                  .setType(subresponseElementType)
                  .setName("subresponseElements")
                  .build());

      VariableExpr subresponseCountVarExpr =
          VariableExpr.withVariable(
              Variable.builder().setType(TypeNode.LONG).setName("subresponseCount").build());

      outerForBody.add(
          ExprStatement.withExpr(
              AssignmentExpr.builder()
                  .setVariableExpr(subresponseElementsVarExpr.toBuilder().setIsDecl(true).build())
                  .setValueExpr(
                      NewObjectExpr.builder()
                          .setType(
                              TypeNode.withReference(ConcreteReference.withClazz(ArrayList.class)))
                          .setIsGeneric(true)
                          .build())
                  .build()));

      String getFooCountMethodName = "getMessageCount";
      outerForBody.add(
          ExprStatement.withExpr(
              AssignmentExpr.builder()
                  .setVariableExpr(subresponseCountVarExpr.toBuilder().setIsDecl(true).build())
                  .setValueExpr(
                      MethodInvocationExpr.builder()
                          .setExprReferenceExpr(responderVarExpr)
                          .setMethodName(getFooCountMethodName)
                          .setReturnType(subresponseCountVarExpr.type())
                          .build())
                  .build()));

      List<Expr> innerSubresponseForExprs = new ArrayList<>();
      String getSubresponseFieldMethodName =
          String.format(
              "get%s", JavaStyle.toUpperCamelCase(batchingSettings.subresponseFieldName()));
      Expr addMethodArgExpr =
          MethodInvocationExpr.builder()
              .setExprReferenceExpr(batchResponseVarExpr)
              .setMethodName(getSubresponseFieldMethodName)
              .setArguments(UnaryOperationExpr.postfixIncrementWithExpr(batchMessageIndexVarExpr))
              .build();
      innerSubresponseForExprs.add(
          MethodInvocationExpr.builder()
              .setExprReferenceExpr(subresponseElementsVarExpr)
              .setMethodName("add")
              .setArguments(addMethodArgExpr)
              .build());
      // TODO(miraleung): Increment batchMessageIndexVarExpr.

      VariableExpr forIndexVarExpr =
          VariableExpr.builder()
              .setIsDecl(true)
              .setVariable(Variable.builder().setType(TypeNode.INT).setName("i").build())
              .build();
      ValueExpr initValueExpr =
          ValueExpr.withValue(PrimitiveValue.builder().setValue("0").setType(TypeNode.INT).build());
      GeneralForStatement innerSubresponseForStatement =
          GeneralForStatement.incrementWith(
              forIndexVarExpr,
              initValueExpr,
              subresponseCountVarExpr,
              innerSubresponseForExprs.stream()
                  .map(e -> ExprStatement.withExpr(e))
                  .collect(Collectors.toList()));

      outerForBody.add(innerSubresponseForStatement);
    }

    TypeNode responseType = method.outputType();
    Expr responseBuilderExpr =
        MethodInvocationExpr.builder()
            .setStaticReferenceType(responseType)
            .setMethodName("newBuilder")
            .build();
    if (hasSubresponseField) {
      Preconditions.checkNotNull(
          subresponseElementsVarExpr,
          String.format(
              "subresponseElements variable should not be null for method %s", method.name()));

      responseBuilderExpr =
          MethodInvocationExpr.builder()
              .setExprReferenceExpr(responseBuilderExpr)
              .setMethodName(
                  String.format(
                      "addAll%s",
                      JavaStyle.toUpperCamelCase(batchingSettings.subresponseFieldName())))
              .setArguments(subresponseElementsVarExpr)
              .build();
    }
    responseBuilderExpr =
        MethodInvocationExpr.builder()
            .setExprReferenceExpr(responseBuilderExpr)
            .setMethodName("build")
            .setReturnType(responseType)
            .build();

    VariableExpr responseVarExpr =
        VariableExpr.withVariable(
            Variable.builder().setType(responseType).setName("response").build());
    outerForBody.add(
        ExprStatement.withExpr(
            AssignmentExpr.builder()
                .setVariableExpr(responseVarExpr.toBuilder().setIsDecl(true).build())
                .setValueExpr(responseBuilderExpr)
                .build()));

    outerForBody.add(
        ExprStatement.withExpr(
            MethodInvocationExpr.builder()
                .setExprReferenceExpr(responderVarExpr)
                .setMethodName("setResponse")
                .setArguments(responseVarExpr)
                .build()));

    ForStatement outerForStatement =
        ForStatement.builder()
            .setLocalVariableExpr(responderVarExpr.toBuilder().setIsDecl(true).build())
            .setCollectionExpr(batchVarExpr)
            .setBody(outerForBody)
            .build();

    List<Statement> bodyStatements = new ArrayList<>();
    if (hasSubresponseField) {
      bodyStatements.add(
          ExprStatement.withExpr(
              AssignmentExpr.builder()
                  .setVariableExpr(batchMessageIndexVarExpr.toBuilder().setIsDecl(true).build())
                  .setValueExpr(
                      ValueExpr.withValue(
                          PrimitiveValue.builder().setType(TypeNode.INT).setValue("0").build()))
                  .build()));
    }
    bodyStatements.add(outerForStatement);

    return MethodDefinition.builder()
        .setIsOverride(true)
        .setScope(ScopeNode.PUBLIC)
        .setReturnType(TypeNode.VOID)
        .setName("splitResponse")
        .setArguments(
            Arrays.asList(batchResponseVarExpr, batchVarExpr).stream()
                .map(v -> v.toBuilder().setIsDecl(true).build())
                .collect(Collectors.toList()))
        .setBody(bodyStatements)
        .build();
  }

  private static MethodDefinition createSplitExceptionMethod(Method method) {
    VariableExpr throwableVarExpr =
        VariableExpr.withVariable(
            Variable.builder().setType(toType(Throwable.class)).setName("throwable").build());

    TypeNode batchedRequestIssuerType = toType(BATCHED_REQUEST_ISSUER_REF, method.outputType());
    TypeNode batchVarType =
        TypeNode.withReference(
            ConcreteReference.builder()
                .setClazz(Collection.class)
                .setGenerics(
                    Arrays.asList(
                        ConcreteReference.wildcardWithUpperBound(
                            batchedRequestIssuerType.reference())))
                .build());
    VariableExpr batchVarExpr =
        VariableExpr.withVariable(
            Variable.builder().setType(batchVarType).setName("batch").build());
    VariableExpr responderVarExpr =
        VariableExpr.withVariable(
            Variable.builder().setType(batchedRequestIssuerType).setName("responder").build());

    ForStatement forStatement =
        ForStatement.builder()
            .setLocalVariableExpr(responderVarExpr.toBuilder().setIsDecl(true).build())
            .setCollectionExpr(batchVarExpr)
            .setBody(
                Arrays.asList(
                    ExprStatement.withExpr(
                        MethodInvocationExpr.builder()
                            .setExprReferenceExpr(responderVarExpr)
                            .setMethodName("setException")
                            .setArguments(throwableVarExpr)
                            .build())))
            .build();

    return MethodDefinition.builder()
        .setIsOverride(true)
        .setScope(ScopeNode.PUBLIC)
        .setReturnType(TypeNode.VOID)
        .setName("splitException")
        .setArguments(
            Arrays.asList(throwableVarExpr, batchVarExpr).stream()
                .map(v -> v.toBuilder().setIsDecl(true).build())
                .collect(Collectors.toList()))
        .setBody(Arrays.asList(forStatement))
        .build();
  }

  private static MethodDefinition createCountElementsMethod(
      Method method, GapicBatchingSettings batchingSettings) {
    String getFooCountMethodName =
        String.format(
            GET_COUNT_METHOD_PATTERN,
            JavaStyle.toUpperCamelCase(batchingSettings.batchedFieldName()));
    VariableExpr requestVarExpr =
        VariableExpr.withVariable(
            Variable.builder().setType(method.inputType()).setName("request").build());

    return MethodDefinition.builder()
        .setIsOverride(true)
        .setScope(ScopeNode.PUBLIC)
        .setReturnType(TypeNode.LONG)
        .setName("countElements")
        .setArguments(requestVarExpr.toBuilder().setIsDecl(true).build())
        .setReturnExpr(
            MethodInvocationExpr.builder()
                .setExprReferenceExpr(requestVarExpr)
                .setMethodName(getFooCountMethodName)
                .setReturnType(TypeNode.LONG)
                .build())
        .build();
  }

  private static MethodDefinition createCountByteSMethod(Method method) {
    VariableExpr requestVarExpr =
        VariableExpr.withVariable(
            Variable.builder().setType(method.inputType()).setName("request").build());
    return MethodDefinition.builder()
        .setIsOverride(true)
        .setScope(ScopeNode.PUBLIC)
        .setReturnType(TypeNode.LONG)
        .setName("countBytes")
        .setArguments(requestVarExpr.toBuilder().setIsDecl(true).build())
        .setReturnExpr(
            MethodInvocationExpr.builder()
                .setExprReferenceExpr(requestVarExpr)
                .setMethodName("getSerializedSize")
                .setReturnType(TypeNode.LONG)
                .build())
        .build();
  }

  private static TypeNode toType(Class<?> clazz) {
    return TypeNode.withReference(ConcreteReference.withClazz(clazz));
  }

  private static TypeNode toType(Reference reference, TypeNode... types) {
    return TypeNode.withReference(
        reference.copyAndSetGenerics(
            Arrays.asList(types).stream().map(t -> t.reference()).collect(Collectors.toList())));
  }
}
