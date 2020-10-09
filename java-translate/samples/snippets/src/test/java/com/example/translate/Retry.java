/*
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.translate;

import java.util.Objects;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

public class Retry implements TestRule {
  private int maxAttempts;

  public Retry(int maxAttempts) {
    this.maxAttempts = maxAttempts;
  }

  @Override
  public Statement apply(Statement base, Description description) {
    return statement(base, description);
  }

  private Statement statement(final Statement base, final Description description) {
    return new Statement() {
      @Override
      public void evaluate() throws Throwable {
        Throwable caughtThrowable = null;

        // implement retry logic here
        int factor = 1;
        for (int attempt = 0; attempt < maxAttempts; attempt++) {
          try {
            base.evaluate();
            return;
          } catch (Throwable t) {
            caughtThrowable = t;

            // random_number_milliseconds that is less than or equal to 1000.
            int randomNumberMilliseconds = (int) Math.floor(Math.random() * 1000) + 1;
            Thread.sleep(1300 * factor + randomNumberMilliseconds);
            System.out.println(description.getDisplayName() + ": run " + (attempt + 1) + " failed");
            factor += 1;

          }
        }
        System.out.println(
            description.getDisplayName() + ": giving up after " + maxAttempts + " failures");
        throw Objects.requireNonNull(caughtThrowable);
      }
    };
  }
}
