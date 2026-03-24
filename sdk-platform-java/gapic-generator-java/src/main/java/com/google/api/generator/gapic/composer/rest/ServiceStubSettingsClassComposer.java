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

package com.google.api.generator.gapic.composer.rest;

import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.HttpJsonTransportChannel;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.api.generator.engine.ast.MethodDefinition;
import com.google.api.generator.engine.ast.MethodInvocationExpr;
import com.google.api.generator.engine.ast.ScopeNode;
import com.google.api.generator.engine.ast.TypeNode;
import com.google.api.generator.gapic.composer.common.AbstractServiceStubSettingsClassComposer;
import com.google.api.generator.gapic.composer.store.TypeStore;
import com.google.api.generator.gapic.model.Service;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ServiceStubSettingsClassComposer extends AbstractServiceStubSettingsClassComposer {
  private static final ServiceStubSettingsClassComposer INSTANCE =
      new ServiceStubSettingsClassComposer();

  private static final TypeStore FIXED_REST_TYPESTORE = createStaticTypes();

  public static ServiceStubSettingsClassComposer instance() {
    return INSTANCE;
  }

  protected ServiceStubSettingsClassComposer() {
    super(RestContext.instance());
  }

  private static TypeStore createStaticTypes() {
    return new TypeStore(
        Arrays.asList(
            GaxHttpJsonProperties.class,
            HttpJsonTransportChannel.class,
            InstantiatingHttpJsonChannelProvider.class));
  }

  @Override
  protected List<MethodDefinition> createApiClientHeaderProviderBuilderMethods(
      Service service, TypeStore typeStore) {
    if (service.hasAnyEnabledMethodsForTransport(getTransportContext().transport())) {
      return Collections.singletonList(
          createApiClientHeaderProviderBuilderMethod(
              service,
              typeStore,
              "defaultApiClientHeaderProviderBuilder",
              FIXED_REST_TYPESTORE.get(GaxHttpJsonProperties.class.getSimpleName()),
              "getHttpJsonTokenName",
              "getHttpJsonVersion"));
    } else {
      return Collections.emptyList();
    }
  }

  @Override
  public MethodDefinition createDefaultTransportChannelProviderMethod() {
    TypeNode returnType = FIXED_TYPESTORE.get("TransportChannelProvider");
    MethodInvocationExpr transportProviderBuilderExpr =
        MethodInvocationExpr.builder()
            .setMethodName("defaultHttpJsonTransportProviderBuilder")
            .build();
    transportProviderBuilderExpr =
        MethodInvocationExpr.builder()
            .setExprReferenceExpr(transportProviderBuilderExpr)
            .setMethodName("build")
            .setReturnType(returnType)
            .build();
    return MethodDefinition.builder()
        .setScope(ScopeNode.PUBLIC)
        .setIsStatic(true)
        .setReturnType(returnType)
        .setName("defaultTransportChannelProvider")
        .setReturnExpr(transportProviderBuilderExpr)
        .build();
  }
}
