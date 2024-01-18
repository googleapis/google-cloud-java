# Using Synthtool for Python Samples

## Usage

1. Copy `synth.py` and `.repo-metadata.json` to your product or sample directory if not already present.

    ```
    cp synth-template.py PRODUCT_DIR/synth.py
    cp .repo-metadata-template.json PRODUCT_DIR/.repo-metadata.json 
    ```

1. Update `.repo-metadata.json`
    - Populate `samples` array with appropriate sample information
    - Opt into desired generation options

1. New READMEs will be generated every 24 hours

## Metadata Options

The root directory for samples can be set using `sample_project_dir`. Otherwise, this is set to `samples` if that directory exists, or `.` otherwise.

Each sample in `samples` has the attributes:
- `name`
- `description`
- `file` : The main file associated with this sample
- `runnable` (Optional) : Either True/False, depending on whether this sample is made to be run by running the above file name, or not.
- `custom_content` (Optional) : This is custom content that appears after all other information generated about the sample
- `override_path` (Optional): If you would like to have a seperate README generate for this file in a different folder within the directory that holds the samples, ex. a folder named `quickstart`, specify that relative path here.
If multiple samples have the same override path, the README in that folder will contain info for all those samples.
