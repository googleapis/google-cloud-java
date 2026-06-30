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

import com.google.cloud.storage.it.runner.registry.Registry;
import org.junit.function.ThrowingRunnable;
import org.junit.runner.Description;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;
import org.junit.runner.notification.RunNotifier;
import org.junit.runner.notification.StoppedByUserException;

/**
 * Run Notifier doesn't provide an API to query if our custom listener is registered or not, so,
 * instead we decorate the one provided to us and forward the events to the delegate and our
 * registry.
 */
final class RunNotifierUnion extends RunNotifier {

  private final RunNotifier delegate;
  private final Registry registry;

  RunNotifierUnion(RunNotifier delegate, Registry registry) {
    this.delegate = delegate;
    this.registry = registry;
  }

  @Override
  public void fireTestRunStarted(Description description) {
    safely(() -> registry.testRunStarted(description));
    delegate.fireTestRunStarted(description);
  }

  @Override
  public void fireTestRunFinished(Result result) {
    safely(() -> registry.testRunFinished(result));
    delegate.fireTestRunFinished(result);
  }

  @Override
  public void fireTestSuiteStarted(Description description) {
    safely(() -> registry.testSuiteStarted(description));
    delegate.fireTestSuiteStarted(description);
  }

  @Override
  public void fireTestSuiteFinished(Description description) {
    safely(() -> registry.testSuiteFinished(description));
    delegate.fireTestSuiteFinished(description);
  }

  @Override
  public void fireTestStarted(Description description) throws StoppedByUserException {
    safely(() -> registry.testStarted(description));
    delegate.fireTestStarted(description);
  }

  @Override
  public void fireTestFailure(Failure failure) {
    safely(() -> registry.testFailure(failure));
    delegate.fireTestFailure(failure);
  }

  @Override
  public void fireTestAssumptionFailed(Failure failure) {
    safely(() -> registry.testAssumptionFailure(failure));
    delegate.fireTestAssumptionFailed(failure);
  }

  @Override
  public void fireTestIgnored(Description description) {
    safely(() -> registry.testIgnored(description));
    delegate.fireTestIgnored(description);
  }

  @Override
  public void fireTestFinished(Description description) {
    safely(() -> registry.testFinished(description));
    delegate.fireTestFinished(description);
  }

  @Override
  public void addFirstListener(RunListener listener) {
    delegate.addFirstListener(listener);
  }

  @Override
  public void addListener(RunListener listener) {
    delegate.addListener(listener);
  }

  @Override
  public void removeListener(RunListener listener) {
    delegate.removeListener(listener);
  }

  @Override
  public void pleaseStop() {
    delegate.pleaseStop();
  }

  /**
   * Invoking a listener can throw an exception. If that happens catch it and forward it as an event
   */
  private void safely(ThrowingRunnable r) {
    try {
      r.run();
    } catch (Throwable t) {
      delegate.fireTestFailure(new Failure(null, t));
    }
  }
}
