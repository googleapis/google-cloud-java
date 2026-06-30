/*
 * Copyright 2021 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

class ExampleClass {
  /**
   * @deprecated sample has the same functionality as foobar.
   */
  @Deprecated
  public void cat(String bar) {
    for (int i = 0; i < 3; i++) {
      System.out.println("this is a test " + bar);
    }
  }

  /**
   * @deprecated This method will be removed in the next major version.
   *   Use {@link #sample()} instead
   */
  @Beta
  @Generated()
  @Deprecated
  public void foo(String bar) {
    for (int i = 0; i < 3; i++) {
      System.out.println("this is a test " + bar);
    }
  }

  /**
   * This is an existing comment.
   * @deprecated This method will be removed in the next major version.
   *   Use {@link #sample()} instead
   */
  @Deprecated
  public void bar(String bar) {
    for (int i = 0; i < 3; i++) {
      System.out.println("this is a test " + bar);
    }
  }
}
