// Copyright 2022 Google LLC
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

package com.google.api.generator.gapic.composer.samplecode;

import com.google.api.generator.engine.ast.AssignmentExpr;
import com.google.api.generator.engine.ast.CommentStatement;
import com.google.api.generator.engine.ast.Expr;
import com.google.api.generator.engine.ast.ExprStatement;
import com.google.api.generator.engine.ast.ForStatement;
import com.google.api.generator.engine.ast.LineComment;
import com.google.api.generator.engine.ast.MethodInvocationExpr;
import com.google.api.generator.engine.ast.Statement;
import com.google.api.generator.engine.ast.TryCatchStatement;
import com.google.api.generator.engine.ast.TypeNode;
import com.google.api.generator.engine.ast.Variable;
import com.google.api.generator.engine.ast.VariableExpr;
import com.google.api.generator.gapic.composer.defaultvalue.DefaultValueComposer;
import com.google.api.generator.gapic.model.Field;
import com.google.api.generator.gapic.model.Message;
import com.google.api.generator.gapic.model.Method;
import com.google.api.generator.gapic.model.RegionTag;
import com.google.api.generator.gapic.model.ResourceName;
import com.google.api.generator.gapic.model.Sample;
import com.google.api.generator.gapic.model.Service;
import com.google.api.generator.gapic.utils.JavaStyle;
import com.google.common.base.Preconditions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ServiceClientMethodSampleComposer {
  // Creates an example for an empty service (no API methods), which is a corner case but can
  // happen. Generated example will only show how to instantiate the client class but will not call
  // any API methods (because there are no API methods).
  public static Sample composeEmptyServiceSample(TypeNode clientType, Service service) {
    VariableExpr clientVarExpr =
        VariableExpr.withVariable(
            Variable.builder()
                .setName(JavaStyle.toLowerCamelCase(clientType.reference().name()))
                .setType(clientType)
                .build());

    List<Statement> bodyStatements = new ArrayList<>();

    RegionTag regionTag =
        RegionTag.builder().setServiceName(service.name()).setRpcName("emtpy").build();

    List<Statement> body =
        Arrays.asList(
            TryCatchStatement.builder()
                .setTryResourceExpr(
                    SampleComposerUtil.assignClientVariableWithCreateMethodExpr(clientVarExpr))
                .setTryBody(bodyStatements)
                .setIsSampleCode(true)
                .build());
    return Sample.builder().setBody(body).setRegionTag(regionTag).setIsCanonical(true).build();
  }

  public static Sample composeCanonicalSample(
      Method method,
      TypeNode clientType,
      Map<String, ResourceName> resourceNames,
      Map<String, Message> messageTypes,
      Service service) {
    VariableExpr clientVarExpr =
        VariableExpr.withVariable(
            Variable.builder()
                .setName(JavaStyle.toLowerCamelCase(clientType.reference().name()))
                .setType(clientType)
                .build());

    // Create request variable expression and assign with its default value.
    VariableExpr requestVarExpr =
        VariableExpr.withVariable(
            Variable.builder().setName("request").setType(method.inputType()).build());
    List<VariableExpr> rpcMethodArgVarExprs = Arrays.asList(requestVarExpr);
    Message requestMessage = messageTypes.get(method.inputType().reference().fullName());
    Preconditions.checkNotNull(
        requestMessage,
        String.format(
            "Could not find the message type %s.", method.inputType().reference().fullName()));
    Expr requestBuilderExpr =
        DefaultValueComposer.createSimpleMessageBuilderValue(
            requestMessage, resourceNames, messageTypes, method.httpBindings());
    AssignmentExpr requestAssignmentExpr =
        AssignmentExpr.builder()
            .setVariableExpr(requestVarExpr.toBuilder().setIsDecl(true).build())
            .setValueExpr(requestBuilderExpr)
            .build();

    List<Expr> bodyExprs = new ArrayList<>();
    bodyExprs.add(requestAssignmentExpr);

    List<Statement> bodyStatements = new ArrayList<>();
    RegionTag regionTag;
    if (method.isPaged()) {
      // e.g. echoClient.pagedExpand(request).iterateAll()
      Sample unaryPagedRpc =
          composePagedSample(
              method, clientVarExpr, rpcMethodArgVarExprs, bodyExprs, messageTypes, service);
      bodyStatements.addAll(unaryPagedRpc.body());
      regionTag = unaryPagedRpc.regionTag();
    } else if (method.hasLro()) {
      Sample unaryLroRpc =
          composeLroSample(method, clientVarExpr, rpcMethodArgVarExprs, bodyExprs, service);
      bodyStatements.addAll(unaryLroRpc.body());
      regionTag = unaryLroRpc.regionTag();
    } else {
      // e.g. echoClient.echo(request)
      Sample unaryRpc =
          composeSample(method, clientVarExpr, rpcMethodArgVarExprs, bodyExprs, service);
      bodyStatements.addAll(unaryRpc.body());
      regionTag = unaryRpc.regionTag();
    }

    List<Statement> body =
        Arrays.asList(
            TryCatchStatement.builder()
                .setTryResourceExpr(
                    SampleComposerUtil.assignClientVariableWithCreateMethodExpr(clientVarExpr))
                .setTryBody(bodyStatements)
                .setIsSampleCode(true)
                .build());
    return Sample.builder().setBody(body).setRegionTag(regionTag).setIsCanonical(true).build();
  }

  static Sample composeSample(
      Method method,
      VariableExpr clientVarExpr,
      List<VariableExpr> rpcMethodArgVarExprs,
      List<Expr> bodyExprs,
      Service service) {

    // Invoke current method based on return type.
    // e.g. if return void, echoClient.echo(..); or,
    // e.g. if return other type, EchoResponse response = echoClient.echo(...);
    boolean returnsVoid = method.outputType().isProtoEmptyType();
    MethodInvocationExpr clientRpcMethodInvocationExpr =
        MethodInvocationExpr.builder()
            .setExprReferenceExpr(clientVarExpr)
            .setMethodName(JavaStyle.toLowerCamelCase(method.name()))
            .setArguments(
                rpcMethodArgVarExprs.stream().map(e -> (Expr) e).collect(Collectors.toList()))
            .setReturnType(method.outputType())
            .build();
    if (returnsVoid) {
      bodyExprs.add(clientRpcMethodInvocationExpr);
    } else {
      VariableExpr responseVarExpr =
          VariableExpr.withVariable(
              Variable.builder().setName("response").setType(method.outputType()).build());
      bodyExprs.add(
          AssignmentExpr.builder()
              .setVariableExpr(responseVarExpr.toBuilder().setIsDecl(true).build())
              .setValueExpr(clientRpcMethodInvocationExpr)
              .build());
    }

    RegionTag regionTag =
        RegionTag.builder()
            .setServiceName(service.name())
            .setRpcName(method.name())
            .setOverloadDisambiguation(
                SampleComposerUtil.createOverloadDisambiguation(rpcMethodArgVarExprs))
            .build();
    return Sample.builder()
        .setBody(
            bodyExprs.stream().map(e -> ExprStatement.withExpr(e)).collect(Collectors.toList()))
        .setRegionTag(regionTag)
        .build();
  }

  static Sample composePagedSample(
      Method method,
      VariableExpr clientVarExpr,
      List<VariableExpr> rpcMethodArgVarExprs,
      List<Expr> bodyExprs,
      Map<String, Message> messageTypes,
      Service service) {

    // Find the repeated field.
    Message methodOutputMessage = messageTypes.get(method.outputType().reference().fullName());
    Preconditions.checkNotNull(
        methodOutputMessage,
        "Output message %s not found, keys: ",
        method.outputType().reference().fullName(),
        messageTypes.keySet().toString());
    Field repeatedPagedResultsField = methodOutputMessage.findAndUnwrapPaginatedRepeatedField();
    Preconditions.checkNotNull(
        repeatedPagedResultsField,
        String.format(
            "No repeated field found on message %s for method %s",
            methodOutputMessage.name(), method.name()));
    TypeNode repeatedResponseType = repeatedPagedResultsField.type();

    // For loop paged response item on iterateAll method.
    // e.g. for (LogEntry element : loggingServiceV2Client.ListLogs(parent).iterateAll()) {
    //          //doThingsWith(element);
    //      }
    MethodInvocationExpr clientMethodIterateAllExpr =
        MethodInvocationExpr.builder()
            .setExprReferenceExpr(clientVarExpr)
            .setMethodName(JavaStyle.toLowerCamelCase(method.name()))
            .setArguments(
                rpcMethodArgVarExprs.stream().map(e -> (Expr) e).collect(Collectors.toList()))
            .build();

    clientMethodIterateAllExpr =
        MethodInvocationExpr.builder()
            .setExprReferenceExpr(clientMethodIterateAllExpr)
            .setMethodName("iterateAll")
            .setReturnType(repeatedResponseType)
            .build();
    ForStatement loopIteratorStatement =
        ForStatement.builder()
            .setLocalVariableExpr(
                VariableExpr.builder()
                    .setVariable(
                        Variable.builder().setName("element").setType(repeatedResponseType).build())
                    .setIsDecl(true)
                    .build())
            .setCollectionExpr(clientMethodIterateAllExpr)
            .setBody(
                Arrays.asList(
                    CommentStatement.withComment(
                        LineComment.withComment("doThingsWith(element);"))))
            .build();

    List<Statement> bodyStatements =
        bodyExprs.stream().map(e -> ExprStatement.withExpr(e)).collect(Collectors.toList());
    bodyExprs.clear();
    bodyStatements.add(loopIteratorStatement);

    RegionTag regionTag =
        RegionTag.builder()
            .setServiceName(service.name())
            .setRpcName(method.name())
            .setOverloadDisambiguation(
                SampleComposerUtil.createOverloadDisambiguation(rpcMethodArgVarExprs))
            .build();
    return Sample.builder().setBody(bodyStatements).setRegionTag(regionTag).build();
  }

  static Sample composeLroSample(
      Method method,
      VariableExpr clientVarExpr,
      List<VariableExpr> rpcMethodArgVarExprs,
      List<Expr> bodyExprs,
      Service service) {
    // Assign response variable with invoking client's LRO method.
    // e.g. if return void, echoClient.waitAsync(ttl).get(); or,
    // e.g. if return other type, WaitResponse response = echoClient.waitAsync(ttl).get();
    MethodInvocationExpr invokeLroGetMethodExpr =
        MethodInvocationExpr.builder()
            .setExprReferenceExpr(clientVarExpr)
            .setMethodName(String.format("%sAsync", JavaStyle.toLowerCamelCase(method.name())))
            .setArguments(
                rpcMethodArgVarExprs.stream().map(e -> (Expr) e).collect(Collectors.toList()))
            .build();
    invokeLroGetMethodExpr =
        MethodInvocationExpr.builder()
            .setExprReferenceExpr(invokeLroGetMethodExpr)
            .setMethodName("get")
            .setReturnType(method.lro().responseType())
            .build();
    boolean returnsVoid = method.lro().responseType().isProtoEmptyType();
    if (returnsVoid) {
      bodyExprs.add(invokeLroGetMethodExpr);
    } else {
      VariableExpr responseVarExpr =
          VariableExpr.builder()
              .setVariable(
                  Variable.builder()
                      .setName("response")
                      .setType(method.lro().responseType())
                      .build())
              .setIsDecl(true)
              .build();
      bodyExprs.add(
          AssignmentExpr.builder()
              .setVariableExpr(responseVarExpr)
              .setValueExpr(invokeLroGetMethodExpr)
              .build());
    }
    RegionTag regionTag =
        RegionTag.builder()
            .setServiceName(service.name())
            .setRpcName(method.name())
            .setOverloadDisambiguation(
                SampleComposerUtil.createOverloadDisambiguation(rpcMethodArgVarExprs))
            .build();
    return Sample.builder()
        .setBody(
            bodyExprs.stream().map(e -> ExprStatement.withExpr(e)).collect(Collectors.toList()))
        .setRegionTag(regionTag)
        .build();
  }
}
