variable "inputs" {
  type = object({
    project_id                     = string
    should_enable_apis_on_apply    = bool
    should_disable_apis_on_destroy = bool

    # GCP zone and region in which to deploy the SQL database.
    # Zone must be in the chosen region.
    zone   = string
    region = string
  })
}