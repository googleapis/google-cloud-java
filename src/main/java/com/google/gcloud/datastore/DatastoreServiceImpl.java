package com.google.gcloud.datastore;

import java.util.Map;

final class DatastoreServiceImpl implements DatastoreService {

  private final DatastoreServiceOptions options;

  DatastoreServiceImpl(DatastoreServiceOptions options) {
    this.options = options;
  }

  public DatastoreServiceOptions getOptions() {
    // TODO Auto-generated method stub
    return null;
  }

  public CompleteKey put(Key key, Map<String, Property> values) {
    // TODO Auto-generated method stub
    return null;
  }

  public Map<String, Property> get(CompleteKey key) {
    // TODO Auto-generated method stub
    return null;
  }

  public void delete(CompleteKey... key) {
    // TODO Auto-generated method stub

  }

  public void allocateIds(Key... key) {
    // TODO Auto-generated method stub

  }
}
