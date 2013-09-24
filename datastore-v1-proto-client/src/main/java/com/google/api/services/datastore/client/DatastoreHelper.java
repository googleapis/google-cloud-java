/*
 * Copyright 2013 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.api.services.datastore.client;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.compute.ComputeCredential;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson.JacksonFactory;
import com.google.api.services.datastore.DatastoreV1.CompositeFilter;
import com.google.api.services.datastore.DatastoreV1.Entity;
import com.google.api.services.datastore.DatastoreV1.EntityOrBuilder;
import com.google.api.services.datastore.DatastoreV1.Filter;
import com.google.api.services.datastore.DatastoreV1.Key;
import com.google.api.services.datastore.DatastoreV1.Key.PathElement;
import com.google.api.services.datastore.DatastoreV1.Property;
import com.google.api.services.datastore.DatastoreV1.PropertyFilter;
import com.google.api.services.datastore.DatastoreV1.PropertyOrBuilder;
import com.google.api.services.datastore.DatastoreV1.PropertyOrder;
import com.google.api.services.datastore.DatastoreV1.PropertyReference;
import com.google.api.services.datastore.DatastoreV1.Value;
import com.google.api.services.datastore.DatastoreV1.ValueOrBuilder;
import com.google.protobuf.ByteString;

import java.io.File;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/**
 * Helper methods for {@link Datastore}.
 *
 */
public class DatastoreHelper {
  private static final Logger logger = Logger.getLogger(DatastoreHelper.class.getName());

  /** The property used in the Datastore to give us a random distribution. **/
  public static final String SCATTER_PROPERTY_NAME = "__scatter__";

  /** The property used in the Datastore to get the key of the entity. **/
  public static final String KEY_PROPERTY_NAME = "__key__";

  /**
   * Comparator for Keys
   */
  private static final class KeyComparator implements Comparator<Key> {

    static final KeyComparator INSTANCE = new KeyComparator();

    private int comparePathElement(PathElement thisElement, PathElement otherElement) {
      int result = thisElement.getKind().compareTo(otherElement.getKind());
      if (result != 0) {
        return result;
      }
      if (thisElement.hasId()) {
        if (!otherElement.hasId()) {
          return -1;
        }
        return Long.valueOf(thisElement.getId()).compareTo(otherElement.getId());
      }
      if (otherElement.hasId()) {
        return 1;
      }

      return thisElement.getName().compareTo(otherElement.getName());
    }

    @Override
    public int compare(Key thisKey, Key otherKey) {
      if (!thisKey.getPartitionId().equals(otherKey.getPartitionId())) {
        throw new IllegalArgumentException("Cannot compare keys with different partition ids.");
      }

      Iterator<PathElement> thisPath = thisKey.getPathElementList().iterator();
      Iterator<PathElement> otherPath = otherKey.getPathElementList().iterator();
      while (thisPath.hasNext()) {
        if (!otherPath.hasNext()) {
          return 1;
        }
        int result = comparePathElement(thisPath.next(), otherPath.next());
        if (result != 0) {
          return result;
        }
      }

      return otherPath.hasNext() ? -1 : 0;
    }
  }

  private DatastoreHelper() {}

  /**
   * Attempts to get credentials from Google Compute Engine.
   *
   * @return valid credentials or {@code null}
   */
  public static Credential getComputeEngineCredential()
      throws GeneralSecurityException, IOException {
    NetHttpTransport transport = GoogleNetHttpTransport.newTrustedTransport();
    try {
      // Try to connect using Google Compute Engine service account credentials.
      ComputeCredential credential = new ComputeCredential(transport, new JacksonFactory());
      // Force token refresh to detect if we are running on Google Compute Engine.
      credential.refreshToken();
      return credential;
    } catch (IOException e) {
      return null;
    }
  }

  /**
   * Constructs credentials for the given account and key.
   *
   * @param account the account to use.
   * @param privateKeyFile the file name from which to get the private key.
   * @return valid credentials or {@code null}
   */
  public static Credential getServiceAccountCredential(String account, String privateKeyFile)
      throws GeneralSecurityException, IOException {
    NetHttpTransport transport = GoogleNetHttpTransport.newTrustedTransport();
    JacksonFactory jsonFactory = new JacksonFactory();
    return new GoogleCredential.Builder()
        .setTransport(transport)
        .setJsonFactory(jsonFactory)
        .setServiceAccountId(account)
        .setServiceAccountScopes(DatastoreOptions.SCOPES)
        .setServiceAccountPrivateKeyFromP12File(new File(privateKeyFile))
        .build();
  }

  /**
   * Uses the following enviorment variables to construct a {@link Datastore}:
   *  DATASTORE_DATASET - the datastore dataset id
   *  DATASTORE_HOST - the host to use to access the datastore
   *    e.g: https://www.googleapis.com/datastore/v1/datasets/{dataset}
   *  DATASTORE_SERVICE_ACCOUNT - (optional) service account name
   *  DATASTORE_PRIVATE_KEY_FILE - (optional) service account private key file
   *
   * Preference of credentials is:
   *  - ComputeEngine
   *  - Service Account (specified by DATASTORE_SERVICE_ACCOUNT and DATASTORE_PRIVATE_KEY_FILE)
   *  - no-credentials (for local development environment)
   */
  public static DatastoreOptions.Builder getOptionsfromEnv()
      throws GeneralSecurityException, IOException {
    DatastoreOptions.Builder options = new DatastoreOptions.Builder();
    options.dataset(System.getenv("DATASTORE_DATASET"));
    options.host(System.getenv("DATASTORE_HOST"));
    Credential credential = getComputeEngineCredential();
    if (credential != null) {
      logger.info("Using Compute Engine credential.");
    } else if (System.getenv("DATASTORE_SERVICE_ACCOUNT") != null &&
        System.getenv("DATASTORE_PRIVATE_KEY_FILE") != null) {
      credential = getServiceAccountCredential(System.getenv("DATASTORE_SERVICE_ACCOUNT"),
          System.getenv("DATASTORE_PRIVATE_KEY_FILE"));
      logger.info("Using JWT Service Account credential.");
    }
    options.credential(credential);
    return options;
  }

  /**
   * @see #getOptionsfromEnv()
   */
  public static Datastore getDatastoreFromEnv() throws GeneralSecurityException, IOException {
    return DatastoreFactory.get().create(getOptionsfromEnv().build());
  }

  /**
   * Gets a {@link QuerySplitter}.
   *
   * The returned {@link QuerySplitter#getSplits} cannot accept a query that contains inequality
   * filters, a sort filter, or a missing kind.
   */
  public static QuerySplitter getQuerySplitter() {
    return QuerySplitterImpl.INSTANCE;
  }

  public static Comparator<Key> getKeyComparator() {
    return KeyComparator.INSTANCE;
  }

  /**
   * Make a sort order for use in a query.
   */
  public static PropertyOrder.Builder makeOrder(String property,
      PropertyOrder.Direction direction) {
    return PropertyOrder.newBuilder()
        .setProperty(makePropertyReference(property))
        .setDirection(direction);
  }

  /**
   * Make a filter on a property for use in a query.
   */
  public static Filter.Builder makeFilter(String property, PropertyFilter.Operator operator,
      Value value) {
    return Filter.newBuilder()
        .setPropertyFilter(PropertyFilter.newBuilder()
            .setProperty(makePropertyReference(property))
            .setOperator(operator)
            .setValue(value));
  }

  /**
   * Make a filter on a property for use in a query.
   */
  public static Filter.Builder makeFilter(String property, PropertyFilter.Operator operator,
      Value.Builder value) {
    return makeFilter(property, operator, value.build());
  }

  /**
   * Make a composite filter from the given sub-filters.
   *
   * Uses AND to combine filters.
   */
  public static Filter.Builder makeFilter(Filter... subfilters) {
    return makeFilter(Arrays.asList(subfilters));
  }

  /**
   * Make a composite filter from the given sub-filters.
   *
   * Uses AND to combine filters.
   */
  public static Filter.Builder makeFilter(Iterable<Filter> subfilters) {
    return Filter.newBuilder()
        .setCompositeFilter(CompositeFilter.newBuilder()
            .addAllFilter(subfilters)
            .setOperator(CompositeFilter.Operator.AND));
  }

  /**
   * Make an entity property with the specified value.
   */
  public static Property.Builder makeProperty(String name, Value value) {
    return Property.newBuilder().setName(name).setValue(value);
  }

  /**
   * Make an entity property with the specified value.
   */
  public static Property.Builder makeProperty(String name, Value.Builder value) {
    return makeProperty(name, value.build());
  }

  /**
   * Make a property reference for use in a query.
   */
  public static PropertyReference.Builder makePropertyReference(String propertyName) {
    return PropertyReference.newBuilder().setName(propertyName);
  }

  /**
   * Make an entity value with the specified list values.
   */
  public static Value.Builder makeValue(Iterable<Value> listValues) {
    return Value.newBuilder().addAllListValue(listValues);
  }

  /**
   * Make an entity value with the specified list values.
   */
  public static Value.Builder makeValue(Value... values) {
    return makeValue(Arrays.asList(values));
  }

  /**
   * Make an entity value with the specified list values.
   */
  public static Value.Builder makeValue(Value.Builder... builders) {
    Value.Builder value = Value.newBuilder();
    for (Value.Builder builder : builders) {
      value.addListValue(builder);
    }
    return value;
  }

  /**
   * Make a key value.
   */
  public static Value.Builder makeValue(Key key) {
    return Value.newBuilder().setKeyValue(key);
  }

  /**
   * Make a key value.
   */
  public static Value.Builder makeValue(Key.Builder key) {
    return makeValue(key.build());
  }

  /**
   * Make an integer value.
   */
  public static Value.Builder makeValue(long key) {
    return Value.newBuilder().setIntegerValue(key);
  }

  /**
   * Make a floating point value.
   */
  public static Value.Builder makeValue(double value) {
    return Value.newBuilder().setDoubleValue(value);
  }

  /**
   * Make a floating point value.
   */
  public static Value.Builder makeValue(boolean value) {
    return Value.newBuilder().setBooleanValue(value);
  }

  /**
   * Make a string value.
   */
  public static Value.Builder makeValue(String value) {
    return Value.newBuilder().setStringValue(value);
  }

  /**
   * Make a key value.
   */
  public static Value.Builder makeValue(Entity entity) {
    return Value.newBuilder().setEntityValue(entity);
  }

  /**
   * Make a entity value.
   */
  public static Value.Builder makeValue(Entity.Builder entity) {
    return makeValue(entity.build());
  }

  /**
   * Make a entity value.
   */
  public static Value.Builder makeValue(ByteString blob) {
    return Value.newBuilder().setBlobValue(blob);
  }

  /**
   * Make a date value given a time in milliseconds.
   */
  public static Value.Builder makeValue(Date date) {
    return Value.newBuilder().setTimestampMicrosecondsValue(date.getTime() * 1000L);
  }

  /**
   * Make a key from the specified path of kind/id-or-name pairs.
   *
   * The id-or-name values must be either Key, String, Long, Integer or Short.
   *
   * The last id-or-name value may be omitted, in which case an entity without
   * an id is created (for use with automatic id allocation).
   */
  public static Key.Builder makeKey(Object... elements) {
    Key.Builder key = Key.newBuilder();
    for (int pathIndex = 0; pathIndex < elements.length; pathIndex += 2) {
      PathElement.Builder pathElement = PathElement.newBuilder();
      Object element =  elements[pathIndex];
      if (element instanceof Key) {
        key.addAllPathElement(((Key) element).getPathElementList());
        // We increment by 2, but since we got a Key argument we're only consuming 1 element in this
        // iteration of the loop. Decrement the index so that when we jump by 2 we end up in the
        // right spot.
        pathIndex--;
      } else {
        String kind;
        try {
          kind = (String) element;
        } catch (ClassCastException e) {
          throw new IllegalArgumentException("Expected string or Key, got: " + element.getClass());
        }
        pathElement.setKind(kind);
        if (pathIndex + 1 < elements.length) {
          Object value = elements[pathIndex + 1];
          if (value instanceof String) {
            pathElement.setName((String) value);
          } else if (value instanceof Long) {
            pathElement.setId((Long) value);
          } else if (value instanceof Integer) {
            pathElement.setId((Integer) value);
          } else if (value instanceof Short) {
            pathElement.setId((Short) value);
          } else {
            throw new IllegalArgumentException(
                "Expected string or integer, got: " + value.getClass());
          }
        }
        key.addPathElement(pathElement);
      }
    }
    return key;
  }

  /**
   * @return a map of property name to value
   */
  public static Map<String, Value> getPropertyMap(EntityOrBuilder entity) {
    Map<String, Value> result = new HashMap<String, Value>();
    for (PropertyOrBuilder property : entity.getPropertyList()) {
      result.put(property.getName(), property.getValue());
    }
    return Collections.unmodifiableMap(result);
  }

  /**
   * @return the double contained in value
   * @throws IllegalArgumentException if the value does not contain a double.
   */
  public static double getDouble(ValueOrBuilder value) {
    if (!value.hasDoubleValue()) {
      throw new IllegalArgumentException("Value does not contain a double.");
    }
    return value.getDoubleValue();
  }

  /**
   * @return the key contained in value
   * @throws IllegalArgumentException if the value does not contain a key.
   */
  public static Key getKey(ValueOrBuilder value) {
    if (!value.hasKeyValue()) {
      throw new IllegalArgumentException("Value does not contain a key.");
    }
    return value.getKeyValue();
  }

  /**
   * @return the blob contained in value
   * @throws IllegalArgumentException if the value does not contain a blob.
   */
  public static ByteString getByteString(ValueOrBuilder value) {
    if (value.getMeaning() == 18 && value.hasStringValue()) {
      return value.getStringValueBytes();
    } else if (value.hasBlobValue()) {
      return value.getBlobValue();
    }
    throw new IllegalArgumentException("Value does not contain a bob.");
  }

  /**
   * @return the blob key contained in value
   * @throws IllegalArgumentException if the value does not contain a blob key.
   */
  public static String getBlobKey(ValueOrBuilder value) {
    if (value.getMeaning() == 18 && value.hasStringValue()) {
      return value.getStringValue();
    } else if (value.hasBlobKeyValue()) {
      return value.getBlobKeyValue();
    }
    throw new IllegalArgumentException("Value does not contain a bob key.");
  }

  /**
   * @return the entity contained in value
   * @throws IllegalArgumentException if the value does not contain an entity.
   */
  public static Entity getEntity(ValueOrBuilder value) {
    if (!value.hasEntityValue()) {
      throw new IllegalArgumentException("Value does not contain an Entity.");
    }
    return value.getEntityValue();
  }

  /**
   * @return the string contained in value
   * @throws IllegalArgumentException if the value does not contain a string.
   */
  public static String getString(ValueOrBuilder value) {
    if (!value.hasStringValue()) {
      throw new IllegalArgumentException("Value does not contain a string.");
    }
    return value.getStringValue();
  }

  /**
   * @return the boolean contained in value
   * @throws IllegalArgumentException if the value does not contain a boolean.
   */
  public static boolean getBoolean(ValueOrBuilder value) {
    if (!value.hasBooleanValue()) {
      throw new IllegalArgumentException("Value does not contain a boolean.");
    }
    return value.getBooleanValue();
  }

  /**
   * @return the long contained in value
   * @throws IllegalArgumentException if the value does not contain a long.
   */
  public static long getLong(ValueOrBuilder value) {
    if (!value.hasIntegerValue()) {
      throw new IllegalArgumentException("Value does not contain an integer.");
    }
    return value.getIntegerValue();
  }

  /**
   * @return the timestamp in microseconds contained in value
   * @throws IllegalArgumentException if the value does not contain a timestamp.
   */
  public static long getTimestamp(ValueOrBuilder value) {
    if (value.getMeaning() == 18 && value.hasIntegerValue()) {
      return value.getIntegerValue();
    } else if (value.hasTimestampMicrosecondsValue()) {
      return value.getTimestampMicrosecondsValue();
    }
    throw new IllegalArgumentException("Value does not contain a timestamp.");
  }

  /**
   * @return the list contained in value
   * @throws IllegalArgumentException if the value does not contain a list.
   */
  public static List<Value> getList(ValueOrBuilder value) {
    if (value.getListValueCount() == 0) {
      throw new IllegalArgumentException("Value does not contain a list.");
    }
    return value.getListValueList();
  }

  /**
   * Convert a timestamp value into a {@link Date} clipping off the microseconds.
   *
   * @param value a timestamp value to convert
   * @return the resulting {@link Date}
   * @throws IllegalArgumentException if the value does not contain a timestamp.
   */
  public static Date toDate(ValueOrBuilder value) {
    return new Date(getTimestamp(value) / 1000);
  }
}
