/*
 * Copyright 2023 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.grpc;

import static org.easymock.EasyMock.*;
import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.concurrent.Delayed;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import org.easymock.EasyMock;
import org.easymock.IAnswer;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * This class was copied from grpc-core to prevent dependence on an unstable API that may be subject
 * to changes
 * (https://github.com/grpc/grpc-java/blob/d07ecbe037d2705a1c9f4b6345581f860e505b56/core/src/test/java/io/grpc/internal/SharedResourceHolderTest.java)
 *
 * <p>Unit tests for {@link SharedResourceHolder}.
 */
@RunWith(JUnit4.class)
public class SharedResourceHolderTest {

  private final LinkedList<MockScheduledFuture<?>> scheduledDestroyTasks = new LinkedList<>();

  private SharedResourceHolder holder;

  private static class ResourceInstance {
    volatile boolean closed;
  }

  private static class ResourceFactory implements SharedResourceHolder.Resource<ResourceInstance> {
    @Override
    public ResourceInstance create() {
      return new ResourceInstance();
    }

    @Override
    public void close(ResourceInstance instance) {
      instance.closed = true;
    }
  }

  // Defines two kinds of resources
  private static final SharedResourceHolder.Resource<ResourceInstance> SHARED_FOO =
      new ResourceFactory();
  private static final SharedResourceHolder.Resource<ResourceInstance> SHARED_BAR =
      new ResourceFactory();

  @Before
  public void setUp() {
    holder = new SharedResourceHolder(new MockExecutorFactory());
  }

  @Test
  public void destroyResourceWhenRefCountReachesZero() {
    ResourceInstance foo1 = holder.getInternal(SHARED_FOO);
    ResourceInstance sharedFoo = foo1;
    ResourceInstance foo2 = holder.getInternal(SHARED_FOO);
    assertSame(sharedFoo, foo2);

    ResourceInstance bar1 = holder.getInternal(SHARED_BAR);
    ResourceInstance sharedBar = bar1;

    foo2 = holder.releaseInternal(SHARED_FOO, foo2);
    // foo refcount not reached 0, thus shared foo is not closed
    assertTrue(scheduledDestroyTasks.isEmpty());
    assertFalse(sharedFoo.closed);
    assertNull(foo2);

    foo1 = holder.releaseInternal(SHARED_FOO, foo1);
    assertNull(foo1);

    // foo refcount has reached 0, a destroying task is scheduled
    assertEquals(1, scheduledDestroyTasks.size());
    MockScheduledFuture<?> scheduledDestroyTask = scheduledDestroyTasks.poll();
    assertEquals(
        SharedResourceHolder.DESTROY_DELAY_SECONDS,
        scheduledDestroyTask.getDelay(TimeUnit.SECONDS));

    // Simluate that the destroyer executes the foo destroying task
    scheduledDestroyTask.runTask();
    assertTrue(sharedFoo.closed);

    // After the destroying, obtaining a foo will get a different instance
    ResourceInstance foo3 = holder.getInternal(SHARED_FOO);
    assertNotSame(sharedFoo, foo3);

    holder.releaseInternal(SHARED_BAR, bar1);

    // bar refcount has reached 0, a destroying task is scheduled
    assertEquals(1, scheduledDestroyTasks.size());
    scheduledDestroyTask = scheduledDestroyTasks.poll();
    assertEquals(
        SharedResourceHolder.DESTROY_DELAY_SECONDS,
        scheduledDestroyTask.getDelay(TimeUnit.SECONDS));

    // Simulate that the destroyer executes the bar destroying task
    scheduledDestroyTask.runTask();
    assertTrue(sharedBar.closed);
  }

  @Test
  public void cancelDestroyTask() {
    ResourceInstance foo1 = holder.getInternal(SHARED_FOO);
    ResourceInstance sharedFoo = foo1;
    holder.releaseInternal(SHARED_FOO, foo1);
    // A destroying task for foo is scheduled
    MockScheduledFuture<?> scheduledDestroyTask = scheduledDestroyTasks.poll();
    assertFalse(scheduledDestroyTask.cancelled);

    // obtaining a foo before the destroying task is executed will cancel the destroy
    ResourceInstance foo2 = holder.getInternal(SHARED_FOO);
    assertTrue(scheduledDestroyTask.cancelled);
    assertTrue(scheduledDestroyTasks.isEmpty());
    assertFalse(sharedFoo.closed);

    // And it will be the same foo instance
    assertSame(sharedFoo, foo2);

    // Release it and the destroying task is scheduled again
    holder.releaseInternal(SHARED_FOO, foo2);
    scheduledDestroyTask = scheduledDestroyTasks.poll();
    assertNotNull(scheduledDestroyTask);
    assertFalse(scheduledDestroyTask.cancelled);
    scheduledDestroyTask.runTask();
    assertTrue(sharedFoo.closed);
  }

  @Test
  public void releaseWrongInstance() {
    ResourceInstance uncached = new ResourceInstance();
    try {
      holder.releaseInternal(SHARED_FOO, uncached);
      fail("Should throw IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      // expected
    }
    ResourceInstance cached = holder.getInternal(SHARED_FOO);
    try {
      holder.releaseInternal(SHARED_FOO, uncached);
      fail("Should throw IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      // expected
    }
    holder.releaseInternal(SHARED_FOO, cached);
  }

  @Test
  public void overreleaseInstance() {
    ResourceInstance foo1 = holder.getInternal(SHARED_FOO);
    holder.releaseInternal(SHARED_FOO, foo1);
    try {
      holder.releaseInternal(SHARED_FOO, foo1);
      fail("Should throw IllegalStateException");
    } catch (IllegalStateException e) {
      // expected
    }
  }

  @Test
  public void handleInstanceCloseError() {
    class ExceptionOnCloseResource implements SharedResourceHolder.Resource<ResourceInstance> {
      @Override
      public ResourceInstance create() {
        return new ResourceInstance();
      }

      @Override
      public void close(ResourceInstance instance) {
        throw new RuntimeException();
      }
    }

    SharedResourceHolder.Resource<ResourceInstance> resource = new ExceptionOnCloseResource();
    ResourceInstance instance = holder.getInternal(resource);
    holder.releaseInternal(resource, instance);
    MockScheduledFuture<?> scheduledDestroyTask = scheduledDestroyTasks.poll();
    try {
      scheduledDestroyTask.runTask();
      fail("Should throw RuntimeException");
    } catch (RuntimeException e) {
      // expected
    }

    // Future resource fetches should not get the partially-closed one.
    assertNotSame(instance, holder.getInternal(resource));
  }

  private class MockExecutorFactory implements SharedResourceHolder.ScheduledExecutorFactory {
    @Override
    public ScheduledExecutorService createScheduledExecutor() {
      ScheduledExecutorService mockExecutor = createNiceMock(ScheduledExecutorService.class);
      expect(mockExecutor.schedule(anyObject(Runnable.class), anyLong(), anyObject(TimeUnit.class)))
          .andAnswer(
              new IAnswer() {
                @Override
                public ScheduledFuture<?> answer() throws Throwable {
                  Object[] args = EasyMock.getCurrentArguments();
                  Runnable command = (Runnable) args[0];
                  long delay = (Long) args[1];
                  TimeUnit unit = (TimeUnit) args[2];
                  MockScheduledFuture<Void> future =
                      new MockScheduledFuture<>(command, delay, unit);
                  scheduledDestroyTasks.add(future);
                  return future;
                }
              })
          .anyTimes();
      replay(mockExecutor);
      return mockExecutor;
    }
  }

  protected static class MockScheduledFuture<V> implements java.util.concurrent.ScheduledFuture<V> {
    private boolean cancelled;
    private boolean finished;
    final Runnable command;
    final long delay;
    final TimeUnit unit;

    MockScheduledFuture(Runnable command, long delay, TimeUnit unit) {
      this.command = command;
      this.delay = delay;
      this.unit = unit;
    }

    void runTask() {
      command.run();
      finished = true;
    }

    @Override
    public boolean cancel(boolean interrupt) {
      if (cancelled || finished) {
        return false;
      }
      cancelled = true;
      return true;
    }

    @Override
    public boolean isCancelled() {
      return cancelled;
    }

    @Override
    public long getDelay(TimeUnit targetUnit) {
      return targetUnit.convert(this.delay, this.unit);
    }

    @Override
    public int compareTo(Delayed o) {
      throw new UnsupportedOperationException();
    }

    @Override
    public boolean isDone() {
      return cancelled || finished;
    }

    @Override
    public V get() {
      throw new UnsupportedOperationException();
    }

    @Override
    public V get(long timeout, TimeUnit unit) {
      throw new UnsupportedOperationException();
    }
  }
}
