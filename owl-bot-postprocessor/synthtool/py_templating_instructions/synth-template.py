# Copyright 2020 Google LLC
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

# Append the generation lines (21-26) to your existing synth.py file, or
# duplicate this file and add it to your repo.

import synthtool as s
from synthtool import gcp

# The following code generates sample documentation according to the
# kwargs provided in the accompanying .repo-metadata.json file
common = gcp.CommonTemplates()
sample_files = common.py_samples()
for path in sample_files:
    s.move(path, excludes=["noxfile.py"])
