package utils;
//Data generation has 2 types (Dynamic - Static (Hardcoded))


/*
1. static (best of the best)
    1.1 Database snapshot (restore)

//no collaboration or no connection between the test team and db team
2. dynamic
    2.1 Database queries (setup) // INSERT INTO user VALUES ("user1", "user2", "user3") // (fast execution)
    2.2 API endpoints (setup) //POST /users {"email" : "toBeModified@gmail.com"} // network request (slow execution)
    2.3 UI (setup) -> create user through the UI (slow execution) -> u go throw all the steps from the beginning to create a user //CRUD Operations
*/
// excel (not recommended) -> complex / no version control - csv (not recommended) -> complex / no version control - json - properties -> sys.get("email") -> take a key and return a value
public class JsonReader {


}
