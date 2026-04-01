// Copyright 2021 Google LLC
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

package com.google.api.generator.gapic.composer.grpcrest;

import com.google.api.generator.engine.ast.MethodDefinition;
import com.google.api.generator.engine.ast.VariableExpr;
import com.google.api.generator.gapic.composer.common.AbstractServiceClientTestClassComposer;
import com.google.api.generator.gapic.composer.rest.ServiceClientTestClassComposer;
import com.google.api.generator.gapic.composer.store.TypeStore;
import com.google.api.generator.gapic.model.GapicClass;
import com.google.api.generator.gapic.model.GapicContext;
import com.google.api.generator.gapic.model.Service;
import java.util.Map;

public class HttpJsonServiceClientTestClassComposer extends ServiceClientTestClassComposer {
  private static final HttpJsonServiceClientTestClassComposer INSTANCE =
      new HttpJsonServiceClientTestClassComposer();

  protected HttpJsonServiceClientTestClassComposer() {
    super();
  }

  public static AbstractServiceClientTestClassComposer instance() {
    return INSTANCE;
  }

  @Override
  protected GapicClass generate(String className, GapicContext context, Service service) {
    return super.generate(
        getTransportContext().classNames().getServiceClientTestClassNames(service).get(0),
        context,
        service);
  }

  @Override
  protected MethodDefinition createStartStaticServerMethod(
      Service service,
      GapicContext context,
      Map<String, VariableExpr> classMemberVarExprs,
      TypeStore typeStore,
      String newBuilderMethod) {
    return super.createStartStaticServerMethod(
        service, context, classMemberVarExprs, typeStore, "newHttpJsonBuilder");
  }
}
