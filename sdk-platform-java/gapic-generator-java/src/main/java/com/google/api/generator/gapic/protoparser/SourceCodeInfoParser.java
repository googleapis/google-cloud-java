// Copyright 2020 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//      http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.google.api.generator.gapic.protoparser;

import com.google.api.generator.gapic.model.SourceCodeInfoLocation;
import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableListMultimap;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimaps;
import com.google.protobuf.DescriptorProtos.DescriptorProto;
import com.google.protobuf.DescriptorProtos.EnumDescriptorProto;
import com.google.protobuf.DescriptorProtos.FileDescriptorProto;
import com.google.protobuf.DescriptorProtos.ServiceDescriptorProto;
import com.google.protobuf.DescriptorProtos.SourceCodeInfo.Location;
import com.google.protobuf.Descriptors.Descriptor;
import com.google.protobuf.Descriptors.EnumDescriptor;
import com.google.protobuf.Descriptors.EnumValueDescriptor;
import com.google.protobuf.Descriptors.FieldDescriptor;
import com.google.protobuf.Descriptors.FileDescriptor;
import com.google.protobuf.Descriptors.MethodDescriptor;
import com.google.protobuf.Descriptors.OneofDescriptor;
import com.google.protobuf.Descriptors.ServiceDescriptor;
import java.util.Map;
import javax.annotation.Nullable;

/**
 * A helper class which provides protocol buffer source info for descriptors.
 *
 * <p>In order to make this work, the descriptors need to be produced using the flag {@code
 * --include_source_info}. Note that descriptors taken from the generated java code have source info
 * stripped, and won't work with this class.
 *
 * <p>This class uses internal caches to speed up access to the source info. It is not thread safe.
 * If you think you need this functionality in a thread-safe context, feel free to suggest a
 * refactor.
 */
public class SourceCodeInfoParser {
  /**
   * A map from file descriptors to the analyzed source info, stored as a multimap from a path of
   * the form {@code n.m.l} to the location info.
   */
  private final Map<FileDescriptor, ImmutableListMultimap<String, Location>> fileToPathToLocation =
      Maps.newHashMap();

  /** A map from descriptor objects to the path to those objects in their proto file. */
  private final Map<Object, String> descriptorToPath = Maps.newHashMap();

  /** Gets the location of a message, if available. */
  @Nullable
  public SourceCodeInfoLocation getLocation(Descriptor message) {
    FileDescriptor file = message.getFile();
    if (!file.toProto().hasSourceCodeInfo()) {
      return null;
    }
    return SourceCodeInfoLocation.create(getLocation(file, buildPath(message)));
  }

  /** Gets the location of a field, if available. */
  @Nullable
  public SourceCodeInfoLocation getLocation(FieldDescriptor field) {
    FileDescriptor file = field.getFile();
    if (!file.toProto().hasSourceCodeInfo()) {
      return null;
    }
    Location fieldLocation = getLocation(file, buildPath(field));
    return SourceCodeInfoLocation.create(fieldLocation);
  }

  /** Gets the location of a service, if available. */
  @Nullable
  public SourceCodeInfoLocation getLocation(ServiceDescriptor service) {
    FileDescriptor file = service.getFile();
    if (!file.toProto().hasSourceCodeInfo()) {
      return null;
    }
    return SourceCodeInfoLocation.create(getLocation(file, buildPath(service)));
  }

  /** Gets the location of a method, if available. */
  @Nullable
  public SourceCodeInfoLocation getLocation(MethodDescriptor method) {
    FileDescriptor file = method.getFile();
    if (!file.toProto().hasSourceCodeInfo()) {
      return null;
    }
    return SourceCodeInfoLocation.create(getLocation(file, buildPath(method)));
  }

  /** Gets the location of an enum type, if available. */
  @Nullable
  public SourceCodeInfoLocation getLocation(EnumDescriptor enumType) {
    FileDescriptor file = enumType.getFile();
    if (!file.toProto().hasSourceCodeInfo()) {
      return null;
    }
    return SourceCodeInfoLocation.create(getLocation(file, buildPath(enumType)));
  }

  /** Gets the location of an enum value, if available. */
  @Nullable
  public SourceCodeInfoLocation getLocation(EnumValueDescriptor enumValue) {
    FileDescriptor file = enumValue.getFile();
    if (!file.toProto().hasSourceCodeInfo()) {
      return null;
    }
    return SourceCodeInfoLocation.create(getLocation(file, buildPath(enumValue)));
  }

  /** Gets the location of a oneof, if available. */
  @Nullable
  public SourceCodeInfoLocation getLocation(OneofDescriptor oneof) {
    FileDescriptor file = oneof.getFile();
    if (!file.toProto().hasSourceCodeInfo()) {
      return null;
    }
    return SourceCodeInfoLocation.create(getLocation(file, buildPath(oneof)));
  }

  // -----------------------------------------------------------------------------
  // Helpers

  /**
   * A helper to compute the location based on a file descriptor and a path into that descriptor.
   */
  private Location getLocation(FileDescriptor file, String path) {
    ImmutableList<Location> cands = getCandidateLocations(file, path);
    if (cands != null && cands.isEmpty()) {
      return null;
    } else {
      return cands.get(0); // We choose the first one.
    }
  }

  private ImmutableList<Location> getCandidateLocations(FileDescriptor file, String path) {
    ImmutableListMultimap<String, Location> locationMap = fileToPathToLocation.get(file);
    if (locationMap == null) {
      locationMap =
          Multimaps.index(
              file.toProto().getSourceCodeInfo().getLocationList(),
              new Function<Location, String>() {
                @Override
                public String apply(Location location) {
                  return Joiner.on('.').join(location.getPathList());
                }
              });
      fileToPathToLocation.put(file, locationMap);
    }
    return locationMap.get(path);
  }

  private String buildPath(Descriptor message) {
    String path = descriptorToPath.get(message);
    if (path != null) {
      return path;
    }
    if (message.getContainingType() != null) {
      path =
          String.format(
              "%s.%d.%d",
              buildPath(message.getContainingType()),
              DescriptorProto.NESTED_TYPE_FIELD_NUMBER,
              message.getContainingType().getNestedTypes().indexOf(message));
    } else {
      path =
          String.format(
              "%d.%d",
              FileDescriptorProto.MESSAGE_TYPE_FIELD_NUMBER,
              message.getFile().getMessageTypes().indexOf(message));
    }
    descriptorToPath.put(message, path);
    return path;
  }

  private String buildPath(FieldDescriptor field) {
    String path = descriptorToPath.get(field);
    if (path != null) {
      return path;
    }
    if (field.isExtension()) {
      if (field.getExtensionScope() == null) {
        path =
            String.format(
                "%d.%d",
                FileDescriptorProto.EXTENSION_FIELD_NUMBER,
                field.getFile().getExtensions().indexOf(field));
      } else {
        path =
            String.format(
                "%s.%d.%d",
                buildPath(field.getExtensionScope()),
                DescriptorProto.EXTENSION_FIELD_NUMBER,
                field.getExtensionScope().getExtensions().indexOf(field));
      }
    } else {
      path =
          String.format(
              "%s.%d.%d",
              buildPath(field.getContainingType()),
              DescriptorProto.FIELD_FIELD_NUMBER,
              field.getContainingType().getFields().indexOf(field));
    }
    descriptorToPath.put(field, path);
    return path;
  }

  private String buildPath(ServiceDescriptor service) {
    String path = descriptorToPath.get(service);
    if (path != null) {
      return path;
    }
    path =
        String.format(
            "%d.%d",
            FileDescriptorProto.SERVICE_FIELD_NUMBER,
            service.getFile().getServices().indexOf(service));
    descriptorToPath.put(service, path);
    return path;
  }

  private String buildPath(MethodDescriptor method) {
    String path = descriptorToPath.get(method);
    if (path != null) {
      return path;
    }
    path =
        String.format(
            "%s.%d.%d",
            buildPath(method.getService()),
            ServiceDescriptorProto.METHOD_FIELD_NUMBER,
            method.getService().getMethods().indexOf(method));
    descriptorToPath.put(method, path);
    return path;
  }

  private String buildPath(EnumDescriptor enumType) {
    String path = descriptorToPath.get(enumType);
    if (path != null) {
      return path;
    }
    if (enumType.getContainingType() != null) {
      path =
          String.format(
              "%s.%d.%d",
              buildPath(enumType.getContainingType()),
              DescriptorProto.ENUM_TYPE_FIELD_NUMBER,
              enumType.getContainingType().getEnumTypes().indexOf(enumType));
    } else {
      path =
          String.format(
              "%d.%d",
              FileDescriptorProto.ENUM_TYPE_FIELD_NUMBER,
              enumType.getFile().getEnumTypes().indexOf(enumType));
    }
    descriptorToPath.put(enumType, path);
    return path;
  }

  private String buildPath(EnumValueDescriptor enumValue) {
    String path = descriptorToPath.get(enumValue);
    if (path != null) {
      return path;
    }
    path =
        String.format(
            "%s.%d.%d",
            buildPath(enumValue.getType()),
            EnumDescriptorProto.VALUE_FIELD_NUMBER,
            enumValue.getType().getValues().indexOf(enumValue));
    descriptorToPath.put(enumValue, path);
    return path;
  }

  private String buildPath(OneofDescriptor oneof) {
    String path = descriptorToPath.get(oneof);
    if (path != null) {
      return path;
    }
    path =
        String.format(
            "%s.%d.%d",
            buildPath(oneof.getContainingType()),
            DescriptorProto.ONEOF_DECL_FIELD_NUMBER,
            oneof.getContainingType().getOneofs().indexOf(oneof));

    descriptorToPath.put(oneof, path);
    return path;
  }
}
