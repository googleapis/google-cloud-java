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

import static com.google.common.truth.Truth.assertThat;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Integration tests for read and query.
 *
 * <p>See also {@code it/WriteIntegrationTest}, which provides coverage of writing and reading back
 * all Cloud Spanner types.
 */
@Category(IntegrationTest.class)
@RunWith(JUnit4.class)
public class SessionPoolIntegrationTest {
  @ClassRule public static IntegrationTestEnv env = new IntegrationTestEnv();
  private static final String TABLE_NAME = "TestTable";

  private static Database db;
  @Rule public ExpectedException expectedException = ExpectedException.none();
  private SessionPool pool;

  @BeforeClass
  public static void setUpDatabase() {
    db =
        env.getTestHelper()
            .createTestDatabase(
                "CREATE TABLE TestTable ("
                    + "  Key                STRING(MAX) NOT NULL,"
                    + "  StringValue        STRING(MAX),"
                    + ") PRIMARY KEY (Key)",
                "CREATE INDEX TestTableByValue ON TestTable(StringValue)");

    // Includes k0..k14.  Note that strings k{10,14} sort between k1 and k2.
    List<Mutation> mutations = new ArrayList<>();
    for (int i = 0; i < 15; ++i) {
      mutations.add(
          Mutation.newInsertOrUpdateBuilder(TABLE_NAME)
              .set("Key")
              .to("k" + i)
              .set("StringValue")
              .to("v" + i)
              .build());
    }
    env.getTestHelper().getDatabaseClient(db).write(mutations);
  }

  @Before
  public void setUp() throws Exception {
    SessionPoolOptions options =
        SessionPoolOptions.newBuilder().setMinSessions(1).setMaxSessions(2).build();
    pool =
        SessionPool.createPool(
            options,
            new SessionPoolTest.TestExecutorFactory(),
            db.getId(),
            (SpannerImpl) env.getTestHelper().getClient());
  }

  @Test
  public void sessionCreation() {
    try (Session session = pool.getReadSession()) {
      assertThat(session).isNotNull();
    }

    try (Session session = pool.getReadSession()) {
      assertThat(session).isNotNull();
      Session session2 = pool.getReadSession();
      assertThat(session2).isNotNull();
      session2.close();
    }
  }

  @Test
  public void poolExhaustion() throws Exception {
    Session session1 = pool.getReadSession();
    Session session2 = pool.getReadSession();
    final CountDownLatch latch = new CountDownLatch(1);
    new Thread(
            new Runnable() {
              @Override
              public void run() {
                try (Session session3 = pool.getReadSession()) {
                  latch.countDown();
                }
              }
            })
        .start();
    assertThat(latch.await(5, TimeUnit.SECONDS)).isFalse();
    session1.close();
    session2.close();
    latch.await();
  }

  @Test
  public void multipleWaiters() throws Exception {
    Session session1 = pool.getReadSession();
    Session session2 = pool.getReadSession();
    int numSessions = 5;
    final CountDownLatch latch = new CountDownLatch(numSessions);
    for (int i = 0; i < numSessions; i++) {
      new Thread(
              new Runnable() {
                @Override
                public void run() {
                  try (Session session = pool.getReadSession()) {
                    latch.countDown();
                  }
                }
              })
          .start();
    }
    session1.close();
    session2.close();
    // Everyone should get session pretty quickly.
    assertThat(latch.await(1, TimeUnit.SECONDS)).isTrue();
  }

  @Test
  public void closeQuicklyDoesNotBlockIndefinitely() throws Exception {
    pool.closeAsync().get();
  }

  @Test
  public void closeAfterInitialCreateDoesNotBlockIndefinitely() throws Exception {
    pool.getReadSession().close();
    pool.closeAsync().get();
  }

  @Test
  public void closeWhenSessionsActiveDoesNotBlockIndefinitely() throws Exception {
    Session session = pool.getReadSession();
    ListenableFuture<Void> future = pool.closeAsync();
    try {
      future.get(5, TimeUnit.SECONDS);
      Assert.fail("Closure future should not have finished");
    } catch (TimeoutException e) {
      // expected
    }
    session.close();
    // Now pool should close.
    future.get();
  }
}
