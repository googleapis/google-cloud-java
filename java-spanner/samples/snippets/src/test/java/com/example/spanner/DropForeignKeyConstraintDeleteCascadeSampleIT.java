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

package com.example.spanner;

import static org.junit.Assert.assertTrue;

import com.google.common.collect.Lists;
import com.google.spanner.admin.database.v1.CreateDatabaseRequest;
import com.google.spanner.admin.database.v1.InstanceName;
import java.util.concurrent.TimeUnit;
import org.junit.Test;

public class DropForeignKeyConstraintDeleteCascadeSampleIT extends SampleTestBaseV2 {

  @Test
  public void testDropForeignKeyConstraintDeleteCascade() throws Exception {

    // Creates database
    final String databaseId = idGenerator.generateDatabaseId();
    final CreateDatabaseRequest request =
        CreateDatabaseRequest.newBuilder()
            .setCreateStatement("CREATE DATABASE `" + databaseId + "`")
            .setParent(InstanceName.of(projectId, instanceId).toString())
            .addAllExtraStatements(Lists.newArrayList(
                "CREATE TABLE Customers (\n"
                    + "              CustomerId INT64 NOT NULL,\n"
                    + "              CustomerName STRING(62) NOT NULL,\n"
                    + "              ) PRIMARY KEY (CustomerId)",
                "CREATE TABLE ShoppingCarts (\n"
                    + "              CartId INT64 NOT NULL,\n"
                    + "              CustomerId INT64 NOT NULL,\n"
                    + "              CustomerName STRING(62) NOT NULL,\n"
                    + "              CONSTRAINT FKShoppingCartsCustomerName"
                    + " FOREIGN KEY (CustomerName)\n"
                    + "              REFERENCES Customers (CustomerName) ON DELETE CASCADE\n"
                    + "              ) PRIMARY KEY (CartId)\n")).build();
    databaseAdminClient.createDatabaseAsync(request).get(5, TimeUnit.MINUTES);

    // Runs sample
    final String out =
        SampleRunner.runSample(
            () ->
                DropForeignKeyConstraintDeleteCascadeSample.deleteForeignKeyDeleteCascadeConstraint(
                    projectId, instanceId, databaseId));

    assertTrue(
        "Expected to have dropped foreign-key constraints from tables in created database "
            + databaseId,
        out.contains("Altered ShoppingCarts table to drop FKShoppingCartsCustomerName"));
  }
}
