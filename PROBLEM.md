**Welcome to our selection process**

**Scenario**

Magalu has the challenge of developing a communication platform. You have been chosen to initiate the development of the first sprint.

**Requirements**

- **Must have an endpoint that receives a communication scheduling request (1):**
    - This endpoint must have at least the following fields:
        - Date/Time for sending
        - Recipient
        - Message to be delivered
    - The possible communications that can be sent are: email, SMS, push, and WhatsApp.
    - At this moment, we need this entry channel to schedule the sending, i.e., this endpoint (1). The sending itself will not be developed at this stage: you do not need to worry about it.
    - For this sprint, it was decided that the scheduling request for communication sending will be saved in the database. Therefore, as soon as the scheduling request is received (1), it should be saved in the database.
    - Think carefully about this database structure. Although you will not be the one to send the communication, the structure must be ready so that your colleague does not need to change anything when developing this functionality. The concern at the time of sending will be to send and change the status of the record in the database.

- **Must have an endpoint to check the status of the communication sending schedule (2):**
    - The scheduling will be done at endpoint (1) and the consultation will be done by this other endpoint.

- **Must have an endpoint to remove a communication sending schedule.**

**General Remarks and Guidelines**

- We prefer development in Java, Python, or Node, but any language can be used; just explain why you chose it.
- Use one of the following databases:
    - MySQL
    - PostgreSQL
- The APIs should follow the RESTful model with JSON format.
- Perform unit tests, focusing on a well-organized test suite.
- Follow what you consider best programming practices.
- The creation of the database and tables is up to you, whether via script, application, etc.

Your challenge should preferably be sent as a public GIT repository (Github, Gitlab, Bitbucket), with small and well-described commits, or as a compressed file (ZIP or TAR). Your repository should have an open-source license model. Do not send any files other than the compressed code itself and its documentation. Be careful not to send images, videos, audio, binaries, etc.

Follow good development, quality, and code governance practices. Guide the evaluators on how to install, test, and run your code: it can be a README within the project.

We will evaluate your challenge according to the position and level you are applying for.

We appreciate your willingness to participate in our selection process and wish you have fun and good luck :)