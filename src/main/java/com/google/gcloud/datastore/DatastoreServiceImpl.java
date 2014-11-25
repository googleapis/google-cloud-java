package com.google.gcloud.datastore;


final class DatastoreServiceImpl implements DatastoreService {

  private final DatastoreServiceOptions options;

  DatastoreServiceImpl(DatastoreServiceOptions options) {
    this.options = options;
  }

  @Override
  public DatastoreServiceOptions getOptions() {
    return options;
  }
}
