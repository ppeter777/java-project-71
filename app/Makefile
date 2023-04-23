run-dist: # run application
	./build/install/app/bin/app

.PHONY: build
build: # build project
	./gradlew build
	
run:
	./gradlew run

test:
	./gradlew test

report:
	./gradlew jacocoTestReport

lint:
	./gradlew checkstyleMain checkstyleTest
