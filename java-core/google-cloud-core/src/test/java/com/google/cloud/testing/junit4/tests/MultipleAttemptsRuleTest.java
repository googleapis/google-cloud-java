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

package com.google.cloud.testing.junit4.tests;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import com.google.cloud.testing.junit4.MultipleAttemptsRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runners.model.MultipleFailureException;
import org.junit.runners.model.Statement;

public final class MultipleAttemptsRuleTest {

  private static final int NUMBER_OF_ATTEMPTS = 5;

  @Rule public MultipleAttemptsRule rr = new MultipleAttemptsRule(NUMBER_OF_ATTEMPTS, 0);

  private int numberAttempted = 0;

  @Test
  public void wontPassUntil5() {
    numberAttempted += 1;
    assertEquals(NUMBER_OF_ATTEMPTS, numberAttempted);
  }

  @Test(expected = IllegalArgumentException.class)
  public void errorConstructing_attemptLessThan1() {
    new MultipleAttemptsRule(0);
  }

  @Test
  public void errorConstructing_attemptEquals1() {
    new MultipleAttemptsRule(1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void errorConstructing_attemptGreaterThanOrEqualTo1AndBackoffLessThan0() {
    new MultipleAttemptsRule(1, -1);
  }

  @Test
  public void errorConstructing_attemptGreaterThanOrEqualTo1AndBackoffEqualTo0() {
    new MultipleAttemptsRule(1, 0);
  }

  @Test
  public void allErrorPropagated() {
    MultipleAttemptsRule rule = new MultipleAttemptsRule(3, 0);
    Statement statement =
        rule.apply(
            new Statement() {
              private int counter = 1;

              @Override
              public void evaluate() {
                fail("attempt " + counter++);
              }
            },
            null);

    try {
      statement.evaluate();
    } catch (MultipleFailureException mfe) {
      // pass
      assertThat(mfe.getFailures()).hasSize(3);
    } catch (Throwable throwable) {
      fail("unexpected error: " + throwable.getMessage());
    }
  }
}
