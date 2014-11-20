package com.google.gcloud.datastore;

import java.util.Map;

public interface DatastoreService {

  DatastoreServiceOptions getOptions();

  CompleteKey put(Key key, Map<String, Property> values);

  Map<String, Property> get(CompleteKey key);

  void delete(CompleteKey... key);

  void allocateIds(Key... key);

  // query result item is a tuple of (key, value...) where values may be empty
  //QueryResult runQuery(Query query);

}
