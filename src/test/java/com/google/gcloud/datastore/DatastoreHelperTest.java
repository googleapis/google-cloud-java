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
import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.createStrictMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import com.google.common.collect.Iterators;
import com.google.common.collect.Sets;
import com.google.gcloud.com.google.gcloud.spi.DatastoreRpc;

import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DatastoreHelperTest {

  @Test
  public void testDelegate() throws Exception {
    final Set<Method> methods = Sets.newHashSet(DatastoreService.class.getMethods());
    final Map<String, Object[]> params = new HashMap<>();
    InvocationHandler handler = new InvocationHandler() {
      @Override
      public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        String methodName = Thread.currentThread().getStackTrace()[3].getMethodName();
        if (method.getParameterTypes().length > 0) {
          Class paramClass = method.getParameterTypes()[0];
          methodName += paramClass.getSimpleName();
          if (method.isVarArgs()) {
            objects = (Object[]) objects[0];
          }
          assertArrayEquals(objects, params.get(methodName));
        }
        assertTrue(methods.remove(method));
        return null;
      }
    };
    PartialKey pKey1 = PartialKey.builder("ds", "k").build();
    PartialKey pKey2 = PartialKey.builder("ds", "k").build();
    PartialEntity pEntity1 = PartialEntity.builder(pKey1).build();
    PartialEntity pEntity2 = PartialEntity.builder(pKey2).build();
    Key key1 = Key.builder(pKey1, 1).build();
    Key key2 = Key.builder(pKey1, "a").build();
    Entity entity1 = Entity.builder(key1).build();
    Entity entity2 = Entity.builder(key2).build();
    ClassLoader cl = DatastoreService.class.getClassLoader();
    Class<?>[] interfaces = DatastoreHelper.class.getInterfaces();
    DatastoreService delegate = (DatastoreService) Proxy.newProxyInstance(cl, interfaces, handler);
    DatastoreHelper helper = DatastoreHelper.createFor(delegate);
    params.put("getKey", new Object[] {key1});
    helper.get(key1);
    params.put("getKey[]", new Object[] {key1, key2});
    helper.get(key1, key2);
    params.put("addEntity[]", new Object[] {entity1, entity2});
    helper.add(entity1, entity2);
    params.put("updateEntity[]", new Object[] {entity1});
    helper.update(entity1);
    params.put("addPartialEntity", new Object[] {pEntity1});
    helper.add(pEntity1);
    params.put("addPartialEntity[]", new Object[] {pEntity2, entity1});
    helper.add(pEntity2, entity1);
    params.put("allocateIdPartialKey", new Object[] {pKey1});
    helper.allocateId(pKey1);
    params.put("allocateIdPartialKey[]", new Object[] {pKey1, pKey2});
    helper.allocateId(pKey1, pKey2);
    params.put("deleteKey[]", new Object[] {key1});
    helper.delete(key1);
    params.put("putEntity[]", new Object[] {entity1});
    helper.put(entity1);
    helper.options();
    params.put("newBatchBatchOption[]", new Object[] {});
    helper.newBatch();
    params.put("newTransactionTransactionOption[]", new Object[] {});
    helper.newTransaction();
    Query query = createMock(Query.class);
    params.put("runQuery", new Object[] {query});
    helper.run(query);
    assertTrue(methods.isEmpty());
  }

  @Test
  public void testNewKeyFactory() throws Exception {
    DatastoreService datastoreService = createStrictMock(DatastoreService.class);
    DatastoreRpc datastoreRpc = createStrictMock(DatastoreRpc.class);
    DatastoreServiceOptions options =
        DatastoreServiceOptions.builder().normalizeDataset(false).datastoreRpc(datastoreRpc)
            .dataset("ds").build();
    expect(datastoreService.options()).andReturn(options).atLeastOnce();
    replay(datastoreRpc, datastoreService);
    DatastoreHelper helper = DatastoreHelper.createFor(datastoreService);
    KeyFactory keyFactory = helper.newKeyFactory();
    assertSame(datastoreService, keyFactory.datastore());
    verify(datastoreRpc, datastoreService);
  }

  @Test
  public void testFetch() throws Exception {
    DatastoreService datastoreService = createStrictMock(DatastoreService.class);
    PartialKey pKey1 = PartialKey.builder("ds", "k").build();
    Key key1 = Key.builder(pKey1, 1).build();
    Key key2 = Key.builder(pKey1, "a").build();
    Entity entity1 = Entity.builder(key1).build();
    Entity entity2 = Entity.builder(key2).build();
    expect(datastoreService.get(key1, key2)).andReturn(Iterators.forArray(entity1, entity2)).once();
    replay(datastoreService);
    DatastoreHelper helper = DatastoreHelper.createFor(datastoreService);
    List<Entity> values = helper.fetch(key1, key2);
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
    DatastoreHelper helper = DatastoreHelper.createFor(datastoreService);
    helper.runInTransaction(new DatastoreHelper.RunInTransaction() {
      @Override
      public void run(DatastoreReaderWriter readerWriter) {
        assertTrue(transaction.active());
        assertSame(transaction, readerWriter);
      }
    });
    verify(datastoreService, transaction);
  }
}
