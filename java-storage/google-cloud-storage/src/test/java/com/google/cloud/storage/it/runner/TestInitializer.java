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

/**
 * JUnit test initialization is kinda racey due to its need for constructor super calls and calling
 * into instance methods from that constructor hierarchy.
 *
 * <p>This interface allows us to define an external composable means of initializing a single
 * instance of a test.
 *
 * <p>This class shouldn't be used outside of {@code com.google.cloud.storage.it.runner}. When we
 * have access to java modules this will be enforced.
 */
@FunctionalInterface
public interface TestInitializer {

  Object apply(Object o) throws Exception;

  default TestInitializer andThen(TestInitializer other) {
    return o -> other.apply(this.apply(o));
  }
}
