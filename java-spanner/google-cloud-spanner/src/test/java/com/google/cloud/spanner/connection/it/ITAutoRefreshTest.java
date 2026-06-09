/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.spanner.connection.it;

import com.google.cloud.spanner.ParallelIntegrationTest;
import com.google.cloud.spanner.Statement;
import com.google.cloud.spanner.connection.ITAbstractSpannerTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@Category(ParallelIntegrationTest.class)
@RunWith(JUnit4.class)
public class ITAutoRefreshTest extends ITAbstractSpannerTest {

  @Test
  public void testAutoRefresh() throws Exception {
    try (ITConnection connection = createConnection()) {
      System.out.println("Executing first query...");
      connection.execute(Statement.of("SELECT 1"));

      System.out.println("Sleeping for 5.5 minutes (330 seconds)...");
      Thread.sleep(330_000);

      System.out.println("Executing second query...");
      connection.execute(Statement.of("SELECT 1"));
      System.out.println("Success! The query succeeded after token expiration.");
    }
  }
}
