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

package com.google.cloud.datastore.it;

import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;

public final class MultipleAttemptsRuleTest {

  private static final int NUMBER_OF_ATTEMPTS = 5;

  @Rule public MultipleAttemptsRule rr = new MultipleAttemptsRule(NUMBER_OF_ATTEMPTS, 10);

  private int numberAttempted = 0;

  @Test
  public void wontPassUntil5() {
    numberAttempted += 1;
    assertEquals(NUMBER_OF_ATTEMPTS, numberAttempted);
  }
}
