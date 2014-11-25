package com.google.gcloud.datastore;

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.api.services.datastore.DatastoreV1;
import com.google.common.collect.ImmutableList;

/**
 * A key that is guaranteed to be complete.
 */
public final class Key extends IncompleteKey {

  private static final long serialVersionUID = 3160994559785491356L;

  public static class Builder {

    private final IncompleteKey.Builder keyBuilder;
    private String name;

    public Builder(String dataset, String kind) {
      keyBuilder = new IncompleteKey.Builder(dataset, kind);
    }

    public Builder(Key key) {
      keyBuilder = new IncompleteKey.Builder(key);

      // set name or id
    }

    public Builder setDataset(String dataset) {
      keyBuilder.setDataset(checkNotNull(dataset));
      return this;
    }

    public Builder setNamespace(String namespace) {
      keyBuilder.setNamespace(checkNotNull(namespace));
      return this;
    }

    public Builder addToPath(String kind, long id) {
      keyBuilder.addChild(kind, id);
      return this;
    }

    public Builder addToPath(String kind, String name) {
      keyBuilder.addChild(kind, name);
      return this;
    }

    public Builder clearPath() {
      keyBuilder.clearPath();
      return this;
    }

    public Key build(String name) {

      return new Key(keyBuilder.build());
    }
  }

  private Key(IncompleteKey key) {
    super(key.getDataset(), key.getNamespace(), ImmutableList.copyOf(key.getFullPath()));
  }

  public Long getId() {
    return getLeaf().getId();
  }

  public String getName() {
    return getLeaf().getName();
  }

  public Object getNameOrId() {
    PathEntry leaf = getLeaf();
    return leaf.hasId() ? leaf.getId() : leaf.getName();
  }

  static Key fromPb(DatastoreV1.Key keyPb) {
    return new Key(IncompleteKey.fromPb(keyPb));
  }
}
