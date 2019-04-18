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

import static com.google.common.util.concurrent.MoreExecutors.directExecutor;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutureCallback;
import com.google.api.core.ApiFutures;
import com.google.api.core.SettableApiFuture;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.Executor;
import java.util.logging.Level;
import java.util.logging.Logger;

interface CancellableRunnable extends Runnable {
  void cancel(Throwable e);
}

/**
 * An executor service that runs the tasks with the same key sequentially. The tasks with the same
 * key will be run only when its predecessor has been completed while tasks with different keys can
 * be run in parallel.
 */
final class SequentialExecutorService<T> {
  private static final Logger logger = Logger.getLogger(SequentialExecutorService.class.getName());

  private final CallbackExecutor callbackExecutor;
  private final AutoExecutor autoExecutor;

  SequentialExecutorService(Executor executor) {
    this.callbackExecutor = new CallbackExecutor(executor);
    this.autoExecutor = new AutoExecutor(executor);
  }

  /**
   * Runs asynchronous {@code Callable} tasks sequentially. If one of the tasks fails, other tasks
   * with the same key that have not been executed will be cancelled.
   */
  ApiFuture<T> submit(final String key, final Callable<ApiFuture> callable) {
    return callbackExecutor.submit(key, callable);
  }

  /** Runs synchronous {@code Runnable} tasks sequentially. */
  void submit(String key, Runnable runnable) {
    autoExecutor.execute(key, runnable);
  }

  /**
   * Internal implementation of SequentialExecutorService. Takes a serial stream of string keys and
   * {@code Runnable} tasks, and runs the tasks with the same key sequentially. Tasks with the same
   * key will be run only when its predecessor has been completed while tasks with different keys
   * can be run in parallel.
   */
  abstract static class SequentialExecutor {
    // Maps keys to tasks.
    protected final Map<String, Deque<Runnable>> tasksByKey;
    protected final Executor executor;

    private SequentialExecutor(Executor executor) {
      this.executor = executor;
      this.tasksByKey = new HashMap<>();
    }

    void execute(final String key, Runnable task) {
      Deque<Runnable> newTasks;
      synchronized (tasksByKey) {
        newTasks = tasksByKey.get(key);
        // If this key is already being handled, add it to the queue and return.
        if (newTasks != null) {
          newTasks.add(task);
          return;
        }

        newTasks = new ConcurrentLinkedDeque();
        newTasks.add(task);
        tasksByKey.put(key, newTasks);
      }

      execute(key, newTasks);
    }

    protected abstract void execute(String key, Deque<Runnable> finalTasks);

    protected void invokeCallback(final Deque<Runnable> tasks) {
      // TODO(kimkyung-goog): Check if there is a race when task list becomes empty.
      Runnable task = tasks.poll();
      if (task != null) {
        task.run();
      }
    }
  }

  private static class AutoExecutor extends SequentialExecutor {
    AutoExecutor(Executor executor) {
      super(executor);
    }

    protected void execute(final String key, final Deque<Runnable> finalTasks) {
      executor.execute(
          new Runnable() {
            @Override
            public void run() {
              invokeCallbackAndExecuteNext(key, finalTasks);
            }
          });
    }

    protected void invokeCallbackAndExecuteNext(final String key, final Deque<Runnable> tasks) {
      invokeCallback(tasks);
      synchronized (tasksByKey) {
        if (tasks.isEmpty()) {
          // Note that there can be a race if a task is added to `tasks` at this point. However,
          // tasks.add() is called only inside the block synchronized by `tasksByKey` object
          // in the execute() function. Therefore, we are safe to remove `tasks` here. This is not
          // optimal, but correct.
          tasksByKey.remove(key);
          return;
        }
      }
      executor.execute(
          new Runnable() {
            @Override
            public void run() {
              invokeCallbackAndExecuteNext(key, tasks);
            }
          });
    }
  }

  private static class CallbackExecutor extends SequentialExecutor {
    CallbackExecutor(Executor executor) {
      super(executor);
    }

    <T> ApiFuture<T> submit(final String key, final Callable<ApiFuture> callable) {
      final SettableApiFuture<T> future = SettableApiFuture.create();
      execute(
          key,
          new CancellableRunnable() {
            private boolean cancelled = false;

            @Override
            public void run() {
              if (cancelled) {
                return;
              }
              try {
                ApiFuture<T> callResult = callable.call();
                ApiFutures.addCallback(
                    callResult,
                    new ApiFutureCallback<T>() {
                      @Override
                      public void onSuccess(T msg) {
                        future.set(msg);
                        resume(key);
                      }

                      @Override
                      public void onFailure(Throwable e) {
                        future.setException(e);
                        cancelQueuedTasks(
                            key,
                            new CancellationException(
                                "Execution cancelled because executing previous runnable failed."));
                      }
                    },
                    directExecutor());
              } catch (Exception e) {
                future.setException(e);
              }
            }

            @Override
            public void cancel(Throwable e) {
              this.cancelled = true;
              future.setException(e);
            }
          });
      return future;
    }

    protected void execute(final String key, final Deque<Runnable> finalTasks) {
      executor.execute(
          new Runnable() {
            @Override
            public void run() {
              invokeCallback(finalTasks);
            }
          });
    }

    /** Executes the next queued task associated with {@code key}. */
    void resume(final String key) {
      Deque<Runnable> tasks;
      synchronized (tasksByKey) {
        tasks = tasksByKey.get(key);
        if (tasks == null) {
          return;
        }
        if (tasks.isEmpty()) {
          tasksByKey.remove(key);
          return;
        }
      }
      final Deque<Runnable> finalTasks = tasks;
      // Run the next task.
      executor.execute(
          new Runnable() {
            @Override
            public void run() {
              invokeCallback(finalTasks);
            }
          });
    }

    /** Cancels every task in the queue assoicated with {@code key}. */
    void cancelQueuedTasks(final String key, Throwable e) {
      // TODO(kimkyung-goog): Ensure execute() fails once cancelQueueTasks() has been ever invoked,
      // so that no more tasks are scheduled.
      synchronized (tasksByKey) {
        final Deque<Runnable> tasks = tasksByKey.get(key);
        if (tasks == null) {
          return;
        }
        while (!tasks.isEmpty()) {
          Runnable task = tasks.poll();
          if (task instanceof CancellableRunnable) {
            ((CancellableRunnable) task).cancel(e);
          } else {
            logger.log(
                Level.WARNING,
                "Attempted to cancel Runnable that was not CancellableRunnable; ignored.");
          }
        }
      }
    }
  }
}
