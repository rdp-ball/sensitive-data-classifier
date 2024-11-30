# Build the Docker image
docker build -t aurva-app .

# Run the Docker container
docker run -d -p 8090:8090 aurva-app
