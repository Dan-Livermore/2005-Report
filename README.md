# COMP 2005 Service Testing

FIX GETS DATA TWICE FROM API
DO UNIT TESTS FOR EACH TRY sCATCH

Unit Tests:
- Database connection passes (200)   OK
- Database connection fails  (204) No Content
- Database connection fails  (>299)
- Temporary Redirect         (307) Incomplete url

- Bad request                (400) Size too large
- Unauthorized               (401)
- Not Found                  (404) If not made yet
- Method Not Allowed         (405) Create a get request as a post

Task 1: List of patients seen by a specific staff
+ gets staff id out of range
+ IF id's dont link to the same id 
+ wrong id's in get by id
+ displays not enough patients
+ displays only one patient
+ displays zero patients


Task 2: List of patients discharged within 3 days
- loops over too many patients
- loops over not enough patients
- calculates 3 days incorrectly
- uses wrong part of the date
- splits date incorrectly
- tries to use time instead of date part

Task 3: Which day of the week has the most admissions
+ gets wrong section (employees instead perhaps)
+ gets correct section

+ increments wrong day of the week
+ increments the correct versions


Task 4: Average duration by staff
- Gets correct staff by ID
- Gets incorrect staff by ID

- Gets all allocations
- Gets some allocations

- Averages all data correctly
- Does not use all data

- Incorrect use of algorithm