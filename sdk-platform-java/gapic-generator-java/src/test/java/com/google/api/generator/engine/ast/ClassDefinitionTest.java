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

import static org.junit.Assert.assertThrows;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class ClassDefinitionTest {

  @Test
  void validClassDefinition_basicWithCommentsAndHeader() {
    LineComment lineComment = LineComment.withComment("AUTO-GENERATED DOCUMENTATION AND CLASS");
    JavaDocComment javaDocComment =
        JavaDocComment.builder()
            .addComment("Base stub class for Google Example Library API.")
            .addParagraph(
                "This class is for advanced usage and reflects the underlying API directly.")
            .build();
    ClassDefinition.builder()
        .setFileHeader(createFileHeader())
        .setHeaderCommentStatements(
            Arrays.asList(
                CommentStatement.withComment(lineComment),
                CommentStatement.withComment(javaDocComment)))
        .setPackageString("com.google.example.library.v1.stub")
        .setName("LibraryServiceStub")
        .setScope(ScopeNode.PUBLIC)
        .build();
    // No exception thrown, we're good.
  }

  @Test
  void validClassDefinition_exprCommentAndBlockStatements() {
    ClassDefinition.builder()
        .setName("LibraryServiceStub")
        .setIsNested(true)
        .setScope(ScopeNode.PUBLIC)
        .setStatements(
            Arrays.asList(
                BlockStatement.builder().setIsStatic(true).build(),
                CommentStatement.withComment(LineComment.withComment("Test line comment.")),
                ExprStatement.withExpr(
                    AssignmentExpr.builder()
                        .setVariableExpr(
                            VariableExpr.builder()
                                .setIsDecl(true)
                                .setScope(ScopeNode.PRIVATE)
                                .setVariable(
                                    Variable.builder().setType(TypeNode.INT).setName("x").build())
                                .build())
                        .setValueExpr(
                            MethodInvocationExpr.builder()
                                .setMethodName("foobar")
                                .setReturnType(TypeNode.INT)
                                .build())
                        .build())))
        .build();
    // No exception thrown, we're good.
  }

  @Test
  void validClassDefinition_nestedBasic() {
    ClassDefinition.builder()
        .setName("LibraryServiceStub")
        .setIsNested(true)
        .setScope(ScopeNode.PUBLIC)
        .build();
    // No exception thrown, we're good.

    ClassDefinition.builder()
        .setPackageString("com.google.example.library.v1.stub")
        .setName("LibraryServiceStub")
        .setIsNested(true)
        .setScope(ScopeNode.PUBLIC)
        .build();
    // Weird but still fine.
  }

  @Test
  void validClassDefinition_withAnnotationsExtendsAndImplements() {
    ClassDefinition.builder()
        .setPackageString("com.google.example.library.v1.stub")
        .setName("LibraryServiceStub")
        .setScope(ScopeNode.PUBLIC)
        .setIsAbstract(true)
        .setAnnotations(
            Arrays.asList(AnnotationNode.DEPRECATED, AnnotationNode.withSuppressWarnings("all")))
        .setExtendsType(TypeNode.STRING)
        .setImplementsTypes(
            Arrays.asList(
                TypeNode.withReference(ConcreteReference.withClazz(Cloneable.class)),
                TypeNode.withReference(ConcreteReference.withClazz(Readable.class))))
        .build();
    // No exception thrown, we're good.
  }

  @Test
  void validClassDefinition_statementsAndMethods() {
    List<Statement> statements =
        Arrays.asList(
            ExprStatement.withExpr(createAssignmentExpr()),
            ExprStatement.withExpr(
                VariableExpr.builder()
                    .setVariable(createVariable("x", TypeNode.INT))
                    .setIsDecl(true)
                    .setScope(ScopeNode.PRIVATE)
                    .build()),
            ExprStatement.withExpr(
                VariableExpr.builder()
                    .setVariable(createVariable("y", TypeNode.INT))
                    .setIsDecl(true)
                    .setScope(ScopeNode.PROTECTED)
                    .build()));

    MethodDefinition method =
        MethodDefinition.builder()
            .setName("close")
            .setScope(ScopeNode.PUBLIC)
            .setReturnType(TypeNode.VOID)
            .setBody(Arrays.asList(ExprStatement.withExpr(createAssignmentExpr(false))))
            .build();

    List<MethodDefinition> methods = Arrays.asList(method, method);

    ClassDefinition.builder()
        .setPackageString("com.google.example.library.v1.stub")
        .setName("LibraryServiceStub")
        .setIsFinal(true)
        .setScope(ScopeNode.PUBLIC)
        .setStatements(statements)
        .setMethods(methods)
        .build();
    // No exception thrown, we're good.
  }

  @Test
  void invalidClassDefinition_nestedWithFileHeader() {
    assertThrows(
        IllegalStateException.class,
        () -> {
          ClassDefinition.builder()
              .setPackageString("com.google.example.library.v1.stub")
              .setName("LibraryServiceStub")
              .setIsNested(true)
              .setScope(ScopeNode.PUBLIC)
              .setFileHeader(createFileHeader())
              .build();
        });
  }

  @Test
  void invalidClassDefinition_implementsNullType() {
    assertThrows(
        IllegalStateException.class,
        () -> {
          ClassDefinition.builder()
              .setPackageString("com.google.example.library.v1.stub")
              .setName("LibraryServiceStub")
              .setScope(ScopeNode.PUBLIC)
              .setImplementsTypes(Arrays.asList(TypeNode.NULL))
              .build();
        });
  }

  @Test
  void invalidClassDefinition_outerClassMissingPackage() {
    assertThrows(
        NullPointerException.class,
        () -> {
          ClassDefinition.builder()
              .setName("LibraryServiceStub")
              .setScope(ScopeNode.PUBLIC)
              .build();
        });
  }

  @Test
  void invalidClassDefinition_outerClassStatic() {
    assertThrows(
        IllegalStateException.class,
        () -> {
          ClassDefinition.builder()
              .setPackageString("com.google.example.library.v1.stub")
              .setName("LibraryServiceStub")
              .setIsStatic(true)
              .setScope(ScopeNode.PUBLIC)
              .build();
        });
  }

  @Test
  void invalidClassDefinition_outerClassPrivate() {
    assertThrows(
        IllegalStateException.class,
        () -> {
          ClassDefinition.builder()
              .setPackageString("com.google.example.library.v1.stub")
              .setName("LibraryServiceStub")
              .setScope(ScopeNode.PRIVATE)
              .build();
        });
  }

  @Test
  void invalidClassDefinition_extendsPrimitiveType() {
    assertThrows(
        IllegalStateException.class,
        () -> {
          ClassDefinition.builder()
              .setPackageString("com.google.example.library.v1.stub")
              .setName("LibraryServiceStub")
              .setScope(ScopeNode.PUBLIC)
              .setExtendsType(TypeNode.INT)
              .build();
        });
  }

  @Test
  void invalidClassDefinition_extendsNullType() {
    assertThrows(
        IllegalStateException.class,
        () -> {
          ClassDefinition.builder()
              .setPackageString("com.google.example.library.v1.stub")
              .setName("LibraryServiceStub")
              .setScope(ScopeNode.PUBLIC)
              .setExtendsType(TypeNode.NULL)
              .build();
        });
  }

  @Test
  void invalidClassDefinition_abstractFinal() {
    assertThrows(
        IllegalStateException.class,
        () -> {
          ClassDefinition.builder()
              .setPackageString("com.google.example.library.v1.stub")
              .setName("LibraryServiceStub")
              .setIsAbstract(true)
              .setIsFinal(true)
              .setScope(ScopeNode.PUBLIC)
              .setImplementsTypes(Arrays.asList(TypeNode.INT))
              .build();
        });
  }

  @Test
  void invalidClassDefinition_implementsPrimtiveType() {
    assertThrows(
        IllegalStateException.class,
        () -> {
          ClassDefinition.builder()
              .setPackageString("com.google.example.library.v1.stub")
              .setName("LibraryServiceStub")
              .setScope(ScopeNode.PUBLIC)
              .setImplementsTypes(Arrays.asList(TypeNode.INT))
              .build();
        });
  }

  @Test
  void invalidClassDefinition_extendsImplementsSameType() {
    TypeNode cloneableType = TypeNode.withReference(ConcreteReference.withClazz(Cloneable.class));
    assertThrows(
        IllegalStateException.class,
        () -> {
          ClassDefinition.builder()
              .setPackageString("com.google.example.library.v1.stub")
              .setName("LibraryServiceStub")
              .setScope(ScopeNode.PUBLIC)
              .setExtendsType(cloneableType)
              .setImplementsTypes(
                  Arrays.asList(
                      TypeNode.withReference(ConcreteReference.withClazz(Readable.class)),
                      cloneableType))
              .build();
        });
  }

  @Test
  void invalidClassDefinition_assignmentWithUnscopedVariableExprStatement() {
    Variable variable = createVariable("x", TypeNode.INT);
    VariableExpr variableExpr =
        VariableExpr.builder().setVariable(variable).setIsDecl(true).build();

    Variable anotherVariable = createVariable("y", TypeNode.INT);
    Expr valueExpr = VariableExpr.builder().setVariable(anotherVariable).build();

    AssignmentExpr assignmentExpr =
        AssignmentExpr.builder().setVariableExpr(variableExpr).setValueExpr(valueExpr).build();

    List<Statement> statements = Arrays.asList(ExprStatement.withExpr(assignmentExpr));
    assertThrows(
        IllegalStateException.class,
        () -> {
          ClassDefinition.builder()
              .setPackageString("com.google.example.library.v1.stub")
              .setName("LibraryServiceStub")
              .setScope(ScopeNode.PUBLIC)
              .setStatements(statements)
              .build();
        });
  }

  @Test
  void invalidClassDefinition_unscopedVariableExprStatement() {
    List<Statement> statements =
        Arrays.asList(
            ExprStatement.withExpr(createAssignmentExpr()),
            ExprStatement.withExpr(
                VariableExpr.builder()
                    .setVariable(createVariable("x", TypeNode.INT))
                    .setIsDecl(true)
                    .build()));
    assertThrows(
        IllegalStateException.class,
        () -> {
          ClassDefinition.builder()
              .setPackageString("com.google.example.library.v1.stub")
              .setName("LibraryServiceStub")
              .setScope(ScopeNode.PUBLIC)
              .setStatements(statements)
              .build();
        });
  }

  @Test
  void invalidClassDefinition_badStatementType() {
    List<Statement> statements = Arrays.asList(createForStatement());
    assertThrows(
        IllegalStateException.class,
        () -> {
          ClassDefinition.builder()
              .setPackageString("com.google.example.library.v1.stub")
              .setName("LibraryServiceStub")
              .setScope(ScopeNode.PUBLIC)
              .setStatements(statements)
              .build();
        });
  }

  private static Variable createVariable(String variableName, TypeNode type) {
    return Variable.builder().setName(variableName).setType(type).build();
  }

  private static AssignmentExpr createAssignmentExpr() {
    return createAssignmentExpr(true);
  }

  private static AssignmentExpr createAssignmentExpr(boolean scoped) {
    Variable variable = createVariable("x", TypeNode.INT);
    VariableExpr variableExpr =
        VariableExpr.builder()
            .setVariable(variable)
            .setIsDecl(true)
            .setScope(scoped ? ScopeNode.PRIVATE : ScopeNode.LOCAL)
            .build();

    Variable anotherVariable = createVariable("y", TypeNode.INT);
    Expr valueExpr = VariableExpr.builder().setVariable(anotherVariable).build();

    return AssignmentExpr.builder().setVariableExpr(variableExpr).setValueExpr(valueExpr).build();
  }

  private static ForStatement createForStatement() {
    Variable variable = createVariable("str", TypeNode.STRING);
    VariableExpr variableExpr =
        VariableExpr.builder().setVariable(variable).setIsDecl(true).build();

    MethodInvocationExpr methodExpr =
        MethodInvocationExpr.builder().setMethodName("getSomeStrings").build();

    return ForStatement.builder()
        .setLocalVariableExpr(variableExpr)
        .setCollectionExpr(methodExpr)
        .setBody(Arrays.asList(ExprStatement.withExpr(createAssignmentExpr())))
        .build();
  }

  // Create a simple block comment to stand for the Apache License header.
  private static List<CommentStatement> createFileHeader() {
    return Arrays.asList(CommentStatement.withComment(BlockComment.withComment("Apache License")));
  }
}
