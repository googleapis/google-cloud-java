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

public class ScopeNode implements AstNode {
  private enum ScopeKind {
    LOCAL, // Placeholder for local scopes.
    PRIVATE,
    PROTECTED,
    PUBLIC;
  }

  private final ScopeKind scopeKind;

  private ScopeNode(ScopeKind scopeKind) {
    this.scopeKind = scopeKind;
  }

  public static final ScopeNode PRIVATE = new ScopeNode(ScopeKind.PRIVATE);
  public static final ScopeNode PROTECTED = new ScopeNode(ScopeKind.PROTECTED);
  public static final ScopeNode PUBLIC = new ScopeNode(ScopeKind.PUBLIC);
  public static final ScopeNode LOCAL = new ScopeNode(ScopeKind.LOCAL);

  @Override
  public String toString() {
    switch (scopeKind) {
      case PRIVATE:
        return "private";
      case PROTECTED:
        return "protected";
      case PUBLIC:
        return "public";
      case LOCAL:
      default:
        return "";
    }
  }

  @Override
  public void accept(AstNodeVisitor visitor) {
    visitor.visit(this);
  }

  @Override
  public boolean equals(Object o) {
    if (!(o instanceof ScopeNode)) {
      return false;
    }

    ScopeNode scope = (ScopeNode) o;
    return scopeKind.equals(scope.scopeKind);
  }

  @Override
  public int hashCode() {
    return 17 * scopeKind.hashCode();
  }
}
