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

package com.google.cloud.spanner.connection;

import com.google.cloud.spanner.Dialect;
import com.google.cloud.spanner.Statement;
import com.google.cloud.spanner.connection.AbstractStatementParser.ParsedStatement;
import com.google.spanner.v1.ExecuteSqlRequest.QueryOptions;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Warmup;

@Fork(value = 1, warmups = 0)
@Warmup(iterations = 1, time = 5)
@Measurement(iterations = 5, time = 5)
public class StatementParserBenchmark {
  private static final Dialect dialect = Dialect.POSTGRESQL;
  private static final AbstractStatementParser PARSER =
      AbstractStatementParser.getInstance(dialect);

  private static final String LONG_QUERY_TEXT =
      generateLongStatement("SELECT * FROM foo WHERE 1", 100 * 1024); // 100kb

  private static final String LONG_DML_TEXT =
      generateLongStatement("update foo set bar=1 WHERE 1", 100 * 1024); // 100kb

  /** Generates a long SQL-looking string. */
  private static String generateLongStatement(String prefix, int length) {
    StringBuilder sb = new StringBuilder(length + 50);
    sb.append(prefix);
    while (sb.length() < length) {
      sb.append(" OR abcdefghijklmnopqrstuvwxyz='abcdefghijklmnopqrstuvwxyz'");
    }
    return sb.toString();
  }

  @Benchmark
  public ParsedStatement isQueryTest() {
    return PARSER.internalParse(
        Statement.of("CREATE TABLE FOO (ID INT64, NAME STRING(100)) PRIMARY KEY (ID)"),
        QueryOptions.getDefaultInstance());
  }

  @Benchmark
  public ParsedStatement longQueryTest() {
    return PARSER.internalParse(Statement.of(LONG_QUERY_TEXT), QueryOptions.getDefaultInstance());
  }

  @Benchmark
  public ParsedStatement longDmlTest() {
    return PARSER.internalParse(Statement.of(LONG_DML_TEXT), QueryOptions.getDefaultInstance());
  }

  public static void main(String[] args) throws Exception {
    for (int i = 0; i < 100000; i++) {
      if (PARSER.internalParse(Statement.of(LONG_QUERY_TEXT), QueryOptions.getDefaultInstance())
          == null) {
        throw new AssertionError();
      }
      if (PARSER.internalParse(Statement.of(LONG_DML_TEXT), QueryOptions.getDefaultInstance())
          == null) {
        throw new AssertionError();
      }
    }
  }
}
