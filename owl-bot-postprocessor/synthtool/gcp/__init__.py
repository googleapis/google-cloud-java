# Copyright 2018 Google LLC
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#     https://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.

from . import gapic_generator
from . import gapic_microgenerator
from . import gapic_bazel
from . import discogapic_generator
from . import common

DiscoGAPICGenerator = discogapic_generator.DiscoGAPICGenerator
GAPICGenerator = gapic_generator.GAPICGenerator
GAPICMicrogenerator = gapic_microgenerator.GAPICMicrogenerator
GAPICBazel = gapic_bazel.GAPICBazel
CommonTemplates = common.CommonTemplates


__all__ = (
    "CommonTemplates",
    "DiscoGAPICGenerator",
    "GAPICGenerator",
    "GAPICMicrogenerator",
    "GAPICBazel",
)
