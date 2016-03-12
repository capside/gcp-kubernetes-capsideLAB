FROM nginx
MAINTAINER Loïc Prieto <loic.sephiroth@gmail.com>

# Serves the frontend webpage. The webpage is a monopage application, that only performs requests
# against the backend instances. Thus, the instances serving frontend requests can be very low tier. 
COPY src /usr/share/nginx/html
