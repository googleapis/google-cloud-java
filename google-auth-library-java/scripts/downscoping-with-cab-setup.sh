#!/bin/bash

# Copyright 2021 Google LLC
#
# Redistribution and use in source and binary forms, with or without
# modification, are permitted provided that the following conditions are
# met:
#
#    * Redistributions of source code must retain the above copyright
# notice, this list of conditions and the following disclaimer.
#    * Redistributions in binary form must reproduce the above
# copyright notice, this list of conditions and the following disclaimer
# in the documentation and/or other materials provided with the
# distribution.
#    * Neither the name of Google LLC nor the names of its
# contributors may be used to endorse or promote products derived from
# this software without specific prior written permission.
#
# THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
# "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
# LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
# A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
# OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
# SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
# LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
# DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
# THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
# (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
# OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.

# This script is used to generate the project configurations needed to
# end-to-end test Downscoping with Credential Access Boundaries in the Auth
# library.
#
# In order to run this script, you need to fill in the project_id and
# service_account_email variables.
#
# This script needs to be run once. It will do the following:
# 1. Sets the current project to the one specified.
# 2. Creates a GCS bucket in the specified project.
# 3. Gives the specified service account the objectAdmin role for this bucket.
# 4. Creates two text files to be uploaded to the created bucket.
# 5. Uploads both text files.
# 6. Prints out the identifiers (bucket ID, first object ID, second object ID)
#    to be used in the accompanying tests.
# 7. Deletes the created text files in the current directory.
#
# The same service account used for this setup script should be used for
# the integration tests.
#
# It is safe to run the setup script again. A new bucket is created along with
# new objects. If run multiple times, it is advisable to delete
# unused buckets.

suffix=""

function generate_random_string () {
  local valid_chars=abcdefghijklmnopqrstuvwxyz0123456789
  for i in {1..8} ; do
    suffix+="${valid_chars:RANDOM%${#valid_chars}:1}"
    done
}

generate_random_string

bucket_id="cab-int-bucket-"${suffix}
first_object="cab-first-"${suffix}.txt
second_object="cab-second-"${suffix}.txt

# Fill in.
project_id=""
service_account_email=""

gcloud config set project ${project_id}

# Create the GCS bucket.
gsutil mb -b on -l us-east1 gs://${bucket_id}

# Give the specified service account the objectAdmin role for this bucket.
gsutil iam ch serviceAccount:${service_account_email}:objectAdmin gs://${bucket_id}

# Create both objects.
echo "first" >> ${first_object}
echo "second" >> ${second_object}

# Upload the created objects to the bucket.
gsutil cp ${first_object} gs://${bucket_id}
gsutil cp ${second_object} gs://${bucket_id}

echo "Bucket ID: "${bucket_id}
echo "First object ID: "${first_object}
echo "Second object ID: "${second_object}

# Cleanup.
rm ${first_object}
rm ${second_object}
