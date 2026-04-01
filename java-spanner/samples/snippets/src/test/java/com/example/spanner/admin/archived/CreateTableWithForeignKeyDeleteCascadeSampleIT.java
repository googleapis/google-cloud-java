/*
 * Copyright 2023 Google LLC
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

package com.example.spanner.admin.archived;

import static org.junit.Assert.assertTrue;

import com.example.spanner.SampleRunner;
import com.example.spanner.SampleTestBase;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import org.junit.Test;

public class CreateTableWithForeignKeyDeleteCascadeSampleIT extends SampleTestBase {

  @Test
  public void testCreateTableWithForeignKeyDeleteCascade() throws Exception {

    // Creates database
    final String databaseId = idGenerator.generateDatabaseId();
    databaseAdminClient
        .createDatabase(instanceId, databaseId, Arrays.asList())
        .get(5, TimeUnit.MINUTES);

    // Runs sample
    final String out =
        SampleRunner.runSample(
            () ->
                CreateTableWithForeignKeyDeleteCascadeSample
                    .createForeignKeyDeleteCascadeConstraint(
                        databaseAdminClient, instanceId, databaseId));

    assertTrue(
        "Expected to have created database "
            + databaseId
            + " with tables containing "
            + "foreign key constraints.",
        out.contains(
            "Created Customers and ShoppingCarts table " + "with FKShoppingCartsCustomerId"));
  }
}
