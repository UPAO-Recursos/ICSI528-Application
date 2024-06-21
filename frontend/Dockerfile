# Stage 1: Build Stage
# Use Node.js image as the base for building Angular application
FROM node:22.3.0 AS build

# Set the working directory
WORKDIR /app

# Copy the entire project files to work directory
COPY . .

# Install dependencies
RUN npm install

# Build the Angular app with production configuration
ARG CONFIGURATION=development
RUN npm run build -- --configuration $CONFIGURATION

# Stage 2: Production Stage
# Use nginx image as the base for serving Angular application
FROM nginx:alpine AS production

# Copy built artifacts from the build stage to nginx public directory
COPY --from=build /app/dist/angular-tdd/browser /usr/share/nginx/html

# Copy custom nginx configuration if needed (optional)
COPY ./nginx.conf /etc/nginx/conf.d/default.conf

# Expose port 80 to the outside world
EXPOSE 80

# Command to start nginx when the container starts
CMD ["nginx", "-g", "daemon off;"]
