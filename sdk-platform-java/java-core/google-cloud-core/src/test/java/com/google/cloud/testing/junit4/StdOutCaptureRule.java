/*
 * Copyright 2020 Google LLC
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

package com.google.cloud.testing.junit4;

import java.io.PrintStream;
import org.junit.Rule;

/**
 * A JUnit rule that allows the capturing stdout (i.e. {@link System#out} during the scope of a
 * test.
 *
 * <p><i>Note: If some part of the system holds a reference System.out before this rule is loaded
 * into the test lifecycle there is no way for this rule to capture the output. Ensure this rule is
 * declared as high in your test file as possible, and ordered using {@link Rule#order()} before
 * other Rules if necessary.</i>
 *
 * <p>To use this rule add the field declaration to your JUnit 4 Test class:
 *
 * <p><i>Note: It is important that the field is public</i>
 *
 * <pre>{@code
 * @Rule
 * public StdOutCaptureRule stdOutCaptureRule = new StdOutCaptureRule();
 * }</pre>
 *
 * @see org.junit.Rule
 * @see Rule#order()
 */
public final class StdOutCaptureRule extends StdXCaptureRule {

  public StdOutCaptureRule() {}

  @Override
  protected PrintStream getOriginal() {
    return System.out;
  }

  @Override
  protected void set(PrintStream ps) {
    System.setOut(ps);
  }
}
