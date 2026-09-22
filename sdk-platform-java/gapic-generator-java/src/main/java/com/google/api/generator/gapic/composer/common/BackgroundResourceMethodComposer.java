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

package com.google.api.generator.gapic.composer.common;

import com.google.api.generator.engine.ast.ConcreteReference;
import com.google.api.generator.engine.ast.Expr;
import com.google.api.generator.engine.ast.ExprStatement;
import com.google.api.generator.engine.ast.MethodDefinition;
import com.google.api.generator.engine.ast.MethodInvocationExpr;
import com.google.api.generator.engine.ast.ScopeNode;
import com.google.api.generator.engine.ast.ThrowExpr;
import com.google.api.generator.engine.ast.TryCatchStatement;
import com.google.api.generator.engine.ast.TypeNode;
import com.google.api.generator.engine.ast.Variable;
import com.google.api.generator.engine.ast.VariableExpr;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.jspecify.annotations.NullMarked;

/**
 * Generates the {@code BackgroundResource} method overrides that a generated stub delegates to its
 * {@code backgroundResources} member.
 */
@NullMarked
public final class BackgroundResourceMethodComposer {

  private static final TypeNode TIME_UNIT_TYPE =
      TypeNode.withReference(ConcreteReference.withClazz(TimeUnit.class));
  private static final TypeNode INTERRUPTED_EXCEPTION_TYPE =
      TypeNode.withReference(ConcreteReference.withClazz(InterruptedException.class));

  private BackgroundResourceMethodComposer() {}

  /**
   * Returns the {@code BackgroundResource} overrides, in declaration order, each delegating to the
   * given {@code backgroundResources} member variable.
   */
  public static List<MethodDefinition> createBackgroundResourceMethods(
      VariableExpr backgroundResourcesVarExpr) {
    Function<String, MethodDefinition.Builder> methodMakerStarterFn =
        methodName ->
            MethodDefinition.builder()
                .setIsOverride(true)
                .setScope(ScopeNode.PUBLIC)
                .setName(methodName);

    Function<String, MethodDefinition> voidMethodMakerFn =
        methodName ->
            methodMakerStarterFn
                .apply(methodName)
                .setReturnType(TypeNode.VOID)
                .setBody(
                    Arrays.asList(
                        ExprStatement.withExpr(
                            MethodInvocationExpr.builder()
                                .setExprReferenceExpr(backgroundResourcesVarExpr)
                                .setMethodName(methodName)
                                .build())))
                .build();

    Function<String, MethodDefinition> booleanMethodMakerFn =
        methodName ->
            methodMakerStarterFn
                .apply(methodName)
                .setReturnType(TypeNode.BOOLEAN)
                .setReturnExpr(
                    MethodInvocationExpr.builder()
                        .setExprReferenceExpr(backgroundResourcesVarExpr)
                        .setMethodName(methodName)
                        .setReturnType(TypeNode.BOOLEAN)
                        .build())
                .build();

    // Generate the close() method:
    //   @Override
    //   public final void close() {
    //     try {
    //       backgroundResources.close();
    //     } catch (RuntimeException e) {
    //       throw e;
    //     } catch (Exception e) {
    //       throw new IllegalStateException("Failed to close resource", e);
    //     }
    //  }

    VariableExpr catchRuntimeExceptionVarExpr =
        VariableExpr.builder()
            .setVariable(
                Variable.builder()
                    .setType(TypeNode.withExceptionClazz(RuntimeException.class))
                    .setName("e")
                    .build())
            .build();
    VariableExpr catchExceptionVarExpr =
        VariableExpr.builder()
            .setVariable(
                Variable.builder()
                    .setType(TypeNode.withExceptionClazz(Exception.class))
                    .setName("e")
                    .build())
            .build();

    List<MethodDefinition> javaMethods = new ArrayList<>();
    javaMethods.add(
        methodMakerStarterFn
            .apply("close")
            .setIsFinal(true)
            .setReturnType(TypeNode.VOID)
            .setBody(
                Arrays.asList(
                    TryCatchStatement.builder()
                        .setTryBody(
                            Arrays.asList(
                                ExprStatement.withExpr(
                                    MethodInvocationExpr.builder()
                                        .setExprReferenceExpr(backgroundResourcesVarExpr)
                                        .setMethodName("close")
                                        .build())))
                        .addCatch(
                            catchRuntimeExceptionVarExpr.toBuilder().setIsDecl(true).build(),
                            Arrays.asList(
                                ExprStatement.withExpr(
                                    ThrowExpr.builder()
                                        .setThrowExpr(catchRuntimeExceptionVarExpr)
                                        .build())))
                        .addCatch(
                            catchExceptionVarExpr.toBuilder().setIsDecl(true).build(),
                            Arrays.asList(
                                ExprStatement.withExpr(
                                    ThrowExpr.builder()
                                        .setType(
                                            TypeNode.withExceptionClazz(
                                                IllegalStateException.class))
                                        .setMessageExpr("Failed to close resource")
                                        .setCauseExpr(catchExceptionVarExpr)
                                        .build())))
                        .build()))
            .build());
    javaMethods.add(voidMethodMakerFn.apply("shutdown"));
    javaMethods.add(booleanMethodMakerFn.apply("isShutdown"));
    javaMethods.add(booleanMethodMakerFn.apply("isTerminated"));
    javaMethods.add(voidMethodMakerFn.apply("shutdownNow"));

    List<VariableExpr> awaitTerminationArgs =
        Arrays.asList(
            VariableExpr.withVariable(
                Variable.builder().setName("duration").setType(TypeNode.LONG).build()),
            VariableExpr.withVariable(
                Variable.builder().setName("unit").setType(TIME_UNIT_TYPE).build()));
    javaMethods.add(
        methodMakerStarterFn
            .apply("awaitTermination")
            .setReturnType(TypeNode.BOOLEAN)
            .setArguments(
                awaitTerminationArgs.stream()
                    .map(v -> v.toBuilder().setIsDecl(true).build())
                    .collect(Collectors.toList()))
            .setThrowsExceptions(Arrays.asList(INTERRUPTED_EXCEPTION_TYPE))
            .setReturnExpr(
                MethodInvocationExpr.builder()
                    .setExprReferenceExpr(backgroundResourcesVarExpr)
                    .setMethodName("awaitTermination")
                    .setArguments(
                        awaitTerminationArgs.stream()
                            .map(v -> (Expr) v)
                            .collect(Collectors.toList()))
                    .setReturnType(TypeNode.BOOLEAN)
                    .build())
            .build());
    return javaMethods;
  }
}
