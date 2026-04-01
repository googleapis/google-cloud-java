/*
 * Copyright 2022 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.storage.jqwik;

import static com.google.cloud.storage.PackagePrivateMethodWorkarounds.ifNonNull;

import com.google.iam.v1.Binding;
import com.google.iam.v1.Policy;
import com.google.protobuf.ByteString;
import com.google.type.Expr;
import java.util.Collections;
import java.util.Locale;
import java.util.Set;
import javax.annotation.ParametersAreNonnullByDefault;
import net.jqwik.api.Arbitraries;
import net.jqwik.api.Arbitrary;
import net.jqwik.api.Combinators;
import net.jqwik.api.providers.ArbitraryProvider;
import net.jqwik.api.providers.TypeUsage;
import net.jqwik.web.api.Web;
import org.checkerframework.checker.nullness.qual.NonNull;

@ParametersAreNonnullByDefault
public final class IamPolicyArbitraryProvider implements ArbitraryProvider {

  @Override
  public boolean canProvideFor(TypeUsage targetType) {
    return targetType.isOfType(Policy.class);
  }

  @NonNull
  @Override
  public Set<Arbitrary<?>> provideFor(TypeUsage targetType, SubtypeProvider subtypeProvider) {
    Arbitrary<Policy> as =
        Combinators.combine(
                StorageArbitraries.etag().injectNull(0.10),
                Arbitraries.integers().between(0, 3).injectNull(0.05),
                bindings().list().ofMinSize(0).ofMaxSize(10).injectNull(0.5))
            .as(
                (etag, version, bindings) -> {
                  Policy.Builder b = Policy.newBuilder();
                  ifNonNull(etag, ByteString::copyFromUtf8, b::setEtag);
                  ifNonNull(version, b::setVersion);
                  ifNonNull(bindings, b::addAllBindings);
                  return b.build();
                });
    return Collections.singleton(as);
  }

  static Arbitrary<Binding> bindings() {
    return Combinators.combine(
            role(),
            member().list().ofMinSize(0).ofMaxSize(10).injectNull(0.2),
            condition().injectNull(0.25))
        .as(
            (role, members, condition) -> {
              Binding.Builder b = Binding.newBuilder();
              ifNonNull(role, b::setRole);
              ifNonNull(members, b::addAllMembers);
              ifNonNull(condition, b::setCondition);
              return b.build();
            });
  }

  static Arbitrary<String> role() {
    return Arbitraries.of("roles/viewer", "roles/editor", "roles/owner");
  }

  static Arbitrary<String> member() {
    return Arbitraries.oneOf(
        Arbitraries.of("allUsers"),
        Arbitraries.of("allAuthenticatedUsers"),
        Web.emails().map(e -> String.format(Locale.US, "user:%s", e)),
        Web.emails().map(e -> String.format(Locale.US, "serviceAccount:%s", e)),
        Web.emails().map(e -> String.format(Locale.US, "group:%s", e)),
        Web.webDomains().map(d -> String.format(Locale.US, "domain:%s", d)));
  }

  static Arbitrary<Expr> condition() {
    return Combinators.combine(nonEmptyAlphaString(), nonEmptyAlphaString(), nonEmptyAlphaString())
        .as(
            (title, description, expression) -> {
              // location intentionally omitted as the json representation of an Expr does not
              // specify location
              return Expr.newBuilder()
                  .setTitle(title)
                  .setDescription(description)
                  .setExpression(expression)
                  .build();
            });
  }

  private static Arbitrary<String> nonEmptyAlphaString() {
    return StorageArbitraries.alphaString().filter(s -> !s.isEmpty());
  }
}
