variable "inputs" {
  type = object({
    project_id                     = string
    should_enable_apis_on_apply    = bool
    should_disable_apis_on_destroy = bool
  })
}