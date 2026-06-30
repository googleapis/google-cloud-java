/*
 * Copyright 2017 Google LLC
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
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import com.google.cloud.spanner.Options.RpcLockHint;
import com.google.cloud.spanner.Options.RpcOrderBy;
import com.google.cloud.spanner.Options.RpcPriority;
import com.google.cloud.spanner.Options.TransactionOption;
import com.google.spanner.v1.DirectedReadOptions;
import com.google.spanner.v1.DirectedReadOptions.IncludeReplicas;
import com.google.spanner.v1.DirectedReadOptions.ReplicaSelection;
import com.google.spanner.v1.ReadRequest.LockHint;
import com.google.spanner.v1.ReadRequest.OrderBy;
import com.google.spanner.v1.RequestOptions;
import com.google.spanner.v1.RequestOptions.Priority;
import com.google.spanner.v1.TransactionOptions.IsolationLevel;
import com.google.spanner.v1.TransactionOptions.ReadWrite;
import com.google.spanner.v1.TransactionOptions.ReadWrite.ReadLockMode;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/** Unit tests for {@link Options}. */
@RunWith(JUnit4.class)
public class OptionsTest {
  private static final DirectedReadOptions DIRECTED_READ_OPTIONS =
      DirectedReadOptions.newBuilder()
          .setIncludeReplicas(
              IncludeReplicas.newBuilder()
                  .addReplicaSelections(
                      ReplicaSelection.newBuilder().setLocation("us-west1").build()))
          .build();

  @Test
  public void testToRequestOptionsProto() {
    RequestOptions.ClientContext clientContext =
        RequestOptions.ClientContext.newBuilder()
            .putSecureContext(
                "key", com.google.protobuf.Value.newBuilder().setStringValue("value").build())
            .build();
    Options options =
        Options.fromQueryOptions(
            Options.priority(RpcPriority.HIGH),
            Options.tag("tag"),
            Options.clientContext(clientContext));

    RequestOptions protoForStatement = options.toRequestOptionsProto(false);
    assertEquals(RequestOptions.Priority.PRIORITY_HIGH, protoForStatement.getPriority());
    assertEquals("tag", protoForStatement.getRequestTag());
    assertEquals("", protoForStatement.getTransactionTag());
    assertEquals(clientContext, protoForStatement.getClientContext());

    RequestOptions protoForTransaction = options.toRequestOptionsProto(true);
    assertEquals(RequestOptions.Priority.PRIORITY_HIGH, protoForTransaction.getPriority());
    assertEquals("", protoForTransaction.getRequestTag());
    assertEquals("tag", protoForTransaction.getTransactionTag());
    assertEquals(clientContext, protoForTransaction.getClientContext());
  }

  @Test
  public void negativeLimitsNotAllowed() {
    IllegalArgumentException e =
        assertThrows(IllegalArgumentException.class, () -> Options.limit(-1));
    assertNotNull(e.getMessage());
  }

  @Test
  public void zeroLimitNotAllowed() {
    IllegalArgumentException e =
        assertThrows(IllegalArgumentException.class, () -> Options.limit(0));
    assertNotNull(e.getMessage());
  }

  @Test
  public void negativePrefetchChunksNotAllowed() {
    IllegalArgumentException e =
        assertThrows(IllegalArgumentException.class, () -> Options.prefetchChunks(-1));
    assertNotNull(e.getMessage());
  }

  @Test
  public void zeroPrefetchChunksNotAllowed() {
    IllegalArgumentException e =
        assertThrows(IllegalArgumentException.class, () -> Options.prefetchChunks(0));
    assertNotNull(e.getMessage());
  }

  @Test
  public void allOptionsPresent() {
    XGoogSpannerRequestId reqId1 = XGoogSpannerRequestId.of(2, 3, 4, 5);
    Options options =
        Options.fromReadOptions(
            Options.limit(10),
            Options.prefetchChunks(1),
            Options.dataBoostEnabled(true),
            Options.directedRead(DIRECTED_READ_OPTIONS),
            Options.orderBy(RpcOrderBy.NO_ORDER),
            Options.requestId(reqId1),
            Options.lockHint(Options.RpcLockHint.SHARED));
    assertThat(options.hasLimit()).isTrue();
    assertThat(options.limit()).isEqualTo(10);
    assertThat(options.hasPrefetchChunks()).isTrue();
    assertThat(options.prefetchChunks()).isEqualTo(1);
    assertThat(options.hasDataBoostEnabled()).isTrue();
    assertTrue(options.dataBoostEnabled());
    assertTrue(options.hasDirectedReadOptions());
    assertTrue(options.hasOrderBy());
    assertTrue(options.hasLockHint());
    assertEquals(DIRECTED_READ_OPTIONS, options.directedReadOptions());
    assertEquals(options.reqId(), reqId1);
  }

  @Test
  public void allOptionsAbsent() {
    Options options = Options.fromReadOptions();
    assertThat(options.hasLimit()).isFalse();
    assertThat(options.hasPrefetchChunks()).isFalse();
    assertThat(options.hasFilter()).isFalse();
    assertThat(options.hasPageToken()).isFalse();
    assertThat(options.hasPriority()).isFalse();
    assertThat(options.hasTag()).isFalse();
    assertThat(options.hasDataBoostEnabled()).isFalse();
    assertThat(options.hasDirectedReadOptions()).isFalse();
    assertThat(options.hasOrderBy()).isFalse();
    assertThat(options.hasLockHint()).isFalse();
    assertNull(options.withExcludeTxnFromChangeStreams());
    assertThat(options.toString()).isEqualTo("");
    assertThat(options.equals(options)).isTrue();
    assertThat(options.equals(null)).isFalse();
    assertThat(options.equals(this)).isFalse();
    assertNull(options.isolationLevel());
    assertThat(options.hashCode()).isEqualTo(31);
  }

  @Test
  public void listOptionsTest() {
    int pageSize = 3;
    String pageToken = "ptok";
    String filter = "env";
    Options options =
        Options.fromListOptions(
            Options.pageSize(pageSize), Options.pageToken(pageToken), Options.filter(filter));

    assertThat(options.toString())
        .isEqualTo(
            "pageSize: " + pageSize + " pageToken: " + pageToken + " filter: " + filter + " ");

    assertThat(options.hasPageSize()).isTrue();
    assertThat(options.hasPageToken()).isTrue();
    assertThat(options.hasFilter()).isTrue();

    assertThat(options.pageSize()).isEqualTo(pageSize);
    assertThat(options.pageToken()).isEqualTo(pageToken);
    assertThat(options.filter()).isEqualTo(filter);
    assertThat(options.hashCode()).isEqualTo(108027089);
  }

  @Test
  public void listEquality() {
    Options o1;
    Options o2;
    Options o3;

    o1 = Options.fromListOptions();
    o2 = Options.fromListOptions();
    assertThat(o1.equals(o2)).isTrue();

    o2 = Options.fromListOptions(Options.pageSize(1));
    assertThat(o1.equals(o2)).isFalse();
    assertThat(o2.equals(o1)).isFalse();

    o3 = Options.fromListOptions(Options.pageSize(1));
    assertThat(o2.equals(o3)).isTrue();

    o3 = Options.fromListOptions(Options.pageSize(2));
    assertThat(o2.equals(o3)).isFalse();

    o2 = Options.fromListOptions(Options.pageToken("t1"));
    assertThat(o1.equals(o2)).isFalse();

    o3 = Options.fromListOptions(Options.pageToken("t1"));
    assertThat(o2.equals(o3)).isTrue();

    o3 = Options.fromListOptions(Options.pageToken("t2"));
    assertThat(o2.equals(o3)).isFalse();

    o2 = Options.fromListOptions(Options.filter("f1"));
    assertThat(o1.equals(o2)).isFalse();

    o3 = Options.fromListOptions(Options.filter("f1"));
    assertThat(o2.equals(o3)).isTrue();

    o3 = Options.fromListOptions(Options.filter("f2"));
    assertThat(o2.equals(o3)).isFalse();
  }

  @Test
  public void readOptionsTest() {
    int limit = 3;
    String tag = "app=spanner,env=test,action=read";
    boolean dataBoost = true;
    Options options =
        Options.fromReadOptions(
            Options.limit(limit),
            Options.tag(tag),
            Options.dataBoostEnabled(true),
            Options.directedRead(DIRECTED_READ_OPTIONS),
            Options.orderBy(RpcOrderBy.NO_ORDER),
            Options.lockHint(RpcLockHint.SHARED));

    assertThat(options.toString())
        .isEqualTo(
            "limit: "
                + limit
                + " "
                + "tag: "
                + tag
                + " "
                + "dataBoostEnabled: "
                + dataBoost
                + " "
                + "directedReadOptions: "
                + DIRECTED_READ_OPTIONS
                + " "
                + "orderBy: "
                + RpcOrderBy.NO_ORDER
                + " "
                + "lockHint: "
                + RpcLockHint.SHARED
                + " ");
    assertThat(options.tag()).isEqualTo(tag);
    assertEquals(dataBoost, options.dataBoostEnabled());
    assertEquals(DIRECTED_READ_OPTIONS, options.directedReadOptions());
    assertEquals(OrderBy.ORDER_BY_NO_ORDER, options.orderBy());
    assertEquals(LockHint.LOCK_HINT_SHARED, options.lockHint());
  }

  @Test
  public void readEquality() {
    Options o1;
    Options o2;
    Options o3;

    o1 = Options.fromReadOptions();
    o2 = Options.fromReadOptions();
    assertThat(o1.equals(o2)).isTrue();

    o2 = Options.fromReadOptions(Options.limit(1));
    assertThat(o1.equals(o2)).isFalse();
    assertThat(o2.equals(o1)).isFalse();

    o3 = Options.fromReadOptions(Options.limit(1));
    assertThat(o2.equals(o3)).isTrue();

    o3 = Options.fromReadOptions(Options.limit(2));
    assertThat(o2.equals(o3)).isFalse();
  }

  @Test
  public void queryOptionsTest() {
    int chunks = 3;
    String tag = "app=spanner,env=test,action=query";
    boolean dataBoost = true;
    Options options =
        Options.fromQueryOptions(
            Options.prefetchChunks(chunks),
            Options.tag(tag),
            Options.dataBoostEnabled(true),
            Options.directedRead(DIRECTED_READ_OPTIONS));
    assertThat(options.toString())
        .isEqualTo(
            "prefetchChunks: "
                + chunks
                + " "
                + "tag: "
                + tag
                + " "
                + "dataBoostEnabled: "
                + dataBoost
                + " "
                + "directedReadOptions: "
                + DIRECTED_READ_OPTIONS
                + " ");
    assertThat(options.prefetchChunks()).isEqualTo(chunks);
    assertThat(options.tag()).isEqualTo(tag);
    assertEquals(dataBoost, options.dataBoostEnabled());
    assertEquals(DIRECTED_READ_OPTIONS, options.directedReadOptions());
  }

  @Test
  public void testReadOptionsDataBoost() {
    boolean dataBoost = true;
    Options options = Options.fromReadOptions(Options.dataBoostEnabled(true));
    assertTrue(options.hasDataBoostEnabled());
    assertEquals("dataBoostEnabled: " + dataBoost + " ", options.toString());
  }

  @Test
  public void testQueryOptionsDataBoost() {
    boolean dataBoost = true;
    Options options = Options.fromQueryOptions(Options.dataBoostEnabled(true));
    assertTrue(options.hasDataBoostEnabled());
    assertEquals("dataBoostEnabled: " + dataBoost + " ", options.toString());
  }

  @Test
  public void queryEquality() {
    Options o1;
    Options o2;
    Options o3;

    o1 = Options.fromQueryOptions();
    o2 = Options.fromQueryOptions();
    assertThat(o1.equals(o2)).isTrue();

    o2 = Options.fromReadOptions(Options.prefetchChunks(1));
    assertThat(o1.equals(o2)).isFalse();
    assertThat(o2.equals(o1)).isFalse();

    o3 = Options.fromReadOptions(Options.prefetchChunks(1));
    assertThat(o2.equals(o3)).isTrue();

    o3 = Options.fromReadOptions(Options.prefetchChunks(2));
    assertThat(o2.equals(o3)).isFalse();
  }

  @Test
  public void testFromTransactionOptions_toStringNoOptions() {
    Options options = Options.fromTransactionOptions();
    assertThat(options.toString()).isEqualTo("");
  }

  @Test
  public void testFromTransactionOptions_toStringWithCommitStats() {
    Options options = Options.fromTransactionOptions(Options.commitStats());
    assertThat(options.toString()).contains("withCommitStats: true");
  }

  @Test
  public void testTransactionOptions_noOptionsAreEqual() {
    Options option1 = Options.fromTransactionOptions();
    Options option2 = Options.fromTransactionOptions();
    assertEquals(option1, option2);
  }

  @Test
  public void testTransactionOptions_withCommitStatsAreEqual() {
    Options option1 = Options.fromTransactionOptions(Options.commitStats());
    Options option2 = Options.fromTransactionOptions(Options.commitStats());
    assertEquals(option1, option2);
  }

  @Test
  public void testTransactionOptions_withCommitStatsAndOtherOptionAreNotEqual() {
    Options option1 = Options.fromTransactionOptions(Options.commitStats());
    Options option2 = Options.fromQueryOptions(Options.prefetchChunks(10));
    assertNotEquals(option1, option2);
  }

  @Test
  public void testTransactionOptions_noOptionsHashCode() {
    Options option1 = Options.fromTransactionOptions();
    Options option2 = Options.fromTransactionOptions();
    assertEquals(option2.hashCode(), option1.hashCode());
  }

  @Test
  public void testTransactionOptions_withCommitStatsHashCode() {
    Options option1 = Options.fromTransactionOptions(Options.commitStats());
    Options option2 = Options.fromTransactionOptions(Options.commitStats());
    assertEquals(option2.hashCode(), option1.hashCode());
  }

  @Test
  public void testTransactionOptions_withCommitStatsAndOtherOptionHashCode() {
    Options option1 = Options.fromTransactionOptions(Options.commitStats());
    Options option2 = Options.fromQueryOptions(Options.prefetchChunks(10));
    assertNotEquals(option2.hashCode(), option1.hashCode());
  }

  @Test
  public void testTransactionOptionsPriority() {
    RpcPriority priority = RpcPriority.HIGH;
    Options options = Options.fromTransactionOptions(Options.priority(priority));
    assertTrue(options.hasPriority());
    assertEquals("priority: " + priority + " ", options.toString());
  }

  @Test
  public void testTransactionOptionsIsolationLevel() {
    Options options =
        Options.fromTransactionOptions(Options.isolationLevel(IsolationLevel.REPEATABLE_READ));
    assertEquals(options.isolationLevel(), IsolationLevel.REPEATABLE_READ);
    assertEquals(
        "isolationLevel: " + IsolationLevel.REPEATABLE_READ.name() + " ", options.toString());
  }

  @Test
  public void testReadOptionsOrderBy() {
    RpcOrderBy orderBy = RpcOrderBy.NO_ORDER;
    Options options = Options.fromReadOptions(Options.orderBy(orderBy));
    assertTrue(options.hasOrderBy());
    assertEquals("orderBy: " + orderBy + " ", options.toString());
  }

  @Test
  public void testReadOptionsLockHint() {
    RpcLockHint lockHint = RpcLockHint.SHARED;
    Options options = Options.fromReadOptions(Options.lockHint(lockHint));
    assertTrue(options.hasLockHint());
    assertEquals("lockHint: " + lockHint + " ", options.toString());
  }

  @Test
  public void testReadOptionsWithOrderByEquality() {
    Options optionsWithNoOrderBy1 = Options.fromReadOptions(Options.orderBy(RpcOrderBy.NO_ORDER));
    Options optionsWithNoOrderBy2 = Options.fromReadOptions(Options.orderBy(RpcOrderBy.NO_ORDER));
    assertTrue(optionsWithNoOrderBy1.equals(optionsWithNoOrderBy2));

    Options optionsWithPkOrder = Options.fromReadOptions(Options.orderBy(RpcOrderBy.PRIMARY_KEY));
    assertFalse(optionsWithNoOrderBy1.equals(optionsWithPkOrder));
  }

  @Test
  public void testReadOptionsWithLockHintEquality() {
    Options optionsWithSharedLockHint1 =
        Options.fromReadOptions(Options.lockHint(RpcLockHint.SHARED));
    Options optionsWithSharedLockHint2 =
        Options.fromReadOptions(Options.lockHint(RpcLockHint.SHARED));
    assertEquals(optionsWithSharedLockHint1, optionsWithSharedLockHint2);

    Options optionsWithExclusiveLock =
        Options.fromReadOptions(Options.lockHint(RpcLockHint.EXCLUSIVE));
    assertNotEquals(optionsWithSharedLockHint1, optionsWithExclusiveLock);
  }

  @Test
  public void testQueryOptionsPriority() {
    RpcPriority priority = RpcPriority.MEDIUM;
    Options options = Options.fromQueryOptions(Options.priority(priority));
    assertTrue(options.hasPriority());
    assertEquals("priority: " + priority + " ", options.toString());
  }

  @Test
  public void testReadOptionsPriority() {
    RpcPriority priority = RpcPriority.LOW;
    Options options = Options.fromReadOptions(Options.priority(priority));
    assertTrue(options.hasPriority());
    assertEquals("priority: " + priority + " ", options.toString());
  }

  @Test
  public void testUpdateOptionsPriority() {
    RpcPriority priority = RpcPriority.LOW;
    Options options = Options.fromUpdateOptions(Options.priority(priority));
    assertTrue(options.hasPriority());
    assertEquals("priority: " + priority + " ", options.toString());
  }

  @Test
  public void testRpcPriorityEnumFromProto() {
    assertEquals(RpcPriority.fromProto(Priority.PRIORITY_LOW), RpcPriority.LOW);
    assertEquals(RpcPriority.fromProto(Priority.PRIORITY_MEDIUM), RpcPriority.MEDIUM);
    assertEquals(RpcPriority.fromProto(Priority.PRIORITY_HIGH), RpcPriority.HIGH);
    assertEquals(RpcPriority.fromProto(Priority.PRIORITY_UNSPECIFIED), RpcPriority.UNSPECIFIED);
    assertEquals(RpcPriority.fromProto(null), RpcPriority.UNSPECIFIED);
  }

  @Test
  public void testTransactionOptionsHashCode() {
    Options option1 = Options.fromTransactionOptions();
    Options option2 = Options.fromTransactionOptions();
    assertEquals(option1.hashCode(), option2.hashCode());
  }

  @Test
  public void testTransactionOptionsWithPriorityEquality() {
    Options optionsWithHighPriority1 =
        Options.fromTransactionOptions(Options.priority(RpcPriority.HIGH));
    Options optionsWithHighPriority2 =
        Options.fromTransactionOptions(Options.priority(RpcPriority.HIGH));
    assertEquals(optionsWithHighPriority1, optionsWithHighPriority2);

    Options optionsWithMediumPriority =
        Options.fromTransactionOptions(Options.priority(RpcPriority.MEDIUM));
    assertNotEquals(optionsWithHighPriority1, optionsWithMediumPriority);
  }

  @Test
  public void testTransactionOptionsWithPriorityHashCode() {
    Options optionsWithHighPriority1 =
        Options.fromTransactionOptions(Options.priority(RpcPriority.HIGH));
    Options optionsWithHighPriority2 =
        Options.fromTransactionOptions(Options.priority(RpcPriority.HIGH));
    assertEquals(optionsWithHighPriority1.hashCode(), optionsWithHighPriority2.hashCode());

    Options optionsWithMediumPriority =
        Options.fromTransactionOptions(Options.priority(RpcPriority.MEDIUM));
    assertNotEquals(optionsWithHighPriority1.hashCode(), optionsWithMediumPriority.hashCode());
  }

  @Test
  public void testUpdateOptionsEquality() {
    Options option1 = Options.fromUpdateOptions();
    Options option2 = Options.fromUpdateOptions();
    assertEquals(option1, option2);
  }

  @Test
  public void testUpdateOptionsHashCode() {
    Options option1 = Options.fromUpdateOptions();
    Options option2 = Options.fromUpdateOptions();
    assertEquals(option1.hashCode(), option2.hashCode());
  }

  @Test
  public void testUpdateOptionsWithPriorityEquality() {
    Options optionsWithHighPriority1 =
        Options.fromUpdateOptions(Options.priority(RpcPriority.HIGH));
    Options optionsWithHighPriority2 =
        Options.fromUpdateOptions(Options.priority(RpcPriority.HIGH));
    assertEquals(optionsWithHighPriority1, optionsWithHighPriority2);

    Options optionsWithMediumPriority =
        Options.fromUpdateOptions(Options.priority(RpcPriority.MEDIUM));
    assertNotEquals(optionsWithHighPriority1, optionsWithMediumPriority);
  }

  @Test
  public void testUpdateOptionsWithPriorityHashCode() {
    Options optionsWithHighPriority1 =
        Options.fromUpdateOptions(Options.priority(RpcPriority.HIGH));
    Options optionsWithHighPriority2 =
        Options.fromUpdateOptions(Options.priority(RpcPriority.HIGH));
    assertEquals(optionsWithHighPriority1.hashCode(), optionsWithHighPriority2.hashCode());

    Options optionsWithMediumPriority =
        Options.fromUpdateOptions(Options.priority(RpcPriority.MEDIUM));
    assertNotEquals(optionsWithHighPriority1.hashCode(), optionsWithMediumPriority.hashCode());
  }

  @Test
  public void testQueryOptionsEquality() {
    Options option1 = Options.fromQueryOptions();
    Options option2 = Options.fromQueryOptions();
    assertEquals(option1, option2);
  }

  @Test
  public void testQueryOptionsHashCode() {
    Options option1 = Options.fromQueryOptions();
    Options option2 = Options.fromQueryOptions();
    assertEquals(option1.hashCode(), option2.hashCode());
  }

  @Test
  public void testQueryOptionsWithPriorityEquality() {
    Options optionsWithHighPriority1 = Options.fromQueryOptions(Options.priority(RpcPriority.HIGH));
    Options optionsWithHighPriority2 = Options.fromQueryOptions(Options.priority(RpcPriority.HIGH));
    assertEquals(optionsWithHighPriority1, optionsWithHighPriority2);

    Options optionsWithMediumPriority =
        Options.fromQueryOptions(Options.priority(RpcPriority.MEDIUM));
    assertNotEquals(optionsWithHighPriority1, optionsWithMediumPriority);

    Options optionsWithHighPriorityAndBufferRows =
        Options.fromQueryOptions(Options.priority(RpcPriority.HIGH), Options.bufferRows(10));
    assertNotEquals(optionsWithHighPriorityAndBufferRows, optionsWithHighPriority1);
  }

  @Test
  public void testQueryOptionsWithPriorityHashCode() {
    Options optionsWithHighPriority1 = Options.fromQueryOptions(Options.priority(RpcPriority.HIGH));
    Options optionsWithHighPriority2 = Options.fromQueryOptions(Options.priority(RpcPriority.HIGH));
    assertEquals(optionsWithHighPriority1.hashCode(), optionsWithHighPriority2.hashCode());

    Options optionsWithMediumPriority =
        Options.fromQueryOptions(Options.priority(RpcPriority.MEDIUM));
    assertNotEquals(optionsWithHighPriority1.hashCode(), optionsWithMediumPriority.hashCode());

    Options optionsWithHighPriorityAndBufferRows =
        Options.fromQueryOptions(Options.priority(RpcPriority.HIGH), Options.bufferRows(10));
    assertNotEquals(
        optionsWithHighPriorityAndBufferRows.hashCode(), optionsWithHighPriority1.hashCode());
  }

  @Test
  public void testReadOptionsEquality() {
    Options option1 = Options.fromReadOptions();
    Options option2 = Options.fromReadOptions();
    assertEquals(option1, option2);
  }

  @Test
  public void testReadOptionsHashCode() {
    Options option1 = Options.fromReadOptions();
    Options option2 = Options.fromReadOptions();
    assertEquals(option1.hashCode(), option2.hashCode());
  }

  @Test
  public void testReadOptionsWithPriorityEquality() {
    Options optionsWithHighPriority1 = Options.fromReadOptions(Options.priority(RpcPriority.HIGH));
    Options optionsWithHighPriority2 = Options.fromReadOptions(Options.priority(RpcPriority.HIGH));
    assertEquals(optionsWithHighPriority1, optionsWithHighPriority2);

    Options optionsWithMediumPriority =
        Options.fromReadOptions(Options.priority(RpcPriority.MEDIUM));
    assertNotEquals(optionsWithHighPriority1, optionsWithMediumPriority);

    Options optionsWithHighPriorityAndBufferRows =
        Options.fromReadOptions(Options.priority(RpcPriority.HIGH), Options.bufferRows(10));
    assertNotEquals(optionsWithHighPriorityAndBufferRows, optionsWithHighPriority1);
  }

  @Test
  public void testReadOptionsWithPriorityHashCode() {
    Options optionsWithHighPriority1 = Options.fromReadOptions(Options.priority(RpcPriority.HIGH));
    Options optionsWithHighPriority2 = Options.fromReadOptions(Options.priority(RpcPriority.HIGH));
    assertEquals(optionsWithHighPriority1.hashCode(), optionsWithHighPriority2.hashCode());

    Options optionsWithMediumPriority =
        Options.fromReadOptions(Options.priority(RpcPriority.MEDIUM));
    assertNotEquals(optionsWithHighPriority1.hashCode(), optionsWithMediumPriority.hashCode());

    Options optionsWithHighPriorityAndBufferRows =
        Options.fromReadOptions(Options.priority(RpcPriority.HIGH), Options.bufferRows(10));
    assertNotEquals(
        optionsWithHighPriorityAndBufferRows.hashCode(), optionsWithHighPriority1.hashCode());
  }

  @Test
  public void testFromUpdateOptions() {
    Options options = Options.fromUpdateOptions();
    assertThat(options.toString()).isEqualTo("");
  }

  @Test
  public void testTransactionOptions() {
    RpcPriority prio = RpcPriority.HIGH;
    Options options = Options.fromTransactionOptions(Options.priority(prio));
    assertThat(options.toString()).isEqualTo("priority: " + prio + " ");
    assertThat(options.priority()).isEqualTo(Priority.PRIORITY_HIGH);
  }

  @Test
  public void testTransactionOptionsDefaultEqual() {
    Options options1 = Options.fromTransactionOptions();
    Options options2 = Options.fromTransactionOptions();
    assertEquals(options1, options2);
  }

  @Test
  public void testTransactionOptionsPriorityEquality() {
    Options options1 = Options.fromTransactionOptions(Options.priority(RpcPriority.HIGH));
    Options options2 = Options.fromTransactionOptions(Options.priority(RpcPriority.HIGH));
    Options options3 = Options.fromTransactionOptions();
    Options options4 = Options.fromTransactionOptions(Options.priority(RpcPriority.LOW));

    assertEquals(options1, options2);
    assertNotEquals(options1, options3);
    assertNotEquals(options1, options4);
    assertNotEquals(options2, options3);
    assertNotEquals(options2, options4);
  }

  @Test
  public void updateOptionsTest() {
    String tag = "app=spanner,env=test";
    Options options = Options.fromUpdateOptions(Options.tag(tag));

    assertEquals("tag: " + tag + " ", options.toString());
    assertTrue(options.hasTag());
    assertThat(options.tag()).isEqualTo(tag);
    assertThat(options.hashCode()).isEqualTo(-2118248262);
  }

  @Test
  public void updateEquality() {
    Options o1;
    Options o2;
    Options o3;

    o1 = Options.fromUpdateOptions();
    o2 = Options.fromUpdateOptions();
    assertThat(o1.equals(o2)).isTrue();

    o2 = Options.fromUpdateOptions(Options.tag("app=spanner,env=test"));
    assertThat(o1.equals(o2)).isFalse();
    assertThat(o2.equals(o1)).isFalse();

    o3 = Options.fromUpdateOptions(Options.tag("app=spanner,env=test"));
    assertThat(o2.equals(o3)).isTrue();

    o3 = Options.fromUpdateOptions(Options.tag("app=spanner,env=stage"));
    assertThat(o2.equals(o3)).isFalse();
  }

  @Test
  public void transactionOptionsTest() {
    String tag = "app=spanner,env=test";
    Options options = Options.fromTransactionOptions(Options.tag(tag));

    assertEquals("tag: " + tag + " ", options.toString());
    assertTrue(options.hasTag());
    assertThat(options.tag()).isEqualTo(tag);
    assertThat(options.hashCode()).isEqualTo(-2118248262);
  }

  @Test
  public void transactionEquality() {
    Options o1;
    Options o2;
    Options o3;

    o1 = Options.fromTransactionOptions();
    o2 = Options.fromTransactionOptions();
    assertThat(o1.equals(o2)).isTrue();

    o2 = Options.fromTransactionOptions(Options.tag("app=spanner,env=test"));
    assertThat(o1.equals(o2)).isFalse();
    assertThat(o2.equals(o1)).isFalse();

    o3 = Options.fromTransactionOptions(Options.tag("app=spanner,env=test"));
    assertThat(o2.equals(o3)).isTrue();

    o3 = Options.fromTransactionOptions(Options.tag("app=spanner,env=stage"));
    assertThat(o2.equals(o3)).isFalse();
  }

  @Test
  public void optimisticLockEquality() {
    Options option1 = Options.fromTransactionOptions(Options.optimisticLock());
    Options option2 = Options.fromTransactionOptions(Options.optimisticLock());
    Options option3 = Options.fromReadOptions();

    assertEquals(option1, option2);
    assertNotEquals(option1, option3);
  }

  @Test
  public void readLockModeEquality() {
    Options option1 = Options.fromTransactionOptions(Options.readLockMode(ReadLockMode.OPTIMISTIC));
    Options option2 = Options.fromTransactionOptions(Options.readLockMode(ReadLockMode.OPTIMISTIC));
    Options option3 =
        Options.fromTransactionOptions(Options.readLockMode(ReadLockMode.PESSIMISTIC));
    Options option4 = Options.fromReadOptions();

    assertEquals(option1, option2);
    assertNotEquals(option1, option3);
    assertNotEquals(option1, option4);
  }

  @Test
  public void optimisticLockHashCode() {
    Options option1 = Options.fromTransactionOptions(Options.optimisticLock());
    Options option2 = Options.fromTransactionOptions(Options.optimisticLock());
    Options option3 = Options.fromReadOptions();

    assertEquals(option1.hashCode(), option2.hashCode());
    assertNotEquals(option1.hashCode(), option3.hashCode());
  }

  @Test
  public void readLockModeHashCode() {
    Options option1 = Options.fromTransactionOptions(Options.readLockMode(ReadLockMode.OPTIMISTIC));
    Options option2 = Options.fromTransactionOptions(Options.readLockMode(ReadLockMode.OPTIMISTIC));
    Options option3 =
        Options.fromTransactionOptions(Options.readLockMode(ReadLockMode.PESSIMISTIC));
    Options option4 = Options.fromReadOptions();

    assertEquals(option1.hashCode(), option2.hashCode());
    assertNotEquals(option1.hashCode(), option3.hashCode());
    assertNotEquals(option1.hashCode(), option4.hashCode());
  }

  @Test
  public void directedReadEquality() {
    Options option1 = Options.fromReadOptions(Options.directedRead(DIRECTED_READ_OPTIONS));
    Options option2 = Options.fromReadOptions(Options.directedRead(DIRECTED_READ_OPTIONS));
    Options option3 = Options.fromTransactionOptions();

    assertEquals(option1, option2);
    assertNotEquals(option1, option3);
  }

  @Test
  public void directedReadHashCode() {
    Options option1 = Options.fromReadOptions(Options.directedRead(DIRECTED_READ_OPTIONS));
    Options option2 = Options.fromReadOptions(Options.directedRead(DIRECTED_READ_OPTIONS));
    Options option3 = Options.fromTransactionOptions();

    assertEquals(option1.hashCode(), option2.hashCode());
    assertNotEquals(option1.hashCode(), option3.hashCode());
  }

  @Test
  public void directedReadsNullNotAllowed() {
    assertThrows(NullPointerException.class, () -> Options.directedRead(null));
  }

  @Test
  public void transactionOptionsExcludeTxnFromChangeStreams() {
    Options option1 = Options.fromTransactionOptions(Options.excludeTxnFromChangeStreams());
    Options option2 = Options.fromTransactionOptions(Options.excludeTxnFromChangeStreams());
    Options option3 = Options.fromTransactionOptions();

    assertEquals(option1, option2);
    assertEquals(option1.hashCode(), option2.hashCode());
    assertNotEquals(option1, option3);
    assertNotEquals(option1.hashCode(), option3.hashCode());

    assertTrue(option1.withExcludeTxnFromChangeStreams());
    assertThat(option1.toString()).contains("withExcludeTxnFromChangeStreams: true");

    assertNull(option3.withExcludeTxnFromChangeStreams());
    assertThat(option3.toString()).doesNotContain("withExcludeTxnFromChangeStreams: true");
  }

  @Test
  public void transactionOptionsIsolationLevel() {
    Options option1 =
        Options.fromTransactionOptions(Options.isolationLevel(IsolationLevel.REPEATABLE_READ));
    Options option2 =
        Options.fromTransactionOptions(Options.isolationLevel(IsolationLevel.REPEATABLE_READ));
    Options option3 = Options.fromTransactionOptions();

    assertEquals(option1, option2);
    assertEquals(option1.hashCode(), option2.hashCode());
    assertNotEquals(option1, option3);
    assertNotEquals(option1.hashCode(), option3.hashCode());

    assertEquals(option1.isolationLevel(), IsolationLevel.REPEATABLE_READ);
    assertThat(option1.toString())
        .contains("isolationLevel: " + IsolationLevel.REPEATABLE_READ.name());

    assertNull(option3.isolationLevel());
    assertThat(option3.toString())
        .doesNotContain("isolationLevel: " + IsolationLevel.REPEATABLE_READ.name());
  }

  @Test
  public void updateOptionsExcludeTxnFromChangeStreams() {
    Options option1 = Options.fromUpdateOptions(Options.excludeTxnFromChangeStreams());
    Options option2 = Options.fromUpdateOptions(Options.excludeTxnFromChangeStreams());
    Options option3 = Options.fromUpdateOptions();

    assertEquals(option1, option2);
    assertEquals(option1.hashCode(), option2.hashCode());
    assertNotEquals(option1, option3);
    assertNotEquals(option1.hashCode(), option3.hashCode());

    assertTrue(option1.withExcludeTxnFromChangeStreams());
    assertThat(option1.toString()).contains("withExcludeTxnFromChangeStreams: true");

    assertNull(option3.withExcludeTxnFromChangeStreams());
    assertThat(option3.toString()).doesNotContain("withExcludeTxnFromChangeStreams: true");
  }

  @Test
  public void testLastStatement() {
    Options option1 = Options.fromUpdateOptions(Options.lastStatement());
    Options option2 = Options.fromUpdateOptions(Options.lastStatement());
    Options option3 = Options.fromUpdateOptions();

    assertEquals(option1, option2);
    assertEquals(option1.hashCode(), option2.hashCode());
    assertNotEquals(option1, option3);
    assertNotEquals(option1.hashCode(), option3.hashCode());

    assertTrue(option1.isLastStatement());
    assertThat(option1.toString()).contains("lastStatement: true");

    assertNull(option3.isLastStatement());
    assertThat(option3.toString()).doesNotContain("lastStatement: true");
  }

  @Test
  public void testTransactionOptionCombine_WithNoSpannerOptions() {
    com.google.spanner.v1.TransactionOptions primaryOptions =
        com.google.spanner.v1.TransactionOptions.newBuilder()
            .setIsolationLevel(IsolationLevel.SERIALIZABLE)
            .setExcludeTxnFromChangeStreams(true)
            .setReadWrite(ReadWrite.newBuilder().setReadLockMode(ReadLockMode.PESSIMISTIC))
            .build();
    com.google.spanner.v1.TransactionOptions spannerOptions =
        com.google.spanner.v1.TransactionOptions.newBuilder()
            .setIsolationLevel(IsolationLevel.REPEATABLE_READ)
            .build();
    com.google.spanner.v1.TransactionOptions combinedOptions =
        spannerOptions.toBuilder().mergeFrom(primaryOptions).build();
    assertEquals(combinedOptions.getIsolationLevel(), IsolationLevel.SERIALIZABLE);
    assertTrue(combinedOptions.getExcludeTxnFromChangeStreams());
    assertEquals(
        combinedOptions.getReadWrite(),
        ReadWrite.newBuilder().setReadLockMode(ReadLockMode.PESSIMISTIC).build());
  }

  @Test
  public void testOptions_WithMultipleDifferentIsolationLevels() {
    TransactionOption[] transactionOptions = {
      Options.isolationLevel(IsolationLevel.REPEATABLE_READ),
      Options.isolationLevel(IsolationLevel.SERIALIZABLE)
    };
    Options options = Options.fromTransactionOptions(transactionOptions);
    assertEquals(options.isolationLevel(), IsolationLevel.SERIALIZABLE);
  }

  @Test
  public void testRequestId() {
    XGoogSpannerRequestId reqId1 = XGoogSpannerRequestId.of(1, 2, 3, 4);
    XGoogSpannerRequestId reqId2 = XGoogSpannerRequestId.of(2, 3, 4, 5);
    Options option1 = Options.fromUpdateOptions(Options.requestId(reqId1));
    Options option1Prime = Options.fromUpdateOptions(Options.requestId(reqId1));
    Options option2 = Options.fromUpdateOptions(Options.requestId(reqId2));
    Options option3 = Options.fromUpdateOptions();

    assertEquals(option1, option1Prime);
    assertNotEquals(option1, option2);
    assertEquals(option1.hashCode(), option1Prime.hashCode());
    assertNotEquals(option1, option2);
    assertNotEquals(option1, option3);
    assertNotEquals(option1.hashCode(), option3.hashCode());

    assertTrue(option1.hasReqId());
    assertThat(option1.toString()).contains("requestId: " + reqId1.toString());

    assertFalse(option3.hasReqId());
    assertThat(option3.toString()).doesNotContain("requestId");
  }

  @Test
  public void testRequestIdOptionEqualsAndHashCode() {
    XGoogSpannerRequestId reqId1 = XGoogSpannerRequestId.of(1, 2, 3, 4);
    XGoogSpannerRequestId reqId2 = XGoogSpannerRequestId.of(2, 3, 4, 5);
    Options.RequestIdOption opt1 = Options.requestId(reqId1);
    Options.RequestIdOption opt1Prime = Options.requestId(reqId1);
    Options.RequestIdOption opt2 = Options.requestId(reqId2);

    assertTrue(opt1.equals(opt1));
    assertTrue(opt1.equals(opt1Prime));
    assertEquals(opt1.hashCode(), opt1Prime.hashCode());
    assertFalse(opt1.equals(opt2));
    assertNotEquals(opt1, opt2);
    assertNotEquals(opt1.hashCode(), opt2.hashCode());
  }

  @Test
  public void testOptions_WithMultipleDifferentRequestIds() {
    XGoogSpannerRequestId reqId1 = XGoogSpannerRequestId.of(1, 1, 1, 1);
    XGoogSpannerRequestId reqId2 = XGoogSpannerRequestId.of(1, 1, 1, 2);
    TransactionOption[] transactionOptions = {
      Options.requestId(reqId1), Options.requestId(reqId2),
    };
    Options options = Options.fromTransactionOptions(transactionOptions);
    assertNotEquals(options.reqId(), reqId1);
    assertEquals(options.reqId(), reqId2);
  }
}
