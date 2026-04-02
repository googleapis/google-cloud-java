/*
 * Copyright 2024 Google LLC
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

package com.google.cloud.spanner.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

/**
 * Simple Java application that is used to verify the working of the single-jar-with-dependencies.
 */
public class SingleJarTestApplication {

  public static void main(String[] args) throws Exception {
    if (args.length != 3) {
      throw new IllegalArgumentException("expected 3 arguments");
    }
    String project = args[0];
    String instance = args[1];
    String database = args[2];
    String extraOptions = "";
    String host = "";
    if (System.getenv("SPANNER_EMULATOR_HOST") != null) {
      extraOptions = "?autoConfigEmulator=true";
      host = "//" + System.getenv("SPANNER_EMULATOR_HOST");
    }

    try (Connection connection =
        DriverManager.getConnection(
            String.format(
                "jdbc:cloudspanner:%s/projects/%s/instances/%s/databases/%s%s",
                host, project, instance, database, extraOptions))) {
      try (ResultSet resultSet =
          connection.createStatement().executeQuery("select 'Hello World from Real Spanner!'")) {
        while (resultSet.next()) {
          System.out.println(resultSet.getString(1));
        }
      }
    }
  }
}
