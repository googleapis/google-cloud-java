package com.google.cloud.spanner;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.joda.time.Instant;

import com.google.cloud.grpc.GrpcTransportOptions.ExecutorFactory;
import com.google.cloud.spanner.SessionPool.Clock;

abstract class BaseSessionPoolTest {
	  ScheduledExecutorService mockExecutor;
	  int sessionIndex = 0;
	  
	  final class TestExecutorFactory implements ExecutorFactory<ScheduledExecutorService> {

		    @Override
		    public ScheduledExecutorService get() {
		      ScheduledExecutorService realExecutor = new ScheduledThreadPoolExecutor(2);
		      mockExecutor = spy(realExecutor);
		      @SuppressWarnings("rawtypes")
			  ScheduledFuture mockFuture = mock(ScheduledFuture.class);
		      // To prevent maintenance loop from running.
		      doReturn(mockFuture).when(mockExecutor).scheduleAtFixedRate(any(Runnable.class), any(Long.class),
		    		  any(Long.class), any(TimeUnit.class));
		      return mockExecutor;
		    }

		    @Override
		    public void release(ScheduledExecutorService executor) {
		      // do nothing
		    }
		  }
	  
	  Session mockSession() {
		  Session session = mock(Session.class);
		  when(session.getName()).thenReturn(
	        "projects/dummy/instances/dummy/database/dummy/sessions/session" + sessionIndex);
		  sessionIndex++;
		  return session;
	  }
	  
	  void runMaintainanceLoop(FakeClock clock, SessionPool pool, long numCycles) {
		    for (int i = 0; i < numCycles; i++) {
		      pool.poolMaintainer.maintainPool();
		      clock.currentTimeMillis += SessionPool.PoolMaintainer.LOOP_FREQUENCY;
		    }
		  }

		  static class FakeClock extends Clock {
		    volatile long currentTimeMillis;

		    @Override
		    public Instant instant() {
		      return new Instant(currentTimeMillis);
		    }
		  }

}
