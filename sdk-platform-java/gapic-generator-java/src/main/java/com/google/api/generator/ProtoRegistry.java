// Copyright 2021 Google LLC
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

package com.google.api.generator;

import com.google.api.AnnotationsProto;
import com.google.api.ClientProto;
import com.google.api.FieldBehaviorProto;
import com.google.api.FieldInfoProto;
import com.google.api.ResourceProto;
import com.google.api.RoutingProto;
import com.google.cloud.ExtendedOperationsProto;
import com.google.longrunning.OperationsProto;
import com.google.protobuf.ExtensionRegistry;

public class ProtoRegistry {
  /** Register all extensions needed to process API protofiles. */
  public static void registerAllExtensions(ExtensionRegistry extensionRegistry) {
    OperationsProto.registerAllExtensions(extensionRegistry);
    AnnotationsProto.registerAllExtensions(extensionRegistry);
    ClientProto.registerAllExtensions(extensionRegistry);
    ResourceProto.registerAllExtensions(extensionRegistry);
    FieldBehaviorProto.registerAllExtensions(extensionRegistry);
    FieldInfoProto.registerAllExtensions(extensionRegistry);
    ExtendedOperationsProto.registerAllExtensions(extensionRegistry);
    RoutingProto.registerAllExtensions(extensionRegistry);
  }
}
