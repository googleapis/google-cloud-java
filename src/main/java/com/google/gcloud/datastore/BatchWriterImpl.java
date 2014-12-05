package com.google.gcloud.datastore;

import static com.google.gcloud.datastore.DatastoreServiceException.Code.FAILED_PRECONDITION;

import com.google.api.services.datastore.DatastoreV1;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

class BatchWriterImpl implements BatchWriter {

  private final LinkedHashMap<Key, Entity> toAdd = new LinkedHashMap<>();
  private final LinkedHashMap<Key, Entity> toUpdate = new LinkedHashMap<>();
  private final LinkedHashMap<Key, Entity> toPut = new LinkedHashMap<>();
  private final LinkedHashSet<Key> toDelete = new LinkedHashSet<>();
  private final DatastoreServiceImpl datastore;

  private boolean force;
  protected boolean isValid = true;

  BatchWriterImpl(DatastoreServiceImpl datastore, BatchWriteOption... options) {
    this.datastore = datastore;
    force = datastore.getOptions().force();
    for (BatchWriteOption option : options) {
      option.apply(this);
    }
  }

  // Apply all valid options

  void apply(BatchWriteOption.ForceWrites forceOptions) {
    this.force = forceOptions.force();
  }

  void apply(BatchWriteOption other) {
    // dont care
  }

  ////////////////////

  DatastoreServiceException newBatchFailure(Entity entity, String msg) {
    isValid = false;
    return new DatastoreServiceException(FAILED_PRECONDITION,
        new RuntimeException("Entity with the key " + entity.key() + " " + msg));
  }

  protected void checkValid() {
    if (!isValid) {
      throw new DatastoreServiceException(FAILED_PRECONDITION,
          new RuntimeException("BatchWriter is in an invalid state"));
    }
  }

  @Override
  public void add(Entity... entities) {
    checkValid();
    for (Entity entity : entities) {
      Key key = entity.key();
      if (toAdd.containsKey(key) || toUpdate.containsKey(key) || toPut.containsKey(key)) {
        throw newBatchFailure(entity, "was already added or updated in this batch");
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
    checkValid();
    for (Entity entity : entities) {
      Key key = entity.key();
      if (toDelete.contains(key)) {
        throw newBatchFailure(entity, "was alredy deleted in this batch");
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
    checkValid();
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
    checkValid();
    for (Key key : keys) {
      toAdd.remove(key);
      toUpdate.remove(key);
      toPut.remove(key);
      toDelete.add(key);
    }
  }

  @Override
  public void submit() {
    checkValid();
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
    isValid = false;
  }

  protected DatastoreV1.CommitRequest.Builder newCommitRequest() {
    DatastoreV1.CommitRequest.Builder requestPb = DatastoreV1.CommitRequest.newBuilder();
    requestPb.setMode(DatastoreV1.CommitRequest.Mode.NON_TRANSACTIONAL);
    return requestPb;
  }
}
