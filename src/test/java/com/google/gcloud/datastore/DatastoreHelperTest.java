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

import static junit.framework.TestCase.assertTrue;
import static junit.framework.TestCase.fail;
import static org.easymock.EasyMock.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import com.google.common.collect.Iterators;
import com.google.gcloud.datastore.DatastoreService.TransactionCallable;
import org.easymock.EasyMock;
import org.junit.Test;

import java.util.List;

public class DatastoreHelperTest {

  @Test
  public void testFetch() throws Exception {
    DatastoreService datastoreService = createStrictMock(DatastoreService.class);
    IncompleteKey pKey1 = IncompleteKey.builder("ds", "k").build();
    Key key1 = Key.builder(pKey1, 1).build();
    Key key2 = Key.builder(pKey1, "a").build();
    Entity entity1 = Entity.builder(key1).build();
    Entity entity2 = Entity.builder(key2).build();
    expect(datastoreService.get(key1, key2)).andReturn(Iterators.forArray(entity1, entity2)).once();
    replay(datastoreService);
    List<Entity> values = DatastoreHelper.fetch(datastoreService, key1, key2);
    assertEquals(2, values.size());
    assertEquals(entity1, values.get(0));
    assertEquals(entity2, values.get(1));
    verify(datastoreService);
  }

  @Test
  public void testRunInTransaction() throws Exception {
    final DatastoreService datastoreService = createStrictMock(DatastoreService.class);
    final Transaction transaction = createStrictMock(Transaction.class);
    expect(datastoreService.newTransaction()).andReturn(transaction).once();
    expect(transaction.active()).andReturn(true).once();
    expect(transaction.commit()).andReturn(null).once();
    expect(transaction.active()).andReturn(false).once();
    replay(datastoreService, transaction);
    String value = DatastoreHelper.runInTransaction(datastoreService,
        new TransactionCallable<String>() {
          @Override
          public String run(DatastoreReaderWriter readerWriter) {
            assertTrue(transaction.active());
            assertSame(transaction, readerWriter);
            return "done";
          }
        });
    verify(datastoreService, transaction);
    assertEquals("done", value);
  }

  @Test
  public void testRunInTransactionWithException() throws Exception {
    final DatastoreService datastoreService = createStrictMock(DatastoreService.class);
    final Transaction transaction = createStrictMock(Transaction.class);
    expect(datastoreService.newTransaction()).andReturn(transaction).once();
    expect(transaction.active()).andReturn(true).once();
    transaction.rollback();
    EasyMock.expectLastCall().once();
    expect(transaction.active()).andReturn(false).once();
    replay(datastoreService, transaction);
    try {
      DatastoreHelper.runInTransaction(datastoreService, new TransactionCallable<Void>() {
        @Override
        public Void run(DatastoreReaderWriter readerWriter) throws Exception {
          assertTrue(transaction.active());
          assertSame(transaction, readerWriter);
          throw new Exception("Bla");
        }
      });
      fail("DatastoreServiceException was expected");
    } catch (DatastoreServiceException ex) {
      assertEquals("Bla", ex.getCause().getMessage());
    }
    verify(datastoreService, transaction);
  }
}
