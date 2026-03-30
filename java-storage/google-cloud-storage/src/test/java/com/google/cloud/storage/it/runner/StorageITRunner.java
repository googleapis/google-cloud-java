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

import com.google.cloud.storage.it.runner.annotations.Backend;
import com.google.cloud.storage.it.runner.annotations.CrossRun;
import com.google.cloud.storage.it.runner.annotations.CrossRun.AllowClassRule;
import com.google.cloud.storage.it.runner.annotations.ParallelFriendly;
import com.google.cloud.storage.it.runner.annotations.Parameterized;
import com.google.cloud.storage.it.runner.annotations.Parameterized.Parameter;
import com.google.cloud.storage.it.runner.annotations.Parameterized.ParametersProvider;
import com.google.cloud.storage.it.runner.annotations.SingleBackend;
import com.google.cloud.storage.it.runner.registry.Registry;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Function;
import java.util.stream.Stream;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.junit.ClassRule;
import org.junit.runner.Description;
import org.junit.runner.Runner;
import org.junit.runner.manipulation.Filter;
import org.junit.runner.manipulation.NoTestsRemainException;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.Suite;
import org.junit.runners.model.FrameworkField;
import org.junit.runners.model.InitializationError;
import org.junit.runners.model.TestClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Storage custom runner which will handle {@link CrossRun}, {@link SingleBackend}, {@link
 * com.google.cloud.storage.it.runner.annotations.ParallelFriendly} and {@link
 * com.google.cloud.storage.it.runner.annotations.Inject} suite computation.
 *
 * <p>Use in place of the usual default JUnit test runner.
 *
 * @see org.junit.runners.BlockJUnit4ClassRunner
 */
public final class StorageITRunner extends Suite {
  static {
    org.slf4j.bridge.SLF4JBridgeHandler.removeHandlersForRootLogger();
    org.slf4j.bridge.SLF4JBridgeHandler.install();
  }

  private static final Logger LOGGER = LoggerFactory.getLogger(StorageITRunner.class);

  private final Lock childrenLock = new ReentrantLock();
  private volatile ImmutableList<Runner> filteredChildren = null;

  public StorageITRunner(Class<?> klass) throws InitializationError {
    super(klass, computeRunners(klass, Registry.getInstance()));
    boolean runInParallel = getTestClass().getAnnotation(ParallelFriendly.class) != null;
    if (runInParallel) {
      this.setScheduler(Registry.getInstance().parallelScheduler());
    }
  }

  @Override
  public void run(RunNotifier notifier) {
    LOGGER.debug("run(notifier : {})", notifier);
    super.run(new RunNotifierUnion(notifier, Registry.getInstance()));
  }

  /*
  Filter is how intellij picks an individual method to run
   */
  @Override
  public void filter(Filter filter) throws NoTestsRemainException {
    childrenLock.lock();
    try {
      // TODO: Figure out how/why the test name is being mangled when @CrossRun is present
      //    test_results
      //    | test1[http][prod]()
      //    \ StorageParamTest
      //  instead of
      //    StorageParamTest / [http][prod] / test1
      filteredChildren =
          getFilteredChildren().stream()
              .filter(c -> shouldRun(filter, c, this::describeChild))
              .collect(ImmutableList.toImmutableList());
      if (filteredChildren.isEmpty()) {
        throw new NoTestsRemainException();
      }
    } finally {
      childrenLock.unlock();
    }
  }

  private List<Runner> getFilteredChildren() {
    if (filteredChildren == null) {
      childrenLock.lock();
      try {
        if (filteredChildren == null) {
          filteredChildren = ImmutableList.copyOf(getChildren());
        }
      } finally {
        childrenLock.unlock();
      }
    }
    return filteredChildren;
  }

  private static List<Runner> computeRunners(Class<?> klass, Registry registry)
      throws InitializationError {
    TestClass testClass = new TestClass(klass);

    Parameterized parameterized = testClass.getAnnotation(Parameterized.class);

    CrossRun crossRun = getClassAnnotation(testClass, CrossRun.class);
    SingleBackend singleBackend = getClassAnnotation(testClass, SingleBackend.class);
    StorageITRunner.validateBackendAnnotations(crossRun, singleBackend);

    final ImmutableList<?> parameters;
    if (parameterized != null) {
      try {
        Class<? extends ParametersProvider> ppC = parameterized.value();
        ParametersProvider pp = ppC.newInstance();
        registry.injectFields(pp, null);
        parameters = pp.parameters();
        if (parameters == null || parameters.isEmpty()) {
          throw new InitializationError(
              "Null or empty parameters from ParameterProvider: " + ppC.getName());
        }
      } catch (InstantiationException | IllegalAccessException e) {
        throw new InitializationError(e);
      }
    } else {
      parameters = null;
    }

    if (crossRun != null) {
      List<FrameworkField> classRules = testClass.getAnnotatedFields(ClassRule.class);
      AllowClassRule allowClassRule = testClass.getAnnotation(AllowClassRule.class);
      if (allowClassRule == null && !classRules.isEmpty()) {
        String msg =
            "@CrossRun used along with @ClassRule. This can be dangerous, multiple class scopes"
                + " will be created for cross running, possibly breaking expectations on rule"
                + " scope. If the use of a @ClassRule is still desirable, please annotate your"
                + " class with @CrossRun.AllowClassRule";
        throw new InitializationError(msg);
      }
      return SneakyException.unwrap(
          () ->
              ImmutableSet.copyOf(crossRun.backends()).stream()
                  .flatMap(
                      b ->
                          ImmutableSet.copyOf(crossRun.transports()).stream()
                              .map(t -> CrossRunIntersection.of(b, t)))
                  .flatMap(
                      c -> {
                        TestInitializer ti = registry.newTestInitializerForCell(c);
                        if (parameters != null) {
                          return parameters.stream()
                              .map(
                                  param ->
                                      StorageITLeafRunner.unsafeOf(
                                          testClass,
                                          c,
                                          fmtParam(c, param),
                                          ti.andThen(setFieldTo(testClass, param))));
                        } else {
                          return Stream.of(
                              StorageITLeafRunner.unsafeOf(testClass, c, c.fmtSuiteName(), ti));
                        }
                      })
                  .collect(ImmutableList.toImmutableList()));
    } else {
      Backend backend = singleBackend.value();
      CrossRunIntersection crossRunIntersection = CrossRunIntersection.of(backend, null);
      TestInitializer ti = registry.newTestInitializerForCell(crossRunIntersection);
      if (parameters != null) {
        return SneakyException.unwrap(
            () ->
                parameters.stream()
                    .map(
                        param ->
                            StorageITLeafRunner.unsafeOf(
                                testClass,
                                crossRunIntersection,
                                fmtParam(param),
                                ti.andThen(setFieldTo(testClass, param))))
                    .collect(ImmutableList.toImmutableList()));
      } else {
        return ImmutableList.of(StorageITLeafRunner.of(testClass, crossRunIntersection, null, ti));
      }
    }
  }

  private static <A extends Annotation> @Nullable A getClassAnnotation(
      TestClass testClass, Class<A> annotation) {
    A a = testClass.getAnnotation(annotation);
    if (a != null) {
      return a;
    }
    Class<?> parent = testClass.getJavaClass().getSuperclass();
    if (parent == null) {
      return null;
    }
    return getClassAnnotation(new TestClass(parent), annotation);
  }

  private static String fmtParam(Object param) {
    return String.format(Locale.US, "[%s]", param.toString());
  }

  private static String fmtParam(CrossRunIntersection c, Object param) {
    return c.fmtSuiteName() + fmtParam(param);
  }

  private static TestInitializer setFieldTo(TestClass testClass, Object param) {
    return o -> {
      List<FrameworkField> ffs = testClass.getAnnotatedFields(Parameter.class);
      for (FrameworkField ff : ffs) {
        ff.getField().set(o, param);
      }
      return o;
    };
  }

  private static void validateBackendAnnotations(CrossRun crossRun, SingleBackend singleBackend)
      throws InitializationError {
    if (crossRun != null && singleBackend != null) {
      throw new InitializationError(
          String.format(
              Locale.US,
              "Class annotated with both @%s and @%s. Pick only one.",
              CrossRun.class.getSimpleName(),
              SingleBackend.class.getSimpleName()));
    } else if (crossRun == null && singleBackend == null) {
      throw new InitializationError(
          String.format(
              Locale.US,
              "Missing either of @%s and @%s.",
              CrossRun.class.getSimpleName(),
              SingleBackend.class.getSimpleName()));
    }
  }

  private static <T> boolean shouldRun(Filter filter, T each, Function<T, Description> describe) {
    if (each instanceof StorageITLeafRunner) {
      StorageITLeafRunner leaf = (StorageITLeafRunner) each;
      return testsRemaining(filter, leaf);
    }

    boolean b = filter.shouldRun(describe.apply(each));
    return b && testsRemaining(filter, each);
  }

  private static boolean testsRemaining(Filter f, Object o) {
    try {
      f.apply(o);
      return true;
    } catch (NoTestsRemainException e) {
      return false;
    }
  }
}
