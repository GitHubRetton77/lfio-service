# lfio-service
Lightfeature IO Kanban Code Challenge

Github Code URL: https://github.com/GitHubRetton77/lfio-service

## Installation Dependencies

##### Java (programming language)

> Installation guide homepage: https://www.oracle.com/java/technologies/javase-downloads.html  
> Required version: 1.8 and up

##### Maven (project management)

> Installation guide: https://maven.apache.org/install.html 
> version: I dont' think Maven's version matter but the version in my computer is 3.6.3

## Run Instructions (when all dependencies are installed)
1. From a fresh clone from Github, on a terminal, navigate to the root of the project and get code dependencies and build the project using Maven by running  `mvn -U clean package`
2. `mvn -U clean package` will generate the machine code in form for classes inside a directory named `target` on the root of the project
3. One of the machine code file inside `target` is `kanban-service-1.0.0.jar`. Again on a terminal, run the kanban service with `java -jar JAR_LOCATION` replacing `JAR_LOCATION` with the location where `kanban-service-1.0.0.jar` is created in your computer like ` 
java -jar /Users/retton/code/kanban-service-1.0.0.jar`
4. All is well if you find the 2 messages at the bottom of the start up logs:
    ```text
    Tomcat started on port(s): 23456 (http) with context path ''
    Started LFIOKanbanService in 3.826 seconds (JVM running for 4.183)
    ```
5. The service is now running on http://localhost:23456 as required on the code challenge. Just follow the functionality requirements from here to operate.



## Notes
- Installations of dependent stuff maybe tricky due to versions and compatibility. I'm not using most up to date versions of things because I did not need to update. States of our computers could affect at times. Please let me know if these instructions are not working smoothly.
- I've tried deleting my local copy of the project and started from scatch by following the steps I've written here and worked for me.
- I believe I implemented all of the required specifications. Wanted to do the optional auto generation of data but did not have time.
- This is also working together with the 2nd component of the server spec on data state storage and load which I have in a separate project here: https://github.com/GitHubRetton77/lfio-data-util

