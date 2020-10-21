all: help

help: ## Show this help
	@fgrep -h "##" $(MAKEFILE_LIST) | fgrep -v fgrep | sed -e 's/\\$$//' | sed -e 's/##//'
	
build-proj: ## Build project
	mvn clean install

build-proj-wo-rat: ## Build project without Rat (license verifier)
	mvn clean install -Drat.skip=true