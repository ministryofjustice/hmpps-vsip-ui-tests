# Specify the base image
FROM maven:3.8.4-openjdk-11

# Set the working directory inside the container
WORKDIR /app

# Copy the necessary files to the container
COPY . /app

# Install required dependencies
RUN apt-get update && apt-get install -y wget curl unzip chromium libc6-dev

# Set the ChromeDriver version
ENV CHROME_DRIVER_VERSION=112.0.5615.49

# Download and install ChromeDriver
RUN wget -q -O /tmp/chromedriver.zip https://chromedriver.storage.googleapis.com/$CHROME_DRIVER_VERSION/chromedriver_linux64.zip \
    && unzip /tmp/chromedriver.zip -d /usr/local/bin \
    && rm /tmp/chromedriver.zip \
    && chmod +x /usr/local/bin/chromedriver

# Build the Maven project
RUN mvn clean package -DskipTests

# Specify the entry point command for running the tests
CMD mvn test