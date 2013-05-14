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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/**
 * Helper methods for {@link Datastore}.
 *
 */
public class DatastoreHelper {
  private static final Logger logger = Logger.getLogger(DatastoreHelper.class.getName());

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
        .setServiceAccountScopes(DatastoreOptions.SCOPE)
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
  public static Filter.Builder makeFilter(Filter ...subfilters) {
    return makeCompositeFilter(Arrays.asList(subfilters));
  }

  /**
   * Make a composite filter from the given sub-filters.
   *
   * Uses AND to combine filters.
   */
  public static Filter.Builder makeCompositeFilter(Iterable<Filter> subfilters) {
    return Filter.newBuilder()
        .setCompositeFilter(CompositeFilter.newBuilder()
            .addAllFilter(subfilters)
            .setOperator(CompositeFilter.Operator.AND));
  }

  /**
   * Make an entity property with the specified value.
   */
  public static Property.Builder makeProperty(String name, Value value) {
    return Property.newBuilder().setName(name).addValue(value);
  }

  /**
   * Make an entity property with the specified value.
   */
  public static Property.Builder makeProperty(String name, Value.Builder value) {
    return makeProperty(name, value.build());
  }

  /**
   * Make an entity property with the specified values.
   */
  public static Property.Builder makeProperty(String name, Iterable<Value> values) {
    return Property.newBuilder().setName(name).setMulti(true).addAllValue(values);
  }

  /**
   * Make an entity property with the specified values.
   */
  public static Property.Builder makeProperty(String name, Value ...values) {
    return makeProperty(name, Arrays.asList(values));
  }

  /**
   * Make an entity property with the specified values.
   */
  public static Property.Builder makeProperty(String name, Value.Builder ...builders) {
    Property.Builder prop = makeProperty(name, Collections.<Value>emptyList());
    for (Value.Builder builder : builders) {
      prop.addValue(builder);
    }
    return prop;
  }

  /**
   * Make a property reference for use in a query.
   */
  public static PropertyReference.Builder makePropertyReference(String propertyName) {
    return PropertyReference.newBuilder().setName(propertyName);
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
   * Return a map of property name to java object.
   *
   * Looses microseconds on timestamp values, meaning and indexing information.
   *
   * @param entity the entity to search for the property.
   * @return The property value, or null if it's not found.
   */
  public static Map<String, Object> getPropertyMap(EntityOrBuilder entity) {
    Map<String, Object> result = new HashMap<String, Object>();
    for (PropertyOrBuilder property : entity.getPropertyList()) {
      Object value;
      if (property.getMulti()) {
        List<Object> values = new ArrayList<Object>(property.getValueCount());
        for (ValueOrBuilder subValue : property.getValueList()) {
          values.add(getValue(subValue));
        }
        value = values;
      } else {
        value = getValue(property.getValue(0));
      }
      result.put(property.getName(), value);
    }
    return Collections.unmodifiableMap(result);
  }

  /**
   * Convert a Value to a Java Object. Ignores meaning.
   *
   * Looses microseconds on timestamp values, meaning and indexing information.
   */
  public static Object getValue(ValueOrBuilder value) {
    if (value.hasBooleanValue()) {
      return value.getBooleanValue();
    }
    if (value.hasIntegerValue()) {
      return value.getIntegerValue();
    }
    if (value.hasDoubleValue()) {
      return value.getDoubleValue();
    }
    if (value.hasTimestampMicrosecondsValue()) {
      return new Date(value.getTimestampMicrosecondsValue() / 1000L);
    }
    if (value.hasKeyValue()) {
      return value.getKeyValue();
    }
    if (value.hasBlobKeyValue()) {
      return value;  // Returning value directly to avoid loosing type info.
    }
    if (value.hasStringValue()) {
      return value.getStringValue();
    }
    if (value.hasBlobValue()) {
      return value.getBlobValue();
    }
    if (value.hasEntityValue()) {
      return value.getEntityValue();
    }
    return null;
  }
}
