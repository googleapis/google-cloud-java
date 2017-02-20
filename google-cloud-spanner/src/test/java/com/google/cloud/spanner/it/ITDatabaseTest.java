/*
 * Copyright 2017 Google Inc. All Rights Reserved.
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

package com.google.cloud.spanner.it;

import static com.google.cloud.spanner.SpannerMatchers.isSpannerException;

import com.google.cloud.spanner.ErrorCode;
import com.google.cloud.spanner.IntegrationTest;
import com.google.cloud.spanner.IntegrationTestEnv;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/** Integration tests for database admin functionality: DDL etc. */
@Category(IntegrationTest.class)
@RunWith(JUnit4.class)
public class ITDatabaseTest {
  @ClassRule public static IntegrationTestEnv env = new IntegrationTestEnv();
  @Rule public ExpectedException expectedException = ExpectedException.none();

  @Test
  public void badDdl() {
    expectedException.expect(isSpannerException(ErrorCode.INVALID_ARGUMENT));
    expectedException.expectMessage("Syntax error on line 1");

    env.getTestHelper().createTestDatabase("CREATE TABLE T ( Illegal Way To Define A Table )");
  }
}
