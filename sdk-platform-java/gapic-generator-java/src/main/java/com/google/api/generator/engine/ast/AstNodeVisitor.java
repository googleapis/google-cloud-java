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

public interface AstNodeVisitor {
  /** Writes the syntatically-correct Java code representation of this node. */
  public void visit(IdentifierNode identifier);

  public void visit(TypeNode type);

  public void visit(ScopeNode scope);

  public void visit(AnnotationNode annotation);

  public void visit(ArrayExpr expr);

  public void visit(ConcreteReference reference);

  public void visit(VaporReference reference);

  /** =============================== EXPRESSIONS =============================== */
  public void visit(ValueExpr valueExpr);

  public void visit(VariableExpr variableExpr);

  public void visit(TernaryExpr tenaryExpr);

  public void visit(AssignmentExpr assignmentExpr);

  public void visit(MethodInvocationExpr methodInvocationExpr);

  public void visit(CastExpr castExpr);

  public void visit(AnonymousClassExpr anonymousClassExpr);

  public void visit(ThrowExpr throwExpr);

  public void visit(InstanceofExpr instanceofExpr);

  public void visit(NewObjectExpr newObjectExpr);

  public void visit(EnumRefExpr enumRefExpr);

  public void visit(ReturnExpr returnExpr);

  public void visit(ReferenceConstructorExpr referenceConstructorExpr);

  public void visit(ArithmeticOperationExpr arithmeticOperationExpr);

  public void visit(UnaryOperationExpr unaryOperationExpr);

  public void visit(RelationalOperationExpr relationalOperationExpr);

  public void visit(LogicalOperationExpr logicalOperationExpr);

  public void visit(AssignmentOperationExpr assignmentOperationExpr);

  public void visit(LambdaExpr lambdaExpr);

  /** =============================== COMMENT =============================== */
  public void visit(LineComment lineComment);

  public void visit(BlockComment blockComment);

  public void visit(JavaDocComment javaDocComment);

  /** =============================== STATEMENTS =============================== */
  public void visit(ExprStatement exprStatement);

  public void visit(BlockStatement blockStatement);

  public void visit(IfStatement ifStatement);

  public void visit(ForStatement forStatement);

  public void visit(GeneralForStatement generalForStatement);

  public void visit(WhileStatement whileStatement);

  public void visit(TryCatchStatement tryCatchStatement);

  public void visit(SynchronizedStatement synchronizedStatement);

  public void visit(CommentStatement commentStatement);

  public void visit(EmptyLineStatement emptyLineStatement);

  public void visit(BreakStatement breakStatement);

  /** =============================== OTHER =============================== */
  public void visit(MethodDefinition methodDefinition);

  public void visit(ClassDefinition classDefinition);

  public void visit(PackageInfoDefinition packageInfoDefinition);
}
