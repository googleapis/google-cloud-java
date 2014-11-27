package com.google.gcloud.datastore;

public interface DatastoreWriter {

  void add(Entity... entity);

  void update(Entity... entity);

  Key put(Entity... entity);

  void delete(Key... key);
}