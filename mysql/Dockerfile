FROM mysql:5.7.11
MAINTAINER Loïc Prieto <loic.sephiroth@gmail.com>

# A simple one-instance database that will lose all data upon instance termination
# The data is loaded through an SQL file that creates the database, the user for that database
# a dummy password and populates some data.
COPY test_seed.sql /docker-entrypoint-initdb.d
