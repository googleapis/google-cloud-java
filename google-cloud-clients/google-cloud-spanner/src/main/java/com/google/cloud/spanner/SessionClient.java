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

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import com.google.api.pathtemplate.PathTemplate;
import com.google.cloud.grpc.GrpcTransportOptions.ExecutorFactory;
import com.google.cloud.spanner.spi.v1.SpannerRpc;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import io.opencensus.common.Scope;
import io.opencensus.trace.Span;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;
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
    private final SessionConsumer consumer;

    private BatchCreateSessionsRunnable(
        int sessionCount, long channelHint, SessionConsumer consumer) {
      Preconditions.checkNotNull(consumer);
      Preconditions.checkArgument(sessionCount > 0, "sessionCount must be > 0");
      this.channelHint = channelHint;
      this.sessionCount = sessionCount;
      this.consumer = consumer;
    }

    @Override
    public void run() {
      List<SessionImpl> sessions = null;
      int remainingSessionsToCreate = sessionCount;
      try (Scope scope =
          SpannerImpl.tracer.spanBuilder(SpannerImpl.BATCH_CREATE_SESSIONS).startScopedSpan()) {
        SpannerImpl.tracer
            .getCurrentSpan()
            .addAnnotation(String.format("Creating %d sessions", sessionCount));
        while (remainingSessionsToCreate > 0) {
          try {
            sessions = internalBatchCreateSessions(remainingSessionsToCreate, channelHint);
          } catch (Throwable t) {
            TraceUtil.endSpanWithFailure(SpannerImpl.tracer.getCurrentSpan(), t);
            consumer.onSessionCreateFailure(t, remainingSessionsToCreate);
            break;
          }
          for (SessionImpl session : sessions) {
            consumer.onSessionReady(session);
          }
          remainingSessionsToCreate -= sessions.size();
        }
      }
    }
  }

  /**
   * Callback interface to be used for BatchCreateSessions. When sessions become available or
   * session creation fails, one of the callback methods will be called.
   */
  static interface SessionConsumer {
    /** Called when a session has been created and is ready for use. */
    void onSessionReady(SessionImpl session);

    /**
     * Called when an error occurred during session creation. The createFailureForSessionCount
     * indicates the number of sessions that could not be created, so that the consumer knows how
     * many sessions it should still expect.
     */
    void onSessionCreateFailure(Throwable t, int createFailureForSessionCount);
  }

  private final SpannerImpl spanner;
  private final ExecutorFactory<ScheduledExecutorService> executorFactory;
  private final ScheduledExecutorService executor;
  private final DatabaseId db;

  @GuardedBy("this")
  private volatile long sessionChannelCounter;

  SessionClient(
      SpannerImpl spanner,
      DatabaseId db,
      ExecutorFactory<ScheduledExecutorService> executorFactory) {
    this.spanner = spanner;
    this.db = db;
    this.executorFactory = executorFactory;
    this.executor = executorFactory.get();
  }

  @Override
  public void close() {
    executorFactory.release(executor);
  }

  SpannerImpl getSpanner() {
    return spanner;
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
   * Asynchronously creates a batch of sessions and returns these to the given {@link
   * SessionConsumer}. This method may split the actual session creation over several gRPC calls in
   * order to distribute the sessions evenly over all available channels and to parallelize the
   * session creation. The given {@link SessionConsumer} is guaranteed to eventually get exactly the
   * number of requested sessions unless an error occurs. In case of an error on one or more of the
   * gRPC calls, the consumer will receive one or more {@link
   * SessionConsumer#onSessionCreateFailure(Throwable, int)} calls with the error and the number of
   * sessions that could not be created.
   *
   * @param sessionCount The number of sessions to create.
   * @param consumer The {@link SessionConsumer} to use for callbacks when sessions are available.
   */
  void asyncBatchCreateSessions(final int sessionCount, SessionConsumer consumer) {
    // We spread the session creation evenly over all available channels.
    int sessionCountPerChannel = sessionCount / spanner.getOptions().getNumChannels();
    int remainder = sessionCount % spanner.getOptions().getNumChannels();
    int numBeingCreated = 0;
    synchronized (this) {
      for (int channelIndex = 0;
          channelIndex < spanner.getOptions().getNumChannels();
          channelIndex++) {
        int createCountForChannel = sessionCountPerChannel;
        // Add the remainder of the division to the creation count of the first channel to make sure
        // we are creating the requested number of sessions. This will cause a slightly less
        // efficient distribution of sessions over the channels than spreading the remainder over
        // all channels as well, but it will also reduce the number of requests when less than
        // numChannels sessions are requested (i.e. with 4 channels and 3 requested sessions, the 3
        // sessions will be requested in one rpc call).
        if (channelIndex == 0) {
          createCountForChannel = sessionCountPerChannel + remainder;
        }
        if (createCountForChannel > 0) {
          try {
            executor.submit(
                new BatchCreateSessionsRunnable(
                    createCountForChannel, sessionChannelCounter++, consumer));
            numBeingCreated += createCountForChannel;
          } catch (Throwable t) {
            consumer.onSessionCreateFailure(t, sessionCount - numBeingCreated);
          }
        } else {
          break;
        }
      }
    }
  }

  /**
   * Creates a batch of sessions that will all be affiliated with the same gRPC channel. It is the
   * responsibility of the caller to make multiple calls to this method in order to create sessions
   * that are distributed over multiple channels.
   */
  private List<SessionImpl> internalBatchCreateSessions(
      final int sessionCount, final long channelHint) throws SpannerException {
    final Map<SpannerRpc.Option, ?> options = optionMap(SessionOption.channelHint(channelHint));
    Span parent = SpannerImpl.tracer.getCurrentSpan();
    Span span =
        SpannerImpl.tracer
            .spanBuilderWithExplicitParent(SpannerImpl.BATCH_CREATE_SESSIONS_REQUEST, parent)
            .startSpan();
    span.addAnnotation(String.format("Requesting %d sessions", sessionCount));
    try (Scope s = SpannerImpl.tracer.withSpan(span)) {
      List<com.google.spanner.v1.Session> sessions =
          spanner
              .getRpc()
              .batchCreateSessions(
                  db.getName(), sessionCount, spanner.getOptions().getSessionLabels(), options);
      span.addAnnotation(
          String.format(
              "Request for %d sessions returned %d sessions", sessionCount, sessions.size()));
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
