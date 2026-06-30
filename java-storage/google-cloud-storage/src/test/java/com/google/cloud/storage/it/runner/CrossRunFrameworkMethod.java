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

package com.google.cloud.storage.it.runner;

import com.google.cloud.storage.it.runner.annotations.CrossRun;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;
import java.lang.annotation.Annotation;
import java.util.Optional;
import org.junit.runners.model.FrameworkMethod;

/**
 * Utility wrapper for {@link FrameworkMethod} providing "syntax" extension for exclude and ignore
 * logic
 */
final class CrossRunFrameworkMethod {

  private final FrameworkMethod fm;

  private CrossRunFrameworkMethod(FrameworkMethod fm) {
    this.fm = fm;
  }

  boolean isIgnored(CrossRunIntersection crossRunIntersection) {
    ImmutableSet<CrossRunIntersection> ignores = ignores();
    return ignores.stream().anyMatch(crossRunIntersection::anyMatch);
  }

  boolean isExcluded(CrossRunIntersection crossRunIntersection) {
    ImmutableSet<CrossRunIntersection> crossRunIntersections = excludedAndNotIgnored();
    return crossRunIntersections.stream().anyMatch(crossRunIntersection::anyMatch);
  }

  private ImmutableSet<CrossRunIntersection> excludedAndNotIgnored() {
    ImmutableSet<CrossRunIntersection> excludes =
        findMethodOrClassAnnotation(fm, CrossRun.Exclude.class)
            .map(CrossRunIntersection::expand)
            .orElse(ImmutableSet.of());
    ImmutableSet<CrossRunIntersection> ignores = ignores();
    return ImmutableSet.copyOf(Sets.difference(excludes, ignores));
  }

  private ImmutableSet<CrossRunIntersection> ignores() {
    return findMethodOrClassAnnotation(fm, CrossRun.Ignore.class)
        .map(CrossRunIntersection::expand)
        .orElse(ImmutableSet.of());
  }

  static CrossRunFrameworkMethod of(FrameworkMethod fm) {
    return new CrossRunFrameworkMethod(fm);
  }

  private static <A extends Annotation> Optional<A> findMethodOrClassAnnotation(
      FrameworkMethod child, Class<A> annotation) {
    A methodA = child.getAnnotation(annotation);
    A classA = child.getDeclaringClass().getAnnotation(annotation);
    if (methodA != null) {
      return Optional.of(methodA);
    } else {
      return Optional.ofNullable(classA);
    }
  }
}
