/*
 * Copyright 2017 Google Inc. All Rights Reserved.
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

import static com.google.cloud.spanner.SpannerExceptionFactory.newSpannerException;

import com.google.cloud.Timestamp;
import com.google.cloud.grpc.GrpcTransportOptions;
import com.google.cloud.grpc.GrpcTransportOptions.ExecutorFactory;
import com.google.cloud.spanner.Options.QueryOption;
import com.google.cloud.spanner.Options.ReadOption;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.common.util.concurrent.SettableFuture;
import com.google.common.util.concurrent.Uninterruptibles;

import io.opencensus.trace.Annotation;
import io.opencensus.trace.AttributeValue;
import io.opencensus.trace.Span;
import io.opencensus.trace.Tracing;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import org.threeten.bp.Duration;
import org.threeten.bp.Instant;

/**
 * Maintains a pool of sessions some of which might be prepared for write by invoking
 * BeginTransaction rpc. It maintains two queues of sessions(read and write prepared) and two queues
 * of waiters who are waiting for a session to become available. This class itself is thread safe
 * and is meant to be used concurrently across multiple threads.
 */
final class SessionPool {

  private static final Logger logger = Logger.getLogger(SessionPool.class.getName());

  /**
   * Wrapper around current time so that we can fake it in tests. TODO(user): Replace with Java 8
   * Clock.
   */
  static class Clock {
    Instant instant() {
      return Instant.now();
    }
  }

  /**
   * Wrapper around {@code ReadContext} that releases the session to the pool once the call is
   * finished, if it is a single use context.
   */
  private static class AutoClosingReadContext implements ReadContext {
    private final ReadContext delegate;
    private final PooledSession session;
    private final boolean isSingleUse;
    private boolean closed;

    private AutoClosingReadContext(
        ReadContext delegate, PooledSession session, boolean isSingleUse) {
      this.delegate = delegate;
      this.session = session;
      this.isSingleUse = isSingleUse;
    }

    private ResultSet wrap(final ResultSet resultSet) {
      session.markUsed();
      if (!isSingleUse) {
        return resultSet;
      }
      return new ForwardingResultSet(resultSet) {
        @Override
        public boolean next() throws SpannerException {
          try {
            boolean ret = super.next();
            if (!ret) {
              close();
            }
            return ret;
          } catch (SpannerException e) {
            if (!closed) {
              session.lastException = e;
              AutoClosingReadContext.this.close();
            }
            throw e;
          }
        }

        @Override
        public void close() {
          super.close();
          AutoClosingReadContext.this.close();
        }
      };
    }

    @Override
    public ResultSet read(
        String table, KeySet keys, Iterable<String> columns, ReadOption... options) {
      return wrap(delegate.read(table, keys, columns, options));
    }

    @Override
    public ResultSet readUsingIndex(
        String table, String index, KeySet keys, Iterable<String> columns, ReadOption... options) {
      return wrap(delegate.readUsingIndex(table, index, keys, columns, options));
    }

    @Override
    @Nullable
    public Struct readRow(String table, Key key, Iterable<String> columns) {
      try {
        session.markUsed();
        return delegate.readRow(table, key, columns);
      } finally {
        if (isSingleUse) {
          close();
        }
      }
    }

    @Override
    @Nullable
    public Struct readRowUsingIndex(String table, String index, Key key, Iterable<String> columns) {
      try {
        session.markUsed();
        return delegate.readRowUsingIndex(table, index, key, columns);
      } finally {
        if (isSingleUse) {
          close();
        }
      }
    }

    @Override
    public ResultSet executeQuery(Statement statement, QueryOption... options) {
      return wrap(delegate.executeQuery(statement, options));
    }

    @Override
    public ResultSet analyzeQuery(Statement statement, QueryAnalyzeMode queryMode) {
      return wrap(delegate.analyzeQuery(statement, queryMode));
    }

    @Override
    public void close() {
      if (closed) {
        return;
      }
      closed = true;
      delegate.close();
      session.close();
    }
  }

  private static class AutoClosingReadTransaction extends AutoClosingReadContext
      implements ReadOnlyTransaction {
    private final ReadOnlyTransaction txn;

    AutoClosingReadTransaction(
        ReadOnlyTransaction txn, PooledSession session, boolean isSingleUse) {
      super(txn, session, isSingleUse);
      this.txn = txn;
    }

    @Override
    public Timestamp getReadTimestamp() {
      return txn.getReadTimestamp();
    }
  }

  // Exception class used just to track the stack trace at the point when a session was handed out
  // from the pool.
  private final class LeakedSessionException extends RuntimeException {
    private static final long serialVersionUID = 1451131180314064914L;

    private LeakedSessionException() {
      super("Session was checked out from the pool at " + clock.instant());
    }
  }

  private enum SessionState {
    AVAILABLE,
    BUSY,
    CLOSING,
  }

  final class PooledSession implements Session {
    @VisibleForTesting final Session delegate;
    private volatile Instant lastUseTime;
    private volatile SpannerException lastException;
    private volatile LeakedSessionException leakedException;

    @GuardedBy("lock")
    private SessionState state;

    private PooledSession(Session delegate) {
      this.delegate = delegate;
      this.state = SessionState.AVAILABLE;
      markUsed();
    }

    private void markBusy() {
      this.state = SessionState.BUSY;
      this.leakedException = new LeakedSessionException();
    }

    private void markClosing() {
      this.state = SessionState.CLOSING;
    }

    @Override
    public Timestamp write(Iterable<Mutation> mutations) throws SpannerException {
      try {
        markUsed();
        return delegate.write(mutations);
      } catch (SpannerException e) {
        throw lastException = e;
      } finally {
        close();
      }
    }

    @Override
    public Timestamp writeAtLeastOnce(Iterable<Mutation> mutations) throws SpannerException {
      try {
        markUsed();
        return delegate.writeAtLeastOnce(mutations);
      } catch (SpannerException e) {
        throw lastException = e;
      } finally {
        close();
      }
    }

    @Override
    public ReadContext singleUse() {
      try {
        return new AutoClosingReadContext(delegate.singleUse(), this, true);
      } catch (Exception e) {
        close();
        throw e;
      }
    }

    @Override
    public ReadContext singleUse(TimestampBound bound) {
      try {
        return new AutoClosingReadContext(delegate.singleUse(bound), this, true);
      } catch (Exception e) {
        close();
        throw e;
      }
    }

    @Override
    public ReadOnlyTransaction singleUseReadOnlyTransaction() {
      try {
        return new AutoClosingReadTransaction(delegate.singleUseReadOnlyTransaction(), this, true);
      } catch (Exception e) {
        close();
        throw e;
      }
    }

    @Override
    public ReadOnlyTransaction singleUseReadOnlyTransaction(TimestampBound bound) {
      try {
        return new AutoClosingReadTransaction(
            delegate.singleUseReadOnlyTransaction(bound), this, true);
      } catch (Exception e) {
        close();
        throw e;
      }
    }

    @Override
    public ReadOnlyTransaction readOnlyTransaction() {
      try {
        return new AutoClosingReadTransaction(delegate.readOnlyTransaction(), this, false);
      } catch (Exception e) {
        close();
        throw e;
      }
    }

    @Override
    public ReadOnlyTransaction readOnlyTransaction(TimestampBound bound) {
      try {
        return new AutoClosingReadTransaction(delegate.readOnlyTransaction(bound), this, false);
      } catch (Exception e) {
        close();
        throw e;
      }
    }

    @Override
    public TransactionRunner readWriteTransaction() {
      final TransactionRunner runner = delegate.readWriteTransaction();
      return new TransactionRunner() {

        @Override
        @Nullable
        public <T> T run(TransactionCallable<T> callable) {
          try {
            markUsed();
            T result = runner.run(callable);
            return result;
          } catch (SpannerException e) {
            throw lastException = e;
          } finally {
            close();
          }
        }

        @Override
        public Timestamp getCommitTimestamp() {
          return runner.getCommitTimestamp();
        }
      };
    }

    @Override
    public void close() {
      synchronized (lock) {
        numSessionsInUse--;
      }
      leakedException = null;
      if (lastException != null && isSessionNotFound(lastException)) {
        invalidateSession(this);
      } else {
        lastException = null;
        if (state != SessionState.CLOSING) {
          state = SessionState.AVAILABLE;
        }
        releaseSession(this);
      }
    }

    @Override
    public String getName() {
      return delegate.getName();
    }

    @Override
    public void prepareReadWriteTransaction() {
      markUsed();
      delegate.prepareReadWriteTransaction();
    }

    private void keepAlive() {
      markUsed();
      delegate
          .singleUse(TimestampBound.ofMaxStaleness(60, TimeUnit.SECONDS))
          .executeQuery(Statement.newBuilder("SELECT 1").build())
          .next();
    }

    private void markUsed() {
      lastUseTime = clock.instant();
    }
  }

  private static final class SessionOrError {
    private final PooledSession session;
    private final SpannerException e;

    SessionOrError(PooledSession session) {
      this.session = session;
      this.e = null;
    }

    SessionOrError(SpannerException e) {
      this.session = null;
      this.e = e;
    }
  }

  private static final class Waiter {
    private final SynchronousQueue<SessionOrError> waiter = new SynchronousQueue<>();

    private void put(PooledSession session) {
      Uninterruptibles.putUninterruptibly(waiter, new SessionOrError(session));
    }

    private void put(SpannerException e) {
      Uninterruptibles.putUninterruptibly(waiter, new SessionOrError(e));
    }

    private PooledSession take() throws SpannerException {
      SessionOrError s = Uninterruptibles.takeUninterruptibly(waiter);
      if (s.e != null) {
        throw newSpannerException(s.e);
      }
      return s.session;
    }
  }

  // Background task to maintain the pool. It closes idle sessions, keeps alive sessions that have
  // not been used for a user configured time and creates session if needed to bring pool up to
  // minimum required sessions. We keep track of the number of concurrent sessions being used.
  // The maximum value of that over a window (10 minutes) tells us how many sessions we need in the
  // pool. We close the remaining sessions. To prevent bursty traffic, we smear this out over the
  // window length. We also smear out the keep alive traffic over the keep alive period.
  final class PoolMaintainer {
    // Length of the window in millis over which we keep track of maximum number of concurrent
    // sessions in use.
    private final Duration windowLength = Duration.ofMillis(TimeUnit.MINUTES.toMillis(10));
    // Frequency of the timer loop.
    @VisibleForTesting static final long LOOP_FREQUENCY = 10 * 1000L;
    // Number of loop iterations in which we need to to close all the sessions waiting for closure.
    @VisibleForTesting final long numClosureCycles = windowLength.toMillis() / LOOP_FREQUENCY;
    private final Duration keepAliveMilis =
        Duration.ofMillis(TimeUnit.MINUTES.toMillis(options.getKeepAliveIntervalMinutes()));
    // Number of loop iterations in which we need to keep alive all the sessions
    @VisibleForTesting final long numKeepAliveCycles = keepAliveMilis.toMillis() / LOOP_FREQUENCY;

    Instant lastResetTime = Instant.ofEpochMilli(0);
    int numSessionsToClose = 0;
    int sessionsToClosePerLoop = 0;

    @GuardedBy("lock")
    ScheduledFuture<?> scheduledFuture;

    @GuardedBy("lock")
    boolean running;

    void init() {
      // Scheduled pool maintenance worker.
      synchronized (lock) {
        scheduledFuture =
            executor.scheduleAtFixedRate(
                new Runnable() {
                  @Override
                  public void run() {
                    maintainPool();
                  }
                },
                LOOP_FREQUENCY,
                LOOP_FREQUENCY,
                TimeUnit.MILLISECONDS);
      }
    }

    void close() {
      synchronized (lock) {
        scheduledFuture.cancel(false);
        if (!running) {
          decrementPendingClosures();
        }
      }
    }

    // Does various pool maintenance activities.
    void maintainPool() {
      synchronized (lock) {
        if (isClosed()) {
          return;
        }
        running = true;
      }
      Instant currTime = clock.instant();
      closeIdleSessions(currTime);
      // Now go over all the remaining sessions and see if they need to be kept alive explicitly.
      keepAliveSessions(currTime);
      replenishPool();
      synchronized (lock) {
        running = false;
        if (isClosed()) {
          decrementPendingClosures();
        }
      }
    }

    private void closeIdleSessions(Instant currTime) {
      LinkedList<PooledSession> sessionsToClose = new LinkedList<>();
      synchronized (lock) {
        // Every ten minutes figure out how many sessions need to be closed then close them over
        // next ten minutes.
        if (currTime.isAfter(lastResetTime.plus(windowLength))) {
          int sessionsToKeep =
              Math.max(options.getMinSessions(), maxSessionsInUse + options.getMaxIdleSessions());
          numSessionsToClose = totalSessions() - sessionsToKeep;
          sessionsToClosePerLoop = (int) Math.ceil((double) numSessionsToClose / numClosureCycles);
          maxSessionsInUse = 0;
          lastResetTime = currTime;
        }
        if (numSessionsToClose > 0) {
          while (sessionsToClose.size() < Math.min(numSessionsToClose, sessionsToClosePerLoop)) {
            PooledSession sess =
                readSessions.size() > 0 ? readSessions.poll() : writePreparedSessions.poll();
            if (sess != null) {
              if (sess.state != SessionState.CLOSING) {
                sess.markClosing();
                sessionsToClose.add(sess);
              }
            } else {
              break;
            }
          }
          numSessionsToClose -= sessionsToClose.size();
        }
      }
      for (PooledSession sess : sessionsToClose) {
        logger.log(Level.FINE, "Closing session %s", sess.getName());
        closeSession(sess);
      }
    }

    private void keepAliveSessions(Instant currTime) {
      long numSessionsToKeepAlive = 0;
      synchronized (lock) {
        // In each cycle only keep alive a subset of sessions to prevent burst of traffic.
        numSessionsToKeepAlive = (long) Math.ceil((double) totalSessions() / numKeepAliveCycles);
      }
      // Now go over all the remaining sessions and see if they need to be kept alive explicitly.
      Instant keepAliveThreshold = currTime.minus(keepAliveMilis);

      // Keep chugging till there is no session that needs to be kept alive.
      while (numSessionsToKeepAlive > 0) {
        PooledSession sessionToKeepAlive = null;
        synchronized (lock) {
          sessionToKeepAlive = findSessionToKeepAlive(readSessions, keepAliveThreshold);
          if (sessionToKeepAlive == null) {
            sessionToKeepAlive = findSessionToKeepAlive(writePreparedSessions, keepAliveThreshold);
          }
        }
        if (sessionToKeepAlive == null) {
          break;
        }
        try {
          logger.log(Level.FINE, "Keeping alive session " + sessionToKeepAlive.getName());
          numSessionsToKeepAlive--;
          sessionToKeepAlive.keepAlive();
          releaseSession(sessionToKeepAlive);
        } catch (SpannerException e) {
          handleException(e, sessionToKeepAlive);
        }
      }
    }

    private void replenishPool() {
      synchronized (lock) {
        // If we have gone below min pool size, create that many sessions.
        for (int i = 0;
            i < options.getMinSessions() - (totalSessions() + numSessionsBeingCreated);
            i++) {
          createSession();
        }
      }
    }
  }

  private final SessionPoolOptions options;
  private final DatabaseId db;
  private final SpannerImpl spanner;
  private final ScheduledExecutorService executor;
  private final ExecutorFactory<ScheduledExecutorService> executorFactory;
  final PoolMaintainer poolMaintainer;
  private final Clock clock;
  private final Object lock = new Object();

  @GuardedBy("lock")
  private int pendingClosure;

  @GuardedBy("lock")
  private SettableFuture<Void> closureFuture;

  @GuardedBy("lock")
  private final Queue<PooledSession> readSessions = new LinkedList<>();

  @GuardedBy("lock")
  private final Queue<PooledSession> writePreparedSessions = new LinkedList<>();

  @GuardedBy("lock")
  private final Queue<Waiter> readWaiters = new LinkedList<>();

  @GuardedBy("lock")
  private final Queue<Waiter> readWriteWaiters = new LinkedList<>();

  @GuardedBy("lock")
  private int numSessionsBeingPrepared = 0;

  @GuardedBy("lock")
  private int numSessionsBeingCreated = 0;

  @GuardedBy("lock")
  private int numSessionsInUse = 0;

  @GuardedBy("lock")
  private int maxSessionsInUse = 0;

  @GuardedBy("lock")
  private final Set<PooledSession> allSessions = new HashSet<>();

  /**
   * Create a session pool with the given options and for the given database. It will also start
   * eagerly creating sessions if {@link SessionPoolOptions#getMinSessions()} is greater than 0.
   * Return pool is immediately ready for use, though getting a session might block for sessions to
   * be created.
   */
  static SessionPool createPool(SpannerOptions spannerOptions, DatabaseId db, SpannerImpl spanner) {
    return createPool(
        spannerOptions.getSessionPoolOptions(),
        ((GrpcTransportOptions) spannerOptions.getTransportOptions()).getExecutorFactory(),
        db,
        spanner);
  }

  static SessionPool createPool(
      SessionPoolOptions poolOptions,
      ExecutorFactory<ScheduledExecutorService> executorFactory,
      DatabaseId db,
      SpannerImpl spanner) {
    return createPool(poolOptions, executorFactory, db, spanner, new Clock());
  }

  static SessionPool createPool(
      SessionPoolOptions poolOptions,
      ExecutorFactory<ScheduledExecutorService> executorFactory,
      DatabaseId db,
      SpannerImpl spanner,
      Clock clock) {
    SessionPool pool =
        new SessionPool(poolOptions, executorFactory, executorFactory.get(), db, spanner, clock);
    pool.initPool();
    return pool;
  }

  private SessionPool(
      SessionPoolOptions options,
      ExecutorFactory<ScheduledExecutorService> executorFactory,
      ScheduledExecutorService executor,
      DatabaseId db,
      SpannerImpl spanner,
      Clock clock) {
    this.options = options;
    this.executorFactory = executorFactory;
    this.executor = executor;
    this.db = db;
    this.spanner = spanner;
    this.clock = clock;
    this.poolMaintainer = new PoolMaintainer();
  }

  private void initPool() {
    synchronized (lock) {
      poolMaintainer.init();
      for (int i = 0; i < options.getMinSessions(); i++) {
        createSession();
      }
    }
  }

  private boolean isClosed() {
    synchronized (lock) {
      return closureFuture != null;
    }
  }

  private void handleException(SpannerException e, PooledSession session) {
    if (isSessionNotFound(e)) {
      invalidateSession(session);
    } else {
      releaseSession(session);
    }
  }

  private boolean isSessionNotFound(SpannerException e) {
    return e.getErrorCode() == ErrorCode.NOT_FOUND && e.getMessage().contains("Session not found");
  }

  private void invalidateSession(PooledSession session) {
    synchronized (lock) {
      if (isClosed()) {
        return;
      }
      allSessions.remove(session);
      // replenish the pool.
      createSession();
    }
  }

  private PooledSession findSessionToKeepAlive(
      Queue<PooledSession> queue, Instant keepAliveThreshold) {
    Iterator<PooledSession> iterator = queue.iterator();
    while (iterator.hasNext()) {
      PooledSession session = iterator.next();
      if (session.lastUseTime.isBefore(keepAliveThreshold)) {
        iterator.remove();
        return session;
      }
    }
    return null;
  }

  /**
   * Returns a session to be used for read requests to spanner. It will block if a session is not
   * currently available. In case the pool is exhausted and {@link
   * SessionPoolOptions#isFailIfPoolExhausted()} has been set, it will throw an exception. Returned
   * session must be closed by calling {@link Session#close()}.
   *
   * <p>Implementation strategy:
   *
   * <ol>
   *   <li>If a read session is available, return that.
   *   <li>Otherwise if a writePreparedSession is available, return that.
   *   <li>Otherwise if a session can be created, fire a creation request.
   *   <li>Wait for a session to become available. Note that this can be unblocked either by a
   *       session being returned to the pool or a new session being created.
   * </ol>
   */
  Session getReadSession() throws SpannerException {
    Span span = Tracing.getTracer().getCurrentSpan();
    span.addAnnotation("Acquiring session");
    Waiter waiter = null;
    PooledSession sess = null;
    synchronized (lock) {
      if (closureFuture != null) {
        span.addAnnotation("Pool has been closed");
        throw new IllegalStateException("Pool has been closed");
      }
      sess = readSessions.poll();
      if (sess == null) {
        sess = writePreparedSessions.poll();
        if (sess == null) {
          span.addAnnotation("No session available");
          maybeCreateSession();
          waiter = new Waiter();
          readWaiters.add(waiter);
        } else {
          span.addAnnotation("Acquired read write session");
        }
      } else {
        span.addAnnotation("Acquired read only session");
      }
    }
    if (waiter != null) {
      logger.log(
          Level.FINE,
          "No session available in the pool. Blocking for one to become available/created");
      span.addAnnotation("Waiting for read only session to be available");
      sess = waiter.take();
    }
    sess.markBusy();
    incrementNumSessionsInUse();
    span.addAnnotation(sessionAnnotation(sess));
    return sess;
  }

  /**
   * Returns a session which has been prepared for writes by invoking BeginTransaction rpc. It will
   * block if such a session is not currently available.In case the pool is exhausted and {@link
   * SessionPoolOptions#isFailIfPoolExhausted()} has been set, it will throw an exception. Returned
   * session must closed by invoking {@link Session#close()}.
   *
   * <p>Implementation strategy:
   *
   * <ol>
   *   <li>If a writePreparedSession is available, return that.
   *   <li>Otherwise if we have an extra session being prepared for write, wait for that.
   *   <li>Otherwise, if there is a read session available, start preparing that for write and wait.
   *   <li>Otherwise start creating a new session and wait.
   *   <li>Wait for write prepared session to become available. This can be unblocked either by the
   *       session create/prepare request we fired in above request or by a session being released
   *       to the pool which is then write prepared.
   * </ol>
   */
  Session getReadWriteSession() {
    Span span = Tracing.getTracer().getCurrentSpan();
    span.addAnnotation("Acquiring read write session");
    Waiter waiter = null;
    PooledSession sess = null;
    synchronized (lock) {
      if (closureFuture != null) {
        throw new IllegalStateException("Pool has been closed");
      }
      sess = writePreparedSessions.poll();
      if (sess == null) {
        if (numSessionsBeingPrepared <= readWriteWaiters.size()) {
          PooledSession readSession = readSessions.poll();
          if (readSession != null) {
            span.addAnnotation("Acquired read only session. Preparing for read write transaction");
            prepareSession(readSession);
          } else {
            span.addAnnotation("No session available");
            maybeCreateSession();
          }
        }
        waiter = new Waiter();
        readWriteWaiters.add(waiter);
      } else {
        span.addAnnotation("Acquired read write session");
      }
    }
    if (waiter != null) {
      logger.log(
          Level.FINE,
          "No session available in the pool. Blocking for one to become available/created");
      span.addAnnotation("Waiting for read write session to be available");
      sess = waiter.take();
    }
    sess.markBusy();
    incrementNumSessionsInUse();
    span.addAnnotation(sessionAnnotation(sess));
    return sess;
  }

  private Annotation sessionAnnotation(Session session) {
    AttributeValue sessionId = AttributeValue.stringAttributeValue(session.getName());
    return Annotation.fromDescriptionAndAttributes("Using Session",
        ImmutableMap.of("sessionId", sessionId));
  }
 
  private void incrementNumSessionsInUse() {
    synchronized (lock) {
      if (maxSessionsInUse < ++numSessionsInUse) {
        maxSessionsInUse = numSessionsInUse;
      }
    }
  }

  private void maybeCreateSession() {
    Span span = Tracing.getTracer().getCurrentSpan();
    synchronized (lock) {
      if (numWaiters() >= numSessionsBeingCreated) {
        if (canCreateSession()) {
          span.addAnnotation("Creating session");
          createSession();
        } else if (options.isFailIfPoolExhausted()) {
          span.addAnnotation("Pool exhausted. Failing");
          // throw specific exception
          throw newSpannerException(
              ErrorCode.RESOURCE_EXHAUSTED,
              "No session available in the pool. Maximum number of sessions in the pool can be"
                  + " overridden by invoking SessionPoolOptions#Builder#setMaxSessions. Client can be made to block"
                  + " rather than fail by setting SessionPoolOptions#Builder#setBlockIfPoolExhausted.");
        }
      }
    }
  }
  /**
   * Releases a session back to the pool. This might cause one of the waiters to be unblocked.
   *
   * <p>Implementation note:
   *
   * <ol>
   *   <li>If there are no pending waiters, either add to the read sessions queue or start preparing
   *       for write depending on what fraction of sessions are already prepared for writes.
   *   <li>Otherwise either unblock a waiting reader or start preparing for a write. Exact strategy
   *       on which option we chose, in case there are both waiting readers and writers, is
   *       implemented in {@link #shouldUnblockReader}
   * </ol>
   */
  private void releaseSession(PooledSession session) {
    Preconditions.checkNotNull(session);
    synchronized (lock) {
      if (closureFuture != null) {
        return;
      }
      if (readWaiters.size() == 0 && numSessionsBeingPrepared >= readWriteWaiters.size()) {
        // No pending waiters
        if (shouldPrepareSession()) {
          prepareSession(session);
        } else {
          readSessions.add(session);
        }
      } else if (shouldUnblockReader()) {
        readWaiters.poll().put(session);
      } else {
        prepareSession(session);
      }
    }
  }

  private void handleCreateSessionFailure(SpannerException e) {
    synchronized (lock) {
      if (readWaiters.size() > 0) {
        readWaiters.poll().put(e);
      } else if (readWriteWaiters.size() > 0) {
        readWriteWaiters.poll().put(e);
      }
    }
  }

  private void handlePrepareSessionFailure(SpannerException e, PooledSession session) {
    synchronized (lock) {
      if (isSessionNotFound(e)) {
        invalidateSession(session);
      } else if (readWriteWaiters.size() > 0) {
        readWriteWaiters.poll().put(e);
      } else {
        releaseSession(session);
      }
    }
  }

  private void decrementPendingClosures() {
    pendingClosure--;
    if (pendingClosure == 0) {
      closureFuture.set(null);
    }
  }

  /**
   * Close all the sessions. Once this method is invoked {@link #getReadSession()} and {@link
   * #getReadWriteSession()} will start throwing {@code IllegalStateException}. The returned future
   * blocks till all the sessions created in this pool have been closed.
   */
  ListenableFuture<Void> closeAsync() {
    ListenableFuture<Void> retFuture = null;
    synchronized (lock) {
      if (closureFuture != null) {
        throw new IllegalStateException("Close has already been invoked");
      }
      // Fail all pending waiters.
      Waiter waiter = readWaiters.poll();
      while (waiter != null) {
        waiter.put(newSpannerException(ErrorCode.INTERNAL, "Client has been closed"));
        waiter = readWaiters.poll();
      }
      waiter = readWriteWaiters.poll();
      while (waiter != null) {
        waiter.put(newSpannerException(ErrorCode.INTERNAL, "Client has been closed"));
        waiter = readWriteWaiters.poll();
      }
      closureFuture = SettableFuture.create();
      retFuture = closureFuture;
      pendingClosure =
          totalSessions() + numSessionsBeingCreated + 1 /* For pool maintenance thread */;

      poolMaintainer.close();
      readSessions.clear();
      writePreparedSessions.clear();
      for (final PooledSession session : ImmutableList.copyOf(allSessions)) {
        if (session.leakedException != null) {
          logger.log(Level.WARNING, "Leaked session", session.leakedException);
        }
        if (session.state != SessionState.CLOSING) {
          closeSessionAsync(session);
        }
      }
    }
    retFuture.addListener(
        new Runnable() {
          @Override
          public void run() {
            executorFactory.release(executor);
          }
        },
        MoreExecutors.directExecutor());

    return retFuture;
  }

  private boolean shouldUnblockReader() {
    // This might not be the best strategy since a continuous burst of read requests can starve
    // a write request. Maybe maintain a timestamp in the queue and unblock according to that
    // or just flip a weighted coin.
    synchronized (lock) {
      int numWriteWaiters = readWriteWaiters.size() - numSessionsBeingPrepared;
      return readWaiters.size() > numWriteWaiters;
    }
  }

  private boolean shouldPrepareSession() {
    synchronized (lock) {
      int preparedSessions = writePreparedSessions.size() + numSessionsBeingPrepared;
      return preparedSessions < Math.floor(options.getWriteSessionsFraction() * totalSessions());
    }
  }

  private int numWaiters() {
    synchronized (lock) {
      return readWaiters.size() + readWriteWaiters.size();
    }
  }

  private int totalSessions() {
    synchronized (lock) {
      return allSessions.size();
    }
  }

  private void closeSessionAsync(final PooledSession sess) {
    executor.submit(
        new Runnable() {
          @Override
          public void run() {
            closeSession(sess);
          }
        });
  }

  private void closeSession(PooledSession sess) {
    try {
      sess.delegate.close();
    } catch (SpannerException e) {
      // Backend will delete these sessions after a while even if we fail to close them.
      if (logger.isLoggable(Level.FINE)) {
        logger.log(Level.FINE, "Failed to close session: " + sess.getName(), e);
      }
    } finally {
      synchronized (lock) {
        allSessions.remove(sess);
        if (isClosed()) {
          decrementPendingClosures();
          return;
        }
        // Create a new session if needed to unblock some waiter.
        if (numWaiters() > numSessionsBeingCreated) {
          createSession();
        }
      }
    }
  }

  private void prepareSession(final PooledSession sess) {
    synchronized (lock) {
      numSessionsBeingPrepared++;
    }
    executor.submit(
        new Runnable() {
          @Override
          public void run() {
            try {
              logger.log(Level.FINE, "Preparing session");
              sess.prepareReadWriteTransaction();
              logger.log(Level.FINE, "Session prepared");
              synchronized (lock) {
                numSessionsBeingPrepared--;
                if (!isClosed()) {
                  if (readWriteWaiters.size() > 0) {
                    readWriteWaiters.poll().put(sess);
                  } else if (readWaiters.size() > 0) {
                    readWaiters.poll().put(sess);
                  } else {
                    writePreparedSessions.add(sess);
                  }
                }
              }
            } catch (Throwable t) {
              synchronized (lock) {
                numSessionsBeingPrepared--;
                if (!isClosed()) {
                  handlePrepareSessionFailure(newSpannerException(t), sess);
                }
              }
            }
          }
        });
  }

  private boolean canCreateSession() {
    synchronized (lock) {
      return totalSessions() + numSessionsBeingCreated < options.getMaxSessions();
    }
  }

  private void createSession() {
    logger.log(Level.FINE, "Creating session");
    synchronized (lock) {
      numSessionsBeingCreated++;
      executor.submit(
          new Runnable() {
            @Override
            public void run() {
              Session session = null;
              try {
                session = spanner.createSession(db);
                logger.log(Level.FINE, "Session created");
              } catch (Throwable t) {
                // Expose this to customer via a metric.
                synchronized (lock) {
                  numSessionsBeingCreated--;
                  if (isClosed()) {
                    decrementPendingClosures();
                  }
                  handleCreateSessionFailure(newSpannerException(t));
                }
                return;
              }
              boolean closeSession = false;
              PooledSession pooledSession = null;
              synchronized (lock) {
                pooledSession = new PooledSession(session);
                numSessionsBeingCreated--;
                if (closureFuture != null) {
                  closeSession = true;
                } else {
                  Preconditions.checkState(totalSessions() <= options.getMaxSessions() - 1);
                  allSessions.add(pooledSession);
                  releaseSession(pooledSession);
                }
              }
              if (closeSession) {
                closeSession(pooledSession);
              }
            }
          });
    }
  }
}
