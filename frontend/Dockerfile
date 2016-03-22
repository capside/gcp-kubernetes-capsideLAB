FROM nginx
MAINTAINER Loïc Prieto <loic.sephiroth@gmail.com>

# Basic network debugging
RUN apt-get update && \
    apt-get install -y dnsutils && \
	apt-get install -y curl

# Serves the frontend webpage. The webpage is a monopage application, that only performs requests
# against the backend instances. Thus, the instances serving frontend requests can be very low tier. 
# The nginx front resolves against the backend api to itself, so that the resolving of the backend host
# is left to nginx and kubernetes (through dns) instead of the application.
COPY src /usr/share/nginx/html
COPY front_vhost.conf /etc/nginx/conf.d/default.conf
