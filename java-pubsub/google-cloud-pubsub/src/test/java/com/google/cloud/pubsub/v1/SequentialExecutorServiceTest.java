/*
 * Copyright 2019 Google LLC
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

package com.google.cloud.pubsub.v1;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import com.google.api.core.ApiFuture;
import com.google.api.core.SettableApiFuture;
import com.google.api.gax.core.ExecutorProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.common.collect.ImmutableList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public final class SequentialExecutorServiceTest {
  private final ExecutorProvider executorProvider =
      InstantiatingExecutorProvider.newBuilder()
          .setExecutorThreadCount(5 * Runtime.getRuntime().availableProcessors())
          .build();

  static class AsyncTaskCallable implements Callable<ApiFuture<String>> {
    boolean isCalled = false;
    SettableApiFuture<String> result = SettableApiFuture.create();

    @Override
    public ApiFuture<String> call() {
      isCalled = true;
      return result;
    }

    public boolean isCalled() {
      return isCalled;
    }

    public void finishWithError(Throwable e) {
      result.setException(e);
    }

    public void finish() {
      result.set("ok");
    }
  }

  @Test
  public void testExecutorRunsNextTaskWhenPrevResponseReceived() throws Exception {
    SequentialExecutorService.CallbackExecutor sequentialExecutorService =
        new SequentialExecutorService.CallbackExecutor(executorProvider.getExecutor());
    AsyncTaskCallable callable1 = new AsyncTaskCallable();
    AsyncTaskCallable callable2 = new AsyncTaskCallable();
    AsyncTaskCallable callable3 = new AsyncTaskCallable();

    ApiFuture<String> result1 = sequentialExecutorService.submit("key", callable1);
    ApiFuture<String> result2 = sequentialExecutorService.submit("key", callable2);
    ApiFuture<String> result3 = sequentialExecutorService.submit("key", callable3);

    Thread.sleep(1000);
    assertFalse(callable2.isCalled());
    assertFalse(callable3.isCalled());
    callable1.finish();
    assertEquals("ok", result1.get());

    assertFalse(callable3.isCalled());
    callable2.finish();
    assertEquals("ok", result2.get());

    callable3.finish();
    assertEquals("ok", result3.get());
  }

  @Test
  public void testExecutorRunsDifferentKeySimultaneously() throws Exception {
    SequentialExecutorService.CallbackExecutor sequentialExecutorService =
        new SequentialExecutorService.CallbackExecutor(executorProvider.getExecutor());
    AsyncTaskCallable callable1 = new AsyncTaskCallable();
    AsyncTaskCallable callable2 = new AsyncTaskCallable();
    AsyncTaskCallable callable3 = new AsyncTaskCallable();

    // Submit three tasks (two tasks with "key", and one task with "key2").
    ApiFuture<String> result1 = sequentialExecutorService.submit("key", callable1);
    ApiFuture<String> result2 = sequentialExecutorService.submit("key", callable2);
    ApiFuture<String> result3 = sequentialExecutorService.submit("key2", callable3);

    // The task associated with "key2" can be run in parallel with other tasks with "key".
    callable3.finish();
    assertEquals("ok", result3.get());

    // Sleep some time to give the test a chance to fail. Verify that the second task has not been
    // executed while the main thread is slpeeing.
    Thread.sleep(100);
    assertFalse(callable2.isCalled());
    // Complete the first task.
    callable1.finish();
    assertEquals("ok", result1.get());
    // Now, the second task can be executed.
    callable2.finish();
    assertEquals("ok", result2.get());
  }

  @Test
  public void testExecutorCancelsAllTasksWhenOneFailed() throws Exception {
    SequentialExecutorService.CallbackExecutor sequentialExecutorService =
        new SequentialExecutorService.CallbackExecutor(executorProvider.getExecutor());
    AsyncTaskCallable callable1 = new AsyncTaskCallable();
    AsyncTaskCallable callable2 = new AsyncTaskCallable();
    AsyncTaskCallable callable3 = new AsyncTaskCallable();

    ApiFuture<String> result1 = sequentialExecutorService.submit("key", callable1);
    ApiFuture<String> result2 = sequentialExecutorService.submit("key", callable2);
    ApiFuture<String> result3 = sequentialExecutorService.submit("key", callable3);

    Throwable failure = new Exception("failure");
    callable1.finishWithError(failure);
    // The failed task throws an exception that contains the cause of the failure.
    try {
      result1.get();
      fail("Should have thrown an ExecutionException");
    } catch (ExecutionException e) {
      assertEquals(failure, e.getCause());
    }
    // Other tasks in the queue are expected to fail with a CancellationException.
    for (ApiFuture<String> result : ImmutableList.of(result2, result3)) {
      try {
        result.get();
        fail("Should have thrown an ExecutionException");
      } catch (ExecutionException e) {
        assertThat(e.getCause()).isInstanceOf(CancellationException.class);
      }
    }
  }

  /**
   * A task that sleeps {@code taskDurationMillis} milliseconds. Appends its {@code taskId} to
   * {@code startedTasksSequence} before sleeping and appends it to {@code completedTasksSequence}
   * when sleeping is done.
   */
  static class SleepingSyncTask implements Runnable {
    private final int taskId;
    private final long taskDurationMillis;
    private final LinkedHashSet<Integer> startedTasksSequence;
    private final LinkedHashSet<Integer> completedTasksSequence;
    private final CountDownLatch remainingTasksCount;

    public SleepingSyncTask(
        int taskId,
        long taskDurationMillis,
        LinkedHashSet<Integer> startedTasksSequence,
        LinkedHashSet<Integer> completedTasksSequence,
        CountDownLatch remainingTasksCount) {
      this.taskId = taskId;
      this.taskDurationMillis = taskDurationMillis;
      this.startedTasksSequence = startedTasksSequence;
      this.completedTasksSequence = completedTasksSequence;
      this.remainingTasksCount = remainingTasksCount;
    }

    @Override
    public void run() {
      if (taskId > 0) {
        // Verify that the previous task has been completed.
        assertTrue(startedTasksSequence.contains(taskId - 1));
        assertTrue(completedTasksSequence.contains(taskId - 1));
      }
      startedTasksSequence.add(taskId);
      try {
        Thread.sleep(taskDurationMillis);
      } catch (InterruptedException e) {
        return;
      }
      completedTasksSequence.add(taskId);
      remainingTasksCount.countDown();

      // Verify that the next task has not been started yet.
      assertFalse(startedTasksSequence.contains(taskId + 1));
      assertFalse(completedTasksSequence.contains(taskId + 1));
    }
  }

  @Test
  public void SequentialExecutorRunsTasksAutomatically() throws Exception {
    int numKeys = 50;
    int numTasks = 50;
    SequentialExecutorService.AutoExecutor sequentialExecutor =
        new SequentialExecutorService.AutoExecutor(executorProvider.getExecutor());
    CountDownLatch remainingTasksCount = new CountDownLatch(numKeys * numTasks);
    // Maps keys to lists of started and completed tasks.
    Map<String, LinkedHashSet<Integer>> startedTasks = new HashMap<>();
    Map<String, LinkedHashSet<Integer>> completedTasks = new HashMap<>();

    for (int i = 0; i < numKeys; i++) {
      String key = "key" + i;
      LinkedHashSet<Integer> startedTasksSequence = new LinkedHashSet<>();
      LinkedHashSet<Integer> completedTasksSequence = new LinkedHashSet<>();
      startedTasks.put(key, completedTasksSequence);
      completedTasks.put(key, completedTasksSequence);
      for (int taskId = 0; taskId < numTasks; taskId++) {
        SleepingSyncTask task =
            new SleepingSyncTask(
                taskId, 5, startedTasksSequence, completedTasksSequence, remainingTasksCount);
        sequentialExecutor.submit(key, task);
      }
    }

    remainingTasksCount.await();

    for (int i = 0; i < numKeys; i++) {
      LinkedHashSet<Integer> startedTasksSequence = startedTasks.get("key" + i);
      LinkedHashSet<Integer> completedTasksSequence = completedTasks.get("key" + i);
      // Verify that the tasks have been started and completed in order.
      int expectedTaskId = 0;
      Iterator<Integer> it1 = startedTasksSequence.iterator();
      Iterator<Integer> it2 = completedTasksSequence.iterator();
      while (it1.hasNext() && it2.hasNext()) {
        assertEquals(expectedTaskId, it1.next().intValue());
        assertEquals(expectedTaskId, it2.next().intValue());
        expectedTaskId++;
      }
    }
  }
}
