/*
 * Copyright 2023 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.datastore.it;

import static java.util.concurrent.TimeUnit.SECONDS;

import com.google.cloud.Tuple;
import com.google.cloud.datastore.DatastoreException;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeoutException;

/**
 * An executor class to handle interleaved transactions.
 *
 * <p>It executes statements (under multiple transactions) and record their failures under a groupId
 * provided by users.
 */
class StatementExecutor {

  private final Multimap<String, Exception> failures = ArrayListMultimap.create();

  /**
   * Executes a list of {@link Statement} one by one and record their failures under the groupId. In
   * case of pessimistic concurrency, a statement will be blocked and cause delay until another
   * transaction which was started earlier is committed. In case of optimistic concurrency, both
   * transaction can perform their operation simultaneously, but the one which commits first will be
   * a winner and other one will get an error on commit operation indicating a need for retry.
   *
   * @param tuples A {@link Statement(String, String) Tuple(&lt;String, Statement&gt;)} has a
   *     groupId of {@link String} type and a {@link Statement} to execute.
   */
  @SafeVarargs
  final void execute(Tuple<String, Statement>... tuples) throws Exception {
    ExecutorService executorService = Executors.newSingleThreadExecutor();
    for (Tuple<String, Statement> tuple : tuples) {
      String groupId = tuple.x();
      Statement statement = tuple.y();
      Future<?> future = executorService.submit(statement::execute);
      try {
        // waiting for statement to execute
        future.get(10, SECONDS);
      } catch (Exception exception) {
        future.cancel(true);
        if (transactionConflict(exception)) {
          failures.put(groupId, exception);
        } else {
          throw exception;
        }
      }
    }
    executorService.shutdown();
  }

  boolean didAllPass(String groupId) {
    return failures.get(groupId).isEmpty();
  }

  private boolean transactionConflict(Exception exception) {
    if (exception instanceof TimeoutException) { // timed out coz of pessimistic concurrency delay
      return true;
    }
    return exception instanceof ExecutionException
        && exception.getCause().getClass() == DatastoreException.class
        && (exception.getMessage().contains("contention")
            || exception
                .getMessage()
                .contains("Conflict")); // exception raise coz of optimistic concurrency
  }

  interface Statement {
    void execute();
  }
}
