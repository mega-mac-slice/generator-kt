APP_NAME := <%= name %>
APP_PORT := <%= port %>

# Development
clean:
	./gradlew clean

test:
	./gradlew test -i

start:
	./gradlew run --args 'server config/dev.yaml'

stop:
	lsof -t -i:$(APP_PORT) | xargs kill -9
