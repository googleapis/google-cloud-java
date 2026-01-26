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

package com.example.datastore.filters;

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
public class MultiIneqQuerySampleIT {

  private final Datastore datastore = DatastoreOptions.getDefaultInstance().getService();

  private Key employeeKey1;
  private Key employeeKey2;
  private Key employeeKey3;

  @Rule public final SystemsOutRule systemsOutRule = new SystemsOutRule();

  @Before
  public void setUp() {
    employeeKey1 = datastore.newKeyFactory().setKind("employees").newKey("employee1");
    Entity employee1 =
        Entity.newBuilder(employeeKey1)
            .set("name", "Alice")
            .set("salary", 100001)
            .set("experience", 10)
            .build();

    employeeKey2 = datastore.newKeyFactory().setKind("employees").newKey("employee2");
    Entity employee2 =
        Entity.newBuilder(employeeKey2)
            .set("name", "Bob")
            .set("salary", 90000)
            .set("experience", 5)
            .build();

    employeeKey3 = datastore.newKeyFactory().setKind("employees").newKey("employee3");
    Entity employee3 =
        Entity.newBuilder(employeeKey3)
            .set("name", "Jay")
            .set("salary", 120000)
            .set("experience", 15)
            .build();

    datastore.put(employee1);
    datastore.put(employee2);
    datastore.put(employee3);
  }

  @After
  public void tearDown() {
    datastore.delete(employeeKey1);
    datastore.delete(employeeKey2);
    datastore.delete(employeeKey3);
  }

  @Test
  public void testIndexingConsiderationQuery() throws Exception {
    // Act
    IndexingConsiderationQuery.invoke();

    // Assert
    systemsOutRule.assertContains("Entity");
  }

  @Test
  public void testOrderFieldsQuery() throws Exception {
    // Act
    OrderFieldsQuery.invoke();

    // Assert
    systemsOutRule.assertContains("Entity");
  }
}
