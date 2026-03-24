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

package com.google.api.generator.engine.writer;

import com.google.api.generator.engine.ast.AnnotationNode;
import com.google.api.generator.engine.ast.AnonymousClassExpr;
import com.google.api.generator.engine.ast.ArithmeticOperationExpr;
import com.google.api.generator.engine.ast.ArrayExpr;
import com.google.api.generator.engine.ast.AssignmentExpr;
import com.google.api.generator.engine.ast.AssignmentOperationExpr;
import com.google.api.generator.engine.ast.AstNodeVisitor;
import com.google.api.generator.engine.ast.BlockComment;
import com.google.api.generator.engine.ast.BlockStatement;
import com.google.api.generator.engine.ast.BreakStatement;
import com.google.api.generator.engine.ast.CastExpr;
import com.google.api.generator.engine.ast.ClassDefinition;
import com.google.api.generator.engine.ast.CommentStatement;
import com.google.api.generator.engine.ast.ConcreteReference;
import com.google.api.generator.engine.ast.EmptyLineStatement;
import com.google.api.generator.engine.ast.EnumRefExpr;
import com.google.api.generator.engine.ast.Expr;
import com.google.api.generator.engine.ast.ExprStatement;
import com.google.api.generator.engine.ast.ForStatement;
import com.google.api.generator.engine.ast.GeneralForStatement;
import com.google.api.generator.engine.ast.IdentifierNode;
import com.google.api.generator.engine.ast.IfStatement;
import com.google.api.generator.engine.ast.InstanceofExpr;
import com.google.api.generator.engine.ast.JavaDocComment;
import com.google.api.generator.engine.ast.LambdaExpr;
import com.google.api.generator.engine.ast.LineComment;
import com.google.api.generator.engine.ast.LogicalOperationExpr;
import com.google.api.generator.engine.ast.MethodDefinition;
import com.google.api.generator.engine.ast.MethodInvocationExpr;
import com.google.api.generator.engine.ast.NewObjectExpr;
import com.google.api.generator.engine.ast.OperatorKind;
import com.google.api.generator.engine.ast.PackageInfoDefinition;
import com.google.api.generator.engine.ast.Reference;
import com.google.api.generator.engine.ast.ReferenceConstructorExpr;
import com.google.api.generator.engine.ast.RelationalOperationExpr;
import com.google.api.generator.engine.ast.ReturnExpr;
import com.google.api.generator.engine.ast.ScopeNode;
import com.google.api.generator.engine.ast.Statement;
import com.google.api.generator.engine.ast.SynchronizedStatement;
import com.google.api.generator.engine.ast.TernaryExpr;
import com.google.api.generator.engine.ast.ThrowExpr;
import com.google.api.generator.engine.ast.TryCatchStatement;
import com.google.api.generator.engine.ast.TypeNode;
import com.google.api.generator.engine.ast.TypeNode.TypeKind;
import com.google.api.generator.engine.ast.UnaryOperationExpr;
import com.google.api.generator.engine.ast.ValueExpr;
import com.google.api.generator.engine.ast.VaporReference;
import com.google.api.generator.engine.ast.Variable;
import com.google.api.generator.engine.ast.VariableExpr;
import com.google.api.generator.engine.ast.WhileStatement;
import com.google.api.generator.gapic.model.RegionTag;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class JavaWriterVisitor implements AstNodeVisitor {
  private static final String SPACE = " ";
  private static final String NEWLINE = "\n";

  private static final String AT = "@";

  private static final String COLON = ":";
  private static final String COMMA = ",";
  private static final String BLOCK_COMMENT_START = "/*";
  private static final String BLOCK_COMMENT_END = "*/";
  private static final String DOT = ".";
  private static final String EQUALS = "=";
  private static final String LEFT_ANGLE = "<";
  private static final String LEFT_BRACE = "{";
  private static final String LEFT_PAREN = "(";
  private static final String JAVADOC_COMMENT_START = "/**";
  private static final String QUESTION_MARK = "?";
  private static final String RIGHT_ANGLE = ">";
  private static final String RIGHT_BRACE = "}";
  private static final String RIGHT_PAREN = ")";
  private static final String SEMICOLON = ";";
  private static final String ASTERISK = "*";

  private static final String ABSTRACT = "abstract";
  private static final String CATCH = "catch";
  private static final String CLASS = "class";
  private static final String ELSE = "else";
  private static final String EXTENDS = "extends";
  private static final String FINAL = "final";
  private static final String FOR = "for";
  private static final String IF = "if";
  private static final String INSTANCEOF = "instanceof";
  private static final String IMPLEMENTS = "implements";
  private static final String NEW = "new";
  private static final String RETURN = "return";
  private static final String SYNCHRONIZED = "synchronized";
  private static final String STATIC = "static";
  private static final String THROW = "throw";
  private static final String THROWS = "throws";
  private static final String TRY = "try";
  private static final String VOLATILE = "volatile";
  private static final String WHILE = "while";
  private static final String BREAK = "break";

  // Operators
  private static final String OPERATOR_ADDITION = "+";
  private static final String OPERATOR_EQUAL_TO = "==";
  private static final String OPERATOR_NOT_EQUAL_TO = "!=";
  private static final String OPERATOR_LESS_THAN = "<";
  private static final String OPERATOR_INCREMENT = "++";
  private static final String OPERATOR_LOGICAL_NOT = "!";
  private static final String OPERATOR_LOGICAL_AND = "&&";
  private static final String OPERATOR_LOGICAL_OR = "||";
  private static final String OPERATOR_XOR = "^=";
  private static final String OPERATOR_MULTIPLE_AND_ASSIGNMENT = "*=";

  private final StringBuffer buffer = new StringBuffer();
  private final ImportWriterVisitor importWriterVisitor = new ImportWriterVisitor();

  public JavaWriterVisitor() {}

  public void clear() {
    buffer.setLength(0);
    importWriterVisitor.clear();
  }

  public String write() {
    return buffer.toString();
  }

  @Override
  public void visit(IdentifierNode identifier) {
    buffer.append(identifier.name());
  }

  @Override
  public void visit(TypeNode type) {
    TypeKind typeKind = type.typeKind();
    if (type.isPrimitiveType()) {
      buffer.append(typeKind.toString().toLowerCase());
    } else {
      type.reference().accept(this);
    }

    if (type.isArray()) {
      buffer.append("[]");
    }
  }

  @Override
  public void visit(ScopeNode scope) {
    buffer.append(scope.toString());
  }

  @Override
  public void visit(ArrayExpr expr) {
    buffer.append(LEFT_BRACE);
    for (int i = 0; i < expr.exprs().size(); i++) {
      expr.exprs().get(i).accept(this);
      if (i < expr.exprs().size() - 1) {
        buffer.append(COMMA);
        buffer.append(SPACE);
      }
    }
    buffer.append(RIGHT_BRACE);
  }

  @Override
  public void visit(AnnotationNode annotation) {
    buffer.append(AT);
    annotation.type().accept(this);
    if (annotation.descriptionExprs() != null) {
      leftParen();
      for (int i = 0; i < annotation.descriptionExprs().size(); i++) {
        annotation.descriptionExprs().get(i).accept(this);
        if (i < annotation.descriptionExprs().size() - 1) {
          buffer.append(COMMA);
          buffer.append(SPACE);
        }
      }
      rightParen();
    }
    newline();
  }

  @Override
  public void visit(ConcreteReference reference) {
    if (reference.isWildcard()) {
      buffer.append(QUESTION_MARK);
      if (reference.wildcardUpperBound() != null) {
        // Handle the upper bound.
        buffer.append(SPACE);
        buffer.append(EXTENDS);
        buffer.append(SPACE);
        reference.wildcardUpperBound().accept(this);
      }
      return;
    }
    String pakkage = reference.pakkage();
    String shortName = reference.name();
    if (reference.useFullName() || importWriterVisitor.collidesWithImport(pakkage, shortName)) {
      buffer.append(pakkage);
      buffer.append(DOT);
    }

    if (reference.hasEnclosingClass() && !reference.isStaticImport()) {
      buffer.append(String.join(DOT, reference.enclosingClassNames()));
      buffer.append(DOT);
    }

    buffer.append(reference.simpleName());

    if (!reference.generics().isEmpty()) {
      buffer.append(LEFT_ANGLE);
      for (int i = 0; i < reference.generics().size(); i++) {
        Reference r = reference.generics().get(i);
        r.accept(this);
        if (i < reference.generics().size() - 1) {
          buffer.append(COMMA);
          buffer.append(SPACE);
        }
      }
      buffer.append(RIGHT_ANGLE);
    }
  }

  @Override
  public void visit(VaporReference reference) {
    // This implementation should be more extensive, but there are no existing use cases that
    // exercise the edge cases.
    // TODO(miraleung): Give this behavioral parity with ConcreteReference.
    String pakkage = reference.pakkage();
    String shortName = reference.name();

    if (reference.useFullName() || importWriterVisitor.collidesWithImport(pakkage, shortName)) {
      buffer.append(pakkage);
      buffer.append(DOT);
      if (reference.hasEnclosingClass()) {
        buffer.append(String.join(DOT, reference.enclosingClassNames()));
        buffer.append(DOT);
      }
    }

    // A null pointer exception will be thrown if reference is null, which is WAI.
    buffer.append(shortName);
  }

  /** =============================== EXPRESSIONS =============================== */
  @Override
  public void visit(ValueExpr valueExpr) {
    buffer.append(valueExpr.value().value());
  }

  @Override
  public void visit(VariableExpr variableExpr) {
    Variable variable = variableExpr.variable();
    TypeNode type = variable.type();
    ScopeNode scope = variableExpr.scope();

    // VariableExpr will handle isDecl and exprReferenceExpr edge cases.
    if (variableExpr.isDecl()) {
      // Annotations, if any.
      annotations(variableExpr.annotations());

      if (!scope.equals(ScopeNode.LOCAL)) {
        scope.accept(this);
        space();
      }

      if (variableExpr.isStatic()) {
        buffer.append(STATIC);
        space();
      }

      if (variableExpr.isFinal()) {
        buffer.append(FINAL);
        space();
      }

      if (variableExpr.isVolatile()) {
        buffer.append(VOLATILE);
        space();
      }

      type.accept(this);
      if (!variableExpr.templateNodes().isEmpty()) {
        leftAngle();
        IntStream.range(0, variableExpr.templateNodes().size())
            .forEach(
                i -> {
                  variableExpr.templateNodes().get(i).accept(this);
                  if (i < variableExpr.templateNodes().size() - 1) {
                    buffer.append(COMMA);
                    space();
                  }
                });
        rightAngle();
      }
      space();
    } else {
      // Expression or static reference.
      if (variableExpr.exprReferenceExpr() != null) {
        variableExpr.exprReferenceExpr().accept(this);
        buffer.append(DOT);
      } else if (variableExpr.staticReferenceType() != null) {
        variableExpr.staticReferenceType().accept(this);
        buffer.append(DOT);
      }
    }

    variable.identifier().accept(this);
  }

  @Override
  public void visit(TernaryExpr ternaryExpr) {
    ternaryExpr.conditionExpr().accept(this);
    space();
    buffer.append(QUESTION_MARK);
    space();
    ternaryExpr.thenExpr().accept(this);
    space();
    buffer.append(COLON);
    space();
    ternaryExpr.elseExpr().accept(this);
  }

  @Override
  public void visit(AssignmentExpr assignmentExpr) {
    assignmentExpr.variableExpr().accept(this);
    space();
    buffer.append(EQUALS);
    space();
    assignmentExpr.valueExpr().accept(this);
  }

  @Override
  public void visit(MethodInvocationExpr methodInvocationExpr) {
    // Expression or static reference.
    if (methodInvocationExpr.exprReferenceExpr() != null) {
      methodInvocationExpr.exprReferenceExpr().accept(this);
      buffer.append(DOT);
    } else if (methodInvocationExpr.staticReferenceType() != null) {
      methodInvocationExpr.staticReferenceType().accept(this);
      buffer.append(DOT);
    }

    if (methodInvocationExpr.isGeneric()) {
      leftAngle();
      int numGenerics = methodInvocationExpr.generics().size();
      for (int i = 0; i < numGenerics; i++) {
        Reference r = methodInvocationExpr.generics().get(i);
        r.accept(this);
        if (i < numGenerics - 1) {
          buffer.append(COMMA);
          space();
        }
      }
      rightAngle();
    }

    methodInvocationExpr.methodIdentifier().accept(this);
    leftParen();
    int numArguments = methodInvocationExpr.arguments().size();
    for (int i = 0; i < numArguments; i++) {
      Expr argExpr = methodInvocationExpr.arguments().get(i);
      argExpr.accept(this);
      if (i < numArguments - 1) {
        buffer.append(COMMA);
        space();
      }
    }
    rightParen();
  }

  @Override
  public void visit(CastExpr castExpr) {
    leftParen();
    leftParen();
    castExpr.type().accept(this);
    rightParen();
    space();
    castExpr.expr().accept(this);
    rightParen();
  }

  @Override
  public void visit(AnonymousClassExpr anonymousClassExpr) {
    buffer.append(NEW);
    space();
    anonymousClassExpr.type().accept(this);
    leftParen();
    rightParen();
    space();
    leftBrace();
    newline();
    statements(anonymousClassExpr.statements());
    methods(anonymousClassExpr.methods());
    rightBrace();
  }

  @Override
  public void visit(ThrowExpr throwExpr) {
    buffer.append(THROW);
    space();
    // If throwExpr is present, then messageExpr and causeExpr will not be present. Relies on AST
    // build-time checks.
    if (throwExpr.throwExpr() != null) {
      throwExpr.throwExpr().accept(this);
      return;
    }

    buffer.append(NEW);
    space();
    throwExpr.type().accept(this);
    leftParen();
    if (throwExpr.messageExpr() != null) {
      throwExpr.messageExpr().accept(this);
    }
    if (throwExpr.causeExpr() != null) {
      if (throwExpr.messageExpr() != null) {
        buffer.append(COMMA);
        space();
      }
      throwExpr.causeExpr().accept(this);
    }
    rightParen();
  }

  @Override
  public void visit(InstanceofExpr instanceofExpr) {
    instanceofExpr.expr().accept(this);
    space();
    buffer.append(INSTANCEOF);
    space();
    instanceofExpr.checkType().accept(this);
  }

  @Override
  public void visit(NewObjectExpr newObjectExpr) {
    buffer.append(NEW);
    space();
    newObjectExpr.type().accept(this);
    // If isGeneric() is true, but generic list is empty, we will append `<>` to the buffer.
    if (newObjectExpr.isGeneric() && newObjectExpr.type().reference().generics().isEmpty()) {
      leftAngle();
      rightAngle();
    }
    leftParen();
    int numArguments = newObjectExpr.arguments().size();
    for (int i = 0; i < numArguments; i++) {
      newObjectExpr.arguments().get(i).accept(this);
      if (i < numArguments - 1) {
        buffer.append(COMMA);
        space();
      }
    }
    rightParen();
  }

  @Override
  public void visit(EnumRefExpr enumRefExpr) {
    enumRefExpr.type().accept(this);
    buffer.append(DOT);
    enumRefExpr.identifier().accept(this);
  }

  @Override
  public void visit(ReturnExpr returnExpr) {
    buffer.append(RETURN);
    space();
    returnExpr.expr().accept(this);
  }

  @Override
  public void visit(ReferenceConstructorExpr referenceConstructorExpr) {
    buffer.append(referenceConstructorExpr.keywordKind().name().toLowerCase());
    leftParen();
    IntStream.range(0, referenceConstructorExpr.arguments().size())
        .forEach(
            i -> {
              referenceConstructorExpr.arguments().get(i).accept(this);
              if (i < referenceConstructorExpr.arguments().size() - 1) {
                buffer.append(COMMA);
                space();
              }
            });
    rightParen();
  }

  @Override
  public void visit(ArithmeticOperationExpr arithmeticOperationExpr) {
    arithmeticOperationExpr.lhsExpr().accept(this);
    space();
    operator(arithmeticOperationExpr.operatorKind());
    space();
    arithmeticOperationExpr.rhsExpr().accept(this);
  }

  @Override
  public void visit(UnaryOperationExpr unaryOperationExpr) {
    if (unaryOperationExpr.operatorKind().isPrefixOperator()) {
      operator(unaryOperationExpr.operatorKind());
      unaryOperationExpr.expr().accept(this);
    } else {
      unaryOperationExpr.expr().accept(this);
      operator(unaryOperationExpr.operatorKind());
    }
  }

  @Override
  public void visit(RelationalOperationExpr relationalOperationExpr) {
    relationalOperationExpr.lhsExpr().accept(this);
    space();
    operator(relationalOperationExpr.operatorKind());
    space();
    relationalOperationExpr.rhsExpr().accept(this);
  }

  @Override
  public void visit(LogicalOperationExpr logicalOperationExpr) {
    logicalOperationExpr.lhsExpr().accept(this);
    space();
    operator(logicalOperationExpr.operatorKind());
    space();
    logicalOperationExpr.rhsExpr().accept(this);
  }

  @Override
  public void visit(AssignmentOperationExpr assignmentOperationExpr) {
    assignmentOperationExpr.variableExpr().accept(this);
    space();
    operator(assignmentOperationExpr.operatorKind());
    space();
    assignmentOperationExpr.valueExpr().accept(this);
  }

  @Override
  public void visit(LambdaExpr lambdaExpr) {
    if (lambdaExpr.arguments().isEmpty()) {
      leftParen();
      rightParen();
    } else if (lambdaExpr.arguments().size() == 1) {
      // Print just the variable.
      lambdaExpr.arguments().get(0).variable().identifier().accept(this);
    } else {
      // Stylistic choice - print the types and variable names for clarity.
      leftParen();
      int numArguments = lambdaExpr.arguments().size();
      for (int i = 0; i < numArguments; i++) {
        lambdaExpr.arguments().get(i).accept(this);
        if (i < numArguments - 1) {
          buffer.append(COMMA);
          space();
        }
      }
      rightParen();
    }

    space();
    buffer.append("->");
    space();

    if (lambdaExpr.body().isEmpty()) {
      // Just the return expression - don't render "return".
      lambdaExpr.returnExpr().expr().accept(this);
      return;
    }

    leftBrace();
    newline();
    statements(lambdaExpr.body());
    ExprStatement.withExpr(lambdaExpr.returnExpr()).accept(this);
    rightBrace();
  }

  /** =============================== STATEMENTS =============================== */
  @Override
  public void visit(ExprStatement exprStatement) {
    exprStatement.expression().accept(this);
    semicolon();
    newline();
  }

  @Override
  public void visit(BlockStatement blockStatement) {
    if (blockStatement.isStatic()) {
      buffer.append(STATIC);
      space();
    }
    leftBrace();
    newline();
    statements(blockStatement.body());
    rightBrace();
    newline();
  }

  @Override
  public void visit(IfStatement ifStatement) {
    buffer.append(IF);
    space();
    leftParen();

    ifStatement.conditionExpr().accept(this);
    rightParen();
    space();
    leftBrace();
    newline();

    statements(ifStatement.body());
    buffer.append(RIGHT_BRACE);
    if (!ifStatement.elseIfs().isEmpty()) {
      for (Map.Entry<Expr, List<Statement>> elseIfEntry : ifStatement.elseIfs().entrySet()) {
        Expr elseIfConditionExpr = elseIfEntry.getKey();
        List<Statement> elseIfBody = elseIfEntry.getValue();
        space();
        buffer.append(ELSE);
        space();
        buffer.append(IF);
        space();
        leftParen();
        elseIfConditionExpr.accept(this);
        rightParen();
        space();
        leftBrace();
        newline();
        statements(elseIfBody);
        rightBrace();
      }
    }
    if (!ifStatement.elseBody().isEmpty()) {
      space();
      buffer.append(ELSE);
      space();
      leftBrace();
      newline();
      statements(ifStatement.elseBody());
      rightBrace();
    }
    newline();
  }

  @Override
  public void visit(ForStatement forStatement) {
    buffer.append(FOR);
    space();
    leftParen();
    forStatement.localVariableExpr().accept(this);
    space();
    buffer.append(COLON);
    space();
    forStatement.collectionExpr().accept(this);
    rightParen();
    space();
    leftBrace();
    newline();
    statements(forStatement.body());
    rightBrace();
    newline();
  }

  @Override
  public void visit(GeneralForStatement generalForStatement) {
    buffer.append(FOR);
    space();
    leftParen();
    generalForStatement.initializationExpr().accept(this);
    semicolon();
    space();

    generalForStatement.terminationExpr().accept(this);
    semicolon();
    space();

    generalForStatement.updateExpr().accept(this);
    rightParen();
    space();
    leftBrace();
    newline();

    statements(generalForStatement.body());
    rightBrace();
    newline();
  }

  @Override
  public void visit(WhileStatement whileStatement) {
    buffer.append(WHILE);
    space();
    leftParen();
    whileStatement.conditionExpr().accept(this);
    rightParen();
    space();
    leftBrace();
    newline();
    statements(whileStatement.body());
    rightBrace();
    newline();
  }

  @Override
  public void visit(TryCatchStatement tryCatchStatement) {
    buffer.append(TRY);
    space();
    if (tryCatchStatement.tryResourceExpr() != null) {
      leftParen();
      tryCatchStatement.tryResourceExpr().accept(this);
      rightParen();
      space();
    }
    leftBrace();
    newline();

    statements(tryCatchStatement.tryBody());
    rightBrace();

    for (int i = 0; i < tryCatchStatement.catchVariableExprs().size(); i++) {
      space();
      buffer.append(CATCH);
      space();
      leftParen();
      tryCatchStatement.catchVariableExprs().get(i).accept(this);
      rightParen();
      space();
      leftBrace();
      newline();
      statements(tryCatchStatement.catchBlocks().get(i));
      rightBrace();
    }
    newline();
  }

  @Override
  public void visit(SynchronizedStatement synchronizedStatement) {
    buffer.append(SYNCHRONIZED);
    space();
    leftParen();
    synchronizedStatement.lock().accept(this);
    rightParen();
    space();
    leftBrace();
    newline();
    statements(synchronizedStatement.body());
    rightBrace();
    newline();
  }

  @Override
  public void visit(CommentStatement commentStatement) {
    commentStatement.comment().accept(this);
  }

  @Override
  public void visit(EmptyLineStatement emptyLineStatement) {
    newline();
  }

  @Override
  public void visit(BreakStatement breakStatement) {
    buffer.append(BREAK);
    semicolon();
  }

  /** =============================== COMMENT =============================== */
  @Override
  public void visit(LineComment lineComment) {
    // Split comments by new line and add `//` to each line.
    String formattedSource =
        JavaFormatter.format(
            String.format("// %s", String.join("\n//", lineComment.comment().split("\\r?\\n"))));
    buffer.append(formattedSource);
  }

  @Override
  public void visit(BlockComment blockComment) {
    // Split comments by new line and embrace the comment block with `/* */`.
    StringBuilder sourceComment = new StringBuilder();
    sourceComment.append(BLOCK_COMMENT_START).append(NEWLINE);
    Arrays.stream(blockComment.comment().split("\\r?\\n"))
        .forEach(
            comment -> {
              sourceComment.append(String.format("%s %s%s", ASTERISK, comment, NEWLINE));
            });
    sourceComment.append(BLOCK_COMMENT_END);
    buffer.append(JavaFormatter.format(sourceComment.toString()));
  }

  @Override
  public void visit(JavaDocComment javaDocComment) {
    StringBuilder sourceComment = new StringBuilder();
    sourceComment.append(JAVADOC_COMMENT_START).append(NEWLINE);
    Arrays.stream(javaDocComment.comment().split("\\r?\\n"))
        .forEach(
            comment -> {
              sourceComment.append(String.format("%s %s%s", ASTERISK, comment, NEWLINE));
            });
    sourceComment.append(BLOCK_COMMENT_END);
    buffer.append(JavaFormatter.format(sourceComment.toString()));
  }

  /** =============================== OTHER =============================== */
  @Override
  public void visit(MethodDefinition methodDefinition) {
    // Header comments, if any.
    statements(methodDefinition.headerCommentStatements().stream().collect(Collectors.toList()));
    // Annotations, if any.
    annotations(methodDefinition.annotations());

    // Method scope.
    methodDefinition.scope().accept(this);
    space();

    // Templates, if any.
    if (!methodDefinition.templateIdentifiers().isEmpty()) {
      leftAngle();
      IntStream.range(0, methodDefinition.templateIdentifiers().size())
          .forEach(
              i -> {
                methodDefinition.templateIdentifiers().get(i).accept(this);
                if (i < methodDefinition.templateIdentifiers().size() - 1) {
                  buffer.append(COMMA);
                  space();
                }
              });
      rightAngle();
      space();
    }

    // Modifiers.
    if (methodDefinition.isAbstract()) {
      buffer.append(ABSTRACT);
      space();
    }
    if (methodDefinition.isStatic()) {
      buffer.append(STATIC);
      space();
    }
    if (methodDefinition.isFinal()) {
      buffer.append(FINAL);
      space();
    }

    if (!methodDefinition.isConstructor()) {
      methodDefinition.returnType().accept(this);
      if (!methodDefinition.returnTemplateIdentifiers().isEmpty()) {
        leftAngle();
        IntStream.range(0, methodDefinition.returnTemplateIdentifiers().size())
            .forEach(
                i -> {
                  methodDefinition.returnTemplateIdentifiers().get(i).accept(this);
                  if (i < methodDefinition.returnTemplateIdentifiers().size() - 1) {
                    buffer.append(COMMA);
                    space();
                  }
                });
        rightAngle();
      }
      space();
    }

    // Method name.
    methodDefinition.methodIdentifier().accept(this);
    leftParen();

    // Arguments, if any.
    int numArguments = methodDefinition.arguments().size();
    for (int i = 0; i < numArguments; i++) {
      methodDefinition.arguments().get(i).accept(this);
      if (i < numArguments - 1) {
        buffer.append(COMMA);
        space();
      }
    }
    rightParen();

    // Thrown exceptions.
    if (!methodDefinition.throwsExceptions().isEmpty()) {
      space();
      buffer.append(THROWS);
      space();

      Iterator<TypeNode> exceptionIter = methodDefinition.throwsExceptions().iterator();
      while (exceptionIter.hasNext()) {
        TypeNode exceptionType = exceptionIter.next();
        exceptionType.accept(this);
        if (exceptionIter.hasNext()) {
          buffer.append(COMMA);
          space();
        }
      }
    }

    if (methodDefinition.isAbstract() && methodDefinition.body().isEmpty()) {
      semicolon();
      newline();
      return;
    }

    // Method body.
    space();
    leftBrace();
    newline();
    statements(methodDefinition.body());
    if (methodDefinition.returnExpr() != null) {
      ExprStatement.withExpr(methodDefinition.returnExpr()).accept(this);
    }

    rightBrace();
    newline();
    newline();
  }

  @Override
  public void visit(ClassDefinition classDefinition) {
    if (!classDefinition.isNested()) {
      statements(classDefinition.fileHeader().stream().collect(Collectors.toList()));
      newline();
      importWriterVisitor.initialize(
          classDefinition.packageString(), classDefinition.classIdentifier().name());
      buffer.append(String.format("package %s;", classDefinition.packageString()));
      newline();
      newline();
    }

    String regionTagReplace = "REPLACE_REGION_TAG";
    if (classDefinition.regionTag() != null) {
      statements(
          Arrays.asList(
              classDefinition
                  .regionTag()
                  .generateTag(RegionTag.RegionTagRegion.START, regionTagReplace)));
    }

    // This must go first, so that we can check for type collisions.
    classDefinition.accept(importWriterVisitor);
    if (!classDefinition.isNested()) {
      buffer.append(importWriterVisitor.write());
    }
    // Header comments, if any.
    statements(classDefinition.headerCommentStatements().stream().collect(Collectors.toList()));
    // Annotations, if any.
    annotations(classDefinition.annotations());

    classDefinition.scope().accept(this);
    space();

    // Modifiers.
    if (classDefinition.isStatic()) {
      buffer.append(STATIC);
      space();
    }
    if (classDefinition.isFinal()) {
      buffer.append(FINAL);
      space();
    }
    if (classDefinition.isAbstract()) {
      buffer.append(ABSTRACT);
      space();
    }

    // Name, extends, implements.
    buffer.append(CLASS);
    space();
    classDefinition.classIdentifier().accept(this);
    space();
    if (classDefinition.extendsType() != null) {
      buffer.append(EXTENDS);
      space();
      classDefinition.extendsType().accept(this);
      space();
    }

    if (!classDefinition.implementsTypes().isEmpty()) {
      buffer.append(IMPLEMENTS);
      space();

      int numImplementsTypes = classDefinition.implementsTypes().size();
      for (int i = 0; i < numImplementsTypes; i++) {
        classDefinition.implementsTypes().get(i).accept(this);
        if (i < numImplementsTypes - 1) {
          buffer.append(COMMA);
        }
        space();
      }
    }

    // Class body.
    leftBrace();
    newline();

    statements(classDefinition.statements());
    newline();
    methods(classDefinition.methods());
    newline();
    classes(classDefinition.nestedClasses());

    rightBrace();
    if (classDefinition.regionTag() != null) {
      statements(
          Arrays.asList(
              classDefinition
                  .regionTag()
                  .generateTag(RegionTag.RegionTagRegion.END, regionTagReplace)));
    }

    // We should have valid Java by now, so format it.
    if (!classDefinition.isNested()) {
      String formattedClazz = JavaFormatter.format(buffer.toString());

      // fixing region tag after formatting
      // formatter splits long region tags on multiple lines and moves the end tag up - doesn't meet
      // tag requirements. See https://github.com/google/google-java-format/issues/137
      if (classDefinition.regionTag() != null) {
        formattedClazz =
            formattedClazz.replaceAll(regionTagReplace, classDefinition.regionTag().generate());
        formattedClazz = formattedClazz.replaceAll("} // \\[END", "}\n// \\[END");
      }
      buffer.replace(0, buffer.length(), formattedClazz);
    }
  }

  @Override
  public void visit(PackageInfoDefinition packageInfoDefinition) {
    statements(packageInfoDefinition.fileHeader().stream().collect(Collectors.toList()));
    newline();
    statements(
        packageInfoDefinition.headerCommentStatements().stream().collect(Collectors.toList()));
    newline();

    annotations(packageInfoDefinition.annotations());
    buffer.append(String.format("package %s;", packageInfoDefinition.pakkage()));
    newline();

    packageInfoDefinition.accept(importWriterVisitor);
    importWriterVisitor.initialize(packageInfoDefinition.pakkage());
    buffer.append(importWriterVisitor.write());

    // Format code.
    buffer.replace(0, buffer.length(), JavaFormatter.format(buffer.toString()));
  }

  /** =============================== PRIVATE HELPERS =============================== */
  private void annotations(List<AnnotationNode> annotations) {
    for (AnnotationNode annotation : annotations) {
      annotation.accept(this);
    }
  }

  private void statements(List<Statement> statements) {
    for (Statement statement : statements) {
      statement.accept(this);
    }
  }

  private void methods(List<MethodDefinition> methods) {
    for (MethodDefinition method : methods) {
      method.accept(this);
    }
  }

  private void classes(List<ClassDefinition> classes) {
    if (!classes.isEmpty()) {
      newline();
    }
    for (ClassDefinition classDef : classes) {
      classDef.accept(this);
      newline();
      newline();
    }
  }

  private void space() {
    buffer.append(SPACE);
  }

  private void newline() {
    buffer.append(NEWLINE);
  }

  private void leftParen() {
    buffer.append(LEFT_PAREN);
  }

  private void rightParen() {
    buffer.append(RIGHT_PAREN);
  }

  private void leftAngle() {
    buffer.append(LEFT_ANGLE);
  }

  private void rightAngle() {
    buffer.append(RIGHT_ANGLE);
  }

  private void leftBrace() {
    buffer.append(LEFT_BRACE);
  }

  private void rightBrace() {
    buffer.append(RIGHT_BRACE);
  }

  private void semicolon() {
    buffer.append(SEMICOLON);
  }

  private void operator(OperatorKind kind) {
    switch (kind) {
      case ARITHMETIC_ADDITION:
        buffer.append(OPERATOR_ADDITION);
        break;
      case ASSIGNMENT_XOR:
        buffer.append(OPERATOR_XOR);
        break;
      case ASSIGNMENT_MULTIPLY:
        buffer.append(OPERATOR_MULTIPLE_AND_ASSIGNMENT);
        break;
      case RELATIONAL_EQUAL_TO:
        buffer.append(OPERATOR_EQUAL_TO);
        break;
      case RELATIONAL_NOT_EQUAL_TO:
        buffer.append(OPERATOR_NOT_EQUAL_TO);
        break;
      case RELATIONAL_LESS_THAN:
        buffer.append(OPERATOR_LESS_THAN);
        break;
      case UNARY_POST_INCREMENT:
        buffer.append(OPERATOR_INCREMENT);
        break;
      case UNARY_LOGICAL_NOT:
        buffer.append(OPERATOR_LOGICAL_NOT);
        break;
      case LOGICAL_AND:
        buffer.append(OPERATOR_LOGICAL_AND);
        break;
      case LOGICAL_OR:
        buffer.append(OPERATOR_LOGICAL_OR);
        break;
    }
  }
}
