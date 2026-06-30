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
import com.google.api.generator.gapic.composer.store.TypeStore;
import com.google.api.generator.gapic.model.Service;
import java.util.List;

public class HttpJsonServiceStubClassComposer
    extends com.google.api.generator.gapic.composer.rest.HttpJsonServiceStubClassComposer {
  private static final HttpJsonServiceStubClassComposer INSTANCE =
      new HttpJsonServiceStubClassComposer();

  protected HttpJsonServiceStubClassComposer() {
    super();
  }

  public static HttpJsonServiceStubClassComposer instance() {
    return INSTANCE;
  }

  @Override
  protected List<MethodDefinition> createStaticCreatorMethods(
      Service service, TypeStore typeStore, String newBuilderMethod) {
    // No need to check if REST Transport is enabled
    // AbstractTransportServiceStubClassComposer won't generate a file if REST isn't enabled
    return super.createStaticCreatorMethods(service, typeStore, "newHttpJsonBuilder");
  }
}
