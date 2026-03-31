/*
 * Copyright 2015 Google LLC
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

package com.google.cloud.storage;

import com.google.cloud.storage.UnifiedOpts.Opt;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.function.IntFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/** Base class for Storage operation option. */
@Deprecated
public abstract class Option<O extends Opt> extends UnifiedOpts.OptionShim<O>
    implements Serializable {

  private static final long serialVersionUID = -7579883369516703936L;

  Option(O opt) {
    super(opt);
  }

  @SafeVarargs
  static <O extends Option<?>> O[] dedupe(IntFunction<O[]> gen, O... os) {
    return dedupe(gen, Arrays.stream(os));
  }

  @SafeVarargs
  static <O extends Option<?>> O[] dedupe(IntFunction<O[]> gen, Collection<O> collection, O... os) {
    return dedupe(gen, Stream.of(collection.stream(), Arrays.stream(os)).flatMap(s -> s));
  }

  @SafeVarargs
  static <O extends Option<?>> O[] dedupe(IntFunction<O[]> gen, O[] array, O... os) {
    return dedupe(gen, Stream.of(Arrays.stream(array), Arrays.stream(os)).flatMap(s -> s));
  }

  /**
   * All Options contain an {@link Opt}, {@code Opt}s are distinct classes allowing us to group
   * based on those classes. Once grouped, we select the last element to provide last wins behavior.
   *
   * <p>Each of these helpers is an internal implementation detail, primarily due to the fact that
   * generic arrays can not be instantiated in Java and requires a factory to be passed in.
   */
  private static <O extends Option<?>> O[] dedupe(IntFunction<O[]> gen, Stream<O> s) {
    return s.collect(Collectors.groupingBy(o -> o.getOpt().getClass())).values().stream()
        .map(l -> l.get(l.size() - 1))
        .toArray(gen);
  }
}
