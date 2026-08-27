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

import com.google.api.generator.engine.ast.AssignmentExpr;
import com.google.api.generator.engine.ast.BlockStatement;
import com.google.api.generator.engine.ast.CastExpr;
import com.google.api.generator.engine.ast.ClassDefinition;
import com.google.api.generator.engine.ast.ConcreteReference;
import com.google.api.generator.engine.ast.Expr;
import com.google.api.generator.engine.ast.ExprStatement;
import com.google.api.generator.engine.ast.ForStatement;
import com.google.api.generator.engine.ast.IfStatement;
import com.google.api.generator.engine.ast.InstanceofExpr;
import com.google.api.generator.engine.ast.LogicalOperationExpr;
import com.google.api.generator.engine.ast.UnaryOperationExpr;
import com.google.api.generator.engine.ast.MethodDefinition;
import com.google.api.generator.engine.ast.MethodInvocationExpr;
import com.google.api.generator.engine.ast.NewObjectExpr;
import com.google.api.generator.engine.ast.PrimitiveValue;
import com.google.api.generator.engine.ast.RelationalOperationExpr;
import com.google.api.generator.engine.ast.ReturnExpr;
import com.google.api.generator.engine.ast.ScopeNode;
import com.google.api.generator.engine.ast.Statement;
import com.google.api.generator.engine.ast.StringObjectValue;
import com.google.api.generator.engine.ast.TypeNode;
import com.google.api.generator.engine.ast.ValueExpr;
import com.google.api.generator.engine.ast.VaporReference;
import com.google.api.generator.engine.ast.Variable;
import com.google.api.generator.engine.ast.VariableExpr;
import com.google.api.generator.gapic.composer.comment.CommentComposer;
import com.google.api.generator.gapic.model.GapicClass;
import com.google.api.generator.gapic.model.GapicContext;
import com.google.api.generator.gapic.model.Service;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ComputeLroErrorParserClassComposer {
  private static final ComputeLroErrorParserClassComposer INSTANCE = new ComputeLroErrorParserClassComposer();

  public static ComputeLroErrorParserClassComposer instance() {
    return INSTANCE;
  }

  public GapicClass generate(GapicContext context, Service service) {
    String pakkage = service.pakkage() + ".stub";
    TypeNode parserType = TypeNode.withReference(
        VaporReference.builder().setName("ComputeLroErrorParser").setPakkage(pakkage).build());

    TypeNode httpJsonLroErrorParserType = TypeNode.withReference(
        ConcreteReference.withClazz(com.google.api.gax.httpjson.HttpJsonLroErrorParser.class));
    TypeNode errorDetailsType = TypeNode.withReference(
        ConcreteReference.withClazz(com.google.api.gax.rpc.ErrorDetails.class));
    TypeNode operationType = TypeNode.withReference(
        VaporReference.builder().setName("Operation").setPakkage(service.pakkage()).build());
    TypeNode errorsType = TypeNode.withReference(
        VaporReference.builder().setName("Errors").setPakkage(service.pakkage()).build());
    TypeNode errorInfoType = TypeNode.withReference(
        ConcreteReference.withClazz(com.google.rpc.ErrorInfo.class));
    TypeNode anyType = TypeNode.withReference(
        ConcreteReference.withClazz(com.google.protobuf.Any.class));
    TypeNode listAnyType = TypeNode.withReference(
        ConcreteReference.builder().setClazz(java.util.List.class).setGenerics(anyType.reference()).build());
    TypeNode arrayListAnyType = TypeNode.withReference(
        ConcreteReference.builder().setClazz(java.util.ArrayList.class).setGenerics(anyType.reference()).build());

    VariableExpr responseVar = VariableExpr.withVariable(
        Variable.builder().setType(TypeNode.OBJECT).setName("response").build());
    VariableExpr operationVar = VariableExpr.withVariable(
        Variable.builder().setType(operationType).setName("operation").build());
    VariableExpr rawErrorMessagesVar = VariableExpr.withVariable(
        Variable.builder().setType(listAnyType).setName("rawErrorMessages").build());
    VariableExpr errorVar = VariableExpr.withVariable(
        Variable.builder().setType(errorsType).setName("error").build());
    VariableExpr errorInfoVar = VariableExpr.withVariable(
        Variable.builder().setType(errorInfoType).setName("errorInfo").build());
    VariableExpr sbVar = VariableExpr.withVariable(
        Variable.builder().setType(TypeNode.withReference(ConcreteReference.withClazz(StringBuilder.class))).setName("sb").build());

    // parse() method
    List<Statement> parseBody = new ArrayList<>();
    parseBody.add(IfStatement.builder()
        .setConditionExpr(UnaryOperationExpr.logicalNotWithExpr(
            InstanceofExpr.builder().setExpr(responseVar).setCheckType(operationType).build()))
        .setBody(Arrays.asList(ExprStatement.withExpr(ReturnExpr.withExpr(ValueExpr.createNullExpr()))))
        .build());
    parseBody.add(ExprStatement.withExpr(AssignmentExpr.builder()
        .setVariableExpr(operationVar.toBuilder().setIsDecl(true).build())
        .setValueExpr(CastExpr.builder().setType(operationType).setExpr(responseVar).build())
        .build()));
    parseBody.add(IfStatement.builder()
        .setConditionExpr(UnaryOperationExpr.logicalNotWithExpr(
            MethodInvocationExpr.builder().setExprReferenceExpr(operationVar).setMethodName("hasError").setReturnType(TypeNode.BOOLEAN).build()))
        .setBody(Arrays.asList(ExprStatement.withExpr(ReturnExpr.withExpr(ValueExpr.createNullExpr()))))
        .build());
    parseBody.add(ExprStatement.withExpr(AssignmentExpr.builder()
        .setVariableExpr(rawErrorMessagesVar.toBuilder().setIsDecl(true).build())
        .setValueExpr(NewObjectExpr.builder().setType(arrayListAnyType).build())
        .build()));
    
    Expr getErrorsListExpr = MethodInvocationExpr.builder()
        .setExprReferenceExpr(MethodInvocationExpr.builder().setExprReferenceExpr(operationVar).setMethodName("getError").build())
        .setMethodName("getErrorsList").build();
    
    List<Statement> forBody = new ArrayList<>();
    Expr errorInfoBuilderExpr = MethodInvocationExpr.builder().setStaticReferenceType(errorInfoType).setMethodName("newBuilder").build();
    errorInfoBuilderExpr = MethodInvocationExpr.builder().setExprReferenceExpr(errorInfoBuilderExpr).setMethodName("setReason")
        .setArguments(MethodInvocationExpr.builder().setExprReferenceExpr(errorVar).setMethodName("getCode").setReturnType(TypeNode.STRING).build()).build();
    errorInfoBuilderExpr = MethodInvocationExpr.builder().setExprReferenceExpr(errorInfoBuilderExpr).setMethodName("setDomain")
        .setArguments(ValueExpr.withValue(StringObjectValue.withValue("googleapis.com"))).build();
    errorInfoBuilderExpr = MethodInvocationExpr.builder().setExprReferenceExpr(errorInfoBuilderExpr).setMethodName("putMetadata")
        .setArguments(ValueExpr.withValue(StringObjectValue.withValue("message")), MethodInvocationExpr.builder().setExprReferenceExpr(errorVar).setMethodName("getMessage").setReturnType(TypeNode.STRING).build()).build();
    errorInfoBuilderExpr = MethodInvocationExpr.builder().setExprReferenceExpr(errorInfoBuilderExpr).setMethodName("putMetadata")
        .setArguments(ValueExpr.withValue(StringObjectValue.withValue("location")), MethodInvocationExpr.builder().setExprReferenceExpr(errorVar).setMethodName("getLocation").setReturnType(TypeNode.STRING).build()).build();
    errorInfoBuilderExpr = MethodInvocationExpr.builder().setExprReferenceExpr(errorInfoBuilderExpr).setMethodName("build").setReturnType(errorInfoType).build();
    
    forBody.add(ExprStatement.withExpr(AssignmentExpr.builder()
        .setVariableExpr(errorInfoVar.toBuilder().setIsDecl(true).build())
        .setValueExpr(errorInfoBuilderExpr)
        .build()));
    forBody.add(ExprStatement.withExpr(MethodInvocationExpr.builder()
        .setExprReferenceExpr(rawErrorMessagesVar).setMethodName("add")
        .setArguments(MethodInvocationExpr.builder().setStaticReferenceType(anyType).setMethodName("pack").setArguments(errorInfoVar).setReturnType(anyType).build())
        .build()));
        
    parseBody.add(ForStatement.builder()
        .setLocalVariableExpr(errorVar.toBuilder().setIsDecl(true).build())
        .setCollectionExpr(getErrorsListExpr)
        .setBody(forBody)
        .build());
        
    Expr parseReturnExpr = MethodInvocationExpr.builder()
        .setExprReferenceExpr(MethodInvocationExpr.builder()
            .setExprReferenceExpr(MethodInvocationExpr.builder().setStaticReferenceType(errorDetailsType).setMethodName("builder").build())
            .setMethodName("setRawErrorMessages").setArguments(rawErrorMessagesVar).build())
        .setMethodName("build").setReturnType(errorDetailsType).build();

    MethodDefinition parseMethod = MethodDefinition.builder()
        .setAnnotations(Arrays.asList(com.google.api.generator.engine.ast.AnnotationNode.OVERRIDE))
        .setScope(ScopeNode.PUBLIC)
        .setReturnType(errorDetailsType)
        .setName("parse")
        .setArguments(responseVar.toBuilder().setIsDecl(true).build())
        .setBody(parseBody)
        .setReturnExpr(parseReturnExpr)
        .build();

    // parseErrorMessage() method
    List<Statement> parseErrorBody = new ArrayList<>();
    parseErrorBody.add(IfStatement.builder()
        .setConditionExpr(UnaryOperationExpr.logicalNotWithExpr(
            InstanceofExpr.builder().setExpr(responseVar).setCheckType(operationType).build()))
        .setBody(Arrays.asList(ExprStatement.withExpr(ReturnExpr.withExpr(ValueExpr.createNullExpr()))))
        .build());
    parseErrorBody.add(ExprStatement.withExpr(AssignmentExpr.builder()
        .setVariableExpr(operationVar.toBuilder().setIsDecl(true).build())
        .setValueExpr(CastExpr.builder().setType(operationType).setExpr(responseVar).build())
        .build()));
        
    Expr condition1 = UnaryOperationExpr.logicalNotWithExpr(MethodInvocationExpr.builder().setExprReferenceExpr(operationVar).setMethodName("hasError").setReturnType(TypeNode.BOOLEAN).build());
    Expr condition2 = RelationalOperationExpr.equalToWithExprs(
        MethodInvocationExpr.builder().setExprReferenceExpr(MethodInvocationExpr.builder().setExprReferenceExpr(operationVar).setMethodName("getError").build()).setMethodName("getErrorsCount").setReturnType(TypeNode.INT).build(),
        ValueExpr.withValue(PrimitiveValue.builder().setType(TypeNode.INT).setValue("0").build()));
    parseErrorBody.add(IfStatement.builder()
        .setConditionExpr(LogicalOperationExpr.logicalOrWithExprs(condition1, condition2))
        .setBody(Arrays.asList(ExprStatement.withExpr(ReturnExpr.withExpr(ValueExpr.createNullExpr()))))
        .build());
        
    parseErrorBody.add(ExprStatement.withExpr(AssignmentExpr.builder()
        .setVariableExpr(sbVar.toBuilder().setIsDecl(true).build())
        .setValueExpr(NewObjectExpr.builder().setType(sbVar.type()).build())
        .build()));
        
    List<Statement> forBody2 = new ArrayList<>();
    forBody2.add(IfStatement.builder()
        .setConditionExpr(RelationalOperationExpr.lessThanWithExprs(
            ValueExpr.withValue(PrimitiveValue.builder().setType(TypeNode.INT).setValue("0").build()),
            MethodInvocationExpr.builder().setExprReferenceExpr(sbVar).setMethodName("length").setReturnType(TypeNode.INT).build()))
        .setBody(Arrays.asList(ExprStatement.withExpr(MethodInvocationExpr.builder().setExprReferenceExpr(sbVar).setMethodName("append").setArguments(ValueExpr.withValue(StringObjectValue.withValue("; "))).build())))
        .build());
    
    Expr appendExpr = MethodInvocationExpr.builder().setExprReferenceExpr(sbVar).setMethodName("append").setArguments(MethodInvocationExpr.builder().setExprReferenceExpr(errorVar).setMethodName("getCode").build()).build();
    appendExpr = MethodInvocationExpr.builder().setExprReferenceExpr(appendExpr).setMethodName("append").setArguments(ValueExpr.withValue(StringObjectValue.withValue(": "))).build();
    appendExpr = MethodInvocationExpr.builder().setExprReferenceExpr(appendExpr).setMethodName("append").setArguments(MethodInvocationExpr.builder().setExprReferenceExpr(errorVar).setMethodName("getMessage").build()).build();
    forBody2.add(ExprStatement.withExpr(appendExpr));
    
    parseErrorBody.add(ForStatement.builder()
        .setLocalVariableExpr(errorVar.toBuilder().setIsDecl(true).build())
        .setCollectionExpr(getErrorsListExpr)
        .setBody(forBody2)
        .build());
        
    Expr parseErrorReturnExpr = MethodInvocationExpr.builder().setExprReferenceExpr(sbVar).setMethodName("toString").setReturnType(TypeNode.STRING).build();

    MethodDefinition parseErrorMethod = MethodDefinition.builder()
        .setAnnotations(Arrays.asList(com.google.api.generator.engine.ast.AnnotationNode.OVERRIDE))
        .setScope(ScopeNode.PUBLIC)
        .setReturnType(TypeNode.STRING)
        .setName("parseErrorMessage")
        .setArguments(responseVar.toBuilder().setIsDecl(true).build())
        .setBody(parseErrorBody)
        .setReturnExpr(parseErrorReturnExpr)
        .build();

    ClassDefinition classDef = ClassDefinition.builder()
        .setFileHeader(CommentComposer.APACHE_LICENSE_COMMENT)
        .setPackageString(pakkage)
        .setName("ComputeLroErrorParser")
        .setScope(ScopeNode.PUBLIC)
        .setImplementsTypes(Arrays.asList(httpJsonLroErrorParserType))
        .setMethods(Arrays.asList(parseMethod, parseErrorMethod))
        .build();

    return GapicClass.create(GapicClass.Kind.STUB, classDef);
  }
}
