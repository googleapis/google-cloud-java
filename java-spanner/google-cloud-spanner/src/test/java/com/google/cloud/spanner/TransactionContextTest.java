/*
 * Copyright 2021 Google LLC
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

package com.google.cloud.spanner;

import static org.junit.Assert.assertThrows;

import com.google.api.core.ApiFuture;
import com.google.cloud.spanner.Options.QueryOption;
import com.google.cloud.spanner.Options.ReadOption;
import com.google.cloud.spanner.Options.UpdateOption;
import java.util.Collections;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class TransactionContextTest {

  @Test
  public void testDefaultImplementations() {
    try (TransactionContext context =
        new TransactionContext() {
          @Override
          public AsyncResultSet readUsingIndexAsync(
              String table,
              String index,
              KeySet keys,
              Iterable<String> columns,
              ReadOption... options) {
            return null;
          }

          @Override
          public ResultSet readUsingIndex(
              String table,
              String index,
              KeySet keys,
              Iterable<String> columns,
              ReadOption... options) {
            return null;
          }

          @Override
          public ApiFuture<Struct> readRowUsingIndexAsync(
              String table, String index, Key key, Iterable<String> columns) {
            return null;
          }

          @Override
          public Struct readRowUsingIndex(
              String table, String index, Key key, Iterable<String> columns) {
            return null;
          }

          @Override
          public ApiFuture<Struct> readRowAsync(String table, Key key, Iterable<String> columns) {
            return null;
          }

          @Override
          public Struct readRow(String table, Key key, Iterable<String> columns) {
            return null;
          }

          @Override
          public AsyncResultSet readAsync(
              String table, KeySet keys, Iterable<String> columns, ReadOption... options) {
            return null;
          }

          @Override
          public ResultSet read(
              String table, KeySet keys, Iterable<String> columns, ReadOption... options) {
            return null;
          }

          @Override
          public AsyncResultSet executeQueryAsync(Statement statement, QueryOption... options) {
            return null;
          }

          @Override
          public ResultSet executeQuery(Statement statement, QueryOption... options) {
            return null;
          }

          @Override
          public void close() {}

          @Override
          public ResultSet analyzeQuery(Statement statement, QueryAnalyzeMode queryMode) {
            return null;
          }

          @Override
          public ApiFuture<Long> executeUpdateAsync(Statement statement, UpdateOption... options) {
            return null;
          }

          @Override
          public ResultSet analyzeUpdateStatement(
              Statement statement, QueryAnalyzeMode analyzeMode, UpdateOption... options) {
            return null;
          }

          @Override
          public long executeUpdate(Statement statement, UpdateOption... options) {
            return 0;
          }

          @Override
          public void buffer(Iterable<Mutation> mutations) {}

          @Override
          public void buffer(Mutation mutation) {}

          @Override
          public ApiFuture<long[]> batchUpdateAsync(
              Iterable<Statement> statements, UpdateOption... options) {
            return null;
          }

          @Override
          public long[] batchUpdate(Iterable<Statement> statements, UpdateOption... options) {
            return null;
          }
        }) {
      assertThrows(
          UnsupportedOperationException.class,
          () -> context.bufferAsync(Mutation.delete("foo", KeySet.all())));
      assertThrows(
          UnsupportedOperationException.class,
          () -> context.bufferAsync(Collections.singleton(Mutation.delete("foo", KeySet.all()))));
    }
  }
}
