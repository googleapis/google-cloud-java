/*
 * Copyright 2021 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.api.generator.gapic.composer.grpcrest;

import com.google.api.generator.engine.ast.MethodDefinition;
import com.google.api.generator.engine.ast.ReturnExpr;
import com.google.api.generator.engine.ast.ScopeNode;
import com.google.api.generator.engine.ast.TypeNode;
import com.google.api.generator.engine.ast.ValueExpr;
import com.google.api.generator.gapic.composer.common.AbstractServiceStubClassComposer;
import com.google.api.generator.gapic.composer.store.TypeStore;

public class ServiceStubClassComposer extends AbstractServiceStubClassComposer {
  private static final ServiceStubClassComposer INSTANCE = new ServiceStubClassComposer();

  protected ServiceStubClassComposer() {
    super(GrpcRestContext.instance());
  }

  public static ServiceStubClassComposer instance() {
    return INSTANCE;
  }

  @Override
  protected MethodDefinition createOperationsStubGetterMethodDefinition(
      TypeNode returnType, String methodName, TypeStore typeStore) {
    return MethodDefinition.builder()
        .setScope(ScopeNode.PUBLIC)
        .setReturnType(returnType)
        .setName(methodName)
        .setReturnExpr(ReturnExpr.withExpr(ValueExpr.createNullExpr()))
        .build();
  }
}
