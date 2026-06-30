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

package com.google.api.generator.gapic.composer.store;

import com.google.api.generator.engine.ast.ConcreteReference;
import com.google.api.generator.engine.ast.TypeNode;
import com.google.api.generator.engine.ast.VaporReference;
import com.google.api.generator.gapic.model.Message;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TypeStore {
  private final Map<String, TypeNode> store = new HashMap<>();

  public TypeStore() {}

  public TypeStore(List<Class<?>> concreteClasses) {
    putConcreteClassses(concreteClasses);
  }

  private void putConcreteClassses(List<Class<?>> concreteClasses) {
    store.putAll(
        concreteClasses.stream()
            .collect(
                Collectors.toMap(
                    Class::getSimpleName,
                    c -> TypeNode.withReference(ConcreteReference.withClazz(c)))));
  }

  public TypeNode get(String typeName) {
    return store.get(typeName);
  }

  public void put(String pakkage, String typeName) {
    store.put(
        typeName,
        TypeNode.withReference(
            VaporReference.builder().setName(typeName).setPakkage(pakkage).build()));
  }

  public void putAll(String pakkage, List<String> typeNames) {
    for (String typeName : typeNames) {
      put(pakkage, typeName);
    }
  }

  public void put(
      String pakkage, String typeName, boolean isStaticImport, String... enclosingClassNames) {
    store.put(
        typeName,
        TypeNode.withReference(
            VaporReference.builder()
                .setName(typeName)
                .setEnclosingClassNames(enclosingClassNames)
                .setPakkage(pakkage)
                .setIsStaticImport(isStaticImport)
                .build()));
  }

  public void putAll(List<Class<?>> concreteClasses) {
    putConcreteClassses(concreteClasses);
  }

  public void putAll(
      String pakkage,
      List<String> typeNames,
      boolean isStaticImport,
      String... enclosingClassNames) {
    for (String typeName : typeNames) {
      put(pakkage, typeName, isStaticImport, enclosingClassNames);
    }
  }

  public void putMessageTypes(String pakkage, Map<String, Message> messages) {
    store.putAll(
        messages.entrySet().stream()
            // Short-term hack for messages that have nested subtypes with colliding names. This
            // should work as long as there isn't heavy usage of fully-qualified nested subtypes in
            // general. A long-term fix would involve adding a custom type-store that handles
            // fully-qualified types.
            .filter(e -> e.getValue().outerNestedTypes().isEmpty())
            .collect(
                Collectors.toMap(
                    e -> e.getValue().name(),
                    e ->
                        TypeNode.withReference(
                            VaporReference.builder()
                                .setName(e.getValue().name())
                                .setPakkage(pakkage)
                                .build()))));
  }
}
