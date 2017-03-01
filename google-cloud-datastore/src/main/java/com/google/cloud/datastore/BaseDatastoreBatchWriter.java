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

package com.google.cloud.datastore;

import com.google.common.base.Preconditions;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Base class for DatastoreBatchWriter.
 */
public abstract class BaseDatastoreBatchWriter implements DatastoreBatchWriter {

  private final String name;
  private final Map<Key, FullEntity<Key>> toAdd = new LinkedHashMap<>();
  private final List<FullEntity<IncompleteKey>> toAddAutoId = new LinkedList<>();
  private final Map<Key, FullEntity<Key>> toUpdate = new LinkedHashMap<>();
  private final Map<Key, FullEntity<Key>> toPut = new LinkedHashMap<>();
  private final Set<Key> toDelete = new LinkedHashSet<>();
  private boolean active = true;

  protected BaseDatastoreBatchWriter(String name) {
    this.name = name;
  }

  @SuppressWarnings("unchecked")
  @Override
  public final void addWithDeferredIdAllocation(FullEntity<?>... entities) {
    validateActive();
    for (FullEntity<?> entity : entities) {
      IncompleteKey key = entity.getKey();
      Preconditions.checkArgument(key != null, "Entity must have a key");
      if (key instanceof Key) {
        addInternal((FullEntity<Key>) entity);
      } else {
        toAddAutoId.add((FullEntity<IncompleteKey>) entity);
      }
    }
  }

  private void addInternal(FullEntity<Key> entity) {
    Key key = entity.getKey();
    if (toAdd.containsKey(key) || toUpdate.containsKey(key) || toPut.containsKey(key)) {
      throw newInvalidRequest("Entity with the key %s was already added or updated in this %s",
          entity.getKey(), name);
    }
    if (toDelete.remove(key)) {
      toPut.put(key, entity);
    } else {
      toAdd.put(key, entity);
    }
  }

  @Override
  public final Entity add(FullEntity<?> entity) {
    return DatastoreHelper.add(this, entity);
  }

  @SuppressWarnings("unchecked")
  @Override
  public final List<Entity> add(FullEntity<?>... entities) {
    validateActive();
    List<IncompleteKey> incompleteKeys = Lists.newArrayListWithExpectedSize(entities.length);
    for (FullEntity<?> entity : entities) {
      IncompleteKey key = entity.getKey();
      Preconditions.checkArgument(key != null, "Entity must have a key");
      if (!(key instanceof Key)) {
        incompleteKeys.add(key);
      }
    }
    Iterator<Key> allocated;
    if (!incompleteKeys.isEmpty()) {
      IncompleteKey[] toAllocate = Iterables.toArray(incompleteKeys, IncompleteKey.class);
      allocated = getDatastore().allocateId(toAllocate).iterator();
    } else {
      allocated = Collections.emptyIterator();
    }
    List<Entity> answer = Lists.newArrayListWithExpectedSize(entities.length);
    for (FullEntity<?> entity : entities) {
      if (entity.getKey() instanceof Key) {
        addInternal((FullEntity<Key>) entity);
        answer.add(Entity.convert((FullEntity<Key>) entity));
      } else {
        Entity entityWithAllocatedId = Entity.newBuilder(allocated.next(), entity).build();
        addInternal(entityWithAllocatedId);
        answer.add(entityWithAllocatedId);
      }
    }
    return answer;
  }

  @SafeVarargs
  @Override
  public final void update(Entity... entities) {
    validateActive();
    for (Entity entity : entities) {
      Key key = entity.getKey();
      if (toDelete.contains(key)) {
        throw newInvalidRequest("Entity with the key %s was already deleted in this %s",
            entity.getKey(), name);
      }
      if (toAdd.remove(key) != null || toPut.containsKey(key)) {
        toPut.put(key, entity);
      } else {
        toUpdate.put(key, entity);
      }
    }
  }

  private void putInternal(FullEntity<Key> entity) {
    Key key = entity.getKey();
    toAdd.remove(key);
    toUpdate.remove(key);
    toDelete.remove(key);
    toPut.put(key, entity);
  }

  @Override
  public final Entity put(FullEntity<?> entity) {
    return DatastoreHelper.put(this, entity);
  }

  @SuppressWarnings("unchecked")
  @Override
  public final void putWithDeferredIdAllocation(FullEntity<?>... entities) {
    validateActive();
    for (FullEntity<?> entity : entities) {
      IncompleteKey key = entity.getKey();
      Preconditions.checkArgument(key != null, "Entity must have a key");
      if (key instanceof Key) {
        putInternal(Entity.convert((FullEntity<Key>) entity));
      } else {
        toAddAutoId.add((FullEntity<IncompleteKey>) entity);
      }
    }
  }

  @SuppressWarnings("unchecked")
  @Override
  public final List<Entity> put(FullEntity<?>... entities) {
    validateActive();
    List<IncompleteKey> incompleteKeys = Lists.newArrayListWithExpectedSize(entities.length);
    for (FullEntity<?> entity : entities) {
      IncompleteKey key = entity.getKey();
      Preconditions.checkArgument(key != null, "Entity must have a key");
      if (!(key instanceof Key)) {
        incompleteKeys.add(key);
      }
    }
    Iterator<Key> allocated;
    if (!incompleteKeys.isEmpty()) {
      IncompleteKey[] toAllocate = Iterables.toArray(incompleteKeys, IncompleteKey.class);
      allocated = getDatastore().allocateId(toAllocate).iterator();
    } else {
      allocated = Collections.emptyIterator();
    }
    List<Entity> answer = Lists.newArrayListWithExpectedSize(entities.length);
    for (FullEntity<?> entity : entities) {
      if (entity.getKey() instanceof Key) {
        putInternal((FullEntity<Key>) entity);
        answer.add(Entity.convert((FullEntity<Key>) entity));
      } else {
        Entity entityWithAllocatedId = Entity.newBuilder(allocated.next(), entity).build();
        putInternal(entityWithAllocatedId);
        answer.add(entityWithAllocatedId);
      }
    }
    return answer;
  }

  @Override
  public final void delete(Key... keys) {
    validateActive();
    for (Key key : keys) {
      toAdd.remove(key);
      toUpdate.remove(key);
      toPut.remove(key);
      toDelete.add(key);
    }
  }

  @Override
  @Deprecated
  public boolean active() {
    return isActive();
  }

  @Override
  public boolean isActive() {
    return active;
  }

  protected String getName() {
    return name;
  }

  protected Map<Key, FullEntity<Key>> toAdd() {
    return toAdd;
  }

  protected List<FullEntity<IncompleteKey>> toAddAutoId() {
    return toAddAutoId;
  }

  protected Map<Key, FullEntity<Key>> toUpdate() {
    return toUpdate;
  }

  protected Map<Key, FullEntity<Key>> toPut() {
    return toPut;
  }

  protected Set<Key> toDelete() {
    return toDelete;
  }

  protected void deactivate() {
    active = false;
  }

  protected void validateActive() {
    if (!active) {
      throw newInvalidRequest("%s is no longer active", name);
    }
  }

  protected DatastoreException newInvalidRequest(String msg, Object... params) {
    return DatastoreException.throwInvalidRequest(String.format(msg, params));
  }

  protected List<com.google.datastore.v1.Mutation> toMutationPbList() {
    List<com.google.datastore.v1.Mutation> mutationsPb = new ArrayList<>();
    for (FullEntity<IncompleteKey> entity : toAddAutoId()) {
      mutationsPb.add(
          com.google.datastore.v1.Mutation.newBuilder().setInsert(entity.toPb()).build());
    }
    for (FullEntity<Key> entity : toAdd().values()) {
      mutationsPb.add(
          com.google.datastore.v1.Mutation.newBuilder().setInsert(entity.toPb()).build());
    }
    for (FullEntity<Key> entity : toUpdate().values()) {
      mutationsPb.add(
          com.google.datastore.v1.Mutation.newBuilder().setUpdate(entity.toPb()).build());
    }
    for (FullEntity<Key> entity : toPut().values()) {
      mutationsPb.add(
          com.google.datastore.v1.Mutation.newBuilder().setUpsert(entity.toPb()).build());
    }
    for (Key key : toDelete()) {
      mutationsPb.add(com.google.datastore.v1.Mutation.newBuilder().setDelete(key.toPb()).build());
    }
    return mutationsPb;
  }

  @Deprecated
  protected abstract Datastore datastore();

  protected abstract Datastore getDatastore();
}
