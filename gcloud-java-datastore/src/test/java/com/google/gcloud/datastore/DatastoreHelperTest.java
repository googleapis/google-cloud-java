/*
 * Copyright 2015 Google Inc. All Rights Reserved.
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

package com.google.gcloud.datastore;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.createStrictMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterators;
import com.google.gcloud.datastore.Datastore.TransactionCallable;

import org.easymock.EasyMock;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

public class DatastoreHelperTest {

  @Test
  public void testNewKeyFactory() {
    DatastoreOptions options = createMock(DatastoreOptions.class);
    expect(options.projectId()).andReturn("ds1").once();
    expect(options.namespace()).andReturn("ns1").once();
    replay(options);
    KeyFactory keyFactory = DatastoreHelper.newKeyFactory(options);
    Key key = keyFactory.kind("k").newKey("bla");
    assertEquals("ds1", key.projectId());
    assertEquals("ns1", key.namespace());
    assertEquals("k", key.kind());
    assertEquals("bla", key.name());
    verify(options);
  }

  @Test
  public void testAllocateId() throws Exception {
    Datastore datastore = createStrictMock(Datastore.class);
    IncompleteKey pKey1 = IncompleteKey.builder("ds", "k").build();
    Key key1 = Key.builder(pKey1, 1).build();
    expect(datastore.allocateId(new IncompleteKey[] {pKey1}))
        .andReturn(Collections.singletonList(key1));
    replay(datastore);
    assertEquals(key1, DatastoreHelper.allocateId(datastore, pKey1));
    verify(datastore);
  }

  @Test
  public void testGetWithDatastore() throws Exception {
    Datastore datastore = createStrictMock(Datastore.class);
    IncompleteKey pKey1 = IncompleteKey.builder("ds", "k").build();
    Key key1 = Key.builder(pKey1, 1).build();
    Entity entity1 = Entity.builder(key1).build();
    Key key2 = Key.builder(pKey1, 2).build();
    ReadOption eventualConsistency = ReadOption.eventualConsistency();
    expect(datastore.get(Collections.singletonList(key1)))
        .andReturn(Collections.singletonList(entity1).iterator());
    expect(datastore.get(Collections.singletonList(key2)))
        .andReturn(Collections.<Entity>emptyIterator());
    expect(datastore.get(Collections.singletonList(key1), eventualConsistency))
        .andReturn(Collections.singletonList(entity1).iterator());
    replay(datastore);
    assertEquals(entity1, DatastoreHelper.get(datastore, key1));
    assertNull(DatastoreHelper.get(datastore, key2));
    assertEquals(entity1, DatastoreHelper.get(datastore, key1, eventualConsistency));
    verify(datastore);
  }

  @Test
  public void testGetWithTransaction() throws Exception {
    Transaction transaction = createStrictMock(Transaction.class);
    IncompleteKey pKey1 = IncompleteKey.builder("ds", "k").build();
    Key key1 = Key.builder(pKey1, 1).build();
    Entity entity1 = Entity.builder(key1).build();
    Key key2 = Key.builder(pKey1, 2).build();
    expect(transaction.get(new Key[] {key1}))
        .andReturn(Collections.singletonList(entity1).iterator());
    expect(transaction.get(new Key[] {key2})).andReturn(Collections.<Entity>emptyIterator());
    replay(transaction);
    assertEquals(entity1, DatastoreHelper.get(transaction, key1));
    assertNull(DatastoreHelper.get(transaction, key2));
    verify(transaction);
  }

  @Test
  public void testAdd() throws Exception {
    Datastore datastore = createStrictMock(Datastore.class);
    IncompleteKey pKey = IncompleteKey.builder("ds", "k").build();
    Key key = Key.builder(pKey, 1).build();
    Entity entity = Entity.builder(key).build();
    expect(datastore.add(new Entity[] {entity})).andReturn(Collections.singletonList(entity));
    replay(datastore);
    assertEquals(entity, DatastoreHelper.add(datastore, entity));
    verify(datastore);
  }

  @Test
  public void testFetchWithDatastore() throws Exception {
    Datastore datastore = createStrictMock(Datastore.class);
    IncompleteKey pKey1 = IncompleteKey.builder("ds", "k").build();
    Key key1 = Key.builder(pKey1, 1).build();
    Key key2 = Key.builder(pKey1, "a").build();
    Entity entity1 = Entity.builder(key1).build();
    Entity entity2 = Entity.builder(key2).build();
    ReadOption eventualConsistency = ReadOption.eventualConsistency();
    expect(datastore.get(ImmutableList.of(key1, key2)))
        .andReturn(Iterators.forArray(entity1, entity2))
        .once();
    expect(datastore.get(ImmutableList.of(key1, key2), eventualConsistency))
        .andReturn(Iterators.forArray(entity1, entity2))
        .once();
    replay(datastore);
    List<Entity> values = DatastoreHelper.fetch(datastore, new Key[] {key1, key2});
    assertEquals(2, values.size());
    assertEquals(entity1, values.get(0));
    assertEquals(entity2, values.get(1));
    values = DatastoreHelper.fetch(datastore, new Key[] {key1, key2}, eventualConsistency);
    assertEquals(2, values.size());
    assertEquals(entity1, values.get(0));
    assertEquals(entity2, values.get(1));
    verify(datastore);
  }

  @Test
  public void testFetchWithTransaction() throws Exception {
    Transaction transaction = createStrictMock(Transaction.class);
    IncompleteKey pKey1 = IncompleteKey.builder("ds", "k").build();
    Key key1 = Key.builder(pKey1, 1).build();
    Key key2 = Key.builder(pKey1, "a").build();
    Entity entity1 = Entity.builder(key1).build();
    Entity entity2 = Entity.builder(key2).build();
    expect(transaction.get(new Key[] {key1, key2}))
        .andReturn(Iterators.forArray(entity1, entity2))
        .once();
    replay(transaction);
    List<Entity> values = DatastoreHelper.fetch(transaction, new Key[] {key1, key2});
    assertEquals(2, values.size());
    assertEquals(entity1, values.get(0));
    assertEquals(entity2, values.get(1));
    verify(transaction);
  }

  @Test
  public void testRunInTransaction() throws Exception {
    final Datastore datastore = createStrictMock(Datastore.class);
    final Transaction transaction = createStrictMock(Transaction.class);
    expect(datastore.newTransaction()).andReturn(transaction).once();
    expect(transaction.active()).andReturn(true).once();
    expect(transaction.commit()).andReturn(null).once();
    expect(transaction.active()).andReturn(false).once();
    replay(datastore, transaction);
    String value = DatastoreHelper.runInTransaction(datastore,
        new TransactionCallable<String>() {
          @Override
          public String run(DatastoreReaderWriter readerWriter) {
            assertTrue(transaction.active());
            assertSame(transaction, readerWriter);
            return "done";
          }
        });
    verify(datastore, transaction);
    assertEquals("done", value);
  }

  @Test
  public void testRunInTransactionWithException() throws Exception {
    final Datastore datastore = createStrictMock(Datastore.class);
    final Transaction transaction = createStrictMock(Transaction.class);
    expect(datastore.newTransaction()).andReturn(transaction).once();
    expect(transaction.active()).andReturn(true).once();
    transaction.rollback();
    EasyMock.expectLastCall().once();
    expect(transaction.active()).andReturn(false).once();
    replay(datastore, transaction);
    try {
      DatastoreHelper.runInTransaction(datastore, new TransactionCallable<Void>() {
        @Override
        public Void run(DatastoreReaderWriter readerWriter) throws Exception {
          assertTrue(transaction.active());
          assertSame(transaction, readerWriter);
          throw new Exception("Bla");
        }
      });
      fail("DatastoreException was expected");
    } catch (DatastoreException ex) {
      assertEquals("Bla", ex.getCause().getMessage());
    }
    verify(datastore, transaction);
  }
}
