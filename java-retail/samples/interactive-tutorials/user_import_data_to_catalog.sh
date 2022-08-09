#!/bin/bash

# Copyright 2022 Google Inc. All Rights Reserved.
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#      http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.

{
	# set the key as GOOGLE_APPLICATION_CREDENTIALS
	export GOOGLE_APPLICATION_CREDENTIALS=~/key.json

	# Change the working directory
	cd ~/cloudshell_open/java-retail/samples/interactive-tutorials/ || exit

	# Run the sample for creating the GCS bucket and extract the output of that execution
	output=$(mvn compile exec:java -Dexec.mainClass="product.setup.ProductsCreateGcsBucket")

	# Get the bucket name and store it in the env variable BUCKET_NAME
	temp="${output#*gcs bucket }"
	bucket_name="${temp% was created*}"
	export BUCKET_NAME=$bucket_name

	# Import products to the Retail catalog
	mvn compile exec:java -Dexec.mainClass="product.ImportProductsGcs"

} && {

   # Print success message
   echo "====================================="
   echo "Your Retail catalog is ready to use!"
   echo "====================================="

 } || {

   # Print error message
   echo "====================================="
   echo "Your Retail catalog wasn't created! Please fix the errors above!"
   echo "====================================="
   
 }
