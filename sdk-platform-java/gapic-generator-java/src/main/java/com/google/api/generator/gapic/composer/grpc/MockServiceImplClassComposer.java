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

package com.google.api.generator.gapic.composer.grpc;

import com.google.api.core.BetaApi;
import com.google.api.generator.engine.ast.AnnotationNode;
import com.google.api.generator.engine.ast.AnonymousClassExpr;
import com.google.api.generator.engine.ast.AssignmentExpr;
import com.google.api.generator.engine.ast.CastExpr;
import com.google.api.generator.engine.ast.ClassDefinition;
import com.google.api.generator.engine.ast.ConcreteReference;
import com.google.api.generator.engine.ast.Expr;
import com.google.api.generator.engine.ast.ExprStatement;
import com.google.api.generator.engine.ast.IfStatement;
import com.google.api.generator.engine.ast.InstanceofExpr;
import com.google.api.generator.engine.ast.MethodDefinition;
import com.google.api.generator.engine.ast.MethodInvocationExpr;
import com.google.api.generator.engine.ast.NewObjectExpr;
import com.google.api.generator.engine.ast.Reference;
import com.google.api.generator.engine.ast.RelationalOperationExpr;
import com.google.api.generator.engine.ast.ScopeNode;
import com.google.api.generator.engine.ast.Statement;
import com.google.api.generator.engine.ast.StringObjectValue;
import com.google.api.generator.engine.ast.TernaryExpr;
import com.google.api.generator.engine.ast.ThisObjectValue;
import com.google.api.generator.engine.ast.TypeNode;
import com.google.api.generator.engine.ast.ValueExpr;
import com.google.api.generator.engine.ast.VaporReference;
import com.google.api.generator.engine.ast.Variable;
import com.google.api.generator.engine.ast.VariableExpr;
import com.google.api.generator.gapic.composer.common.ClassComposer;
import com.google.api.generator.gapic.composer.store.TypeStore;
import com.google.api.generator.gapic.composer.utils.ClassNames;
import com.google.api.generator.gapic.model.GapicClass;
import com.google.api.generator.gapic.model.GapicClass.Kind;
import com.google.api.generator.gapic.model.GapicContext;
import com.google.api.generator.gapic.model.Method;
import com.google.api.generator.gapic.model.Method.Stream;
import com.google.api.generator.gapic.model.Service;
import com.google.api.generator.gapic.utils.JavaStyle;
import com.google.longrunning.Operation;
import com.google.protobuf.AbstractMessage;
import io.grpc.ServerServiceDefinition;
import io.grpc.stub.StreamObserver;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.annotation.Generated;

public class MockServiceImplClassComposer implements ClassComposer {
  private static final MockServiceImplClassComposer INSTANCE = new MockServiceImplClassComposer();
  private static final String IMPL_BASE_PATTERN = "%sImplBase";
  private static final TypeStore FIXED_TYPESTORE = createStaticTypes();
  private static final VariableExpr requestsVarExpr =
      VariableExpr.withVariable(
          Variable.builder()
              .setName("requests")
              .setType(
                  TypeNode.withReference(
                      ConcreteReference.builder()
                          .setClazz(List.class)
                          .setGenerics(
                              Arrays.asList(FIXED_TYPESTORE.get("AbstractMessage").reference()))
                          .build()))
              .build());

  private static Reference javaObjectReference = ConcreteReference.withClazz(Object.class);
  private static VariableExpr responsesVarExpr;

  private MockServiceImplClassComposer() {}

  public static MockServiceImplClassComposer instance() {
    return INSTANCE;
  }

  @Override
  public GapicClass generate(GapicContext context, Service service) {
    TypeStore typeStore = createDynamicTypes(service);
    String className = ClassNames.getMockServiceImplClassName(service);
    GapicClass.Kind kind = Kind.TEST;
    String pakkage = service.pakkage();

    // Use the full name java.lang.Object if there is a proto message that is also named "Object".
    // Affects GCS.
    if (context.messages().keySet().stream()
        .anyMatch(s -> s.equals("Object") || s.endsWith(".Object"))) {
      javaObjectReference =
          ConcreteReference.builder().setClazz(Object.class).setUseFullName(true).build();
    }

    responsesVarExpr =
        VariableExpr.withVariable(
            Variable.builder()
                .setName("responses")
                .setType(
                    TypeNode.withReference(
                        ConcreteReference.builder()
                            .setClazz(Queue.class)
                            .setGenerics(Arrays.asList(javaObjectReference))
                            .build()))
                .build());

    ClassDefinition classDef =
        ClassDefinition.builder()
            .setPackageString(pakkage)
            .setAnnotations(createClassAnnotations())
            .setScope(ScopeNode.PUBLIC)
            .setName(className)
            .setExtendsType(typeStore.get(String.format(IMPL_BASE_PATTERN, service.name())))
            .setStatements(createFieldDeclarations())
            .setMethods(createClassMethods(service, typeStore))
            .build();
    return GapicClass.create(kind, classDef);
  }

  private static List<Statement> createFieldDeclarations() {
    return Arrays.asList(
        ExprStatement.withExpr(
            requestsVarExpr.toBuilder().setIsDecl(true).setScope(ScopeNode.PRIVATE).build()),
        ExprStatement.withExpr(
            responsesVarExpr.toBuilder().setIsDecl(true).setScope(ScopeNode.PRIVATE).build()));
  }

  private static List<AnnotationNode> createClassAnnotations() {
    return Arrays.asList(
        AnnotationNode.builder().setType(FIXED_TYPESTORE.get("BetaApi")).build(),
        AnnotationNode.builder()
            .setType(FIXED_TYPESTORE.get("Generated"))
            .setDescription("by gapic-generator-java")
            .build());
  }

  private static List<MethodDefinition> createClassMethods(Service service, TypeStore typeStore) {
    List<MethodDefinition> javaMethods = new ArrayList<>();
    javaMethods.add(
        createConstructor(typeStore.get(ClassNames.getMockServiceImplClassName(service))));
    javaMethods.add(createGetRequestsMethod());
    javaMethods.add(createAddResponseMethod());
    javaMethods.add(createSetResponsesMethod(service));
    javaMethods.add(createAddExceptionMethod());
    javaMethods.add(createResetMethod());
    javaMethods.addAll(createProtoMethodOverrides(service));
    return javaMethods;
  }

  private static MethodDefinition createConstructor(TypeNode classType) {
    return MethodDefinition.constructorBuilder()
        .setScope(ScopeNode.PUBLIC)
        .setBody(createRequestResponseAssignStatements())
        .setReturnType(classType)
        .build();
  }

  private static MethodDefinition createGetRequestsMethod() {
    return MethodDefinition.builder()
        .setScope(ScopeNode.PUBLIC)
        .setReturnType(requestsVarExpr.type())
        .setName("getRequests")
        .setReturnExpr(requestsVarExpr)
        .build();
  }

  private static MethodDefinition createAddResponseMethod() {
    VariableExpr responseArgExpr =
        VariableExpr.withVariable(
            Variable.builder()
                .setName("response")
                .setType(FIXED_TYPESTORE.get("AbstractMessage"))
                .build());
    Expr methodInvocationExpr =
        MethodInvocationExpr.builder()
            .setMethodName("add")
            .setArguments(Arrays.asList(responseArgExpr))
            .setExprReferenceExpr(responsesVarExpr)
            .build();
    return MethodDefinition.builder()
        .setScope(ScopeNode.PUBLIC)
        .setReturnType(TypeNode.VOID)
        .setName("addResponse")
        .setArguments(Arrays.asList(responseArgExpr.toBuilder().setIsDecl(true).build()))
        .setBody(Arrays.asList(ExprStatement.withExpr(methodInvocationExpr)))
        .build();
  }

  private static MethodDefinition createSetResponsesMethod(Service service) {
    VariableExpr responsesArgVarExpr =
        VariableExpr.withVariable(
            Variable.builder()
                .setName("responses")
                .setType(
                    TypeNode.withReference(
                        ConcreteReference.builder()
                            .setClazz(List.class)
                            .setGenerics(
                                Arrays.asList(FIXED_TYPESTORE.get("AbstractMessage").reference()))
                            .build()))
                .build());
    Expr responseAssignExpr =
        AssignmentExpr.builder()
            .setVariableExpr(
                responsesVarExpr.toBuilder()
                    .setExprReferenceExpr(
                        ValueExpr.withValue(ThisObjectValue.withType(getThisClassType(service))))
                    .build())
            .setValueExpr(
                NewObjectExpr.builder()
                    .setType(
                        TypeNode.withReference(
                            ConcreteReference.builder()
                                .setClazz(LinkedList.class)
                                .setGenerics(Arrays.asList(javaObjectReference))
                                .build()))
                    .setArguments(Arrays.asList(responsesArgVarExpr))
                    .build())
            .build();
    return MethodDefinition.builder()
        .setScope(ScopeNode.PUBLIC)
        .setReturnType(TypeNode.VOID)
        .setName("setResponses")
        .setArguments(Arrays.asList(responsesArgVarExpr.toBuilder().setIsDecl(true).build()))
        .setBody(Arrays.asList(ExprStatement.withExpr(responseAssignExpr)))
        .build();
  }

  private static MethodDefinition createAddExceptionMethod() {
    VariableExpr exceptionArgExpr =
        VariableExpr.withVariable(
            Variable.builder()
                .setName("exception")
                .setType(TypeNode.withReference(ConcreteReference.withClazz(Exception.class)))
                .build());
    Expr methodInvocationExpr =
        MethodInvocationExpr.builder()
            .setMethodName("add")
            .setArguments(Arrays.asList(exceptionArgExpr))
            .setExprReferenceExpr(responsesVarExpr)
            .build();
    return MethodDefinition.builder()
        .setScope(ScopeNode.PUBLIC)
        .setReturnType(TypeNode.VOID)
        .setName("addException")
        .setArguments(Arrays.asList(exceptionArgExpr.toBuilder().setIsDecl(true).build()))
        .setBody(Arrays.asList(ExprStatement.withExpr(methodInvocationExpr)))
        .build();
  }

  private static MethodDefinition createResetMethod() {
    return MethodDefinition.builder()
        .setScope(ScopeNode.PUBLIC)
        .setReturnType(TypeNode.VOID)
        .setName("reset")
        .setBody(createRequestResponseAssignStatements())
        .build();
  }

  private static List<MethodDefinition> createProtoMethodOverrides(Service service) {
    return service.methods().stream()
        .filter(m -> !m.isMixin()) // Mixin APIs will get their own generated mocks.
        .map(m -> createGenericProtoMethodOverride(m))
        .collect(Collectors.toList());
  }

  private static MethodDefinition createGenericProtoMethodOverride(Method protoMethod) {
    ConcreteReference streamObserverRef = ConcreteReference.withClazz(StreamObserver.class);
    TypeNode objectType = TypeNode.withReference(javaObjectReference);
    VariableExpr localResponseVarExpr =
        VariableExpr.withVariable(
            Variable.builder().setName("response").setType(objectType).build());

    VariableExpr responseObserverVarExpr =
        VariableExpr.withVariable(
            Variable.builder()
                .setName("responseObserver")
                .setType(
                    TypeNode.withReference(
                        streamObserverRef.copyAndSetGenerics(
                            Arrays.asList(protoMethod.outputType().reference()))))
                .build());

    if (protoMethod.stream().equals(Stream.CLIENT) || protoMethod.stream().equals(Stream.BIDI)) {
      return createGenericClientStreamingProtoMethodOverride(
          protoMethod, responseObserverVarExpr, localResponseVarExpr);
    }

    VariableExpr requestArgVarExpr =
        VariableExpr.withVariable(
            Variable.builder().setName("request").setType(protoMethod.inputType()).build());

    return MethodDefinition.builder()
        .setIsOverride(true)
        .setScope(ScopeNode.PUBLIC)
        .setReturnType(TypeNode.VOID)
        .setName(JavaStyle.toLowerCamelCase(protoMethod.name()))
        .setArguments(
            Arrays.asList(
                requestArgVarExpr.toBuilder().setIsDecl(true).build(),
                responseObserverVarExpr.toBuilder().setIsDecl(true).build()))
        .setBody(
            Arrays.asList(
                ExprStatement.withExpr(
                    AssignmentExpr.builder()
                        .setVariableExpr(localResponseVarExpr.toBuilder().setIsDecl(true).build())
                        .setValueExpr(
                            MethodInvocationExpr.builder()
                                .setMethodName("poll")
                                .setExprReferenceExpr(responsesVarExpr)
                                .setReturnType(objectType)
                                .build())
                        .build()),
                createHandleObjectStatement(
                    protoMethod, requestArgVarExpr, responseObserverVarExpr, localResponseVarExpr)))
        .build();
  }

  private static MethodDefinition createGenericClientStreamingProtoMethodOverride(
      Method protoMethod, VariableExpr responseObserverVarExpr, VariableExpr localResponseVarExpr) {
    ConcreteReference streamObserverRef = ConcreteReference.withClazz(StreamObserver.class);

    TypeNode returnType =
        TypeNode.withReference(
            streamObserverRef.copyAndSetGenerics(
                Arrays.asList(protoMethod.inputType().reference())));
    VariableExpr requestObserverVarExpr =
        VariableExpr.withVariable(
            Variable.builder().setName("requestObserver").setType(returnType).build());
    return MethodDefinition.builder()
        .setIsOverride(true)
        .setScope(ScopeNode.PUBLIC)
        .setReturnType(returnType)
        .setName(JavaStyle.toLowerCamelCase(protoMethod.name()))
        .setArguments(
            Arrays.asList(
                responseObserverVarExpr.toBuilder().setIsFinal(true).setIsDecl(true).build()))
        .setBody(
            Arrays.asList(
                ExprStatement.withExpr(
                    AssignmentExpr.builder()
                        .setVariableExpr(requestObserverVarExpr.toBuilder().setIsDecl(true).build())
                        .setValueExpr(
                            createStreamObserverClassInstance(
                                protoMethod,
                                returnType,
                                responseObserverVarExpr,
                                localResponseVarExpr))
                        .build())))
        .setReturnExpr(requestObserverVarExpr)
        .build();
  }

  private static AnonymousClassExpr createStreamObserverClassInstance(
      Method protoMethod,
      TypeNode classType,
      VariableExpr responseObserverVarExpr,
      VariableExpr localResponseVarExpr) {
    return AnonymousClassExpr.builder()
        .setType(classType)
        .setMethods(
            Arrays.asList(
                createOnNextJavaMethod(protoMethod, responseObserverVarExpr, localResponseVarExpr),
                createOnErrorJavaMethod(responseObserverVarExpr),
                createOnCompletedJavaMethod(responseObserverVarExpr)))
        .build();
  }

  private static MethodDefinition createOnNextJavaMethod(
      Method protoMethod, VariableExpr responseObserverVarExpr, VariableExpr localResponseVarExpr) {
    VariableExpr valueVarExpr =
        VariableExpr.withVariable(
            Variable.builder().setName("value").setType(protoMethod.inputType()).build());
    TypeNode objectType = TypeNode.withReference(javaObjectReference);

    Statement addValueToRequestsStatement =
        ExprStatement.withExpr(
            MethodInvocationExpr.builder()
                .setMethodName("add")
                .setArguments(Arrays.asList(valueVarExpr))
                .setExprReferenceExpr(requestsVarExpr)
                .build());
    Statement removeObjectStatement =
        ExprStatement.withExpr(
            AssignmentExpr.builder()
                .setVariableExpr(
                    localResponseVarExpr.toBuilder().setIsDecl(true).setIsFinal(true).build())
                .setValueExpr(
                    MethodInvocationExpr.builder()
                        .setMethodName("remove")
                        .setExprReferenceExpr(responsesVarExpr)
                        .setReturnType(objectType)
                        .build())
                .build());

    Statement handleObjectStatement =
        createHandleObjectStatement(
            protoMethod, null, responseObserverVarExpr, localResponseVarExpr);

    return MethodDefinition.builder()
        .setIsOverride(true)
        .setScope(ScopeNode.PUBLIC)
        .setReturnType(TypeNode.VOID)
        .setName("onNext")
        .setArguments(Arrays.asList(valueVarExpr.toBuilder().setIsDecl(true).build()))
        .setBody(
            Arrays.asList(
                addValueToRequestsStatement, removeObjectStatement, handleObjectStatement))
        .build();
  }

  private static MethodDefinition createOnErrorJavaMethod(VariableExpr responseObserverVarExpr) {
    VariableExpr throwableVarExpr =
        VariableExpr.withVariable(
            Variable.builder()
                .setName("t")
                .setType(TypeNode.withReference(ConcreteReference.withClazz(Throwable.class)))
                .build());
    return MethodDefinition.builder()
        .setIsOverride(true)
        .setScope(ScopeNode.PUBLIC)
        .setReturnType(TypeNode.VOID)
        .setName("onError")
        .setArguments(Arrays.asList(throwableVarExpr.toBuilder().setIsDecl(true).build()))
        .setBody(
            Arrays.asList(
                ExprStatement.withExpr(
                    MethodInvocationExpr.builder()
                        .setMethodName("onError")
                        .setArguments(Arrays.asList(throwableVarExpr))
                        .setExprReferenceExpr(responseObserverVarExpr)
                        .build())))
        .build();
  }

  private static MethodDefinition createOnCompletedJavaMethod(
      VariableExpr responseObserverVarExpr) {
    return MethodDefinition.builder()
        .setIsOverride(true)
        .setScope(ScopeNode.PUBLIC)
        .setReturnType(TypeNode.VOID)
        .setName("onCompleted")
        .setBody(
            Arrays.asList(
                ExprStatement.withExpr(
                    MethodInvocationExpr.builder()
                        .setMethodName("onCompleted")
                        .setExprReferenceExpr(responseObserverVarExpr)
                        .build())))
        .build();
  }

  private static Statement createHandleObjectStatement(
      Method protoMethod,
      VariableExpr requestArgVarExpr,
      VariableExpr responseObserverVarExpr,
      VariableExpr localResponseVarExpr) {
    List<Expr> ifBodyExprs = new ArrayList<>();
    boolean isAnonymousClass = requestArgVarExpr == null;
    if (!isAnonymousClass) {
      ifBodyExprs.add(
          MethodInvocationExpr.builder()
              .setMethodName("add")
              .setArguments(Arrays.asList(requestArgVarExpr))
              .setExprReferenceExpr(requestsVarExpr)
              .build());
    }

    ifBodyExprs.add(
        MethodInvocationExpr.builder()
            .setMethodName("onNext")
            .setArguments(
                Arrays.asList(
                    CastExpr.builder()
                        .setType(protoMethod.outputType())
                        .setExpr(localResponseVarExpr)
                        .build()))
            .setExprReferenceExpr(responseObserverVarExpr)
            .build());

    if (!isAnonymousClass) {
      ifBodyExprs.add(
          MethodInvocationExpr.builder()
              .setMethodName("onCompleted")
              .setExprReferenceExpr(responseObserverVarExpr)
              .build());
    }

    TypeNode exceptionType = TypeNode.withReference(ConcreteReference.withClazz(Exception.class));
    // Constructs `response == null ? "" : response.getClass().getName()`.
    Expr actualResponseTypeString =
        TernaryExpr.builder()
            .setConditionExpr(
                RelationalOperationExpr.equalToWithExprs(
                    localResponseVarExpr, ValueExpr.createNullExpr()))
            .setThenExpr(ValueExpr.withValue(StringObjectValue.withValue("null")))
            .setElseExpr(
                MethodInvocationExpr.builder()
                    .setExprReferenceExpr(
                        MethodInvocationExpr.builder()
                            .setExprReferenceExpr(localResponseVarExpr)
                            .setMethodName("getClass")
                            .build())
                    .setMethodName("getName")
                    .setReturnType(TypeNode.STRING)
                    .build())
            .build();
    Function<TypeNode, Expr> typeToStrFn =
        t ->
            MethodInvocationExpr.builder()
                .setExprReferenceExpr(
                    VariableExpr.builder()
                        .setStaticReferenceType(t)
                        .setVariable(
                            Variable.builder()
                                .setType(TypeNode.CLASS_OBJECT)
                                .setName("class")
                                .build())
                        .build())
                .setMethodName("getName")
                .setReturnType(TypeNode.STRING)
                .build();
    Expr expectedResponseTypeOneString = typeToStrFn.apply(protoMethod.outputType());
    Expr expectedResponseTypeTwoString = typeToStrFn.apply(exceptionType);

    Expr newExceptionExpr =
        NewObjectExpr.builder()
            .setType(
                TypeNode.withReference(ConcreteReference.withClazz(IllegalArgumentException.class)))
            .setArguments(
                // Generates something like:
                // String.format("Unrecognized response type %s, expected %s or %s",
                //     Operation.class.getName(), Exception.class.getName());
                MethodInvocationExpr.builder()
                    .setStaticReferenceType(TypeNode.STRING)
                    .setMethodName("format")
                    .setArguments(
                        ValueExpr.withValue(
                            StringObjectValue.withValue(
                                "Unrecognized response type %s for method "
                                    + protoMethod.name()
                                    + ", expected %s or %s")),
                        actualResponseTypeString,
                        expectedResponseTypeOneString,
                        expectedResponseTypeTwoString)
                    .build())
            .build();

    return IfStatement.builder()
        .setConditionExpr(
            InstanceofExpr.builder()
                .setExpr(localResponseVarExpr)
                .setCheckType(protoMethod.outputType())
                .build())
        .setBody(
            ifBodyExprs.stream().map(e -> ExprStatement.withExpr(e)).collect(Collectors.toList()))
        .addElseIf(
            InstanceofExpr.builder()
                .setExpr(localResponseVarExpr)
                .setCheckType(exceptionType)
                .build(),
            Arrays.asList(
                ExprStatement.withExpr(
                    MethodInvocationExpr.builder()
                        .setMethodName("onError")
                        .setArguments(
                            Arrays.asList(
                                CastExpr.builder()
                                    .setType(exceptionType)
                                    .setExpr(localResponseVarExpr)
                                    .build()))
                        .setExprReferenceExpr(responseObserverVarExpr)
                        .build())))
        .setElseBody(
            Arrays.asList(
                ExprStatement.withExpr(
                    MethodInvocationExpr.builder()
                        .setMethodName("onError")
                        .setExprReferenceExpr(responseObserverVarExpr)
                        .setArguments(Arrays.asList(newExceptionExpr))
                        .build())))
        .build();
  }

  private static TypeStore createStaticTypes() {
    List<Class<?>> concreteClazzes =
        Arrays.asList(
            AbstractMessage.class,
            ArrayList.class,
            BetaApi.class,
            Generated.class,
            LinkedList.class,
            Operation.class,
            ServerServiceDefinition.class,
            StreamObserver.class);
    return new TypeStore(concreteClazzes);
  }

  private static TypeStore createDynamicTypes(Service service) {
    TypeStore typeStore = new TypeStore();
    // Hack: This two should be nested classes and perhaps a static import or something.
    typeStore.put(
        String.format("%s.%sGrpc", service.originalJavaPackage(), service.name()),
        String.format(IMPL_BASE_PATTERN, service.name()));
    typeStore.put(service.pakkage(), ClassNames.getMockServiceImplClassName(service));
    return typeStore;
  }

  private static TypeNode getThisClassType(Service service) {
    return TypeNode.withReference(
        VaporReference.builder()
            .setName(ClassNames.getMockServiceImplClassName(service))
            .setPakkage(service.pakkage())
            .build());
  }

  private static List<Statement> createRequestResponseAssignStatements() {
    Expr assignRequestVarExpr =
        AssignmentExpr.builder()
            .setVariableExpr(requestsVarExpr)
            .setValueExpr(
                NewObjectExpr.builder()
                    .setType(TypeNode.withReference(ConcreteReference.withClazz(ArrayList.class)))
                    .setIsGeneric(true)
                    .build())
            .build();
    Expr assignResponsesVarExpr =
        AssignmentExpr.builder()
            .setVariableExpr(responsesVarExpr)
            .setValueExpr(
                NewObjectExpr.builder()
                    .setType(TypeNode.withReference(ConcreteReference.withClazz(LinkedList.class)))
                    .setIsGeneric(true)
                    .build())
            .build();
    return Arrays.asList(assignRequestVarExpr, assignResponsesVarExpr).stream()
        .map(e -> ExprStatement.withExpr(e))
        .collect(Collectors.toList());
  }
}
