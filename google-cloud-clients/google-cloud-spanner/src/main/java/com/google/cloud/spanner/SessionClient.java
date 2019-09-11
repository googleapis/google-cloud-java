/*
 * Copyright 2019 Google LLC
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
import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import com.google.api.pathtemplate.PathTemplate;
import com.google.cloud.spanner.spi.v1.SpannerRpc;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import io.opencensus.common.Scope;
import io.opencensus.trace.Span;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import javax.annotation.concurrent.GuardedBy;

/** Client for creating single sessions and batches of sessions. */
class SessionClient implements AutoCloseable {
  static class SessionId {
    private static final PathTemplate NAME_TEMPLATE =
        PathTemplate.create(
            "projects/{project}/instances/{instance}/databases/{database}/sessions/{session}");
    private final DatabaseId db;
    private final String name;

    private SessionId(DatabaseId db, String name) {
      this.db = db;
      this.name = name;
    }

    static SessionId of(String name) {
      Map<String, String> parts = NAME_TEMPLATE.match(name);
      Preconditions.checkArgument(
          parts != null, "Name should conform to pattern %s: %s", NAME_TEMPLATE, name);
      return of(
          parts.get("project"), parts.get("instance"), parts.get("database"), parts.get("session"));
    }

    /** Creates a {@code SessionId} given project, instance, database and session IDs. */
    static SessionId of(String project, String instance, String database, String session) {
      return new SessionId(new DatabaseId(new InstanceId(project, instance), database), session);
    }

    DatabaseId getDatabaseId() {
      return db;
    }

    String getName() {
      return name;
    }
  }

  /**
   * Encapsulates state to be passed to the {@link SpannerRpc} layer for a given session. Currently
   * used to select the {@link io.grpc.Channel} to be used in issuing the RPCs in a Session.
   */
  static class SessionOption {
    private final SpannerRpc.Option rpcOption;
    private final Object value;

    SessionOption(SpannerRpc.Option option, Object value) {
      this.rpcOption = checkNotNull(option);
      this.value = value;
    }

    static SessionOption channelHint(long hint) {
      return new SessionOption(SpannerRpc.Option.CHANNEL_HINT, hint);
    }

    SpannerRpc.Option rpcOption() {
      return rpcOption;
    }

    Object value() {
      return value;
    }
  }

  static Map<SpannerRpc.Option, ?> optionMap(SessionOption... options) {
    if (options.length == 0) {
      return Collections.emptyMap();
    }
    Map<SpannerRpc.Option, Object> tmp = Maps.newEnumMap(SpannerRpc.Option.class);
    for (SessionOption option : options) {
      Object prev = tmp.put(option.rpcOption(), option.value());
      checkArgument(prev == null, "Duplicate option %s", option.rpcOption());
    }
    return ImmutableMap.copyOf(tmp);
  }

  private final class BatchCreateSessionsRunnable implements Runnable {
    private final long channelHint;
    private final int sessionCount;
    private final SessionEnumeration enumeration;

    private BatchCreateSessionsRunnable(
        int sessionCount, long channelHint, SessionEnumeration enumeration) {
      Preconditions.checkNotNull(enumeration);
      Preconditions.checkArgument(sessionCount > 0, "sessionCount must be > 0");
      this.channelHint = channelHint;
      this.sessionCount = sessionCount;
      this.enumeration = enumeration;
    }

    @Override
    public void run() {
      List<SessionImpl> sessions = null;
      int remainingSessionsToCreate = sessionCount;
      while(remainingSessionsToCreate > 0) {
        try {
          sessions = internalBatchCreateSessions(remainingSessionsToCreate, channelHint);
        } catch (Throwable t) {
          enumeration.registerException(t, remainingSessionsToCreate);
          break;
        }
        int numActuallyCreated = sessions.size();
        if (numActuallyCreated == 0) {
          // No sessions returned by the server. Give up creation to avoid an infinite loop.
          enumeration.registerException(
              newSpannerException(ErrorCode.UNKNOWN, "Server did not return any sessions"),
              remainingSessionsToCreate);
          break;
        }
        for (SessionImpl session : sessions) {
          enumeration.put(session);
        }
        remainingSessionsToCreate -= numActuallyCreated;
      }
    }
  }

  private static class SessionOrError {
    private final SessionImpl session;
    private final Throwable throwable;

    private SessionOrError(SessionImpl session) {
      this.session = session;
      this.throwable = null;
    }

    private SessionOrError(Throwable throwable) {
      this.session = null;
      this.throwable = throwable;
    }
  }

  static class SessionEnumeration implements Enumeration<SessionImpl> {
    private final LinkedBlockingQueue<SessionOrError> queue;
    private volatile Throwable exception;
    private volatile int remainingSessions;

    @VisibleForTesting
    static SessionEnumeration of(Collection<SessionImpl> sessions) {
      SessionEnumeration stream = new SessionEnumeration(sessions.size());
      for (SessionImpl s : sessions) {
        stream.put(s);
      }
      return stream;
    }

    @VisibleForTesting
    static SessionEnumeration of(SpannerException e) {
      SessionEnumeration stream = new SessionEnumeration(1);
      stream.registerException(e, 1);
      return stream;
    }

    @VisibleForTesting
    SessionEnumeration(int sessionCount) {
      this.queue = new LinkedBlockingQueue<>(sessionCount);
      this.remainingSessions = sessionCount;
    }

    void put(SessionImpl session) {
      synchronized (this) {
        boolean added = queue.offer(new SessionOrError(session));
        this.remainingSessions--;
        if (!added || remainingSessions < 0) {
          throw new IllegalStateException("More sessions returned than requested");
        }
        checkOfferException();
      }
    }

    void registerException(Throwable exception, int forSessionCount) {
      synchronized (this) {
        if (this.exception == null) {
          this.exception = exception;
        }
        this.remainingSessions -= forSessionCount;
        checkOfferException();
      }
    }

    private void checkOfferException() {
      if (remainingSessions == 0 && exception != null) {
        queue.offer(new SessionOrError(exception));
        exception = null;
      }
    }

    @Override
    public boolean hasMoreElements() {
      synchronized (this) {
        return remainingSessions > 0 || !queue.isEmpty() || exception != null;
      }
    }

    @Override
    public SessionImpl nextElement() throws NoSuchElementException, SpannerException {
      if (hasMoreElements()) {
        try {
          SessionOrError s = queue.take();
          if (s.session != null) {
            return s.session;
          } else if (s.throwable != null && s.throwable instanceof SpannerException) {
            throw (SpannerException) s.throwable;
          } else if (s.throwable != null) {
            throw SpannerExceptionFactory.newSpannerException(s.throwable);
          } else {
            // This should not happen.
            throw new IllegalStateException("no session and no exception was returned");
          }
        } catch (InterruptedException e) {
          throw SpannerExceptionFactory.propagateInterrupt(e);
        }
      } else {
        throw new NoSuchElementException("This stream has no more sessions");
      }
    }
  }

  private static final ThreadFactory SESSION_CLIENT_THREAD_FACTORY =
      new ThreadFactoryBuilder()
          .setDaemon(true)
          .setNameFormat("session-client-%d")
          .setThreadFactory(MoreExecutors.platformThreadFactory())
          .build();
  private final SpannerImpl spanner;
  private final ScheduledExecutorService executor;
  private final DatabaseId db;

  @GuardedBy("this")
  private volatile long sessionChannelCounter;

  SessionClient(SpannerImpl spanner, DatabaseId db) {
    this.spanner = spanner;
    this.db = db;
    this.executor =
        Executors.newScheduledThreadPool(
            spanner.getOptions().getNumChannels(), SESSION_CLIENT_THREAD_FACTORY);
  }

  @Override
  public void close() {
    executor.shutdown();
  }

  /** Create a single session. */
  SessionImpl createSession() {
    // The sessionChannelCounter could overflow, but that will just flip it to Integer.MIN_VALUE,
    // which is also a valid channel hint.
    final Map<SpannerRpc.Option, ?> options;
    synchronized (this) {
      options = optionMap(SessionOption.channelHint(sessionChannelCounter++));
    }
    Span span = SpannerImpl.tracer.spanBuilder(SpannerImpl.CREATE_SESSION).startSpan();
    try (Scope s = SpannerImpl.tracer.withSpan(span)) {
      com.google.spanner.v1.Session session =
          spanner
              .getRpc()
              .createSession(db.getName(), spanner.getOptions().getSessionLabels(), options);
      span.end();
      return new SessionImpl(spanner, session.getName(), options);
    } catch (RuntimeException e) {
      TraceUtil.endSpanWithFailure(span, e);
      throw e;
    }
  }

  /**
   * Creates a batch of sessions and returns these as an enumeration. This method may split the
   * actual session creation over several gRPC calls in order to distribute the sessions evenly over
   * all available channels and to parallelize the session creation. The returned {@link
   * Enumeration} is guaranteed to eventually return exactly the number of requested sessions unless
   * an error occurs. In case of an error on one or more of the gRPC calls, the enumeration will
   * first return all sessions that were successfully created before returning the first error that
   * occurred. This means that the {@link Enumeration#nextElement()} could throw a {@link
   * SpannerException} even when {@link Enumeration#hasMoreElements()} returned true. The
   * enumeration is guaranteed to only return one {@link SpannerException}, and once it has been
   * returned {@link Enumeration#hasMoreElements()} will always return false. Closing the {@link
   * SessionClient} while sessions are being created or while an {@link Enumeration} is consumed may
   * cause an error and is handled in the same way as any other error that might occur, i.e. it is
   * returned as the last value of the {@link Enumeration}.
   *
   * @param sessionCount The number of sessions to create.
   * @return an {@link Enumeration} of sessions that will return exactly the number of requested
   *     sessions unless one or more errors occurs. In case of one or more errors, the enumeration
   *     will first return all sessions that were created successfully, and then the first error
   *     that occurred will be returned as the last element of the {@link Enumeration}.
   */
  Enumeration<SessionImpl> batchCreateSessions(final int sessionCount) {
    SessionEnumeration stream = new SessionEnumeration(sessionCount);
    // We spread the session creation evenly over all available channels.
    int sessionCountPerChannel = sessionCount / spanner.getOptions().getNumChannels();
    int remainder = sessionCount % spanner.getOptions().getNumChannels();
    int numBeingCreated = 0;
    synchronized (this) {
      for (int i = 0; i < spanner.getOptions().getNumChannels(); i++) {
        // Create one more session for the first X calls to fill up the remainder of the division.
        int createCountForChannel = sessionCountPerChannel + (i < remainder ? 1 : 0);
        if (createCountForChannel > 0) {
          try {
            executor.submit(
                new BatchCreateSessionsRunnable(
                    createCountForChannel, sessionChannelCounter++, stream));
            numBeingCreated += createCountForChannel;
          } catch (Throwable t) {
            stream.registerException(t, sessionCount - numBeingCreated);
          }
        } else {
          break;
        }
      }
    }
    return stream;
  }

  /**
   * Creates a batch of sessions that will all be affiliated with the same gRPC channel. It is the
   * responsibility of the caller to make multiple calls to this method in order to create sessions
   * that are distributed over multiple channels.
   */
  private List<SessionImpl> internalBatchCreateSessions(
      final int sessionCount, final long channelHint) throws SpannerException {
    final Map<SpannerRpc.Option, ?> options = optionMap(SessionOption.channelHint(channelHint));
    Span span = SpannerImpl.tracer.spanBuilder(SpannerImpl.BATCH_CREATE_SESSIONS).startSpan();
    try (Scope s = SpannerImpl.tracer.withSpan(span)) {
      List<com.google.spanner.v1.Session> sessions =
          spanner
              .getRpc()
              .batchCreateSessions(
                  db.getName(), sessionCount, spanner.getOptions().getSessionLabels(), options);
      span.end();
      List<SessionImpl> res = new ArrayList<>(sessionCount);
      for (com.google.spanner.v1.Session session : sessions) {
        res.add(new SessionImpl(spanner, session.getName(), options));
      }
      return res;
    } catch (RuntimeException e) {
      TraceUtil.endSpanWithFailure(span, e);
      throw e;
    }
  }

  /** Returns a {@link SessionImpl} that references the existing session with the given name. */
  SessionImpl sessionWithId(String name) {
    final Map<SpannerRpc.Option, ?> options;
    synchronized (this) {
      options = optionMap(SessionOption.channelHint(sessionChannelCounter++));
    }
    return new SessionImpl(spanner, name, options);
  }
}
