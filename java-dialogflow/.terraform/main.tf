terraform {
  required_providers {
    google = {
      source = "hashicorp/google"
    }
  }
}
module "project-services" {
  source = "terraform-google-modules/project-factory/google//modules/project_services"

  project_id                  = var.inputs.project_id
  enable_apis                 = var.inputs.should_enable_apis_on_apply
  disable_services_on_destroy = var.inputs.should_disable_apis_on_destroy
  activate_apis               = ["dialogflow.googleapis.com"]
}
locals {
  agent_display_name = "google-cloud-java-tests"
}
resource "google_dialogflow_agent" "design_time_agent" {
  display_name          = local.agent_display_name
  default_language_code = "en"
  time_zone             = "America/Los_Angeles"
  match_mode            = "MATCH_MODE_HYBRID"
  depends_on            = [module.project-services]
}
