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

import static com.google.cloud.storage.it.runner.SneakyException.sneaky;

import com.google.cloud.storage.it.runner.annotations.Inject;
import com.google.cloud.storage.it.runner.registry.Registry;
import com.google.common.collect.ImmutableList;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.InitializationError;
import org.junit.runners.model.TestClass;
import org.slf4j.LoggerFactory;

final class StorageITLeafRunner extends BlockJUnit4ClassRunner {
  private final CrossRunIntersection crossRunIntersection;
  @Nullable private final String name;
  private final TestInitializer f;

  private StorageITLeafRunner(
      TestClass testClass,
      CrossRunIntersection crossRunIntersection,
      @Nullable String name,
      TestInitializer f)
      throws InitializationError {
    super(testClass);
    this.f = f;
    this.crossRunIntersection = crossRunIntersection;
    this.name = name;
  }

  @Override
  protected void validateFields(List<Throwable> errors) {
    super.validateFields(errors);
    TestClass testClass = getTestClass();
    if (testClass != null) {
      testClass.getAnnotatedFields(Inject.class).stream()
          .map(
              ff -> {
                Field f = ff.getField();
                Class<?> type = f.getType();
                int modifiers = f.getModifiers();
                if (Modifier.isPublic(modifiers)) {
                  // manually lookup the registry here since this method is called as part of the
                  // super constructor and any passed in value to our constructor hasn't been set
                  // yet.
                  Registry registry = Registry.getInstance();
                  if (registry.injectableTypes().stream().anyMatch(type::isAssignableFrom)) {
                    return null;
                  } else {
                    return new Exception(
                        String.format(
                            Locale.US,
                            "@Inject field '%s' must have a type compatible with one of [%s]",
                            f,
                            registry.injectableTypesString()));
                  }
                } else {
                  return new Exception(
                      String.format(Locale.US, "The @Inject field '%s' must be public", f));
                }
              })
          .filter(Objects::nonNull)
          .forEach(errors::add);
    }
  }

  @Override
  protected void validateTestMethods(List<Throwable> errors) {
    TestClass testClass = getTestClass();
    if (testClass != null) {
      boolean anyTestWithTimeout =
          testClass.getAnnotatedMethods(Test.class).stream()
              .anyMatch(fm -> fm.getAnnotation(Test.class).timeout() > 0);

      boolean timeoutRule =
          testClass.getAnnotatedFields(Rule.class).stream()
              .anyMatch(ff -> ff.getType().isAssignableFrom(Timeout.class));

      boolean timeoutClassRule =
          testClass.getAnnotatedFields(ClassRule.class).stream()
              .anyMatch(ff -> ff.getType().isAssignableFrom(Timeout.class));

      if (anyTestWithTimeout || timeoutRule || timeoutClassRule) {
        String msg =
            "Using @Test(timeout = 1), @Rule Timeout or @ClassRule Timeout can break multi-thread"
                + " and Fixture support of StorageITRunner. Please refactor your test to detect a"
                + " timeout in the test itself.";
        LoggerFactory.getLogger(StorageITRunner.class).warn(msg);
      }
    }
    super.validateTestMethods(errors);
  }

  @Override
  protected String getName() {
    if (name == null) {
      return super.getName();
    } else {
      return name;
    }
  }

  @Override
  protected String testName(FrameworkMethod method) {
    if (name == null) {
      return method.getName();
    } else {
      return method.getName() + getName();
    }
  }

  @Override
  protected List<FrameworkMethod> computeTestMethods() {
    List<FrameworkMethod> baseMethods = super.computeTestMethods();
    if (crossRunIntersection != null) {
      return baseMethods.stream()
          .filter(Objects::nonNull)
          .filter(fm -> !CrossRunFrameworkMethod.of(fm).isExcluded(crossRunIntersection))
          .collect(ImmutableList.toImmutableList());
    } else {
      return baseMethods;
    }
  }

  @Override
  protected Object createTest(FrameworkMethod method) throws Exception {
    return f.apply(super.createTest(method));
  }

  @Override
  protected boolean isIgnored(FrameworkMethod child) {
    return super.isIgnored(child)
        || CrossRunFrameworkMethod.of(child).isIgnored(crossRunIntersection);
  }

  static StorageITLeafRunner of(
      TestClass testClass,
      CrossRunIntersection crossRunIntersection,
      @Nullable String name,
      TestInitializer f)
      throws InitializationError {
    return new StorageITLeafRunner(testClass, crossRunIntersection, name, f);
  }

  static StorageITLeafRunner unsafeOf(
      TestClass testClass,
      CrossRunIntersection crossRunIntersection,
      @Nullable String name,
      TestInitializer f) {
    return sneaky(() -> of(testClass, crossRunIntersection, name, f));
  }
}
