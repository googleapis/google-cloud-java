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

import com.google.common.collect.ImmutableList;
import java.util.List;
import javax.annotation.Nullable;

public interface Reference extends AstNode {
  @Override
  void accept(AstNodeVisitor visitor);

  ImmutableList<Reference> generics();

  String name();

  // Just the class name, no generics.
  String simpleName();

  String fullName();

  String pakkage();

  boolean useFullName();

  // The nested types in left-to-right order, if any.
  // Example: com.google.Foo.Bar.Car.ThisType will have the outer types listed in the order
  // [Foo, Bar, Car].
  @Nullable
  ImmutableList<String> enclosingClassNames();

  @Nullable
  Reference wildcardUpperBound();

  Reference copyAndSetGenerics(List<Reference> generics);

  // Valid only for nested classes.
  boolean isStaticImport();

  boolean hasEnclosingClass();

  boolean isFromPackage(String pkg);

  // Returns true if this is a supertype of the given Reference.
  boolean isSupertypeOrEquals(Reference other);

  boolean isAssignableFrom(Reference other);

  boolean isWildcard();
}
