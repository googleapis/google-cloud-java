package com.google.gcloud.datastore;

import static com.google.gcloud.datastore.DatastoreServiceException.throwInvalidRequest;

import com.google.api.services.datastore.DatastoreV1;
import com.google.gcloud.datastore.BatchWriteOption.ForceWrites;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;

class BatchWriterImpl implements BatchWriter {

  private final LinkedHashMap<Key, Entity> toAdd = new LinkedHashMap<>();
  private final LinkedHashMap<Key, Entity> toUpdate = new LinkedHashMap<>();
  private final LinkedHashMap<Key, Entity> toPut = new LinkedHashMap<>();
  private final LinkedHashSet<Key> toDelete = new LinkedHashSet<>();
  private final boolean force;
  protected final DatastoreServiceImpl datastore;

  private boolean active = true;

  BatchWriterImpl(DatastoreServiceImpl datastore, BatchWriteOption... options) {
    this.datastore = datastore;
    Map<Class<? extends BatchWriteOption>, BatchWriteOption> optionsMap =
        BatchWriteOption.asImmutableMap(options);
    if (optionsMap.containsKey(ForceWrites.class)) {
      force = ((ForceWrites) optionsMap.get(ForceWrites.class)).force();
    } else {
      force = datastore.getOptions().force();
    }
  }

  protected void checkActive() {
    if (!active) {
      throwInvalidRequest(getName() + " is no longer active");
    }
  }

  protected String getName() {
    return "batch";
  }

  @Override
  public void add(Entity... entities) {
    checkActive();
    for (Entity entity : entities) {
      Key key = entity.key();
      if (toAdd.containsKey(key) || toUpdate.containsKey(key) || toPut.containsKey(key)) {
        throw throwInvalidRequest("Entity with the key %s was already added or updated in this "
            + getName(), entity.key());
      }
      if (toDelete.remove(key)) {
        toPut.put(key, entity);
      } else {
        toAdd.put(key, entity);
      }
    }
  }

  @Override
  public void update(Entity... entities) {
    checkActive();
    for (Entity entity : entities) {
      Key key = entity.key();
      if (toDelete.contains(key)) {
        throw throwInvalidRequest(
            "Entity with the key %s was already deleted in this " + getName(), entity.key());
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
    checkActive();
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
    checkActive();
    for (Key key : keys) {
      toAdd.remove(key);
      toUpdate.remove(key);
      toPut.remove(key);
      toDelete.add(key);
    }
  }

  @Override
  public void submit() {
    checkActive();
    DatastoreV1.Mutation.Builder mutationPb = DatastoreV1.Mutation.newBuilder();
    for (Entity entity : toAdd.values()) {
      mutationPb.addInsert(entity.toPb());
    }
    for (Entity entity : toUpdate.values()) {
      mutationPb.addUpdate(entity.toPb());
    }
    for (Entity entity : toPut.values()) {
      mutationPb.addUpsert(entity.toPb());
    }
    for (Key key : toDelete) {
      mutationPb.addDelete(key.toPb());
    }
    if (force) {
      mutationPb.setForce(force);
    }
    DatastoreV1.CommitRequest.Builder requestPb = newCommitRequest();
    requestPb.setMutation(mutationPb);
    datastore.comitMutation(requestPb);
    active = false;
  }

  @Override
  public boolean active() {
    return active;
  }

  protected DatastoreV1.CommitRequest.Builder newCommitRequest() {
    DatastoreV1.CommitRequest.Builder requestPb = DatastoreV1.CommitRequest.newBuilder();
    requestPb.setMode(DatastoreV1.CommitRequest.Mode.NON_TRANSACTIONAL);
    return requestPb;
  }
}
