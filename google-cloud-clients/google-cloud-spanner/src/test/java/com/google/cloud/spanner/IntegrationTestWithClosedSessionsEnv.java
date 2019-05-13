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

import com.google.cloud.spanner.SessionPool.PooledSession;
import com.google.cloud.spanner.testing.RemoteSpannerHelper;

/**
 * Subclass of {@link IntegrationTestEnv} that allows the user to specify when the underlying
 * session of a {@link PooledSession} should be closed. This can be used to ensure that the
 * recreation of sessions that have been invalidated by the server works.
 */
public class IntegrationTestWithClosedSessionsEnv extends IntegrationTestEnv {
  private static class RemoteSpannerHelperWithClosedSessions extends RemoteSpannerHelper {
    private RemoteSpannerHelperWithClosedSessions(
        SpannerOptions options, InstanceId instanceId, Spanner client) {
      super(options, instanceId, client);
    }
  }

  @Override
  RemoteSpannerHelper createTestHelper(SpannerOptions options, InstanceId instanceId)
      throws Throwable {
    SpannerWithClosedSessionsImpl spanner = new SpannerWithClosedSessionsImpl(options);
    return new RemoteSpannerHelperWithClosedSessions(options, instanceId, spanner);
  }

  private static class SpannerWithClosedSessionsImpl extends SpannerImpl {
    SpannerWithClosedSessionsImpl(SpannerOptions options) {
      super(options);
    }

    @Override
    DatabaseClientImpl createDatabaseClient(SessionPool pool) {
      return new DatabaseClientWithClosedSessionImpl(pool);
    }
  }

  /**
   * {@link DatabaseClient} that allows the user to specify when an underlying session of a {@link
   * PooledSession} should be closed.
   */
  public static class DatabaseClientWithClosedSessionImpl extends DatabaseClientImpl {
    private boolean invalidateNextSession = false;
    private boolean allowReplacing = true;

    DatabaseClientWithClosedSessionImpl(SessionPool pool) {
      super(pool);
    }

    /** Invalidate the next session that is checked out from the pool. */
    public void invalidateNextSession() {
      invalidateNextSession = true;
    }

    /** Sets whether invalidated sessions should be replaced or not. */
    public void setAllowSessionReplacing(boolean allow) {
      this.allowReplacing = allow;
    }

    @Override
    PooledSession getReadSession() {
      PooledSession session = super.getReadSession();
      if (invalidateNextSession) {
        session.delegate.close();
        session.setAllowReplacing(false);
        awaitDeleted(session.delegate);
        session.setAllowReplacing(allowReplacing);
        invalidateNextSession = false;
      }
      session.setAllowReplacing(allowReplacing);
      return session;
    }

    @Override
    PooledSession getReadWriteSession() {
      PooledSession session = super.getReadWriteSession();
      if (invalidateNextSession) {
        session.delegate.close();
        session.setAllowReplacing(false);
        awaitDeleted(session.delegate);
        session.setAllowReplacing(allowReplacing);
        invalidateNextSession = false;
      }
      session.setAllowReplacing(allowReplacing);
      return session;
    }

    /**
     * Deleting a session server side takes some time. This method checks and waits until the
     * session really has been deleted.
     */
    private void awaitDeleted(Session session) {
      // Wait until the session has actually been deleted.
      while (true) {
        try (ResultSet rs = session.singleUse().executeQuery(Statement.of("SELECT 1"))) {
          while (rs.next()) {
            // Do nothing.
          }
          Thread.sleep(500L);
        } catch (SpannerException e) {
          if (e.getErrorCode() == ErrorCode.NOT_FOUND
              && e.getMessage().contains("Session not found")) {
            break;
          } else {
            throw e;
          }
        } catch (InterruptedException e) {
          break;
        }
      }
    }
  }
}
