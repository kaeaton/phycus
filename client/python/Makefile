build:clean generate
	cd api && \
		python setup.py install

install:
	cd api && \
		python setup.py install

generate: ## remove build artifacts
	
	java -jar swagger-codegen-cli.jar generate -i ../../curation-swagger-spec.yaml -l python -DpackageName=pyhfcus -o api
	cp setup.py api
	mkdir api/bin
	cp hfcus-* api/bin
	chmod a+x api/bin/*

clean:
	rm -rf api


