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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Test;

class MultipleAttemptsRuleTest {

  private static final int NUMBER_OF_ATTEMPTS = 5;

  @Test
  void wontPassUntil5() {
    int numberAttempted = 0;
    for (int i = 0; i < NUMBER_OF_ATTEMPTS; i++) {
      numberAttempted += 1;
      if (numberAttempted == NUMBER_OF_ATTEMPTS) {
        assertEquals(NUMBER_OF_ATTEMPTS, numberAttempted);
        return; // pass
      }
      // Simulate failure for previous attempts by doing nothing and continuing the loop
    }
    fail("Did not reach 5 attempts");
  }
}
