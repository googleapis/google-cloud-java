/*
 * Copyright 2025 Google LLC
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

package com.example.spanner;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class QueueSampleIT extends SampleTestBase {

  @Test
  public void testQueueSample() throws Exception {
    final String databaseId = idGenerator.generateDatabaseId();

    final String out =
        SampleRunner.runSample(
            () ->
                QueueSample.main(
                    new String[] {
                      projectId, instanceId, databaseId
                    }));

    assertTrue(out.contains("Creating database with a queue..."));
    assertTrue(out.contains("Created database ["));
    assertTrue(out.contains("Sending a message to queue using Mutation API..."));
    assertTrue(out.contains("Sending a message to queue using SQL API..."));
    assertTrue(out.contains("Sending a message to queue using Mutation API in the future..."));
    assertTrue(out.contains("Sending a message to queue using SQL API in the future..."));
    assertTrue(out.contains("Acknowledging a message using Mutation API..."));
    assertTrue(out.contains("Acknowledging a message using SQL API with ASSERT_ROWS_MODIFIED..."));
    assertTrue(out.contains("Deleting a message using SQL API..."));
    assertTrue(out.contains("Sending and receiving a message using SQL API..."));
    assertTrue(out.contains("Received message ID: 5"));
  }
}
