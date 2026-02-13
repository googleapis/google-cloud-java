/*
 * Copyright 2024 Google LLC
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

package com.example.datastore.queryprofile;

import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.Key;
import com.rule.SystemsOutRule;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
@SuppressWarnings("checkstyle:abbreviationaswordinname")
public class QueryProfileSampleIT {

  private final Datastore datastore = DatastoreOptions.getDefaultInstance().getService();
  private final String fieldName = "description";

  private Key taskKey1;
  private Key taskKey2;

  @Rule public final SystemsOutRule systemsOutRule = new SystemsOutRule();

  @Before
  public void setUp() {
    taskKey1 = datastore.newKeyFactory().setKind("Task").newKey("sampleTask");
    Entity task1 = Entity.newBuilder(taskKey1).set(fieldName, "Buy milk").build();

    taskKey2 = datastore.newKeyFactory().setKind("Task").newKey("sampleTask2");
    Entity task2 = Entity.newBuilder(taskKey2).set(fieldName, "Feed cats").build();

    datastore.put(task1);
    datastore.put(task2);
  }

  @After
  public void tearDown() {
    datastore.delete(taskKey1);
    datastore.delete(taskKey2);
  }

  @Test
  public void testQueryProfileExplain() throws Exception {
    // Act
    QueryProfileExplain.invoke();

    // Assert
    systemsOutRule.assertContains("query_scope: Collection group");
    systemsOutRule.assertContains("properties: (__name__ ASC)");
  }

  @Test
  public void testQueryProfileExplainAggregation() throws Exception {
    // Act
    QueryProfileExplainAggregation.invoke();

    // Assert
    systemsOutRule.assertContains("query_scope: Collection group");
    systemsOutRule.assertContains("properties: (__name__ ASC)");
  }

  @Test
  public void testQueryProfileExplainAnalyze() throws Exception {
    // Act
    QueryProfileExplainAnalyze.invoke();

    // Assert
    systemsOutRule.assertContains("documents_scanned:");
    systemsOutRule.assertContains("index_entries_scanned:");
    systemsOutRule.assertContains("query_scope: Collection group");
    systemsOutRule.assertContains("Entity: Entity{key=");
  }

  @Test
  public void testQueryProfileExplainAnalyzeAggregation() throws Exception {
    // Act
    QueryProfileExplainAnalyzeAggregation.invoke();

    // Assert
    systemsOutRule.assertContains("index_entries_scanned:");
    systemsOutRule.assertContains("documents_scanned:");
    systemsOutRule.assertContains("query_scope: Collection group");
    systemsOutRule.assertContains("Count: 2");
  }
}
