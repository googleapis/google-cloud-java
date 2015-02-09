/*
 * Copyright 2015 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package com.google.gcloud.datastore;

import com.google.api.services.datastore.DatastoreV1;

import java.util.*;

/**
 * Base class for DatastoreBatchWriter.
 */
public abstract class BaseDatastoreBatchWriter implements DatastoreBatchWriter {

  private final String name;
  private final Map<Key, Entity> toAdd = new LinkedHashMap<>();
  private final List<PartialEntity> toAddAutoId = new LinkedList<>();
  private final Map<Key, Entity> toUpdate = new LinkedHashMap<>();
  private final Map<Key, Entity> toPut = new LinkedHashMap<>();
  private final Set<Key> toDelete = new LinkedHashSet<>();
  private boolean active = true;

  protected BaseDatastoreBatchWriter(String name) {
    this.name = name;
  }

  @Override
  public void add(Entity... entities) {
    validateActive();
    for (Entity entity : entities) {
      Key key = entity.key();
      if (toAdd.containsKey(key) || toUpdate.containsKey(key) || toPut.containsKey(key)) {
        throw newInvalidRequest("Entity with the key %s was already added or updated in this %s",
            entity.key(), name);
      }
      if (toDelete.remove(key)) {
        toPut.put(key, entity);
      } else {
        toAdd.put(key, entity);
      }
    }
  }

  @Override
  public void add(PartialEntity... entities) {
    validateActive();
    for (PartialEntity entity : entities) {
      if (entity instanceof Entity) {
        add((Entity) entity);
      } else {
        toAddAutoId.add(entity);
      }
    }
  }

  @Override
  public void update(Entity... entities) {
    validateActive();
    for (Entity entity : entities) {
      Key key = entity.key();
      if (toDelete.contains(key)) {
        throw newInvalidRequest("Entity with the key %s was already deleted in this %s",
            entity.key(), name);
      }
      if (toAdd.remove(key) != null || toPut.containsKey(key)) {
        toPut.put(key, entity);
      } else {
        toUpdate.put(key, entity);
      }
    }
  }

  @Override
  public void put(Entity... entities) {
    validateActive();
    for (Entity entity : entities) {
      Key key = entity.key();
      toAdd.remove(key);
      toUpdate.remove(key);
      toDelete.remove(key);
      toPut.put(key, entity);
    }
  }

  @Override
  public void delete(Key... keys) {
    validateActive();
    for (Key key : keys) {
      toAdd.remove(key);
      toUpdate.remove(key);
      toPut.remove(key);
      toDelete.add(key);
    }
  }

  @Override
  public boolean active() {
    return active;
  }

  protected String name() {
    return name;
  }

  protected Map<Key, Entity> toAdd() {
    return toAdd;
  }

  protected List<PartialEntity> toAddAutoId() {
    return toAddAutoId;
  }

  protected Map<Key, Entity> toUpdate() {
    return toUpdate;
  }

  protected Map<Key, Entity> toPut() {
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

  protected DatastoreServiceException newInvalidRequest(String msg, Object... params) {
    return DatastoreServiceException.throwInvalidRequest(String.format(msg, params));
  }

  protected DatastoreV1.Mutation.Builder toMutationPb() {
    DatastoreV1.Mutation.Builder mutationPb = DatastoreV1.Mutation.newBuilder();
    for (PartialEntity entity : toAddAutoId()) {
      mutationPb.addInsertAutoId(entity.toPb());
    }
    for (Entity entity : toAdd().values()) {
      mutationPb.addInsert(entity.toPb());
    }
    for (Entity entity : toUpdate().values()) {
      mutationPb.addUpdate(entity.toPb());
    }
    for (Entity entity : toPut().values()) {
      mutationPb.addUpsert(entity.toPb());
    }
    for (Key key : toDelete()) {
      mutationPb.addDelete(key.toPb());
    }
    return mutationPb;
  }
}
