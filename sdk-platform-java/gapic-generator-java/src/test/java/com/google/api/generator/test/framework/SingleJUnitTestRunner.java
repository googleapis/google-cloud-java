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

package com.google.api.generator.test.framework;

import org.junit.runner.JUnitCore;
import org.junit.runner.Request;
import org.junit.runner.Result;

class SingleJUnitTestRunner {
  // SingleJUnitTestRunner runs single JUnit test whose class name is passed through `args`.
  // This is used to prepare codegen for updating goldens files.
  static void main(String... args) {
    // Check whether the test class name is passed correctly e.g.
    // `com.google.api.generator.gapic.composer.ComposerTest`
    if (args.length < 1) {
      throw new MissingRequiredArgException("Missing the JUnit class name argument.");
    }
    String className = args[0];
    Class<?> clazz = null;
    try {
      clazz = Class.forName(className);
    } catch (ClassNotFoundException e) {
      throw new JUnitClassNotFoundException(
          String.format("JUnit test class %s is not found.", className));
    }
    Result result = new JUnitCore().run(Request.aClass(clazz));
    if (!result.wasSuccessful()) {
      System.out.println("Tests have failures: " + result.getFailures());
    }
  }

  static class JUnitClassNotFoundException extends RuntimeException {
    JUnitClassNotFoundException(String errorMessage) {
      super(errorMessage);
    }
  }

  static class MissingRequiredArgException extends RuntimeException {
    MissingRequiredArgException(String errorMessage) {
      super(errorMessage);
    }
  }
}
