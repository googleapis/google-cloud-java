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

package com.google.api.generator.engine.ast;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertThrows;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

class MethodDefinitionTest {
  @Test
  void validMethodDefinition_basicWithComments() {
    MethodDefinition.builder()
        .setHeaderCommentStatements(createCommentStatements())
        .setName("close")
        .setScope(ScopeNode.PUBLIC)
        .setReturnType(TypeNode.VOID)
        .setBody(Arrays.asList(ExprStatement.withExpr(createAssignmentExpr())))
        .build();
    // No exception thrown, we're good.
  }

  @Test
  void validMethodDefinition_emptyBody() {
    MethodDefinition.builder()
        .setHeaderCommentStatements(createCommentStatements())
        .setName("close")
        .setScope(ScopeNode.PUBLIC)
        .setReturnType(TypeNode.VOID)
        .build();
  }

  @Test
  void validMethodDefinition_repeatedAnnotations() {
    MethodDefinition method =
        MethodDefinition.builder()
            .setName("close")
            .setAnnotations(
                Arrays.asList(
                    AnnotationNode.withSuppressWarnings("all"),
                    AnnotationNode.DEPRECATED,
                    AnnotationNode.DEPRECATED))
            .setScope(ScopeNode.PUBLIC)
            .setReturnType(TypeNode.VOID)
            .setBody(Arrays.asList(ExprStatement.withExpr(createAssignmentExpr())))
            .build();
    assertThat(method.annotations())
        .containsExactly(AnnotationNode.withSuppressWarnings("all"), AnnotationNode.DEPRECATED);
  }

  @Test
  void validMethodDefinition_basicWithReturnType() {
    MethodDefinition.builder()
        .setName("close")
        .setScope(ScopeNode.PUBLIC)
        .setReturnType(TypeNode.STRING)
        .setBody(Arrays.asList(ExprStatement.withExpr(createAssignmentExpr())))
        .setReturnExpr(
            MethodInvocationExpr.builder()
                .setMethodName("foobar")
                .setReturnType(TypeNode.STRING)
                .build())
        .build();
    // No exception thrown, we're good.
  }

  @Test
  void validMethodDefinition_throwInsteadOfReturnType() {
    MethodDefinition.builder()
        .setName("foobar")
        .setScope(ScopeNode.PUBLIC)
        .setReturnType(TypeNode.STRING)
        .setBody(
            Arrays.asList(
                ExprStatement.withExpr(createAssignmentExpr()),
                ExprStatement.withExpr(
                    ThrowExpr.builder()
                        .setType(
                            TypeNode.withReference(
                                ConcreteReference.withClazz(NullPointerException.class)))
                        .build())))
        .build();
  }

  @Test
  void validMethodDefinition_voidThrowInsteadOfReturnType() {
    MethodDefinition.builder()
        .setName("foobar")
        .setScope(ScopeNode.PUBLIC)
        .setReturnType(TypeNode.VOID)
        .setBody(
            Arrays.asList(
                ExprStatement.withExpr(createAssignmentExpr()),
                ExprStatement.withExpr(
                    ThrowExpr.builder()
                        .setType(
                            TypeNode.withReference(
                                ConcreteReference.withClazz(NullPointerException.class)))
                        .build())))
        .build();
  }

  @Test
  void validMethodDefinition_subtyping() {
    Reference stringRef = ConcreteReference.withClazz(String.class);
    TypeNode returnType =
        TypeNode.withReference(
            ConcreteReference.builder()
                .setClazz(List.class)
                .setGenerics(Arrays.asList(stringRef))
                .build());
    TypeNode actualReturnType =
        TypeNode.withReference(
            ConcreteReference.builder()
                .setClazz(ArrayList.class)
                .setGenerics(Arrays.asList(stringRef))
                .build());

    MethodInvocationExpr methodExpr =
        MethodInvocationExpr.builder()
            .setMethodName("getSomeList")
            .setReturnType(actualReturnType)
            .build();

    MethodDefinition.builder()
        .setName("getAList")
        .setScope(ScopeNode.PUBLIC)
        .setReturnType(returnType)
        .setBody(Arrays.asList(ExprStatement.withExpr(createAssignmentExpr())))
        .setReturnExpr(methodExpr)
        .build();
    // No exception thrown, we're good.
  }

  @Test
  void validMethodDefinition_basicAbstract() {
    MethodDefinition.builder()
        .setName("close")
        .setIsAbstract(true)
        .setScope(ScopeNode.PUBLIC)
        .setReturnType(TypeNode.VOID)
        .build();
    // No exception thrown, we're good.
  }

  @Test
  void validMethodDefinition_constructor() {
    TypeNode returnType =
        TypeNode.withReference(
            VaporReference.builder()
                .setName("LibrarySettings")
                .setPakkage("com.google.example.library.v1")
                .build());
    MethodDefinition.constructorBuilder()
        .setScope(ScopeNode.PUBLIC)
        .setReturnType(returnType)
        .build();
  }

  @Test
  void validMethodDefinition_withArgumentsAndReturnExpr() {
    ValueExpr returnExpr =
        ValueExpr.builder()
            .setValue(PrimitiveValue.builder().setType(TypeNode.INT).setValue("3").build())
            .build();
    List<VariableExpr> arguments =
        Arrays.asList(
            VariableExpr.builder()
                .setVariable(createVariable("x", TypeNode.INT))
                .setIsDecl(true)
                .build(),
            VariableExpr.builder()
                .setVariable(createVariable("y", TypeNode.INT))
                .setIsDecl(true)
                .build());
    MethodDefinition.builder()
        .setName("close")
        .setScope(ScopeNode.PUBLIC)
        .setReturnType(TypeNode.INT)
        .setArguments(arguments)
        .setReturnExpr(returnExpr)
        .setBody(Arrays.asList(ExprStatement.withExpr(createAssignmentExpr())))
        .build();
    // No exception thrown, we're good.
  }

  @Test
  void validMethodDefinition_nonRuntimeException() {
    MethodDefinition.builder()
        .setName("close")
        .setScope(ScopeNode.PUBLIC)
        .setReturnType(TypeNode.VOID)
        .setBody(Arrays.asList(ExprStatement.withExpr(createAssignmentExpr())))
        .setThrowsExceptions(Arrays.asList(TypeNode.withExceptionClazz(InterruptedException.class)))
        .build();
    // No exception thrown, we're good.
  }

  @Test
  void validMethodDefinition_templateBasic() {
    TypeNode returnType = TypeNode.withReference(ConcreteReference.withClazz(Map.class));
    MethodDefinition.builder()
        .setName("close")
        .setScope(ScopeNode.PUBLIC)
        .setReturnType(returnType)
        .setTemplateNames(Arrays.asList("T", "K", "V"))
        .setReturnTemplateNames(Arrays.asList("K", "V"))
        .setBody(Arrays.asList(ExprStatement.withExpr(createAssignmentExpr())))
        .setReturnExpr(
            MethodInvocationExpr.builder()
                .setMethodName("foobar")
                .setReturnType(returnType)
                .build())
        .build();
  }

  @Test
  void validMethodDefinition_templateOnArguments() {
    Reference listRef = ConcreteReference.withClazz(List.class);
    List<VariableExpr> arguments =
        Arrays.asList(
            VariableExpr.builder()
                .setVariable(createVariable("x", TypeNode.withReference(listRef)))
                .setIsDecl(true)
                .setTemplateObjects(Arrays.asList("K"))
                .build(),
            VariableExpr.builder()
                .setVariable(createVariable("y", TypeNode.withReference(listRef)))
                .setIsDecl(true)
                .setTemplateObjects(Arrays.asList("V"))
                .build());

    TypeNode returnType = TypeNode.withReference(ConcreteReference.withClazz(Map.class));
    MethodDefinition.builder()
        .setName("close")
        .setScope(ScopeNode.PUBLIC)
        .setReturnType(returnType)
        .setTemplateNames(Arrays.asList("T", "K", "V"))
        .setArguments(arguments)
        .setBody(Arrays.asList(ExprStatement.withExpr(createAssignmentExpr())))
        .setReturnExpr(
            MethodInvocationExpr.builder()
                .setMethodName("foobar")
                .setReturnType(returnType)
                .build())
        .build();
  }

  @Test
  void validMethodDefinition_primitiveReturnTypeWithoutTemplates() {
    // Not valid Java. Please change this test if you are trying to prevent this case.
    MethodDefinition.builder()
        .setName("close")
        .setScope(ScopeNode.PUBLIC)
        .setReturnType(TypeNode.VOID)
        .setTemplateNames(Arrays.asList("T", "K", "V"))
        .setBody(Arrays.asList(ExprStatement.withExpr(createAssignmentExpr())))
        .build();
  }

  @Test
  void validMethodDefinition_boxedReturnType() {
    MethodDefinition.builder()
        .setName("foobar")
        .setScope(ScopeNode.PUBLIC)
        .setReturnType(TypeNode.INT_OBJECT)
        .setBody(Arrays.asList(ExprStatement.withExpr(createAssignmentExpr())))
        .setReturnExpr(
            ValueExpr.withValue(
                PrimitiveValue.builder().setType(TypeNode.INT).setValue("3").build()))
        .build();
  }

  @Test
  void validMethodDefinition_setReturnExprUsingReturnExpr() {
    ReturnExpr returnExpr =
        ReturnExpr.withExpr(
            ValueExpr.withValue(
                PrimitiveValue.builder().setType(TypeNode.INT).setValue("3").build()));
    MethodDefinition.builder()
        .setName("foobar")
        .setScope(ScopeNode.PUBLIC)
        .setReturnType(TypeNode.INT_OBJECT)
        .setBody(Arrays.asList(ExprStatement.withExpr(createAssignmentExpr())))
        .setReturnExpr(returnExpr)
        .build();
  }

  @Test
  void invalidMethodDefinition_badTemplateName() {
    assertThrows(
        IdentifierNode.InvalidIdentifierException.class,
        () ->
            MethodDefinition.builder()
                .setName("close")
                .setScope(ScopeNode.PUBLIC)
                .setReturnType(TypeNode.VOID)
                .setTemplateNames(Arrays.asList("T", "K", "false"))
                .setBody(Arrays.asList(ExprStatement.withExpr(createAssignmentExpr())))
                .build());
  }

  @Test
  void invalidMethodDefinition_primitiveReturnType() {
    assertThrows(
        IllegalStateException.class,
        () ->
            MethodDefinition.builder()
                .setName("close")
                .setScope(ScopeNode.PUBLIC)
                .setReturnType(TypeNode.VOID)
                .setTemplateNames(Arrays.asList("T", "K", "V"))
                .setReturnTemplateNames(Arrays.asList("K", "V"))
                .setBody(Arrays.asList(ExprStatement.withExpr(createAssignmentExpr())))
                .build());
  }

  @Test
  void invalidMethodDefinition_emptyTemplatesOnMethod() {
    assertThrows(
        IllegalStateException.class,
        () ->
            MethodDefinition.builder()
                .setName("close")
                .setScope(ScopeNode.PUBLIC)
                .setReturnType(TypeNode.VOID)
                .setReturnTemplateNames(Arrays.asList("K", "V"))
                .setBody(Arrays.asList(ExprStatement.withExpr(createAssignmentExpr())))
                .setThrowsExceptions(
                    Arrays.asList(TypeNode.withExceptionClazz(InterruptedException.class)))
                .build());
  }

  @Test
  void invalidMethodDefinition_returnTemplatesNotPresent() {
    assertThrows(
        IllegalStateException.class,
        () ->
            MethodDefinition.builder()
                .setName("close")
                .setScope(ScopeNode.PUBLIC)
                .setReturnType(TypeNode.VOID)
                .setTemplateNames(Arrays.asList("T", "K", "V"))
                .setReturnTemplateNames(Arrays.asList("K", "R"))
                .setBody(Arrays.asList(ExprStatement.withExpr(createAssignmentExpr())))
                .setThrowsExceptions(
                    Arrays.asList(TypeNode.withExceptionClazz(InterruptedException.class)))
                .build());
  }

  @Test
  void invalidMethodDefinition_noName() {
    assertThrows(
        NullPointerException.class,
        () -> {
          MethodDefinition.builder()
              .setScope(ScopeNode.PUBLIC)
              .setReturnType(TypeNode.VOID)
              .setBody(Arrays.asList(ExprStatement.withExpr(createAssignmentExpr())))
              .build();
        });
  }

  @Test
  void invalidMethodDefinition_runtimeException() {
    assertThrows(
        IllegalStateException.class,
        () -> {
          MethodDefinition.builder()
              .setName("close")
              .setScope(ScopeNode.PUBLIC)
              .setReturnType(TypeNode.VOID)
              .setBody(Arrays.asList(ExprStatement.withExpr(createAssignmentExpr())))
              .setThrowsExceptions(
                  Arrays.asList(TypeNode.withExceptionClazz(IllegalArgumentException.class)))
              .build();
        });
  }

  @Test
  void invalidMethodDefinition_abstractStatic() {
    assertThrows(
        IllegalStateException.class,
        () -> {
          MethodDefinition.builder()
              .setName("close")
              .setIsAbstract(true)
              .setIsStatic(true)
              .setScope(ScopeNode.PUBLIC)
              .setReturnType(TypeNode.VOID)
              .build();
        });
  }

  @Test
  void invalidMethodDefinition_localScope() {
    assertThrows(
        IllegalStateException.class,
        () -> {
          MethodDefinition.builder()
              .setName("close")
              .setScope(ScopeNode.LOCAL)
              .setReturnType(TypeNode.VOID)
              .build();
        });
  }

  @Test
  void invalidMethodDefinition_constructorOverride() {
    TypeNode returnType =
        TypeNode.withReference(
            VaporReference.builder()
                .setName("LibrarySettings")
                .setPakkage("com.google.example.library.v1")
                .build());
    assertThrows(
        IllegalStateException.class,
        () -> {
          MethodDefinition.constructorBuilder()
              .setScope(ScopeNode.PUBLIC)
              .setReturnType(returnType)
              .setIsOverride(true)
              .build();
        });
  }

  @Test
  void invalidMethodDefinition_constructorFinalOrStatic() {
    TypeNode returnType =
        TypeNode.withReference(
            VaporReference.builder()
                .setName("LibrarySettings")
                .setPakkage("com.google.example.library.v1")
                .build());
    assertThrows(
        IllegalStateException.class,
        () -> {
          MethodDefinition.constructorBuilder()
              .setScope(ScopeNode.PUBLIC)
              .setReturnType(returnType)
              .setIsStatic(true)
              .build();
        });
    assertThrows(
        IllegalStateException.class,
        () -> {
          MethodDefinition.constructorBuilder()
              .setScope(ScopeNode.PUBLIC)
              .setReturnType(returnType)
              .setIsFinal(true)
              .build();
        });
  }

  @Test
  void invalidMethodDefinition_constructorHasReturnExpr() {
    TypeNode returnType =
        TypeNode.withReference(
            VaporReference.builder()
                .setName("LibrarySettings")
                .setPakkage("com.google.example.library.v1")
                .build());
    MethodInvocationExpr methodExpr =
        MethodInvocationExpr.builder().setMethodName("getFoobar").setReturnType(returnType).build();

    assertThrows(
        IllegalStateException.class,
        () -> {
          MethodDefinition.constructorBuilder()
              .setScope(ScopeNode.PUBLIC)
              .setReturnType(returnType)
              .setReturnExpr(methodExpr)
              .setIsOverride(true)
              .build();
        });
  }

  @Test
  void invalidMethodDefinition_objectPrimitiveTypeMismatch() {
    Value value = PrimitiveValue.builder().setType(TypeNode.INT).setValue("3").build();
    ValueExpr valueExpr = ValueExpr.builder().setValue(value).build();

    assertThrows(
        IllegalStateException.class,
        () -> {
          MethodDefinition.builder()
              .setName("foobar")
              .setScope(ScopeNode.PUBLIC)
              .setReturnType(TypeNode.STRING)
              .setBody(Arrays.asList(ExprStatement.withExpr(createAssignmentExpr())))
              .setReturnExpr(valueExpr)
              .build();
        });
  }

  @Test
  void invalidMethodDefinition_mismatchedTypes() {
    Reference stringRef = ConcreteReference.withClazz(String.class);
    TypeNode returnType =
        TypeNode.withReference(
            ConcreteReference.builder()
                .setClazz(List.class)
                .setGenerics(Arrays.asList(stringRef))
                .build());

    MethodInvocationExpr methodExpr =
        MethodInvocationExpr.builder()
            .setMethodName("getSomeList")
            .setReturnType(TypeNode.STRING)
            .build();

    assertThrows(
        IllegalStateException.class,
        () -> {
          MethodDefinition.builder()
              .setName("getAList")
              .setScope(ScopeNode.PUBLIC)
              .setReturnType(returnType)
              .setBody(Arrays.asList(ExprStatement.withExpr(createAssignmentExpr())))
              .setReturnExpr(methodExpr)
              .build();
        });
  }

  @Test
  void invalidMethodDefinition_abstractFinal() {
    assertThrows(
        IllegalStateException.class,
        () -> {
          MethodDefinition.builder()
              .setName("close")
              .setIsAbstract(true)
              .setIsFinal(true)
              .setScope(ScopeNode.PUBLIC)
              .setReturnType(TypeNode.VOID)
              .build();
        });
  }

  @Test
  void invalidMethodDefinition_abstractPrivate() {
    assertThrows(
        IllegalStateException.class,
        () -> {
          MethodDefinition.builder()
              .setName("close")
              .setIsAbstract(true)
              .setScope(ScopeNode.PRIVATE)
              .setReturnType(TypeNode.VOID)
              .build();
        });
  }

  @Test
  void invalidMethodDefinition_invalidException() {
    assertThrows(
        IllegalStateException.class,
        () -> {
          MethodDefinition.builder()
              .setName("close")
              .setScope(ScopeNode.PUBLIC)
              .setReturnType(TypeNode.VOID)
              .setBody(Arrays.asList(ExprStatement.withExpr(createAssignmentExpr())))
              .setThrowsExceptions(Arrays.asList(TypeNode.STRING))
              .build();
        });
  }

  @Test
  void invalidMethodDefinition_missingNonVoidReturnType() {
    assertThrows(
        NullPointerException.class,
        () -> {
          MethodDefinition.builder()
              .setName("close")
              .setScope(ScopeNode.PUBLIC)
              .setReturnType(TypeNode.INT)
              .setBody(Arrays.asList(ExprStatement.withExpr(createAssignmentExpr())))
              .build();
        });
  }

  @Test
  void invalidMethodDefinition_mismatchedPrimitiveReturnType() {
    ValueExpr booleanValueExpr =
        ValueExpr.builder()
            .setValue(PrimitiveValue.builder().setType(TypeNode.BOOLEAN).setValue("false").build())
            .build();
    assertThrows(
        IllegalStateException.class,
        () -> {
          MethodDefinition.builder()
              .setName("close")
              .setScope(ScopeNode.PUBLIC)
              .setReturnType(TypeNode.INT)
              .setReturnExpr(booleanValueExpr)
              .setBody(Arrays.asList(ExprStatement.withExpr(createAssignmentExpr())))
              .build();
        });
  }

  @Test
  void invalidMethodDefinition_mismatchedObjectReturnType() {
    assertThrows(
        IllegalStateException.class,
        () -> {
          MethodDefinition.builder()
              .setName("close")
              .setScope(ScopeNode.PUBLIC)
              .setReturnType(TypeNode.INT_OBJECT)
              .setBody(Arrays.asList(ExprStatement.withExpr(createAssignmentExpr())))
              .setReturnExpr(
                  MethodInvocationExpr.builder()
                      .setMethodName("foobar")
                      .setReturnType(TypeNode.STRING)
                      .build())
              .build();
        });
  }

  @Test
  void invalidMethodDefinition_mismatchedPrimitiveToObjectReturnType() {
    assertThrows(
        IllegalStateException.class,
        () -> {
          MethodDefinition.builder()
              .setName("close")
              .setScope(ScopeNode.PUBLIC)
              .setReturnType(TypeNode.INT)
              .setBody(Arrays.asList(ExprStatement.withExpr(createAssignmentExpr())))
              .setReturnExpr(
                  MethodInvocationExpr.builder()
                      .setMethodName("foobar")
                      .setReturnType(TypeNode.STRING)
                      .build())
              .build();
        });
  }

  @Test
  void invalidMethodDefinition_repeatedArgumentName() {
    ValueExpr returnValueExpr =
        ValueExpr.builder()
            .setValue(PrimitiveValue.builder().setType(TypeNode.INT).setValue("3").build())
            .build();
    List<VariableExpr> arguments =
        Arrays.asList(
            VariableExpr.builder().setVariable(createVariable("x", TypeNode.INT)).build(),
            VariableExpr.builder().setVariable(createVariable("x", TypeNode.STRING)).build());
    assertThrows(
        IllegalStateException.class,
        () -> {
          MethodDefinition.builder()
              .setName("close")
              .setScope(ScopeNode.PUBLIC)
              .setReturnType(TypeNode.INT)
              .setArguments(arguments)
              .setReturnExpr(returnValueExpr)
              .setBody(Arrays.asList(ExprStatement.withExpr(createAssignmentExpr())))
              .build();
        });
  }

  @Test
  void invalidMethodDefinition_nonDeclArguments() {
    ValueExpr returnValueExpr =
        ValueExpr.builder()
            .setValue(PrimitiveValue.builder().setType(TypeNode.INT).setValue("3").build())
            .build();
    List<VariableExpr> arguments =
        Arrays.asList(
            VariableExpr.builder().setVariable(createVariable("x", TypeNode.INT)).build(),
            VariableExpr.builder().setVariable(createVariable("y", TypeNode.INT)).build());
    assertThrows(
        IllegalStateException.class,
        () -> {
          MethodDefinition.builder()
              .setName("close")
              .setScope(ScopeNode.PUBLIC)
              .setReturnType(TypeNode.INT)
              .setArguments(arguments)
              .setReturnExpr(returnValueExpr)
              .setBody(Arrays.asList(ExprStatement.withExpr(createAssignmentExpr())))
              .build();
        });
  }

  @Test
  void invalidMethodDefinition_argumentsWithModifiers() {
    ValueExpr returnValueExpr =
        ValueExpr.builder()
            .setValue(PrimitiveValue.builder().setType(TypeNode.INT).setValue("3").build())
            .build();
    List<VariableExpr> arguments =
        Arrays.asList(
            VariableExpr.builder()
                .setVariable(createVariable("x", TypeNode.INT))
                .setIsDecl(true)
                .setIsStatic(true)
                .build(),
            VariableExpr.builder().setVariable(createVariable("y", TypeNode.INT)).build());
    assertThrows(
        IllegalStateException.class,
        () -> {
          MethodDefinition.builder()
              .setName("close")
              .setScope(ScopeNode.PUBLIC)
              .setReturnType(TypeNode.INT)
              .setArguments(arguments)
              .setReturnExpr(returnValueExpr)
              .build();
        });
  }

  @Test
  void invalidMethodDefinition_argumentsWithScope() {
    ValueExpr returnValueExpr =
        ValueExpr.builder()
            .setValue(PrimitiveValue.builder().setType(TypeNode.INT).setValue("3").build())
            .build();
    List<VariableExpr> arguments =
        Arrays.asList(
            VariableExpr.builder().setVariable(createVariable("x", TypeNode.INT)).build(),
            VariableExpr.builder()
                .setVariable(createVariable("y", TypeNode.INT))
                .setScope(ScopeNode.PRIVATE)
                .build());
    assertThrows(
        IllegalStateException.class,
        () -> {
          MethodDefinition.builder()
              .setName("close")
              .setScope(ScopeNode.PUBLIC)
              .setReturnType(TypeNode.INT)
              .setArguments(arguments)
              .setReturnExpr(returnValueExpr)
              .build();
        });
  }

  @Test
  void invalidMethodDefinition_nullReturnType() {
    assertThrows(
        IllegalStateException.class,
        () -> {
          MethodDefinition.builder()
              .setName("foobar")
              .setScope(ScopeNode.PUBLIC)
              .setReturnType(TypeNode.NULL)
              .build();
        });
  }

  @Test
  void invalidMethodDefinition_missingReturnType() {
    assertThrows(
        NullPointerException.class,
        () -> {
          MethodDefinition.builder()
              .setName("foobar")
              .setScope(ScopeNode.PUBLIC)
              .setReturnType(TypeNode.STRING)
              .build();
        });
  }

  private static Variable createVariable(String variableName, TypeNode type) {
    return Variable.builder().setName(variableName).setType(type).build();
  }

  private static AssignmentExpr createAssignmentExpr() {
    Variable variable = createVariable("x", TypeNode.INT);
    VariableExpr variableExpr =
        VariableExpr.builder().setVariable(variable).setIsDecl(true).build();

    Variable anotherVariable = createVariable("y", TypeNode.INT);
    Expr valueExpr = VariableExpr.builder().setVariable(anotherVariable).build();

    return AssignmentExpr.builder().setVariableExpr(variableExpr).setValueExpr(valueExpr).build();
  }

  private static List<CommentStatement> createCommentStatements() {
    JavaDocComment javaDocComment =
        JavaDocComment.builder()
            .addComment("Constructs an instance of GrpcMyProtoStub, using the given settings.")
            .addComment(
                "This is protected so that it is easy to make a subclass, but otherwise, the"
                    + " static factory methods should be preferred.")
            .build();
    return Arrays.asList(CommentStatement.withComment(javaDocComment));
  }
}
