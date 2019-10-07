## Movie-Theater-Seating-Reservation

### Overview:

- Implemented an algorithm for assigning seats within a movie theater to fulfill reservation requests

- Made some assumptions to maximize both customer satisfaction and theater utilization

  Assumptions

### Assumptions:

- The best seats are around 2/3 of the distance from the screen to the back of theater
- Customers will make reservation order in sequence
- Everyone wants to get the best view while purchasing tickets ,and sit together with their  friends/family

### The allocation algorithm:

- Start from the 2/3 row of the theater room, spread from this row to upper row and down row.
- There are two pointer, up and down. Up point start from 2/3 row to the last row of the room. Down point start form 2/3 to the first row of the room.
- Every request will be allocated to the row which is the nearest to the 2/3 row
- The system will allocate seats as near as possible for the request, which have to allocate customs in different row

##### Time Complexity: O(N) N is the number of seats

##### Space Complexity: O(N) N is the number of seats

### How to run in console:

java -jar MovieTheaterSeatingReservation-1.0-SNAPSHOT.jar -i input.txt -o output.txt



