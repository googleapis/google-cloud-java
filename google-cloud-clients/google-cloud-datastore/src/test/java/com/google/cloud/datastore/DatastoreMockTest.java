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

package com.google.cloud.datastore;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;

import com.google.cloud.NoCredentials;
import com.google.cloud.ServiceOptions;
import com.google.cloud.ServiceRpc;
import com.google.cloud.Timestamp;
import com.google.cloud.datastore.DatastoreOptions.DefaultDatastoreRpcFactory;
import com.google.cloud.datastore.spi.DatastoreRpcFactory;
import com.google.cloud.datastore.spi.v1.DatastoreRpc;
import com.google.common.collect.ImmutableList;
import com.google.datastore.v1.AllocateIdsRequest;
import com.google.datastore.v1.AllocateIdsResponse;
import com.google.datastore.v1.BeginTransactionRequest;
import com.google.datastore.v1.BeginTransactionResponse;
import com.google.datastore.v1.CommitRequest;
import com.google.datastore.v1.CommitResponse;
import com.google.datastore.v1.LookupRequest;
import com.google.datastore.v1.LookupResponse;
import com.google.datastore.v1.PartitionId;
import java.util.Collections;
import java.util.List;
import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;


@RunWith(JUnit4.class)
public class DatastoreMockTest {

  private static String DEFAULT_PROJECT_ID = "test-project-898e3b96-f74a-4955-838d-7cdef2483d43";
  private static final String DEFAULT_HOST = "localhost";
  private static DatastoreOptions options = DatastoreOptions.newBuilder()
      .setProjectId(DEFAULT_PROJECT_ID)
      .setHost(DEFAULT_HOST)
      .setCredentials(NoCredentials.getInstance())
      .setRetrySettings(ServiceOptions.getNoRetrySettings())
      .setServiceRpcFactory(MockDefaultDatastoreRpcFactory.INSTANCE)
      .build();


  private static Datastore datastore;
  private static final String PROJECT_ID = options.getProjectId();
  private static final String KIND1 = "kind1";
  private static final String KIND2 = "kind2";
  private static final NullValue NULL_VALUE = NullValue.of();
  private static final StringValue STR_VALUE = StringValue.of("str");
  private static final BooleanValue BOOL_VALUE =
      BooleanValue.newBuilder(false).setExcludeFromIndexes(true).build();
  private static final IncompleteKey INCOMPLETE_KEY1 =
      IncompleteKey.newBuilder(PROJECT_ID, KIND1).build();
  private static final IncompleteKey INCOMPLETE_KEY2 =
      IncompleteKey.newBuilder(PROJECT_ID, KIND2).build();
  private static final Key KEY1 = Key.newBuilder(INCOMPLETE_KEY1, "name").build();
  private static final KeyValue KEY_VALUE = KeyValue.of(KEY1);
  private static final ListValue LIST_VALUE1 =
      ListValue.newBuilder().addValue(NULL_VALUE).addValue(STR_VALUE, BOOL_VALUE).build();
  private static final ListValue LIST_VALUE2 = ListValue.of(Collections.singletonList(KEY_VALUE));
  private static final ListValue EMPTY_LIST_VALUE = ListValue.of(Collections.<Value<?>>emptyList());
  private static final TimestampValue TIMESTAMP_VALUE = new TimestampValue(Timestamp.now());
  private static final LatLngValue LAT_LNG_VALUE =
      new LatLngValue(new LatLng(37.422035, -122.084124));
  private static final FullEntity<IncompleteKey> PARTIAL_ENTITY1 =
      FullEntity.newBuilder(INCOMPLETE_KEY2)
          .set("str", STR_VALUE)
          .set("bool", BOOL_VALUE)
          .set("list", LIST_VALUE1)
          .build();
  private static final Entity ENTITY1 =
      Entity.newBuilder(KEY1)
          .set("str", STR_VALUE)
          .set("date", TIMESTAMP_VALUE)
          .set("latLng", LAT_LNG_VALUE)
          .set("bool", BOOL_VALUE)
          .set("partial1", EntityValue.of(PARTIAL_ENTITY1))
          .set("list", LIST_VALUE2)
          .set("emptyList", EMPTY_LIST_VALUE)
          .build();

  private DatastoreOptions rpcMockOptions;
  private DatastoreRpcFactory rpcFactoryMock = EasyMock.createStrictMock(DatastoreRpcFactory.class);
  private static DatastoreRpc rpcMock = EasyMock.createStrictMock(DatastoreRpc.class);

  public static class MockDefaultDatastoreRpcFactory extends DefaultDatastoreRpcFactory {

    private static final DatastoreRpcFactory INSTANCE = new MockDefaultDatastoreRpcFactory();

    @Override
    public ServiceRpc create(DatastoreOptions options) {
      return rpcMock;
    }
  }

  @Before
  public void setUp() {
    EasyMock.expect(rpcFactoryMock.create(rpcMockOptions)).andReturn(rpcMock);
    EasyMock.replay(rpcFactoryMock);

    rpcMockOptions =
        options
            .toBuilder()
            .setRetrySettings(ServiceOptions.getDefaultRetrySettings())
            .setServiceRpcFactory(MockDefaultDatastoreRpcFactory.INSTANCE)
            .build();
    datastore = options.getService();
  }


  @Test
  public void testGetOptions() {
    assertSame(options, datastore.getOptions());
  }

  @Test
  public void testNewTransaction() {
    BeginTransactionResponse mockBeginTransactionResponse = BeginTransactionResponse
        .getDefaultInstance();
    CommitResponse mockCommitResponse = CommitResponse.getDefaultInstance();

    EasyMock.expect(rpcMock.beginTransaction(EasyMock.anyObject(BeginTransactionRequest.class)))
        .andReturn(mockBeginTransactionResponse);
    EasyMock.expect(rpcMock.commit(EasyMock.anyObject(CommitRequest.class)))
        .andReturn(mockCommitResponse);

    EasyMock.replay(rpcMock);
    Transaction transaction = datastore.newTransaction();
    transaction.add(ENTITY1);
    Entity entity2 = Entity.newBuilder(ENTITY1).clear().setNull("bla").build();
    transaction.update(entity2);
    transaction.delete(KEY1);
    transaction.commit();
    EasyMock.reset(rpcMock);
  }

  @Test
  public void testGet() {
    LookupResponse mockLookupResponse = LookupResponse.getDefaultInstance();
    EasyMock.expect(rpcMock.lookup(EasyMock.anyObject(LookupRequest.class)))
        .andReturn(mockLookupResponse);
    EasyMock.replay(rpcMock);

    Entity entity = datastore.get(KEY1);
    assertNull(entity);

    EasyMock.reset(rpcMock);
  }

  @Test
  public void testFetch() {
    LookupResponse mockLookupResponse = LookupResponse.getDefaultInstance();
    EasyMock.expect(rpcMock.lookup(EasyMock.anyObject(LookupRequest.class)))
        .andReturn(mockLookupResponse);
    EasyMock.replay(rpcMock);

    List<Entity> fetch = datastore.fetch(ImmutableList.of(KEY1), ReadOption.eventualConsistency());
    assertEquals(fetch.size(), 1);
    assertNull(fetch.get(0));

    EasyMock.reset(rpcMock);
  }

  @Test
  public void testPut() {
    CommitResponse mockCommitResponse = CommitResponse.getDefaultInstance();
    EasyMock.expect(rpcMock.commit(EasyMock.anyObject(CommitRequest.class)))
        .andReturn(mockCommitResponse);
    EasyMock.replay(rpcMock);

    Entity entity = Entity.newBuilder(ENTITY1).set("new_property", 42L).build();
    List<Entity> entities = datastore.put(ENTITY1, entity);
    assertEquals(entities.get(1), entity);
    EasyMock.reset(rpcMock);
  }

  @Test
  public void testAllocateId() {
    KeyFactory keyFactory = datastore.newKeyFactory().setKind(KIND1);
    IncompleteKey incompleteKey = keyFactory.newKey();
    com.google.datastore.v1.Key key =
        com.google.datastore.v1.Key.newBuilder()
            .setPartitionId(PartitionId.newBuilder().setProjectId(PROJECT_ID).build())
            .addPath(
                com.google.datastore.v1.Key.PathElement.newBuilder()
                    .setKind("kind1")
                    .setName("name")
                    .build())
            .build();

    AllocateIdsResponse mockAllocateIdsResponse = AllocateIdsResponse.newBuilder()
        .addKeys(key)
        .build();
    EasyMock.expect(rpcMock.allocateIds(EasyMock.anyObject(AllocateIdsRequest.class)))
        .andReturn(mockAllocateIdsResponse);
    EasyMock.replay(rpcMock);

    Key key1 = datastore.allocateId(incompleteKey);
    assertEquals(key1.getProjectId(), incompleteKey.getProjectId());
    assertEquals(key1.getNamespace(), incompleteKey.getNamespace());
    assertEquals(key1.getAncestors(), incompleteKey.getAncestors());
    assertEquals(key1.getKind(), incompleteKey.getKind());
    EasyMock.reset(rpcMock);
  }
}
