package com.google.gcloud.datastore;

import com.google.api.services.datastore.DatastoreV1;
import com.google.protobuf.InvalidProtocolBufferException;

public class GqlQuery extends Serializable<DatastoreV1.GqlQuery> implements Query {

  private static final long serialVersionUID = 5988280590929540569L;

  @Override
  protected DatastoreV1.GqlQuery toPb() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  protected Object fromPb(byte[] bytesPb) throws InvalidProtocolBufferException {
    // TODO Auto-generated method stub
    return null;
  }

  static GqlQuery fromPb(DatastoreV1.GqlQuery queryPb) {
    // TODO Auto-generated method stub
    return null;
  }
}
